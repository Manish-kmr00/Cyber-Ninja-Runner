package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class vZF implements com.bytedance.adsdk.pA.Og.Og.pA {
    private final String pA;

    public vZF(String str) {
        this.pA = str;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.STRING;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        return "'" + this.pA + "'";
    }

    public String toString() {
        return Og();
    }
}
