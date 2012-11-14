package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-08 15:12:21")
/** */
public final class WaterInfoDtlMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.WaterInfoDtl> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, java.lang.Double> Ammonia = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, java.lang.Double>(this, "Ammonia", "Ammonia", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoDtl> no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoDtl>(this, "no", "no");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoDtl> taste = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoDtl>(this, "taste", "taste");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoDtl, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final WaterInfoDtlMeta slim3_singleton = new WaterInfoDtlMeta();

    /**
     * @return the singleton
     */
    public static WaterInfoDtlMeta get() {
       return slim3_singleton;
    }

    /** */
    public WaterInfoDtlMeta() {
        super("WaterInfoDtl", net.clearwaterproject.model.WaterInfoDtl.class);
    }

    @Override
    public net.clearwaterproject.model.WaterInfoDtl entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.WaterInfoDtl model = new net.clearwaterproject.model.WaterInfoDtl();
        model.setAmmonia(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("Ammonia")));
        model.setKey(entity.getKey());
        model.setNo((java.lang.String) entity.getProperty("no"));
        model.setTaste((java.lang.String) entity.getProperty("taste"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("Ammonia", m.getAmmonia());
        entity.setProperty("no", m.getNo());
        entity.setProperty("taste", m.getTaste());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
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
        net.clearwaterproject.model.WaterInfoDtl m = (net.clearwaterproject.model.WaterInfoDtl) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("Ammonia");
        encoder0.encode(writer, m.getAmmonia());
        if(m.getNo() != null){
            writer.setNextPropertyName("no");
            encoder0.encode(writer, m.getNo());
        }
        if(m.getTaste() != null){
            writer.setNextPropertyName("taste");
            encoder0.encode(writer, m.getTaste());
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.WaterInfoDtl jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.WaterInfoDtl m = new net.clearwaterproject.model.WaterInfoDtl();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("Ammonia");
        m.setAmmonia(decoder0.decode(reader, m.getAmmonia()));
        reader = rootReader.newObjectReader("no");
        m.setNo(decoder0.decode(reader, m.getNo()));
        reader = rootReader.newObjectReader("taste");
        m.setTaste(decoder0.decode(reader, m.getTaste()));
        return m;
    }
}