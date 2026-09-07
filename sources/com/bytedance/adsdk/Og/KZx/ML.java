package com.bytedance.adsdk.Og.KZx;

import com.bytedance.adsdk.Og.Sn;

/* JADX INFO: loaded from: classes2.dex */
public class ML {
    private static final ML pA = new ML();
    private final Sn<String, com.bytedance.adsdk.Og.SD> Og = new Sn<>(20);

    public static ML pA() {
        return pA;
    }

    ML() {
    }

    public com.bytedance.adsdk.Og.SD pA(String str) {
        if (str == null) {
            return null;
        }
        return this.Og.pA(str);
    }

    public void pA(String str, com.bytedance.adsdk.Og.SD sd) {
        if (str == null) {
            return;
        }
        this.Og.pA(str, sd);
    }
}
