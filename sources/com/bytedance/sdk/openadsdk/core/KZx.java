package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: loaded from: classes14.dex */
public class KZx {
    private static volatile KZx pA;

    private KZx() {
    }

    public static KZx pA(Context context) {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new KZx();
                }
            }
        }
        return pA;
    }

    public void pA(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", str, str2);
    }

    public String Og(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("ttopenadsdk", str, str2);
    }

    public void pA(String str, int i) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", str, Integer.valueOf(i));
    }

    public int Og(String str, int i) {
        return com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", str, i);
    }

    public void pA(String str, long j) {
        com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", str, Long.valueOf(j));
    }

    public Long Og(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("ttopenadsdk", str, j));
    }
}
