package com.bytedance.sdk.openadsdk.Sn;

import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.openadsdk.Sn.pA.ML;
import com.bytedance.sdk.openadsdk.ZZv.pA.JG;
import com.bytedance.sdk.openadsdk.core.BF;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    public static void pA() {
        if (xy.ML()) {
            xy.pA(new omh("DailyTaskHelper") { // from class: com.bytedance.sdk.openadsdk.Sn.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.KZx();
                }
            });
        } else {
            KZx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx() {
        com.bytedance.sdk.openadsdk.ZZv.pA.pA.Og();
        ML.KZx();
        JG.pA();
        BF.pA();
    }
}
