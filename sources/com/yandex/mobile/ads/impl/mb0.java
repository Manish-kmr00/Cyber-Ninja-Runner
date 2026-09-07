package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
final class mb0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f9620a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;

        private a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.f9620a = jArr;
            this.b = iArr;
            this.c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
        }
    }

    public static a a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int i3 = 0;
        for (int i4 : iArr) {
            int i5 = x82.f10629a;
            i3 += ((i4 + i2) - 1) / i2;
        }
        long[] jArr2 = new long[i3];
        int[] iArr2 = new int[i3];
        long[] jArr3 = new long[i3];
        int[] iArr3 = new int[i3];
        int i6 = 0;
        int i7 = 0;
        int iMax = 0;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            long j2 = jArr[i8];
            while (i9 > 0) {
                int iMin = Math.min(i2, i9);
                jArr2[i7] = j2;
                int i10 = i * iMin;
                iArr2[i7] = i10;
                iMax = Math.max(iMax, i10);
                jArr3[i7] = ((long) i6) * j;
                iArr3[i7] = 1;
                j2 += (long) iArr2[i7];
                i6 += iMin;
                i9 -= iMin;
                i7++;
                jArr2 = jArr2;
            }
        }
        return new a(jArr2, iArr2, iMax, jArr3, iArr3, j * ((long) i6));
    }
}
