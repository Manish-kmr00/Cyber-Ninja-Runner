package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class Bzk implements KZx {
    private final long Og;
    private final String pA;

    public Bzk(String str, long j) {
        this.pA = str;
        this.Og = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.pA);
            jSONObject.put("preload_size", this.Og);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("LoadVideoCancelModel", th.getMessage());
        }
    }
}
