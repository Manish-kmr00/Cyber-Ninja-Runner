package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class pA extends aBv {
    public pA() {
        super(com.bytedance.adsdk.pA.Og.ZZv.KZx.DIVISION);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA;
        Object objPA2 = this.pA.pA(map);
        if (objPA2 == null || (objPA = this.Og.pA(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.pA.Og.ML.pA.pA.pA((Number) objPA2, (Number) objPA);
    }
}
