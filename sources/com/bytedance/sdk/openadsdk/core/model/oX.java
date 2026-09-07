package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class oX {
    public static int Og = 2;
    public static int pA = 1;
    private int KZx = 5;
    private int ZZv = 30;
    private int ML = 70;
    private int JG = 1;
    private int SD = pA;

    public int pA() {
        return this.KZx;
    }

    public void pA(int i) {
        this.KZx = i;
    }

    public int Og() {
        return this.ZZv;
    }

    public void Og(int i) {
        this.ZZv = i;
    }

    public int KZx() {
        return this.ML;
    }

    public void KZx(int i) {
        this.ML = i;
    }

    public int ZZv() {
        return this.JG;
    }

    public void ZZv(int i) {
        this.JG = i;
    }

    public int ML() {
        return this.SD;
    }

    public void ML(int i) {
        this.SD = i;
    }

    public JSONObject pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.KZx);
            jSONObject.put("ceiling_ratio", this.ZZv);
            jSONObject.put("expand_ratio", this.ML);
            jSONObject.put("back_type", this.JG);
            jSONObject.put("boc_return_type", this.SD);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("InteractionParams", th.getMessage());
        }
        return jSONObject;
    }
}
