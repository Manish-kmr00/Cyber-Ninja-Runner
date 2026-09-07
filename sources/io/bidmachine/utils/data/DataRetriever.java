package io.bidmachine.utils.data;

import io.bidmachine.Function;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface DataRetriever<K> {
    boolean contains(K k);

    boolean getBoolean(K k, boolean z);

    Boolean getBooleanOrNull(K k, Boolean bool);

    double getDouble(K k, double d);

    Double getDoubleOrNull(K k, Double d);

    float getFloat(K k, float f);

    Float getFloatOrNull(K k, Float f);

    int getInteger(K k, int i);

    Integer getIntegerOrNull(K k, Integer num);

    List<Object> getListOrNull(K k);

    Map<Object, Object> getMapOrNull(K k);

    Object getObjectOrNull(K k, Object obj);

    <T> T getOrNull(K k, T t) throws Exception;

    String getStringOrNull(K k, String str);

    default String getStringOrNull(K k) {
        return getStringOrNull(k, null);
    }

    default boolean getBoolean(K k) {
        return getBoolean(k, false);
    }

    default Boolean getBooleanOrNull(K k) {
        return getBooleanOrNull(k, false);
    }

    default int getInteger(K k) {
        return getInteger(k, 0);
    }

    default Integer getIntegerOrNull(K k) {
        return getIntegerOrNull(k, null);
    }

    default float getFloat(K k) {
        return getFloat(k, 0.0f);
    }

    default Float getFloatOrNull(K k) {
        return getFloatOrNull(k, null);
    }

    default double getDouble(K k) {
        return getDouble(k, 0.0d);
    }

    default Double getDoubleOrNull(K k) {
        return getDoubleOrNull(k, null);
    }

    default <T> T getOrNull(K k) throws Exception {
        return (T) getOrNull(k, null);
    }

    default <T> T getOrNullSafely(K k, Function<Object, T> function) {
        return (T) getOrNullSafely(k, null, function);
    }

    default <T> T getOrNullSafely(K k, T t, Function<Object, T> function) {
        try {
            Object objectOrNull = getObjectOrNull(k, t);
            if (objectOrNull == null) {
                return null;
            }
            return function.apply(objectOrNull);
        } catch (Exception unused) {
            return t;
        }
    }

    default Object getObjectOrNull(K k) {
        return getObjectOrNull(k, null);
    }
}
