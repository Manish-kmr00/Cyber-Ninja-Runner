package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5232a;
    private int b;
    protected ToolBar c;
    protected ToolBar d;
    protected ProgressBar e;
    private RelativeLayout f;
    private View.OnClickListener g;
    private com.mbridge.msdk.mbsignalcommon.commonwebview.b h;
    private com.mbridge.msdk.mbsignalcommon.commonwebview.a i;
    protected BaseWebView j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private View.OnClickListener n;
    private Handler o;
    private int p;
    private WebViewClient q;
    private String r;
    private i s;
    private boolean t;
    private final Runnable u;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.p + "ms");
            if (CommonWebView.this.s != null) {
                CommonWebView.this.t = false;
                CommonWebView.this.s.a(CommonWebView.this.r);
            }
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$b;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, webView, str);
            safedk_CommonWebView$b_onPageStarted_47c4ccca086f652fd0967ba39821c0ed(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    if (webView instanceof WindVaneWebView) {
                        ((WindVaneWebView) webView).release();
                    } else {
                        webView.destroy();
                    }
                } catch (Throwable th) {
                    o0.b("CommonWebView", th.getMessage());
                }
            }
            return true;
        }

        public void safedk_CommonWebView$b_onPageStarted_47c4ccca086f652fd0967ba39821c0ed(WebView p0, String p1, Bitmap p2) {
            o0.c("CommonWebView", "newProgress! 开始! = " + p1);
            CommonWebView.this.e.setVisible(true);
            CommonWebView.this.e.setProgressState(5);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }
    }

    class c extends WebChromeClient {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommonWebView.this.e.setVisible(false);
            }
        }

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            o0.c("CommonWebView", "newProgress! = " + i);
            if (i == 100) {
                CommonWebView.this.e.setProgressState(7);
                new Handler().postDelayed(new a(), 200L);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseWebView baseWebView = CommonWebView.this.j;
            if (baseWebView != null) {
                baseWebView.stopLoading();
                String str = (String) view.getTag();
                if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(true);
                    if (CommonWebView.this.j.canGoBack()) {
                        CommonWebView.this.j.goBack();
                    }
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.j.canGoBack());
                    if (CommonWebView.this.k != null) {
                        CommonWebView.this.k.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.FORWARD)) {
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(true);
                    if (CommonWebView.this.j.canGoForward()) {
                        CommonWebView.this.j.goForward();
                    }
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.j.canGoForward());
                    if (CommonWebView.this.l != null) {
                        CommonWebView.this.l.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.REFRESH)) {
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.j.canGoBack());
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.j.canGoForward());
                    CommonWebView.this.j.reload();
                    if (CommonWebView.this.m != null) {
                        CommonWebView.this.m.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.EXITS)) {
                    if (CommonWebView.this.g != null) {
                        CommonWebView.this.g.onClick(view);
                    }
                } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                    if (CommonWebView.this.n != null) {
                        CommonWebView.this.n.onClick(view);
                    }
                    com.mbridge.msdk.click.c.c(CommonWebView.this.getContext(), CommonWebView.this.j.getUrl());
                }
            }
        }
    }

    class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, view, errorCode, description, failingUrl);
        }

        public boolean safedk_CommonWebView$e_shouldOverrideUrlLoading_c8af97742a2adb21698558eb32e0e266(WebView p0, String p1) {
            CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(true);
            CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(false);
            return false;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$e;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_CommonWebView$e_shouldOverrideUrlLoading_c8af97742a2adb21698558eb32e0e266 = safedk_CommonWebView$e_shouldOverrideUrlLoading_c8af97742a2adb21698558eb32e0e266(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, webView, str, zSafedk_CommonWebView$e_shouldOverrideUrlLoading_c8af97742a2adb21698558eb32e0e266);
            return zSafedk_CommonWebView$e_shouldOverrideUrlLoading_c8af97742a2adb21698558eb32e0e266;
        }
    }

    class f extends WebViewClient {
        f() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, view, errorCode, description, failingUrl);
        }

        public boolean safedk_CommonWebView$f_shouldOverrideUrlLoading_e22e3dde4870eea386a2fe1c3e296548(WebView p0, String p1) {
            if (s0.a.b(p1)) {
                s0.a.a(CommonWebView.this.getContext(), p1, null);
            }
            return CommonWebView.this.a(p0, p1);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$f;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_CommonWebView$f_shouldOverrideUrlLoading_e22e3dde4870eea386a2fe1c3e296548 = safedk_CommonWebView$f_shouldOverrideUrlLoading_e22e3dde4870eea386a2fe1c3e296548(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, webView, str, zSafedk_CommonWebView$f_shouldOverrideUrlLoading_e22e3dde4870eea386a2fe1c3e296548);
            return zSafedk_CommonWebView$f_shouldOverrideUrlLoading_e22e3dde4870eea386a2fe1c3e296548;
        }
    }

    class g extends WebViewClient {
        g() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$g;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, webView, str);
            safedk_CommonWebView$g_onPageFinished_5e1dde7865f8c88d4c576c22f58d79e4(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$g;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, webView, str);
            safedk_CommonWebView$g_onPageStarted_f002285ad44b41c85a222e8c7f178720(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$g;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, webView, i, str, str2);
            safedk_CommonWebView$g_onReceivedError_973c7118cfec8605bdb8bcdafdfa195e(webView, i, str, str2);
        }

        public void safedk_CommonWebView$g_onPageFinished_5e1dde7865f8c88d4c576c22f58d79e4(WebView p0, String p1) {
            CommonWebView.this.t = false;
            CommonWebView.this.a();
        }

        public void safedk_CommonWebView$g_onPageStarted_f002285ad44b41c85a222e8c7f178720(WebView p0, String p1, Bitmap p2) {
            CommonWebView.this.r = p1;
            if (CommonWebView.this.t) {
                return;
            }
            CommonWebView.this.t = true;
            CommonWebView.this.c();
        }

        public void safedk_CommonWebView$g_onReceivedError_973c7118cfec8605bdb8bcdafdfa195e(WebView p0, int p1, String p2, String p3) {
            CommonWebView.this.t = false;
            CommonWebView.this.a();
        }

        public boolean safedk_CommonWebView$g_shouldOverrideUrlLoading_9914e364f799338377518c1a04af695c(WebView p0, String p1) {
            CommonWebView.this.r = p1;
            if (CommonWebView.this.t) {
                CommonWebView.this.a();
            }
            CommonWebView.this.t = true;
            CommonWebView.this.c();
            return false;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/commonwebview/CommonWebView$g;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_CommonWebView$g_shouldOverrideUrlLoading_9914e364f799338377518c1a04af695c = safedk_CommonWebView$g_shouldOverrideUrlLoading_9914e364f799338377518c1a04af695c(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, webView, str, zSafedk_CommonWebView$g_shouldOverrideUrlLoading_9914e364f799338377518c1a04af695c);
            return zSafedk_CommonWebView$g_shouldOverrideUrlLoading_9914e364f799338377518c1a04af695c;
        }
    }

    public interface h {
        void a();
    }

    public interface i {
        void a(String str);
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new a();
        init();
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.o);
        p0.startActivity(p1);
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.i.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.h.a(webViewClient);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    public View findToolBarButton(String str) {
        ToolBar toolBar;
        ToolBar toolBar2 = this.c;
        View item = toolBar2 != null ? toolBar2.getItem(str) : null;
        return (item != null || (toolBar = this.d) == null) ? item : toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.j;
        return baseWebView == null ? "" : baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.j;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.c;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.d;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.c.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f, layoutParams);
        this.f5232a = t0.a(getContext(), 40.0f);
        this.b = t0.a(getContext(), 40.0f);
        this.h = new com.mbridge.msdk.mbsignalcommon.commonwebview.b();
        this.i = new com.mbridge.msdk.mbsignalcommon.commonwebview.a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.j == null) {
                this.j = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.j.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.j;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.h);
            MintegralNetworkBridge.webviewSetWebChromeClient(this.j, this.i);
            addWebViewClient(bVar);
        } catch (Throwable th) {
            o0.b("CommonWebView", "webview is error", th);
        }
        this.f.addView(this.j);
    }

    public void loadUrl(String str) {
        MintegralNetworkBridge.webviewLoadUrl(this.j, str);
        if (this.q != null) {
            c();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.i.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.h.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.c.getParent()).removeView(this.c);
        this.f.addView(this.c);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.c.getParent()).removeView(this.c);
        addView(this.c, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void setPageLoadTimtout(int i2) {
        this.p = i2;
        if (this.o == null) {
            this.o = new Handler(Looper.getMainLooper());
        }
        if (this.q == null) {
            g gVar = new g();
            this.q = gVar;
            addWebViewClient(gVar);
        }
    }

    public void setPageLoadTimtoutListener(i iVar) {
        this.s = iVar;
    }

    public void setToolBarTitle(String str, int i2) {
        this.c.setTitle(str, i2);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.c;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.d;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.c.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z) {
        a(arrayList, z);
    }

    public void useDeeplink() {
        addWebViewClient(new f());
    }

    public void useDefaultToolBar() {
        b();
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new b());
        addWebChromeClient(new c());
        addView(this.e);
        this.e.initResource(true);
    }

    private void b() {
        if (this.d != null) {
            return;
        }
        this.d = new ToolBar(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.b);
        layoutParams.bottomMargin = 0;
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1);
        this.d.setOnItemClickListener(new d());
        addWebViewClient(new e());
        addView(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.o.postDelayed(this.u, this.p);
    }

    public void setToolBarTitle(String str) {
        this.c.setTitle(str);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z) {
        if (this.c != null) {
            return;
        }
        ToolBar.a aVar = new ToolBar.a();
        aVar.a(40);
        aVar.b(80);
        ToolBar toolBar = new ToolBar(getContext(), aVar, arrayList);
        this.c = toolBar;
        toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
        if (z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f5232a);
            layoutParams.addRule(10);
            this.c.setLayoutParams(layoutParams);
            this.f.addView(this.c);
            return;
        }
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f5232a));
        addView(this.c, 0);
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri uri = Uri.parse(str);
            if (!uri.getScheme().equals("http") && !uri.getScheme().equals("https")) {
                if (uri.getScheme().equals(SDKConstants.PARAM_INTENT)) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    try {
                        String str2 = uri2.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            uri2.setComponent(null);
                            uri2.setSelector(null);
                            uri2.setFlags(268435456);
                            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(getContext(), uri2);
                            return true;
                        }
                        try {
                            String stringExtra = uri2.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri uri3 = Uri.parse(str);
                                if (!uri3.getScheme().equals("http") && !uri3.getScheme().equals("https")) {
                                    str = stringExtra;
                                }
                                MintegralNetworkBridge.webviewLoadUrl(webView, stringExtra);
                                return false;
                            }
                        } catch (Throwable th) {
                            o0.b("CommonWebView", th.getMessage());
                        }
                    } catch (Throwable th2) {
                        o0.b("CommonWebView", th2.getMessage());
                    }
                    o0.b("CommonWebView", th.getMessage());
                    return false;
                }
                if (com.mbridge.msdk.click.c.d(getContext(), str)) {
                    o0.b("CommonWebView", "openDeepLink");
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith("http") || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th3) {
            o0.b("CommonWebView", th3.getMessage());
            return false;
        }
    }

    public CommonWebView(Context context) {
        super(context);
        this.u = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.o.removeCallbacks(this.u);
    }
}
