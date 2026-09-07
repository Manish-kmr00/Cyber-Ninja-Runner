package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class KZx extends com.bytedance.sdk.component.pA.ZZv<JSONObject, JSONObject> {
    private final WeakReference<IG> pA;

    public static void pA(aBv abv, final IG ig) {
        abv.pA("newClickEvent", new com.bytedance.sdk.component.pA.ZZv.Og() { // from class: com.bytedance.sdk.openadsdk.BSW.pA.KZx.1
            @Override // com.bytedance.sdk.component.pA.ZZv.Og
            public com.bytedance.sdk.component.pA.ZZv pA() {
                return new KZx(ig);
            }
        });
    }

    public KZx(IG ig) {
        this.pA = new WeakReference<>(ig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.pA.ZZv
    public void pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        IG ig = this.pA.get();
        if (ig == null) {
            KZx();
        } else {
            ig.ML(jSONObject);
        }
    }
}
