package com.bytedance.sdk.component.Bzk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ML extends WebViewClient {
    private final List<String> KZx;
    private final pA.InterfaceC0186pA Og;
    private final WebViewClient pA;

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.u, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
        safedk_ML_onPageFinished_435473ab3d75fca1a5b87cd80cb9d2ed(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
        safedk_ML_onPageStarted_e19d779d3fcaf1baeb853132062eea09(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
        safedk_ML_onReceivedError_1840bde4c59d04d3c2df18699f36a76d(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
        safedk_ML_onReceivedError_e41404755e434744cb8917d662b7a9f2(webView, webResourceRequest, webResourceError);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, webView, webResourceRequest, safedk_ML_shouldInterceptRequest_eccc8be4803c1a59113453a8608e62f2(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_ML_shouldInterceptRequest_a31eadca43bd08715a84215a4f2e07ef(webView, str));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/component/Bzk/ML;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_ML_shouldOverrideUrlLoading_267367b658e2765dcb3fb363b86dfdbc = safedk_ML_shouldOverrideUrlLoading_267367b658e2765dcb3fb363b86dfdbc(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView, str, zSafedk_ML_shouldOverrideUrlLoading_267367b658e2765dcb3fb363b86dfdbc);
        return zSafedk_ML_shouldOverrideUrlLoading_267367b658e2765dcb3fb363b86dfdbc;
    }

    public ML(pA.InterfaceC0186pA interfaceC0186pA, WebViewClient webViewClient, List<String> list) {
        this.Og = interfaceC0186pA;
        this.pA = webViewClient;
        this.KZx = list;
    }

    public WebResourceResponse safedk_ML_shouldInterceptRequest_a31eadca43bd08715a84215a4f2e07ef(WebView p0, String p1) {
        return this.pA.shouldInterceptRequest(p0, p1);
    }

    public WebResourceResponse safedk_ML_shouldInterceptRequest_eccc8be4803c1a59113453a8608e62f2(WebView p0, WebResourceRequest p1) {
        pA.InterfaceC0186pA interfaceC0186pA;
        if (Og.pA(this.KZx, p1.getUrl().toString()) && (interfaceC0186pA = this.Og) != null) {
            interfaceC0186pA.pA();
        }
        return this.pA.shouldInterceptRequest(p0, p1);
    }

    public boolean safedk_ML_shouldOverrideUrlLoading_267367b658e2765dcb3fb363b86dfdbc(WebView p0, String p1) {
        pA.InterfaceC0186pA interfaceC0186pA = this.Og;
        if (interfaceC0186pA != null) {
            interfaceC0186pA.pA();
        }
        return this.pA.shouldOverrideUrlLoading(p0, p1);
    }

    public void safedk_ML_onPageFinished_435473ab3d75fca1a5b87cd80cb9d2ed(WebView p0, String p1) {
        this.pA.onPageFinished(p0, p1);
    }

    public void safedk_ML_onPageStarted_e19d779d3fcaf1baeb853132062eea09(WebView p0, String p1, Bitmap p2) {
        pA.InterfaceC0186pA interfaceC0186pA = this.Og;
        if (interfaceC0186pA != null) {
            interfaceC0186pA.pA(pA(p0));
        }
        this.pA.onPageStarted(p0, p1, p2);
    }

    public void safedk_ML_onReceivedError_e41404755e434744cb8917d662b7a9f2(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        this.pA.onReceivedError(p0, p1, p2);
    }

    public void safedk_ML_onReceivedError_1840bde4c59d04d3c2df18699f36a76d(WebView p0, int p1, String p2, String p3) {
        this.pA.onReceivedError(p0, p1, p2, p3);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.pA.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.pA.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.pA.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    private int pA(WebView webView) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                return webBackForwardListCopyBackForwardList.getCurrentIndex() + 1;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
