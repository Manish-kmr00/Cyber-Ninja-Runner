package com.bytedance.adsdk.Og.KZx.Og;

import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public class oX implements KZx {
    private final boolean KZx;
    private final List<KZx> Og;
    private final String pA;

    public oX(String str, List<KZx> list, boolean z) {
        this.pA = str;
        this.Og = list;
        this.KZx = z;
    }

    public String pA() {
        return this.pA;
    }

    public List<KZx> Og() {
        return this.Og;
    }

    public boolean KZx() {
        return this.KZx;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.ZZv(bzk, pAVar, this, sd);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.pA + "' Shapes: " + Arrays.toString(this.Og.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
