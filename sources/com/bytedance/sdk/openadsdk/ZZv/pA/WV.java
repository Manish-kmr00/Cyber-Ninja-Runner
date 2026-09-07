package com.bytedance.sdk.openadsdk.ZZv.pA;

import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes4.dex */
class WV implements com.bytedance.sdk.openadsdk.Sn.KZx.Og {
    public static final WV pA = new WV();

    private WV() {
    }

    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.Og
    public void pA(com.bytedance.sdk.openadsdk.Sn.Og og) {
        pA(og, false);
    }

    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.Og
    public void pA(final com.bytedance.sdk.openadsdk.Sn.Og og, final boolean z) {
        pA(new com.bytedance.sdk.component.omh.omh("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.WV.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.Sn.pA.KZx logStats = og.getLogStats();
                    if (logStats == null) {
                        return;
                    }
                    com.bytedance.sdk.component.JG.pA.ZZv.pA.pA pAVar = new com.bytedance.sdk.component.JG.pA.ZZv.pA.pA(WQf.pA(), logStats.pA());
                    pAVar.KZx((byte) 0);
                    pAVar.Og(z ? (byte) 2 : (byte) 3);
                    pAVar.pA((byte) 1);
                    if (com.bytedance.sdk.component.JG.pA.Og.Og()) {
                        ZZv.pA(aBv.pA(), com.bytedance.sdk.openadsdk.multipro.Og.KZx());
                    }
                    com.bytedance.sdk.component.JG.pA.Og.pA(pAVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void pA(com.bytedance.sdk.component.omh.omh omhVar) {
        if (omhVar == null) {
            return;
        }
        if (!xy.JG()) {
            xy.Og(omhVar, 5);
        } else {
            omhVar.run();
        }
    }
}
