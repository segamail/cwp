package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Date;


import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class PromoterMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)  
    @Json(ignore=true)
    private Long version;
    
    private ModelRef<Promoter> promoterRef = new ModelRef<Promoter>(Promoter.class);

    private String promoter_member_no;
    private String first_name;
    private String first_name_kn;
    private String last_name;
    private String last_name_kn;
    private String middle_name;
    private String middle_name_kn;
    private String gender;
    private String phone;
    private String mobile_phone;
    private String moblie_email;
    private String email;
    private String linkdin_id;
    private int    first_login;  //0:not first login  1:yes first login
    private Date   regist_date;
    
    
    /**
     * @return promoterRef
     */
    public ModelRef<Promoter> getPromoterRef() {
        return promoterRef;
    }

    /**
     * @return promoter_member_no
     */
    public String getPromoter_member_no() {
        return promoter_member_no;
    }

    /**
     * @param promoter_member_no セットする promoter_member_no
     */
    public void setPromoter_member_no(String promoter_member_no) {
        this.promoter_member_no = promoter_member_no;
    }

    /**
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name セットする first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return first_name_kn
     */
    public String getFirst_name_kn() {
        return first_name_kn;
    }

    /**
     * @param first_name_kn セットする first_name_kn
     */
    public void setFirst_name_kn(String first_name_kn) {
        this.first_name_kn = first_name_kn;
    }

    /**
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name セットする last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return last_name_kn
     */
    public String getLast_name_kn() {
        return last_name_kn;
    }

    /**
     * @param last_name_kn セットする last_name_kn
     */
    public void setLast_name_kn(String last_name_kn) {
        this.last_name_kn = last_name_kn;
    }

    /**
     * @return middle_name
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * @param middle_name セットする middle_name
     */
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    /**
     * @return middle_name_kn
     */
    public String getMiddle_name_kn() {
        return middle_name_kn;
    }

    /**
     * @param middle_name_kn セットする middle_name_kn
     */
    public void setMiddle_name_kn(String middle_name_kn) {
        this.middle_name_kn = middle_name_kn;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender セットする gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone セットする phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return mobile_phone
     */
    public String getMobile_phone() {
        return mobile_phone;
    }

    /**
     * @param mobile_phone セットする mobile_phone
     */
    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    /**
     * @return moblie_email
     */
    public String getMoblie_email() {
        return moblie_email;
    }

    /**
     * @param moblie_email セットする moblie_email
     */
    public void setMoblie_email(String moblie_email) {
        this.moblie_email = moblie_email;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email セットする email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return linkdin_id
     */
    public String getLinkdin_id() {
        return linkdin_id;
    }

    /**
     * @param linkdin_id セットする linkdin_id
     */
    public void setLinkdin_id(String linkdin_id) {
        this.linkdin_id = linkdin_id;
    }

    /**
     * @return first_login
     */
    public int getFirst_login() {
        return first_login;
    }

    /**
     * @param first_login セットする first_login
     */
    public void setFirst_login(int first_login) {
        this.first_login = first_login;
    }

    /**
     * @return regist_date
     */
    public Date getRegist_date() {
        return regist_date;
    }

    /**
     * @param regist_date セットする regist_date
     */
    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PromoterMember other = (PromoterMember) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
