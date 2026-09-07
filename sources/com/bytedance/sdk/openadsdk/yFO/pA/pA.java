package com.bytedance.sdk.openadsdk.yFO.pA;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.pA.JG;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.WV.ML;
import com.bytedance.sdk.openadsdk.ZZv.aBv;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.BSW;
import com.bytedance.sdk.openadsdk.core.widget.SGo;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.yFO.SD;
import com.bytedance.sdk.openadsdk.yFO.omh;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class pA {
    private ML BSW;
    private final String Bzk;
    private AtomicBoolean DX;
    private BSW JG;
    private final yFO KZx;
    private final FrameLayout ML;
    private final Context Og;
    private IG SD;
    private omh SGo;
    private volatile boolean Sn;
    private boolean WV;
    private volatile boolean Wx;
    private InterfaceC0260pA XT;
    private final int ZZv;
    private com.bytedance.sdk.openadsdk.core.Og.pA aBv;
    private SGo oX;
    private String omh;
    protected com.bytedance.sdk.component.Bzk.ZZv pA;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.yFO.pA.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0260pA {
        void pA();
    }

    public pA(Context context, yFO yfo, int i, boolean z, FrameLayout frameLayout) {
        this(context, yfo, i, z, frameLayout, false);
    }

    public pA(Context context, yFO yfo, int i, boolean z, FrameLayout frameLayout, boolean z2) {
        this.WV = true;
        this.DX = new AtomicBoolean(false);
        this.Og = context;
        this.KZx = yfo;
        this.ZZv = i;
        String strKZx = gbA.KZx(yfo.rB().getDurationSlotType());
        this.omh = strKZx;
        int iPA = gbA.pA(strKZx);
        if (z2) {
            this.omh = gbA.Og(iPA);
        }
        this.Bzk = WQf.Wx(yfo);
        this.ML = frameLayout;
        pA(frameLayout);
        pA(iPA);
        KZx(z);
        SD();
    }

    public static void pA(yFO yfo, JSONObject jSONObject) {
        if (jSONObject == null || yfo == null || !WQf.Og(yfo) || !yfo.SRe()) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_new_playable", 1);
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    private void pA(FrameLayout frameLayout) {
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(this.Og);
        this.pA = zZv;
        zZv.f_();
        this.pA.setLayerType(2, null);
        this.pA.setVisibility(4);
        this.pA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.pA.setEnabled(true);
        this.pA.setTag(this.omh);
        this.pA.setMaterialMeta(this.KZx.BDQ());
        this.pA.setLandingPage(true);
        frameLayout.addView(this.pA, new FrameLayout.LayoutParams(-1, -1));
        SGo sGo = new SGo(this.Og);
        this.oX = sGo;
        sGo.pA(this.KZx, this.omh, this.aBv);
        frameLayout.addView(this.oX, new FrameLayout.LayoutParams(-1, -1));
        if (this.KZx.Bpk()) {
            BSW bsw = new BSW(this.Og);
            this.JG = bsw;
            bsw.Og();
            frameLayout.addView(this.JG, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void pA(int i) {
        HashMap map = new HashMap();
        map.put("click_scence", 3);
        this.SD = new IG(this.Og);
        this.SD.Og(this.pA).pA(this.KZx).KZx(this.KZx.nCO()).ZZv(this.KZx.tM()).Og(i).ML(this.KZx.jK()).pA(this.pA).Og(this.omh).pA(map).pA(new aBv(3, this.omh, this.KZx));
    }

    private void KZx(boolean z) {
        com.bytedance.sdk.component.pA.aBv abvPA;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.KZx.nCO());
            jSONObject.put("log_extra", this.KZx.tM());
        } catch (Throwable unused) {
        }
        if (Bzk.Og().aBv()) {
            SD.pA(new SD.pA() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.1
                @Override // com.bytedance.sdk.openadsdk.yFO.SD.pA
                public void pA(String str, String str2, Throwable th) {
                    WV.pA(str, str2, th);
                }
            });
        }
        omh omhVarPA = omh.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.pA.getWebView(), new com.bytedance.sdk.openadsdk.yFO.KZx() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.2
            @Override // com.bytedance.sdk.openadsdk.yFO.KZx
            public void pA(String str, JSONObject jSONObject2) {
                if (pA.this.SD != null) {
                    pA.this.SD.pA(str, jSONObject2);
                }
            }
        }, new com.bytedance.sdk.openadsdk.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.3
            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public com.bytedance.sdk.openadsdk.yFO.ZZv pA() {
                String strJG = com.bytedance.sdk.openadsdk.common.Og.JG();
                strJG.hashCode();
                switch (strJG) {
                    case "2g":
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_2G;
                    case "3g":
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_3G;
                    case "4g":
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_4G;
                    case "5g":
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_5G;
                    case "wifi":
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_WIFI;
                    default:
                        return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_UNKNOWN;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public void Og() {
                pA.this.SD.KZx(true);
                if (pA.this.BSW != null) {
                    pA.this.BSW.pA();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public void pA(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_new_playable", 1);
                    if (pA.this.KZx.ISu()) {
                        jSONObject3.put("is_pre_render", 1);
                    }
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                } catch (JSONException e) {
                    WV.pA("PlayableManager", e.getMessage());
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(pA.this.KZx, pA.this.omh, "playable_track", jSONObject2);
            }

            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public void pA(int i, String str) {
                pA.this.WV = false;
                if (i == 2 || i == 3 || i == 4) {
                    pA.this.pA(2, i);
                } else if (i == 5) {
                    pA.this.pA(3, i);
                } else {
                    pA.this.pA(1, 0);
                }
            }
        });
        this.SGo = omhVarPA;
        omhVarPA.SD(this.Bzk).ML(com.bytedance.sdk.openadsdk.common.Og.pA(com.bytedance.sdk.openadsdk.core.aBv.pA())).Og(com.bytedance.sdk.openadsdk.common.Og.ML()).pA(com.bytedance.sdk.openadsdk.common.Og.pA()).ZZv(com.bytedance.sdk.openadsdk.common.Og.ZZv()).KZx(jSONObject).KZx(WQf.BSW(this.KZx)).ZZv(true).pA(z).KZx(false).pA(WQf.vZF(this.KZx)).Og(WQf.vZF(this.KZx)).pA("sdkEdition", com.bytedance.sdk.openadsdk.common.Og.KZx()).ML(WQf.JG(this.KZx)).JG(this.omh);
        this.SGo.pA(com.bytedance.sdk.openadsdk.yFO.ML.Og(this.Og));
        Set<String> setBSW = this.SGo.BSW();
        final WeakReference weakReference = new WeakReference(this.SGo);
        for (String str : setBSW) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (abvPA = this.SD.pA()) != null) {
                abvPA.pA(str, new com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.4
                    @Override // com.bytedance.sdk.component.pA.ML
                    public JSONObject pA(JSONObject jSONObject2, JG jg) {
                        try {
                            omh omhVar = (omh) weakReference.get();
                            if (omhVar == null) {
                                return null;
                            }
                            return omhVar.ZZv(pA(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    private void SD() {
        this.pA.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ML(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.SD, this.KZx.nCO(), null, true) { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/yFO/pA/pA$5;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                safedk_pA$5_onPageFinished_da0783938f969256cc76a7f4acce03c2(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/yFO/pA/pA$5;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
                safedk_pA$5_onReceivedError_8bb6856aaf6243f9cc518045137f0633(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/yFO/pA/pA$5;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
                safedk_pA$5_onReceivedError_b9e119220db1f117f33c3395084c0dc9(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/yFO/pA/pA$5;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_pA$5_shouldInterceptRequest_a8b5c25525489875c6d0c0220ca73073(webView, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                return zShouldOverrideUrlLoading;
            }

            public WebResourceResponse safedk_pA$5_shouldInterceptRequest_a8b5c25525489875c6d0c0220ca73073(WebView p0, String p1) {
                try {
                    if (pA.this.KZx.Bf() != null && !TextUtils.isEmpty(pA.this.KZx.Bf().Wx())) {
                        if (pA.this.SGo != null) {
                            pA.this.SGo.SGo(p1);
                        }
                        String strWx = WQf.Wx(pA.this.KZx);
                        WebResourceResponse webResourceResponsePA = com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pA.this.KZx.Bf().Wx(), strWx, p1);
                        if (webResourceResponsePA != null) {
                            new Object[]{"Plb res: hit++ ", p1};
                            if (pA.this.SGo != null) {
                                pA.this.SGo.BSW(p1);
                            }
                            return webResourceResponsePA;
                        }
                        new Object[]{"Plb res: hit no ", p1};
                        return super.shouldInterceptRequest(p0, p1);
                    }
                    return super.shouldInterceptRequest(p0, p1);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(p0, p1);
                }
            }

            public void safedk_pA$5_onReceivedError_8bb6856aaf6243f9cc518045137f0633(WebView p0, int p1, String p2, String p3) {
                super.onReceivedError(p0, p1, p2, p3);
                pA.this.WV = false;
                if (pA.this.SGo != null) {
                    pA.this.SGo.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pA.this.KZx));
                    pA.this.SGo.pA(p1, p2, p3);
                }
            }

            public void safedk_pA$5_onReceivedError_b9e119220db1f117f33c3395084c0dc9(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                super.onReceivedError(p0, p1, p2);
                if (p1.isForMainFrame()) {
                    pA.this.WV = false;
                    if (pA.this.SGo == null || p2 == null || p1 == null) {
                        return;
                    }
                    pA.this.SGo.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pA.this.KZx));
                    pA.this.SGo.pA(p2.getErrorCode(), String.valueOf(p2.getDescription()), String.valueOf(p1.getUrl()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    pA.this.WV = false;
                    if (pA.this.SGo != null) {
                        pA.this.SGo.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pA.this.KZx));
                        pA.this.SGo.pA(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    }
                }
            }

            public void safedk_pA$5_onPageFinished_da0783938f969256cc76a7f4acce03c2(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
                if (pA.this.SGo != null) {
                    pA.this.SGo.Bzk(p1);
                }
                if (pA.this.WV) {
                    pA.this.pA(0, 0);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), pA.this.KZx, pA.this.omh, "py_loading_success");
                }
            }
        });
        this.pA.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.SD) { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (pA.this.JG == null || pA.this.JG.getVisibility() != 0) {
                    return;
                }
                pA.this.JG.setProgress(i);
            }
        });
        com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this.Og).pA(false).Og(false).pA(this.pA.getWebView());
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
        zZv.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv.getWebView(), BuildConfig.VERSION_CODE));
        this.pA.setMixedContentMode(0);
    }

    public void pA(boolean z, ML ml) {
        this.BSW = ml;
        this.SGo.Og(z);
        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().Og(this.KZx);
        this.pA.a_(this.Bzk);
        omh omhVar = this.SGo;
        if (omhVar != null) {
            omhVar.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.KZx));
            this.SGo.omh(this.Bzk);
        }
    }

    public void pA() {
        boolean z;
        BSW bsw;
        if (this.DX.getAndSet(true)) {
            return;
        }
        FrameLayout frameLayout = this.ML;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (!this.Sn && (bsw = this.JG) != null) {
            bsw.Og(this.KZx, this.ZZv);
            omh omhVar = this.SGo;
            if (omhVar != null) {
                omhVar.Mc();
            }
            z = true;
        } else {
            this.SGo.KZx(true);
            z = false;
        }
        if (this.SGo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("webview_state", this.SGo.CIG());
                jSONObject2.put("has_loading", z);
                jSONObject2.put("is_new_playable", 1);
                jSONObject.put("pag_json_data", jSONObject2.toString());
                jSONObject.put("playable_event", "start_show_plb");
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.KZx, this.omh, "playable_track", jSONObject);
            this.SGo.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.KZx));
        }
        this.pA.setVisibility(0);
    }

    public void pA(final int i, final int i2) {
        omh omhVar;
        InterfaceC0260pA interfaceC0260pA;
        if (this.Sn) {
            return;
        }
        this.Sn = true;
        if (i == 2) {
            this.Wx = true;
            this.SGo.pA(3);
        } else if (i == 1) {
            this.Wx = true;
            this.SGo.pA(2);
        } else if (i == 3) {
            this.Wx = true;
            this.SGo.pA(4);
        } else if (i == 0) {
            this.SGo.pA(1);
        }
        if (this.Wx && (interfaceC0260pA = this.XT) != null) {
            interfaceC0260pA.pA();
        }
        if (this.DX.get() && (omhVar = this.SGo) != null) {
            omhVar.KZx(true);
        }
        BSW bsw = this.JG;
        if (bsw != null) {
            bsw.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.pA.7
                @Override // java.lang.Runnable
                public void run() {
                    if (pA.this.Wx) {
                        pA.this.oX.setVisibility(0);
                        pA.this.pA(true);
                    }
                    pA.this.JG.KZx();
                    if (pA.this.DX.get()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("remove_loading_page_type", i);
                            jSONObject2.put("remove_loading_page_reason", i2);
                            jSONObject2.put("playable_url", pA.this.Bzk);
                            jSONObject2.put("duration", pA.this.JG.getDisplayDuration());
                            jSONObject2.put("is_new_playable", 1);
                            jSONObject.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("playable_event", "remove_loading_page");
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(pA.this.KZx, pA.this.omh, "playable_track", jSONObject);
                    }
                }
            });
        }
    }

    public void pA(boolean z) {
        omh omhVar = this.SGo;
        if (omhVar != null) {
            omhVar.pA(z);
        }
    }

    public void Og() {
        omh omhVar;
        if (!this.DX.get() || (omhVar = this.SGo) == null) {
            return;
        }
        omhVar.KZx(true);
    }

    public void KZx() {
        omh omhVar;
        if (!this.DX.get() || (omhVar = this.SGo) == null) {
            return;
        }
        omhVar.KZx(false);
    }

    public void ZZv() {
        omh omhVar = this.SGo;
        if (omhVar != null) {
            omhVar.qmB();
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
        if (zZv != null) {
            zZv.WV();
        }
        IG ig = this.SD;
        if (ig != null) {
            ig.BSW();
        }
        this.pA = null;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        this.aBv = pAVar;
        BSW bsw = this.JG;
        if (bsw != null && bsw.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.ML.omh downloadButton = this.JG.getDownloadButton();
            downloadButton.setOnClickListener(pAVar);
            downloadButton.setOnTouchListener(pAVar);
        }
        SGo sGo = this.oX;
        if (sGo != null) {
            sGo.setClickListener(pAVar);
        }
    }

    public boolean ML() {
        return this.Wx;
    }

    public void pA(InterfaceC0260pA interfaceC0260pA) {
        this.XT = interfaceC0260pA;
    }

    public boolean JG() {
        IG ig = this.SD;
        if (ig != null) {
            return ig.ML();
        }
        return false;
    }

    public void Og(boolean z) {
        omh omhVar = this.SGo;
        if (omhVar != null) {
            omhVar.ML(z);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        IG ig = this.SD;
        if (ig != null) {
            ig.pA(og);
        }
    }
}
