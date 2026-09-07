package com.bytedance.adsdk.Og.KZx.Og;

/* JADX INFO: loaded from: classes6.dex */
public class omh {
    private final com.bytedance.adsdk.Og.KZx.pA.ZZv KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.omh Og;
    private final boolean ZZv;
    private final pA pA;

    public enum pA {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public omh(pA pAVar, com.bytedance.adsdk.Og.KZx.pA.omh omhVar, com.bytedance.adsdk.Og.KZx.pA.ZZv zZv, boolean z) {
        this.pA = pAVar;
        this.Og = omhVar;
        this.KZx = zZv;
        this.ZZv = z;
    }

    public pA pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.omh Og() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.ZZv KZx() {
        return this.KZx;
    }

    public boolean ZZv() {
        return this.ZZv;
    }
}
