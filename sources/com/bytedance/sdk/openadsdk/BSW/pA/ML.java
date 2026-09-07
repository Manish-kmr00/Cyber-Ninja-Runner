package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ML extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private JSONObject pA;

    public ML(JSONObject jSONObject) {
        this.pA = jSONObject;
    }

    public static void pA(aBv abv, JSONObject jSONObject) {
        abv.pA("getData", new ML(jSONObject));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        return com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(this.pA, jSONObject);
    }
}
