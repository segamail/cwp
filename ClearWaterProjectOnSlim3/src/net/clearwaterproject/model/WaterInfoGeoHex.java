package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.google.appengine.api.datastore.Key;


import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class WaterInfoGeoHex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;

    private String zone;
    private int   level;
    /* データストアに保存するフィールドに　Persistentアノテーションを付与 */
    private double lat;
    private double lng;
    
    /*moblieに送る用のデータのため、非永続化（データ保存しない）で、あくまでデータセットのみ*/
    @Attribute(persistent = false) private double cod;
    
    @Attribute(persistent = false)
    private InverseModelListRef<WaterInfo, WaterInfoGeoHex> waterInfoListRef = 
            new InverseModelListRef<WaterInfo, WaterInfoGeoHex>(WaterInfo.class, "waterInfoGHRef", this);
    
    private Date   regist_date;
    
    /* コンストラクタ */
    public WaterInfoGeoHex(){
        
    }
    
    /* コンストラクタ */
    public WaterInfoGeoHex(String zone, int level,double lat, double lng){
        //zoneからKeyを作っておく。zoneさえわかれば関連データも取得できるため
        this.key   = Datastore.createKey(WaterInfoGeoHex.class, zone);
        this.zone  = zone;
        this.level = level;
        this.lat = lat;
        this.lng = lng;
        this.regist_date = Calendar.getInstance().getTime();
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
        WaterInfoGeoHex other = (WaterInfoGeoHex) obj;
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
     * @return zone
     */
    public String getZone() {
        return zone;
    }

    /**
     * @param zone セットする zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level セットする level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat セットする lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng セットする lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * @return cod
     */
    public double getCod() {
        return cod;
    }

    /**
     * @param cod セットする cod
     */
    public void setCod(double cod) {
        this.cod = cod;
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
     * @return waterInfoListRef
     */
    public InverseModelListRef<WaterInfo, WaterInfoGeoHex> getWaterInfoListRef() {
        return waterInfoListRef;
    }
    
    
}
