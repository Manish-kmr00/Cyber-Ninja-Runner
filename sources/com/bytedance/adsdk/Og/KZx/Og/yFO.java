package com.bytedance.adsdk.Og.KZx.Og;

import com.bytedance.adsdk.Og.pA.pA.TX;

/* JADX INFO: loaded from: classes6.dex */
public class yFO implements KZx {
    private final boolean JG;
    private final com.bytedance.adsdk.Og.KZx.pA.Og KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.Og ML;
    private final pA Og;
    private final com.bytedance.adsdk.Og.KZx.pA.Og ZZv;
    private final String pA;

    public enum pA {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static pA pA(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public yFO(String str, pA pAVar, com.bytedance.adsdk.Og.KZx.pA.Og og, com.bytedance.adsdk.Og.KZx.pA.Og og2, com.bytedance.adsdk.Og.KZx.pA.Og og3, boolean z) {
        this.pA = str;
        this.Og = pAVar;
        this.KZx = og;
        this.ZZv = og2;
        this.ML = og3;
        this.JG = z;
    }

    public String pA() {
        return this.pA;
    }

    public pA Og() {
        return this.Og;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og KZx() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og ZZv() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og ML() {
        return this.ML;
    }

    public boolean JG() {
        return this.JG;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new TX(pAVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.KZx + ", end: " + this.ZZv + ", offset: " + this.ML + "}";
    }
}
