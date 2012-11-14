package net.clearwaterproject.sys.com;

import java.util.Iterator;

import net.clearwaterproject.db.obj.com.IPlace;

public class UtilMap {
	
	public static final int GeoHexLevel = 11;
	
//	public static void removeItrOutOfLngRange(Iterator<IPlace> itr, double swLng, double neLng){
//		while (itr.hasNext()){
//			//南西経度より北東経度の方が大きい（168.13.., -172... という日付変更線またぎは外す）、かつ南西経度-北東経度内から外れたデータ
//			IPlace p = (IPlace)itr.next();
//			if (swLng <= neLng && (p.getLng() < swLng || p.getLng() > neLng)){
//				itr.remove();
//			}else{
//
//			}
//		}
//		
//	}

}
