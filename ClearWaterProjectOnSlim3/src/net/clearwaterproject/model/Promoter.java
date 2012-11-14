package net.clearwaterproject.model;

import java.io.Serializable;
import java.util.Date;
import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.json.Expanded;
import org.slim3.datastore.json.Json;

@Model(schemaVersion = 1)
public class Promoter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Json(ignore=true)
    private Key key;

    @Attribute(version = true)
    @Json(ignore=true)
    private Long version;

    private String promoter_no;
    private String org_name;
    private String org_name_kn;
    private String org_name_en;
    private String post;
    private String address;
    private String sector;
    private String org_detail;
    private String ir_no;
    private Date   founding_date;
    private String tel;
    private String fax;
    private String email;
    private int    emp_num;
    private String URL;
    private String pic;
    private int    office_flg;
    @Attribute(persistent = false)
    @Json(ignore=false, coder=Expanded.class)
    private InverseModelListRef<Office, Promoter> officeListRef = 
            new InverseModelListRef<Office, Promoter>(Office.class, "promoterRef", this);
    @Attribute(persistent = false)
    @Json(ignore=false, coder=Expanded.class)
    private InverseModelListRef<PromoterMember, Promoter> promoterMemberListRef = 
            new InverseModelListRef<PromoterMember, Promoter>(PromoterMember.class, "promoterRef", this);
    private Date   regist_date;
    
    
    /**
     * @return promoter_no
     */
    public String getPromoter_no() {
        return promoter_no;
    }

    /**
     * @param promoter_no セットする promoter_no
     */
    public void setPromoter_no(String promoter_no) {
        this.promoter_no = promoter_no;
    }

    /**
     * @return org_name
     */
    public String getOrg_name() {
        return org_name;
    }

    /**
     * @param org_name セットする org_name
     */
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    /**
     * @return org_name_kn
     */
    public String getOrg_name_kn() {
        return org_name_kn;
    }

    /**
     * @param org_name_kn セットする org_name_kn
     */
    public void setOrg_name_kn(String org_name_kn) {
        this.org_name_kn = org_name_kn;
    }

    /**
     * @return org_name_en
     */
    public String getOrg_name_en() {
        return org_name_en;
    }

    /**
     * @param org_name_en セットする org_name_en
     */
    public void setOrg_name_en(String org_name_en) {
        this.org_name_en = org_name_en;
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address セットする address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return org_detail
     */
    public String getOrg_detail() {
        return org_detail;
    }

    /**
     * @param org_detail セットする org_detail
     */
    public void setOrg_detail(String org_detail) {
        this.org_detail = org_detail;
    }

    /**
     * @return ir_no
     */
    public String getIr_no() {
        return ir_no;
    }

    /**
     * @param ir_no セットする ir_no
     */
    public void setIr_no(String ir_no) {
        this.ir_no = ir_no;
    }

    /**
     * @return founding_date
     */
    public Date getFounding_date() {
        return founding_date;
    }

    /**
     * @param founding_date セットする founding_date
     */
    public void setFounding_date(Date founding_date) {
        this.founding_date = founding_date;
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
     * @return emp_num
     */
    public int getEmp_num() {
        return emp_num;
    }

    /**
     * @param emp_num セットする emp_num
     */
    public void setEmp_num(int emp_num) {
        this.emp_num = emp_num;
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
     * @return office_flg
     */
    public int getOffice_flg() {
        return office_flg;
    }

    /**
     * @param office_flg セットする office_flg
     */
    public void setOffice_flg(int office_flg) {
        this.office_flg = office_flg;
    }

    /**
     * @return officeListRef
     */
    public InverseModelListRef<Office, Promoter> getOfficeListRef() {
        return officeListRef;
    }


    /**
     * @return promoterMemberListRef
     */
    public InverseModelListRef<PromoterMember, Promoter> getPromoterMemberListRef() {
        return promoterMemberListRef;
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
        Promoter other = (Promoter) obj;
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
