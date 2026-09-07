package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DX implements com.bytedance.adsdk.pA.Og.Og.pA {
    private Number pA;

    public DX(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.pA = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.pA = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.pA = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.pA = Long.valueOf(str);
        }
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        return this.pA;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.NUMBER;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        return this.pA.toString();
    }

    public String toString() {
        return Og();
    }
}
