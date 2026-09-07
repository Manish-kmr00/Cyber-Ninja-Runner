package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class ub0 {
    public static xb0.a a(wf1 wf1Var) {
        wf1Var.f(1);
        int iW = wf1Var.w();
        long jD = ((long) wf1Var.d()) + ((long) iW);
        int i = iW / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jP = wf1Var.p();
            if (jP == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jP;
            jArrCopyOf2[i2] = wf1Var.p();
            wf1Var.f(2);
        }
        wf1Var.f((int) (jD - ((long) wf1Var.d())));
        return new xb0.a(jArrCopyOf, jArrCopyOf2);
    }
}
