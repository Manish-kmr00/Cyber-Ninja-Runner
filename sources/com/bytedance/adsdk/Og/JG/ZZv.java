package com.bytedance.adsdk.Og.JG;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv {
    private int Og;
    private float pA;

    public void pA(float f) {
        float f2 = this.pA + f;
        this.pA = f2;
        int i = this.Og + 1;
        this.Og = i;
        if (i == Integer.MAX_VALUE) {
            this.pA = f2 / 2.0f;
            this.Og = i / 2;
        }
    }
}
