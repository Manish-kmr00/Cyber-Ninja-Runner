package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.io.ByteArrayInputStream;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e5 extends s9 {
    public static final WebResourceResponse d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f7289a = null;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final y4 c = y4.f7449a;

    static {
        byte[] bytes = "".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        d = new WebResourceResponse("text/image", "UTF-8", new ByteArrayInputStream(bytes));
    }

    @Override // com.ogury.ad.internal.s9
    public WebResourceResponse a(WebView view, final String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(url, "<this>");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = url.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.startsWith$default(lowerCase, "http://ogymraid", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "https://ogymraid", false, 2, (Object) null)) {
            this.b.post(new Runnable() { // from class: com.ogury.ad.internal.e5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    e5.a(url, this);
                }
            });
            return d;
        }
        if (Intrinsics.areEqual("mraid.js", Uri.parse(url).getLastPathSegment())) {
            return a(view);
        }
        return null;
    }

    @Override // com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded("io.presage", view, url);
    }

    @Override // com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished("io.presage", view, url);
    }

    @Override // com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted("io.presage", view, url);
    }

    public static final void a(String url, e5 e5Var) {
        f5 f5Var;
        u3 u3Var = u3.f7411a;
        m9.a(url);
        u3Var.getClass();
        g5 g5Var = (g5) e5Var;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        d5 webView = g5Var.e;
        webView.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        if (webView.q.containsMatchIn(url)) {
            webView.h = true;
            w4 w4Var = webView.p;
            w4Var.getClass();
            Intrinsics.checkNotNullParameter(webView, "webView");
            w4Var.b.a(webView.getMraidCommandExecutor());
            f5 f5Var2 = webView.m;
            if (f5Var2 != null) {
                f5Var2.b(webView);
            }
        } else if (webView.r.containsMatchIn(url) && (f5Var = webView.m) != null) {
            f5Var.a(webView);
        }
        webView.i.a(url, webView, webView.f7280a);
    }

    public final WebResourceResponse a(WebView webView) {
        String strA;
        y4 y4Var = this.c;
        Context context = webView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        p pVar = this.f7289a;
        y4Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (pVar != null && Intrinsics.areEqual(pVar.c, "optin_video")) {
            strA = s4.a(pVar);
        } else {
            strA = "window.MRAID_ENV =  { version: '3.0', sdk: 'Presage', sdkVersion: '5.0.1'};";
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (p4.b == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            p4.b = new p4(applicationContext);
        }
        p4 p4Var = p4.b;
        Intrinsics.checkNotNull(p4Var);
        SharedPreferences sharedPref = p4Var.f7383a;
        Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
        String strA2 = p8.a(sharedPref, "mraid_js");
        WebResourceResponse webResourceResponseA = strA2.length() > 0 ? y4.a(strA2, strA) : null;
        if (webResourceResponseA != null) {
            return webResourceResponseA;
        }
        this.b.post(new Runnable() { // from class: com.ogury.ad.internal.e5$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e5.a(this.f$0);
            }
        });
        return d;
    }

    public static final void a(e5 e5Var) {
        g5 g5Var = (g5) e5Var;
        g5Var.getClass();
        u3.f7411a.getClass();
        f5 f5Var = g5Var.f;
        if (f5Var != null) {
            f5Var.a("Mraid injection failed");
        }
    }
}
