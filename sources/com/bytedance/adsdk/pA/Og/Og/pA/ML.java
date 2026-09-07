package com.bytedance.adsdk.pA.Og.Og.pA;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ML extends aBv {
    public ML() {
        super(com.bytedance.adsdk.pA.Og.ZZv.KZx.GT_EQ);
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public Object pA(Map<String, JSONObject> map) {
        Object objPA;
        Object objPA2 = this.pA.pA(map);
        if (objPA2 == null || (objPA = this.Og.pA(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.pA.Og.ML.pA.ZZv.pA(objPA2, (Number) objPA)).booleanValue());
    }
}
