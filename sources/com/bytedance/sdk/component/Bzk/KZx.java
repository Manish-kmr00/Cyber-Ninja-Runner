package com.bytedance.sdk.component.Bzk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.WV;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class KZx extends WebView {
    private pA JG;
    private boolean KZx;
    private boolean ML;
    private final HashSet<String> Og;
    private boolean ZZv;
    public long pA;

    @SuppressLint({"AddJavascriptInterface", "JavascriptInterface"})
    private void safedk_webview_KZx_onAddedJavascriptInterface_d5cc8fe3a6f29e536613b996bf4ad6eb(Object p1, String p2) {
        Logger.d("PangleNetwork|SafeDK: Partial-Network> Lcom/bytedance/sdk/component/Bzk/KZx;->safedk_webview_KZx_onAddedJavascriptInterface_d5cc8fe3a6f29e536613b996bf4ad6eb(Ljava/lang/Object;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "onAddedJavascriptInterface invoked, WebView address: " + this + ", SDK_PACKAGE_NAME: " + h.u + " object is: " + p1 + " and name: " + p2);
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.u);
        if (adNetworkDiscoveryI != null) {
            adNetworkDiscoveryI.a((WebView) this, p1);
        }
        super.addJavascriptInterface(p1, p2);
    }

    private void safedk_webview_KZx_webviewLoadDataWithBaseURL_558df8468e7a3606a3ca6ea19e01a100(String p1, String p2, String p3, String p4, String p5) {
        Logger.d("PangleNetwork|SafeDK: Partial-Network> Lcom/bytedance/sdk/component/Bzk/KZx;->safedk_webview_KZx_webviewLoadDataWithBaseURL_558df8468e7a3606a3ca6ea19e01a100(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            Logger.d("SafeDKNetwork", "webviewLoadDataWithBaseURL: " + p1 + ", WebView address : " + toString() + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = " + h.u);
            CreativeInfoManager.a(p1, p2, this, h.u);
            SafeDKWebAppInterface.a(h.u, (WebView) this, p2, true);
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.u);
        if (adNetworkDiscoveryI != null) {
            p2 = adNetworkDiscoveryI.a(this, p1, p2);
        }
        super.loadDataWithBaseURL(p1, p2, p3, p4, p5);
    }

    private void safedk_webview_KZx_webviewLoadUrl_9734b466488e157cba9b069557de2b55(String p1, Map p2) {
        Logger.d("PangleNetwork|SafeDK: Partial-Network> Lcom/bytedance/sdk/component/Bzk/KZx;->safedk_webview_KZx_webviewLoadUrl_9734b466488e157cba9b069557de2b55(Ljava/lang/String;Ljava/util/Map;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl. url: " + p1 + ", WebView address : " + toString() + "  SDK_PACKAGE_NAME = " + h.u);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(p1) || p1.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl loadUrl url is null or a javascript command : " + p1);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.u, this, p1);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.u);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(p1, (String) null, this, h.u);
                }
                SafeDKWebAppInterface.a(h.u, (WebView) this, p1, true);
            }
        }
        super.loadUrl(p1, p2);
    }

    private void safedk_webview_KZx_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(String p1) {
        Logger.d("PangleNetwork|SafeDK: Partial-Network> Lcom/bytedance/sdk/component/Bzk/KZx;->safedk_webview_KZx_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + p1 + ", WebView address : " + toString() + "  SDK_PACKAGE_NAME = " + h.u);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(p1) || p1.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + p1);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.u, this, p1);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.u);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(p1, (String) null, this, h.u);
                }
                SafeDKWebAppInterface.a(h.u, (WebView) this, p1, true);
            }
        }
        super.loadUrl(p1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public KZx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Og = new HashSet<>();
        this.pA = System.currentTimeMillis();
        pA();
    }

    public KZx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Og = new HashSet<>();
        this.pA = System.currentTimeMillis();
        pA();
    }

    public void setArbitrageTouchListener(pA pAVar) {
        this.JG = pAVar;
    }

    private void pA() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new ZZv.pA());
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        new StringBuilder("addJavascriptInterface: ").append(str).append(", ").append(this);
        if (!this.KZx && !this.ML) {
            safedk_webview_KZx_onAddedJavascriptInterface_d5cc8fe3a6f29e536613b996bf4ad6eb(obj, str);
            this.Og.add(str);
        } else {
            WV.pA("TTAD.PangleWebView", "addJavascriptInterface: has destroyed or has recycler");
        }
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (this.KZx || this.ML) {
            return;
        }
        super.removeJavascriptInterface(str);
        this.Og.remove(str);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (!this.KZx && !this.ML) {
            try {
                super.onPause();
                return;
            } catch (Exception e) {
                WV.pA("TTAD.PangleWebView", "onPause: ", e);
                return;
            }
        }
        WV.pA("TTAD.PangleWebView", "onPause: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (!this.KZx && !this.ML) {
            try {
                super.onResume();
                return;
            } catch (Exception e) {
                WV.pA("TTAD.PangleWebView", "onResume: ", e);
                return;
            }
        }
        WV.pA("TTAD.PangleWebView", "onResume: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (!this.KZx && !this.ML) {
            try {
                super.stopLoading();
                return;
            } catch (Exception e) {
                WV.pA("TTAD.PangleWebView", "stopLoading: ", e);
                return;
            }
        }
        WV.pA("TTAD.PangleWebView", "stopLoading: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (!this.KZx && !this.ML) {
            super.reload();
        } else {
            WV.pA("TTAD.PangleWebView", "reload: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (!this.KZx && !this.ML) {
            super.goBack();
        } else {
            WV.pA("TTAD.PangleWebView", "goBack: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (!this.KZx && !this.ML) {
            super.goForward();
        } else {
            WV.pA("TTAD.PangleWebView", "goForward: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i) {
        if (!this.KZx && !this.ML) {
            super.goBackOrForward(i);
        } else {
            WV.pA("TTAD.PangleWebView", "goBackOrForward: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        if (!this.KZx && !this.ML) {
            super.clearCache(z);
        } else {
            WV.pA("TTAD.PangleWebView", "clearCache: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!this.KZx && !this.ML) {
            try {
                safedk_webview_KZx_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                WV.pA("TTAD.PangleWebView", "loadUrl: ", e);
                return;
            }
        }
        WV.pA("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.KZx && !this.ML) {
            try {
                safedk_webview_KZx_webviewLoadUrl_9734b466488e157cba9b069557de2b55(str, map);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                WV.pA("TTAD.PangleWebView", "loadUrl: ", e);
                return;
            }
        }
        WV.pA("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.KZx || this.ML) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.KZx && !this.ML) {
            safedk_webview_KZx_webviewLoadDataWithBaseURL_558df8468e7a3606a3ca6ea19e01a100(str, str2, str3, str4, str5);
        } else {
            WV.pA("TTAD.PangleWebView", "loadDataWithBaseURL: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.KZx && !this.ML) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            WV.pA("TTAD.PangleWebView", "evaluateJavascript: has destroyed or recycler, ".concat(String.valueOf(str)));
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        new StringBuilder("onAttachedToWindow: ").append(this);
    }

    public void setDestroyOnDetached(boolean z) {
        this.ZZv = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        new StringBuilder("onDetachedFromWindow: ").append(this);
        if (this.ZZv) {
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        if (this.KZx || this.ML) {
            return;
        }
        super.resumeTimers();
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        if (this.KZx || this.ML) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.KZx || this.ML) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        new StringBuilder("destroy() called, ").append(this);
        if (this.KZx) {
            return;
        }
        this.KZx = true;
        Og();
        super.destroy();
    }

    private void Og() {
        if (this.KZx) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.Og.iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface(it.next());
        }
    }

    public void setRecycler(boolean z) {
        this.ML = z;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        pA pAVar = this.JG;
        if (pAVar == null) {
            super.setOnTouchListener(onTouchListener);
        } else {
            pAVar.pA(onTouchListener);
            super.setOnTouchListener(this.JG);
        }
    }
}
