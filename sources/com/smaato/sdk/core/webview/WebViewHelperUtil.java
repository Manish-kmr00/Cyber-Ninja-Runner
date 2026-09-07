package com.smaato.sdk.core.webview;

import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.util.Objects;
import com.unity3d.ads.adplayer.AndroidWebViewClient;

/* JADX INFO: loaded from: classes10.dex */
public final class WebViewHelperUtil {
    static void destroyWebViewSafely(WebView webView) {
        Objects.requireNonNull(webView, "Parameter webView cannot be null for WebViewHelperUtil::destroyWebViewSafely");
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        webView.removeAllViews();
        webView.destroy();
    }

    public static void resetAndDestroyWebViewSafely(final WebView webView) {
        Objects.requireNonNull(webView);
        webView.stopLoading();
        BaseWebViewClient baseWebViewClient = new BaseWebViewClient();
        baseWebViewClient.setWebViewClientCallback(new WebViewClientCallbackAdapter() { // from class: com.smaato.sdk.core.webview.WebViewHelperUtil.1
            @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
            public void onPageFinishedLoading(String str) {
                if (AndroidWebViewClient.BLANK_PAGE.equals(str)) {
                    Log.d(LogDomain.CORE.name(), "going to release web-view");
                    WebViewHelperUtil.destroyWebViewSafely(webView);
                }
            }
        });
        webView.setWebViewClient(baseWebViewClient);
        SmaatoNetworkBridge.webviewLoadUrl(webView, AndroidWebViewClient.BLANK_PAGE);
    }

    public static String getCenterContentCss() {
        return "display: flex;align-items: center;justify-content: center;";
    }
}
