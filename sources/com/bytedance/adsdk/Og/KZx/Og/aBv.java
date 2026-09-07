package com.bytedance.adsdk.Og.KZx.Og;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class aBv implements KZx {
    private final com.bytedance.adsdk.Og.KZx.pA.omh KZx;
    private final int Og;
    private final boolean ZZv;
    private final String pA;

    public aBv(String str, int i, com.bytedance.adsdk.Og.KZx.pA.omh omhVar, boolean z) {
        this.pA = str;
        this.Og = i;
        this.KZx = omhVar;
        this.ZZv = z;
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.omh Og() {
        return this.KZx;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.XT(bzk, pAVar, this);
    }

    public boolean KZx() {
        return this.ZZv;
    }

    public String toString() {
        return "ShapePath{name=" + this.pA + ", index=" + this.Og + AbstractJsonLexerKt.END_OBJ;
    }
}
