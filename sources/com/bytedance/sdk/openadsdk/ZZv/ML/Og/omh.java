package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class omh implements KZx {
    private int KZx;
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
            jSONObject.put("video_start_duration", this.pA);
            jSONObject.put("video_cache_size", this.Og);
            jSONObject.put("is_auto_play", this.KZx);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("FeedPlayModel", th.getMessage());
        }
    }
}
