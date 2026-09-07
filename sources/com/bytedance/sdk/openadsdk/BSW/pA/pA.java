package com.bytedance.sdk.openadsdk.BSW.pA;

import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class pA extends com.bytedance.sdk.component.pA.ZZv<JSONObject, JSONObject> {
    private final WeakReference<IG> pA;

    public static void pA(aBv abv, final IG ig) {
        abv.pA("getNetworkData", new com.bytedance.sdk.component.pA.ZZv.Og() { // from class: com.bytedance.sdk.openadsdk.BSW.pA.pA.1
            @Override // com.bytedance.sdk.component.pA.ZZv.Og
            public com.bytedance.sdk.component.pA.ZZv pA() {
                return new pA(ig);
            }
        });
    }

    public pA(IG ig) {
        this.pA = new WeakReference<>(ig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.pA.ZZv
    public void pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        IG ig = this.pA.get();
        if (ig == null) {
            KZx();
        } else {
            ig.pA(jSONObject, new com.bytedance.sdk.openadsdk.WV.KZx() { // from class: com.bytedance.sdk.openadsdk.BSW.pA.pA.2
                @Override // com.bytedance.sdk.openadsdk.WV.KZx
                public void pA(boolean z, List<yFO> list) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        if (!z) {
                            pA.this.pA(jSONObject2);
                        } else {
                            jSONObject2.put("creatives", IG.Og(list));
                            pA.this.pA(jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
