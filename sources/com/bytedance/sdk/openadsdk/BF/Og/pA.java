package com.bytedance.sdk.openadsdk.BF.Og;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class pA {
    private final float KZx;
    private final int Og;
    private final int pA;

    public pA(int i, int i2, float f) {
        this.pA = i;
        this.Og = i2;
        this.KZx = f;
    }

    public static JSONObject pA(pA pAVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", pAVar.pA);
        jSONObject.put("height", pAVar.Og);
        jSONObject.put("alpha", pAVar.KZx);
        return jSONObject;
    }
}
