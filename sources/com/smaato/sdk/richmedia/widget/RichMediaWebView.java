package com.smaato.sdk.richmedia.widget;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StubOnGestureListener;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.BaseWebView;
import com.smaato.sdk.core.webview.BaseWebViewClient;
import com.smaato.sdk.core.webview.WebViewHelperUtil;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import com.smaato.sdk.richmedia.util.RichMediaHtmlUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class RichMediaWebView extends BaseWebView {
    private Callback callback;
    private boolean clicked;
    private boolean destroyed;
    private final RichMediaHtmlUtils htmlUtils;
    private boolean isExpandedWebView;
    private boolean loadingStarted;
    private final Logger logger;

    public interface Callback {
        void handleMraidUrl(String str, boolean z);

        void onAdViolation(String str, String str2);

        void onError();

        void onRenderProcessGone();

        void onUrlClicked(String str);

        void onWebViewLoaded();
    }

    @Override // com.smaato.sdk.core.webview.BaseWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.core.webview.BaseWebView, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public RichMediaWebView(Context context, Logger logger, RichMediaHtmlUtils richMediaHtmlUtils) {
        super((Context) Objects.requireNonNull(context));
        this.destroyed = false;
        this.clicked = false;
        this.loadingStarted = false;
        this.isExpandedWebView = false;
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.htmlUtils = (RichMediaHtmlUtils) Objects.requireNonNull(richMediaHtmlUtils);
        initWebView();
    }

    public RichMediaWebView(Context context, Logger logger, RichMediaHtmlUtils richMediaHtmlUtils, boolean z) {
        super((Context) Objects.requireNonNull(context));
        this.destroyed = false;
        this.clicked = false;
        this.loadingStarted = false;
        this.isExpandedWebView = false;
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.htmlUtils = (RichMediaHtmlUtils) Objects.requireNonNull(richMediaHtmlUtils);
        this.isExpandedWebView = z;
        initWebView();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void loadData(String str, MraidEnvironmentProperties mraidEnvironmentProperties) {
        Threads.ensureMainThread();
        if (this.loadingStarted) {
            return;
        }
        this.loadingStarted = true;
        initClickDetector();
        loadHtml(this.htmlUtils.createHtml(str, getContext(), mraidEnvironmentProperties));
    }

    public void loadUrlContent(String str) {
        Threads.ensureMainThread();
        if (this.loadingStarted) {
            return;
        }
        this.loadingStarted = true;
        initClickDetector();
        SmaatoNetworkBridge.webviewLoadUrl(this, str);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Threads.ensureMainThread();
        if (this.destroyed) {
            this.logger.debug(LogDomain.WIDGET, "release() has been already called, ignoring this call", new Object[0]);
        } else {
            this.destroyed = true;
            WebViewHelperUtil.resetAndDestroyWebViewSafely(this);
        }
    }

    public void resetClickedFlag() {
        this.clicked = false;
    }

    private void initWebView() {
        hideScrollbar();
        setVisibility(4);
        setBackgroundColor(getResources().getColor(R.color.transparent));
        WebSettings settings = getSettings();
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(false);
        BaseWebViewClient baseWebViewClient = new BaseWebViewClient();
        baseWebViewClient.setWebViewClientCallback(createWebViewClientCallback());
        setWebViewClient(baseWebViewClient);
        setWebChromeClient(createWebChromeClient());
    }

    private void initClickDetector() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new StubOnGestureListener() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView.1
            @Override // com.smaato.sdk.core.util.StubOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                RichMediaWebView.this.clicked = true;
                return true;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return RichMediaWebView.lambda$initClickDetector$0(gestureDetector, view, motionEvent);
            }
        });
    }

    static /* synthetic */ boolean lambda$initClickDetector$0(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    private void hideScrollbar() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.widget.RichMediaWebView$2, reason: invalid class name */
    class AnonymousClass2 implements BaseWebViewClient.WebViewClientCallback {
        AnonymousClass2() {
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public boolean shouldOverrideUrlLoading(final String str) {
            Logger logger = RichMediaWebView.this.logger;
            LogDomain logDomain = LogDomain.WIDGET;
            logger.debug(logDomain, "shouldOverrideUrlLoading: %s", str);
            if (str.startsWith("smaato://")) {
                Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$2$$ExternalSyntheticLambda3
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5704xfe6847b3(str, (RichMediaWebView.Callback) obj);
                    }
                });
                return true;
            }
            if (str.startsWith("mraid://")) {
                return true;
            }
            if (!RichMediaWebView.this.isExpandedWebView || RichMediaWebView.this.clicked) {
                if (RichMediaWebView.this.clicked) {
                    RichMediaWebView.this.clicked = false;
                    RichMediaWebView.this.logger.debug(logDomain, "shouldOverrideUrlLoading: going to call Callback::onUrlClicked() with %s", str);
                    Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$2$$ExternalSyntheticLambda4
                        @Override // com.smaato.sdk.core.util.fi.Consumer
                        public final void accept(Object obj) {
                            ((RichMediaWebView.Callback) obj).onUrlClicked(str);
                        }
                    });
                    return true;
                }
                Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$2$$ExternalSyntheticLambda5
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((RichMediaWebView.Callback) obj).onAdViolation("AUTO_REDIRECT", str);
                    }
                });
                return true;
            }
            SmaatoNetworkBridge.webviewLoadUrl(RichMediaWebView.this, str);
            return true;
        }

        /* JADX INFO: renamed from: lambda$shouldOverrideUrlLoading$0$com-smaato-sdk-richmedia-widget-RichMediaWebView$2, reason: not valid java name */
        /* synthetic */ void m5704xfe6847b3(String str, Callback callback) {
            callback.handleMraidUrl(str, RichMediaWebView.this.clicked);
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onPageStartedLoading(String str) {
            RichMediaWebView.this.logger.debug(LogDomain.WIDGET, "onPageStartedLoading: %s", str);
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onPageFinishedLoading(String str) {
            RichMediaWebView.this.logger.debug(LogDomain.WIDGET, "onPageFinishedLoading: %s", str);
            RichMediaWebView.this.setVisibility(0);
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$2$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onWebViewLoaded();
                }
            });
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            RichMediaWebView.this.logger.debug(LogDomain.WIDGET, "onHttpError: request = %s, errorResponse = %s", webResourceRequest, webResourceResponse);
            Objects.onNotNull(RichMediaWebView.this.callback, new RichMediaWebView$2$$ExternalSyntheticLambda1());
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onGeneralError(int i, String str, String str2) {
            RichMediaWebView.this.logger.debug(LogDomain.WIDGET, "onGeneralError: errorCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
            Objects.onNotNull(RichMediaWebView.this.callback, new RichMediaWebView$2$$ExternalSyntheticLambda1());
        }

        @Override // com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onRenderProcessGone() {
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$2$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onRenderProcessGone();
                }
            });
        }
    }

    private BaseWebViewClient.WebViewClientCallback createWebViewClientCallback() {
        return new AnonymousClass2();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.widget.RichMediaWebView$3, reason: invalid class name */
    class AnonymousClass3 extends WebChromeClient {
        AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$3$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onAdViolation("JS_ALERT_DIALOG", "");
                }
            });
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$3$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onAdViolation("JS_CONFIRM_DIALOG", "");
                }
            });
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$3$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onAdViolation("JS_PROMPT_DIALOG", "");
                }
            });
            jsPromptResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            Objects.onNotNull(RichMediaWebView.this.callback, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.RichMediaWebView$3$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((RichMediaWebView.Callback) obj).onAdViolation("JS_ON_BEFORE_UNLOAD_DIALOG", "");
                }
            });
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return !RichMediaWebView.this.htmlUtils.isLoggingEnabled() || super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            return defaultVideoPoster != null ? defaultVideoPoster : Bitmap.createBitmap(64, 64, Bitmap.Config.ARGB_8888);
        }
    }

    private WebChromeClient createWebChromeClient() {
        return new AnonymousClass3();
    }
}
