package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.Path;

/* JADX INFO: loaded from: classes4.dex */
public class ML implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.Og Bzk;
    private final com.bytedance.adsdk.Og.KZx.pA.JG JG;
    private final com.bytedance.adsdk.Og.KZx.pA.KZx KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.JG ML;
    private final Path.FillType Og;
    private final String SD;
    private final boolean SGo;
    private final com.bytedance.adsdk.Og.KZx.pA.ZZv ZZv;
    private final com.bytedance.adsdk.Og.KZx.pA.Og omh;
    private final SD pA;

    public ML(String str, SD sd, Path.FillType fillType, com.bytedance.adsdk.Og.KZx.pA.KZx kZx, com.bytedance.adsdk.Og.KZx.pA.ZZv zZv, com.bytedance.adsdk.Og.KZx.pA.JG jg, com.bytedance.adsdk.Og.KZx.pA.JG jg2, com.bytedance.adsdk.Og.KZx.pA.Og og, com.bytedance.adsdk.Og.KZx.pA.Og og2, boolean z) {
        this.pA = sd;
        this.Og = fillType;
        this.KZx = kZx;
        this.ZZv = zZv;
        this.ML = jg;
        this.JG = jg2;
        this.SD = str;
        this.omh = og;
        this.Bzk = og2;
        this.SGo = z;
    }

    public String pA() {
        return this.SD;
    }

    public SD Og() {
        return this.pA;
    }

    public Path.FillType KZx() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.KZx ZZv() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.ZZv ML() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.JG JG() {
        return this.ML;
    }

    public com.bytedance.adsdk.Og.KZx.pA.JG SD() {
        return this.JG;
    }

    public boolean omh() {
        return this.SGo;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.omh(bzk, sd, pAVar, this);
    }
}
