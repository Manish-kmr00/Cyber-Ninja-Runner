package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1595Fu {
    public static byte[] A00;
    public static String[] A01 = {"e7juOHCMVCS96MucXvvyM5upzpE0CxcL", "6Axk6XM18YFtFlcC0tEdKqjogVlmemrm", "CHYE97fUe", "94l1C", "pvrd7E3JtMrEOvPAC3lcGaqqDdvc2Rnk", "mswd2ljSuB4EOxjza27Iz7krcpdQKmDN", "x2gmwPWroRNX0socjzMaFBH0Y3mBhUE3", "1dJrelJWCcDuEHtNsp3IaM8Oqex3ZZ7a"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-73, -32, 10, -73, -32, 5, 10, Ascii.VT, -8, 5, Ascii.VT, -73, -2, -8, 4, -4, 10, -73, -8, 3, 3, 6, Ascii.SO, -4, -5, -47, -73, -121, -80, -38, -121, -80, -43, -38, -37, -56, -43, -37, -121, -50, -56, -44, -52, -38, -95, -121, -57, Ascii.SO, Ascii.SYN, Ascii.SYN, Ascii.SO, 19, Ascii.FF, -57, Ascii.CR, 8, 19, 19, 9, 8, 10, Ascii.DC2, -57, Ascii.FS, Ascii.EM, 19, -57, 8, Ascii.GS, 8, Ascii.DLE, 19, 8, 9, 19, Ascii.FF, -31, -57, 79, -104, -94, -126, -93, -98, -95, -108, 105, 79, 90, -95, -9, -22, -27, -26, -16, -95, -10, -13, -19, -95, -22, -12, -95, -17, -10, -19, -19, -69, -95, 4, Ascii.DLE, Ascii.SO, -49, 7, 2, 4, 6, 3, Ascii.DLE, Ascii.DLE, Ascii.FF, -49, Ascii.FF, 2, Ascii.NAK, 2, Ascii.SI, 2, -42, -41, -46, -43, -56, -35, -34, -39, -36, -49, -55, -33, -36, -42, -55, -31, -49, -52, -55, -48, -53, -42, -42, -52, -53, -51, -43, -30, -43, -48, -47, -37, -53, -31, -34, -40};
        String[] strArr = A01;
        if (strArr[5].charAt(19) != strArr[7].charAt(19)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[3] = "ump74";
        strArr2[2] = "QJx5Vwz5z";
    }

    static {
        A02();
    }

    public static AbstractC1594Ft A00(C1598Fx c1598Fx, Bundle bundle, boolean z) {
        AbstractC1594Ft c2467gA;
        c1598Fx.A05().A0H().A00(false);
        C2T c2tA1b = c1598Fx.A04().A1b();
        double dA00 = AbstractC1591Fq.A00(c2tA1b);
        boolean isWatchAndBrowse = c1598Fx.A04().A1b().A0Q();
        boolean zA06 = AbstractC1591Fq.A06(c1598Fx.A00(), c1598Fx.A01(), dA00);
        AbstractC12551v abstractC12551vA00 = C12561w.A00(c1598Fx.A05(), c1598Fx.A06(), A01(0, 0, 8), C5.A00(c1598Fx.A04().A1b().A0H().A05()), new HashMap(), c1598Fx.A04().A1c());
        boolean z2 = !TextUtils.isEmpty(c2tA1b.A0F().A09());
        if (C14499m.A1s(c1598Fx.A05())) {
            C2699k1 c2699k1A05 = c1598Fx.A05();
            String[] strArr = A01;
            if (strArr[4].charAt(27) == strArr[6].charAt(27)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "oHCvC4ERmXYMU8sW9KKIPv7pnY2wXb01";
            strArr2[7] = "G3HUaMks2xBdg2z9mSbIts1gYwx1OgmU";
            c2699k1A05.A0B().AJs(c1598Fx.A02(), c1598Fx.A04().A1g(), z2);
        }
        boolean zA03 = A03(c1598Fx, z2);
        if ((isWatchAndBrowse && (abstractC12551vA00 instanceof N8)) || zA03) {
            c2467gA = new C2451fu(c1598Fx, zA03);
        } else if (z2) {
            c2467gA = new LS(c1598Fx);
        } else if (!z2 && C14499m.A2Y(c1598Fx.A05())) {
            c2467gA = new LT(c1598Fx, zA06);
        } else if (zA06) {
            c2467gA = new C2472gF(c1598Fx, c1598Fx.A00() == 2);
        } else {
            c2467gA = new C2467gA(c1598Fx, AbstractC1591Fq.A04(dA00));
        }
        if (z) {
            c2467gA.A14(c2tA1b, c1598Fx.A04().A1g(), dA00, bundle);
        }
        return c2467gA;
    }

    public static boolean A03(C1598Fx c1598Fx, boolean z) {
        boolean z2 = false;
        if (!c1598Fx.A04().A1T() || !z) {
            return false;
        }
        Uri uriA00 = C5.A00(c1598Fx.A04().A1b().A0H().A05());
        String authority = uriA00.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            c1598Fx.A05().A0F().ABf();
            return false;
        }
        boolean isInstantGamesEnabled = authority.equals(A01(128, 5, 58));
        boolean isInstantGames = uriA00.getQueryParameter(A01(155, 9, 67)) == null;
        String queryParameter = uriA00.getQueryParameter(A01(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 22, 65));
        boolean isGoogleFallBackUrlAvailable = !TextUtils.isEmpty(queryParameter) && queryParameter.contains(c1598Fx.A04().A0j());
        boolean zEquals = c1598Fx.A05().getPackageName().equals(A01(109, 19, 120));
        boolean zA1U = c1598Fx.A04().A1U();
        if (isInstantGamesEnabled && isInstantGames && isGoogleFallBackUrlAvailable && (!zEquals || zA1U)) {
            z2 = true;
        }
        if (!z2 && Build.VERSION.SDK_INT >= 24) {
            c1598Fx.A05().A0F().ABe(A01(78, 11, 6) + isInstantGamesEnabled + A01(89, 20, 88) + isInstantGames + A01(46, 32, 126) + isGoogleFallBackUrlAvailable + A01(27, 19, 62) + zEquals + A01(0, 27, 110) + zA1U);
        }
        return z2;
    }
}
