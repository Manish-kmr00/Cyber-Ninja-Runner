package com.bytedance.adsdk.Og.KZx.Og;

import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv {
    private final int[] Og;
    private final float[] pA;

    public ZZv(float[] fArr, int[] iArr) {
        this.pA = fArr;
        this.Og = iArr;
    }

    public float[] pA() {
        return this.pA;
    }

    public int[] Og() {
        return this.Og;
    }

    public int KZx() {
        return this.Og.length;
    }

    public void pA(ZZv zZv, ZZv zZv2, float f) {
        if (zZv.Og.length != zZv2.Og.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + zZv.Og.length + " vs " + zZv2.Og.length + ")");
        }
        for (int i = 0; i < zZv.Og.length; i++) {
            this.pA[i] = com.bytedance.adsdk.Og.JG.ML.pA(zZv.pA[i], zZv2.pA[i], f);
            this.Og[i] = com.bytedance.adsdk.Og.JG.Og.pA(f, zZv.Og[i], zZv2.Og[i]);
        }
    }

    public ZZv pA(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = pA(fArr[i]);
        }
        return new ZZv(fArr, iArr);
    }

    private int pA(float f) {
        int iBinarySearch = Arrays.binarySearch(this.pA, f);
        if (iBinarySearch >= 0) {
            return this.Og[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.Og[0];
        }
        int[] iArr = this.Og;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.pA;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.Og.JG.Og.pA((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
