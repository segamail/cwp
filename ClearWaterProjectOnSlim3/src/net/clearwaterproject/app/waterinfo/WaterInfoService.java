package net.clearwaterproject.app.waterinfo;

import java.util.Calendar;
import java.util.Map;

import javax.jdo.PersistenceManager;

import net.clearwaterproject.db.dao.jdo.PMF;
import net.clearwaterproject.model.User;

public class WaterInfoService {
	
	
	 
	public void setUser(Map map){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			@SuppressWarnings("deprecation")
			User user = new User();	
			user.setFacebook_id(map.get("facebook_id").toString());
			user.setFirst_name(map.get("first_name").toString());
			user.setLast_name(map.get("last_name").toString());
			user.setMiddle_name(map.get("middle_name").toString());
			user.setGender(map.get("gender").toString());
//			user.setBirth(((Date)map.get("birth")));
			user.setEmail(map.get("email").toString());
			user.setFacebook_id(map.get("facebook_id").toString());
			user.setRegist_date(Calendar.getInstance().getTime());
			
			pm.makePersistent(user);
		} finally {
			pm.close();
		}
			
	}

}
