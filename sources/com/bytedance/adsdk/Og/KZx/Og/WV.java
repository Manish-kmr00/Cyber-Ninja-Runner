package com.bytedance.adsdk.Og.KZx.Og;

/* JADX INFO: loaded from: classes6.dex */
public class WV implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.Og KZx;
    private final boolean ML;
    private final com.bytedance.adsdk.Og.KZx.pA.Og Og;
    private final com.bytedance.adsdk.Og.KZx.pA.WV ZZv;
    private final String pA;

    public WV(String str, com.bytedance.adsdk.Og.KZx.pA.Og og, com.bytedance.adsdk.Og.KZx.pA.Og og2, com.bytedance.adsdk.Og.KZx.pA.WV wv, boolean z) {
        this.pA = str;
        this.Og = og;
        this.KZx = og2;
        this.ZZv = wv;
        this.ML = z;
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og Og() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og KZx() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.WV ZZv() {
        return this.ZZv;
    }

    public boolean ML() {
        return this.ML;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.oX(bzk, pAVar, this);
    }
}
