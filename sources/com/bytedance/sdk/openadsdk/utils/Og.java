package com.bytedance.sdk.openadsdk.utils;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public static SoftReference<com.bytedance.sdk.openadsdk.core.model.yFO> pA;

    public static com.bytedance.sdk.openadsdk.core.model.yFO pA() {
        SoftReference<com.bytedance.sdk.openadsdk.core.model.yFO> softReference = pA;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null) {
            return;
        }
        pA = new SoftReference<>(yfo);
    }
}
