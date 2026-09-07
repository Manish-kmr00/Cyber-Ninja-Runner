package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.io.ByteArrayInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes13.dex */
public final class v21 extends xg0 {
    private String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v21(yg0 webViewClientListener) {
        super(webViewClientListener);
        Intrinsics.checkNotNullParameter(webViewClientListener, "webViewClientListener");
    }

    @Override // com.yandex.mobile.ads.impl.xg0, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.y, view, url);
    }

    @Override // com.yandex.mobile.ads.impl.xg0, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.y, view, url);
    }

    @Override // com.yandex.mobile.ads.impl.xg0, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Uri url;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String str = this.c;
        if (str == null || str.length() <= 0 || (url = request.getUrl()) == null || !Intrinsics.areEqual("mraid.js", url.getLastPathSegment())) {
            return super.shouldInterceptRequest(view, request);
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new WebResourceResponse(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT, "UTF-8", new ByteArrayInputStream(bytes));
    }

    public final void a(String str) {
        this.c = str;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return super.shouldInterceptRequest(view, url);
    }
}
