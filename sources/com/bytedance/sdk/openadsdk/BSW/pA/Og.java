package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.IG;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class Og extends com.bytedance.sdk.component.pA.ZZv<JSONObject, JSONObject> {
    private final WeakReference<IG> pA;

    public static void pA(aBv abv, final IG ig) {
        abv.pA("interstitial_webview_close", new com.bytedance.sdk.component.pA.ZZv.Og() { // from class: com.bytedance.sdk.openadsdk.BSW.pA.Og.1
            @Override // com.bytedance.sdk.component.pA.ZZv.Og
            public com.bytedance.sdk.component.pA.ZZv pA() {
                return new Og(ig);
            }
        });
    }

    public Og(IG ig) {
        this.pA = new WeakReference<>(ig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.pA.ZZv
    public void pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        com.bytedance.sdk.openadsdk.core.Bzk.Og().aBv();
        IG ig = this.pA.get();
        if (ig == null) {
            WV.pA("DoInterstitialWebViewCloseMethod", "invoke error");
            KZx();
        } else {
            ig.SD();
        }
    }
}
