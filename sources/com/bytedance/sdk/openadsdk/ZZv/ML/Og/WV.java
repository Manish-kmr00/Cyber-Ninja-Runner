package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class WV implements KZx {
    private long KZx;
    private long Og;
    private long ZZv;
    private String pA;

    public void pA(String str) {
        this.pA = str;
    }

    public void pA(long j) {
        this.Og = j;
    }

    public void Og(long j) {
        this.KZx = j;
    }

    public void KZx(long j) {
        this.ZZv = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.pA);
            jSONObject.put("preload_size", this.Og);
            jSONObject.put("load_time", this.KZx);
            jSONObject.put("local_cache", this.ZZv);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("LoadVideoSuccessModel", th.getMessage());
        }
    }
}
