package net.clearwaterproject.model;

import java.io.Serializable;


import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class WaterInfoDtl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;

    private String no;
    private String taste;  //味
    private double Ammonia; //アンモニア
    
    


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
        WaterInfoDtl other = (WaterInfoDtl) obj;
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
     * @return taste
     */
    public String getTaste() {
        return taste;
    }

    /**
     * @param taste セットする taste
     */
    public void setTaste(String taste) {
        this.taste = taste;
    }

    /**
     * @return ammonia
     */
    public double getAmmonia() {
        return Ammonia;
    }

    /**
     * @param ammonia セットする ammonia
     */
    public void setAmmonia(double ammonia) {
        Ammonia = ammonia;
    }
    
    
}
