package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class ML extends JG {
    private static volatile ML pA;

    @Override // com.bytedance.sdk.openadsdk.core.JG
    public /* bridge */ /* synthetic */ JG.KZx pA() {
        return super.pA();
    }

    public static ML pA(Context context) {
        if (pA == null) {
            synchronized (ML.class) {
                if (pA == null) {
                    pA = new ML(context);
                }
            }
        }
        return pA;
    }

    private ML(Context context) {
        super(context);
    }
}
