package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3083m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1712a = new HashMap();

    public C3083m() {
    }

    public C3083m(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        JSONArray jSONArrayNames2 = jSONObject.names();
        for (int i = 0; i < jSONArrayNames2.length(); i++) {
            String strOptString = jSONArrayNames2.optString(i, null);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
            C3082l c3082l = new C3082l();
            if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    String strOptString2 = jSONArrayNames.optString(i2, null);
                    String strOptString3 = jSONObjectOptJSONObject.optString(strOptString2, null);
                    if (strOptString2 != null && strOptString3 != null) {
                        c3082l.f1711a.put(strOptString2, strOptString3);
                    }
                }
            }
            this.f1712a.put(strOptString, c3082l);
        }
    }
}
