package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1953Ui {
    public static byte[] A02;
    public static String[] A03 = {"DcZnPoy59v7sj6PT8aConXR6jEPAL960", "Pv8IBEx58pJkNNVPq5bnbeRuMFJtpa1x", "3Zs54Ju7SHVe", "H", "RKR9j3xEV0ivPjQ8DuOkvj9eC5GtakEP", "8QNaCEG2mWsibXa4TFiVJYyhNMyXSiHE", "uazceyLmjty8LR90DaJQZdEYzqeKFyaJ", "Ew5eYlEYbVVB"};
    public final C1954Uk A00;
    public final C1954Uk A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{70, 74, Ascii.FS, 56};
    }

    static {
        A01();
    }

    public C1953Ui(C1954Uk c1954Uk) {
        this(c1954Uk, c1954Uk);
    }

    public C1953Ui(C1954Uk c1954Uk, C1954Uk c1954Uk2) {
        this.A00 = (C1954Uk) AbstractC2388es.A01(c1954Uk);
        this.A01 = (C1954Uk) AbstractC2388es.A01(c1954Uk2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A03;
        if (strArr[1].charAt(6) != strArr[4].charAt(6)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[7] = "TGB2jMu9Hb97";
        strArr2[3] = "v";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1953Ui c1953Ui = (C1953Ui) obj;
        return this.A00.equals(c1953Ui.A00) && this.A01.equals(c1953Ui.A01);
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }

    public final String toString() {
        return A00(2, 1, 56) + this.A00 + (this.A00.equals(this.A01) ? A00(0, 0, 31) : A00(0, 2, 21) + this.A01) + A00(3, 1, 26);
    }
}
