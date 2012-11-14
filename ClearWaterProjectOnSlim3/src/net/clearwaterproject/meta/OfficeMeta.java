package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 12:18:09")
/** */
public final class OfficeMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.Office> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> URL = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "URL", "URL");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> adress = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "adress", "adress");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> fax = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "fax", "fax");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.Office, org.slim3.datastore.ModelRef<net.clearwaterproject.model.OfficePicture>, net.clearwaterproject.model.OfficePicture> officePicRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.Office, org.slim3.datastore.ModelRef<net.clearwaterproject.model.OfficePicture>, net.clearwaterproject.model.OfficePicture>(this, "officePicRef", "officePicRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.OfficePicture.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> office_detail = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "office_detail", "office_detail");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> office_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "office_name", "office_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> office_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "office_name_kn", "office_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> pic = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "pic", "pic");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> post = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "post", "post");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.Office, org.slim3.datastore.ModelRef<net.clearwaterproject.model.Promoter>, net.clearwaterproject.model.Promoter> promoterRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.Office, org.slim3.datastore.ModelRef<net.clearwaterproject.model.Promoter>, net.clearwaterproject.model.Promoter>(this, "promoterRef", "promoterRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.Promoter.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> sector = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "sector", "sector");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office> tel = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.Office>(this, "tel", "tel");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.Office, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final OfficeMeta slim3_singleton = new OfficeMeta();

    /**
     * @return the singleton
     */
    public static OfficeMeta get() {
       return slim3_singleton;
    }

    /** */
    public OfficeMeta() {
        super("Office", net.clearwaterproject.model.Office.class);
    }

    @Override
    public net.clearwaterproject.model.Office entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.Office model = new net.clearwaterproject.model.Office();
        model.setURL((java.lang.String) entity.getProperty("URL"));
        model.setAdress((java.lang.String) entity.getProperty("adress"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFax((java.lang.String) entity.getProperty("fax"));
        model.setKey(entity.getKey());
        if (model.getOfficePicRef() == null) {
            throw new NullPointerException("The property(officePicRef) is null.");
        }
        model.getOfficePicRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("officePicRef"));
        model.setOffice_detail((java.lang.String) entity.getProperty("office_detail"));
        model.setOffice_name((java.lang.String) entity.getProperty("office_name"));
        model.setOffice_name_kn((java.lang.String) entity.getProperty("office_name_kn"));
        model.setPic((java.lang.String) entity.getProperty("pic"));
        model.setPost((java.lang.String) entity.getProperty("post"));
        if (model.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) is null.");
        }
        model.getPromoterRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("promoterRef"));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setSector((java.lang.String) entity.getProperty("sector"));
        model.setTel((java.lang.String) entity.getProperty("tel"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("URL", m.getURL());
        entity.setProperty("adress", m.getAdress());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("fax", m.getFax());
        if (m.getOfficePicRef() == null) {
            throw new NullPointerException("The property(officePicRef) must not be null.");
        }
        entity.setProperty("officePicRef", m.getOfficePicRef().getKey());
        entity.setProperty("office_detail", m.getOffice_detail());
        entity.setProperty("office_name", m.getOffice_name());
        entity.setProperty("office_name_kn", m.getOffice_name_kn());
        entity.setProperty("pic", m.getPic());
        entity.setProperty("post", m.getPost());
        if (m.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) must not be null.");
        }
        entity.setProperty("promoterRef", m.getPromoterRef().getKey());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("sector", m.getSector());
        entity.setProperty("tel", m.getTel());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        if (m.getOfficePicRef() == null) {
            throw new NullPointerException("The property(officePicRef) must not be null.");
        }
        m.getOfficePicRef().assignKeyIfNecessary(ds);
        if (m.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) must not be null.");
        }
        m.getPromoterRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
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
        net.clearwaterproject.model.Office m = (net.clearwaterproject.model.Office) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getURL() != null){
            writer.setNextPropertyName("URL");
            encoder0.encode(writer, m.getURL());
        }
        if(m.getAdress() != null){
            writer.setNextPropertyName("adress");
            encoder0.encode(writer, m.getAdress());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getFax() != null){
            writer.setNextPropertyName("fax");
            encoder0.encode(writer, m.getFax());
        }
        org.slim3.datastore.json.Expanded encoder1 = new org.slim3.datastore.json.Expanded();
        if(m.getOfficePicRef() != null && m.getOfficePicRef().getKey() != null){
            writer.setNextPropertyName("officePicRef");
            encoder1.encode(writer, m.getOfficePicRef(), maxDepth, currentDepth);
        }
        if(m.getOffice_detail() != null){
            writer.setNextPropertyName("office_detail");
            encoder0.encode(writer, m.getOffice_detail());
        }
        if(m.getOffice_name() != null){
            writer.setNextPropertyName("office_name");
            encoder0.encode(writer, m.getOffice_name());
        }
        if(m.getOffice_name_kn() != null){
            writer.setNextPropertyName("office_name_kn");
            encoder0.encode(writer, m.getOffice_name_kn());
        }
        if(m.getPic() != null){
            writer.setNextPropertyName("pic");
            encoder0.encode(writer, m.getPic());
        }
        if(m.getPost() != null){
            writer.setNextPropertyName("post");
            encoder0.encode(writer, m.getPost());
        }
        if(m.getPromoterRef() != null && m.getPromoterRef().getKey() != null){
            writer.setNextPropertyName("promoterRef");
            encoder0.encode(writer, m.getPromoterRef(), maxDepth, currentDepth);
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
    protected net.clearwaterproject.model.Office jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.Office m = new net.clearwaterproject.model.Office();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("URL");
        m.setURL(decoder0.decode(reader, m.getURL()));
        reader = rootReader.newObjectReader("adress");
        m.setAdress(decoder0.decode(reader, m.getAdress()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("fax");
        m.setFax(decoder0.decode(reader, m.getFax()));
        reader = rootReader.newObjectReader("officePicRef");
        org.slim3.datastore.json.Expanded decoder1 = new org.slim3.datastore.json.Expanded();
        decoder1.decode(reader, m.getOfficePicRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("office_detail");
        m.setOffice_detail(decoder0.decode(reader, m.getOffice_detail()));
        reader = rootReader.newObjectReader("office_name");
        m.setOffice_name(decoder0.decode(reader, m.getOffice_name()));
        reader = rootReader.newObjectReader("office_name_kn");
        m.setOffice_name_kn(decoder0.decode(reader, m.getOffice_name_kn()));
        reader = rootReader.newObjectReader("pic");
        m.setPic(decoder0.decode(reader, m.getPic()));
        reader = rootReader.newObjectReader("post");
        m.setPost(decoder0.decode(reader, m.getPost()));
        reader = rootReader.newObjectReader("promoterRef");
        decoder0.decode(reader, m.getPromoterRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("sector");
        m.setSector(decoder0.decode(reader, m.getSector()));
        reader = rootReader.newObjectReader("tel");
        m.setTel(decoder0.decode(reader, m.getTel()));
        return m;
    }
}