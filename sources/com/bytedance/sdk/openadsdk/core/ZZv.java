package com.bytedance.sdk.openadsdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, str, "convert_track", jSONObject);
    }
}
