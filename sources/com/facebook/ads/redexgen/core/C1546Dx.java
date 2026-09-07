package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1546Dx extends AbstractC2060Yr {
    public static byte[] A02;
    public static String[] A03 = {"fetKLtnMCFDfNTa7bwmObcthDo9ngy", "PCLmUJy2ummTCnV", "VcuGkei5vuld", "K82HQX4MuyZYXl7RtFThppOgUf2xURat", "GIJiD0tbUpKlWEo4Ksax6W36ytXEgmkB", "fEKK3qZEhYyP4ktAyJk", "P4giTz2uHY1MhYc22pRWrb", "wQOIq3PUWFgl2b3jPpcViaGbsVCo6pcB"};
    public static final InterfaceC1774Na<C1546Dx> A04;
    public static final String A05;
    public static final String A06;
    public final float A00;
    public final int A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "ZCIykIhk3soNbWZ8AMDjEHj0GXLniP";
            strArr2[6] = "WCNLdM0woplDkVLZGfcH9s";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
            i4++;
        }
    }

    public static void A03() {
        A02 = new byte[]{37, 41, 48, Ascii.ESC, 60, 41, 58, 59, 104, 37, Base64.padSymbol, 59, 60, 104, 42, 45, 104, 41, 104, 56, 39, 59, 33, 60, 33, 62, 45, 104, 33, 38, 60, 45, 47, 45, 58, 113, 118, 99, 112, 80, 99, 118, 107, 108, 101, 34, 107, 113, 34, 109, 119, 118, 34, 109, 100, 34, 112, 99, 108, 101, 103, 34, 89, 50, 46, 34, 111, 99, 122, 81, 118, 99, 112, 113, 95};
    }

    static {
        A03();
        A05 = AbstractC2471gE.A0h(1);
        A06 = AbstractC2471gE.A0h(2);
        A04 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Yl
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return C1546Dx.A00(bundle);
            }
        };
    }

    public C1546Dx(int i) {
        AbstractC2388es.A09(i > 0, A02(0, 35, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
        this.A01 = i;
        this.A00 = -1.0f;
    }

    public C1546Dx(int i, float f) {
        AbstractC2388es.A09(i > 0, A02(0, 35, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
        AbstractC2388es.A09(f >= 0.0f && f <= ((float) i), A02(35, 40, 54));
        this.A01 = i;
        this.A00 = f;
    }

    public static C1546Dx A00(Bundle bundle) {
        AbstractC2388es.A07(bundle.getInt(AbstractC2060Yr.A02, -1) == 2);
        int i = bundle.getInt(A05, 5);
        float starRating = bundle.getFloat(A06, -1.0f);
        if (starRating == -1.0f) {
            return new C1546Dx(i);
        }
        return new C1546Dx(i, starRating);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1546Dx)) {
            return false;
        }
        C1546Dx c1546Dx = (C1546Dx) obj;
        return this.A01 == c1546Dx.A01 && this.A00 == c1546Dx.A00;
    }

    public final int hashCode() {
        return AbstractC1813Or.A00(Integer.valueOf(this.A01), Float.valueOf(this.A00));
    }
}
