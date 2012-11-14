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
import net.clearwaterproject.controller.in.abs.AbstractDeleteInfoData;
import net.clearwaterproject.controller.out.JsonResultStatus;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.WaterAddComment;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterWatchUser;

import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/*
 * 水辺情報の注目を追加。
 * 20121106 WaterAddCommentServletとほぼ同じ成り立ちのため、何らかの共通化を図るべき。
 * 共通するのは①水辺情報に紐づく情報の更新（water_info_no,cwp_user_noは共通して利用）
 * ②WaterInfo, Userの取得
 */
public class DelWaterWatchUserServlet extends AbstractDeleteInfoData {

    /**
     * 
     */
    private static final long serialVersionUID = -8729571321784733438L;

    protected void deleteData(HashMap map){
        String waterInfoNo = (String)map.get("water_info_no");
        String cwpUserNo = (String) map.get("cwp_user_no").toString();

        //WaterWatchUserを削除
        Key wwKey = KeyFactory.createKey(WaterWatchUser.class.getSimpleName(), waterInfoNo + cwpUserNo);
        Datastore.delete(wwKey);
    }
    
//    public void doPost(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//        res.setContentType("application/json; charset=UTF-8");
//        
//        HashMap map   = new HashMap();
//        String jsonString = Streams.asString(req.getInputStream(),"UTF-8");
//        map =JSON.decode(jsonString, HashMap.class);
//
//
//        if (! CheckRequestData.chkWaterInfoNoInJsonMap(map, res)){
//            return;
//        }
//        long water_info_no = Long.parseLong((String)map.get("water_info_no").toString());
//        String cwp_user_no = (String) map.get("cwp_user_no").toString();
//        //WaterWatchUserを削除
//        Key wwKey = KeyFactory.createKey(WaterWatchUser.class.getSimpleName(), Long.toString(water_info_no) + cwp_user_no);
//        Datastore.delete(wwKey);
//        
//        //登録が完了したためクライアントに戻す
//        JsonResultStatus jsrs = new JsonResultStatus("ok",0,0,"");
//        JSON.encode(jsrs, res.getOutputStream());
//
//
//    }
	

}
