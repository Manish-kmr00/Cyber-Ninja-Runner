package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private final IG pA;

    public ZZv(IG ig) {
        this.pA = ig;
    }

    public static void pA(aBv abv, IG ig) {
        abv.pA("expressAdViewStartZoom", new ZZv(ig));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        this.pA.ZZv(jSONObject);
        return null;
    }
}
