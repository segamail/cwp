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
import net.clearwaterproject.controller.in.abs.AbstractUpdateInfoData;
import net.clearwaterproject.controller.out.JsonResultStatus;
import net.clearwaterproject.model.User;
import net.clearwaterproject.model.WaterAddComment;
import net.clearwaterproject.model.WaterInfo;

import org.apache.commons.fileupload.util.Streams;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/*
 * 水辺情報のコメント更新
 */
public class UpdateWaterAddCommentServlet extends AbstractUpdateInfoData {


    /**
     * 
     */
    private static final long serialVersionUID = 290763281010021767L;


    protected void updateData(HashMap map){
        String cwpUserNo   = (String) map.get("cwp_user_no");
        String waterInfoNo = (String)map.get("water_info_no").toString();
        String waterAddCommentSelfNo = (String) map.get("water_add_comment_self_no");
        
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        //コメントの更新
        Key waKey = WaterAddComment.getCreateKey(waterInfoNo, cwpUserNo, waterAddCommentSelfNo);
        WaterAddComment wa = gtx.get(WaterAddComment.class, waKey);
        wa.setComment(map.get("comment").toString());
        gtx.put(wa);
        gtx.commit();
    }



}
