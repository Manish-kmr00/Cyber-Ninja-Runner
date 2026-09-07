package com.bytedance.sdk.component.JG.pA.pA.pA;

import com.bytedance.sdk.component.JG.pA.omh;

/* JADX INFO: loaded from: classes11.dex */
public class SD {
    public static String pA = "com.bytedance.openadsdk";
    public static String Og = "content://" + pA + ".TTMultiProvider";

    static {
        pA();
    }

    public static void pA() {
        if (omh.SD().JG() != null) {
            pA = omh.SD().JG().getPackageName();
            Og = "content://" + pA + ".TTMultiProvider";
        }
    }
}
