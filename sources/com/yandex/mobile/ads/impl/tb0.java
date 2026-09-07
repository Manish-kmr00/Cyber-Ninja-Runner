package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class tb0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10282a;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cc  */
    public static boolean a(wf1 wf1Var, xb0 xb0Var, int i, a aVar) {
        int i2;
        int i3;
        int i4;
        int iT;
        int iD = wf1Var.d();
        long jV = wf1Var.v();
        long j = jV >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        int i5 = (int) ((jV >> 12) & 15);
        int i6 = (int) ((jV >> 8) & 15);
        int i7 = (int) (15 & (jV >> 4));
        int i8 = (int) ((jV >> 1) & 7);
        boolean z2 = (jV & 1) == 1;
        if (i7 > 7 ? !(i7 > 10 || xb0Var.g != 2) : i7 == xb0Var.g - 1) {
            if ((i8 == 0 || i8 == xb0Var.i) && !z2) {
                try {
                    long jA = wf1Var.A();
                    if (!z) {
                        jA *= (long) xb0Var.b;
                    }
                    aVar.f10282a = jA;
                    switch (i5) {
                        case 1:
                            i2 = 192;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            i3 = i5 - 2;
                            i4 = 576;
                            i2 = i4 << i3;
                            break;
                        case 6:
                            iT = wf1Var.t();
                            i2 = iT + 1;
                            break;
                        case 7:
                            iT = wf1Var.z();
                            i2 = iT + 1;
                            break;
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            i3 = i5 - 8;
                            i4 = 256;
                            i2 = i4 << i3;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    if (i2 != -1 && i2 <= xb0Var.b) {
                        int i9 = xb0Var.e;
                        if (i6 == 0) {
                            if (wf1Var.t() == x82.a(iD, wf1Var.d() - 1, wf1Var.c())) {
                                return true;
                            }
                        } else if (i6 <= 11) {
                            if (i6 == xb0Var.f) {
                                if (wf1Var.t() == x82.a(iD, wf1Var.d() - 1, wf1Var.c())) {
                                    return true;
                                }
                            }
                        } else if (i6 == 12) {
                            if (wf1Var.t() * 1000 == i9) {
                                if (wf1Var.t() == x82.a(iD, wf1Var.d() - 1, wf1Var.c())) {
                                    return true;
                                }
                            }
                        } else if (i6 <= 14) {
                            int iZ = wf1Var.z();
                            if (i6 == 14) {
                                iZ *= 10;
                            }
                            if (iZ == i9) {
                                if (wf1Var.t() == x82.a(iD, wf1Var.d() - 1, wf1Var.c())) {
                                    return true;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }
}
