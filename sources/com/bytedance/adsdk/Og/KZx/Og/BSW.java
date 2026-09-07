package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class BSW implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> KZx;
    private final boolean ML;
    private final com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> Og;
    private final com.bytedance.adsdk.Og.KZx.pA.Og ZZv;
    private final String pA;

    public BSW(String str, com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wx, com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wx2, com.bytedance.adsdk.Og.KZx.pA.Og og, boolean z) {
        this.pA = str;
        this.Og = wx;
        this.KZx = wx2;
        this.ZZv = og;
        this.ML = z;
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og Og() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> KZx() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> ZZv() {
        return this.Og;
    }

    public boolean ML() {
        return this.ML;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.DX(bzk, pAVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.Og + ", size=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
    }
}
