package com.bytedance.sdk.openadsdk.core;

/* JADX INFO: loaded from: classes5.dex */
public class TV {
    private static TV pA;
    private com.bytedance.sdk.openadsdk.pA.ZZv.Og JG;
    private com.bytedance.sdk.openadsdk.core.model.yFO KZx;
    private com.bytedance.sdk.openadsdk.pA.KZx.Og ML;
    private com.bytedance.sdk.openadsdk.core.model.pA Og;
    private com.bytedance.sdk.openadsdk.pA.ML.pA ZZv;

    private TV() {
    }

    public static TV pA() {
        if (pA == null) {
            pA = new TV();
        }
        return pA;
    }

    public com.bytedance.sdk.openadsdk.core.model.yFO Og() {
        return this.KZx;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        this.KZx = yfo;
    }

    public com.bytedance.sdk.openadsdk.pA.ML.pA KZx() {
        return this.ZZv;
    }

    public com.bytedance.sdk.openadsdk.pA.KZx.Og ZZv() {
        return this.ML;
    }

    public com.bytedance.sdk.openadsdk.pA.ZZv.Og ML() {
        return this.JG;
    }

    public void pA(com.bytedance.sdk.openadsdk.pA.KZx.Og og) {
        this.ML = og;
    }

    public void pA(com.bytedance.sdk.openadsdk.pA.ML.pA pAVar) {
        this.ZZv = pAVar;
    }

    public void pA(com.bytedance.sdk.openadsdk.pA.ZZv.Og og) {
        this.JG = og;
    }

    public void JG() {
        this.KZx = null;
        this.Og = null;
        this.ZZv = null;
        this.ML = null;
        this.JG = null;
    }

    public com.bytedance.sdk.openadsdk.core.model.pA SD() {
        return this.Og;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.Og = pAVar;
    }
}
