package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.FlashPreferences;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14368z {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"i0FOsf0o9fpBvAlaEaGgnCYFRbNnwBKJ", "ZsBa2nEfyhltTo", "ZG6g5nWnUhxh", "6zjosiDwJWE47kuMvKAUCDrCWUeR8P3q", "Gh89HIHHDqfPtiuASbXLVil627eRz", "Lsbp3nhJR34oAmuvtJAouWbaxC4Ny9OM", "s0Y", "C"};
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-91, -39, -93, -87, -85, -84, -39, -41, -54, -58, -59, -7, -24, -19, -23, -14, -25, -23, -46, -23, -8, -5, -13, -10, -17, -88, -103, -96, 117, -66, -61, -66, -55, -66, -74, -63, -66, -49, -74, -55, -66, -60, -61, 117, -56, -55, -74, -57, -55, -70, -71, -84, -67, -60, 121, -48, -70, -52, 121, -70, -59, -53, -66, -70, -67, -46, 121, -62, -57, -62, -51, -62, -70, -59, -62, -45, -66, -67, 122, 121, -84, -60, -62, -55, -55, -62, -57, -64, -121, -90, -68, -62, 109, -79, -68, -69, 116, -63, 109, -80, -82, -71, -71, 109, -114, -62, -79, -74, -78, -69, -80, -78, -101, -78, -63, -60, -68, -65, -72, -114, -79, -64, 123, -74, -69, -74, -63, -74, -82, -71, -74, -57, -78, 117, 118, 123, 109, -96, -68, -70, -78, 109, -77, -62, -69, -80, -63, -74, -68, -69, -82, -71, -74, -63, -58, 109, -70, -82, -58, 109, -69, -68, -63, 109, -60, -68, -65, -72, 109, -67, -65, -68, -67, -78, -65, -71, -58, 123, -120, -105, -112, -58, -52, -63, -45, -56, 0, 6, -5, Ascii.CR, 2, -7, -3, 9, 8, 0, 3, 1, -42, -44, -35, -44, -31, -40, -46, -3, 2, -3, 8, -3, -11, 0, -3, Ascii.SO, -7, -51, -46, -51, -40, -51, -59, -48, -51, -34, -55, -116, -115, -124, -46, -45, -40, -124, -57, -59, -48, -48, -55, -56, -110, 1, -10, 8, 9, -12, 7, -6, 8, 10, 1, 9};
    }

    static {
        A03();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static C2683jl A00() {
        return new C2683jl();
    }

    public static C2682jk A01(C2698k0 c2698k0) {
        return new C2682jk(c2698k0);
    }

    public static void A04(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        ExecutorC1520Cx.A01.execute(new C2684jm(initListener, initResult));
    }

    public static void A06(C2698k0 c2698k0) {
        if (AbstractC14519o.A0P(c2698k0) && !A05.getAndSet(true)) {
            try {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = new C8Q(Thread.getDefaultUncaughtExceptionHandler(), c2698k0, new C2680ji());
                Thread.setDefaultUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
            } catch (Exception e) {
                c2698k0.A08().AAu(A02(198, 7, 78), AbstractC14128a.A1X, new C14138b(e));
            }
        }
    }

    public static void A07(C2698k0 c2698k0) {
        A0H(c2698k0, null, null, 3);
    }

    public static void A08(C2698k0 c2698k0) {
        A0H(c2698k0, null, null, 3);
    }

    public static void A09(C2698k0 c2698k0) {
        if (C14499m.A2F(c2698k0)) {
            A0F(c2698k0, 0);
        }
        if (C14499m.A2O(c2698k0)) {
            A0B(c2698k0);
        }
    }

    public static void A0A(C2698k0 c2698k0) {
        if (C14499m.A2G(c2698k0)) {
            String[] strArr = A03;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "XjvPwbQrSqkAxC";
            strArr2[6] = "skO";
            A0G(c2698k0, null, 3);
        }
    }

    public static void A0B(C2698k0 c2698k0) {
        D8.A06.execute(new C2685jn(c2698k0));
    }

    public static void A0C(C2698k0 c2698k0) {
        C3P.A02(c2698k0);
        C8U.A0C(c2698k0, new C2679jh(c2698k0), new C2689jr(), BuildConfigApi.isDebug());
        c2698k0.A0A();
        A0D(c2698k0);
    }

    public static void A0D(C2698k0 c2698k0) {
        if (ProcessUtils.isRemoteRenderingProcess()) {
            return;
        }
        SharedPreferences sharedPreferences = FlashPreferences.getSharedPreferences(c2698k0);
        String string = sharedPreferences.getString(A02(186, 12, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), null);
        String string2 = sharedPreferences.getString(A02(239, 11, 116), null);
        if (string != null && string2 != null) {
            C8Z c8zA08 = c2698k0.A08();
            C14138b c14138b = new C14138b(string2);
            String flashConfig = A02(181, 5, 63);
            c8zA08.ABM(flashConfig, 3701, c14138b);
        }
    }

    public static void A0F(C2698k0 c2698k0, int i) {
        AnonymousClass84.A01(c2698k0);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            AbstractC1477Au.A02();
        }
        A06(c2698k0);
        AbstractC1480Bb.A00(C14499m.A0p(c2698k0), BuildConfigApi.isDebug(), A00(), A01(c2698k0));
        C13917e.A03(C14499m.A04(c2698k0));
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            C1688Jj.A09(new C2681jj(c2698k0));
        }
        if (i == 3) {
            Log.e(A02(8, 17, 99), A02(89, 89, 44));
            c2698k0.A08().ABM(A02(178, 3, 6), AbstractC14128a.A0R, new C14138b(A02(Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 24, 67)));
        }
        ActivityUtils.A04(c2698k0, AudienceNetworkActivity.class);
        D8.A05(c2698k0);
        AI.A05(c2698k0);
        C2A.A01(c2698k0);
        if (C14499m.A15(c2698k0)) {
            C6X.A00(c2698k0);
        }
        if (C14499m.A1s(c2698k0)) {
            C2671jZ.A02().A8q(c2698k0);
        }
    }

    public static void A0G(C2698k0 c2698k0, AudienceNetworkAds.InitListener initListener, int i) {
        AnonymousClass84.A01(c2698k0);
        boolean z = false;
        synchronized (C14368z.class) {
            boolean execute = A00;
            if (!execute) {
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        boolean execute2 = A01;
                        if (!execute2) {
                            A01 = true;
                            z = true;
                        }
                    }
                } else {
                    A00 = true;
                    z = true;
                }
            }
        }
        if (z) {
            A0F(c2698k0, i);
            D8.A08.execute(new C2686jo(c2698k0, initListener));
        } else {
            if (i != 1) {
                return;
            }
            String strA02 = A02(51, 38, 56);
            if (initListener != null) {
                A04(initListener, new C14358y(true, strA02));
            } else {
                Log.w(A02(8, 17, 99), strA02);
            }
        }
    }

    public static void A0H(C2698k0 c2698k0, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, int i) {
        AbstractC1477Au.A05(A02(205, 10, 115), A02(25, 26, 52), A02(0, 8, 82));
        C1688Jj.A06();
        A0G(c2698k0, initListener, i);
    }

    public static synchronized boolean A0I() {
        return A00;
    }
}
