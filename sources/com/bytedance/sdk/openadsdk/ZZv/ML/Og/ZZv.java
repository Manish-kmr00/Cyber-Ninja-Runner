package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ZZv implements KZx {
    public int KZx;
    public long Og;
    public int ZZv = 0;
    public long pA;

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
            jSONObject.put("total_duration", this.pA);
            jSONObject.put("buffers_time", this.Og);
            jSONObject.put("break_reason", this.KZx);
            jSONObject.put("video_backup", this.ZZv);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("FeedBreakModel", th.getMessage());
        }
    }
}
