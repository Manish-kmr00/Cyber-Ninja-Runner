package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: classes13.dex */
public interface by1 {

    public static class a implements by1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Random f8547a;
        private final int[] b;
        private final int[] c;

        public a() {
            this(new Random());
        }

        private static int[] a(Random random) {
            return new int[0];
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final a b(int i) {
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                iArr[i3] = this.f8547a.nextInt(this.b.length + 1);
                int i4 = i3 + 1;
                int iNextInt = this.f8547a.nextInt(i4);
                iArr2[i3] = iArr2[iNextInt];
                iArr2[iNextInt] = i3;
                i3 = i4;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.b.length + i];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int[] iArr4 = this.b;
                if (i2 >= iArr4.length + i) {
                    return new a(iArr3, new Random(this.f8547a.nextLong()));
                }
                if (i5 >= i || i6 != iArr[i5]) {
                    int i7 = i6 + 1;
                    int i8 = iArr4[i6];
                    iArr3[i2] = i8;
                    if (i8 >= 0) {
                        iArr3[i2] = i8 + i;
                    }
                    i6 = i7;
                } else {
                    iArr3[i2] = iArr2[i5];
                    i5++;
                }
                i2++;
            }
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final a c(int i) {
            int[] iArr = new int[this.b.length - i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.b;
                if (i2 >= iArr2.length) {
                    return new a(iArr, new Random(this.f8547a.nextLong()));
                }
                int i4 = iArr2[i2];
                if (i4 < 0 || i4 >= i) {
                    int i5 = i2 - i3;
                    if (i4 >= 0) {
                        i4 -= i;
                    }
                    iArr[i5] = i4;
                } else {
                    i3++;
                }
                i2++;
            }
        }

        private a(Random random) {
            this(a(random), random);
        }

        private a(int[] iArr, Random random) {
            this.b = iArr;
            this.f8547a = random;
            this.c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.c[iArr[i]] = i;
            }
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final int d(int i) {
            int i2 = this.c[i] - 1;
            if (i2 >= 0) {
                return this.b[i2];
            }
            return -1;
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final a d() {
            return new a(new int[0], new Random(this.f8547a.nextLong()));
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final int a() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final int b() {
            return this.b.length;
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final int c() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.yandex.mobile.ads.impl.by1
        public final int a(int i) {
            int i2 = this.c[i] + 1;
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }
    }

    int a();

    int a(int i);

    int b();

    a b(int i);

    int c();

    a c(int i);

    int d(int i);

    a d();
}
