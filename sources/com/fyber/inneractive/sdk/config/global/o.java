package com.fyber.inneractive.sdk.config.global;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f1705a;

    public o(JSONObject jSONObject) {
        this.f1705a = jSONObject;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Integer a(String str) {
        if (this.f1705a.has(str)) {
            try {
                return Integer.valueOf(this.f1705a.getInt(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final String b(String str) {
        if (this.f1705a.has(str)) {
            try {
                return this.f1705a.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Boolean c(String str) {
        if (this.f1705a.has(str)) {
            try {
                return Boolean.valueOf(this.f1705a.getBoolean(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final String toString() {
        JSONObject jSONObject = this.f1705a;
        return jSONObject != null ? jSONObject.toString() : "no params";
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Double a() {
        return Double.valueOf(this.f1705a.optDouble("scale_up_to", 0.0d));
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Map b() {
        HashMap map = new HashMap();
        Iterator<String> itKeys = this.f1705a.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, this.f1705a.get(next));
            } catch (Exception unused) {
            }
        }
        return map;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final String a(String str, String str2) {
        return this.f1705a.optString(str, str2);
    }
}
