package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes9.dex */
public class SGo implements KZx {
    private final boolean BSW;
    private final com.bytedance.adsdk.Og.KZx.pA.Og Bzk;
    private final com.bytedance.adsdk.Og.KZx.pA.Og JG;
    private final com.bytedance.adsdk.Og.KZx.pA.Og KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.Og ML;
    private final pA Og;
    private final com.bytedance.adsdk.Og.KZx.pA.Og SD;
    private final boolean SGo;
    private final com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> ZZv;
    private final com.bytedance.adsdk.Og.KZx.pA.Og omh;
    private final String pA;

    public enum pA {
        STAR(1),
        POLYGON(2);

        private final int KZx;

        pA(int i) {
            this.KZx = i;
        }

        public static pA pA(int i) {
            for (pA pAVar : values()) {
                if (pAVar.KZx == i) {
                    return pAVar;
                }
            }
            return null;
        }
    }

    public SGo(String str, pA pAVar, com.bytedance.adsdk.Og.KZx.pA.Og og, com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wx, com.bytedance.adsdk.Og.KZx.pA.Og og2, com.bytedance.adsdk.Og.KZx.pA.Og og3, com.bytedance.adsdk.Og.KZx.pA.Og og4, com.bytedance.adsdk.Og.KZx.pA.Og og5, com.bytedance.adsdk.Og.KZx.pA.Og og6, boolean z, boolean z2) {
        this.pA = str;
        this.Og = pAVar;
        this.KZx = og;
        this.ZZv = wx;
        this.ML = og2;
        this.JG = og3;
        this.SD = og4;
        this.omh = og5;
        this.Bzk = og6;
        this.SGo = z;
        this.BSW = z2;
    }

    public String pA() {
        return this.pA;
    }

    public pA Og() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og KZx() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> ZZv() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og ML() {
        return this.ML;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og JG() {
        return this.JG;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og SD() {
        return this.SD;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og omh() {
        return this.omh;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og Bzk() {
        return this.Bzk;
    }

    public boolean SGo() {
        return this.SGo;
    }

    public boolean BSW() {
        return this.BSW;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.Sn(bzk, pAVar, this);
    }
}
