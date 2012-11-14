package net.clearwaterproject.app.promoter;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import net.clearwaterproject.db.dao.jdo.PMF;
import net.clearwaterproject.model.Promoter;
import net.clearwaterproject.model.PromoterMember;

public class PromoterMemberService {
	
	/*  ログイン状態の確認  */
	public boolean isPromoterMemberloggedIn(){
		return true; //とりあえず
	}
	
	/*  PromoterMember情報を取得。  */
	public PromoterMember getPromoterMember(String email){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(PromoterMember.class);
		try{
			//Promoterデータをemailを元に取得。
			query.setFilter("email == emailParam");
			query.declareParameters("String emailParam");
			List<PromoterMember> results = (List<PromoterMember>)query.execute(email);
			if (results.size() > 0 || !results.isEmpty()){
				return results.get(0);
			}else{
				return null;
			}
		} finally {
			query.closeAll();
			pm.close();

		}

	}

	public void setPromoterMember(Map map){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
		    PromoterMember promoterMember = new PromoterMember();	
		    if (map.get("email") != null){promoterMember.setEmail(map.get("email").toString());}
		    if (map.get("last_name") != null) {promoterMember.setLast_name(map.get("last_name").toString()); }
		    if (map.get("last_name_kn") != null) {promoterMember.setLast_name_kn(map.get("last_name_kn").toString());}
		    if (map.get("first_name") != null) {promoterMember.setFirst_name(map.get("first_name").toString());}
			if (map.get("first_name_kn") != null) {promoterMember.setFirst_name_kn(map.get("first_name_kn").toString());}
			if (map.get("middle_name") != null) {promoterMember.setMiddle_name(map.get("middle_name").toString());}
			if (map.get("middle_name_kn") != null) {promoterMember.setMiddle_name(map.get("middle_name_kn").toString());}
			if (map.get("gender") != null) {promoterMember.setGender(map.get("gender").toString());}
			if (map.get("department") != null) {promoterMember.setGender(map.get("department").toString());}
			if (map.get("phone") != null) {promoterMember.setPhone(map.get("phone").toString());}
			if (map.get("mobile_phone") != null) {promoterMember.setMobile_phone(map.get("mobile_phone").toString());}
			if (map.get("email") != null) {promoterMember.setEmail(map.get("email").toString());}
			if (map.get("mobile_email") != null) {promoterMember.setMoblie_email(map.get("mobile_email").toString());}
			//登録時は必ず最初のログインになるので。
			promoterMember.setFirst_login(1);

			//上位のPromoterのList内に存在する人か確認
			Key k = KeyFactory.createKey(Promoter.class.getSimpleName(), map.get("org_email").toString());
			Promoter promoter = pm.getObjectById(Promoter.class, k);

			List<PromoterMember> memberList = promoter.getPromoterMemberListRef().getModelList();
			Iterator memberIter = memberList.iterator();
			while (memberIter.hasNext()){
				PromoterMember member = (PromoterMember) memberIter.next();
				if (member != null && member.getEmail().equals(promoterMember.getEmail())){
					//追加登録不要。すでに存在していることを返す。いったんは何も返さずreturn
					return;
				}
			}

			//Promoterのメンバーリストに追加
			promoter.getPromoterMemberListRef().getModelList().add(promoterMember);			
			
		} finally {
			pm.close();
		}
			
	}

}
