package com.bytedance.sdk.component.Bzk.pA;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    private static volatile pA Og;
    private volatile Og pA;

    private pA() {
    }

    public static pA pA() {
        if (Og == null) {
            synchronized (pA.class) {
                if (Og == null) {
                    Og = new pA();
                }
            }
        }
        return Og;
    }

    public void pA(Og og) {
        this.pA = og;
    }

    public Og Og() {
        return this.pA;
    }
}
