package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Sn implements KZx {
    private final int KZx;
    private final String ML;
    private long Og;
    private final int ZZv;
    private long pA;

    public Sn(com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar) {
        this.KZx = pAVar.pA();
        this.ZZv = pAVar.Og();
        this.ML = pAVar.KZx();
    }

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
            jSONObject.put("error_code", this.KZx);
            jSONObject.put("extra_error_code", this.ZZv);
            jSONObject.put("error_message", this.ML);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("PlayErrorModel", th.getMessage());
        }
    }
}
