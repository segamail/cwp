package net.clearwaterproject.controller.in.abs;

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
import net.clearwaterproject.controller.out.JsonResultStatus;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.WaterAddComment;
import net.clearwaterproject.model.WaterInfo;

import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.KeyFactory;

public abstract class AbstractInsertInfoData extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -8328904517372213027L;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("application/json; charset=UTF-8");

        HashMap map   = new HashMap();
        String jsonString = Streams.asString(req.getInputStream(),"UTF-8");
        map =JSON.decode(jsonString, HashMap.class);

        if (! CheckRequestData.chkWaterInfoNoInJsonMap(map, res)){
            return;
        }
        //cwp_user_idよりキャッシュからユーザー取得。なければ送られてきたcwp_user_id利用しdatastoreから取得。
        String cwpUserNo   = (String) map.get("cwp_user_no");
        UserService us = UserServiceFactory.getUserService();
        User user = us.getLoginUserByCWP(req, cwpUserNo);

        insertData(user, map);

        //登録が完了したためクライアントに戻す
        JsonResultStatus jsrs = new JsonResultStatus("ok",0,0,"");
        JSON.encode(jsrs, res.getOutputStream());

    }
    
    /**
     * それぞれの内部データ登録を実装
     */
    protected abstract void insertData(User user, HashMap map);

    
}
