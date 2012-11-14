package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-11 21:55:03")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.User> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> address = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "address", "address");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.util.Date> birth = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.util.Date>(this, "birth", "birth", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> cwp_user_no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "cwp_user_no", "cwp_user_no");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> facebook_id = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "facebook_id", "facebook_id");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> first_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "first_name", "first_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> first_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "first_name_kn", "first_name_kn");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Integer> first_use = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Integer>(this, "first_use", "first_use", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> gender = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "gender", "gender");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> last_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "last_name", "last_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> last_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "last_name_kn", "last_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> login_type = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "login_type", "login_type");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> middle_name = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "middle_name", "middle_name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> middle_name_kn = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "middle_name_kn", "middle_name_kn");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User> moblile_email = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.User>(this, "moblile_email", "moblile_email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Long> phone = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Long>(this, "phone", "phone", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Integer> post = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Integer>(this, "post", "post", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.User, org.slim3.datastore.ModelRef<net.clearwaterproject.model.UserPicture>, net.clearwaterproject.model.UserPicture> userPicRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.User, org.slim3.datastore.ModelRef<net.clearwaterproject.model.UserPicture>, net.clearwaterproject.model.UserPicture>(this, "userPicRef", "userPicRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.UserPicture.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.ModificationDate slim3_regist_dateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", net.clearwaterproject.model.User.class);
    }

    @Override
    public net.clearwaterproject.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.User model = new net.clearwaterproject.model.User();
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setBirth((java.util.Date) entity.getProperty("birth"));
        model.setCwp_user_no((java.lang.String) entity.getProperty("cwp_user_no"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFacebook_id((java.lang.String) entity.getProperty("facebook_id"));
        model.setFirst_name((java.lang.String) entity.getProperty("first_name"));
        model.setFirst_name_kn((java.lang.String) entity.getProperty("first_name_kn"));
        model.setFirst_use(longToPrimitiveInt((java.lang.Long) entity.getProperty("first_use")));
        model.setGender((java.lang.String) entity.getProperty("gender"));
        model.setKey(entity.getKey());
        model.setLast_name((java.lang.String) entity.getProperty("last_name"));
        model.setLast_name_kn((java.lang.String) entity.getProperty("last_name_kn"));
        model.setLogin_type((java.lang.String) entity.getProperty("login_type"));
        model.setMiddle_name((java.lang.String) entity.getProperty("middle_name"));
        model.setMiddle_name_kn((java.lang.String) entity.getProperty("middle_name_kn"));
        model.setMoblile_email((java.lang.String) entity.getProperty("moblile_email"));
        model.setPhone(longToPrimitiveLong((java.lang.Long) entity.getProperty("phone")));
        model.setPost(longToPrimitiveInt((java.lang.Long) entity.getProperty("post")));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        if (model.getUserPicRef() == null) {
            throw new NullPointerException("The property(userPicRef) is null.");
        }
        model.getUserPicRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userPicRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("address", m.getAddress());
        entity.setProperty("birth", m.getBirth());
        entity.setProperty("cwp_user_no", m.getCwp_user_no());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("facebook_id", m.getFacebook_id());
        entity.setProperty("first_name", m.getFirst_name());
        entity.setProperty("first_name_kn", m.getFirst_name_kn());
        entity.setProperty("first_use", m.getFirst_use());
        entity.setProperty("gender", m.getGender());
        entity.setProperty("last_name", m.getLast_name());
        entity.setProperty("last_name_kn", m.getLast_name_kn());
        entity.setProperty("login_type", m.getLogin_type());
        entity.setProperty("middle_name", m.getMiddle_name());
        entity.setProperty("middle_name_kn", m.getMiddle_name_kn());
        entity.setProperty("moblile_email", m.getMoblile_email());
        entity.setProperty("phone", m.getPhone());
        entity.setProperty("post", m.getPost());
        entity.setProperty("regist_date", m.getRegist_date());
        if (m.getUserPicRef() == null) {
            throw new NullPointerException("The property(userPicRef) must not be null.");
        }
        entity.setProperty("userPicRef", m.getUserPicRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        if (m.getUserPicRef() == null) {
            throw new NullPointerException("The property(userPicRef) must not be null.");
        }
        m.getUserPicRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        m.setRegist_date(slim3_regist_dateAttributeListener.prePut(m.getRegist_date()));
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
        net.clearwaterproject.model.User m = (net.clearwaterproject.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getBirth() != null){
            writer.setNextPropertyName("birth");
            encoder0.encode(writer, m.getBirth());
        }
        if(m.getCwp_user_no() != null){
            writer.setNextPropertyName("cwp_user_no");
            encoder0.encode(writer, m.getCwp_user_no());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getFacebook_id() != null){
            writer.setNextPropertyName("facebook_id");
            encoder0.encode(writer, m.getFacebook_id());
        }
        if(m.getFirst_name() != null){
            writer.setNextPropertyName("first_name");
            encoder0.encode(writer, m.getFirst_name());
        }
        if(m.getFirst_name_kn() != null){
            writer.setNextPropertyName("first_name_kn");
            encoder0.encode(writer, m.getFirst_name_kn());
        }
        writer.setNextPropertyName("first_use");
        encoder0.encode(writer, m.getFirst_use());
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
        if(m.getLogin_type() != null){
            writer.setNextPropertyName("login_type");
            encoder0.encode(writer, m.getLogin_type());
        }
        if(m.getMiddle_name() != null){
            writer.setNextPropertyName("middle_name");
            encoder0.encode(writer, m.getMiddle_name());
        }
        if(m.getMiddle_name_kn() != null){
            writer.setNextPropertyName("middle_name_kn");
            encoder0.encode(writer, m.getMiddle_name_kn());
        }
        if(m.getMoblile_email() != null){
            writer.setNextPropertyName("moblile_email");
            encoder0.encode(writer, m.getMoblile_email());
        }
        writer.setNextPropertyName("phone");
        encoder0.encode(writer, m.getPhone());
        writer.setNextPropertyName("post");
        encoder0.encode(writer, m.getPost());
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        org.slim3.datastore.json.Expanded encoder1 = new org.slim3.datastore.json.Expanded();
        if(m.getUserPicRef() != null && m.getUserPicRef().getKey() != null){
            writer.setNextPropertyName("userPicRef");
            encoder1.encode(writer, m.getUserPicRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.User m = new net.clearwaterproject.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("birth");
        m.setBirth(decoder0.decode(reader, m.getBirth()));
        reader = rootReader.newObjectReader("cwp_user_no");
        m.setCwp_user_no(decoder0.decode(reader, m.getCwp_user_no()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("facebook_id");
        m.setFacebook_id(decoder0.decode(reader, m.getFacebook_id()));
        reader = rootReader.newObjectReader("first_name");
        m.setFirst_name(decoder0.decode(reader, m.getFirst_name()));
        reader = rootReader.newObjectReader("first_name_kn");
        m.setFirst_name_kn(decoder0.decode(reader, m.getFirst_name_kn()));
        reader = rootReader.newObjectReader("first_use");
        m.setFirst_use(decoder0.decode(reader, m.getFirst_use()));
        reader = rootReader.newObjectReader("gender");
        m.setGender(decoder0.decode(reader, m.getGender()));
        reader = rootReader.newObjectReader("last_name");
        m.setLast_name(decoder0.decode(reader, m.getLast_name()));
        reader = rootReader.newObjectReader("last_name_kn");
        m.setLast_name_kn(decoder0.decode(reader, m.getLast_name_kn()));
        reader = rootReader.newObjectReader("login_type");
        m.setLogin_type(decoder0.decode(reader, m.getLogin_type()));
        reader = rootReader.newObjectReader("middle_name");
        m.setMiddle_name(decoder0.decode(reader, m.getMiddle_name()));
        reader = rootReader.newObjectReader("middle_name_kn");
        m.setMiddle_name_kn(decoder0.decode(reader, m.getMiddle_name_kn()));
        reader = rootReader.newObjectReader("moblile_email");
        m.setMoblile_email(decoder0.decode(reader, m.getMoblile_email()));
        reader = rootReader.newObjectReader("phone");
        m.setPhone(decoder0.decode(reader, m.getPhone()));
        reader = rootReader.newObjectReader("post");
        m.setPost(decoder0.decode(reader, m.getPost()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("userPicRef");
        org.slim3.datastore.json.Expanded decoder1 = new org.slim3.datastore.json.Expanded();
        decoder1.decode(reader, m.getUserPicRef(), maxDepth, currentDepth);
        return m;
    }
}