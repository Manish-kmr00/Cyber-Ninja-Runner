package com.bytedance.sdk.component.Bzk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.vZF;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;
import com.vungle.ads.internal.model.AdPayload;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ZZv extends FrameLayout {
    private static KZx roi;
    private Context BF;
    private volatile WebView BSW;
    private long Bzk;
    private List<String> DX;
    private long IG;
    private float JG;
    private JSONObject KZx;
    private float ML;
    private long Mc;
    private String Og;
    private long SD;
    private boolean SGo;
    private vZF Sd;
    private com.bytedance.sdk.component.Bzk.pA Sn;
    private AtomicBoolean TV;
    private AttributeSet TX;
    private AtomicBoolean WQf;
    private View WV;
    private com.bytedance.sdk.component.Bzk.pA.InterfaceC0186pA Wx;
    private float XT;
    private boolean ZZv;
    private float aBv;
    private AtomicBoolean du;
    private InterfaceC0185ZZv eG;
    private float oX;
    private long omh;
    private com.bytedance.sdk.component.Bzk.Og.pA pA;
    private Og vZF;
    private int yFO;

    public interface KZx {
        WebView createWebView(Context context, AttributeSet attributeSet, int i);
    }

    public interface Og {
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Bzk.ZZv$ZZv, reason: collision with other inner class name */
    public interface InterfaceC0185ZZv {
    }

    private static void KZx(Context context) {
    }

    private static Context pA(Context context) {
        return context;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ZZv;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z");
        DetectTouchUtils.viewOnTouch(h.u, this, motionEvent);
        return safedk_ZZv_dispatchTouchEvent_2e07174988d3d7ac5d0450e2630ba58b(motionEvent);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public com.bytedance.sdk.component.Bzk.Og.pA getMaterialMeta() {
        return this.pA;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.Bzk.Og.pA pAVar) {
        this.pA = pAVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.Og;
    }

    public void setTag(String str) {
        this.Og = str;
        com.bytedance.sdk.component.Bzk.pA pAVar = this.Sn;
        if (pAVar != null) {
            pAVar.pA(str);
        }
    }

    public void setLandingPage(boolean z) {
        this.ZZv = z;
    }

    public void setTouchStateListener(InterfaceC0185ZZv interfaceC0185ZZv) {
        this.eG = interfaceC0185ZZv;
    }

    public ZZv(Context context) {
        this(pA(context), false);
    }

    public ZZv(Context context, boolean z) {
        super(pA(context));
        this.ML = 0.0f;
        this.JG = 0.0f;
        this.SD = 0L;
        this.omh = 0L;
        this.Bzk = 0L;
        this.SGo = false;
        this.oX = 20.0f;
        this.XT = 50.0f;
        this.WQf = new AtomicBoolean();
        this.TV = new AtomicBoolean();
        this.du = new AtomicBoolean();
        this.BF = context;
        if (z) {
            return;
        }
        try {
            this.BSW = pA((AttributeSet) null, 0);
            Og();
        } catch (Throwable unused) {
        }
        Og(pA(context));
    }

    public void pA(boolean z, int i, int i2, List<Integer> list, int i3, List<String> list2) {
        if (z && this.BSW != null && (this.BSW instanceof com.bytedance.sdk.component.Bzk.KZx)) {
            this.Sn = new com.bytedance.sdk.component.Bzk.pA(this.BF, i, i2, list, i3);
            this.DX = list2;
            if (!TextUtils.isEmpty(this.Og)) {
                this.Sn.pA(this.Og);
            }
            ((com.bytedance.sdk.component.Bzk.KZx) this.BSW).setArbitrageTouchListener(this.Sn);
            this.Wx = this.Sn.pA();
        }
    }

    public void pA(boolean z, View view) {
        if (z) {
            this.WV = view;
            if (view == null || view.getParent() != null) {
                return;
            }
            addView(this.WV, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public View getArbitrageLoadingView() {
        return this.WV;
    }

    public void f_() {
        try {
            this.BSW = pA(this.TX, 0);
            Og();
            Og(pA(this.BF));
        } catch (Throwable th) {
            WV.pA("SSWebView.TAG", "initWebview: " + th.getMessage());
        }
    }

    public static void setWebViewProvider(KZx kZx) {
        roi = kZx;
    }

    private WebView pA(AttributeSet attributeSet, int i) {
        KZx kZx = roi;
        if (kZx != null) {
            return kZx.createWebView(getContext(), attributeSet, i);
        }
        if (attributeSet == null) {
            return new WebView(pA(this.BF));
        }
        return new WebView(pA(this.BF), attributeSet);
    }

    public void setRecycler(boolean z) {
        if (this.BSW == null || !(this.BSW instanceof com.bytedance.sdk.component.Bzk.KZx)) {
            return;
        }
        ((com.bytedance.sdk.component.Bzk.KZx) this.BSW).setRecycler(z);
    }

    public void Og() {
        if (this.BSW != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.BSW.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.BSW, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void Og(Context context) {
        KZx(context);
        oX();
        DX();
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.BSW.setNetworkAvailable(z);
        } catch (Throwable unused) {
        }
    }

    public void pA(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            PangleNetworkBridge.webviewLoadUrl(this.BSW, str, map);
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            PangleNetworkBridge.webviewLoadUrl(this.BSW, str);
        } catch (Throwable unused) {
        }
    }

    public void pA(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            PangleNetworkBridge.webviewLoadDataWithBaseURL(this.BSW, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void KZx() {
        try {
            this.BSW.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void ZZv() {
        try {
            this.BSW.reload();
        } catch (Throwable unused) {
        }
    }

    public boolean ML() {
        if (this.BSW == null) {
            return false;
        }
        try {
            return this.BSW.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void JG() {
        try {
            this.BSW.goBack();
        } catch (Throwable unused) {
        }
    }

    public boolean SD() {
        if (this.BSW == null) {
            return false;
        }
        try {
            return this.BSW.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void omh() {
        try {
            this.BSW.goForward();
        } catch (Throwable unused) {
        }
    }

    public void Bzk() {
        if (this.BSW != null) {
            this.BSW.onResume();
        }
    }

    public String getUrl() {
        if (this.BSW == null) {
            return null;
        }
        try {
            return this.BSW.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOriginalUrl() {
        String url;
        if (this.BSW == null) {
            return null;
        }
        try {
            String originalUrl = this.BSW.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith(n.b) || (url = this.BSW.getUrl()) == null || !url.startsWith(AdPayload.FILE_SCHEME)) ? originalUrl : url;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        if (this.BSW == null) {
            return 0;
        }
        try {
            return this.BSW.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public int getContentHeight() {
        if (this.BSW == null) {
            return 0;
        }
        try {
            return this.BSW.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public void pA(boolean z) {
        try {
            this.BSW.clearCache(z);
        } catch (Throwable unused) {
        }
    }

    public void SGo() {
        try {
            this.BSW.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof InterfaceC0185ZZv) {
                setTouchStateListener((InterfaceC0185ZZv) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new pA();
            }
            this.BSW.setWebViewClient(new ML(this.Wx, webViewClient, this.DX));
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.BSW.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.BSW.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        try {
            this.BSW.setBackgroundColor(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.BSW == null) {
            return;
        }
        try {
            this.BSW.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentPA;
        try {
            pA(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.SGo && (viewParentPA = pA(this)) != null) {
                viewParentPA.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.SGo = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent pA(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (Og(view2) || KZx(view2)) ? parent : pA(view2);
    }

    private static boolean Og(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static boolean KZx(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        try {
            this.BSW.setLayerType(i, paint);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        try {
            this.BSW.setOverScrollMode(i);
            super.setOverScrollMode(i);
        } catch (Throwable unused) {
        }
    }

    private void DX() {
        if (this.BSW == null) {
            return;
        }
        try {
            this.BSW.removeJavascriptInterface("searchBoxJavaBridge_");
            this.BSW.removeJavascriptInterface("accessibility");
            this.BSW.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public void pA(Object obj, String str) {
        try {
            PangleNetworkBridge.onAddedJavascriptInterface(this.BSW, obj, str);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.BSW.getSettings().setJavaScriptEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z) {
        try {
            this.BSW.getSettings().setDisplayZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i) {
        try {
            this.BSW.getSettings().setCacheMode(i);
        } catch (Throwable unused) {
        }
    }

    private void oX() {
        try {
            WebSettings settings = this.BSW.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.BSW.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equalsIgnoreCase("file")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public void BSW() {
        if (this.BSW == null) {
            return;
        }
        try {
            this.BSW.onPause();
        } catch (Throwable unused) {
        }
    }

    public boolean safedk_ZZv_dispatchTouchEvent_2e07174988d3d7ac5d0450e2630ba58b(MotionEvent p0) {
        return super.dispatchTouchEvent(p0);
    }

    public String getUserAgentString() {
        if (this.BSW == null) {
            return "";
        }
        try {
            return this.BSW.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.BSW;
    }

    public void WV() {
        if (this.BSW == null) {
            return;
        }
        try {
            this.BSW.destroy();
        } catch (Throwable unused) {
        }
    }

    public void b_(String str) {
        try {
            this.BSW.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void setSupportZoom(boolean z) {
        try {
            this.BSW.getSettings().setSupportZoom(z);
        } catch (Throwable unused) {
        }
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.BSW.getSettings().setUseWideViewPort(z);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.BSW.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.BSW.getSettings().setDomStorageEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.BSW.getSettings().setBuiltInZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.BSW.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.BSW.getSettings().setLoadWithOverviewMode(z);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.BSW.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.BSW.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultFontSize(int i) {
        try {
            this.BSW.getSettings().setDefaultFontSize(i);
        } catch (Throwable unused) {
        }
    }

    public void setMixedContentMode(int i) {
        try {
            this.BSW.getSettings().setMixedContentMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.BSW.getSettings().setDatabaseEnabled(z);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        try {
            super.setVisibility(i);
            this.BSW.setVisibility(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        try {
            super.setAlpha(f);
            this.BSW.setAlpha(f);
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.BSW.getSettings().setAllowFileAccess(z);
        } catch (Throwable unused) {
        }
    }

    public void Wx() {
        try {
            this.BSW.clearView();
        } catch (Throwable unused) {
        }
    }

    public void Sn() {
        try {
            this.BSW.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.BSW.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    private void aBv() {
        if (this.Sd == null) {
            this.du.set(false);
            this.Sd = new vZF(getContext());
        }
        new Object() { // from class: com.bytedance.sdk.component.Bzk.ZZv.1
        };
        this.du.set(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.WQf.set(true);
        if (!this.TV.get() || this.du.get()) {
            return;
        }
        aBv();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.WQf.set(false);
    }

    public long getLandingPageClickBegin() {
        return this.Mc;
    }

    public void setLandingPageClickBegin(long j) {
        this.Mc = j;
    }

    public long getLandingPageClickEnd() {
        return this.IG;
    }

    public void setLandingPageClickEnd(long j) {
        this.IG = j;
    }

    private void pA(MotionEvent motionEvent) {
        if (!this.ZZv || this.pA == null) {
            return;
        }
        if ((this.Og == null && this.KZx == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.ML = motionEvent.getRawX();
                this.JG = motionEvent.getRawY();
                this.SD = System.currentTimeMillis();
                this.KZx = new JSONObject();
                if (this.BSW != null) {
                    this.Mc = this.SD;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.KZx.put("start_x", String.valueOf(this.ML));
                this.KZx.put("start_y", String.valueOf(this.JG));
                this.KZx.put("offset_x", String.valueOf(motionEvent.getRawX() - this.ML));
                this.KZx.put("offset_y", String.valueOf(motionEvent.getRawY() - this.JG));
                this.KZx.put("url", String.valueOf(getUrl()));
                this.KZx.put("tag", "");
                this.omh = System.currentTimeMillis();
                if (this.BSW != null) {
                    this.IG = this.omh;
                }
                this.KZx.put("down_time", this.SD);
                this.KZx.put("up_time", this.omh);
                if (com.bytedance.sdk.component.Bzk.pA.pA.pA().Og() != null) {
                    long j = this.Bzk;
                    long j2 = this.SD;
                    if (j != j2) {
                        this.Bzk = j2;
                        com.bytedance.sdk.component.Bzk.pA.pA.pA().Og().pA(this.pA, this.Og, "in_web_click", this.KZx, this.omh - this.SD);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f) {
        this.oX = f;
    }

    public void setDeepShakeValue(float f) {
        this.aBv = f;
    }

    public void setWriggleValue(float f) {
        this.XT = f;
    }

    public void setCalculationMethod(int i) {
        this.yFO = i;
    }

    public void setOnShakeListener(Og og) {
        this.vZF = og;
    }

    public static class pA extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.u, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(h.u, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(h.u, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() { // from class: com.bytedance.sdk.component.Bzk.ZZv.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
    }
}
