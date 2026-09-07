package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
final class g72 {
    private boolean d;
    private boolean e;
    private boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8975a = 112800;
    private final i52 b = new i52(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private final wf1 c = new wf1();

    g72() {
    }

    public final boolean c() {
        return this.d;
    }

    public final long a() {
        return this.i;
    }

    public final int a(tz tzVar, lj1 lj1Var, int i) throws IOException {
        if (i <= 0) {
            this.c.a(x82.f);
            this.d = true;
            tzVar.c();
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.f) {
            long jB = tzVar.b();
            int iMin = (int) Math.min(this.f8975a, jB);
            long j2 = jB - ((long) iMin);
            if (tzVar.a() != j2) {
                lj1Var.f9531a = j2;
                return 1;
            }
            this.c.c(iMin);
            tzVar.c();
            tzVar.b(this.c.c(), 0, iMin, false);
            wf1 wf1Var = this.c;
            int iD = wf1Var.d();
            int iE = wf1Var.e();
            for (int i2 = iE - 188; i2 >= iD; i2--) {
                byte[] bArrC = wf1Var.c();
                int i3 = 0;
                for (int i4 = -4; i4 <= 4; i4++) {
                    int i5 = (i4 * 188) + i2;
                    if (i5 >= iD && i5 < iE && bArrC[i5] == 71) {
                        i3++;
                        if (i3 == 5) {
                            long jA = j72.a(i2, i, wf1Var);
                            if (jA == -9223372036854775807L) {
                                break;
                            }
                            j = jA;
                            break;
                        }
                    } else {
                        i3 = 0;
                    }
                }
            }
            this.h = j;
            this.f = true;
            return 0;
        }
        if (this.h == -9223372036854775807L) {
            this.c.a(x82.f);
            this.d = true;
            tzVar.c();
            return 0;
        }
        if (!this.e) {
            int iMin2 = (int) Math.min(this.f8975a, tzVar.b());
            long j3 = 0;
            if (tzVar.a() != j3) {
                lj1Var.f9531a = j3;
                return 1;
            }
            this.c.c(iMin2);
            tzVar.c();
            tzVar.b(this.c.c(), 0, iMin2, false);
            wf1 wf1Var2 = this.c;
            int iE2 = wf1Var2.e();
            for (int iD2 = wf1Var2.d(); iD2 < iE2; iD2++) {
                if (wf1Var2.c()[iD2] == 71) {
                    long jA2 = j72.a(iD2, i, wf1Var2);
                    if (jA2 != -9223372036854775807L) {
                        j = jA2;
                        break;
                    }
                }
            }
            this.g = j;
            this.e = true;
            return 0;
        }
        long j4 = this.g;
        if (j4 == -9223372036854775807L) {
            this.c.a(x82.f);
            this.d = true;
            tzVar.c();
            return 0;
        }
        long jB2 = this.b.b(this.h) - this.b.b(j4);
        this.i = jB2;
        if (jB2 < 0) {
            at0.d("TsDurationReader", "Invalid duration: " + this.i + ". Using TIME_UNSET instead.");
            this.i = -9223372036854775807L;
        }
        this.c.a(x82.f);
        this.d = true;
        tzVar.c();
        return 0;
    }

    public final i52 b() {
        return this.b;
    }
}
