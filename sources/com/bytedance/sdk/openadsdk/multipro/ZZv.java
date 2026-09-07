package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.aBv;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv {
    public static String pA = "com.bytedance.openadsdk";
    public static String Og = "content://" + pA + ".TTMultiProvider";

    static {
        pA();
    }

    public static void pA() {
        if (aBv.pA() != null) {
            pA = aBv.pA().getPackageName();
            Og = "content://" + pA + ".TTMultiProvider";
        }
    }
}
