package com.bytedance.sdk.openadsdk.core.SGo;

import android.content.Context;
import com.bytedance.sdk.component.SD.KZx.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.aBv.KZx;
import com.bytedance.sdk.openadsdk.aBv.Og;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.JG;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    public static boolean pA;
    private static final int Og = Integer.parseInt("1371");
    private static long KZx = System.currentTimeMillis();

    public static void pA() {
        Context contextPA;
        if (!aBv.ZZv().Bzk() || pA || (contextPA = aBv.pA()) == null) {
            return;
        }
        try {
            KZx.pA().Og().pA(contextPA, true, new Og(contextPA));
            KZx.pA().Og().pA(contextPA, com.bytedance.sdk.openadsdk.multipro.Og.KZx());
            KZx = System.currentTimeMillis();
            pA = true;
        } catch (Exception e) {
            WV.pA("TncHelper", "initTTAdNet: ", e.getMessage());
        }
    }

    public static void Og() {
        if (pA) {
            JG jgZZv = aBv.ZZv();
            if (jgZZv.Bzk()) {
                long jRS = jgZZv.RS();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - KZx >= jRS) {
                    KZx = jCurrentTimeMillis;
                    Context contextPA = aBv.pA();
                    if (contextPA == null) {
                        return;
                    }
                    omh.pA().pA(Og, contextPA).KZx();
                }
            }
        }
    }
}
