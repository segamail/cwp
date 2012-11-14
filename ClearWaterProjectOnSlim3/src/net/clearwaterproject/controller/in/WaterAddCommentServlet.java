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
import net.clearwaterproject.model.WaterAddComment;
import net.clearwaterproject.model.WaterInfo;

import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.KeyFactory;

/*
 * 水辺情報のコメント登録
 */
public class WaterAddCommentServlet extends AbstractInsertInfoData {


    /**
     * 
     */
    private static final long serialVersionUID = 290763281010021767L;


    protected void insertData(User user, HashMap map){
        String waterInfoNo = (String)map.get("water_info_no").toString();
        String waterAddCommentSelfNo = (String) map.get("water_add_comment_self_no");

        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        //waterInfoの取得
        WaterInfo wi = gtx.get(WaterInfo.class, KeyFactory.createKey(WaterInfo.class.getSimpleName(), waterInfoNo));
        //コメントの追加
        WaterAddComment wa = new WaterAddComment();
        wa.setKey(waterInfoNo, user.getCwp_user_no(), waterAddCommentSelfNo);
        wa.setComment(map.get("comment").toString());
        wa.getUser().setModel(user);
        wa.getWaterInfoRef().setModel(wi);
        //関連データ含め登録
        gtx.put(wa,user,wi);
        gtx.commit();
    }

//    public void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        res.setContentType("application/json; charset=UTF-8");
//
//        HashMap map   = new HashMap();
//        String jsonString = Streams.asString(req.getInputStream(),"UTF-8");
//        map =JSON.decode(jsonString, HashMap.class);
//
//        if (! CheckRequestData.chkWaterInfoNoInJsonMap(map, res)){
//            return;
//        }
//        //cwp_user_idよりキャッシュからユーザー取得。なければ送られてきたcwp_user_id利用しdatastoreから取得。
//        long water_info_no = Long.parseLong((String)map.get("water_info_no").toString());
//        String cwp_user_no = (String) map.get("cwp_user_no").toString();
//        String water_add_comment_self_no = (String) map.get("water_add_comment_self_no");
//        UserService us = UserServiceFactory.getUserService();
//        User user = us.getLoginUserByCWP(req, cwp_user_no);
//
//        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
//        //waterInfoの取得
//        WaterInfo wi = gtx.get(WaterInfo.class, KeyFactory.createKey(WaterInfo.class.getSimpleName(), water_info_no));
//        //コメントの追加
//        WaterAddComment wa = new WaterAddComment();
//        wa.setKey(water_info_no, cwp_user_no, water_add_comment_self_no);
//        wa.setComment(map.get("comment").toString());
//        User u = gtx.get(User.class, KeyFactory.createKey(User.class.getSimpleName(), cwp_user_no));
//        wa.getUser().setModel(u);
//        wa.getWaterInfoRef().setModel(wi);
//        //関連データ含め登録
//        gtx.put(wa,u,wi);
//        gtx.commit();
//
//        //登録が完了したためクライアントに戻す
//        JsonResultStatus jsrs = new JsonResultStatus("ok",0,0,"");
//        JSON.encode(jsrs, res.getOutputStream());
//
//    }


}
