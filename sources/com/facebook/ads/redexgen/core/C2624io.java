package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2624io extends AnonymousClass24 {
    public static byte[] A01;
    public final /* synthetic */ C2615ie A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{95, 112, 101, 120, 103, 116, 49, 112, 117, 98, 49, 124, 112, 127, 112, 118, 116, 99, 49, 101, 121, 116, 120, 99, 49, 126, 102, 127, 49, 120, 124, 97, 99, 116, 98, 98, 120, 126, 127, 98, 63};
    }

    public C2624io(C2615ie c2615ie) {
        this.A00 = c2615ie;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0B(C2873mv c2873mv) {
        this.A00.A1W(c2873mv);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0C() {
        if (this.A00.A0G != null) {
            this.A00.A0G.AC6();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 15));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0F(AnonymousClass23 anonymousClass23) {
        if (this.A00.A0A != null) {
            this.A00.A0A.A0M();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0G(C1468Ag c1468Ag) {
        this.A00.A12().A0F().A3D(C1517Cu.A01(this.A00.A00), c1468Ag.A03().getErrorCode(), c1468Ag.A04());
        if (this.A00.A0G != null) {
            this.A00.A0G.AD4(c1468Ag);
        }
    }
}
