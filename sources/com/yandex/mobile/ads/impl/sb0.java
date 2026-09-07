package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class sb0 implements w70 {
    private y70 e;
    private t52 f;
    private g01 h;
    private xb0 i;
    private int j;
    private int k;
    private rb0 l;
    private int m;
    private long n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10194a = new byte[42];
    private final wf1 b = new wf1(0, new byte[32768]);
    private final boolean c = false;
    private final tb0.a d = new tb0.a();
    private int g = 0;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.sb0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return sb0.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.e = y70Var;
        this.f = y70Var.a(0, 1);
        y70Var.a();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        boolean zF;
        xw1 bVar;
        long j;
        boolean zA;
        int i = this.g;
        g01 g01Var = null;
        boolean z = true;
        if (i == 0) {
            boolean z2 = this.c;
            tz tzVar = (tz) x70Var;
            tzVar.c();
            long jD = tzVar.d();
            g01 g01VarA = new ri0().a(tzVar, !z2 ? null : pi0.b);
            if (g01VarA != null && g01VarA.c() != 0) {
                g01Var = g01VarA;
            }
            tzVar.a((int) (tzVar.d() - jD));
            this.h = g01Var;
            this.g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.f10194a;
            tz tzVar2 = (tz) x70Var;
            tzVar2.b(bArr, 0, bArr.length, false);
            tzVar2.c();
            this.g = 2;
            return 0;
        }
        if (i == 2) {
            wf1 wf1Var = new wf1(4);
            ((tz) x70Var).a(wf1Var.c(), 0, 4, false);
            if (wf1Var.v() == 1716281667) {
                this.g = 3;
                return 0;
            }
            throw ag1.a("Failed to read FLAC stream marker.", (Exception) null);
        }
        if (i == 3) {
            xb0 xb0VarA = this.i;
            do {
                tz tzVar3 = (tz) x70Var;
                tzVar3.c();
                byte[] bArr2 = new byte[4];
                vf1 vf1Var = new vf1(4, bArr2);
                tzVar3.b(bArr2, 0, 4, false);
                zF = vf1Var.f();
                int iB = vf1Var.b(7);
                int iB2 = vf1Var.b(24) + 4;
                if (iB == 0) {
                    byte[] bArr3 = new byte[38];
                    tzVar3.a(bArr3, 0, 38, false);
                    xb0VarA = new xb0(4, bArr3);
                } else {
                    if (xb0VarA == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iB == 3) {
                        wf1 wf1Var2 = new wf1(iB2);
                        tzVar3.a(wf1Var2.c(), 0, iB2, false);
                        xb0VarA = xb0VarA.a(ub0.a(wf1Var2));
                    } else if (iB == 4) {
                        wf1 wf1Var3 = new wf1(iB2);
                        tzVar3.a(wf1Var3.c(), 0, iB2, false);
                        wf1Var3.f(4);
                        xb0VarA = xb0VarA.b(Arrays.asList(yi2.a(wf1Var3, false, false).f10740a));
                    } else if (iB == 6) {
                        wf1 wf1Var4 = new wf1(iB2);
                        tzVar3.a(wf1Var4.c(), 0, iB2, false);
                        wf1Var4.f(4);
                        int iH = wf1Var4.h();
                        String strA = wf1Var4.a(wf1Var4.h(), ko.f9439a);
                        String strA2 = wf1Var4.a(wf1Var4.h(), ko.c);
                        int iH2 = wf1Var4.h();
                        int iH3 = wf1Var4.h();
                        int iH4 = wf1Var4.h();
                        int iH5 = wf1Var4.h();
                        int iH6 = wf1Var4.h();
                        byte[] bArr4 = new byte[iH6];
                        wf1Var4.a(bArr4, 0, iH6);
                        xb0VarA = xb0VarA.a(hk0.a(new fh1(iH, strA, strA2, iH2, iH3, iH4, iH5, bArr4)));
                    } else {
                        tzVar3.a(iB2);
                    }
                }
                int i2 = x82.f10629a;
                this.i = xb0VarA;
            } while (!zF);
            this.j = Math.max(xb0VarA.c, 6);
            this.f.a(this.i.a(this.f10194a, this.h));
            this.g = 4;
            return 0;
        }
        long j2 = 0;
        if (i == 4) {
            tz tzVar4 = (tz) x70Var;
            tzVar4.c();
            wf1 wf1Var5 = new wf1(2);
            tzVar4.b(wf1Var5.c(), 0, 2, false);
            int iZ = wf1Var5.z();
            if ((iZ >> 2) == 16382) {
                tzVar4.c();
                this.k = iZ;
                y70 y70Var = this.e;
                int i3 = x82.f10629a;
                long jA = tzVar4.a();
                long jB = tzVar4.b();
                this.i.getClass();
                xb0 xb0Var = this.i;
                if (xb0Var.k != null) {
                    bVar = new wb0(xb0Var, jA);
                } else if (jB != -1 && xb0Var.j > 0) {
                    rb0 rb0Var = new rb0(xb0Var, this.k, jA, jB);
                    this.l = rb0Var;
                    bVar = rb0Var.a();
                } else {
                    bVar = new xw1.b(xb0Var.b(), 0L);
                }
                y70Var.a(bVar);
                this.g = 5;
                return 0;
            }
            tzVar4.c();
            throw ag1.a("First frame does not start with sync code.", (Exception) null);
        }
        if (i != 5) {
            throw new IllegalStateException();
        }
        this.f.getClass();
        this.i.getClass();
        rb0 rb0Var2 = this.l;
        if (rb0Var2 != null && rb0Var2.b()) {
            return this.l.a((tz) x70Var, lj1Var);
        }
        if (this.n == -1) {
            xb0 xb0Var2 = this.i;
            tz tzVar5 = (tz) x70Var;
            tzVar5.c();
            tzVar5.a(false, 1);
            byte[] bArr5 = new byte[1];
            tzVar5.b(bArr5, 0, 1, false);
            boolean z3 = (bArr5[0] & 1) == 1;
            tzVar5.a(false, 2);
            int i4 = z3 ? 7 : 6;
            wf1 wf1Var6 = new wf1(i4);
            byte[] bArrC = wf1Var6.c();
            int i5 = 0;
            while (i5 < i4) {
                int iC = tzVar5.c(bArrC, i5, i4 - i5);
                if (iC == -1) {
                    break;
                }
                i5 += iC;
            }
            wf1Var6.d(i5);
            tzVar5.c();
            try {
                long jA2 = wf1Var6.A();
                if (!z3) {
                    jA2 *= (long) xb0Var2.b;
                }
                j2 = jA2;
            } catch (NumberFormatException unused) {
                z = false;
            }
            if (z) {
                this.n = j2;
                return 0;
            }
            throw ag1.a((String) null, (Exception) null);
        }
        int iE = this.b.e();
        if (iE < 32768) {
            int i6 = ((tz) x70Var).read(this.b.c(), iE, 32768 - iE);
            z = i6 == -1;
            if (!z) {
                this.b.d(iE + i6);
            } else if (this.b.a() == 0) {
                long j3 = this.n * 1000000;
                xb0 xb0Var3 = this.i;
                int i7 = x82.f10629a;
                this.f.a(j3 / ((long) xb0Var3.e), 1, this.m, 0, null);
                return -1;
            }
        } else {
            z = false;
        }
        int iD = this.b.d();
        int i8 = this.m;
        int i9 = this.j;
        if (i8 < i9) {
            wf1 wf1Var7 = this.b;
            wf1Var7.f(Math.min(i9 - i8, wf1Var7.a()));
        }
        wf1 wf1Var8 = this.b;
        this.i.getClass();
        int iD2 = wf1Var8.d();
        while (true) {
            if (iD2 > wf1Var8.e() - 16) {
                if (z) {
                    while (true) {
                        if (iD2 <= wf1Var8.e() - this.j) {
                            wf1Var8.e(iD2);
                            try {
                                zA = tb0.a(wf1Var8, this.i, this.k, this.d);
                            } catch (IndexOutOfBoundsException unused2) {
                                zA = false;
                            }
                            if (wf1Var8.d() <= wf1Var8.e() && zA) {
                                wf1Var8.e(iD2);
                                j = this.d.f10282a;
                                break;
                            }
                            iD2++;
                        } else {
                            wf1Var8.e(wf1Var8.e());
                        }
                    }
                } else {
                    wf1Var8.e(iD2);
                }
                j = -1;
                break;
            }
            wf1Var8.e(iD2);
            if (tb0.a(wf1Var8, this.i, this.k, this.d)) {
                wf1Var8.e(iD2);
                j = this.d.f10282a;
                break;
            }
            iD2++;
        }
        int iD3 = this.b.d() - iD;
        this.b.e(iD);
        this.f.a(iD3, this.b);
        int i10 = this.m + iD3;
        this.m = i10;
        if (j != -1) {
            long j4 = this.n * 1000000;
            xb0 xb0Var4 = this.i;
            int i11 = x82.f10629a;
            this.f.a(j4 / ((long) xb0Var4.e), 1, i10, 0, null);
            this.m = 0;
            this.n = j;
        }
        if (this.b.a() >= 16) {
            return 0;
        }
        int iA = this.b.a();
        System.arraycopy(this.b.c(), this.b.d(), this.b.c(), 0, iA);
        this.b.e(0);
        this.b.d(iA);
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            rb0 rb0Var = this.l;
            if (rb0Var != null) {
                rb0Var.a(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.c(0);
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar = (tz) x70Var;
        g01 g01VarA = new ri0().a(tzVar, pi0.b);
        if (g01VarA != null) {
            g01VarA.c();
        }
        wf1 wf1Var = new wf1(4);
        tzVar.b(wf1Var.c(), 0, 4, false);
        return wf1Var.v() == 1716281667;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new sb0()};
    }
}
