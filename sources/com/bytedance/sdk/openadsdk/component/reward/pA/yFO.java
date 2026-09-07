package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.xy;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class yFO implements com.bytedance.sdk.openadsdk.WV.SD {
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA Bzk;
    private com.bytedance.sdk.openadsdk.core.Og.SD JG;
    private com.bytedance.sdk.component.Bzk.ZZv KZx;
    private boolean ML;
    private final com.bytedance.sdk.openadsdk.core.model.yFO Og;
    private final AtomicBoolean SD = new AtomicBoolean(false);
    private int SGo;
    private ImageView ZZv;
    private volatile boolean omh;
    private final Activity pA;

    public yFO(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.Bzk = pAVar;
        this.Og = pAVar.Og;
        this.pA = pAVar.SzT;
    }

    public void pA() {
        DeviceUtils.AudioInfoReceiver.pA(this);
        this.SGo = DeviceUtils.SD();
        if (this.Og.dGZ() != null) {
            this.JG = new com.bytedance.sdk.openadsdk.core.Og.SD("VAST_END_CARD", this.Og.dGZ()) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.yFO.1
            };
            com.bytedance.sdk.openadsdk.core.WV.KZx KZx = this.Og.dGZ().KZx();
            if (KZx != null) {
                String strML = KZx.ML();
                if (!TextUtils.isEmpty(strML)) {
                    this.ML = true;
                    this.ZZv = (ImageView) this.Bzk.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.omh);
                    pA(KZx.Og(), KZx.KZx());
                    com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(strML).pA(KZx.Og()).Og(KZx.KZx()).ML(Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA())).ZZv(Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA())).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(this.Og, strML, new pA(this.ZZv, strML, this, this.SD)));
                    return;
                }
                com.bytedance.sdk.component.Bzk.ZZv zZv = (com.bytedance.sdk.component.Bzk.ZZv) this.Bzk.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Bzk);
                this.KZx = zZv;
                if (zZv == null) {
                    return;
                }
                ML();
                String strZZv = KZx.ZZv();
                if (strZZv != null) {
                    this.ML = true;
                    if (strZZv.startsWith("http")) {
                        this.KZx.a_(strZZv);
                        return;
                    }
                    String strPA = com.bytedance.sdk.openadsdk.core.WV.ML.pA(strZZv);
                    String str = TextUtils.isEmpty(strPA) ? strZZv : strPA;
                    this.KZx.setDefaultTextEncodingName("UTF -8");
                    this.KZx.pA(null, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        pA(Integer.MAX_VALUE, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final int i, final String str) {
        String strBSW;
        if (this.omh) {
            return;
        }
        this.omh = true;
        if (this.Og.dGZ() == null) {
            strBSW = "";
        } else {
            strBSW = this.Og.dGZ().BSW();
        }
        final String str2 = strBSW;
        if (i == Integer.MAX_VALUE) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.Og, str2, "load_vast_endcard_success", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("load_vast_endcard_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.yFO.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("reason_code", i);
                        jSONObject.put("error_code", i);
                        String str3 = str;
                        if (str3 != null) {
                            jSONObject.put("url", str3);
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(yFO.this.Og, str2, "load_vast_endcard_fail", jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void ML() {
        this.KZx.f_();
        pA(this.KZx);
        this.KZx.setDisplayZoomControls(false);
        this.KZx.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.yFO.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100) {
                    yFO.this.ZZv();
                }
            }
        });
        this.KZx.setWebViewClient(new com.bytedance.sdk.component.Bzk.ZZv.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.yFO.4
            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/yFO$4;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                safedk_yFO$4_onPageFinished_60bcfef203b32dc78e0b32f4d4c6eb70(webView, str);
            }

            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
            }

            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                BrandSafetyUtils.onWebViewReceivedError(h.u, view, errorCode, description, failingUrl);
            }

            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
                return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
            }

            @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/yFO$4;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
                boolean zSafedk_yFO$4_shouldOverrideUrlLoading_b62a0f5a71b44b2cabed2ea7bd6a6627 = safedk_yFO$4_shouldOverrideUrlLoading_b62a0f5a71b44b2cabed2ea7bd6a6627(webView, str);
                BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView, str, zSafedk_yFO$4_shouldOverrideUrlLoading_b62a0f5a71b44b2cabed2ea7bd6a6627);
                return zSafedk_yFO$4_shouldOverrideUrlLoading_b62a0f5a71b44b2cabed2ea7bd6a6627;
            }

            public boolean safedk_yFO$4_shouldOverrideUrlLoading_b62a0f5a71b44b2cabed2ea7bd6a6627(WebView p0, String p1) {
                if (yFO.this.pA(p1)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(p0, p1);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    yFO.this.pA(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
            }

            public void safedk_yFO$4_onPageFinished_60bcfef203b32dc78e0b32f4d4c6eb70(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
                yFO.this.ZZv();
            }
        });
    }

    private void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        zZv.setVerticalScrollBarEnabled(false);
        zZv.setHorizontalScrollBarEnabled(false);
        zZv.setMixedContentMode(0);
        zZv.setJavaScriptEnabled(true);
        zZv.setJavaScriptCanOpenWindowsAutomatically(true);
        zZv.setDomStorageEnabled(true);
        zZv.setDatabaseEnabled(true);
        zZv.setCacheMode(-1);
        zZv.setAllowFileAccess(false);
        zZv.setSupportZoom(true);
        zZv.setBuiltInZoomControls(true);
        zZv.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        zZv.setUseWideViewPort(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(String str) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        if (str == null || (yfo = this.Og) == null || yfo.dGZ() == null || this.JG == null) {
            return false;
        }
        this.Og.dGZ().SD(str);
        this.JG.onClick(this.KZx);
        return true;
    }

    private void pA(int i, int i2) {
        if (i == 0 || i2 == 0 || this.ZZv == null) {
            return;
        }
        int iKZx = Vgu.KZx((Context) this.pA);
        int iZZv = Vgu.ZZv((Context) this.pA);
        float f = i / i2;
        float f2 = iKZx;
        if (f <= f2 / iZZv) {
            iKZx = (int) Math.ceil(f2 * f);
        } else {
            iZZv = (int) Math.ceil(f2 / f);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZZv.getLayoutParams();
        layoutParams.width = iKZx;
        layoutParams.height = iZZv;
        layoutParams.gravity = 17;
        this.ZZv.setLayoutParams(layoutParams);
        this.ZZv.setOnClickListener(this.JG);
        this.ZZv.setOnTouchListener(this.JG);
    }

    public boolean pA(aBv abv) {
        com.bytedance.sdk.openadsdk.core.WV.KZx KZx;
        if (!this.ML) {
            return false;
        }
        if (this.ZZv != null && this.SD.get()) {
            this.ZZv.setVisibility(0);
        } else {
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.KZx;
            if (zZv != null) {
                zZv.setVisibility(0);
                if (this.KZx.getWebView() != null) {
                    this.KZx.getWebView().setOnTouchListener(this.JG);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.Og;
        if (yfo == null || yfo.dGZ() == null || (KZx = this.Og.dGZ().KZx()) == null) {
            return true;
        }
        KZx.Og(abv != null ? abv.SD() : -1L);
        return true;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        com.bytedance.sdk.openadsdk.core.Og.SD sd = this.JG;
        if (sd != null) {
            sd.pA(ml);
        }
    }

    public void Og() {
        DeviceUtils.AudioInfoReceiver.Og(this);
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.KZx;
        if (zZv != null) {
            xy.pA(zZv.getWebView());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.WV.SD
    public void pA(int i) {
        int i2 = this.SGo;
        if (i2 == 0 && i > 0) {
            this.Og.dGZ().pA().Bzk(this.Bzk.BF.SD());
        } else if (i2 > 0 && i == 0) {
            this.Og.dGZ().pA().omh(this.Bzk.BF.SD());
        }
        this.SGo = i;
    }

    public boolean KZx() {
        if (!this.ML) {
            return false;
        }
        ImageView imageView = this.ZZv;
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.KZx;
        if (zZv == null) {
            return false;
        }
        this.JG.onClick(zZv);
        return true;
    }

    private static class pA implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private final WeakReference<yFO> KZx;
        private final String Og;
        private final AtomicBoolean ZZv;
        private final WeakReference<ImageView> pA;

        public pA(ImageView imageView, String str, yFO yfo, AtomicBoolean atomicBoolean) {
            this.pA = new WeakReference<>(imageView);
            this.Og = str;
            this.KZx = new WeakReference<>(yfo);
            this.ZZv = atomicBoolean;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            yFO yfo;
            ImageView imageView = this.pA.get();
            if (imageView == null || (yfo = this.KZx.get()) == null || bsw == null) {
                return;
            }
            Bitmap bitmapOg = bsw.Og();
            if (bitmapOg == null) {
                yfo.pA(-1, this.Og);
                return;
            }
            imageView.setImageBitmap(bitmapOg);
            this.ZZv.set(true);
            yfo.ZZv();
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
            yFO yfo;
            ImageView imageView = this.pA.get();
            if (imageView == null || (yfo = this.KZx.get()) == null) {
                return;
            }
            imageView.setVisibility(8);
            yfo.pA(-2, this.Og);
        }
    }
}
