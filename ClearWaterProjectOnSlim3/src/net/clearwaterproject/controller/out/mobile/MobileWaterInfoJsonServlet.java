package net.clearwaterproject.controller.out.mobile;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


import net.arnx.jsonic.JSON;
import net.clearwaterproject.meta.WaterInfoMeta;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterInfoGeoHex;

/*
 * スマホ等携帯端末用。
 * マップに表示する関連情報（GeoHex、水質情報一部等）をJSONで出力するサーブレットクラス
 */
public class MobileWaterInfoJsonServlet  extends HttpServlet{
	
	private static final long serialVersionUID = -5135798264725723211L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
		res.setContentType("application/json; charset=UTF-8");
		//抽出用パラメーターの取得GeoHexのzone情報
		String zone = (String)req.getParameter("zone");

		Key wiGHkey = KeyFactory.createKey(WaterInfoGeoHex.class.getSimpleName(), zone);
		WaterInfoMeta wi = WaterInfoMeta.get();
        List<WaterInfo> wiList = Datastore.query(wi)
                .filter(wi.waterInfoGHRef.equal(wiGHkey))
                .asList();
		
        //
//        List<WaterInfoJO> wiListJO = new LinkedList();
//        for (int i=0;i<wiList.size();i++){
//            wiListJO.add(new WaterInfoJO(wiList.get(i)));
//        }
        
        /* 検索結果をJavaオブジェクトをJSONに変更してブラウザに返す  */
        HashMap map = new HashMap();
//        if (wiListJO != null){
//            map.put("waterInfo",wiListJO);
//        }else{
//            map.put("waterInfo",null);
//        }
//        map.put("waterInfo",wiListJO);
        String wiListSt = WaterInfoMeta.get().modelsToJson(wiList,3);
        map.put("waterInfo",JSON.decode(wiListSt));
        JSON.encode(map, res.getOutputStream());
		
	}

}
