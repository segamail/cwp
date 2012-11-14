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
 * 水質情報のコメント取得
 */
public class DelWaterAddCommentServlet extends AbstractDeleteInfoData {


    /**
     * 
     */
    private static final long serialVersionUID = 290763281010021767L;

    protected void deleteData(HashMap map){
        String waterInfoNo = (String)map.get("water_info_no");
        String cwpUserNo = (String) map.get("cwp_user_no").toString();
        String waterAddCommentSelfNo = (String) map.get("water_add_comment_self_no").toString();
        //WaterWatchUserを削除
        Key waKey = KeyFactory.createKey(WaterAddComment.class.getSimpleName(),
            waterInfoNo + cwpUserNo + waterAddCommentSelfNo);
        Datastore.delete(waKey);       
    }

}
