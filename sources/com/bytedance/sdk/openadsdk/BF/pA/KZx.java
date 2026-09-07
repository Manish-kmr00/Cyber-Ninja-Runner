package com.bytedance.sdk.openadsdk.BF.pA;

import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes12.dex */
public class KZx {
    public static String KZx = "engaged_view";
    public static int Og = 6;
    public static boolean pA;

    public static void pA(yFO yfo) {
        Og ogKZx = KZx(yfo);
        if (ogKZx == null) {
            return;
        }
        ogKZx.pA();
    }

    public static void Og(yFO yfo) {
        Og ogKZx = KZx(yfo);
        if (ogKZx == null) {
            return;
        }
        ogKZx.Og();
    }

    public static void pA(yFO yfo, int i) {
        Og ogKZx = KZx(yfo);
        if (ogKZx == null || ogKZx.KZx()) {
            return;
        }
        ogKZx.pA(i);
    }

    public static void pA(yFO yfo, boolean z) {
        Og ogKZx = KZx(yfo);
        if (ogKZx == null || ogKZx.KZx()) {
            return;
        }
        ogKZx.pA(z);
        ogKZx.pA(z ? 4 : 8);
    }

    private static Og KZx(yFO yfo) {
        if (yfo == null || !yfo.qK()) {
            return null;
        }
        return yfo.Yg();
    }
}
