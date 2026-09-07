package com.smaato.sdk.core.browser;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.BaseWebChromeClient;
import com.smaato.sdk.core.webview.BaseWebViewClient;
import com.smaato.sdk.core.webview.WebViewClientCallbackAdapter;

/* JADX INFO: loaded from: classes6.dex */
class BrowserModel {
    private Callback browserModelCallback;
    private String lastKnownUrl;
    private final Logger logger;
    private final SmaatoCookieManager smaatoCookieManager;
    private final BaseWebChromeClient webChromeClient;
    private final BaseWebChromeClient.WebChromeClientCallback webChromeClientCallback;
    private WebView webView;
    private final BaseWebViewClient webViewClient;
    private final BaseWebViewClient.WebViewClientCallback webViewClientCallback;

    public interface Callback {
        void onGeneralError(int i, String str, String str2);

        void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

        void onPageNavigationStackChanged(boolean z, boolean z2);

        void onProgressChanged(int i);

        void onRenderProcessGone();

        void onUrlLoadingStarted(String str);

        boolean shouldOverrideUrlLoading(String str);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.browser.BrowserModel$2, reason: invalid class name */
    class AnonymousClass2 extends WebViewClientCallbackAdapter {
        AnonymousClass2() {
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public boolean shouldOverrideUrlLoading(String str) {
            if (BrowserModel.this.browserModelCallback != null) {
                return BrowserModel.this.browserModelCallback.shouldOverrideUrlLoading(str);
            }
            return false;
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onPageStartedLoading(String str) {
            BrowserModel.this.lastKnownUrl = str;
            if (BrowserModel.this.browserModelCallback != null) {
                BrowserModel.this.browserModelCallback.onUrlLoadingStarted(str);
            }
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onPageFinishedLoading(String str) {
            BrowserModel.this.smaatoCookieManager.forceCookieSync();
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onHttpError(final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
            BrowserModel.this.logger.debug(LogDomain.BROWSER, "BrowserModel.onHttpError statusCode=%d", Integer.valueOf(webResourceResponse.getStatusCode()));
            Objects.onNotNull(BrowserModel.this.browserModelCallback, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserModel$2$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BrowserModel.Callback) obj).onHttpError(webResourceRequest, webResourceResponse);
                }
            });
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onGeneralError(final int i, final String str, final String str2) {
            BrowserModel.this.logger.debug(LogDomain.BROWSER, "BrowserModel.onGeneralError errorCode=%d, description=%s, url=%s", Integer.valueOf(i), str, str2);
            Objects.onNotNull(BrowserModel.this.browserModelCallback, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserModel$2$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BrowserModel.Callback) obj).onGeneralError(i, str, str2);
                }
            });
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onRenderProcessGone() {
            BrowserModel.this.logger.error(LogDomain.BROWSER, "WebView's render process has exited", new Object[0]);
            Objects.onNotNull(BrowserModel.this.browserModelCallback, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserModel$2$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BrowserModel.Callback) obj).onRenderProcessGone();
                }
            });
        }
    }

    BrowserModel(Logger logger, BaseWebViewClient baseWebViewClient, BaseWebChromeClient baseWebChromeClient, SmaatoCookieManager smaatoCookieManager) {
        BaseWebChromeClient.WebChromeClientCallback webChromeClientCallback = new BaseWebChromeClient.WebChromeClientCallback() { // from class: com.smaato.sdk.core.browser.BrowserModel.1
            @Override // com.smaato.sdk.core.webview.BaseWebChromeClient.WebChromeClientCallback
            public void onProgressChanged(int i) {
                if (BrowserModel.this.browserModelCallback != null) {
                    BrowserModel.this.browserModelCallback.onProgressChanged(i);
                    if (BrowserModel.this.webView != null) {
                        BrowserModel.this.browserModelCallback.onPageNavigationStackChanged(BrowserModel.this.webView.canGoBack(), BrowserModel.this.webView.canGoForward());
                    }
                }
            }
        };
        this.webChromeClientCallback = webChromeClientCallback;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.webViewClientCallback = anonymousClass2;
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger cannot be null for BrowserModel::new");
        this.webViewClient = (BaseWebViewClient) Objects.requireNonNull(baseWebViewClient, "Parameter webViewClient cannot be null for BrowserModel::new");
        this.webChromeClient = (BaseWebChromeClient) Objects.requireNonNull(baseWebChromeClient, "Parameter webChromeClient cannot be null for BrowserModel::new");
        this.smaatoCookieManager = (SmaatoCookieManager) Objects.requireNonNull(smaatoCookieManager, "Parameter smaatoCookieManager cannot be null for BrowserModel::BrowserModel");
        baseWebViewClient.setWebViewClientCallback(anonymousClass2);
        baseWebChromeClient.setWebChromeClientCallback(webChromeClientCallback);
    }

    public void setWebView(WebView webView) {
        this.webView = (WebView) Objects.requireNonNull(webView, "Parameter webView cannot be null for BrowserModel::setWebView");
        webView.setWebViewClient(this.webViewClient);
        webView.setWebChromeClient(this.webChromeClient);
        this.smaatoCookieManager.setupCookiePolicy(webView);
    }

    public void setBrowserModelCallback(Callback callback) {
        this.browserModelCallback = callback;
    }

    public void load(String str) {
        Objects.requireNonNull(str, "Parameter url cannot be null for BrowserModel::load");
        this.lastKnownUrl = str;
        SmaatoNetworkBridge.webviewLoadUrl((WebView) Objects.requireNonNull(this.webView), str);
    }

    public void reload() {
        ((WebView) Objects.requireNonNull(this.webView)).reload();
    }

    public void goBack() {
        ((WebView) Objects.requireNonNull(this.webView)).goBack();
    }

    public void goForward() {
        ((WebView) Objects.requireNonNull(this.webView)).goForward();
    }

    public String getCurrentUrl() {
        if (this.lastKnownUrl == null) {
            this.logger.error(LogDomain.BROWSER, "Internal error: loadUrl() was not called", new Object[0]);
        }
        return this.lastKnownUrl;
    }

    public void start() {
        this.smaatoCookieManager.startSync();
    }

    public void resume() {
        ((WebView) Objects.requireNonNull(this.webView)).onResume();
    }

    public void pause() {
        ((WebView) Objects.requireNonNull(this.webView)).onPause();
    }

    public void stop() {
        this.smaatoCookieManager.stopSync();
        this.smaatoCookieManager.forceCookieSync();
    }
}
