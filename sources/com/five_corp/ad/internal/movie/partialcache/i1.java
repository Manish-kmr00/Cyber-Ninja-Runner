package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes6.dex */
public final class i1 {
    public static final /* synthetic */ boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0 f1480a;
    public final E0 b;
    public final E c;
    public final D d;
    public final C e;
    public final long[] f;
    public final long[] g;
    public final long h;
    public final int i;
    public final int[] j;

    public i1(long j, F0 f0) {
        I0 i0;
        this.h = j;
        this.f1480a = (I0) j1.a(f0, I0.class);
        E0 e0 = (E0) j1.a(f0, E0.class);
        this.b = e0;
        E e = (E) j1.a(f0, E.class);
        this.c = e;
        T0 t0 = (T0) j1.a(f0, T0.class);
        this.d = (D) j1.a(f0, D.class);
        this.e = (C) j1.a(f0, C.class);
        int length = e0 != null ? e0.i : e != null ? e.h.length : 0;
        this.i = length;
        this.j = new int[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.i; i5++) {
            if (i <= 0 && (i0 = this.f1480a) != null) {
                if (i0.h.size() <= i2 || ((H0) this.f1480a.h.get(i2)).f1460a > i3 + 2) {
                    i3++;
                    i = i4;
                } else {
                    H0 h0 = (H0) this.f1480a.h.get(i2);
                    i3 = h0.f1460a - 1;
                    i = h0.b;
                    i2++;
                    i4 = i;
                }
            }
            this.j[i5] = i3;
            i--;
        }
        W0 w0 = (W0) j1.a(f0, W0.class);
        this.f = new long[this.i];
        if (w0 != null) {
            long j2 = 0;
            int i6 = 0;
            for (V0 v0 : w0.h) {
                for (int i7 = 0; i7 < v0.f1463a; i7++) {
                    this.f[i6] = (1000000 * j2) / this.h;
                    j2 += (long) v0.b;
                    i6++;
                }
            }
        }
        if (t0 == null) {
            this.g = null;
            return;
        }
        int size = t0.h.size();
        this.g = new long[size];
        for (int i8 = 0; i8 < size; i8++) {
            this.g[i8] = ((Integer) t0.h.get(i8)).intValue();
        }
    }

    public final int a(int i) {
        int i2;
        int i3 = i + 1;
        int i4 = i3 >= this.i ? 4 : 0;
        long[] jArr = this.g;
        if (jArr != null) {
            long j = i3;
            int length = jArr.length;
            if (length != 0 && j >= jArr[0]) {
                int i5 = length - 1;
                if (j < jArr[i5]) {
                    int i6 = length;
                    i2 = length / 2;
                    int i7 = 0;
                    while (true) {
                        long j2 = jArr[i2];
                        if (j2 <= j && j < jArr[i2 + 1]) {
                            break;
                        }
                        if (j < j2) {
                            i6 = i2;
                        } else {
                            i7 = i2;
                        }
                        i2 = ((i6 - i7) / 2) + i7;
                    }
                } else {
                    i2 = i5;
                }
            } else {
                i2 = -1;
            }
            if (this.g[i2] != j) {
                return i4;
            }
        }
        return i4 | 1;
    }

    public final int b(int i) {
        int iIntValue;
        int i2 = this.j[i];
        int iC = 0;
        for (int i3 = i - 1; i3 >= 0 && this.j[i3] == i2; i3--) {
            iC += c(i3);
        }
        if (i2 == -1) {
            return -1;
        }
        D d = this.d;
        if (d != null) {
            if (d.h.size() <= i2) {
                return -1;
            }
            iIntValue = ((Integer) this.d.h.get(i2)).intValue();
        } else {
            if (!k && this.e == null) {
                throw new AssertionError();
            }
            if (this.e.h.size() <= i2) {
                return -1;
            }
            iIntValue = ((Long) this.e.h.get(i2)).intValue();
        }
        return iIntValue + iC;
    }

    public final int c(int i) {
        E0 e0 = this.b;
        if (e0 != null) {
            if (i >= e0.i) {
                return -1;
            }
            int i2 = e0.h;
            return i2 == 0 ? e0.j[i] : i2;
        }
        if (!k && this.c == null) {
            throw new AssertionError();
        }
        int[] iArr = this.c.h;
        if (i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }
}
