package net.pubnative.lite.sdk.utils.json;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class JsonModelFieldCache {
    private static final Map<String, HashMap<String, JsonModel.JsonModelMetadata>> cachedModels = new HashMap();

    public static boolean checkIfModelCached(Class<?> cls) {
        Map<String, HashMap<String, JsonModel.JsonModelMetadata>> map = cachedModels;
        return map.containsKey(cls.getName()) && map.get(cls.getName()) != null;
    }

    public static HashMap<String, JsonModel.JsonModelMetadata> getFields(Class<?> cls) {
        return cachedModels.get(cls.getName());
    }

    public static void setFields(Class<?> cls, HashMap<String, JsonModel.JsonModelMetadata> map) {
        cachedModels.put(cls.getName(), map);
    }
}
