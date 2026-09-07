package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
public final class j72 {
    public static long a(int i, int i2, wf1 wf1Var) {
        wf1Var.e(i);
        if (wf1Var.a() < 5) {
            return -9223372036854775807L;
        }
        int iH = wf1Var.h();
        if ((8388608 & iH) != 0 || ((2096896 & iH) >> 8) != i2 || (iH & 32) == 0 || wf1Var.t() < 7 || wf1Var.a() < 7 || (wf1Var.t() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        wf1Var.a(bArr, 0, 6);
        return ((255 & ((long) bArr[4])) >> 7) | ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1);
    }
}
