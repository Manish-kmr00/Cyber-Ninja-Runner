package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C9G {
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"qZcb6NmBns1n3v1", "rTLETUx3xNnjwSb02Sx6jVZM5Fuzg7Of", "ujF8Yx1ooHYTWOANWsLoHgp9GHsWq5OG", "emoc9RIZRY17k1iV3jHEmbNdIKvpuqWe", "9dj0hHqqeHaqkXambHAPXjsskYxWzSoy", "H6Wp9lsP8ocDK9Bk7hE2Cfl7XjXVKK5i", "baRwZ59Bd0PN8tFBdjuxnLHZSOlJTNRT", "2xLvEFwTfIQTf34sGOrn6donSx3FaGAc"};
    public static final AtomicBoolean A03;
    public static final AtomicReference<String> A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A01 = new byte[]{-56, 3, -18, -22, -23, -10, -41, -23, Ascii.GS, Ascii.FF, 17, Ascii.CR, Ascii.SYN, Ascii.VT, Ascii.CR, -10, Ascii.CR, Ascii.FS, Ascii.US, Ascii.ETB, Ascii.SUB, 19, -18, Ascii.ETB, Ascii.SUB, -23, Ascii.SYN, Ascii.FF, Ascii.SUB, Ascii.ETB, 17, Ascii.FF, -29, -18, -22, -5, -10, -41, 6, -18, -7, -11, -12, 9, -30, -18, -7, -11, -11, 9, -30, -71, -60, -64, -54, -63, -83, -53, -42, -46, -29, -26, -65, -63, -67, -68, -67, -86, -55, -59, -39, -42, -78, SignedBytes.MAX_POWER_OF_TWO, 57, 79, 62, 69, 60, 60, 54, 79, 76, 79, 80, 88, 79, -9, 57, 69, 67, 4, 60, 55, 57, 59, 56, 69, 69, 65, 4, 55, 58, 73, 4, 63, 68, 74, 59, 72, 68, 55, 66, 4, 75, 55, 52, 50, 59, 50, 63, 54, 48, Ascii.EM, 37, 37, 33, -33, Ascii.DC2, Ascii.CAN, Ascii.SYN, Ascii.US, 37, Ascii.US, Ascii.GS, Ascii.SI, Ascii.FS, 9, Ascii.VT, 17, Ascii.SI, Ascii.CAN, Ascii.RS, -20, -22, -36, -23, -42, -40, -34, -36, -27, -21, -42, -29, -40, -22, -21, -42, -23, -36, -35, -23, -36, -22, -33, 59, 41, 38, 35, 58, 45, 41, 59};
    }

    static {
        A08();
        A00 = A00(80, 7, 107);
        A03 = new AtomicBoolean();
        A04 = new AtomicReference<>();
    }

    public static String A01(AnonymousClass85 anonymousClass85) {
        return WebSettings.getDefaultUserAgent(anonymousClass85);
    }

    public static String A02(final AnonymousClass85 anonymousClass85) {
        FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: com.facebook.ads.redexgen.X.9F
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final String call() {
                String browserUserAgent = (String) C9G.A04.get();
                if (browserUserAgent != null) {
                    return browserUserAgent;
                }
                WebView webView = new WebView(anonymousClass85.getApplicationContext());
                webView.setWebViewClient(new WebViewClient() { // from class: com.facebook.ads.redexgen.X.9E
                    @Override // android.webkit.WebViewClient
                    public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                        F1.A02(AbstractC14128a.A2j);
                        return true;
                    }
                });
                String userAgentString = webView.getSettings().getUserAgentString();
                webView.destroy();
                if (userAgentString != null) {
                    C9G.A04.set(userAgentString);
                }
                return userAgentString;
            }
        });
        for (int i = 0; i < 3; i++) {
            ExecutorC1520Cx.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable th) {
                A09(anonymousClass85, th);
                SystemClock.sleep(500L);
            }
        }
        return null;
    }

    public static String A03(AnonymousClass85 anonymousClass85, C14238l c14238l) {
        String strA07 = c14238l.A07();
        if (TextUtils.isEmpty(strA07) && !A03.getAndSet(true)) {
            C8Z c8zA08 = anonymousClass85.A08();
            int i = AbstractC14128a.A1Z;
            String bundle = A00(73, 7, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
            C14138b c14138b = new C14138b(bundle);
            String bundle2 = A00(116, 7, 87);
            c8zA08.AAu(bundle2, i, c14138b);
        }
        return strA07;
    }

    public static String A04(AnonymousClass85 anonymousClass85, boolean z) {
        if (anonymousClass85 == null) {
            return A00;
        }
        if (z) {
            return System.getProperty(A00(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 10, 59));
        }
        String str = A04.get();
        if (str != null) {
            return str;
        }
        long spUserAgentRefresh = AbstractC14489l.A01(anonymousClass85);
        String strA00 = A00(143, 23, 1);
        String strA01 = A00(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 10, 52);
        String strA02 = A00(88, 28, 96);
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences = anonymousClass85.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA02, anonymousClass85), 0);
            String string = sharedPreferences.getString(strA01, null);
            long j = sharedPreferences.getLong(strA00, 0L);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j < spUserAgentRefresh) {
                A04.set(string);
                String[] strArr = A02;
                String str2 = strArr[6];
                String browserUserAgent = strArr[3];
                if (str2.charAt(17) != browserUserAgent.charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "raDju45r7vWAWvtCMjs7ezmbeHuUzRMZ";
                strArr2[3] = "IEXEfOXuBGyf1jRfSjx88B0PyUJh9Pa6";
                return string;
            }
        }
        String strA03 = null;
        try {
            strA03 = A01(anonymousClass85);
            A04.set(strA03);
        } catch (Throwable t) {
            A09(anonymousClass85, t);
        }
        if (strA03 == null) {
            strA03 = A02(anonymousClass85);
        }
        if (strA03 == null) {
            return A00;
        }
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences2 = anonymousClass85.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA02, anonymousClass85), 0);
            sharedPreferences2.edit().putString(strA01, A04.get()).apply();
            sharedPreferences2.edit().putLong(strA00, System.currentTimeMillis()).apply();
        }
        return strA03;
    }

    public static String A05(C14238l c14238l, AnonymousClass85 anonymousClass85) {
        if (AbstractC14489l.A04(anonymousClass85)) {
            return A00(63, 5, 5) + A03(anonymousClass85, c14238l) + A00(39, 6, 61) + c14238l.A06() + A00(45, 6, 61) + c14238l.A04() + A00(38, 1, 85);
        }
        return A00(0, 0, 76);
    }

    public static String A06(C14238l c14238l, AnonymousClass85 anonymousClass85, boolean z) {
        return A04(anonymousClass85, z) + A00(0, 38, 50) + anonymousClass85.A05().A9I() + A00(57, 6, 26) + C14238l.A04 + A00(38, 1, 85) + A05(c14238l, anonymousClass85) + A00(68, 5, 13) + anonymousClass85.A05().A9J() + A00(51, 6, 8) + Locale.getDefault().toString() + A00(87, 1, 36);
    }

    public static void A09(AnonymousClass85 anonymousClass85, Throwable th) {
        anonymousClass85.A08().AAu(A00(166, 8, 78), AbstractC14128a.A2i, new C14138b(th));
    }
}
