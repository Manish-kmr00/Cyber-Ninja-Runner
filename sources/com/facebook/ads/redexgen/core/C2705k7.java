package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2705k7 extends BY {
    public static byte[] A02;
    public final /* synthetic */ C2704k6 A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A04();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A02 = new byte[]{Ascii.SO, 44, 46, 51, 48, -21, 49, 44, 52, 55, -7, -110, -80, -78, -73, -76, 111, -62, -60, -78, -78, -76, -62, -62, 125};
    }

    public C2705k7(C2704k6 c2704k6, AtomicBoolean atomicBoolean) {
        this.A00 = c2704k6;
        this.A01 = atomicBoolean;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0I(AE.A0H);
                C14097w.A02(this.A00.A02.A04, this.A00.A01, C14097w.A00, A01(11, 14, 1), this.A00.A02.A00);
                this.A00.A02.A0T();
                this.A00.A00.ACj();
                return;
            }
            this.A00.A02.A0I(AE.A0G);
            C14097w.A02(this.A00.A02.A04, this.A00.A01, C14097w.A04, A01(0, 11, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), this.A00.A02.A00);
            this.A00.A02.A0U();
            this.A00.A00.ACa();
        }
    }
}
