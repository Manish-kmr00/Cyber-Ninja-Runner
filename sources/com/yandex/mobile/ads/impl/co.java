package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class co {
    public static void a(long j, wf1 wf1Var, t52[] t52VarArr) {
        int i;
        int iT;
        while (true) {
            if (wf1Var.a() <= 1) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (wf1Var.a() == 0) {
                    i = -1;
                    break;
                }
                int iT2 = wf1Var.t();
                i2 += iT2;
                if (iT2 != 255) {
                    i = i2;
                    break;
                }
            }
            int i3 = 0;
            do {
                if (wf1Var.a() == 0) {
                    i3 = -1;
                    break;
                } else {
                    iT = wf1Var.t();
                    i3 += iT;
                }
            } while (iT == 255);
            int iD = wf1Var.d() + i3;
            if (i3 == -1 || i3 > wf1Var.a()) {
                at0.d("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iD = wf1Var.e();
            } else if (i == 4 && i3 >= 8) {
                int iT3 = wf1Var.t();
                int iZ = wf1Var.z();
                int iH = iZ == 49 ? wf1Var.h() : 0;
                int iT4 = wf1Var.t();
                if (iZ == 47) {
                    wf1Var.f(1);
                }
                boolean z = iT3 == 181 && (iZ == 49 || iZ == 47) && iT4 == 3;
                if (iZ == 49) {
                    z &= iH == 1195456820;
                }
                if (z) {
                    b(j, wf1Var, t52VarArr);
                }
            }
            wf1Var.e(iD);
        }
    }

    public static void b(long j, wf1 wf1Var, t52[] t52VarArr) {
        int iT = wf1Var.t();
        if ((iT & 64) != 0) {
            wf1Var.f(1);
            int i = (iT & 31) * 3;
            int iD = wf1Var.d();
            for (t52 t52Var : t52VarArr) {
                wf1Var.e(iD);
                t52Var.a(i, wf1Var);
                if (j != -9223372036854775807L) {
                    t52Var.a(j, 1, i, 0, null);
                }
            }
        }
    }
}
