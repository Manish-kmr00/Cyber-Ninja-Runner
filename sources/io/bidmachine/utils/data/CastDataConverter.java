package io.bidmachine.utils.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class CastDataConverter implements DataConverter {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.bidmachine.utils.data.DataConverter
    public <T> T toOrNull(Object obj, T t) throws Exception {
        return obj != 0 ? obj : t;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public String toStringOrNull(Object obj, String str) {
        return obj instanceof String ? (String) obj : str;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Boolean toBooleanOrNull(Object obj, Boolean bool) {
        return obj instanceof Boolean ? (Boolean) obj : bool;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Integer toIntegerOrNull(Object obj, Integer num) {
        return obj instanceof Integer ? (Integer) obj : num;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Float toFloatOrNull(Object obj, Float f) {
        return obj instanceof Float ? (Float) obj : f;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Double toDoubleOrNull(Object obj, Double d) {
        return obj instanceof Double ? (Double) obj : d;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public List<Object> toListOrNull(Object obj) {
        if (!(obj instanceof List)) {
            return null;
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            return null;
        }
        return new ArrayList(list);
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Map<Object, Object> toMapOrNull(Object obj) {
        if (!(obj instanceof Map)) {
            return null;
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            return null;
        }
        return new HashMap(map);
    }
}
