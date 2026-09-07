package io.bidmachine.utils.data;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface DataConverter {
    Boolean toBooleanOrNull(Object obj, Boolean bool);

    Double toDoubleOrNull(Object obj, Double d);

    Float toFloatOrNull(Object obj, Float f);

    Integer toIntegerOrNull(Object obj, Integer num);

    List<Object> toListOrNull(Object obj);

    Map<Object, Object> toMapOrNull(Object obj);

    <T> T toOrNull(Object obj, T t) throws Exception;

    String toStringOrNull(Object obj, String str);

    default String toStringOrNull(Object obj) {
        return toStringOrNull(obj, null);
    }

    default boolean toBoolean(Object obj, boolean z) {
        Boolean booleanOrNull = toBooleanOrNull(obj);
        return booleanOrNull != null ? booleanOrNull.booleanValue() : z;
    }

    default Boolean toBooleanOrNull(Object obj) {
        return toBooleanOrNull(obj, null);
    }

    default int toInteger(Object obj, int i) {
        Integer integerOrNull = toIntegerOrNull(obj);
        return integerOrNull != null ? integerOrNull.intValue() : i;
    }

    default Integer toIntegerOrNull(Object obj) {
        return toIntegerOrNull(obj, null);
    }

    default float toFloat(Object obj, float f) {
        Float floatOrNull = toFloatOrNull(obj);
        return floatOrNull != null ? floatOrNull.floatValue() : f;
    }

    default Float toFloatOrNull(Object obj) {
        return toFloatOrNull(obj, null);
    }

    default double toDouble(Object obj, double d) {
        Double doubleOrNull = toDoubleOrNull(obj);
        return doubleOrNull != null ? doubleOrNull.doubleValue() : d;
    }

    default Double toDoubleOrNull(Object obj) {
        return toDoubleOrNull(obj, null);
    }

    default <T> T toOrNull(Object obj) throws Exception {
        return (T) toOrNull(obj, null);
    }
}
