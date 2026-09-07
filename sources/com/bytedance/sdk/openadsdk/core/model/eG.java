package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class eG {
    private String KZx;
    private JSONObject ML;
    private String Og;
    private String ZZv;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public String Og() {
        return this.Og;
    }

    public String KZx() {
        return this.KZx;
    }

    public String ZZv() {
        return this.ZZv;
    }

    public JSONObject ML() {
        return this.ML;
    }

    public static eG pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        eG eGVar = new eG();
        eGVar.pA = jSONObject.optString("id");
        eGVar.ZZv = jSONObject.optString("data");
        eGVar.KZx = jSONObject.optString("url");
        eGVar.Og = jSONObject.optString("md5");
        eGVar.ML = jSONObject.optJSONObject("custom_components");
        return eGVar;
    }

    public JSONObject JG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.pA);
            jSONObject.put("md5", this.Og);
            jSONObject.put("url", this.KZx);
            jSONObject.put("data", this.ZZv);
            jSONObject.put("custom_components", this.ML);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
