package com.chartboost.sdk.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class z1 {
    public static JSONObject a(a... aVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : aVarArr) {
            a(jSONObject, aVar.f1205a, aVar.b);
        }
        return jSONObject;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1205a;
        public final Object b;

        public a(String str, Object obj) {
            this.f1205a = str;
            this.b = obj;
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            b7.b("put (" + str + ")", e);
        }
    }

    public static JSONObject a(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (jSONObject == null) {
                break;
            }
            jSONObject = jSONObject.optJSONObject(str);
        }
        return jSONObject;
    }

    public static a a(String str, Object obj) {
        return new a(str, obj);
    }
}
