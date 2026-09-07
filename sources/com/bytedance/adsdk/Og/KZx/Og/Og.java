package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes5.dex */
public class Og implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.JG KZx;
    private final boolean ML;
    private final com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> Og;
    private final boolean ZZv;
    private final String pA;

    public Og(String str, com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wx, com.bytedance.adsdk.Og.KZx.pA.JG jg, boolean z, boolean z2) {
        this.pA = str;
        this.Og = wx;
        this.KZx = jg;
        this.ZZv = z;
        this.ML = z2;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.JG(bzk, pAVar, this);
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> Og() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.JG KZx() {
        return this.KZx;
    }

    public boolean ZZv() {
        return this.ZZv;
    }

    public boolean ML() {
        return this.ML;
    }
}
