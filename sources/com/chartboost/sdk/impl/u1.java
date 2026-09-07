package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R(\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Lcom/chartboost/sdk/impl/u1;", "Lcom/chartboost/sdk/impl/s3;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z", "", "onPageFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Z", "Lcom/chartboost/sdk/impl/i6;", "e", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/w9;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/w9;", "a", "()Lcom/chartboost/sdk/impl/w9;", "gestureDetector", "g", "Z", "getHasLoadFinished", "()Z", "setHasLoadFinished", "(Z)V", "getHasLoadFinished$annotations", "()V", "hasLoadFinished", "Lcom/chartboost/sdk/impl/t3;", "callback", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/w9;Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u1 extends s3 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final i6 impressionInterface;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final w9 gestureDetector;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean hasLoadFinished;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(i6 impressionInterface, w9 gestureDetector, t3 callback, l4 eventTracker) {
        super(callback, eventTracker, impressionInterface, y2.b.d().b().get());
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(gestureDetector, "gestureDetector");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.impressionInterface = impressionInterface;
        this.gestureDetector = gestureDetector;
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.c, view, url);
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/u1;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.c, view, url);
        safedk_u1_onPageFinished_d9b6e6e2a040a53e538eb3cba6f5511f(view, url);
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.c, view, url);
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.c, view, errorCode, description, failingUrl);
    }

    public boolean safedk_u1_shouldOverrideUrlLoading_7b844e5157020f74bd75f4c2d1b164f3(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "request.url.toString()");
        return b(string);
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.c, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/u1;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_u1_shouldOverrideUrlLoading_7b844e5157020f74bd75f4c2d1b164f3 = safedk_u1_shouldOverrideUrlLoading_7b844e5157020f74bd75f4c2d1b164f3(view, request);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.c, view, request, zSafedk_u1_shouldOverrideUrlLoading_7b844e5157020f74bd75f4c2d1b164f3);
        return zSafedk_u1_shouldOverrideUrlLoading_7b844e5157020f74bd75f4c2d1b164f3;
    }

    @Override // com.chartboost.sdk.impl.s3, android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/u1;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_u1_shouldOverrideUrlLoading_25a1a04714428e3f863b503eede6b4b2 = safedk_u1_shouldOverrideUrlLoading_25a1a04714428e3f863b503eede6b4b2(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.c, view, url, zSafedk_u1_shouldOverrideUrlLoading_25a1a04714428e3f863b503eede6b4b2);
        return zSafedk_u1_shouldOverrideUrlLoading_25a1a04714428e3f863b503eede6b4b2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final w9 getGestureDetector() {
        return this.gestureDetector;
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean safedk_u1_shouldOverrideUrlLoading_25a1a04714428e3f863b503eede6b4b2(WebView p0, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return b(url);
    }

    public void safedk_u1_onPageFinished_d9b6e6e2a040a53e538eb3cba6f5511f(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        this.hasLoadFinished = true;
    }

    public final boolean b(String url) {
        if (!this.hasLoadFinished) {
            b7.b("Attempt to open " + url + " detected before WebView loading finished.", null, 2, null);
            this.impressionInterface.d(new m2(url, Boolean.FALSE));
            return true;
        }
        if (!this.gestureDetector.getHasClick()) {
            return false;
        }
        this.impressionInterface.c(new m2(url, Boolean.FALSE));
        this.gestureDetector.b();
        return true;
    }
}
