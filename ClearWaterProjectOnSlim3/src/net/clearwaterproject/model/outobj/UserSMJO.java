package net.clearwaterproject.model.outobj;

import net.clearwaterproject.model.User;


public class UserSMJO {
	private String cwp_user_id;
	private String first_name;
	private String last_name;
	private String middle_name;
	private String facebook_id;
//	private UserPictureJO  userPic;


	/* コンストラクタ */
	public UserSMJO(User user){
	    setCwp_user_id(user.getKey().getName());
		setFacebook_id(user.getFacebook_id());
		setFirst_name(user.getFirst_name());
		setLast_name(user.getLast_name());
		setMiddle_name(user.getMiddle_name());
//		setUserPic(new UserPictureJO(user.getUserPicRef().getModel()));
	}

	
	public String getFirst_name() {
		return first_name;
	}

    /**
     * @return cwp_user_id
     */
    public String getCwp_user_id() {
        return cwp_user_id;
    }


    /**
     * @param cwp_user_id セットする cwp_user_id
     */
    public void setCwp_user_id(String cwp_user_id) {
        this.cwp_user_id = cwp_user_id;
    }


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(String facebook_id) {
		this.facebook_id = facebook_id;
	}
	

//	public UserPictureJO getUserPic() {
//		return userPic;
//	}
//
//	public void setUserPic(UserPictureJO userPic) {
//		this.userPic = userPic;
//	}



}
