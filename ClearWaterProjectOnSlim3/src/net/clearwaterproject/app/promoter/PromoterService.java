package net.clearwaterproject.app.promoter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import net.clearwaterproject.db.dao.jdo.PMF;
import net.clearwaterproject.model.Promoter;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PromoterService {
	
	
	/*  事業者情報を取得。  */
	public Promoter getPromoter(String email){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Promoter.class);
		try{
			//Promoterデータをemailを元に取得。
			query.setFilter("email == emailParam");
			query.declareParameters("String emailParam");
			List<Promoter> results = (List<Promoter>)query.execute(email);
			if (results.size() > 0 || !results.isEmpty()){
				return results.get(0);
			}else{
				return null;
			}
		} finally {
//			pm.close();
			query.closeAll();
		}

	}
		 
	public void setPromoter(Map map){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Promoter promoter = new Promoter();
			if (map.get("org_email") != null){promoter.setEmail(map.get("org_email").toString());}
			if (map.get("org_name") != null){promoter.setOrg_name(map.get("org_name").toString());}
			if (map.get("org_name_kn") != null){promoter.setOrg_name_kn(map.get("org_name_kn").toString());}
			if (map.get("post") != null){promoter.setPost(map.get("post").toString());}
			if (map.get("address") != null){promoter.setAddress(map.get("address").toString());}
			if (map.get("sector") != null){promoter.setSector(map.get("sector").toString());}
			if (map.get("org_detail") != null){promoter.setOrg_detail(map.get("org_detail").toString());}
			if (map.get("ir_no") != null){promoter.setIr_no(map.get("ir_no").toString());}
			if (map.get("org_name") != null){promoter.setFounding_date(Calendar.getInstance().getTime());}
			if (map.get("tel") != null){promoter.setTel(map.get("tel").toString());}
			if (map.get("fax") != null){promoter.setFax(map.get("fax").toString());}
			if (map.get("org_email") != null){promoter.setEmail(map.get("org_email").toString());}
			if (map.get("emp_num") != null){promoter.setEmp_num(Integer.parseInt(map.get("emp_num").toString()));}
			if (map.get("url") != null){promoter.setURL(map.get("url").toString());}
			promoter.setOffice_flg(1);
			pm.makePersistent(promoter);
		} finally {
			pm.close();
		}
			
	}

}
