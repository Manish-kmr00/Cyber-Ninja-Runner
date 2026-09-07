package com.bytedance.sdk.component.JG.pA.pA.pA;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public class pA extends Og {
    private static volatile pA pA;

    @Override // com.bytedance.sdk.component.JG.pA.pA.pA.Og
    public /* bridge */ /* synthetic */ Og.C0189Og pA() {
        return super.pA();
    }

    public static pA pA(Context context) {
        if (pA == null) {
            synchronized (pA.class) {
                if (pA == null) {
                    pA = new pA(context);
                }
            }
        }
        return pA;
    }

    private pA(Context context) {
        super(context);
    }
}
