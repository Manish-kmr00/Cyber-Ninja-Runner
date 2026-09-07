package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract /* synthetic */ class AbstractC3388gc {
    public static JSONObject a(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, i);
        return jSONObject;
    }
}
