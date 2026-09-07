package com.bytedance.sdk.openadsdk.BF.Og;

import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv {
    public static void pA(final yFO yfo, final pA pAVar, final ML.pA pAVar2) {
        yfo.uhO();
        xy.KZx(new com.bytedance.sdk.component.omh.omh("mrc_report") { // from class: com.bytedance.sdk.openadsdk.BF.Og.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                if (yfo.ka()) {
                    if (yfo.qH()) {
                        com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(yfo.PV(), new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og("show_urls", yfo));
                    } else {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo);
                    }
                }
                String strPA = gbA.pA(yfo);
                JSONObject jSONObject = new JSONObject();
                pA pAVar3 = pAVar;
                if (pAVar3 != null) {
                    try {
                        jSONObject.put("root_view", pA.pA(pAVar3));
                        ML.pA pAVar4 = pAVar2;
                        if (pAVar4 != null) {
                            if (pAVar4.pA != -1) {
                                jSONObject.put("dynamic_show_type", pAVar2.pA);
                            }
                            if (pAVar2.Og != -1) {
                                jSONObject.put("ad_show_order", pAVar2.Og + 1);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yfo, strPA, "mrc_show", jSONObject);
            }
        });
    }
}
