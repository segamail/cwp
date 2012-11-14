package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Date;


import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.json.Expanded;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;
    
    private ModelRef<Promoter> promoterRef = new ModelRef<Promoter>(Promoter.class);

    private String office_name;
    private String office_name_kn;
    private String post;
    private String adress;
    private String sector;
    private String office_detail;
    private String tel;
    private String fax;
    private String email;
    private String URL;
    private String pic;
    private Date   regist_date;
    
    @Json(coder=Expanded.class)
    private  ModelRef<OfficePicture>  officePicRef = new ModelRef<OfficePicture>(OfficePicture.class);
    
    
    /**
     * @return office_name
     */
    public String getOffice_name() {
        return office_name;
    }

    /**
     * @param office_name セットする office_name
     */
    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    /**
     * @return office_name_kn
     */
    public String getOffice_name_kn() {
        return office_name_kn;
    }

    /**
     * @param office_name_kn セットする office_name_kn
     */
    public void setOffice_name_kn(String office_name_kn) {
        this.office_name_kn = office_name_kn;
    }

    /**
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post セットする post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress セットする adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector セットする sector
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return office_detail
     */
    public String getOffice_detail() {
        return office_detail;
    }

    /**
     * @param office_detail セットする office_detail
     */
    public void setOffice_detail(String office_detail) {
        this.office_detail = office_detail;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel セットする tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax セットする fax
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * @return uRL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param uRL セットする uRL
     */
    public void setURL(String uRL) {
        URL = uRL;
    }

    /**
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic セットする pic
     */
    public void setPic(String pic) {
        this.pic = pic;
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
     * @return promoterRef
     */
    public ModelRef<Promoter> getPromoterRef() {
        return promoterRef;
    }

    /**
     * @return officePicRef
     */
    public ModelRef<OfficePicture> getOfficePicRef() {
        return officePicRef;
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
        Office other = (Office) obj;
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
