package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 11:02:01")
/** */
public final class WaterWatchUserMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.WaterWatchUser> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterWatchUser> no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterWatchUser>(this, "no", "no");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterWatchUser, org.slim3.datastore.ModelRef<net.clearwaterproject.model.User>, net.clearwaterproject.model.User> user = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterWatchUser, org.slim3.datastore.ModelRef<net.clearwaterproject.model.User>, net.clearwaterproject.model.User>(this, "user", "user", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterWatchUser, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterWatchUser, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfo>, net.clearwaterproject.model.WaterInfo> waterInfoRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterWatchUser, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfo>, net.clearwaterproject.model.WaterInfo>(this, "waterInfoRef", "waterInfoRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.WaterInfo.class);

    private static final WaterWatchUserMeta slim3_singleton = new WaterWatchUserMeta();

    /**
     * @return the singleton
     */
    public static WaterWatchUserMeta get() {
       return slim3_singleton;
    }

    /** */
    public WaterWatchUserMeta() {
        super("WaterWatchUser", net.clearwaterproject.model.WaterWatchUser.class);
    }

    @Override
    public net.clearwaterproject.model.WaterWatchUser entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.WaterWatchUser model = new net.clearwaterproject.model.WaterWatchUser();
        model.setKey(entity.getKey());
        model.setNo((java.lang.String) entity.getProperty("no"));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        if (model.getUser() == null) {
            throw new NullPointerException("The property(user) is null.");
        }
        model.getUser().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("user"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        if (model.getWaterInfoRef() == null) {
            throw new NullPointerException("The property(waterInfoRef) is null.");
        }
        model.getWaterInfoRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("waterInfoRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("no", m.getNo());
        entity.setProperty("regist_date", m.getRegist_date());
        if (m.getUser() == null) {
            throw new NullPointerException("The property(user) must not be null.");
        }
        entity.setProperty("user", m.getUser().getKey());
        entity.setProperty("version", m.getVersion());
        if (m.getWaterInfoRef() == null) {
            throw new NullPointerException("The property(waterInfoRef) must not be null.");
        }
        entity.setProperty("waterInfoRef", m.getWaterInfoRef().getKey());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        if (m.getUser() == null) {
            throw new NullPointerException("The property(user) must not be null.");
        }
        m.getUser().assignKeyIfNecessary(ds);
        if (m.getWaterInfoRef() == null) {
            throw new NullPointerException("The property(waterInfoRef) must not be null.");
        }
        m.getWaterInfoRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
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
        net.clearwaterproject.model.WaterWatchUser m = (net.clearwaterproject.model.WaterWatchUser) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getNo() != null){
            writer.setNextPropertyName("no");
            encoder0.encode(writer, m.getNo());
        }
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        org.slim3.datastore.json.Expanded encoder1 = new org.slim3.datastore.json.Expanded();
        if(m.getUser() != null && m.getUser().getKey() != null){
            writer.setNextPropertyName("user");
            encoder1.encode(writer, m.getUser(), maxDepth, currentDepth);
        }
        if(m.getWaterInfoRef() != null && m.getWaterInfoRef().getKey() != null){
            writer.setNextPropertyName("waterInfoRef");
            encoder0.encode(writer, m.getWaterInfoRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.WaterWatchUser jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.WaterWatchUser m = new net.clearwaterproject.model.WaterWatchUser();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("no");
        m.setNo(decoder0.decode(reader, m.getNo()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("user");
        org.slim3.datastore.json.Expanded decoder1 = new org.slim3.datastore.json.Expanded();
        decoder1.decode(reader, m.getUser(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("waterInfoRef");
        decoder0.decode(reader, m.getWaterInfoRef(), maxDepth, currentDepth);
        return m;
    }
}