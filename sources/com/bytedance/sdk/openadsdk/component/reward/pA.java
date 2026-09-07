package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    public static void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, int i, boolean z) {
        if (pAVar == null || pAVar.ZZv() == null || pAVar.ZZv().size() <= 0) {
            return;
        }
        if (i >= pAVar.ZZv().size()) {
            i = 0;
        }
        yFO yfo = pAVar.ZZv().get(i);
        Context contextPA = aBv.pA();
        pA(yfo, !TextUtils.isEmpty(z ? BSW.pA(contextPA).pA(yfo) : ZZv.pA(contextPA).pA(yfo)), z);
    }

    public static void pA(final yFO yfo, final boolean z, final boolean z2) {
        com.bytedance.sdk.openadsdk.core.Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.1
            @Override // java.lang.Runnable
            public void run() {
                if (yfo == null) {
                    return;
                }
                try {
                    Context contextPA = aBv.pA();
                    AdSlot adSlotRB = yfo.rB();
                    if (adSlotRB != null) {
                        int iOg = ML.Og();
                        if (iOg == 0 || iOg == 2) {
                            if (z2) {
                                WV.pA(contextPA).pA(adSlotRB.getCodeId(), yfo);
                            } else {
                                ML.pA(contextPA).pA(adSlotRB.getCodeId(), yfo);
                            }
                        }
                        if (z) {
                            if (z2) {
                                WV.pA(contextPA).pA(adSlotRB);
                            } else {
                                ML.pA(contextPA).pA(adSlotRB);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
