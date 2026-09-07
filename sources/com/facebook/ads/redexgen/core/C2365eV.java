package com.facebook.ads.redexgen.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2365eV extends BY {
    public static byte[] A02;
    public final /* synthetic */ C1722Kr A00;
    public final /* synthetic */ KX A01;

    static {
        A04();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A02 = new byte[]{98, 85, 70, 70, 69, 82, 73, 78, 71, 0, 73, 78, 68, 69, 70, 73, 78, 73, 84, 69, 76, 89};
    }

    public C2365eV(C1722Kr c1722Kr, KX kx) {
        this.A00 = c1722Kr;
        this.A01 = kx;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        if (this.A00.A0a.getState() == JI.A02 && this.A00.A0a.getCurrentPositionInMillis() == this.A01.A00()) {
            this.A00.A0Y.AFY(A01(0, 22, 86));
        }
    }
}
