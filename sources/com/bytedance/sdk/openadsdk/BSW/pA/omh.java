package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class omh extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private final String Og;
    private final IG pA;

    public omh(IG ig, String str) {
        this.pA = ig;
        this.Og = str;
    }

    public static void pA(aBv abv, IG ig) {
        abv.pA("endcardDynamicCreatives", new omh(ig, "endcardDynamicCreatives"));
        abv.pA("multiOpenCovert", new omh(ig, "multiOpenCovert"));
        abv.pA("skipToNextAd", new omh(ig, "skipToNextAd"));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        if ("endcardDynamicCreatives".equals(this.Og)) {
            return this.pA.SD(jSONObject);
        }
        if ("multiOpenCovert".equals(this.Og)) {
            this.pA.omh(jSONObject);
            return null;
        }
        if (!"skipToNextAd".equals(this.Og)) {
            return null;
        }
        this.pA.pA(jSONObject, this.Og);
        return null;
    }
}
