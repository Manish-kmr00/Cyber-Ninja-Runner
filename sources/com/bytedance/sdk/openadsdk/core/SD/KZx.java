package com.bytedance.sdk.openadsdk.core.SD;

import com.bytedance.sdk.component.SD.Og.ZZv;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class KZx {
    public static void pA(String str, long j) {
        JSONObject jSONObjectOg = Og(str, j);
        ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        zZvOg.Og(gbA.ZZv("/api/ad/union/sdk/stats/"));
        zZvOg.ZZv(jSONObjectOg.toString());
        zZvOg.pA(6);
        zZvOg.pA("uploadFrequentEvent");
        zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.SD.KZx.1
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                iOException.getMessage();
            }
        });
    }

    private static JSONObject Og(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
