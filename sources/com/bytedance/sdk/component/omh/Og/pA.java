package com.bytedance.sdk.component.omh.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class pA {
    public int KZx;
    public int Og;
    public int ZZv;
    public int pA;

    public pA(int i, int i2, int i3, int i4) {
        this.pA = i;
        this.Og = i2;
        this.KZx = i3;
        this.ZZv = i4;
    }

    public JSONObject pA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.pA);
            jSONObject.put("sdk_max_thread_num", this.Og);
            jSONObject.put("app_thread_num", this.KZx);
            jSONObject.put("app_max_thread_num", this.ZZv);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
