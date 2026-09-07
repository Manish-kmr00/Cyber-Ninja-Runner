package com.bytedance.sdk.openadsdk.core.model;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class BSW {
    private int KZx;
    private String Og;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public String Og() {
        return this.Og;
    }

    public void Og(String str) {
        this.Og = str;
    }

    public int KZx() {
        return this.KZx;
    }

    public void pA(int i) {
        this.KZx = i;
    }

    public JSONObject ZZv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_URL, this.pA);
            jSONObject.put("ft", this.KZx);
            jSONObject.put("fu", this.Og);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
