package net.clearwaterproject.controller.in;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.users.UserService;
import net.clearwaterproject.app.users.UserServiceFactory;
import net.clearwaterproject.controller.out.JsonResultStatus;
import net.clearwaterproject.geohex.GeoHex;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterInfoGeoHex;
import net.clearwaterproject.model.WaterInfoPicture;
import net.clearwaterproject.sys.com.UtilDate;
import net.clearwaterproject.sys.com.UtilMap;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

/*
 * 水質情報、GeoHex情報を受信
 * 画像データはそのまま、その他の情報はjSONデータで受信。
 * JSONデータの形式は「CWPシステムカタログ.xls」の「【HTTP接続】各サービス接続仕様」シートにて
 */
public class ReceiveWaterInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 6866721193156806664L;
	private BlobstoreService blobstoreService  = BlobstoreServiceFactory.getBlobstoreService();
	private ImagesService imagesService  = (ImagesService) ImagesServiceFactory.getImagesService();
	
	/*ロガー*/
    private static final Logger logger;
    static {
        logger = Logger.getLogger(
        		ReceiveWaterInfoServlet.class.getName());
        logger.setLevel(Level.ALL);
    }
    
    
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		ServletFileUpload upload = new ServletFileUpload();
		upload.setSizeMax(50000000); // アップロード可能な画像の最大サイズを50MBに制限
		List<BlobKey> blobKeyList = new ArrayList<BlobKey>();
		HashMap<String, HashMap> map   = new HashMap();
		/*まずはファイルを読み込む*/
		System.out.println(req.getContentType());
		try {
			//requestにあるmulti-part/form-dataのファイル群を取得
			FileItemIterator iterator = upload.getItemIterator(req);
			//利用可能なFileItemStreamが存在する限り処理を回す
			while (iterator.hasNext()) {

				//利用可能なFileItemStreamを取得
				FileItemStream item = iterator.next();
				//js の　formData.append　で作ったデータがisFormFieldで判定しない。。20121004
				if (item.isFormField()){
					/*　フォームデータである場合、JSONデータで受信しているはず
					 *　ここでUTF-8指定しないとGAE本番で文字化け発生。ストリームからの読み込み時にbyteから読み込んでいるため 
					 */
					String jsonString = Streams.asString(item.openStream(),"UTF-8");
					map =JSON.decode(jsonString, HashMap.class);
				}else{
					/* ファイルである場合、blobstoreに登録し、キーを保存 */
					//FileItemStreamをbyte化
					byte[] bytes = getBytes(item.openStream());
					
					//ファイルの中身がない場合はスキップして次のファイルを探しに行く
					if (bytes.length == -1){continue;}

					// Get a file service
					FileService fileService = FileServiceFactory.getFileService();

					// Create a new Blob file with mime-type "application/octet-stream"
					AppEngineFile file = fileService.createNewBlobFile(item.getContentType());

					// Open a channel to write to it
					boolean lock = true;
					FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);

					// This time we write to the channel using standard Java
					writeChannel.write(ByteBuffer.wrap(bytes));

					// Now finalize
					writeChannel.closeFinally();

					blobKeyList.add(fileService.getBlobKey(file));
				}


			}
		} catch ( FileUploadException e ) {
			logger.log( Level.SEVERE, "put failed", e );
			throw new IOException(e);
		}
		/*次にファイルをデータストアに登録する*/
		if (map == null || blobKeyList.isEmpty()){
			/*登録すべきデータがないため、何かしらエラーを返す？20120926*/
		}else{
//		    Transaction tx = Datastore.beginTransaction();
		    //写真情報の登録
		    List<WaterInfoPicture> waterInfoPicList = new ArrayList<WaterInfoPicture>();
		    List<String> waterInfoPicURLList = new ArrayList<String>();
		    for (int i=0;i<blobKeyList.size();i++){
		        //写真情報をWaterInfoに一緒に登録してもらうための準備
		        WaterInfoPicture waterInfoPic = new WaterInfoPicture(blobKeyList.get(i));
		        waterInfoPicList.add(waterInfoPic);
		    }

		    //位置情報を取得
		    HashMap placeMap = map.get("place");
		    //まず位置情報から水質情報GeoHexの登録。java版あったため使ってみる
		    GeoHex.Zone zone = GeoHex.getZoneByLocation(Double.parseDouble(placeMap.get("lat").toString()), 
		        Double.parseDouble(placeMap.get("lng").toString()), 
		        UtilMap.GeoHexLevel);
		    WaterInfoGeoHex waterInfoGH = new WaterInfoGeoHex(zone.code,
		        zone.level,
		        zone.lat,
		        zone.lon);

		    //水質情報の登録。位置情報も一緒に登録。日付入ってなかった場合の処理は必要20121008
		    HashMap waterInfoMap = map.get("waterInfo");
		    
		    //cwp_user_noよりキャッシュからユーザー取得。なければ送られてきたcwp_user_no利用しdatastoreから取得。
		    if ( waterInfoMap.get("cwp_user_no") == null){
		        JsonResultStatus jsrs = new JsonResultStatus("ok",0,0,"");
		        JSON.encode(jsrs, res.getOutputStream());
		        return;
		    }
	        UserService us = UserServiceFactory.getUserService();
	        User user = us.getLoginUserByCWP(req, (String) waterInfoMap.get("cwp_user_no").toString());

	        //メインデータであるWaterInfoの作成
		    WaterInfo waterInfo = new WaterInfo(UtilDate.stringToDate(waterInfoMap.get("apply_date").toString()),
		        Double.parseDouble(placeMap.get("lat").toString()), 
		        Double.parseDouble(placeMap.get("lng").toString()),
		        0,
		        waterInfoMap.get("comment").toString());
            if (waterInfoMap.get("cod") != null && waterInfoMap.get("cod").toString().equals("")){
                waterInfo.setCod(Double.parseDouble(placeMap.get("cod").toString()));
            }

		    //最後にまとめて登録
		    for (int i=0; i<waterInfoPicList.size();i++){
		        waterInfoPicList.get(i).getWaterInfoRef().setModel(waterInfo);
		    }

		    waterInfo.getWaterInfoGHRef().setModel(waterInfoGH);
		    waterInfo.getApplyUser().setModel(user);
		    
		    //以下waterInfoDtl登録関連が残。20120926
		    GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		    for (int i=0; i<waterInfoPicList.size();i++){
		        gtx.put(waterInfoPicList.get(i),waterInfo);
		    }
		    gtx.put(waterInfoGH,user,waterInfo);
		    gtx.commit();
		    //登録が完了したため戻す
		    JsonResultStatus jsrs = new JsonResultStatus("ok",0,0,"");
		    JSON.encode(jsrs, res.getOutputStream());
		}

	}
	


	/**
	 * InputStreamをバイト配列に変換する
	 * 
	 * @param is
	 * @return バイト配列
	 */
	private static byte[] getBytes(InputStream is) {
		// byte型の配列を出力先とするクラス。
		// 通常、バイト出力ストリームはファイルやソケットを出力先とするが、
		// ByteArrayOutputStreamクラスはbyte[]変数、つまりメモリを出力先とする。 
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		OutputStream os = new BufferedOutputStream(b);
		int c;
		try {
			while ((c = is.read()) != -1) {
				os.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 書き込み先はByteArrayOutputStreamクラス内部となる。
		// この書き込まれたバイトデータをbyte型配列として取り出す場合には、
		// toByteArray()メソッドを呼び出す。 
		return b.toByteArray();
	}


}
