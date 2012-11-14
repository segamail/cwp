package net.clearwaterproject.sys.com;



import net.clearwaterproject.model.User;

import org.slim3.memcache.Memcache;

public class CWPUserCashManager {

	/*
	 * param キャッシュから取得したユーザーID
	 * memcacheからユーザーIDに位置するユーザー情報があるか検索し取得。
	 */
	public static User getCWPUser(String key){
	    //キャッシュに該当内容あるか確認。
		if (Memcache.contains(key)){
		    return Memcache.get(key);
		}else{
		    return null;
		}
	}
	
}
