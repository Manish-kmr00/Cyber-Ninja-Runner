package com.smaato.sdk.video.vast.widget.element;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda4;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StubOnGestureListener;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.BaseWebView;
import com.smaato.sdk.core.webview.BaseWebViewClient;
import com.smaato.sdk.core.webview.WebViewClientCallbackAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class VastElementView extends BaseWebView {
    private Runnable clickTask;
    private final Handler delayHandler;
    private boolean isLoaded;
    private Runnable onViewVisible;
    private VastElementPresenter presenter;
    private boolean webViewClicked;
    private final BaseWebViewClient webViewClient;
    private final BaseWebViewClient.WebViewClientCallback webViewClientCallback;

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

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.widget.element.VastElementView$1, reason: invalid class name */
    class AnonymousClass1 extends WebViewClientCallbackAdapter {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public boolean shouldOverrideUrlLoading(String str) {
            if (!VastElementView.this.webViewClicked) {
                return VastElementView.this.presenter == null || !VastElementView.this.presenter.isValidUrl(str);
            }
            if (VastElementView.this.clickTask != null) {
                VastElementView.this.delayHandler.removeCallbacks(VastElementView.this.clickTask);
                VastElementView.this.clickTask = null;
            }
            VastElementView.this.onWebViewClicked(str);
            VastElementView.this.webViewClicked = false;
            return true;
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onPageFinishedLoading(String str) {
            VastElementView.this.onContentLoaded();
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            VastElementView.this.onContentLoadingError(String.format("VastElementView WebViewClientHTTP HTTP Error. Request: %s; Error Response: %s", webResourceRequest, webResourceResponse));
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onGeneralError(int i, String str, String str2) {
            final String str3 = String.format("VastElementView WebViewClientHTTP General Error. code: %s; description: %s; url: %s", Integer.valueOf(i), str, str2);
            if (i == -1) {
                Objects.onNotNull(VastElementView.this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$1$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((VastElementPresenter) obj).logError(new VastElementLoadingException(str3));
                    }
                });
            } else {
                VastElementView.this.onContentLoadingError(str3);
            }
        }

        @Override // com.smaato.sdk.core.webview.WebViewClientCallbackAdapter, com.smaato.sdk.core.webview.BaseWebViewClient.WebViewClientCallback
        public void onRenderProcessGone() {
            Objects.onNotNull(VastElementView.this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((VastElementPresenter) obj).onRenderProcessGone();
                }
            });
        }
    }

    public VastElementView(Context context) {
        super(context);
        this.delayHandler = Threads.newUiHandler();
        this.webViewClient = new BaseWebViewClient();
        this.webViewClicked = false;
        this.isLoaded = false;
        this.webViewClientCallback = new AnonymousClass1();
        init();
    }

    public VastElementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.delayHandler = Threads.newUiHandler();
        this.webViewClient = new BaseWebViewClient();
        this.webViewClicked = false;
        this.isLoaded = false;
        this.webViewClientCallback = new AnonymousClass1();
        init();
    }

    private void init() {
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        this.webViewClient.setWebViewClientCallback(this.webViewClientCallback);
        setWebViewClient(this.webViewClient);
        setBackgroundColor(0);
        initClickDetector();
    }

    private void initClickDetector() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new StubOnGestureListener() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView.2
            @Override // com.smaato.sdk.core.util.StubOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                VastElementView.this.webViewClicked = true;
                VastElementView.this.clickWithDelay();
                return true;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return VastElementView.lambda$initClickDetector$0(gestureDetector, view, motionEvent);
            }
        });
    }

    static /* synthetic */ boolean lambda$initClickDetector$0(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5768x980afc17((VastElementPresenter) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAttachedToWindow$1$com-smaato-sdk-video-vast-widget-element-VastElementView, reason: not valid java name */
    /* synthetic */ void m5768x980afc17(VastElementPresenter vastElementPresenter) {
        vastElementPresenter.attachView(this);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).onConfigurationChanged();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).detachView();
            }
        });
        this.isLoaded = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (getVisibility() == 0) {
            Objects.onNotNull(this.onViewVisible, new LinkHandler$$ExternalSyntheticLambda4());
            this.onViewVisible = null;
        }
    }

    public void setSize(final int i, final int i2) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5769x321a0abb(i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setSize$2$com-smaato-sdk-video-vast-widget-element-VastElementView, reason: not valid java name */
    /* synthetic */ void m5769x321a0abb(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public void setOnViewVisible(Runnable runnable) {
        if (getVisibility() == 0) {
            Objects.onNotNull(runnable, new LinkHandler$$ExternalSyntheticLambda4());
        } else {
            this.onViewVisible = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickWithDelay() {
        if (this.clickTask != null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5766xe9afa7ce();
            }
        };
        this.clickTask = runnable;
        this.delayHandler.postDelayed(runnable, 100L);
    }

    /* JADX INFO: renamed from: lambda$clickWithDelay$3$com-smaato-sdk-video-vast-widget-element-VastElementView, reason: not valid java name */
    /* synthetic */ void m5766xe9afa7ce() {
        onWebViewClicked(null);
        this.clickTask = null;
    }

    public void setPresenter(VastElementPresenter vastElementPresenter) {
        this.presenter = vastElementPresenter;
    }

    public void load(final String str) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5767x46b9cedc(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$4$com-smaato-sdk-video-vast-widget-element-VastElementView, reason: not valid java name */
    /* synthetic */ void m5767x46b9cedc(String str) {
        if (this.isLoaded) {
            return;
        }
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).onContentStartedToLoad();
            }
        });
        loadHtml(str);
    }

    protected void onWebViewClicked(final String str) {
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).onClicked(str);
            }
        });
    }

    protected void onContentLoaded() {
        if (this.isLoaded) {
            return;
        }
        this.isLoaded = true;
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).onContentLoaded();
            }
        });
    }

    protected void onContentLoadingError(final String str) {
        Objects.onNotNull(this.presenter, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.element.VastElementView$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VastElementPresenter) obj).onError(new VastElementLoadingException(str));
            }
        });
    }

    private void disableScrollingAndZoom() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }
}
