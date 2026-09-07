package com.yandex.mobile.ads.impl;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class vm1 {
    private static a b(byte[] bArr) {
        wf1 wf1Var = new wf1(bArr);
        if (wf1Var.e() < 32) {
            return null;
        }
        wf1Var.e(0);
        if (wf1Var.h() != wf1Var.a() + 4 || wf1Var.h() != 1886614376) {
            return null;
        }
        int iH = (wf1Var.h() >> 24) & 255;
        if (iH > 1) {
            tr0.a("Unsupported pssh version: ", iH, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(wf1Var.p(), wf1Var.p());
        if (iH == 1) {
            wf1Var.f(wf1Var.x() * 16);
        }
        int iX = wf1Var.x();
        if (iX != wf1Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iX];
        wf1Var.a(bArr2, 0, iX);
        return new a(uuid, iH, bArr2);
    }

    public static boolean a(byte[] bArr) {
        return b(bArr) != null;
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        if (!uuid.equals(aVarB.f10495a)) {
            at0.d("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarB.f10495a + ".");
            return null;
        }
        return aVarB.c;
    }

    public static UUID c(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return null;
        }
        return aVarB.f10495a;
    }

    public static int d(byte[] bArr) {
        a aVarB = b(bArr);
        if (aVarB == null) {
            return -1;
        }
        return aVarB.b;
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f10495a;
        private final int b;
        private final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f10495a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }
}
