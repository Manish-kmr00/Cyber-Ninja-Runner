package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ML extends com.bytedance.sdk.component.Bzk.ZZv implements com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx {
    private Og BSW;
    private int Bzk;
    private KZx JG;
    AtomicBoolean KZx;
    private BF ML;
    protected boolean Og;
    private com.bytedance.sdk.openadsdk.core.model.yFO SD;
    private List<String> SGo;
    private int WV;
    private long Wx;
    AtomicBoolean ZZv;
    private String omh;
    protected boolean pA;

    public interface Og {
        View Og();

        void e_();

        View pA();

        void pA(int i, int i2);

        void pA(View view, int i);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ML(Context context) {
        super(context);
        this.pA = false;
        this.Og = false;
        this.KZx = new AtomicBoolean(false);
        this.ZZv = new AtomicBoolean(false);
        this.Bzk = 0;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, Og og, String str) {
        this.BSW = og;
        this.SD = yfo;
        this.omh = str;
        this.JG = new KZx();
        this.ML = new BF(getContext());
        setWebViewClient(new pA(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.omh.ML.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                ML.this.WV = i;
                super.onProgressChanged(webView, i);
                if (i >= 100) {
                    ML.this.pA();
                }
            }
        });
        com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.ML.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = ML.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.omh.ML.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/ML$2$1;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                            CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                            return safedk_ML$2$1_onTouch_e1750e15db5d6e4edea79114002a25e2(view, motionEvent);
                        }

                        public boolean safedk_ML$2$1_onTouch_e1750e15db5d6e4edea79114002a25e2(View p0, MotionEvent p1) {
                            ML.this.ML.onTouchEvent(p1);
                            return false;
                        }
                    });
                }
            }
        });
    }

    private void aBv() {
        if (this.SGo == null) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.SD, this.omh, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.omh.ML.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ML.this.SGo != null && ML.this.ZZv.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = ML.this.SGo.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(ML.this.SD, ML.this.omh, "dsp_html_error_url", jSONObject);
                            ML.this.SGo = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv
    public void WV() {
        this.JG.Og();
        super.WV();
    }

    public void pA(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.JG.pA(view, friendlyObstructionPurpose);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pA) {
            this.JG.pA(getWebView());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        this.Og = z;
        this.JG.pA(z);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.JG.pA();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.WV / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.SD, this.omh, "load_rate", jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:41:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x0104  */
    /* JADX WARN: Code duplicated, block: B:45:0x0107  */
    /* JADX WARN: Code duplicated, block: B:49:0x0116  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx
    public void pA(String str) {
        String str2;
        boolean zPA;
        String str3;
        BF bf;
        Og og;
        View view;
        int i;
        if (TextUtils.isEmpty(str) || this.SD == null || !this.ML.Og()) {
            return;
        }
        int iPA = gbA.pA(this.omh);
        View view2 = null;
        if (com.bytedance.sdk.component.utils.DX.pA(str) || !(this.SD.Itl() == null || TextUtils.isEmpty(this.SD.Itl().pA()))) {
            str2 = str;
        } else {
            com.bytedance.sdk.openadsdk.core.model.BSW bsw = new com.bytedance.sdk.openadsdk.core.model.BSW();
            bsw.pA(str);
            this.SD.pA(bsw);
            str2 = null;
        }
        this.SD.pA(true);
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.SD;
        if (yfo != null && yfo.Itl() != null && !TextUtils.isEmpty(this.SD.Itl().pA())) {
            zPA = rB.pA(getContext(), this.SD, iPA, this.omh, true, (Map<String, Object>) null);
            if (!zPA && !TextUtils.isEmpty(this.SD.Itl().Og())) {
                String strOg = this.SD.Itl().Og();
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.SD, this.omh, "open_fallback_url", (Map<String, Object>) null);
                str3 = strOg;
            }
            if (!zPA) {
                if (!TextUtils.isEmpty(str3)) {
                    return;
                } else {
                    rB.pA(getContext(), this.SD, iPA, (PAGNativeAd) null, (PangleAd) null, this.omh, true, str3);
                }
            }
            if (this.ML != null) {
                og = this.BSW;
                if (og != null) {
                    View viewPA = og.pA();
                    View viewOg = this.BSW.Og();
                    this.BSW.pA(this, 2);
                    view2 = viewOg;
                    view = viewPA;
                } else {
                    view = null;
                }
                com.bytedance.sdk.openadsdk.core.model.SGo sGoPA = this.ML.pA(getContext(), view2, view);
                HashMap map = new HashMap();
                map.put("click_scence", 1);
                com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.SD;
                String str4 = this.omh;
                if (this.ML.Og()) {
                    i = 1;
                } else {
                    i = 2;
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo2, sGoPA, str4, true, (Map<String, Object>) map, i);
            }
            bf = this.ML;
            if (bf != null) {
                bf.pA();
            }
        }
        zPA = false;
        str3 = str2;
        if (!zPA) {
            if (!TextUtils.isEmpty(str3)) {
                return;
            } else {
                rB.pA(getContext(), this.SD, iPA, (PAGNativeAd) null, (PangleAd) null, this.omh, true, str3);
            }
        }
        if (this.ML != null) {
            og = this.BSW;
            if (og != null) {
                View viewPA2 = og.pA();
                View viewOg2 = this.BSW.Og();
                this.BSW.pA(this, 2);
                view2 = viewOg2;
                view = viewPA2;
            } else {
                view = null;
            }
            com.bytedance.sdk.openadsdk.core.model.SGo sGoPA2 = this.ML.pA(getContext(), view2, view);
            HashMap map2 = new HashMap();
            map2.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.core.model.yFO yfo3 = this.SD;
            String str5 = this.omh;
            if (this.ML.Og()) {
                i = 1;
            } else {
                i = 2;
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", yfo3, sGoPA2, str5, true, (Map<String, Object>) map2, i);
        }
        bf = this.ML;
        if (bf != null) {
            bf.pA();
        }
    }

    public void DX() {
        Og og = this.BSW;
        if (og != null) {
            og.e_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.Wx);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.SD, this.omh, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx
    public void pA(int i, int i2) {
        Og og = this.BSW;
        if (og != null) {
            og.pA(i, i2);
        }
        this.Bzk = i2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", i2);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.Wx);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.SD, this.omh, "render_html_fail", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx
    public void Og(String str) {
        if (this.SGo == null) {
            this.SGo = new ArrayList();
        }
        this.SGo.add(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx
    public void pA() {
        if (this.KZx.compareAndSet(false, true)) {
            this.pA = true;
            this.JG.pA(getWebView());
            this.JG.pA(this.Og);
            DX();
            aBv();
        }
    }

    public void oX() {
        this.KZx.set(false);
        String strXj = this.SD.Xj();
        if (TextUtils.isEmpty(strXj)) {
            return;
        }
        String strPA = com.bytedance.sdk.openadsdk.core.WV.ML.pA(strXj);
        String str = TextUtils.isEmpty(strPA) ? strXj : strPA;
        this.Bzk = 0;
        pA(null, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        this.Wx = SystemClock.elapsedRealtime();
    }

    static class pA extends com.bytedance.sdk.component.Bzk.ZZv.pA {
        public static final Set<String> pA = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.omh.ML.pA.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx Og;

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.u, view, url);
        }

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/ML$pA;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
            safedk_ML$pA_onPageFinished_736da8fe6d01809fb434d0a33b923ed9(webView, str);
        }

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
        }

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/ML$pA;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
            safedk_ML$pA_onReceivedError_6b2fa388d416fd773e394d9fd3e389af(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/ML$pA;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
            safedk_ML$pA_onReceivedError_1607d8e74f12e96b7382c49267b598a9(webView, webResourceRequest, webResourceError);
        }

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/ML$pA;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_ML$pA_shouldOverrideUrlLoading_959790e116695ad66aa273ffbf642ffd = safedk_ML$pA_shouldOverrideUrlLoading_959790e116695ad66aa273ffbf642ffd(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView, str, zSafedk_ML$pA_shouldOverrideUrlLoading_959790e116695ad66aa273ffbf642ffd);
            return zSafedk_ML$pA_shouldOverrideUrlLoading_959790e116695ad66aa273ffbf642ffd;
        }

        public pA(com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx interfaceC0246KZx) {
            this.Og = interfaceC0246KZx;
        }

        public boolean safedk_ML$pA_shouldOverrideUrlLoading_959790e116695ad66aa273ffbf642ffd(WebView p0, String p1) {
            this.Og.pA(p1);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                pA(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            pA(webResourceRequest.getUrl().toString());
        }

        public void safedk_ML$pA_onReceivedError_6b2fa388d416fd773e394d9fd3e389af(WebView p0, int p1, String p2, String p3) {
            super.onReceivedError(p0, p1, p2, p3);
        }

        public void safedk_ML$pA_onReceivedError_1607d8e74f12e96b7382c49267b598a9(WebView p0, WebResourceRequest p1, WebResourceError p2) {
            super.onReceivedError(p0, p1, p2);
            if (p1 == null || p1.getUrl() == null) {
                return;
            }
            pA(p1.getUrl().toString());
        }

        private void pA(String str) {
            int iLastIndexOf;
            com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx interfaceC0246KZx;
            if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!pA.contains(str.substring(iLastIndexOf).toLowerCase()) || (interfaceC0246KZx = this.Og) == null) {
                    return;
                }
                interfaceC0246KZx.Og(str);
            }
        }

        public void safedk_ML$pA_onPageFinished_736da8fe6d01809fb434d0a33b923ed9(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx interfaceC0246KZx = this.Og;
            if (interfaceC0246KZx != null) {
                interfaceC0246KZx.pA();
            }
        }

        private void pA(String str, int i, String str2) {
            com.bytedance.sdk.openadsdk.core.omh.KZx.InterfaceC0246KZx interfaceC0246KZx = this.Og;
            if (interfaceC0246KZx != null) {
                interfaceC0246KZx.pA(106, i);
            }
        }
    }

    public static class KZx {
        protected int pA = 0;
        private com.bytedance.sdk.openadsdk.core.WV.JG Og = com.bytedance.sdk.openadsdk.core.WV.JG.pA();

        KZx() {
        }

        public void pA(WebView webView) {
            if (webView != null && this.pA == 0) {
                if (this.Og == null) {
                    this.Og = com.bytedance.sdk.openadsdk.core.WV.JG.pA();
                }
                this.Og.pA(webView);
                this.Og.Og();
                this.pA = 1;
            }
        }

        public void pA(boolean z) {
            com.bytedance.sdk.openadsdk.core.WV.JG jg;
            if (this.pA == 1 && z && (jg = this.Og) != null) {
                jg.KZx();
                this.pA = 3;
            }
        }

        public void pA(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.WV.JG jg = this.Og;
            if (jg != null) {
                jg.pA(view, friendlyObstructionPurpose);
            }
        }

        public void pA() {
            com.bytedance.sdk.openadsdk.core.WV.JG jg;
            int i = this.pA;
            if (i != 0 && i != 4 && (jg = this.Og) != null) {
                jg.ZZv();
            }
            this.pA = 4;
            this.Og = null;
        }

        public void Og() {
            pA();
        }
    }
}
