package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

/* JADX INFO: loaded from: classes13.dex */
public final class e {
    public int i;
    public int j;
    public int k;
    public int l;
    public com.fyber.inneractive.sdk.player.exoplayer2.o q;
    public int r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2001a = 1000;
    public int[] b = new int[1000];
    public long[] c = new long[1000];
    public long[] f = new long[1000];
    public int[] e = new int[1000];
    public int[] d = new int[1000];
    public byte[][] g = new byte[1000][];
    public com.fyber.inneractive.sdk.player.exoplayer2.o[] h = new com.fyber.inneractive.sdk.player.exoplayer2.o[1000];
    public long m = Long.MIN_VALUE;
    public long n = Long.MIN_VALUE;
    public boolean p = true;
    public boolean o = true;

    public final synchronized void a(long j, int i, long j2, int i2, byte[] bArr) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        if (this.p) {
            throw new IllegalStateException();
        }
        b(j);
        long[] jArr = this.f;
        int i3 = this.l;
        jArr[i3] = j;
        long[] jArr2 = this.c;
        jArr2[i3] = j2;
        this.d[i3] = i2;
        this.e[i3] = i;
        this.g[i3] = bArr;
        this.h[i3] = this.q;
        this.b[i3] = this.r;
        int i4 = this.i + 1;
        this.i = i4;
        int i5 = this.f2001a;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr3 = new long[i6];
            long[] jArr4 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            byte[][] bArr2 = new byte[i6][];
            com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.o[i6];
            int i7 = this.k;
            int i8 = i5 - i7;
            System.arraycopy(jArr2, i7, jArr3, 0, i8);
            System.arraycopy(this.f, this.k, jArr4, 0, i8);
            System.arraycopy(this.e, this.k, iArr2, 0, i8);
            System.arraycopy(this.d, this.k, iArr3, 0, i8);
            System.arraycopy(this.g, this.k, bArr2, 0, i8);
            System.arraycopy(this.h, this.k, oVarArr, 0, i8);
            System.arraycopy(this.b, this.k, iArr, 0, i8);
            int i9 = this.k;
            System.arraycopy(this.c, 0, jArr3, i8, i9);
            System.arraycopy(this.f, 0, jArr4, i8, i9);
            System.arraycopy(this.e, 0, iArr2, i8, i9);
            System.arraycopy(this.d, 0, iArr3, i8, i9);
            System.arraycopy(this.g, 0, bArr2, i8, i9);
            System.arraycopy(this.h, 0, oVarArr, i8, i9);
            System.arraycopy(this.b, 0, iArr, i8, i9);
            this.c = jArr3;
            this.f = jArr4;
            this.e = iArr2;
            this.d = iArr3;
            this.g = bArr2;
            this.h = oVarArr;
            this.b = iArr;
            this.k = 0;
            int i10 = this.f2001a;
            this.l = i10;
            this.i = i10;
            this.f2001a = i6;
        } else {
            int i11 = i3 + 1;
            this.l = i11;
            if (i11 == i5) {
                this.l = 0;
            }
        }
    }

    public final synchronized void b(long j) {
        this.n = Math.max(this.n, j);
    }

    public final synchronized boolean a(long j) {
        if (this.m >= j) {
            return false;
        }
        int i = this.i;
        while (i > 0 && this.f[((this.k + i) - 1) % this.f2001a] >= j) {
            i--;
        }
        int i2 = this.j;
        int i3 = this.i;
        int i4 = (i2 + i3) - (i + i2);
        if (i4 < 0 || i4 > i3) {
            throw new IllegalArgumentException();
        }
        if (i4 != 0) {
            int i5 = i3 - i4;
            this.i = i5;
            int i6 = this.l;
            int i7 = this.f2001a;
            this.l = ((i6 + i7) - i4) % i7;
            this.n = Long.MIN_VALUE;
            for (int i8 = i5 - 1; i8 >= 0; i8--) {
                int i9 = (this.k + i8) % this.f2001a;
                this.n = Math.max(this.n, this.f[i9]);
                if ((this.e[i9] & 1) != 0) {
                    break;
                }
            }
            long j2 = this.c[this.l];
        } else if (i2 != 0) {
            int i10 = this.l;
            if (i10 == 0) {
                i10 = this.f2001a;
            }
            int i11 = i10 - 1;
            long j3 = this.c[i11];
            int i12 = this.d[i11];
        }
        return true;
    }
}
