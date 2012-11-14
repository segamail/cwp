package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 10:32:46")
/** */
public final class WaterInfoPictureMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.WaterInfoPicture> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, com.google.appengine.api.blobstore.BlobKey> blobKey = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, com.google.appengine.api.blobstore.BlobKey>(this, "blobKey", "blobKey", com.google.appengine.api.blobstore.BlobKey.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture> no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture>(this, "no", "no");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture> normal_serving_url = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture>(this, "normal_serving_url", "normal_serving_url");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture> small_serving_url = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoPicture>(this, "small_serving_url", "small_serving_url");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfo>, net.clearwaterproject.model.WaterInfo> waterInfoRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfoPicture, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfo>, net.clearwaterproject.model.WaterInfo>(this, "waterInfoRef", "waterInfoRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.WaterInfo.class);

    private static final WaterInfoPictureMeta slim3_singleton = new WaterInfoPictureMeta();

    /**
     * @return the singleton
     */
    public static WaterInfoPictureMeta get() {
       return slim3_singleton;
    }

    /** */
    public WaterInfoPictureMeta() {
        super("WaterInfoPicture", net.clearwaterproject.model.WaterInfoPicture.class);
    }

    @Override
    public net.clearwaterproject.model.WaterInfoPicture entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.WaterInfoPicture model = new net.clearwaterproject.model.WaterInfoPicture();
        model.setBlobKey((com.google.appengine.api.blobstore.BlobKey) entity.getProperty("blobKey"));
        model.setKey(entity.getKey());
        model.setNo((java.lang.String) entity.getProperty("no"));
        model.setNormal_serving_url((java.lang.String) entity.getProperty("normal_serving_url"));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setSmall_serving_url((java.lang.String) entity.getProperty("small_serving_url"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        if (model.getWaterInfoRef() == null) {
            throw new NullPointerException("The property(waterInfoRef) is null.");
        }
        model.getWaterInfoRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("waterInfoRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("blobKey", m.getBlobKey());
        entity.setProperty("no", m.getNo());
        entity.setProperty("normal_serving_url", m.getNormal_serving_url());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("small_serving_url", m.getSmall_serving_url());
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
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        if (m.getWaterInfoRef() == null) {
            throw new NullPointerException("The property(waterInfoRef) must not be null.");
        }
        m.getWaterInfoRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
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
        net.clearwaterproject.model.WaterInfoPicture m = (net.clearwaterproject.model.WaterInfoPicture) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getBlobKey() != null){
            writer.setNextPropertyName("blobKey");
            encoder0.encode(writer, m.getBlobKey());
        }
        if(m.getNo() != null){
            writer.setNextPropertyName("no");
            encoder0.encode(writer, m.getNo());
        }
        if(m.getNormal_serving_url() != null){
            writer.setNextPropertyName("normal_serving_url");
            encoder0.encode(writer, m.getNormal_serving_url());
        }
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        if(m.getSmall_serving_url() != null){
            writer.setNextPropertyName("small_serving_url");
            encoder0.encode(writer, m.getSmall_serving_url());
        }
        if(m.getWaterInfoRef() != null && m.getWaterInfoRef().getKey() != null){
            writer.setNextPropertyName("waterInfoRef");
            encoder0.encode(writer, m.getWaterInfoRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.WaterInfoPicture jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.WaterInfoPicture m = new net.clearwaterproject.model.WaterInfoPicture();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("blobKey");
        m.setBlobKey(decoder0.decode(reader, m.getBlobKey()));
        reader = rootReader.newObjectReader("no");
        m.setNo(decoder0.decode(reader, m.getNo()));
        reader = rootReader.newObjectReader("normal_serving_url");
        m.setNormal_serving_url(decoder0.decode(reader, m.getNormal_serving_url()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("small_serving_url");
        m.setSmall_serving_url(decoder0.decode(reader, m.getSmall_serving_url()));
        reader = rootReader.newObjectReader("waterInfoRef");
        decoder0.decode(reader, m.getWaterInfoRef(), maxDepth, currentDepth);
        return m;
    }
}