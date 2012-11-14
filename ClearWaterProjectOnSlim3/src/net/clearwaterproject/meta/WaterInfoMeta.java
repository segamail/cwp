package net.clearwaterproject.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-11-14 11:02:03")
/** */
public final class WaterInfoMeta extends org.slim3.datastore.ModelMeta<net.clearwaterproject.model.WaterInfo> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long> add_cooment_cnt = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long>(this, "add_cooment_cnt", "add_cooment_cnt", long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.User>, net.clearwaterproject.model.User> applyUser = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.User>, net.clearwaterproject.model.User>(this, "applyUser", "applyUser", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.util.Date> apply_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.util.Date>(this, "apply_date", "apply_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> bod = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "bod", "bod", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> clarity = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "clarity", "clarity", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> cod = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "cod", "cod", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> colour = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "colour", "colour", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfo> comment = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfo>(this, "comment", "comment");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer> country = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer>(this, "country", "country", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfoDtl>, net.clearwaterproject.model.WaterInfoDtl> dtl = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfoDtl>, net.clearwaterproject.model.WaterInfoDtl>(this, "dtl", "dtl", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.WaterInfoDtl.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> iron = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "iron", "iron", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> lat = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "lat", "lat", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> lng = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "lng", "lng", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> manganese = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "manganese", "manganese", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> nitrate = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "nitrate", "nitrate", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfo> no = new org.slim3.datastore.StringAttributeMeta<net.clearwaterproject.model.WaterInfo>(this, "no", "no");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> odour = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "odour", "odour", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> pH = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "pH", "pH", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.util.Date> regist_date = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.util.Date>(this, "regist_date", "regist_date", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> transparency = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "transparency", "transparency", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double> turbidity = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Double>(this, "turbidity", "turbidity", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long> watch_user_cnt = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Long>(this, "watch_user_cnt", "watch_user_cnt", long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfoGeoHex>, net.clearwaterproject.model.WaterInfoGeoHex> waterInfoGHRef = new org.slim3.datastore.ModelRefAttributeMeta<net.clearwaterproject.model.WaterInfo, org.slim3.datastore.ModelRef<net.clearwaterproject.model.WaterInfoGeoHex>, net.clearwaterproject.model.WaterInfoGeoHex>(this, "waterInfoGHRef", "waterInfoGHRef", org.slim3.datastore.ModelRef.class, net.clearwaterproject.model.WaterInfoGeoHex.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer> water_temperature = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer>(this, "water_temperature", "water_temperature", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer> weather_id = new org.slim3.datastore.CoreAttributeMeta<net.clearwaterproject.model.WaterInfo, java.lang.Integer>(this, "weather_id", "weather_id", int.class);

    private static final WaterInfoMeta slim3_singleton = new WaterInfoMeta();

    /**
     * @return the singleton
     */
    public static WaterInfoMeta get() {
       return slim3_singleton;
    }

    /** */
    public WaterInfoMeta() {
        super("WaterInfo", net.clearwaterproject.model.WaterInfo.class);
    }

    @Override
    public net.clearwaterproject.model.WaterInfo entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.clearwaterproject.model.WaterInfo model = new net.clearwaterproject.model.WaterInfo();
        model.setAdd_cooment_cnt(longToPrimitiveLong((java.lang.Long) entity.getProperty("add_cooment_cnt")));
        if (model.getApplyUser() == null) {
            throw new NullPointerException("The property(applyUser) is null.");
        }
        model.getApplyUser().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("applyUser"));
        model.setApply_date((java.util.Date) entity.getProperty("apply_date"));
        model.setBod(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("bod")));
        model.setClarity(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("clarity")));
        model.setCod(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("cod")));
        model.setColour(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("colour")));
        model.setComment((java.lang.String) entity.getProperty("comment"));
        model.setCountry(longToPrimitiveInt((java.lang.Long) entity.getProperty("country")));
        if (model.getDtl() == null) {
            throw new NullPointerException("The property(dtl) is null.");
        }
        model.getDtl().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("dtl"));
        model.setIron(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("iron")));
        model.setKey(entity.getKey());
        model.setLat(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lat")));
        model.setLng(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lng")));
        model.setManganese(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("manganese")));
        model.setNitrate(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("nitrate")));
        model.setNo((java.lang.String) entity.getProperty("no"));
        model.setOdour(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("odour")));
        model.setPH(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("pH")));
        model.setRegist_date((java.util.Date) entity.getProperty("regist_date"));
        model.setTransparency(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("transparency")));
        model.setTurbidity(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("turbidity")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setWatch_user_cnt(longToPrimitiveLong((java.lang.Long) entity.getProperty("watch_user_cnt")));
        if (model.getWaterInfoGHRef() == null) {
            throw new NullPointerException("The property(waterInfoGHRef) is null.");
        }
        model.getWaterInfoGHRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("waterInfoGHRef"));
        model.setWater_temperature(longToPrimitiveInt((java.lang.Long) entity.getProperty("water_temperature")));
        model.setWeather_id(longToPrimitiveInt((java.lang.Long) entity.getProperty("weather_id")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("add_cooment_cnt", m.getAdd_cooment_cnt());
        if (m.getApplyUser() == null) {
            throw new NullPointerException("The property(applyUser) must not be null.");
        }
        entity.setProperty("applyUser", m.getApplyUser().getKey());
        entity.setProperty("apply_date", m.getApply_date());
        entity.setProperty("bod", m.getBod());
        entity.setProperty("clarity", m.getClarity());
        entity.setProperty("cod", m.getCod());
        entity.setProperty("colour", m.getColour());
        entity.setProperty("comment", m.getComment());
        entity.setProperty("country", m.getCountry());
        if (m.getDtl() == null) {
            throw new NullPointerException("The property(dtl) must not be null.");
        }
        entity.setProperty("dtl", m.getDtl().getKey());
        entity.setProperty("iron", m.getIron());
        entity.setProperty("lat", m.getLat());
        entity.setProperty("lng", m.getLng());
        entity.setProperty("manganese", m.getManganese());
        entity.setProperty("nitrate", m.getNitrate());
        entity.setProperty("no", m.getNo());
        entity.setProperty("odour", m.getOdour());
        entity.setProperty("pH", m.getPH());
        entity.setProperty("regist_date", m.getRegist_date());
        entity.setProperty("transparency", m.getTransparency());
        entity.setProperty("turbidity", m.getTurbidity());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("watch_user_cnt", m.getWatch_user_cnt());
        if (m.getWaterInfoGHRef() == null) {
            throw new NullPointerException("The property(waterInfoGHRef) must not be null.");
        }
        entity.setProperty("waterInfoGHRef", m.getWaterInfoGHRef().getKey());
        entity.setProperty("water_temperature", m.getWater_temperature());
        entity.setProperty("weather_id", m.getWeather_id());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        if (m.getApplyUser() == null) {
            throw new NullPointerException("The property(applyUser) must not be null.");
        }
        m.getApplyUser().assignKeyIfNecessary(ds);
        if (m.getDtl() == null) {
            throw new NullPointerException("The property(dtl) must not be null.");
        }
        m.getDtl().assignKeyIfNecessary(ds);
        if (m.getWaterInfoGHRef() == null) {
            throw new NullPointerException("The property(waterInfoGHRef) must not be null.");
        }
        m.getWaterInfoGHRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
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
        net.clearwaterproject.model.WaterInfo m = (net.clearwaterproject.model.WaterInfo) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("add_cooment_cnt");
        encoder0.encode(writer, m.getAdd_cooment_cnt());
        org.slim3.datastore.json.Expanded encoder1 = new org.slim3.datastore.json.Expanded();
        if(m.getApplyUser() != null && m.getApplyUser().getKey() != null){
            writer.setNextPropertyName("applyUser");
            encoder1.encode(writer, m.getApplyUser(), maxDepth, currentDepth);
        }
        if(m.getApply_date() != null){
            writer.setNextPropertyName("apply_date");
            encoder0.encode(writer, m.getApply_date());
        }
        writer.setNextPropertyName("bod");
        encoder0.encode(writer, m.getBod());
        writer.setNextPropertyName("clarity");
        encoder0.encode(writer, m.getClarity());
        writer.setNextPropertyName("cod");
        encoder0.encode(writer, m.getCod());
        writer.setNextPropertyName("colour");
        encoder0.encode(writer, m.getColour());
        if(m.getComment() != null){
            writer.setNextPropertyName("comment");
            encoder0.encode(writer, m.getComment());
        }
        writer.setNextPropertyName("country");
        encoder0.encode(writer, m.getCountry());
        if(m.getDtl() != null && m.getDtl().getKey() != null){
            writer.setNextPropertyName("dtl");
            encoder1.encode(writer, m.getDtl(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("iron");
        encoder0.encode(writer, m.getIron());
        writer.setNextPropertyName("lat");
        encoder0.encode(writer, m.getLat());
        writer.setNextPropertyName("lng");
        encoder0.encode(writer, m.getLng());
        writer.setNextPropertyName("manganese");
        encoder0.encode(writer, m.getManganese());
        writer.setNextPropertyName("nitrate");
        encoder0.encode(writer, m.getNitrate());
        if(m.getNo() != null){
            writer.setNextPropertyName("no");
            encoder0.encode(writer, m.getNo());
        }
        writer.setNextPropertyName("odour");
        encoder0.encode(writer, m.getOdour());
        writer.setNextPropertyName("pH");
        encoder0.encode(writer, m.getPH());
        if(m.getRegist_date() != null){
            writer.setNextPropertyName("regist_date");
            encoder0.encode(writer, m.getRegist_date());
        }
        writer.setNextPropertyName("transparency");
        encoder0.encode(writer, m.getTransparency());
        writer.setNextPropertyName("turbidity");
        encoder0.encode(writer, m.getTurbidity());
        writer.setNextPropertyName("watch_user_cnt");
        encoder0.encode(writer, m.getWatch_user_cnt());
        if(m.getWaterAddCommentListRef() != null && getKey(m) != null){
            writer.setNextPropertyName("waterAddCommentListRef");
            encoder1.encode(writer, m.getWaterAddCommentListRef(), maxDepth, currentDepth);
        }
        if(m.getWaterInfoGHRef() != null && m.getWaterInfoGHRef().getKey() != null){
            writer.setNextPropertyName("waterInfoGHRef");
            encoder1.encode(writer, m.getWaterInfoGHRef(), maxDepth, currentDepth);
        }
        if(m.getWaterInfoPicListRef() != null && getKey(m) != null){
            writer.setNextPropertyName("waterInfoPicListRef");
            encoder1.encode(writer, m.getWaterInfoPicListRef(), maxDepth, currentDepth);
        }
        if(m.getWaterWatchUserListRef() != null && getKey(m) != null){
            writer.setNextPropertyName("waterWatchUserListRef");
            encoder1.encode(writer, m.getWaterWatchUserListRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("water_temperature");
        encoder0.encode(writer, m.getWater_temperature());
        writer.setNextPropertyName("weather_id");
        encoder0.encode(writer, m.getWeather_id());
        writer.endObject();
    }

    @Override
    protected net.clearwaterproject.model.WaterInfo jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.clearwaterproject.model.WaterInfo m = new net.clearwaterproject.model.WaterInfo();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("add_cooment_cnt");
        m.setAdd_cooment_cnt(decoder0.decode(reader, m.getAdd_cooment_cnt()));
        reader = rootReader.newObjectReader("applyUser");
        org.slim3.datastore.json.Expanded decoder1 = new org.slim3.datastore.json.Expanded();
        decoder1.decode(reader, m.getApplyUser(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("apply_date");
        m.setApply_date(decoder0.decode(reader, m.getApply_date()));
        reader = rootReader.newObjectReader("bod");
        m.setBod(decoder0.decode(reader, m.getBod()));
        reader = rootReader.newObjectReader("clarity");
        m.setClarity(decoder0.decode(reader, m.getClarity()));
        reader = rootReader.newObjectReader("cod");
        m.setCod(decoder0.decode(reader, m.getCod()));
        reader = rootReader.newObjectReader("colour");
        m.setColour(decoder0.decode(reader, m.getColour()));
        reader = rootReader.newObjectReader("comment");
        m.setComment(decoder0.decode(reader, m.getComment()));
        reader = rootReader.newObjectReader("country");
        m.setCountry(decoder0.decode(reader, m.getCountry()));
        reader = rootReader.newObjectReader("dtl");
        decoder1.decode(reader, m.getDtl(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("iron");
        m.setIron(decoder0.decode(reader, m.getIron()));
        reader = rootReader.newObjectReader("lat");
        m.setLat(decoder0.decode(reader, m.getLat()));
        reader = rootReader.newObjectReader("lng");
        m.setLng(decoder0.decode(reader, m.getLng()));
        reader = rootReader.newObjectReader("manganese");
        m.setManganese(decoder0.decode(reader, m.getManganese()));
        reader = rootReader.newObjectReader("nitrate");
        m.setNitrate(decoder0.decode(reader, m.getNitrate()));
        reader = rootReader.newObjectReader("no");
        m.setNo(decoder0.decode(reader, m.getNo()));
        reader = rootReader.newObjectReader("odour");
        m.setOdour(decoder0.decode(reader, m.getOdour()));
        reader = rootReader.newObjectReader("pH");
        m.setPH(decoder0.decode(reader, m.getPH()));
        reader = rootReader.newObjectReader("regist_date");
        m.setRegist_date(decoder0.decode(reader, m.getRegist_date()));
        reader = rootReader.newObjectReader("transparency");
        m.setTransparency(decoder0.decode(reader, m.getTransparency()));
        reader = rootReader.newObjectReader("turbidity");
        m.setTurbidity(decoder0.decode(reader, m.getTurbidity()));
        reader = rootReader.newObjectReader("watch_user_cnt");
        m.setWatch_user_cnt(decoder0.decode(reader, m.getWatch_user_cnt()));
        reader = rootReader.newObjectReader("waterInfoGHRef");
        decoder1.decode(reader, m.getWaterInfoGHRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("water_temperature");
        m.setWater_temperature(decoder0.decode(reader, m.getWater_temperature()));
        reader = rootReader.newObjectReader("weather_id");
        m.setWeather_id(decoder0.decode(reader, m.getWeather_id()));
        return m;
    }
}