package net.pubnative.lite.sdk.utils.json;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class JsonOperations {
    public static void putJsonString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putJsonString(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            jSONArray.put(str);
        }
    }

    public static void putJsonLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putJsonBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putJsonValue(JSONObject jSONObject, String str, Integer num) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, num);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putJsonValue(JSONObject jSONObject, String str, Double d) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, d);
            } catch (JSONException unused) {
            }
        }
    }

    public static void putStringArray(JSONObject jSONObject, String str, List<String> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            if (list.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
    }

    public static void putJsonArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static void removeJsonValue(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            jSONObject.remove(str);
        }
    }

    private static synchronized JSONObject merge(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null) {
            if (jSONObject2.length() != 0) {
                try {
                    JSONArray jSONArrayNames = jSONObject2.names();
                    if (jSONArrayNames != null) {
                        for (int i = 0; i < jSONArrayNames.length(); i++) {
                            String string = jSONArrayNames.getString(i);
                            jSONObject.put(string, jSONObject2.get(string));
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException | RuntimeException | JSONException unused) {
                }
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public static void mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() == 0) {
            return;
        }
        merge(jSONObject, jSONObject2);
    }
}
