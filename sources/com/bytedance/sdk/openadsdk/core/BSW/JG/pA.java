package com.bytedance.sdk.openadsdk.core.BSW.JG;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    private String KZx;
    private String ML;
    private String Og;
    private String ZZv;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public pA pA(String str) {
        this.pA = str;
        return this;
    }

    public String Og() {
        return this.Og;
    }

    public pA Og(String str) {
        this.Og = str;
        return this;
    }

    public String KZx() {
        return this.KZx;
    }

    public pA KZx(String str) {
        this.KZx = str;
        return this;
    }

    public String ZZv() {
        return this.ZZv;
    }

    public pA ZZv(String str) {
        this.ZZv = str;
        return this;
    }

    public String ML() {
        return this.ML;
    }

    public pA ML(String str) {
        this.ML = str;
        return this;
    }

    public JSONObject pA(pA pAVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.pA);
            jSONObject.put("md5", this.Og);
            jSONObject.put("url", this.KZx);
            if (pAVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", pAVar.pA());
                jSONObject2.put("md5", pAVar.Og());
                jSONObject2.put("url", pAVar.KZx());
                jSONObject.put("overlay", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
