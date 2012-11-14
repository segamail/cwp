package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-08 15:11:59")
/** */
public final class WaterInfoGeoHexMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.WaterInfoGeoHex> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Double> lat = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Double>(this, "lat", "lat", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Integer> level = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Integer>(this, "level", "level", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Double> lng = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Double>(this, "lng", "lng", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex> zone = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfoGeoHex>(this, "zone", "zone");

    private static final WaterInfoGeoHexMeta slim3_singleton = new WaterInfoGeoHexMeta();

    /**
     * @return the singleton
     */
    public static WaterInfoGeoHexMeta get() {
       return slim3_singleton;
    }

    /** */
    public WaterInfoGeoHexMeta() {
        super("WaterInfoGeoHex", net.clearwaterproject.model.WaterInfoGeoHex.class);
    }

    @Override
    public net.clearwaterproject.model.WaterInfoGeoHex entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.WaterInfoGeoHex model = new net.clearwaterproject.model.WaterInfoGeoHex();
        model.setKey(entity.getKey());
        model.setLat(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lat")));
        model.setLevel(longToPrimitiveInt((java.lang.Long) entity.getProperty("level")));
        model.setLng(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lng")));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setZone((java.lang.String) entity.getProperty("zone"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("lat", m.getLat());
        entity.setProperty("level", m.getLevel());
        entity.setProperty("lng", m.getLng());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("zone", m.getZone());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
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
        net.clearwaterproject.model.WaterInfoGeoHex m = (net.clearwaterproject.model.WaterInfoGeoHex) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("cod");
        encoder0.encode(writer, m.getCod());
        writer.setNextPropertyName("lat");
        encoder0.encode(writer, m.getLat());
        writer.setNextPropertyName("level");
        encoder0.encode(writer, m.getLevel());
        writer.setNextPropertyName("lng");
        encoder0.encode(writer, m.getLng());
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        if(m.getZone() != null){
            writer.setNextPropertyName("zone");
            encoder0.encode(writer, m.getZone());
        }
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.WaterInfoGeoHex jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.WaterInfoGeoHex m = new net.clearwaterproject.model.WaterInfoGeoHex();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("cod");
        m.setCod(decoder0.decode(reader, m.getCod()));
        reader = rootReader.newObjectReader("lat");
        m.setLat(decoder0.decode(reader, m.getLat()));
        reader = rootReader.newObjectReader("level");
        m.setLevel(decoder0.decode(reader, m.getLevel()));
        reader = rootReader.newObjectReader("lng");
        m.setLng(decoder0.decode(reader, m.getLng()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("zone");
        m.setZone(decoder0.decode(reader, m.getZone()));
        return m;
    }
}