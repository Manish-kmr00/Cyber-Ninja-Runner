package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XG implements InterfaceC1892Rv {
    public static byte[] A01;
    public static String[] A02 = {"XP2FqcAOW5OB", "vy3sHWnxY", "lliIYEEgrUJaxxNNiq0urdHUk", "jOem", "K0eytYsrH5QQCvogWHmQjW0THjxnwlIr", "eBaETZSTNwb8Lbal6f7x", "1IvAX", "YJYc4zCx"};
    public final /* synthetic */ C0V A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-46, 6, -11, -6, 0, -79, 4, -6, -1, -4, -79, -10, 3, 3, 0, 3, -32, -8, -9, -4, -12, -42, 2, -9, -8, -10, -44, 8, -9, -4, 2, -27, -8, 1, -9, -8, 5, -8, 5, -85, -86, -113, -88, -95, -95, -84, -23, -24, -47, -37, -27, -33, -17, -22};
        if (A02[4].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "eS4Y";
        strArr[5] = "7MrfQHgoNWqiCvXyWdPD";
        A01 = bArr;
    }

    static {
        A01();
    }

    public XG(C0V c0v) {
        this.A00 = c0v;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void ACO(Exception exc) {
        AbstractC2432fb.A08(A00(16, 23, 96), A00(0, 16, 94), exc);
        this.A00.A0G.A0D(exc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void ACP(C1888Rr c1888Rr) {
        this.A00.A0G.A0B(c1888Rr);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void ACQ(C1888Rr c1888Rr) {
        this.A00.A0G.A0C(c1888Rr);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AEH() {
        C0V.A05(this.A00);
        if (0 != 0) {
            C0V.A05(this.A00);
            throw new NullPointerException(A00(46, 8, 71));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AEI() {
        C0V.A05(this.A00);
        if (0 != 0) {
            C0V.A05(this.A00);
            throw new NullPointerException(A00(39, 7, 9));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AEa(long j) {
        this.A00.A0G.A03(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AEb() {
        this.A00.A26();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AF7(boolean z) {
        this.A00.A0G.A0I(z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1892Rv
    public final void AFR(int i, long j, long j2) {
        this.A00.A0G.A01(i, j, j2);
    }
}
