package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Persistent;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModificationDate;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class UserPicture implements Serializable {


    /**
     * 
     */
    private static final long serialVersionUID = 2535473019628738397L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;

    private String  no;
    private BlobKey blobKey;
    private String  normal_serving_url;
    private String  small_serving_url;
    private String  thumbnail_serving_url;
    @Attribute(listener = ModificationDate.class) private Date   regist_date;
    
    
    public UserPicture(){
    }
    public UserPicture(String url){
        setNormal_serving_url(url+"?type=large");
        setSmall_serving_url(url+"?type=small");
        setThumbnail_serving_url(url);
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
        UserPicture other = (UserPicture) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public BlobKey getBlobKey() {
        return blobKey;
    }

    public void setBlobKey(BlobKey blobKey) {
        this.blobKey = blobKey;
    }

    public String getNormal_serving_url() {
        return normal_serving_url;
    }

    public void setNormal_serving_url(String normal_serving_url) {
        this.normal_serving_url = normal_serving_url;
    }

    public String getSmall_serving_url() {
        return small_serving_url;
    }

    public void setSmall_serving_url(String small_serving_url) {
        this.small_serving_url = small_serving_url;
    }

    public String getThumbnail_serving_url() {
        return thumbnail_serving_url;
    }

    public void setThumbnail_serving_url(String thumbnail_serving_url) {
        this.thumbnail_serving_url = thumbnail_serving_url;
    }

    public Date getRegist_date() {
        return regist_date;
    }

    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }
    
    
}
