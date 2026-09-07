package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class DX implements KZx {
    private final boolean JG;
    private final String KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.ZZv ML;
    private final Path.FillType Og;
    private final com.bytedance.adsdk.Og.KZx.pA.pA ZZv;
    private final boolean pA;

    public DX(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.Og.KZx.pA.pA pAVar, com.bytedance.adsdk.Og.KZx.pA.ZZv zZv, boolean z2) {
        this.KZx = str;
        this.pA = z;
        this.Og = fillType;
        this.ZZv = pAVar;
        this.ML = zZv;
        this.JG = z2;
    }

    public String pA() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.pA Og() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.ZZv KZx() {
        return this.ML;
    }

    public Path.FillType ZZv() {
        return this.Og;
    }

    public boolean ML() {
        return this.JG;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.SD(bzk, pAVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.pA + AbstractJsonLexerKt.END_OBJ;
    }
}
