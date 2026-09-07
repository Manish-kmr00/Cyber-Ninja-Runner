package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og implements KZx {
    private int KZx;
    private long Og;
    private int ZZv;
    private long pA;

    public void pA(long j) {
        this.pA = j;
    }

    public void Og(long j) {
        this.Og = j;
    }

    public void pA(int i) {
        this.KZx = i;
    }

    public void Og(int i) {
        this.ZZv = i;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pA);
            jSONObject.put("total_duration", this.Og);
            jSONObject.put("vbtt_skip_type", this.KZx);
            jSONObject.put("skip_reason", this.ZZv);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("EndcardSkipModel", th.getMessage());
        }
    }
}
