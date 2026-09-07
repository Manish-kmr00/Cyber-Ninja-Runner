package io.bidmachine.utils.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class MapDataRetriever<K> implements DataRetriever<K> {
    private final DataConverter dataConverter;
    private final Map<K, Object> params;

    public MapDataRetriever() {
        this(new ConcurrentHashMap(), new SmartDataConverter());
    }

    public MapDataRetriever(Map<K, Object> map, DataConverter dataConverter) {
        this.params = map;
        this.dataConverter = dataConverter;
    }

    public Map<K, Object> getParams() {
        return this.params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setParams(Map<K, Object> map) {
        clear();
        if (map != 0) {
            getParams().putAll(map);
        }
    }

    public void put(K k, Object obj) {
        getParams().put(k, obj);
    }

    public void clear() {
        getParams().clear();
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public boolean contains(K k) {
        return getParams().containsKey(k);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public String getStringOrNull(K k, String str) {
        return this.dataConverter.toStringOrNull(getObjectOrNull(k, str), str);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public boolean getBoolean(K k, boolean z) {
        return this.dataConverter.toBoolean(getObjectOrNull(k, Boolean.valueOf(z)), z);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Boolean getBooleanOrNull(K k, Boolean bool) {
        return this.dataConverter.toBooleanOrNull(getObjectOrNull(k, bool), bool);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public int getInteger(K k, int i) {
        return this.dataConverter.toInteger(getObjectOrNull(k, Integer.valueOf(i)), i);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Integer getIntegerOrNull(K k, Integer num) {
        return this.dataConverter.toIntegerOrNull(getObjectOrNull(k, num), num);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public float getFloat(K k, float f) {
        return this.dataConverter.toFloat(getObjectOrNull(k, Float.valueOf(f)), f);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Float getFloatOrNull(K k, Float f) {
        return this.dataConverter.toFloatOrNull(getObjectOrNull(k, f), f);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public double getDouble(K k, double d) {
        return this.dataConverter.toDouble(getObjectOrNull(k, Double.valueOf(d)), d);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Double getDoubleOrNull(K k, Double d) {
        return this.dataConverter.toDoubleOrNull(getObjectOrNull(k, d), d);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public List<Object> getListOrNull(K k) {
        return this.dataConverter.toListOrNull(getObjectOrNull(k, null));
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Map<Object, Object> getMapOrNull(K k) {
        return this.dataConverter.toMapOrNull(getObjectOrNull(k, null));
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public <T> T getOrNull(K k, T t) throws Exception {
        return (T) this.dataConverter.toOrNull(getObjectOrNull(k, t), t);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Object getObjectOrNull(K k, Object obj) {
        return contains(k) ? getParams().get(k) : obj;
    }
}
