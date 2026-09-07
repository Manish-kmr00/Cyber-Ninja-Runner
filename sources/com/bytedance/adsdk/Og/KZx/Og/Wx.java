package com.bytedance.adsdk.Og.KZx.Og;

/* JADX INFO: loaded from: classes6.dex */
public class Wx implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.Wx<Float, Float> Og;
    private final String pA;

    public Wx(String str, com.bytedance.adsdk.Og.KZx.pA.Wx<Float, Float> wx) {
        this.pA = str;
        this.Og = wx;
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Wx<Float, Float> Og() {
        return this.Og;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.aBv(bzk, pAVar, this);
    }
}
