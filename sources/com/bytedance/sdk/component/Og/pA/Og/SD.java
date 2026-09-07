package com.bytedance.sdk.component.Og.pA.Og;

import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
final class SD extends ZZv {
    final transient byte[][] SD;
    final transient int[] omh;

    SD(pA pAVar, int i) {
        super(null);
        Bzk.pA(pAVar.Og, 0L, i);
        ML ml = pAVar.pA;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (ml.KZx == ml.Og) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += ml.KZx - ml.Og;
            i4++;
            ml = ml.JG;
        }
        this.SD = new byte[i4][];
        this.omh = new int[i4 * 2];
        ML ml2 = pAVar.pA;
        int i5 = 0;
        while (i2 < i) {
            this.SD[i5] = ml2.pA;
            i2 += ml2.KZx - ml2.Og;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.omh;
            iArr[i5] = i2;
            iArr[this.SD.length + i5] = ml2.Og;
            ml2.ZZv = true;
            i5++;
            ml2 = ml2.JG;
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public String pA() {
        return ML().pA();
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public String Og() {
        return ML().Og();
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public ZZv pA(int i, int i2) {
        return ML().pA(i, i2);
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public byte pA(int i) {
        Bzk.pA(this.omh[this.SD.length - 1], i, 1L);
        int iOg = Og(i);
        int i2 = iOg == 0 ? 0 : this.omh[iOg - 1];
        int[] iArr = this.omh;
        byte[][] bArr = this.SD;
        return bArr[iOg][(i - i2) + iArr[bArr.length + iOg]];
    }

    private int Og(int i) {
        int iBinarySearch = Arrays.binarySearch(this.omh, 0, this.SD.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public int KZx() {
        return this.omh[this.SD.length - 1];
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public byte[] ZZv() {
        int[] iArr = this.omh;
        byte[][] bArr = this.SD;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.omh;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.SD[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public boolean pA(int i, ZZv zZv, int i2, int i3) {
        if (i < 0 || i > KZx() - i3) {
            return false;
        }
        int iOg = Og(i);
        while (i3 > 0) {
            int i4 = iOg == 0 ? 0 : this.omh[iOg - 1];
            int iMin = Math.min(i3, ((this.omh[iOg] - i4) + i4) - i);
            int[] iArr = this.omh;
            byte[][] bArr = this.SD;
            if (!zZv.pA(i2, bArr[iOg], (i - i4) + iArr[bArr.length + iOg], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iOg++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public boolean pA(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > KZx() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iOg = Og(i);
        while (i3 > 0) {
            int i4 = iOg == 0 ? 0 : this.omh[iOg - 1];
            int iMin = Math.min(i3, ((this.omh[iOg] - i4) + i4) - i);
            int[] iArr = this.omh;
            byte[][] bArr2 = this.SD;
            if (!Bzk.pA(bArr2[iOg], (i - i4) + iArr[bArr2.length + iOg], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iOg++;
        }
        return true;
    }

    private ZZv ML() {
        return new ZZv(ZZv());
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZZv) {
            ZZv zZv = (ZZv) obj;
            if (zZv.KZx() == KZx() && pA(0, zZv, 0, KZx())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public int hashCode() {
        int i = this.ML;
        if (i != 0) {
            return i;
        }
        int length = this.SD.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.SD[i2];
            int[] iArr = this.omh;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.ML = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.Og.pA.Og.ZZv
    public String toString() {
        return ML().toString();
    }
}
