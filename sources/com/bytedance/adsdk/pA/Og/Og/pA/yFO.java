package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class yFO implements com.bytedance.adsdk.pA.Og.Og.Og {
    private com.bytedance.adsdk.pA.Og.Og.pA KZx;
    private com.bytedance.adsdk.pA.Og.Og.pA Og;
    private com.bytedance.adsdk.pA.Og.Og.pA pA;

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA = this.pA.pA(map);
        if (objPA == null) {
            return null;
        }
        if (((Boolean) objPA).booleanValue()) {
            return this.Og.pA(map);
        }
        return this.KZx.pA(map);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.Og
    public void pA(com.bytedance.adsdk.pA.Og.Og.pA pAVar) {
        this.pA = pAVar;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.Og
    public void Og(com.bytedance.adsdk.pA.Og.Og.pA pAVar) {
        this.Og = pAVar;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.Og
    public void KZx(com.bytedance.adsdk.pA.Og.Og.pA pAVar) {
        this.KZx = pAVar;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        return this.pA.Og() + "?" + this.Og.Og() + ":" + this.KZx.Og();
    }

    public String toString() {
        return Og();
    }
}
