package com.smaato.sdk.core.browser;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.UrlCreator;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
class BrowserPresenter {
    private final BrowserModel browserModel;
    private final BrowserModel.Callback browserModelCallback;
    private BrowserView browserView;
    private final ClipboardManager clipboardManager;
    private final LinkHandler linkHandler;
    private final Logger logger;
    private final UrlCreator urlCreator;

    /* JADX INFO: renamed from: com.smaato.sdk.core.browser.BrowserPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements BrowserModel.Callback {
        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onGeneralError(int i, String str, String str2) {
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        }

        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public boolean shouldOverrideUrlLoading(String str) {
            Either<Intent, String> eitherFindExternalAppForUrl = BrowserPresenter.this.linkHandler.findExternalAppForUrl(str);
            if (eitherFindExternalAppForUrl == null) {
                return false;
            }
            Objects.onNotNull(eitherFindExternalAppForUrl.left(), new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserPresenter$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5517xb0dcdc2f((Intent) obj);
                }
            });
            Objects.onNotNull(eitherFindExternalAppForUrl.right(), new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserPresenter$1$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5519x24721fed((String) obj);
                }
            });
            return true;
        }

        /* JADX INFO: renamed from: lambda$shouldOverrideUrlLoading$1$com-smaato-sdk-core-browser-BrowserPresenter$1, reason: not valid java name */
        /* synthetic */ void m5517xb0dcdc2f(final Intent intent) {
            Objects.onNotNull(BrowserPresenter.this.browserView, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserPresenter$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5516x77123a50(intent, (BrowserView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$shouldOverrideUrlLoading$0$com-smaato-sdk-core-browser-BrowserPresenter$1, reason: not valid java name */
        /* synthetic */ void m5516x77123a50(Intent intent, BrowserView browserView) {
            BrowserPresenter.this.logger.debug(LogDomain.BROWSER, "Redirecting to the external app: %s", intent.toString());
            browserView.redirectToExternalApp(intent);
        }

        /* JADX INFO: renamed from: lambda$shouldOverrideUrlLoading$3$com-smaato-sdk-core-browser-BrowserPresenter$1, reason: not valid java name */
        /* synthetic */ void m5519x24721fed(final String str) {
            Objects.onNotNull(BrowserPresenter.this.browserView, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserPresenter$1$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5518xeaa77e0e(str, (BrowserView) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$shouldOverrideUrlLoading$2$com-smaato-sdk-core-browser-BrowserPresenter$1, reason: not valid java name */
        /* synthetic */ void m5518xeaa77e0e(String str, BrowserView browserView) {
            BrowserPresenter.this.logger.debug(LogDomain.BROWSER, "Redirecting to other url: %s", str);
            BrowserPresenter.this.loadUrl(str);
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onUrlLoadingStarted(String str) {
            BrowserPresenter.this.updateHostnameAndSchemeControls(str);
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onPageNavigationStackChanged(boolean z, boolean z2) {
            BrowserPresenter.this.updateNavigationUiControls(z, z2);
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onProgressChanged(int i) {
            if (BrowserPresenter.this.browserView == null) {
                return;
            }
            if (i == 100) {
                BrowserPresenter.this.browserView.hideProgressIndicator();
            } else {
                BrowserPresenter.this.browserView.updateProgressIndicator(i);
                BrowserPresenter.this.browserView.showProgressIndicator();
            }
        }

        @Override // com.smaato.sdk.core.browser.BrowserModel.Callback
        public void onRenderProcessGone() {
            Objects.onNotNull(BrowserPresenter.this.browserView, new Consumer() { // from class: com.smaato.sdk.core.browser.BrowserPresenter$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BrowserView) obj).closeBrowser();
                }
            });
        }
    }

    BrowserPresenter(Logger logger, BrowserModel browserModel, UrlCreator urlCreator, LinkHandler linkHandler, ClipboardManager clipboardManager) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.browserModelCallback = anonymousClass1;
        this.logger = (Logger) Objects.requireNonNull(logger, "Parameter logger cannot be null for BrowserPresenter::new");
        this.browserModel = (BrowserModel) Objects.requireNonNull(browserModel, "Parameter browserModel cannot be null for BrowserPresenter::new");
        this.urlCreator = (UrlCreator) Objects.requireNonNull(urlCreator, "Parameter urlCreator cannot be null for BrowserPresenter::new");
        this.linkHandler = (LinkHandler) Objects.requireNonNull(linkHandler, "Parameter linkHandler cannot be null for BrowserPresenter::new");
        this.clipboardManager = (ClipboardManager) Objects.requireNonNull(clipboardManager, "Parameter clipboardManager cannot be null for BrowserPresenter::new");
        browserModel.setBrowserModelCallback(anonymousClass1);
    }

    public void initWithView(BrowserView browserView, WebView webView) {
        this.browserView = (BrowserView) Objects.requireNonNull(browserView, "Parameter browserView cannot be null for BrowserPresenter::initWithView");
        Objects.requireNonNull(webView, "Parameter webView cannot be null for BrowserPresenter::initWithView");
        this.browserModel.setWebView(webView);
    }

    public void onStart() {
        this.browserModel.start();
    }

    public void onResume() {
        this.browserModel.resume();
    }

    public void onPause() {
        this.browserModel.pause();
    }

    public void onStop() {
        this.browserModel.stop();
    }

    public void dropView() {
        this.browserView = null;
    }

    public void loadUrl(String str) {
        this.browserModel.load(str);
    }

    public void onReloadClicked() {
        this.browserModel.reload();
    }

    public void onPageNavigationBackClicked() {
        this.browserModel.goBack();
    }

    public void onPageNavigationForwardClicked() {
        this.browserModel.goForward();
    }

    public void onOpenExternalBrowserClicked() {
        String currentUrl;
        if (this.browserView == null || (currentUrl = this.browserModel.getCurrentUrl()) == null) {
            return;
        }
        this.linkHandler.m5551x29a88085(currentUrl, null, null);
        this.browserView.closeBrowser();
    }

    public void onCopyHostnameClicked() {
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText(null, this.browserModel.getCurrentUrl()));
        this.logger.debug(LogDomain.BROWSER, "Link copied", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHostnameAndSchemeControls(String str) {
        if (this.browserView == null) {
            return;
        }
        this.browserView.showHostname(this.urlCreator.extractHostname(str));
        this.browserView.showConnectionSecure(this.urlCreator.isSecureScheme(this.urlCreator.extractScheme(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationUiControls(boolean z, boolean z2) {
        BrowserView browserView = this.browserView;
        if (browserView == null) {
            return;
        }
        browserView.setPageNavigationBackEnabled(z);
        this.browserView.setPageNavigationForwardEnabled(z2);
    }
}
