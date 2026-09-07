package com.bytedance.adsdk.Og.KZx.Og;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class Bzk implements KZx {
    private final boolean KZx;
    private final pA Og;
    private final String pA;

    public enum pA {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static pA pA(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public Bzk(String str, pA pAVar, boolean z) {
        this.pA = str;
        this.Og = pAVar;
        this.KZx = z;
    }

    public String pA() {
        return this.pA;
    }

    public pA Og() {
        return this.Og;
    }

    public boolean KZx() {
        return this.KZx;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new com.bytedance.adsdk.Og.pA.pA.WV(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.Og + AbstractJsonLexerKt.END_OBJ;
    }
}
