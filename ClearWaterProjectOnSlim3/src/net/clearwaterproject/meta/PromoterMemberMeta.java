package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 12:18:09")
/** */
public final class PromoterMemberMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.PromoterMember> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.lang.Integer> first_login = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.lang.Integer>(this, "first_login", "first_login", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> first_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "first_name", "first_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> first_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "first_name_kn", "first_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> gender = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "gender", "gender");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> last_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "last_name", "last_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> last_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "last_name_kn", "last_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> linkdin_id = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "linkdin_id", "linkdin_id");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> middle_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "middle_name", "middle_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> middle_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "middle_name_kn", "middle_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> mobile_phone = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "mobile_phone", "mobile_phone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> moblie_email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "moblie_email", "moblie_email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> phone = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "phone", "phone");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.PromoterMember, org.slim3.datastore.ModelRef<net.clearwaterproject.model.Promoter>, net.clearwaterproject.model.Promoter> promoterRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.PromoterMember, org.slim3.datastore.ModelRef<net.clearwaterproject.model.Promoter>, net.clearwaterproject.model.Promoter>(this, "promoterRef", "promoterRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.Promoter.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember> promoter_member_no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.PromoterMember>(this, "promoter_member_no", "promoter_member_no");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.PromoterMember, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PromoterMemberMeta slim3_singleton = new PromoterMemberMeta();

    /**
     * @return the singleton
     */
    public static PromoterMemberMeta get() {
       return slim3_singleton;
    }

    /** */
    public PromoterMemberMeta() {
        super("PromoterMember", net.clearwaterproject.model.PromoterMember.class);
    }

    @Override
    public net.clearwaterproject.model.PromoterMember entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.PromoterMember model = new net.clearwaterproject.model.PromoterMember();
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFirst_login(longToPrimitiveInt((java.lang.Long) entity.getProperty("first_login")));
        model.setFirst_name((java.lang.String) entity.getProperty("first_name"));
        model.setFirst_name_kn((java.lang.String) entity.getProperty("first_name_kn"));
        model.setGender((java.lang.String) entity.getProperty("gender"));
        model.setKey(entity.getKey());
        model.setLast_name((java.lang.String) entity.getProperty("last_name"));
        model.setLast_name_kn((java.lang.String) entity.getProperty("last_name_kn"));
        model.setLinkdin_id((java.lang.String) entity.getProperty("linkdin_id"));
        model.setMiddle_name((java.lang.String) entity.getProperty("middle_name"));
        model.setMiddle_name_kn((java.lang.String) entity.getProperty("middle_name_kn"));
        model.setMobile_phone((java.lang.String) entity.getProperty("mobile_phone"));
        model.setMoblie_email((java.lang.String) entity.getProperty("moblie_email"));
        model.setPhone((java.lang.String) entity.getProperty("phone"));
        if (model.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) is null.");
        }
        model.getPromoterRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("promoterRef"));
        model.setPromoter_member_no((java.lang.String) entity.getProperty("promoter_member_no"));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("email", m.getEmail());
        entity.setProperty("first_login", m.getFirst_login());
        entity.setProperty("first_name", m.getFirst_name());
        entity.setProperty("first_name_kn", m.getFirst_name_kn());
        entity.setProperty("gender", m.getGender());
        entity.setProperty("last_name", m.getLast_name());
        entity.setProperty("last_name_kn", m.getLast_name_kn());
        entity.setProperty("linkdin_id", m.getLinkdin_id());
        entity.setProperty("middle_name", m.getMiddle_name());
        entity.setProperty("middle_name_kn", m.getMiddle_name_kn());
        entity.setProperty("mobile_phone", m.getMobile_phone());
        entity.setProperty("moblie_email", m.getMoblie_email());
        entity.setProperty("phone", m.getPhone());
        if (m.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) must not be null.");
        }
        entity.setProperty("promoterRef", m.getPromoterRef().getKey());
        entity.setProperty("promoter_member_no", m.getPromoter_member_no());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        if (m.getPromoterRef() == null) {
            throw new NullPointerException("The property(promoterRef) must not be null.");
        }
        m.getPromoterRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
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
        net.clearwaterproject.model.PromoterMember m = (net.clearwaterproject.model.PromoterMember) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        writer.setNextPropertyName("first_login");
        encoder0.encode(writer, m.getFirst_login());
        if(m.getFirst_name() != null){
            writer.setNextPropertyName("first_name");
            encoder0.encode(writer, m.getFirst_name());
        }
        if(m.getFirst_name_kn() != null){
            writer.setNextPropertyName("first_name_kn");
            encoder0.encode(writer, m.getFirst_name_kn());
        }
        if(m.getGender() != null){
            writer.setNextPropertyName("gender");
            encoder0.encode(writer, m.getGender());
        }
        if(m.getLast_name() != null){
            writer.setNextPropertyName("last_name");
            encoder0.encode(writer, m.getLast_name());
        }
        if(m.getLast_name_kn() != null){
            writer.setNextPropertyName("last_name_kn");
            encoder0.encode(writer, m.getLast_name_kn());
        }
        if(m.getLinkdin_id() != null){
            writer.setNextPropertyName("linkdin_id");
            encoder0.encode(writer, m.getLinkdin_id());
        }
        if(m.getMiddle_name() != null){
            writer.setNextPropertyName("middle_name");
            encoder0.encode(writer, m.getMiddle_name());
        }
        if(m.getMiddle_name_kn() != null){
            writer.setNextPropertyName("middle_name_kn");
            encoder0.encode(writer, m.getMiddle_name_kn());
        }
        if(m.getMobile_phone() != null){
            writer.setNextPropertyName("mobile_phone");
            encoder0.encode(writer, m.getMobile_phone());
        }
        if(m.getMoblie_email() != null){
            writer.setNextPropertyName("moblie_email");
            encoder0.encode(writer, m.getMoblie_email());
        }
        if(m.getPhone() != null){
            writer.setNextPropertyName("phone");
            encoder0.encode(writer, m.getPhone());
        }
        if(m.getPromoterRef() != null && m.getPromoterRef().getKey() != null){
            writer.setNextPropertyName("promoterRef");
            encoder0.encode(writer, m.getPromoterRef(), maxDepth, currentDepth);
        }
        if(m.getPromoter_member_no() != null){
            writer.setNextPropertyName("promoter_member_no");
            encoder0.encode(writer, m.getPromoter_member_no());
        }
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.PromoterMember jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.PromoterMember m = new net.clearwaterproject.model.PromoterMember();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("first_login");
        m.setFirst_login(decoder0.decode(reader, m.getFirst_login()));
        reader = rootReader.newObjectReader("first_name");
        m.setFirst_name(decoder0.decode(reader, m.getFirst_name()));
        reader = rootReader.newObjectReader("first_name_kn");
        m.setFirst_name_kn(decoder0.decode(reader, m.getFirst_name_kn()));
        reader = rootReader.newObjectReader("gender");
        m.setGender(decoder0.decode(reader, m.getGender()));
        reader = rootReader.newObjectReader("last_name");
        m.setLast_name(decoder0.decode(reader, m.getLast_name()));
        reader = rootReader.newObjectReader("last_name_kn");
        m.setLast_name_kn(decoder0.decode(reader, m.getLast_name_kn()));
        reader = rootReader.newObjectReader("linkdin_id");
        m.setLinkdin_id(decoder0.decode(reader, m.getLinkdin_id()));
        reader = rootReader.newObjectReader("middle_name");
        m.setMiddle_name(decoder0.decode(reader, m.getMiddle_name()));
        reader = rootReader.newObjectReader("middle_name_kn");
        m.setMiddle_name_kn(decoder0.decode(reader, m.getMiddle_name_kn()));
        reader = rootReader.newObjectReader("mobile_phone");
        m.setMobile_phone(decoder0.decode(reader, m.getMobile_phone()));
        reader = rootReader.newObjectReader("moblie_email");
        m.setMoblie_email(decoder0.decode(reader, m.getMoblie_email()));
        reader = rootReader.newObjectReader("phone");
        m.setPhone(decoder0.decode(reader, m.getPhone()));
        reader = rootReader.newObjectReader("promoterRef");
        decoder0.decode(reader, m.getPromoterRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("promoter_member_no");
        m.setPromoter_member_no(decoder0.decode(reader, m.getPromoter_member_no()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        return m;
    }
}