package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class F1 extends WebView {
    public static byte[] A01;
    public static final String A02;
    public boolean A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-31, -4, 4, 7, 0, -1, -69, Ascii.SI, 10, -69, 4, 9, 4, Ascii.SI, 4, -4, 7, 4, Ascii.NAK, 0, -69, -34, 10, 10, 6, 4, 0, -24, -4, 9, -4, 2, 0, Ascii.CR, -55, -70, -71, -125, -58, -43, -60, -42, -53, -56, -57, 63, 54, 75, 54, 72, 56, 71, 62, 69, 73, Ascii.SI, -4, -22, -25, -28, -5, -18, -22, -4};
    }

    public abstract WebChromeClient A0D();

    public abstract WebViewClient A0E();

    static {
        A01();
        A02 = F1.class.getSimpleName();
    }

    public F1(Activity activity, C2699k1 c2699k1) {
        super(activity);
        A03(c2699k1);
    }

    public F1(C2699k1 c2699k1) {
        super(c2699k1);
        A03(c2699k1);
    }

    public static void A02(int i) {
        C2698k0 context = AnonymousClass84.A00();
        if (context != null) {
            context.A08().AAu(A00(56, 8, 37), i, new C14138b(A00(35, 10, 3)));
        }
    }

    private void A03(AnonymousClass85 anonymousClass85) {
        setWebChromeClient(A0D());
        setWebViewClient(A0E());
        F7.A04(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        if (anonymousClass85.A05().AAD()) {
            setWebContentsDebuggingEnabled(true);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        try {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        } catch (Exception unused) {
            Log.w(A02, A00(0, 35, 59));
        }
    }

    private void A04(String str) {
        loadUrl(A00(45, 11, 117) + str);
    }

    public final void A05(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException unused) {
            A04(str);
        }
    }

    public final boolean A06() {
        return this.A00;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.A00 = true;
        super.destroy();
    }
}
