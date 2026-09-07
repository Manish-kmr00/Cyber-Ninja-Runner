package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JG implements KZx {
    private int KZx = 0;
    private long Og;
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

    @Override // com.bytedance.sdk.openadsdk.ZZv.ML.Og.KZx
    public void pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.pA);
            jSONObject.put("buffers_time", this.Og);
            jSONObject.put("video_backup", this.KZx);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("FeedOverModel", th.getMessage());
        }
    }
}
