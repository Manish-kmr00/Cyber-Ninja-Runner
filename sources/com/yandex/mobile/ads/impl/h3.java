package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class h3 extends uk {

    private final class a extends WebChromeClient {
        static final /* synthetic */ KProperty<Object>[] b = {ta.a(a.class, "context", "getContext()Landroid/content/Context;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f9055a;

        public a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f9055a = ao1.a(context);
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            Object obj = (Context) this.f9055a.getValue(this, b[0]);
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar != null) {
                cVar.a(view, i);
            }
        }
    }

    private final class b extends WebViewClient {
        static final /* synthetic */ KProperty<Object>[] d = {ta.a(b.class, "context", "getContext()Landroid/content/Context;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f9056a;
        private final qj2 b;
        private final q82 c;

        public b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f9056a = ao1.a(context);
            this.b = ws1.b();
            this.c = new q82();
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.y, view, url);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView view, String str) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onPageFinished(view, str);
            Object obj = (Context) this.f9056a.getValue(this, d[0]);
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar != null) {
                cVar.b(view);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView view, String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onPageStarted(view, str, bitmap);
            Object obj = (Context) this.f9056a.getValue(this, d[0]);
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar != null) {
                cVar.a(view);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.y, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            qj2 qj2Var = this.b;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (qj2Var.a(context, error)) {
                handler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }

        public boolean safedk_h3$b_shouldOverrideUrlLoading_5722a7a33b68f2cc139642786867e376(WebView view, String p1) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (p1 != null && p1.length() > 0) {
                o82.f9793a.getClass();
                if (o82.a.c(p1) || !URLUtil.isNetworkUrl(p1)) {
                    q82 q82Var = this.c;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    return q82Var.a(context, p1);
                }
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.y, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Yandex|SafeDK: Execution> Lcom/yandex/mobile/ads/impl/h3$b;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_h3$b_shouldOverrideUrlLoading_5722a7a33b68f2cc139642786867e376 = safedk_h3$b_shouldOverrideUrlLoading_5722a7a33b68f2cc139642786867e376(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.y, webView, str, zSafedk_h3$b_shouldOverrideUrlLoading_5722a7a33b68f2cc139642786867e376);
            return zSafedk_h3$b_shouldOverrideUrlLoading_5722a7a33b68f2cc139642786867e376;
        }
    }

    public interface c {
        void a(WebView webView);

        void a(WebView webView, int i);

        void b(WebView webView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    protected final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(-1);
        setInitialScale(1);
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        setDisplayZoomControls(false);
        setScrollbarFadingEnabled(true);
        setDrawingCacheEnabled(true);
        setWebChromeClient(new a(context));
        setWebViewClient(new b(context));
    }

    @Override // com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
