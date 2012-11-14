package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Date;


import com.google.appengine.api.datastore.Key;

import net.clearwaterproject.sys.com.Constants;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.ModificationDate;
import org.slim3.datastore.json.Expanded;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class User implements Serializable {


    /**
     * 
     */
    private static final long serialVersionUID = -2706817011349480412L;

    @Attribute(primaryKey = true) 
    @Json(ignore=true)
    private Key key;

    //    @Attribute(primaryKey = true) private Long id;
    @Attribute(version = true)   
    @Json(ignore=true)
    private Long version;

    /* データストアに保存するフィールドに　Persistentアノテーションを付与 */
    private String cwp_user_no;
    private String first_name;
    private String first_name_kn;
    private String last_name;
    private String last_name_kn;
    private String middle_name;
    private String middle_name_kn;
    private String gender;
    private Date   birth;
    private long   phone;
    private String moblile_email;
    //emailはkey生成に利用。必ず複数ユーザーが同じemailを持つことがないため。
    private String email;
    private int    post;
    private String address;
    private String login_type;
    private String facebook_id;
    
    @Json(coder=Expanded.class)
    private  ModelRef<UserPicture>  userPicRef = new ModelRef<UserPicture>(UserPicture.class);
    
    private int first_use;
    public  static int FIRST = 1; 
    public  static int NOT_FIRST = 0;
    @Attribute(listener = ModificationDate.class) private Date   regist_date;
    
    public static String USER_KEY = "user_key";
    
    /* コンストラクタ */
    public User(){
    }
    
    

    /**
     * @return cwp_user_id
     */
    public String getCwp_user_no() {
        return cwp_user_no;
    }



    /**
     * @param cwp_user_id セットする cwp_user_id
     */
    public void setCwp_user_no(String cwp_user_no) {
        this.cwp_user_no = cwp_user_no;
    }



    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name_kn() {
        return first_name_kn;
    }

    public void setFirst_name_kn(String first_name_kn) {
        this.first_name_kn = first_name_kn;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name_kn() {
        return last_name_kn;
    }

    public void setLast_name_kn(String last_name_kn) {
        this.last_name_kn = last_name_kn;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getMiddle_name_kn() {
        return middle_name_kn;
    }

    public void setMiddle_name_kn(String middle_name_kn) {
        this.middle_name_kn = middle_name_kn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getMoblile_email() {
        return moblile_email;
    }

    public void setMoblile_email(String moblile_email) {
        this.moblile_email = moblile_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }


    public ModelRef<UserPicture> getUserPicRef() {
        return userPicRef;
    }

    public Date getRegist_date() {
        return regist_date;
    }

    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }



    /**
     * @return login_type
     */
    public String getLogin_type() {
        return login_type;
    }



    /**
     * @param login_type セットする login_type
     */
    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }
    

    /**
     * @return first_use
     */
    public int getFirst_use() {
        return first_use;
    }



    /**
     * @param first_use セットする first_use
     */
    public void setFirst_use(int first_use) {
        this.first_use = first_use;
    }

    
}
