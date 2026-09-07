package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.moloco.sdk.internal.MolocoLogger;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends WebViewClientCompat {
    public static final a g = new a(null);
    public static final String h = "MraidWebViewClient";
    public static final String i = "com.moloco.sdk.xenoss.sdkdevkit.mraid.js";
    public static final String j = "mraid.js";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6663a;
    public final WebViewAssetLoader b;
    public final MutableStateFlow<Boolean> c;
    public final StateFlow<Boolean> d;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> e;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final Uri a(WebResourceRequest webResourceRequest) {
            String string;
            Uri url = webResourceRequest.getUrl();
            if (url == null || (string = url.toString()) == null) {
                string = "";
            }
            Uri uri = Uri.parse(StringsKt.replace(string, "mraid.js", v.i, true));
            Intrinsics.checkNotNullExpressionValue(uri, "parse(\n            (requ…e\n            )\n        )");
            return uri;
        }
    }

    public v(Context context, o mraidJsCommandsSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidJsCommandsSource, "mraidJsCommandsSource");
        this.f6663a = mraidJsCommandsSource;
        WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler(RemoteSettings.FORWARD_SLASH_STRING, new WebViewAssetLoader.AssetsPathHandler(context.getApplicationContext())).build();
        Intrinsics.checkNotNullExpressionValue(webViewAssetLoaderBuild, "Builder()\n        .addPa…ontext))\n        .build()");
        this.b = webViewAssetLoaderBuild;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.c = MutableStateFlow;
        this.d = MutableStateFlow;
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.e = MutableStateFlow2;
        this.f = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> a() {
        return this.f;
    }

    public final StateFlow<Boolean> b() {
        return this.d;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.D, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/v;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.D, webView, str);
        safedk_v_onPageFinished_fd963bd783ec820acb286fd832e38b9b(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/v;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.D, webView, str);
        safedk_v_onPageStarted_55221ab48d74c55e8788c556e1a7ef7d(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/v;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.D, webView, i2, str, str2);
        safedk_v_onReceivedError_f1a85c036fc199ed74f1b28e0ad6ef1f(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    public void safedk_v_onPageFinished_fd963bd783ec820acb286fd832e38b9b(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        this.c.setValue(Boolean.TRUE);
    }

    public void safedk_v_onPageStarted_55221ab48d74c55e8788c556e1a7ef7d(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        this.c.setValue(Boolean.FALSE);
    }

    @Deprecated(message = "Deprecated in Android API 23")
    public void safedk_v_onReceivedError_f1a85c036fc199ed74f1b28e0ad6ef1f(WebView p0, int p1, String p2, String p3) {
        super.onReceivedError(p0, p1, p2, p3);
        this.e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "onReceivedError " + p2, null, false, 12, null);
    }

    public WebResourceResponse safedk_v_shouldInterceptRequest_9758fda964674f93761b73de2965b496(WebView p0, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.b.shouldInterceptRequest(g.a(request));
    }

    @Deprecated(message = "Deprecated in Android API 24")
    public boolean safedk_v_shouldOverrideUrlLoading_3a85b6dad567bd3b224e372e54b957f9(WebView p0, String p1) {
        if (p1 == null) {
            return false;
        }
        return this.f6663a.a(p1);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/v;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.D, webView, webResourceRequest, safedk_v_shouldInterceptRequest_9758fda964674f93761b73de2965b496(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 24")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("MolocoAds|SafeDK: Execution> Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/v;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_v_shouldOverrideUrlLoading_3a85b6dad567bd3b224e372e54b957f9 = safedk_v_shouldOverrideUrlLoading_3a85b6dad567bd3b224e372e54b957f9(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.D, webView, str, zSafedk_v_shouldOverrideUrlLoading_3a85b6dad567bd3b224e372e54b957f9);
        return zSafedk_v_shouldOverrideUrlLoading_3a85b6dad567bd3b224e372e54b957f9;
    }
}
