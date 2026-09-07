package com.facebook.ads.redexgen.core;

import android.content.Intent;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13756o {
    public static byte[] A07;
    public static String[] A08 = {"WrVVpIlV0mVOOesXyJjac9RJgGDEsYiy", "55KqVxwk4ItPenJ0PbzoYHpl7VLiDDoF", "", "85Uc86a0UVsoWW8LIwye7frNycSrKuPv", "TRaam", "0wWSnm1p2XMm3vcxH", "", "BPzoua9RAnM56oYN7Gpf0cmvKga9OU"};
    public boolean A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final AudienceNetworkActivity A04;
    public final AudienceNetworkActivityApi A05;
    public final C2699k1 A06;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-78, -19, -7, -9, -72, -16, -21, -19, -17, -20, -7, -7, -11, -72, -21, -18, -3, -72, -21, -18, -4, -17, -6, -7, -4, -2, -13, -8, -15, -72, -48, -45, -40, -45, -35, -46, -23, -53, -50, -23, -36, -49, -38, -39, -36, -34, -45, -40, -47, -23, -48, -42, -39, -31, Ascii.FS, 40, 38, -25, Ascii.US, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.ESC, 40, 40, 36, -25, Ascii.SUB, Ascii.GS, 44, -25, 34, 39, 45, Ascii.RS, 43, 44, 45, 34, 45, 34, Ascii.SUB, 37, -25, Ascii.SUB, Ascii.FS, 45, 34, 47, 34, 45, 50, Ascii.CAN, Ascii.GS, Ascii.RS, 44, 45, 43, 40, 50, Ascii.RS, Ascii.GS, Ascii.DLE, Ascii.FS, Ascii.SUB, -37, 19, Ascii.SO, Ascii.DLE, Ascii.DC2, Ascii.SI, Ascii.FS, Ascii.FS, Ascii.CAN, -37, Ascii.SO, 17, 32, -37, Ascii.SYN, Ascii.ESC, 33, Ascii.DC2, Ascii.US, 32, 33, Ascii.SYN, 33, Ascii.SYN, Ascii.SO, Ascii.EM, -37, 17, Ascii.SYN, 32, Ascii.SUB, Ascii.SYN, 32, 32, Ascii.DC2, 17, 46, 58, 56, -7, 49, 44, 46, 48, 45, 58, 58, 54, -7, 44, 47, 62, -7, 52, 57, 63, 48, Base64.padSymbol, 62, 63, 52, 63, 52, 44, 55, -7, 48, Base64.padSymbol, Base64.padSymbol, 58, Base64.padSymbol, -39, -27, -29, -92, -36, -41, -39, -37, -40, -27, -27, -31, -92, -41, -38, -23, -92, -33, -28, -22, -37, -24, -23, -22, -33, -22, -33, -41, -30, -92, -36, -33, -28, -33, -23, -34, -43, -41, -39, -22, -33, -20, -33, -22, -17, -4, 8, 6, -57, -1, -6, -4, -2, -5, 8, 8, 4, -57, -6, -3, Ascii.FF, -57, 2, 7, Ascii.CR, -2, Ascii.VT, Ascii.FF, Ascii.CR, 2, Ascii.CR, 2, -6, 5, -57, 2, 6, 9, Ascii.VT, -2, Ascii.FF, Ascii.FF, 2, 8, 7, -57, 5, 8, 0, 0, -2, -3, Ascii.SO, Ascii.US, Ascii.SO, Ascii.ETB, Ascii.GS};
    }

    static {
        A01();
    }

    public C13756o(AudienceNetworkActivityApi audienceNetworkActivityApi, C2699k1 c2699k1, AudienceNetworkActivity audienceNetworkActivity) {
        this.A05 = audienceNetworkActivityApi;
        this.A06 = c2699k1;
        this.A04 = audienceNetworkActivity;
    }

    private final void A02(boolean z) {
        this.A03 = z;
    }

    private final boolean A03(BG bg) {
        if (bg != BG.A0H && bg != BG.A0G) {
            BG bg2 = BG.A08;
            String[] strArr = A08;
            if (strArr[3].charAt(18) == strArr[0].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[4] = "QK9lt";
            strArr2[5] = "71ldustRCfnIbk6ZF";
            if (bg != bg2 && bg != BG.A05 && bg != BG.A0F) {
                return false;
            }
        }
        return true;
    }

    public final void A04(BG bg, String str) {
        boolean z = !this.A03 || C14499m.A1v(this.A06);
        boolean shouldCallOnDestroy = this.A02;
        if (!shouldCallOnDestroy && z) {
            boolean shouldCallOnDestroy2 = A03(bg);
            if (shouldCallOnDestroy2) {
                A09(IV.A03.A03(), str);
            } else {
                A09(A00(54, 48, 103), str);
            }
            this.A02 = true;
        }
    }

    public final void A05(BG bg, String str) {
        if (A03(bg)) {
            A09(IV.A09.A03(), str);
        } else {
            A09(A00(141, 35, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), str);
        }
    }

    public final void A06(BG bg, String str) {
        if (A03(bg)) {
            A09(IV.A05.A03(), str);
        } else {
            A09(A00(102, 39, 91), str);
        }
        A02(true);
        A04(bg, str);
    }

    public final void A07(BG bg, String str) {
        if (C14499m.A1q(this.A06) && !this.A01 && !this.A00) {
            InterfaceC12391f interfaceC12391fA0F = this.A06.A0F();
            String[] strArr = A08;
            if (strArr[3].charAt(18) == strArr[0].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "ERQ6CJuvlb3tCwq1OYCzpUpdhNPz9IsE";
            strArr2[0] = "fdli8mgwNbZyMwMFsZ54k8DyiigEG2Sx";
            interfaceC12391fA0F.ABy();
            A05(bg, str);
        }
    }

    public final void A08(String str, C9I c9i, String str2) {
        Intent intent = new Intent(str + A00(0, 1, 38) + str2);
        if (c9i != null) {
            intent.putExtra(A00(268, 5, 87), c9i);
        }
        AnonymousClass42.A00(this.A04).A07(intent);
    }

    public final void A09(String str, String str2) {
        if (A00(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 47, 71).equals(str) || IV.A0A.A03().equals(str)) {
            this.A01 = true;
        }
        boolean zEquals = A00(141, 35, Sdk.SDKError.Reason.TPAT_ERROR_VALUE).equals(str);
        if (A08[7].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "q8Yu3i76ZTlYqxP4qtQeXX4gnui9AJbb";
        strArr[0] = "UYbwc2QJiguNdyXAgiRTefqPyIZvniQg";
        if (zEquals || IV.A09.A03().equals(str)) {
            this.A00 = true;
        }
        if (A00(1, 53, 56).equals(str)) {
            this.A05.finish(9);
        } else if (A00(176, 45, 36).equals(str)) {
            this.A05.finish(10);
        } else {
            A08(str, null, str2);
        }
    }
}
