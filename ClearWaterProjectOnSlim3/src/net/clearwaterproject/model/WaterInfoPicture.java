package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class WaterInfoPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;
    
    private String no;
    private ModelRef<WaterInfo> waterInfoRef = new ModelRef<WaterInfo>(WaterInfo.class);

    private BlobKey blobKey;
    private String  normal_serving_url;
    private String  small_serving_url;
    private Date    regist_date;
    
    public WaterInfoPicture() {
    }

    /* 外部でblobKeyを取得したものからURL取得するパターン。改良必要？ */
    public WaterInfoPicture(BlobKey blobKey) {
        Key wiPicKey = Datastore.allocateId(WaterInfoPicture.class);
        this.key = wiPicKey;
        this.no =  Long.toString(wiPicKey.getId());
        this.setBlobKey(blobKey);
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        setNormal_serving_url(imagesService.getServingUrl(blobKey));
        setSmall_serving_url(imagesService.getServingUrl(blobKey,150,true));
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
        WaterInfoPicture other = (WaterInfoPicture) obj;
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
     * @return blobKey
     */
    public BlobKey getBlobKey() {
        return blobKey;
    }

    /**
     * @param blobKey セットする blobKey
     */
    public void setBlobKey(BlobKey blobKey) {
        this.blobKey = blobKey;
    }

    /**
     * @return normal_serving_url
     */
    public String getNormal_serving_url() {
        return normal_serving_url;
    }

    /**
     * @param normal_serving_url セットする normal_serving_url
     */
    public void setNormal_serving_url(String normal_serving_url) {
        this.normal_serving_url = normal_serving_url;
    }

    /**
     * @return small_serving_url
     */
    public String getSmall_serving_url() {
        return small_serving_url;
    }

    /**
     * @param small_serving_url セットする small_serving_url
     */
    public void setSmall_serving_url(String small_serving_url) {
        this.small_serving_url = small_serving_url;
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
