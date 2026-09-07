package com.bytedance.adsdk.pA.Og.Og.pA;

/* JADX INFO: loaded from: classes11.dex */
public abstract class aBv implements com.bytedance.adsdk.pA.Og.Og.pA {
    protected com.bytedance.adsdk.pA.Og.ZZv.KZx KZx;
    protected com.bytedance.adsdk.pA.Og.Og.pA Og;
    protected com.bytedance.adsdk.pA.Og.Og.pA pA;

    protected aBv(com.bytedance.adsdk.pA.Og.ZZv.KZx kZx) {
        this.KZx = kZx;
    }

    public void pA(com.bytedance.adsdk.pA.Og.Og.pA pAVar) {
        this.pA = pAVar;
    }

    public void Og(com.bytedance.adsdk.pA.Og.Og.pA pAVar) {
        this.Og = pAVar;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public com.bytedance.adsdk.pA.Og.ZZv.ML pA() {
        return com.bytedance.adsdk.pA.Og.ZZv.JG.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.pA.Og.Og.pA
    public String Og() {
        return this.pA.Og() + this.KZx.pA() + this.Og.Og();
    }

    public String toString() {
        return Og();
    }
}
