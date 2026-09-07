package com.facebook.ads.redexgen.core;

import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2647jB implements AJ {
    public static byte[] A04;
    public static String[] A05 = {"HMqNF3eSIzlMBYXVNU3nP1NvWYo5", "x1o785RKTr7Jq0RcU0BPUyycJ3fBjUeE", "GBfmO3K", "Po", "VaaklUluHJvo1XkXnH3kavV5L6d7gpHG", "rG9SvJ3uZ6", "s9MPDvRc6n", "AU4sbnw7bsTTRuLyXll9UaPcK28fS"};
    public static final String A06;
    public ViewOnAttachStateChangeListenerC2648jC A00;
    public C2959oc<C14569t, C14619y> A01;
    public final C2698k0 A02;
    public final C1781Nj A03 = C1781Nj.A01();

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[1].length() == 18) {
                throw new RuntimeException();
            }
            A05[1] = "YaUcq3PJYQGMSsmKTTLasxzUL6lFeW7O";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            i4++;
        }
    }

    public static void A02() {
        A04 = new byte[]{79, 115, 126, 59, 118, 126, 127, 114, 122, 59, 120, 105, 126, 122, 111, 114, 109, 126, 59, 109, 114, 126, 108, 59, 114, 104, 59, 117, 110, 119, 119, 53, 121, 66, 94, 73, 75, 69, 95, 88, 73, 94, 69, 66, 75, Ascii.FF, 77, Ascii.FF, 66, 89, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, Ascii.FF, 79, 94, 73, 77, 88, 69, 90, 73, Ascii.FF, 90, 69, 73, 91, Ascii.CR, 83, 108, 96, 114, 117, 106, 108, 107, 113, 65, 100, 113, 100, 37, 108, 118, 37, 107, 112, 105, 105, 36, Ascii.EM, Ascii.SI, 9, 5, 4, Ascii.SO, 53, 9, 2, Ascii.VT, 4, 4, Ascii.SI, 6};
    }

    static {
        A02();
        A06 = C2647jB.class.getSimpleName();
    }

    public C2647jB(C2698k0 c2698k0) {
        this.A02 = c2698k0;
    }

    private void A01() {
        this.A02.A08().AAu(A00(89, 14, 19), 3600, new C14138b(A00(67, 22, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE)));
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void ACq() {
        if (this.A01 != null) {
            this.A01.A07.A00();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void AFk() {
        if (this.A01 != null) {
            this.A01.A07.A03();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void AJZ(View view) {
        if (this.A01 == null) {
            this.A02.A08().AAu(A00(89, 14, 19), 3600, new C14138b(A00(32, 35, 85)));
            return;
        }
        this.A03.A08(view);
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void AJs(View view, String str, boolean z) {
        AJt(view, str, z, false);
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void AJt(View view, String str, boolean z, boolean z2) {
        AJu(view, str, z, z2, false);
    }

    @Override // com.facebook.ads.redexgen.core.AJ
    public final void AJu(View view, String str, boolean z, boolean z2, boolean z3) {
        if (view != null) {
            this.A00 = new ViewOnAttachStateChangeListenerC2648jC(view);
            this.A03.A0A(this.A00, view);
            if (z2) {
                this.A00.A03();
            }
            this.A01 = C2959oc.A00(new C14569t(this.A02, view, str, z, z3), new C14619y(), A06).A06(new C2649jD(new C2646jA())).A07();
            this.A03.A09(view, this.A01);
            return;
        }
        this.A02.A08().AAu(A00(89, 14, 19), 3600, new C14138b(A00(0, 32, 98)));
    }
}
