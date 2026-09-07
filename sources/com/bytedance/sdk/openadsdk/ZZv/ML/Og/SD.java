package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class SD implements KZx {
    private long Og;
    private long pA;

    public void pA(long j) {
        this.pA = j;
    }

    public void Og(long j) {
        this.Og = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pA);
            jSONObject.put("total_duration", this.Og);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("FeedPauseModel", th.getMessage());
        }
    }
}
