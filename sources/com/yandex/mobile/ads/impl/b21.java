package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class b21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f8469a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] b = {44100, 48000, 32000};
    private static final int[] c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int b(int i) {
        int i2;
        int i3;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 != 0 && i4 != 15 && i5 != 3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return 384;
                    }
                    throw new IllegalArgumentException();
                }
            } else if (i2 != 3) {
                return 576;
            }
            return 1152;
        }
        return -1;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8470a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        /* JADX WARN: Code duplicated, block: B:30:0x005b  */
        public final boolean a(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.f8470a = i2;
            this.b = b21.f8469a[3 - i3];
            int i7 = b21.b[i5];
            this.d = i7;
            if (i2 == 2) {
                this.d = i7 / 2;
            } else if (i2 == 0) {
                this.d = i7 / 4;
            }
            int i8 = (i >>> 9) & 1;
            if (i3 != 1) {
                if (i3 == 2) {
                    i6 = 1152;
                } else {
                    if (i3 != 3) {
                        throw new IllegalArgumentException();
                    }
                    i6 = 384;
                }
            } else if (i2 == 3) {
                i6 = 1152;
            } else {
                i6 = 576;
            }
            this.g = i6;
            if (i3 == 3) {
                int i9 = i2 == 3 ? b21.c[i4 - 1] : b21.d[i4 - 1];
                this.f = i9;
                this.c = (((i9 * 12) / this.d) + i8) * 4;
            } else {
                if (i2 == 3) {
                    int i10 = i3 == 2 ? b21.e[i4 - 1] : b21.f[i4 - 1];
                    this.f = i10;
                    this.c = ((i10 * 144) / this.d) + i8;
                } else {
                    int i11 = b21.g[i4 - 1];
                    this.f = i11;
                    this.c = (((i3 == 1 ? 72 : 144) * i11) / this.d) + i8;
                }
            }
            this.e = ((i >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = b[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? c[i4 - 1] : d[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? e[i4 - 1] : f[i4 - 1];
        } else {
            i6 = g[i4 - 1];
        }
        if (i2 == 3) {
            return ((i6 * 144) / i7) + i8;
        }
        return (((i3 == 1 ? 72 : 144) * i6) / i7) + i8;
    }
}
