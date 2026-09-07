package com.bytedance.sdk.openadsdk.core.widget.pA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.SGo;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.aBv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.vZF;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ML extends com.bytedance.sdk.component.Bzk.ZZv.pA {
    private static final HashSet<String> vZF;
    private Map<String, Object> BSW;
    protected boolean Bzk;
    private final Stack<String> DX;
    protected BSW JG;
    protected final IG KZx;
    protected final String ML;
    private String Og;
    protected boolean SD;
    private SGo SGo;
    private String Sn;
    private boolean WV;
    private com.bytedance.sdk.openadsdk.common.ZZv Wx;
    private JSONObject XT;
    protected final Context ZZv;
    private TTCeilingLandingPageActivity.pA aBv;
    private boolean oX;
    protected boolean omh;
    private final boolean pA;
    private yFO yFO;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(h.u, webView, str);
        safedk_ML_onLoadResource_e3dfa632d425ce250b73ecca086c9817(webView, str);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
        safedk_ML_onPageFinished_ab78d8202be4b6f421e324defc76106b(webView, str);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
        safedk_ML_onPageStarted_ee5a4c55ca5f72b6f34b0ad057c9da84(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
        safedk_ML_onReceivedError_699d4f0f9a7a9e035f5017848ca996c9(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
        safedk_ML_onReceivedError_75053c521aa41464504a9a258edbb5c4(webView, webResourceRequest, webResourceError);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, webView, webResourceRequest, safedk_ML_shouldInterceptRequest_38e2fc0f683939823f3aad43ee15bc91(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_ML_shouldInterceptRequest_8ab341575a39c675994e3a53944f551c(webView, str));
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/pA/ML;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_ML_shouldOverrideUrlLoading_adfa78012d1dee81c38b57df4e5995ef = safedk_ML_shouldOverrideUrlLoading_adfa78012d1dee81c38b57df4e5995ef(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView, str, zSafedk_ML_shouldOverrideUrlLoading_adfa78012d1dee81c38b57df4e5995ef);
        return zSafedk_ML_shouldOverrideUrlLoading_adfa78012d1dee81c38b57df4e5995ef;
    }

    public void pA(SGo sGo) {
        this.SGo = sGo;
    }

    public void pA(Map<String, Object> map) {
        this.BSW = map;
    }

    public void pA(JSONObject jSONObject) {
        this.XT = jSONObject;
    }

    public void pA(String str) {
        this.Og = str;
    }

    public void pA(yFO yfo) {
        this.yFO = yfo;
    }

    public ML(Context context, IG ig, String str, com.bytedance.sdk.openadsdk.common.ZZv zZv, BSW bsw, boolean z, boolean z2, TTCeilingLandingPageActivity.pA pAVar) {
        this(context, ig, str, zZv, bsw, z);
        this.oX = z2;
        this.aBv = pAVar;
    }

    public ML(Context context, IG ig, String str, com.bytedance.sdk.openadsdk.common.ZZv zZv, BSW bsw, boolean z) {
        this(context, ig, str, bsw, z);
        this.Wx = zZv;
    }

    public ML(Context context, IG ig, String str, BSW bsw, boolean z) {
        this.SD = true;
        this.omh = true;
        this.Bzk = false;
        this.ZZv = context;
        this.KZx = ig;
        this.ML = str;
        this.JG = bsw;
        this.pA = z;
        this.DX = new Stack<>();
    }

    public WebResourceResponse safedk_ML_shouldInterceptRequest_38e2fc0f683939823f3aad43ee15bc91(WebView p0, WebResourceRequest p1) {
        return super.shouldInterceptRequest(p0, p1);
    }

    public WebResourceResponse safedk_ML_shouldInterceptRequest_8ab341575a39c675994e3a53944f551c(WebView p0, String p1) {
        BSW bsw = this.JG;
        if (bsw != null) {
            bsw.Og(p0, p1, this.pA);
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZv = this.Wx;
        if (zZv != null) {
            zZv.pA(p0, p1);
        }
        return super.shouldInterceptRequest(p0, p1);
    }

    public void safedk_ML_onLoadResource_e3dfa632d425ce250b73ecca086c9817(WebView p0, String p1) {
        super.onLoadResource(p0, p1);
    }

    public boolean safedk_ML_shouldOverrideUrlLoading_adfa78012d1dee81c38b57df4e5995ef(WebView p0, String p1) {
        BSW bsw = this.JG;
        if (bsw != null) {
            bsw.pA(p1, this.pA);
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZv = this.Wx;
        if (zZv != null) {
            zZv.pA(p0, p1, this.pA);
        }
        if (pA(p0, p1)) {
            return true;
        }
        try {
            Uri uri = Uri.parse(p1);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                aBv.pA(uri, this.KZx);
                return true;
            }
            if (KZx(p1)) {
                return true;
            }
            if (!DX.pA(p1)) {
                if (com.bytedance.sdk.openadsdk.core.model.aBv.omh(this.yFO)) {
                    pA(lowerCase, p1);
                    return true;
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    intent.addFlags(268435456);
                    com.bytedance.sdk.component.utils.Og.pA(this.ZZv, intent, null);
                } catch (Throwable unused) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(p0, p1);
        } catch (Throwable unused2) {
            IG ig = this.KZx;
            if (ig != null && ig.ZZv()) {
                return true;
            }
        }
    }

    private void pA(String str, String str2) {
        if ((ML(str) || ApsAdWebViewSupportClient.MARKET_SCHEME.equals(str)) && ((this.SGo != null || this.XT != null) && Og(str2))) {
            Og();
        }
        this.SGo = null;
        this.XT = null;
    }

    public boolean Og(String str) {
        String strKZx;
        String strPA;
        if (this.ZZv == null) {
            return false;
        }
        yFO yfo = this.yFO;
        if (yfo != null && yfo.Wo() != null) {
            strKZx = this.yFO.Wo().KZx();
            strPA = this.yFO.Wo().pA();
        } else {
            strKZx = "";
            strPA = "";
        }
        if (!com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA()) {
            return com.bytedance.sdk.openadsdk.XT.pA.pA.pA.pA(str, this.ZZv, this.Og, this.yFO, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.XT.pA.pA.pA.pA(this.yFO, strKZx, this.ZZv, this.Og, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv.pA(this.ZZv, strPA, strKZx, this.Og, this.yFO);
        }
        Context context = this.ZZv;
        yFO yfo2 = this.yFO;
        return com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA(context, str, yfo2, gbA.Og(yfo2), null, true) || com.bytedance.sdk.openadsdk.XT.pA.pA.ML.pA(this.yFO, strKZx, this.ZZv, this.Og, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.XT.pA.pA.ML.pA(this.ZZv, strPA, strKZx, this.Og, this.yFO);
    }

    private boolean ML(String str) {
        if (com.bytedance.sdk.openadsdk.core.model.aBv.omh(this.yFO)) {
            return TextUtils.equals(this.yFO.xt(), str);
        }
        return false;
    }

    public void Og() {
        if (TextUtils.isEmpty(this.Og) || !com.bytedance.sdk.openadsdk.core.model.aBv.SD(this.yFO) || this.WV) {
            return;
        }
        SGo sGo = this.SGo;
        if (sGo != null) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", this.yFO, sGo, this.Og, true, this.BSW, 1);
            this.WV = true;
            return;
        }
        JSONObject jSONObject = this.XT;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.yFO, this.Og, "click", jSONObject);
            this.WV = true;
        }
    }

    public void safedk_ML_onPageFinished_ab78d8202be4b6f421e324defc76106b(WebView p0, String p1) {
        BSW bsw = this.JG;
        if (bsw != null) {
            bsw.pA(p0, p1, this.pA);
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZv = this.Wx;
        if (zZv != null) {
            zZv.Og(p0, p1, this.pA);
        }
        super.onPageFinished(p0, p1);
    }

    public void safedk_ML_onPageStarted_ee5a4c55ca5f72b6f34b0ad057c9da84(WebView p0, String p1, Bitmap p2) {
        yFO yfo;
        super.onPageStarted(p0, p1, p2);
        yFO yfo2 = this.yFO;
        int iPA = (yfo2 != null && yfo2.fN() && com.bytedance.sdk.openadsdk.vZF.pA.pA("opt_web_index", false)) ? gbA.pA(p0) : -1;
        new Object[]{"currentUrlIndex is:", Integer.valueOf(iPA)};
        BSW bsw = this.JG;
        if (bsw != null) {
            bsw.pA(p0, p1, p2, this.pA, iPA);
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZv = this.Wx;
        if (zZv != null) {
            zZv.KZx(p0, p1, this.pA);
        }
        if (this.pA && (yfo = this.yFO) != null && yfo.fN() && this.yFO.BSW().Og() >= 2) {
            if (!TextUtils.isEmpty(p1) && !p1.equals(this.Sn)) {
                if (this.DX.contains(p1)) {
                    while (!p1.equals(this.DX.peek())) {
                        this.DX.pop();
                    }
                } else {
                    this.DX.push(p1);
                }
            }
            this.Sn = p1;
        }
        new Object[]{"mNeedHardwareAcceleration:", Boolean.valueOf(this.omh), "hasSetHardwareAccelerate", Boolean.valueOf(this.Bzk)};
        if (!this.omh || this.Bzk) {
            return;
        }
        this.Bzk = true;
        KZx.pA(this.ZZv).pA(true).Og(p0.getSettings().getBuiltInZoomControls()).pA(p0);
    }

    public void safedk_ML_onReceivedError_699d4f0f9a7a9e035f5017848ca996c9(WebView p0, int p1, String p2, String p3) {
        super.onReceivedError(p0, p1, p2, p3);
    }

    public void safedk_ML_onReceivedError_75053c521aa41464504a9a258edbb5c4(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        super.onReceivedError(p0, p1, p2);
        if (this.JG == null || p2 == null) {
            return;
        }
        Uri url = p1.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = p1.getRequestHeaders();
        if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.JG.pA(p0, p2.getErrorCode(), String.valueOf(p2.getDescription()), string, str, p1 != null && p1.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.JG == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.JG.pA(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str, webResourceRequest != null && webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.JG != null) {
            int primaryError = 0;
            String strConcat = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    strConcat = "SslError: ".concat(String.valueOf(sslError));
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str = url;
            this.JG.pA(webView, primaryError, strConcat, str, ZZv(str), true);
        }
    }

    public boolean KZx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (POBCommonConstants.PLAY_STORE_DOMAIN.equals(uri.getHost())) {
                if (com.bytedance.sdk.openadsdk.core.model.aBv.omh(this.yFO) && this.XT == null && this.SGo == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.ZZv instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(uri);
                intent.setPackage("com.android.vending");
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.ZZv, intent);
                Og();
                this.XT = null;
                this.SGo = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        vZF = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    protected static String ZZv(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !vZF.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/".concat(String.valueOf(strSubstring));
    }

    private boolean pA(WebView webView, String str) {
        if (!gbA.ZZv(this.yFO) || this.yFO.BSW() == null || webView == null) {
            return false;
        }
        int iOg = this.yFO.BSW().Og();
        int size = this.DX.size();
        if (this.oX) {
            size++;
        }
        new Object[]{"boc_index is:", Integer.valueOf(iOg), "currentIndex is:", Integer.valueOf(size)};
        if (size + 1 != iOg) {
            return false;
        }
        vZF.pA(this.ZZv, str, this.yFO, com.bytedance.sdk.openadsdk.ZZv.Og.pA.ZZv);
        TTCeilingLandingPageActivity.pA pAVar = this.aBv;
        if (pAVar != null) {
            pAVar.pA();
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            com.bytedance.sdk.component.adexpress.ML.ML.pA().Og();
        } catch (Exception unused) {
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }
}
