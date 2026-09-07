package com.inmobi.media;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.core.configs.AdConfig;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Y1 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3242a = new AtomicBoolean(false);
    public boolean b;
    public final /* synthetic */ T1 c;
    public final /* synthetic */ Handler d;
    public final /* synthetic */ Z1 e;

    public Y1(T1 t1, Z1 z1, Handler handler) {
        this.c = t1;
        this.d = handler;
        this.e = z1;
    }

    public static final void a(Y1 this$0, T1 click, Handler handler, Z1 this$1, final WebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(click, "$click");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        try {
            AdConfig.ImaiConfig imaiConfig = C3364f2.g;
            Thread.sleep((imaiConfig != null ? imaiConfig.getPingInterval() : 0) * 1000);
        } catch (InterruptedException unused) {
        }
        if (this$0.f3242a.get()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
        String str = click.b;
        click.i.set(true);
        handler.post(new Runnable() { // from class: com.inmobi.media.Y1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Y1.a(webView);
            }
        });
        this$1.f3251a.a(click, I3.e);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.i, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.i, webView, str);
        safedk_Y1_onPageFinished_28d0bf422740e62bf6fa66e1bb051447(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.i, webView, str);
        safedk_Y1_onPageStarted_3407bf86c799dec89087cbdfd8aac096(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, i, str, str2);
        safedk_Y1_onReceivedError_f244daba85176d52b4e13ab86aa84641(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, webResourceRequest, webResourceError);
        safedk_Y1_onReceivedError_a916c16ff48655d82861d70e3f34202d(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.b = true;
        this.e.f3251a.a(this.c, I3.e);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return qd.a(view, detail, "click_mgr");
    }

    public void safedk_Y1_onPageFinished_28d0bf422740e62bf6fa66e1bb051447(WebView p0, String p1) {
        this.f3242a.set(true);
        if (this.b || this.c.i.get()) {
            return;
        }
        this.e.f3251a.a(this.c);
    }

    public void safedk_Y1_onPageStarted_3407bf86c799dec89087cbdfd8aac096(final WebView p0, String p1, Bitmap p2) {
        this.b = false;
        int i = S3.f3188a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) S3.b.getValue();
        final T1 t1 = this.c;
        final Handler handler = this.d;
        final Z1 z1 = this.e;
        scheduledThreadPoolExecutor.submit(new Runnable() { // from class: com.inmobi.media.Y1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Y1.a(this.f$0, t1, handler, z1, p0);
            }
        });
    }

    public void safedk_Y1_onReceivedError_f244daba85176d52b4e13ab86aa84641(WebView view, int p1, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        this.b = true;
        this.e.f3251a.a(this.c, I3.e);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.i, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_Y1_shouldOverrideUrlLoading_9ecd68dc69e9fc71227c6f1655cafae7 = safedk_Y1_shouldOverrideUrlLoading_9ecd68dc69e9fc71227c6f1655cafae7(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, webResourceRequest, zSafedk_Y1_shouldOverrideUrlLoading_9ecd68dc69e9fc71227c6f1655cafae7);
        return zSafedk_Y1_shouldOverrideUrlLoading_9ecd68dc69e9fc71227c6f1655cafae7;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Y1;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_Y1_shouldOverrideUrlLoading_d6c3a9c0a894913f4737044f41d5989c = safedk_Y1_shouldOverrideUrlLoading_d6c3a9c0a894913f4737044f41d5989c(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, str, zSafedk_Y1_shouldOverrideUrlLoading_d6c3a9c0a894913f4737044f41d5989c);
        return zSafedk_Y1_shouldOverrideUrlLoading_d6c3a9c0a894913f4737044f41d5989c;
    }

    public boolean safedk_Y1_shouldOverrideUrlLoading_9ecd68dc69e9fc71227c6f1655cafae7(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        return (this.c.d || Intrinsics.areEqual(request.getUrl().toString(), this.c.b)) ? false : true;
    }

    public void safedk_Y1_onReceivedError_a916c16ff48655d82861d70e3f34202d(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        this.b = true;
        this.e.f3251a.a(this.c, I3.e);
    }

    public boolean safedk_Y1_shouldOverrideUrlLoading_d6c3a9c0a894913f4737044f41d5989c(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        T1 t1 = this.c;
        return (t1.d || Intrinsics.areEqual(url, t1.b)) ? false : true;
    }

    public static final void a(WebView webView) {
        try {
            nd ndVar = webView instanceof nd ? (nd) webView : null;
            if (ndVar == null || ndVar.f3383a) {
                return;
            }
            ((nd) webView).stopLoading();
        } catch (Throwable th) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(th);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        }
    }
}
