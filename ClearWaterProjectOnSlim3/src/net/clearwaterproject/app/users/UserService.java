package net.clearwaterproject.app.users;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slim3.datastore.Datastore;

import net.clearwaterproject.meta.UserMeta;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.UserPicture;
import net.clearwaterproject.sys.com.CWPUserCashManager;
import net.clearwaterproject.sys.com.Constants;
import net.clearwaterproject.sys.com.CookieManager;

public class UserService {
	
	private User user = new User();
	
	/*
	 * CWPユーザー取得メソッド。
	 * HttpServletRequestのcookie確認→キャッシュにユーザーデータあるか確認→facebook_idからデータ取得　で取得
	 */
	public User getLoginUserByFB(HttpServletRequest req, String facebookId){
	    //cookie情報の取得
	    String cwpUserNo = CookieManager.getCWPUserNo(req.getCookies());        
	    //キャッシュにユーザーデータあるか確認
	    User user = CWPUserCashManager.getCWPUser(cwpUserNo);

	    if (user == null){
	        //ユーザー情報なし＝cookieなしか、mobileから。
	        user = this.getLoginUserByFB(facebookId);
	    }
	    return user;
	}
	
	 /*  facebookIdよりログインユーザー情報を取得。  */
    public User getLoginUserByFB(String facebookId){
        if (facebookId == null){return null;}
        UserMeta u = UserMeta.get();
        User user = Datastore.query(u)
                .filter(u.facebook_id.equal(facebookId))
                .asSingle();
        return user;
    }
	
    /*
     * CWPユーザー取得メソッド。
     * HttpServletRequestのcookie確認→キャッシュにユーザーデータあるか確認→facebook_idからデータ取得　で取得
     */
    public User getLoginUserByCWP(HttpServletRequest req, String prmCwpUserId){
        //cookie情報の取得
        String cwpUserNo = CookieManager.getCWPUserNo(req.getCookies());        
        //キャッシュにユーザーデータあるか確認
        User user = CWPUserCashManager.getCWPUser(cwpUserNo);

        if (user == null){
            //ユーザー情報なし＝cookieなしか、mobileから。
            user = this.getLoginUserByCWP(prmCwpUserId);
        }
        return user;
    }

    /*  CWPユーザーIDよりログインユーザー情報を取得。  */
    public User getLoginUserByCWP(String prmCwpUserId){
        if (prmCwpUserId == null){return null;}
        UserMeta u = UserMeta.get();
        User user = Datastore.query(u)
                .filter(u.key.equal(Datastore.createKey(User.class, prmCwpUserId)))
                .asSingle();
        return user;
    }

    public void setUser(Map map){
	    user.setFirst_name(map.get("first_name").toString());
	    user.setLast_name(map.get("last_name").toString());
	    user.setMiddle_name(map.get("middle_name").toString());
	    user.setGender(map.get("gender").toString());
	    //			user.setBirth(((Date)map.get("birth")));
	    user.setEmail(map.get("email").toString());
	    user.setFacebook_id(map.get("facebook_id").toString());
	    user.setRegist_date(Calendar.getInstance().getTime());
	    UserPicture userPic = new UserPicture(map.get("picture").toString());
	    user.getUserPicRef().setModel(userPic);
	    user.setLogin_type(Constants.LOGINTYPE_FB);
	    user.setCwp_user_no(Constants.LOGINTYPE_FB + map.get("facebook_id").toString());
	    user.setKey(Datastore.createKey(User.class, 
	        Constants.LOGINTYPE_FB + map.get("facebook_id").toString()));
	    user.setFirst_use(User.FIRST);
	    
	    Datastore.put(userPic,user);


	}
	
	public User getUser(){
		return user;
	}
	
}
