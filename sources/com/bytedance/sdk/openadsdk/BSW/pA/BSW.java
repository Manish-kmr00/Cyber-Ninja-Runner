package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BSW extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private final IG pA;

    public BSW(IG ig) {
        this.pA = ig;
    }

    public static void pA(aBv abv, IG ig) {
        abv.pA("commonConvert", new BSW(ig));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        this.pA.JG(jSONObject);
        return null;
    }
}
