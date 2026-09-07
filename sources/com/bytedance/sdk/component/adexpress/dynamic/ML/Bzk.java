package com.bytedance.sdk.component.adexpress.dynamic.ML;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class Bzk {
    public static void pA(String str, JSONObject jSONObject) {
        JSONObject jSONObjectTM = com.bytedance.sdk.component.adexpress.Og.tM(str);
        if (jSONObjectTM == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectTM.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        pA(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject pA(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectTM = com.bytedance.sdk.component.adexpress.Og.tM(str);
        if (jSONObjectTM == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return pA(jSONObject2, jSONObjectTM.optJSONObject("themeValues"), jSONObject);
    }

    private static void pA(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static JSONObject pA(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String pA(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectTM = com.bytedance.sdk.component.adexpress.Og.tM(str);
        if (jSONObjectTM == null || (jSONObjectOptJSONObject = jSONObjectTM.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String pA(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectTM = com.bytedance.sdk.component.adexpress.Og.tM(str);
        if (jSONObjectTM == null || (jSONObjectOptJSONObject = jSONObjectTM.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject pA(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String Og(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return pA.pA(str);
    }
}
