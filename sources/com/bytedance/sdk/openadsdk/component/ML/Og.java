package com.bytedance.sdk.openadsdk.component.ML;

import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    private String JG;
    private yFO KZx;
    private int ML;
    private int Og;
    private boolean SD;
    private com.bytedance.sdk.openadsdk.core.model.pA ZZv;
    private int pA;

    public Og(int i, int i2, yFO yfo, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        this.pA = i;
        this.Og = i2;
        this.KZx = yfo;
        this.ZZv = pAVar;
    }

    public Og(int i, int i2, int i3, String str) {
        this.pA = i;
        this.Og = i2;
        this.ML = i3;
        this.JG = str;
    }

    public com.bytedance.sdk.openadsdk.core.model.pA pA() {
        return this.ZZv;
    }

    public void pA(boolean z) {
        this.SD = z;
    }

    public boolean Og() {
        return this.SD;
    }

    public int KZx() {
        return this.pA;
    }

    public int ZZv() {
        return this.Og;
    }

    public yFO ML() {
        return this.KZx;
    }

    public int JG() {
        return this.ML;
    }

    public String SD() {
        return this.JG;
    }
}
