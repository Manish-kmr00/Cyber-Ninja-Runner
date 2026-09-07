package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ey, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1573Ey extends WebViewClient {
    public static byte[] A05;
    public InterfaceC1569Eu A00 = new InterfaceC1569Eu() { // from class: com.facebook.ads.redexgen.X.hB
        @Override // com.facebook.ads.redexgen.core.InterfaceC1569Eu
        public final boolean AAU(String str) {
            return C1573Ey.A04(str);
        }
    };
    public WeakReference<InterfaceC1571Ew> A01 = new WeakReference<>(null);
    public final WeakReference<C2699k1> A02;
    public final WeakReference<InterfaceC1570Ev> A03;
    public final WeakReference<C1566Er> A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{Ascii.FS, Ascii.US, Ascii.DC2, 8, 9, 71, Ascii.US, 17, Ascii.FS, 19, Ascii.SYN, 37, 42, Ascii.ESC, 37, 39, 48, 45, 50, 45, 48, Base64.padSymbol, Ascii.FF, 3, 9, Ascii.US, 2, 4, 9, 67, 4, 3, Ascii.EM, 8, 3, Ascii.EM, 67, Ascii.FF, Ascii.SO, Ascii.EM, 4, 2, 3, 67, 59, 36, 40, 58, 119, 120, 114, 100, 121, 127, 114, 56, 127, 120, 98, 115, 120, 98, 56, 117, 119, 98, 115, 113, 121, 100, 111, 56, 84, 68, 89, 65, 69, 87, 84, 90, 83, 117, 101, 120, 96, 100, 114, 101, 72, 113, 118, 123, 123, 117, 118, 116, 124, 72, 98, 101, 123, 51, 54, 35, 54, 97, 102, 124, 109, 102, 124, 2, 5, Ascii.ESC, 77, 87, Ascii.US, Ascii.CR, 10, 55, Ascii.RS, 1, Ascii.CR, Ascii.US};
    }

    public C1573Ey(WeakReference<C2699k1> weakReference, WeakReference<InterfaceC1570Ev> weakReference2, WeakReference<C1566Er> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    private void A02(String str, C2699k1 c2699k1) {
        c2699k1.A08().AAu(A00(11, 11, 104), AbstractC14128a.A09, new C14138b(A00(111, 5, 91) + str));
    }

    private boolean A03(WebView webView, String str) {
        Intent intent;
        String strA00 = A00(116, 8, 68);
        C2699k1 c2699k1 = this.A02.get();
        if (c2699k1 == null) {
            return false;
        }
        if ((C2527h9.A0A && (TextUtils.isEmpty(str) || A00(0, 11, 81).equals(str))) || !this.A00.AAU(str)) {
            return true;
        }
        try {
            Uri uri = C5.A00(str);
            String scheme = uri.getScheme();
            try {
                boolean zA13 = C14499m.A13(c2699k1);
                String strA01 = A00(48, 33, 58);
                String strA02 = A00(22, 26, 65);
                String strA03 = A00(105, 6, 36);
                if (zA13) {
                    if (!C2527h9.A0E.contains(scheme) && !A00(101, 4, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE).equals(scheme)) {
                        if (strA03.equalsIgnoreCase(scheme)) {
                            intent = Intent.parseUri(str, 1);
                            intent.setComponent(null);
                            intent.setSelector(null);
                        } else {
                            intent = new Intent(strA02, uri);
                        }
                        intent.addCategory(strA01);
                        if (Build.VERSION.SDK_INT >= 30) {
                            intent.setFlags(268436480);
                        } else {
                            intent.setFlags(268435456);
                        }
                        try {
                            if (!C1491Bq.A0D(c2699k1, intent)) {
                                A02(str, c2699k1);
                            }
                            return true;
                        } catch (C1489Bo unused) {
                            if (strA03.equals(scheme)) {
                                String stringExtra = intent.getStringExtra(A00(81, 20, 59));
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    if (!C1491Bq.A0D(c2699k1, new Intent(strA02, C5.A00(stringExtra)))) {
                                        A02(str, c2699k1);
                                    }
                                    return true;
                                }
                            }
                            C14138b c14138b = new C14138b(A00(111, 5, 91) + str);
                            c14138b.A05(1);
                            c2699k1.A08().AAv(A00(11, 11, 104), AbstractC14128a.A06, c14138b);
                            return true;
                        }
                    }
                    return false;
                }
                if (C2527h9.A0A && strA03.equalsIgnoreCase(scheme)) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    uri2.addCategory(strA01);
                    uri2.setComponent(null);
                    uri2.setSelector(null);
                    if (c2699k1.getPackageManager().resolveActivity(uri2, 65536) != null && C1491Bq.A0D(c2699k1, uri2)) {
                        webView.goBack();
                        return true;
                    }
                } else if ((C2527h9.A0A && CT.A04(str)) || !C2527h9.A0E.contains(scheme)) {
                    return C1491Bq.A0D(c2699k1, new Intent(strA02, uri));
                }
            } catch (Exception e) {
                c2699k1.A08().AAv(strA00, AbstractC14128a.A2d, new C14138b(e));
                c2699k1.A0F().A9s(e.toString());
            }
            return false;
        } catch (SecurityException e2) {
            c2699k1.A08().AAv(strA00, AbstractC14128a.A2d, new C14138b(e2));
            return true;
        }
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(InterfaceC1569Eu interfaceC1569Eu) {
        this.A00 = interfaceC1569Eu;
    }

    public final void A06(WeakReference<InterfaceC1571Ew> weakReference) {
        this.A01 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C1566Er timingLogger = this.A04.get();
        if (timingLogger != null) {
            timingLogger.A03();
        }
        InterfaceC1570Ev interfaceC1570Ev = this.A03.get();
        if (interfaceC1570Ev != null) {
            interfaceC1570Ev.AEM(str);
        }
        InterfaceC1571Ew interfaceC1571Ew = this.A01.get();
        if (interfaceC1571Ew != null) {
            interfaceC1571Ew.ACT(webView.canGoBack());
            interfaceC1571Ew.ADC(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        InterfaceC1570Ev listener = this.A03.get();
        if (listener != null) {
            listener.AEO(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C2699k1 c2699k1 = this.A02.get();
        if (c2699k1 != null) {
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = CT.A01(i, sb.append(strA00).append(str).toString(), strA00 + str2);
            c2699k1.A0F().A9p(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C2699k1 c2699k1 = this.A02.get();
        if (c2699k1 != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = CT.A01(errorCode, sb.append(strA00).append((Object) webResourceError.getDescription()).toString(), strA00 + webResourceRequest.getUrl());
            c2699k1.A0F().A9p(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C2699k1 context = this.A02.get();
        if (context != null) {
            context.A0F().A9q();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C2699k1 context = this.A02.get();
        if (context != null) {
            context.A0F().A9r();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        F1.A02(AbstractC14128a.A2e);
        InterfaceC1570Ev listener = this.A03.get();
        if (listener != null) {
            listener.AEo();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
