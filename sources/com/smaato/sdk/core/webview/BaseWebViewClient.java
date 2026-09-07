package com.smaato.sdk.core.webview;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public class BaseWebViewClient extends WebViewClient {
    private WebViewClientCallback webViewClientCallback;

    public interface WebViewClientCallback {
        void onGeneralError(int i, String str, String str2);

        void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

        void onPageFinishedLoading(String str);

        void onPageStartedLoading(String str);

        void onRenderProcessGone();

        boolean shouldOverrideUrlLoading(String str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.v, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.v, webView, str);
        safedk_BaseWebViewClient_onPageFinished_59d80ff9bfda2c8665759b51042ff56c(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.v, webView, str);
        safedk_BaseWebViewClient_onPageStarted_abab612fd85830b1743942ff07cfdf22(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.v, webView, i, str, str2);
        safedk_BaseWebViewClient_onReceivedError_a39c12aa172e3d5df941e9fb232d2177(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.v, webView, webResourceRequest, webResourceError);
        safedk_BaseWebViewClient_onReceivedError_36b87bda8fb34bc714d0d7ff7f7eb3ca(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.v, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_330afd7d17a42d68dc317dcc7229c322 = safedk_BaseWebViewClient_shouldOverrideUrlLoading_330afd7d17a42d68dc317dcc7229c322(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.v, webView, webResourceRequest, zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_330afd7d17a42d68dc317dcc7229c322);
        return zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_330afd7d17a42d68dc317dcc7229c322;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Smaato|SafeDK: Execution> Lcom/smaato/sdk/core/webview/BaseWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_dd79d2237401dd004a034b2f2f84d9a1 = safedk_BaseWebViewClient_shouldOverrideUrlLoading_dd79d2237401dd004a034b2f2f84d9a1(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.v, webView, str, zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_dd79d2237401dd004a034b2f2f84d9a1);
        return zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_dd79d2237401dd004a034b2f2f84d9a1;
    }

    public void setWebViewClientCallback(WebViewClientCallback webViewClientCallback) {
        this.webViewClientCallback = webViewClientCallback;
    }

    public void safedk_BaseWebViewClient_onPageStarted_abab612fd85830b1743942ff07cfdf22(WebView p0, final String p1, Bitmap p2) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebViewClient.WebViewClientCallback) obj).onPageStartedLoading(p1);
            }
        });
    }

    public void safedk_BaseWebViewClient_onPageFinished_59d80ff9bfda2c8665759b51042ff56c(WebView p0, final String p1) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebViewClient.WebViewClientCallback) obj).onPageFinishedLoading(p1);
            }
        });
    }

    public boolean safedk_BaseWebViewClient_shouldOverrideUrlLoading_dd79d2237401dd004a034b2f2f84d9a1(WebView p0, String p1) {
        return shouldOverrideUrlLoadingInternal(p1);
    }

    public boolean safedk_BaseWebViewClient_shouldOverrideUrlLoading_330afd7d17a42d68dc317dcc7229c322(WebView p0, WebResourceRequest p1) {
        return shouldOverrideUrlLoadingInternal(p1.getUrl().toString());
    }

    private boolean shouldOverrideUrlLoadingInternal(String str) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback == null) {
            return false;
        }
        return webViewClientCallback.shouldOverrideUrlLoading(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebViewClient.WebViewClientCallback) obj).onHttpError(webResourceRequest, webResourceResponse);
            }
        });
    }

    public void safedk_BaseWebViewClient_onReceivedError_a39c12aa172e3d5df941e9fb232d2177(WebView p0, final int p1, final String p2, final String p3) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebViewClient.WebViewClientCallback) obj).onGeneralError(p1, p2, p3);
            }
        });
    }

    public void safedk_BaseWebViewClient_onReceivedError_36b87bda8fb34bc714d0d7ff7f7eb3ca(WebView p0, final WebResourceRequest p1, final WebResourceError p2) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                WebResourceError webResourceError = p2;
                ((BaseWebViewClient.WebViewClientCallback) obj).onGeneralError(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), p1.getUrl().toString());
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Objects.onNotNull(this.webViewClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebViewClient$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebViewClient.WebViewClientCallback) obj).onRenderProcessGone();
            }
        });
        return true;
    }
}
