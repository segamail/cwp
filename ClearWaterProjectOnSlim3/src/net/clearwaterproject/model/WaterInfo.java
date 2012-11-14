package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.google.appengine.api.datastore.Key;


import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.json.Expanded;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class WaterInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;

    private String no;
    @Json(coder=Expanded.class)
    private ModelRef<User> applyUser = new ModelRef<User>(User.class);
    private Date   apply_date;
    private double lat;
    private double lng;
    private int    country;
    /* GeoHexに該当するデータを取得できるように情報持たせる 。一応GeoHexはすべての情報取得元になるだろうから非所有で。*/
    @Json(coder=Expanded.class)
    private ModelRef<WaterInfoGeoHex>  waterInfoGHRef = new ModelRef<WaterInfoGeoHex>(WaterInfoGeoHex.class);
    /* waterInfoPicは1場所に複数毎アップ可能なため1対多所有*/
    //    private List<WaterInfoPicture> waterInfoPicList;
    @Attribute(persistent = false)
    @Json(ignore=false, coder=Expanded.class)
    private InverseModelListRef<WaterInfoPicture, WaterInfo> waterInfoPicListRef = 
            new InverseModelListRef<WaterInfoPicture, WaterInfo>(WaterInfoPicture.class, "waterInfoRef", this);

    private int    weather_id;
    private int    water_temperature;
    private String comment;
    private double cod;    
    private double bod;     
    private double colour;  //色度
    private double clarity; //透視度
    private double transparency; //透明度
    private double turbidity; //濁度
    private double pH;
    private double odour;     //臭気
    private double nitrate;   //硝酸態窒素
    private double iron;      //鉄
    private double manganese; //マンガン    
    private long watch_user_cnt;
    @Attribute(persistent = false)
    @Json(ignore=false, coder=Expanded.class)
    private InverseModelListRef<WaterWatchUser, WaterInfo> waterWatchUserListRef = 
            new InverseModelListRef<WaterWatchUser, WaterInfo>(WaterWatchUser.class, "waterInfoRef", this);
    
    @Attribute(persistent = false)
    @Json(ignore=false, coder=Expanded.class)
    private InverseModelListRef<WaterAddComment, WaterInfo> waterAddCommentListRef =
            new InverseModelListRef<WaterAddComment, WaterInfo>(WaterAddComment.class, "waterInfoRef", this);
    private long add_cooment_cnt;
    
    @Json(ignore=false, coder=Expanded.class)
    private ModelRef<WaterInfoDtl> dtl = new ModelRef<WaterInfoDtl>(WaterInfoDtl.class); //専門的詳細データ
    private Date regist_date;

    /* コンストラクタ */
    public WaterInfo(){

    }
    
    /* コンストラクタ */
    public WaterInfo(Date apply_date,  double lat, double lng, int weatherId,  String comment){
        Key wiKey = Datastore.allocateId(WaterInfo.class);
        this.key = wiKey;
        this.no =  Long.toString(wiKey.getId());
        this.apply_date = apply_date;
        this.lat  = lat;
        this.lng  = lng;
        this.weather_id = weatherId;
        this.comment= comment;
        this.colour = 0.0;  
        this.clarity = 0.0; 
        this.transparency = 0.0; 
        this.turbidity = 0.0; 
        this.pH = 0.0;
        this.odour = 0.0;    
        this.bod = 0.0;     
        this.cod = 0.0;     
        this.nitrate =0.0;   
        this.iron = 0.0;      
        this.manganese = 0.0;   
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
        WaterInfo other = (WaterInfo) obj;
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
     * @return applyUser
     */
    public ModelRef<User> getApplyUser() {
        return applyUser;
    }

    /**
     * @return apply_date
     */
    public Date getApply_date() {
        return apply_date;
    }

    /**
     * @param apply_date セットする apply_date
     */
    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
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
     * @return country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @param country セットする country
     */
    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * @return waterInfoGHRef
     */
    public ModelRef<WaterInfoGeoHex> getWaterInfoGHRef() {
        return waterInfoGHRef;
    }

    /**
     * @return waterInfoPicListRef
     */
    public InverseModelListRef<WaterInfoPicture, WaterInfo> getWaterInfoPicListRef() {
        return waterInfoPicListRef;
    }


    /**
     * @return weather_id
     */
    public int getWeather_id() {
        return weather_id;
    }

    /**
     * @param weather_id セットする weather_id
     */
    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
    }

    /**
     * @return water_temperature
     */
    public int getWater_temperature() {
        return water_temperature;
    }

    /**
     * @param water_temperature セットする water_temperature
     */
    public void setWater_temperature(int water_temperature) {
        this.water_temperature = water_temperature;
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
     * @return bod
     */
    public double getBod() {
        return bod;
    }

    /**
     * @param bod セットする bod
     */
    public void setBod(double bod) {
        this.bod = bod;
    }

    /**
     * @return colour
     */
    public double getColour() {
        return colour;
    }

    /**
     * @param colour セットする colour
     */
    public void setColour(double colour) {
        this.colour = colour;
    }

    /**
     * @return clarity
     */
    public double getClarity() {
        return clarity;
    }

    /**
     * @param clarity セットする clarity
     */
    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    /**
     * @return transparency
     */
    public double getTransparency() {
        return transparency;
    }

    /**
     * @param transparency セットする transparency
     */
    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    /**
     * @return turbidity
     */
    public double getTurbidity() {
        return turbidity;
    }

    /**
     * @param turbidity セットする turbidity
     */
    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    /**
     * @return pH
     */
    public double getPH() {
        return pH;
    }

    /**
     * @param pH セットする pH
     */
    public void setPH(double pH) {
        this.pH = pH;
    }

    /**
     * @return odour
     */
    public double getOdour() {
        return odour;
    }

    /**
     * @param odour セットする odour
     */
    public void setOdour(double odour) {
        this.odour = odour;
    }

    /**
     * @return nitrate
     */
    public double getNitrate() {
        return nitrate;
    }

    /**
     * @param nitrate セットする nitrate
     */
    public void setNitrate(double nitrate) {
        this.nitrate = nitrate;
    }

    /**
     * @return iron
     */
    public double getIron() {
        return iron;
    }

    /**
     * @param iron セットする iron
     */
    public void setIron(double iron) {
        this.iron = iron;
    }

    /**
     * @return manganese
     */
    public double getManganese() {
        return manganese;
    }

    /**
     * @param manganese セットする manganese
     */
    public void setManganese(double manganese) {
        this.manganese = manganese;
    }

    /**
     * @return dtl
     */
    public ModelRef<WaterInfoDtl> getDtl() {
        return dtl;
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
     * @return watch_user_cnt
     */
    public long getWatch_user_cnt() {
        return watch_user_cnt;
    }

    /**
     * @param watch_user_cnt セットする watch_user_cnt
     */
    public void setWatch_user_cnt(long watch_user_cnt) {
        this.watch_user_cnt = watch_user_cnt;
    }

    /**
     * @return add_cooment_cnt
     */
    public long getAdd_cooment_cnt() {
        return add_cooment_cnt;
    }

    /**
     * @param add_cooment_cnt セットする add_cooment_cnt
     */
    public void setAdd_cooment_cnt(long add_cooment_cnt) {
        this.add_cooment_cnt = add_cooment_cnt;
    }

    /**
     * @return waterWatchUserListRef
     */
    public InverseModelListRef<WaterWatchUser, WaterInfo> getWaterWatchUserListRef() {
        return waterWatchUserListRef;
    }

    /**
     * @return waterAddCommentListRef
     */
    public InverseModelListRef<WaterAddComment, WaterInfo> getWaterAddCommentListRef() {
        return waterAddCommentListRef;
    }

    
    

}
