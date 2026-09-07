package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class Wx implements KZx {
    public long KZx;
    public int Og;
    public long pA;

    public void pA(long j) {
        this.pA = j;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public void Og(long j) {
        this.KZx = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pA);
            jSONObject.put("buffers_count", this.Og);
            jSONObject.put("total_duration", this.KZx);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("PlayBufferModel", th.getMessage());
        }
    }
}
