package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class dd implements w70 {
    private static final int[] p;
    private static final int[] q;
    private static final byte[] r;
    private static final byte[] s;
    private static final int t;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private boolean g;
    private long h;
    private int j;
    private long k;
    private y70 l;
    private t52 m;
    private xw1 n;
    private boolean o;
    private final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f8682a = new byte[1];
    private int i = -1;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.dd$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return dd.a();
            }
        };
        p = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        q = iArr;
        r = x82.c("#!AMR\n");
        s = x82.c("#!AMR-WB\n");
        t = iArr[8];
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.l = y70Var;
        this.m = y70Var.a(0, 1);
        y70Var.a();
    }

    private int a(tz tzVar) throws IOException {
        boolean z;
        tzVar.c();
        tzVar.b(this.f8682a, 0, 1, false);
        byte b = this.f8682a[0];
        if ((b & 131) > 0) {
            throw ag1.a("Invalid padding bits for frame header " + ((int) b), (Exception) null);
        }
        int i = (b >> 3) & 15;
        if (i < 0 || i > 15 || ((!(z = this.c) || (i >= 10 && i <= 13)) && (z || (i >= 12 && i <= 14)))) {
            throw ag1.a("Illegal AMR " + (this.c ? "WB" : "NB") + " frame type " + i, (Exception) null);
        }
        return z ? q[i] : p[i];
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c8  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i;
        int i2;
        int iB;
        int i3;
        if (this.m != null) {
            int i4 = x82.f10629a;
            tz tzVar = (tz) x70Var;
            if (tzVar.a() == 0) {
                byte[] bArr = r;
                tzVar.c();
                byte[] bArr2 = new byte[bArr.length];
                tzVar.b(bArr2, 0, bArr.length, false);
                if (Arrays.equals(bArr2, bArr)) {
                    this.c = false;
                    tzVar.a(bArr.length);
                } else {
                    byte[] bArr3 = s;
                    tzVar.c();
                    byte[] bArr4 = new byte[bArr3.length];
                    tzVar.b(bArr4, 0, bArr3.length, false);
                    if (Arrays.equals(bArr4, bArr3)) {
                        this.c = true;
                        tzVar.a(bArr3.length);
                    } else {
                        throw ag1.a("Could not find AMR header.", (Exception) null);
                    }
                }
            }
            if (!this.o) {
                this.o = true;
                boolean z = this.c;
                this.m.a(new gc0.a().e(z ? "audio/amr-wb" : "audio/3gpp").h(t).c(1).l(z ? 16000 : 8000).a());
            }
            if (this.f == 0) {
                try {
                    int iA = a((tz) x70Var);
                    this.e = iA;
                    this.f = iA;
                    if (this.i == -1) {
                        this.h = tzVar.a();
                        this.i = this.e;
                    }
                    if (this.i == this.e) {
                        this.j++;
                    }
                    iB = this.m.b(x70Var, this.f, true);
                    if (iB == -1) {
                        i = -1;
                    } else {
                        i3 = this.f - iB;
                        this.f = i3;
                        if (i3 <= 0) {
                            this.m.a(this.k + this.d, 1, this.e, 0, null);
                            this.d += 20000;
                        }
                        i = 0;
                    }
                } catch (EOFException unused) {
                }
            } else {
                iB = this.m.b(x70Var, this.f, true);
                if (iB == -1) {
                    i = -1;
                } else {
                    i3 = this.f - iB;
                    this.f = i3;
                    if (i3 <= 0) {
                        this.m.a(this.k + this.d, 1, this.e, 0, null);
                        this.d += 20000;
                    }
                    i = 0;
                }
            }
            long jB = tzVar.b();
            if (!this.g) {
                int i5 = this.b;
                if ((i5 & 1) != 0 && jB != -1 && ((i2 = this.i) == -1 || i2 == this.e)) {
                    if (this.j >= 20 || i == -1) {
                        tr trVar = new tr((int) ((((long) i2) * 8000000) / 20000), i2, jB, this.h, (i5 & 2) != 0);
                        this.n = trVar;
                        this.l.a(trVar);
                        this.g = true;
                    }
                } else {
                    xw1.b bVar = new xw1.b(-9223372036854775807L, 0L);
                    this.n = bVar;
                    this.l.a(bVar);
                    this.g = true;
                }
            }
            return i;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            xw1 xw1Var = this.n;
            if (xw1Var instanceof tr) {
                this.k = ((tr) xw1Var).c(j);
                return;
            }
        }
        this.k = 0L;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar = (tz) x70Var;
        byte[] bArr = r;
        tzVar.c();
        byte[] bArr2 = new byte[bArr.length];
        tzVar.b(bArr2, 0, bArr.length, false);
        if (Arrays.equals(bArr2, bArr)) {
            this.c = false;
            tzVar.a(bArr.length);
        } else {
            byte[] bArr3 = s;
            tzVar.c();
            byte[] bArr4 = new byte[bArr3.length];
            tzVar.b(bArr4, 0, bArr3.length, false);
            if (!Arrays.equals(bArr4, bArr3)) {
                return false;
            }
            this.c = true;
            tzVar.a(bArr3.length);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new dd()};
    }
}
