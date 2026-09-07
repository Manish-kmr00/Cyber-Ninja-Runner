package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
final class tm1 {
    private boolean c;
    private boolean d;
    private boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i52 f10317a = new i52(0);
    private long f = -9223372036854775807L;
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private final wf1 b = new wf1();

    tm1() {
    }

    public final boolean c() {
        return this.c;
    }

    public final i52 b() {
        return this.f10317a;
    }

    public final long a() {
        return this.h;
    }

    public final int a(tz tzVar, lj1 lj1Var) throws IOException {
        long j = -9223372036854775807L;
        if (!this.e) {
            long jB = tzVar.b();
            int iMin = (int) Math.min(20000L, jB);
            long j2 = jB - ((long) iMin);
            if (tzVar.a() != j2) {
                lj1Var.f9531a = j2;
                return 1;
            }
            this.b.c(iMin);
            tzVar.c();
            tzVar.b(this.b.c(), 0, iMin, false);
            wf1 wf1Var = this.b;
            int iD = wf1Var.d();
            for (int iE = wf1Var.e() - 4; iE >= iD; iE--) {
                byte[] bArrC = wf1Var.c();
                if (((bArrC[iE + 3] & 255) | ((bArrC[iE] & 255) << 24) | ((bArrC[iE + 1] & 255) << 16) | ((bArrC[iE + 2] & 255) << 8)) == 442) {
                    wf1Var.e(iE + 4);
                    long jA = a(wf1Var);
                    if (jA != -9223372036854775807L) {
                        j = jA;
                        break;
                    }
                }
            }
            this.g = j;
            this.e = true;
            return 0;
        }
        if (this.g == -9223372036854775807L) {
            this.b.a(x82.f);
            this.c = true;
            tzVar.c();
            return 0;
        }
        if (!this.d) {
            int iMin2 = (int) Math.min(20000L, tzVar.b());
            long j3 = 0;
            if (tzVar.a() != j3) {
                lj1Var.f9531a = j3;
                return 1;
            }
            this.b.c(iMin2);
            tzVar.c();
            tzVar.b(this.b.c(), 0, iMin2, false);
            wf1 wf1Var2 = this.b;
            int iD2 = wf1Var2.d();
            int iE2 = wf1Var2.e();
            while (iD2 < iE2 - 3) {
                byte[] bArrC2 = wf1Var2.c();
                int i = iD2 + 1;
                if (((bArrC2[iD2 + 3] & 255) | ((bArrC2[iD2] & 255) << 24) | ((bArrC2[i] & 255) << 16) | ((bArrC2[iD2 + 2] & 255) << 8)) == 442) {
                    wf1Var2.e(iD2 + 4);
                    long jA2 = a(wf1Var2);
                    if (jA2 != -9223372036854775807L) {
                        j = jA2;
                        break;
                    }
                }
                iD2 = i;
            }
            this.f = j;
            this.d = true;
            return 0;
        }
        long j4 = this.f;
        if (j4 == -9223372036854775807L) {
            this.b.a(x82.f);
            this.c = true;
            tzVar.c();
            return 0;
        }
        long jB2 = this.f10317a.b(this.g) - this.f10317a.b(j4);
        this.h = jB2;
        if (jB2 < 0) {
            at0.d("PsDurationReader", "Invalid duration: " + this.h + ". Using TIME_UNSET instead.");
            this.h = -9223372036854775807L;
        }
        this.b.a(x82.f);
        this.c = true;
        tzVar.c();
        return 0;
    }

    public static long a(wf1 wf1Var) {
        int iD = wf1Var.d();
        if (wf1Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        wf1Var.a(bArr, 0, 9);
        wf1Var.e(iD);
        byte b = bArr[0];
        if ((b & 196) == 68) {
            byte b2 = bArr[2];
            if ((b2 & 4) == 4) {
                byte b3 = bArr[4];
                if ((b3 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j = b;
                    long j2 = b2;
                    return ((j2 & 3) << 13) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }
}
