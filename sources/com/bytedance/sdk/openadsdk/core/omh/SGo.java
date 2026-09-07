package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.IG;
import com.google.common.net.HttpHeaders;
import com.json.cc;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class SGo extends com.bytedance.sdk.openadsdk.core.widget.pA.ML {
    private final com.bytedance.sdk.openadsdk.core.model.yFO Og;
    private com.bytedance.sdk.component.adexpress.Og.Wx SGo;
    public ArrayList<Integer> pA;

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.u, view, url);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/SGo;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
        safedk_SGo_onPageFinished_a79d03f5cb9e5607e689127638f3a32f(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/SGo;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
        safedk_SGo_onPageStarted_ce4f44bee5da5dce07c07e8120b58946(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(h.u, view, errorCode, description, failingUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/SGo;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, webView, webResourceRequest, safedk_SGo_shouldInterceptRequest_b667bc7406d6d9a2257033c58cb6c6de(webView, webResourceRequest));
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/SGo;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_SGo_shouldInterceptRequest_ca0b9ed5183444d10396bcf31cbaab58(webView, str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
        return zShouldOverrideUrlLoading;
    }

    public SGo(Context context, IG ig, com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.openadsdk.ZZv.BSW bsw, com.bytedance.sdk.component.adexpress.Og.Wx wx) {
        super(context, ig, yfo.nCO(), bsw, false);
        this.pA = new ArrayList<>();
        this.Og = yfo;
        this.SGo = wx;
    }

    public WebResourceResponse safedk_SGo_shouldInterceptRequest_b667bc7406d6d9a2257033c58cb6c6de(WebView p0, WebResourceRequest p1) {
        try {
            return shouldInterceptRequest(p0, p1.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(p0, p1);
        }
    }

    public int pA() {
        for (Integer num : this.pA) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(KZx()) ? -1 : 1;
    }

    public WebResourceResponse safedk_SGo_shouldInterceptRequest_ca0b9ed5183444d10396bcf31cbaab58(WebView p0, String p1) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.pA.Og.pA pAVarPA = pA(p0, p1);
            pA(jCurrentTimeMillis, System.currentTimeMillis(), p1, (pAVarPA == null || pAVarPA.pA() == null) ? 2 : 1);
            if (pAVarPA != null && pAVarPA.Og() != 5) {
                pAVarPA.Og();
                this.pA.add(Integer.valueOf(pAVarPA.Og()));
            }
            if (pAVarPA != null && pAVarPA.pA() != null) {
                new Object[]{"return WebResourceResponse by cache, url is:", p1};
                return pAVarPA.pA();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(p0, p1);
    }

    public void safedk_SGo_onPageFinished_a79d03f5cb9e5607e689127638f3a32f(WebView p0, String p1) {
        this.SD = false;
        super.onPageFinished(p0, p1);
    }

    public void safedk_SGo_onPageStarted_ce4f44bee5da5dce07c07e8120b58946(WebView p0, String p1, Bitmap p2) {
        this.omh = false;
        super.onPageStarted(p0, p1, p2);
    }

    private com.bytedance.sdk.component.adexpress.pA.Og.pA pA(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.model.DX dx = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new Object[]{"url is:", str};
        if (str.equals("local://pag_open_icon_id") || str.equals(com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA)) {
            com.bytedance.sdk.component.adexpress.pA.Og.pA pAVar = new com.bytedance.sdk.component.adexpress.pA.Og.pA();
            pAVar.pA(5);
            pAVar.pA(ZZv());
            return pAVar;
        }
        com.bytedance.sdk.openadsdk.core.model.yFO.pA pAVarCIG = this.Og.CIG();
        if (pAVarCIG != null && !TextUtils.isEmpty(str) && str.equals(pAVarCIG.ZZv())) {
            com.bytedance.sdk.component.adexpress.pA.Og.pA pAVar2 = new com.bytedance.sdk.component.adexpress.pA.Og.pA();
            pAVar2.pA(5);
            WebResourceResponse webResourceResponseML = ML(str);
            pAVar2.pA(webResourceResponseML);
            boolean z = webResourceResponseML != null;
            new Object[]{"webview cache result is:", Boolean.valueOf(z)};
            com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().pA(z);
            return pAVar2;
        }
        com.bytedance.sdk.component.adexpress.ZZv.SGo.pA pAVarPA = com.bytedance.sdk.component.adexpress.ZZv.SGo.pA(str);
        if (pAVarPA != com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.IMAGE) {
            for (com.bytedance.sdk.openadsdk.core.model.DX dx2 : this.Og.IIF()) {
                if (!TextUtils.isEmpty(dx2.pA()) && !TextUtils.isEmpty(str)) {
                    String strPA = dx2.pA();
                    if (strPA.startsWith("https")) {
                        strPA = strPA.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strPA)) {
                        dx = dx2;
                        break;
                    }
                }
            }
        }
        if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.IMAGE || dx != null) {
            com.bytedance.sdk.component.adexpress.pA.Og.pA pAVar3 = new com.bytedance.sdk.component.adexpress.pA.Og.pA();
            pAVar3.pA(5);
            pAVar3.pA(pA(str, com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(this.Og, str)));
            return pAVar3;
        }
        return com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(str, pAVarPA, "", KZx());
    }

    private String KZx() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.Og;
        if (yfo == null) {
            return null;
        }
        if (yfo.CIG() != null) {
            return this.Og.CIG().Wx();
        }
        if (this.Og.FQ() != null) {
            return "v3";
        }
        return null;
    }

    private WebResourceResponse ZZv() {
        InputStream inputStreamOpenRawResource;
        int iSD = com.bytedance.sdk.openadsdk.core.Bzk.Og().SD();
        if (iSD == 0) {
            return null;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.aBv.pA().getResources();
        if (resources != null) {
            try {
                inputStreamOpenRawResource = resources.openRawResource(iSD);
            } catch (Resources.NotFoundException e) {
                com.bytedance.sdk.component.utils.WV.pA("ExpressClient", e.toString());
                inputStreamOpenRawResource = null;
            }
        } else {
            inputStreamOpenRawResource = null;
        }
        if (inputStreamOpenRawResource != null) {
            return new WebResourceResponse(com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.IMAGE.pA(), "UTF-8", inputStreamOpenRawResource);
        }
        return null;
    }

    private WebResourceResponse ML(String str) {
        InputStream inputStreamPA;
        if (TextUtils.isEmpty(str) || (inputStreamPA = com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().pA(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("audio/*", "UTF-8", inputStreamPA);
        pA(webResourceResponse);
        return webResourceResponse;
    }

    private WebResourceResponse pA(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream inputStreamPA = com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str, str2);
            if (inputStreamPA == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.IMAGE.pA(), cc.N, inputStreamPA);
            try {
                pA(webResourceResponse2);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        com.bytedance.sdk.component.utils.WV.pA("ExpressClient", "get image WebResourceResponse error", th);
        return webResourceResponse;
    }

    private void pA(long j, long j2, String str, int i) {
        if (this.JG == null || this.JG.Og() == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.ZZv.SGo.pA pAVarPA = com.bytedance.sdk.component.adexpress.ZZv.SGo.pA(str);
        if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.HTML) {
            this.JG.Og().pA(str, j, j2, i);
        } else if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.JS) {
            this.JG.Og().Og(str, j, j2, i);
        }
    }

    private void pA(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        webResourceResponse.setResponseHeaders(map);
    }
}
