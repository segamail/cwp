package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 12:18:14")
/** */
public final class PromoterMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.Promoter> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> URL = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "URL", "URL");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> address = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "address", "address");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Integer> emp_num = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Integer>(this, "emp_num", "emp_num", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> fax = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "fax", "fax");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.util.Date> founding_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.util.Date>(this, "founding_date", "founding_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> ir_no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "ir_no", "ir_no");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Integer> office_flg = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Integer>(this, "office_flg", "office_flg", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> org_detail = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "org_detail", "org_detail");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> org_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "org_name", "org_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> org_name_en = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "org_name_en", "org_name_en");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> org_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "org_name_kn", "org_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> pic = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "pic", "pic");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> post = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "post", "post");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> promoter_no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "promoter_no", "promoter_no");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> sector = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "sector", "sector");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter> tel = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Promoter>(this, "tel", "tel");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Promoter, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PromoterMeta slim3_singleton = new PromoterMeta();

    /**
     * @return the singleton
     */
    public static PromoterMeta get() {
       return slim3_singleton;
    }

    /** */
    public PromoterMeta() {
        super("Promoter", net.clearwaterproject.model.Promoter.class);
    }

    @Override
    public net.clearwaterproject.model.Promoter entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.Promoter model = new net.clearwaterproject.model.Promoter();
        model.setURL((java.lang.String) entity.getProperty("URL"));
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setEmp_num(longToPrimitiveInt((java.lang.Long) entity.getProperty("emp_num")));
        model.setFax((java.lang.String) entity.getProperty("fax"));
        model.setFounding_date((java.util.Date) entity.getProperty("founding_date"));
        model.setIr_no((java.lang.String) entity.getProperty("ir_no"));
        model.setKey(entity.getKey());
        model.setOffice_flg(longToPrimitiveInt((java.lang.Long) entity.getProperty("office_flg")));
        model.setOrg_detail((java.lang.String) entity.getProperty("org_detail"));
        model.setOrg_name((java.lang.String) entity.getProperty("org_name"));
        model.setOrg_name_en((java.lang.String) entity.getProperty("org_name_en"));
        model.setOrg_name_kn((java.lang.String) entity.getProperty("org_name_kn"));
        model.setPic((java.lang.String) entity.getProperty("pic"));
        model.setPost((java.lang.String) entity.getProperty("post"));
        model.setPromoter_no((java.lang.String) entity.getProperty("promoter_no"));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setSector((java.lang.String) entity.getProperty("sector"));
        model.setTel((java.lang.String) entity.getProperty("tel"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("URL", m.getURL());
        entity.setProperty("address", m.getAddress());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("emp_num", m.getEmp_num());
        entity.setProperty("fax", m.getFax());
        entity.setProperty("founding_date", m.getFounding_date());
        entity.setProperty("ir_no", m.getIr_no());
        entity.setProperty("office_flg", m.getOffice_flg());
        entity.setProperty("org_detail", m.getOrg_detail());
        entity.setProperty("org_name", m.getOrg_name());
        entity.setProperty("org_name_en", m.getOrg_name_en());
        entity.setProperty("org_name_kn", m.getOrg_name_kn());
        entity.setProperty("pic", m.getPic());
        entity.setProperty("post", m.getPost());
        entity.setProperty("promoter_no", m.getPromoter_no());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("sector", m.getSector());
        entity.setProperty("tel", m.getTel());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.Promoter m = (net.clearwaterproject.model.Promoter) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getURL() != null){
            writer.setNextPropertyName("URL");
            encoder0.encode(writer, m.getURL());
        }
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        writer.setNextPropertyName("emp_num");
        encoder0.encode(writer, m.getEmp_num());
        if(m.getFax() != null){
            writer.setNextPropertyName("fax");
            encoder0.encode(writer, m.getFax());
        }
        if(m.getFounding_date() != null){
            writer.setNextPropertyName("founding_date");
            encoder0.encode(writer, m.getFounding_date());
        }
        if(m.getIr_no() != null){
            writer.setNextPropertyName("ir_no");
            encoder0.encode(writer, m.getIr_no());
        }
        org.slim3.datastore.json.Expanded encoder1 = new org.slim3.datastore.json.Expanded();
        if(m.getOfficeListRef() != null && getKey(m) != null){
            writer.setNextPropertyName("officeListRef");
            encoder1.encode(writer, m.getOfficeListRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("office_flg");
        encoder0.encode(writer, m.getOffice_flg());
        if(m.getOrg_detail() != null){
            writer.setNextPropertyName("org_detail");
            encoder0.encode(writer, m.getOrg_detail());
        }
        if(m.getOrg_name() != null){
            writer.setNextPropertyName("org_name");
            encoder0.encode(writer, m.getOrg_name());
        }
        if(m.getOrg_name_en() != null){
            writer.setNextPropertyName("org_name_en");
            encoder0.encode(writer, m.getOrg_name_en());
        }
        if(m.getOrg_name_kn() != null){
            writer.setNextPropertyName("org_name_kn");
            encoder0.encode(writer, m.getOrg_name_kn());
        }
        if(m.getPic() != null){
            writer.setNextPropertyName("pic");
            encoder0.encode(writer, m.getPic());
        }
        if(m.getPost() != null){
            writer.setNextPropertyName("post");
            encoder0.encode(writer, m.getPost());
        }
        if(m.getPromoterMemberListRef() != null && getKey(m) != null){
            writer.setNextPropertyName("promoterMemberListRef");
            encoder1.encode(writer, m.getPromoterMemberListRef(), maxDepth, currentDepth);
        }
        if(m.getPromoter_no() != null){
            writer.setNextPropertyName("promoter_no");
            encoder0.encode(writer, m.getPromoter_no());
        }
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        if(m.getSector() != null){
            writer.setNextPropertyName("sector");
            encoder0.encode(writer, m.getSector());
        }
        if(m.getTel() != null){
            writer.setNextPropertyName("tel");
            encoder0.encode(writer, m.getTel());
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.Promoter jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.Promoter m = new net.clearwaterproject.model.Promoter();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("URL");
        m.setURL(decoder0.decode(reader, m.getURL()));
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("emp_num");
        m.setEmp_num(decoder0.decode(reader, m.getEmp_num()));
        reader = rootReader.newObjectReader("fax");
        m.setFax(decoder0.decode(reader, m.getFax()));
        reader = rootReader.newObjectReader("founding_date");
        m.setFounding_date(decoder0.decode(reader, m.getFounding_date()));
        reader = rootReader.newObjectReader("ir_no");
        m.setIr_no(decoder0.decode(reader, m.getIr_no()));
        reader = rootReader.newObjectReader("office_flg");
        m.setOffice_flg(decoder0.decode(reader, m.getOffice_flg()));
        reader = rootReader.newObjectReader("org_detail");
        m.setOrg_detail(decoder0.decode(reader, m.getOrg_detail()));
        reader = rootReader.newObjectReader("org_name");
        m.setOrg_name(decoder0.decode(reader, m.getOrg_name()));
        reader = rootReader.newObjectReader("org_name_en");
        m.setOrg_name_en(decoder0.decode(reader, m.getOrg_name_en()));
        reader = rootReader.newObjectReader("org_name_kn");
        m.setOrg_name_kn(decoder0.decode(reader, m.getOrg_name_kn()));
        reader = rootReader.newObjectReader("pic");
        m.setPic(decoder0.decode(reader, m.getPic()));
        reader = rootReader.newObjectReader("post");
        m.setPost(decoder0.decode(reader, m.getPost()));
        reader = rootReader.newObjectReader("promoter_no");
        m.setPromoter_no(decoder0.decode(reader, m.getPromoter_no()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("sector");
        m.setSector(decoder0.decode(reader, m.getSector()));
        reader = rootReader.newObjectReader("tel");
        m.setTel(decoder0.decode(reader, m.getTel()));
        return m;
    }
}