package net.clearwaterproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.clearwaterproject.model.WaterAddComment;
import net.clearwaterproject.model.WaterInfo;
import net.clearwaterproject.model.WaterInfoDtl;
import net.clearwaterproject.model.WaterInfoGeoHex;
import net.clearwaterproject.model.WaterInfoPicture;
import net.clearwaterproject.model.WaterWatchUser;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

/*　テスト実施用サーブレット */
@SuppressWarnings("serial")
public class FromTest extends HttpServlet{
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		System.out.println("fromtest1");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		System.out.println("fromtest2");
		//データをユーザー以外全部消す
		dropKind(WaterInfo.class.getSimpleName());
		dropKind(WaterInfoGeoHex.class.getSimpleName());
		dropKind(WaterInfoPicture.class.getSimpleName());
		dropKind(WaterAddComment.class.getSimpleName());
		dropKind(WaterInfoDtl.class.getSimpleName());
		dropKind(WaterWatchUser.class.getSimpleName());
	}
	
	
    public static void dropKind(String kindName) {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query(kindName);
        query.setKeysOnly();
        List<Entity> list =
            ds.prepare(query).asList(FetchOptions.Builder.withOffset(0)); // ※DatastoreTimeoutException の可能性がありますが省略しています。
        List<Key> keys = new ArrayList<Key>(500);
        for (Entity entity : list) {
            keys.add(entity.getKey());
            if (keys.size() == 500) {
                try {
                    ds.delete(keys); // batch delete
                } catch (DatastoreTimeoutException ignore) {
                }
                keys.clear();
            }
        }
        if (keys.size() > 0){
            ds.delete(keys); // batch delete ※DatastoreTimeoutException の可能性がありますが省略しています。
        }
    }
	

}
