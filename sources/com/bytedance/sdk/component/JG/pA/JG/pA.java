package com.bytedance.sdk.component.JG.pA.JG;

import com.bytedance.sdk.component.JG.pA.omh;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private static volatile Og pA;

    public static Og pA() {
        if (pA == null) {
            synchronized (Og.class) {
                if (pA == null) {
                    pA = new KZx(omh.SD().JG(), new JG(omh.SD().JG()));
                }
            }
        }
        return pA;
    }
}
