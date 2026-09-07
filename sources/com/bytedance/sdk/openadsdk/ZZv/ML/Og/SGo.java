package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class SGo implements KZx {
    private String JG;
    private long KZx;
    private String ML;
    private long Og;
    private int ZZv;
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

    public void pA(int i) {
        this.ZZv = i;
    }

    public void Og(String str) {
        this.ML = str;
    }

    public void KZx(String str) {
        this.JG = str;
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
            jSONObject.put("error_code", this.ZZv);
            jSONObject.put("error_message", this.ML);
            jSONObject.put("error_message_server", this.JG);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("LoadVideoErrorModel", th.getMessage());
        }
    }
}
