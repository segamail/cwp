package net.clearwaterproject.controller.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;


import net.arnx.jsonic.JSON;
import net.clearwaterproject.meta.UserMeta;
import net.clearwaterproject.meta.WaterInfoMeta;
import net.clearwaterproject.model.WaterInfo;

/*
 * WEBサービス用。
 * マップに表示する関連情報（GeoHex、水質情報一部等）をJSONで出力するサーブレットクラス
 */
public class MapInfoJsonServlet  extends HttpServlet{
	
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

		long t1 = System.nanoTime();
		WaterInfoMeta wi = WaterInfoMeta.get();
		List<WaterInfo> waterInfoList = Datastore.query(wi)
		        .filter(wi.lat.greaterThanOrEqual(swLat), wi.lat.lessThanOrEqual(neLat))
		        .filterInMemory(wi.lng.greaterThanOrEqual(swLng),wi.lng.lessThanOrEqual(neLng))
		        .asList();
//		long t2 = System.nanoTime();
//		List<WaterInfoJO> wiListJO = new LinkedList();
//		for (int i=0;i<waterInfoList.size();i++){
//		    wiListJO.add(new WaterInfoJO(waterInfoList.get(i)));
//		}
//		long t3 = System.nanoTime();
		
		
		/* 検索結果をJavaオブジェクトをJSONに変更してブラウザに返す  */
		HashMap map = new HashMap();
//		if (wiListJO != null){
//            map.put("waterInfo",wiListJO);
//        }else{
//            map.put("waterInfo",null);
//        }
//		map.put("waterInfo",wiListJO);
        String wiListSt = WaterInfoMeta.get().modelsToJson(waterInfoList,3);
        map.put("waterInfo",JSON.decode(wiListSt));
		JSON.encode(map, res.getOutputStream());
//		long t4 = System.nanoTime();

//		System.out.println("t2-t1:"+(t2-t1)/1000);
//		System.out.println("t3-t2:"+(t3-t2)/1000);
//		System.out.println("t4-t3:"+(t4-t3)/1000);
	}

}
