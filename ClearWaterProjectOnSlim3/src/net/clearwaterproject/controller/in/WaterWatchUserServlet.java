package net.clearwaterproject.controller.in;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import net.clearwaterproject.app.check.CheckRequestData;
import net.clearwaterproject.app.users.UserService;
import net.clearwaterproject.app.users.UserServiceFactory;
import net.clearwaterproject.controller.in.abs.AbstractInsertInfoData;
import net.clearwaterproject.controller.out.JsonResultStatus;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterWatchUser;

import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.KeyFactory;

/*
 * 水辺情報の注目を追加。
 * 20121106 WaterAddCommentServletとほぼ同じ成り立ちのため、何らかの共通化を図るべき。
 * 共通するのは①水辺情報に紐づく情報の更新（water_info_id,cwp_user_idは共通して利用）
 * ②WaterInfo, Userの取得
 */
public class WaterWatchUserServlet extends AbstractInsertInfoData {

    /**
     * 
     */
    private static final long serialVersionUID = -2797617943109257374L;

    
    protected void insertData(User user, HashMap map){
        String waterInfoNo = (String)map.get("water_info_no").toString();

        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        //waterInfoの取得
        WaterInfo wi = gtx.get(WaterInfo.class, KeyFactory.createKey(WaterInfo.class.getSimpleName(), waterInfoNo));
        //コメントの追加
        WaterWatchUser ww = new WaterWatchUser();
        ww.setKey(waterInfoNo, user.getCwp_user_no());
        ww.getUser().setModel(user);
        ww.getWaterInfoRef().setModel(wi);
        //関連データ含め登録
        gtx.put(ww,user,wi);
        gtx.commit();
    }

	

}
