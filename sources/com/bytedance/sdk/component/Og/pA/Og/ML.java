package com.bytedance.sdk.component.Og.pA.Og;

/* JADX INFO: loaded from: classes8.dex */
final class ML {
    ML JG;
    int KZx;
    boolean ML;
    int Og;
    ML SD;
    boolean ZZv;
    final byte[] pA;

    ML() {
        this.pA = new byte[8192];
        this.ML = true;
        this.ZZv = false;
    }

    ML(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.pA = bArr;
        this.Og = i;
        this.KZx = i2;
        this.ZZv = z;
        this.ML = z2;
    }

    final ML pA() {
        this.ZZv = true;
        return new ML(this.pA, this.Og, this.KZx, true, false);
    }

    public final ML Og() {
        ML ml = this.JG;
        ML ml2 = ml != this ? ml : null;
        ML ml3 = this.SD;
        if (ml3 != null) {
            ml3.JG = ml;
        }
        ML ml4 = this.JG;
        if (ml4 != null) {
            ml4.SD = ml3;
        }
        this.JG = null;
        this.SD = null;
        return ml2;
    }

    public final ML pA(ML ml) {
        ml.SD = this;
        ml.JG = this.JG;
        this.JG.SD = ml;
        this.JG = ml;
        return ml;
    }
}
