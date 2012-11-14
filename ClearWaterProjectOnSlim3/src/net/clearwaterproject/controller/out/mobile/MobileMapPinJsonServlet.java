package net.clearwaterproject.controller.out.mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.users.UserService;
import net.clearwaterproject.app.users.UserServiceFactory;
import net.clearwaterproject.meta.WaterInfoGeoHexMeta;
import net.clearwaterproject.meta.WaterInfoMeta;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterInfoGeoHex;
import net.clearwaterproject.sys.com.UtilMap;

/*
 * マップに表示する関連情報（水質情報、事業者情報）をJSONで出力するサーブレットクラス
 */
public class MobileMapPinJsonServlet  extends HttpServlet{

    private static final long serialVersionUID = -5135798264725723211L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        res.setContentType("application/json; charset=UTF-8");

        //抽出用パラメーターの取得　GETで南西と北東位置取得
        String stSwLat = (String)req.getParameter("swlat");
        String stSwLng = (String)req.getParameter("swlng");
        String stNeLat = (String)req.getParameter("nelat");
        String stNeLng = (String)req.getParameter("nelng");
        double swLat = 0;
        double swLng = 0;
        double neLat = 0;
        double neLng = 0;

        if (stSwLat != null){swLat = Double.parseDouble(stSwLat);} ;
        if (stSwLng != null){swLng = Double.parseDouble(stSwLng);} ;
        if (stNeLat != null){neLat = Double.parseDouble(stNeLat);} ;
        if (stNeLng != null){neLng = Double.parseDouble(stNeLng);} ;

        WaterInfoGeoHexMeta wi = WaterInfoGeoHexMeta.get();
        List<WaterInfoGeoHex> wiGHList = Datastore.query(wi)
                .filter(wi.lat.greaterThanOrEqual(swLat), wi.lat.lessThanOrEqual(neLat))
                .filterInMemory(wi.lng.greaterThanOrEqual(swLng),wi.lng.lessThanOrEqual(neLng))
                .asList();

        //codの平均をセット。平均でいいのかどうか、Iteratorをもう一回セットすべきか等検討余地大　20121017
//        List<WaterInfoGeoHexJO> wiGHListJO = new LinkedList();
        Iterator<WaterInfoGeoHex> wIGeoHexItr = wiGHList.iterator();
        double cod_sum = 0;
        int    cnt     = 0;
        while (wIGeoHexItr.hasNext()){
            WaterInfoGeoHex wIGeoHex = (WaterInfoGeoHex)wIGeoHexItr.next();

            List<WaterInfo> wiList =  wIGeoHex.getWaterInfoListRef().getModelList();
            for (int i=0; i < wiList.size(); i++){
                if (((WaterInfo)wiList.get(i)).getCod() != 0){
                    cod_sum = ((WaterInfo)wiList.get(i)).getCod();
                    cnt++;
                }
            }
            //現状単純平均
            if (cnt==0){
                wIGeoHex.setCod(0);
            }else{
                wIGeoHex.setCod(cod_sum/cnt);
            }
            //数値初期化
            cod_sum = 0;
            cnt     = 0;
            
            //mobile用に変換して入力
//            wiGHListJO.add(new WaterInfoGeoHexJO(wIGeoHex));
        }

        /* 検索結果をJavaオブジェクトをJSONに変更してブラウザに返す  */
        HashMap map = new HashMap();
//        if (wiGHList != null){
//            map.put("waterGeoHex",wiGHListJO);
//        }else{
//            map.put("waterGeoHex",null);
//        }
        String wiGHListSt = WaterInfoGeoHexMeta.get().modelsToJson(wiGHList);
        map.put("waterGeoHex",JSON.decode(wiGHListSt));
        JSON.encode(map, res.getOutputStream());

	}

}
