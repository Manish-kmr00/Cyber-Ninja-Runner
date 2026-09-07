package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3085o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1713a = new HashMap();
    public final HashMap b = new HashMap();

    public final String a(String str, String str2) {
        return this.f1713a.containsKey(str) ? (String) this.f1713a.get(str) : str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3085o.class != obj.getClass()) {
            return false;
        }
        C3085o c3085o = (C3085o) obj;
        return this.f1713a.equals(c3085o.f1713a) && this.b.equals(c3085o.b);
    }

    public final int hashCode() {
        return this.f1713a.hashCode();
    }

    public static C3085o a(JSONObject jSONObject) {
        C3085o c3085o = new C3085o();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("overrides");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String strOptString = jSONArrayNames.optString(i, null);
            String strOptString2 = jSONObjectOptJSONObject.optString(strOptString, null);
            if (strOptString != null && strOptString2 != null) {
                c3085o.f1713a.put(strOptString, strOptString2);
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            JSONArray jSONArrayNames2 = jSONObjectOptJSONObject2.names();
            for (int i2 = 0; i2 < jSONArrayNames2.length(); i2++) {
                String strOptString3 = jSONArrayNames2.optString(i2, null);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(strOptString3);
                if (strOptString3 != null && jSONObjectOptJSONObject3 != null) {
                    c3085o.b.put(strOptString3, new C3083m(jSONObjectOptJSONObject3));
                }
            }
        }
        return c3085o;
    }

    public final int a(String str, int i, int i2) {
        try {
            i = Integer.parseInt(a(str, Integer.toString(i)));
        } catch (Throwable unused) {
        }
        return Math.max(i, i2);
    }

    public final boolean a(boolean z, String str) {
        try {
            return Boolean.parseBoolean(a(str, Boolean.toString(z)));
        } catch (Throwable unused) {
            return z;
        }
    }

    public final C3082l a(String str) {
        C3083m c3083m;
        String str2 = IAConfigManager.O.d;
        if (this.b.containsKey(str2)) {
            c3083m = (C3083m) this.b.get(str2);
        } else {
            c3083m = new C3083m();
        }
        c3083m.getClass();
        return c3083m.f1712a.containsKey(str) ? (C3082l) c3083m.f1712a.get(str) : new C3082l();
    }
}
