package com.chartboost.sdk.impl;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.playon.bridge.Ad;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f983a;
    public final String b;
    public final String c;

    public String toString() {
        return "Asset{directory='" + this.f983a + "', filename='" + this.b + "', url='" + this.c + "'}";
    }

    public c1(String str, String str2, String str3) {
        this.f983a = str;
        this.b = str2;
        this.c = str3;
    }

    public static Map<String, c1> a(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            b7.a("deserializeAssets assetsJson is null", null);
            return map;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Iterator<String> itKeys2 = jSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next2);
                map.put(next2, new c1(next, jSONObject3.getString(ContentDisposition.Parameters.FileName), jSONObject3.getString("url")));
            }
        }
        return map;
    }

    public static Map<String, c1> b(JSONObject jSONObject, int i) {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            return map;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cache_assets");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if ("templates".equals(next)) {
                    map.putAll(a(jSONObject2, i));
                } else {
                    map.putAll(a(jSONObject2, next));
                }
            }
        } catch (JSONException e) {
            b7.b("v2PrefetchToAssets: " + e, null);
        }
        return map;
    }

    public File a(File file) {
        if (this.f983a != null && this.b != null) {
            String str = this.f983a + RemoteSettings.FORWARD_SLASH_STRING + this.b;
            try {
                return new File(file, str);
            } catch (Exception e) {
                b7.a("Cannot create file for path: " + str + ". Error: " + e, null);
                return null;
            }
        }
        b7.a("Cannot create file. Directory or filename is null.", null);
        return null;
    }

    public String a() {
        return this.c;
    }

    public static Map<String, c1> a(JSONObject jSONObject, String str) throws JSONException {
        HashMap map = new HashMap();
        if (jSONObject != null && str != null) {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("name");
                map.put(string, new c1(str, string, jSONObject2.getString("value")));
            }
        }
        return map;
    }

    public static Map<String, c1> a(JSONObject jSONObject, int i) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        HashMap map = new HashMap();
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("templates")) != null) {
            int iMin = Math.min(i, jSONArrayOptJSONArray.length());
            for (int i2 = 0; i2 < iMin; i2++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                Iterator<Map.Entry<String, c1>> it = a(jSONObject2 != null ? a(jSONObject2.getJSONArray("elements")) : null).entrySet().iterator();
                while (it.hasNext()) {
                    c1 value = it.next().getValue();
                    map.put(value.b, value);
                }
            }
        }
        return map;
    }

    public static JSONObject a(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObjectA = z1.a(new z1.a[0]);
        if (jSONArray == null) {
            return jSONObjectA;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String strOptString = jSONObject.optString("name");
            String strOptString2 = jSONObject.optString("type");
            String strOptString3 = jSONObject.optString("value");
            String strOptString4 = jSONObject.optString(Ad.VERIFICATIONPARAM);
            if (!Ad.VERIFICATIONPARAM.equals(strOptString2) && strOptString4.isEmpty()) {
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(strOptString2);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = z1.a(new z1.a[0]);
                    jSONObjectA.put(strOptString2, jSONObjectOptJSONObject);
                }
                jSONObjectOptJSONObject.put("html".equals(strOptString2) ? "body" : strOptString, z1.a(z1.a(ContentDisposition.Parameters.FileName, strOptString), z1.a("url", strOptString3)));
            }
        }
        return jSONObjectA;
    }
}
