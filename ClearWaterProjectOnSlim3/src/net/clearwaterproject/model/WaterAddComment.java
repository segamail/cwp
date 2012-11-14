package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.json.Expanded;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class WaterAddComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;
    
    private String no;
    private ModelRef<WaterInfo> waterInfoRef = new ModelRef<WaterInfo>(WaterInfo.class);

    @Json(coder=Expanded.class)
    private ModelRef<User> user = new ModelRef<User>(User.class);
    private String comment;
    private Date regist_date;
    
    public WaterAddComment(){
        this.regist_date = Calendar.getInstance().getTime();
    }
    
    


    /**
     * @return no
     */
    public String getNo() {
        return no;
    }




    /**
     * @param no セットする no
     */
    public void setNo(String no) {
        this.no = no;
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
     * 
     * @param water_info_id
     * @param cwp_user_id
     * @param water_add_comment_self_no
     */
    public void setKey(String water_info_no, String cwp_user_no, String water_add_comment_self_no) {
        String s = water_info_no + cwp_user_no + water_add_comment_self_no;
        this.key = KeyFactory.createKey(WaterAddComment.class.getSimpleName(), s); 
        this.no  = s;
    }
    
    /**
     * staticでWaterAddCommentに必要なキーを取得する
     * @param water_info_id
     * @param cwp_user_id
     * @param water_add_comment_self_no
     * @return
     */
    public static Key getCreateKey(String water_info_no, String cwp_user_no, String water_add_comment_self_no){
        return KeyFactory.createKey(WaterAddComment.class.getSimpleName(), water_info_no + cwp_user_no + water_add_comment_self_no);
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
        WaterAddComment other = (WaterAddComment) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /**
     * @return waterInfoRef
     */
    public ModelRef<WaterInfo> getWaterInfoRef() {
        return waterInfoRef;
    }


    /**
     * @return user
     */
    public ModelRef<User> getUser() {
        return user;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment セットする comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
    
    
}
