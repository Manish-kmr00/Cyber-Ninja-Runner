package com.pubmatic.sdk.webrendering.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class POBMraidWebClient extends POBHTMLViewClient {
    POBMraidWebClient(POBHTMLViewClient.OnRenderProcessGoneListener onRenderProcessGoneListener) {
        super(onRenderProcessGoneListener);
    }

    private WebResourceResponse a(Context context) {
        String mraidJs = POBInstanceProvider.getCacheManager(context).getMraidJs();
        if (mraidJs == null) {
            return null;
        }
        return new WebResourceResponse(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT, StandardCharsets.UTF_8.name(), new ByteArrayInputStream(("javascript:" + mraidJs).getBytes()));
    }

    private boolean b(String str) {
        return "mraid.js".equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment());
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.F, view, url);
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.F, view, url);
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.F, view, url);
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.F, view, errorCode, description, failingUrl);
    }

    public WebResourceResponse safedk_POBMraidWebClient_shouldInterceptRequest_515b253a803ef50025de451783a3226a(WebView p0, String p1) {
        if (!b(p1)) {
            return super.shouldInterceptRequest(p0, p1);
        }
        POBLog.debug("POBMraidWebClient", "Injecting MRAID in webView via url", new Object[0]);
        WebResourceResponse webResourceResponseA = a(p0.getContext());
        return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(p0, p1);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/webrendering/mraid/POBMraidWebClient;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.F, webView, webResourceRequest, safedk_POBMraidWebClient_shouldInterceptRequest_3d39cf0a9504b7bc21cc234683da44bd(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/webrendering/mraid/POBMraidWebClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(com.safedk.android.utils.h.F, webView, str, safedk_POBMraidWebClient_shouldInterceptRequest_515b253a803ef50025de451783a3226a(webView, str));
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.F, view, url, zShouldOverrideUrlLoading);
        return zShouldOverrideUrlLoading;
    }

    public WebResourceResponse safedk_POBMraidWebClient_shouldInterceptRequest_3d39cf0a9504b7bc21cc234683da44bd(WebView p0, WebResourceRequest p1) {
        if (b(p1.getUrl().toString())) {
            POBLog.debug("POBMraidWebClient", "Injecting MRAID in webView via request", new Object[0]);
            WebResourceResponse webResourceResponseA = a(p0.getContext());
            return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(p0, p1);
        }
        return super.shouldInterceptRequest(p0, p1);
    }
}
