package net.pubnative.lite.sdk.utils.browser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class BaseWebViewClient extends WebViewClient {
    private static final String TAG = "net.pubnative.lite.sdk.utils.browser.BaseWebViewClient";
    private WebViewClientCallback webViewClientCallback;
    private final BrowserActivity.WebViewCloseListener webViewCloseListener;

    public interface WebViewClientCallback {
        void onGeneralError(int i, String str, String str2);

        void onHttpError(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

        void onPageFinishedLoading(String str);

        void onPageStartedLoading(String str);

        void onRenderProcessGone();

        boolean shouldOverrideUrlLoading(String str);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.C, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.C, webView, str);
        safedk_BaseWebViewClient_onPageFinished_1237b696d8185ea92e8aeee621038456(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(h.C, webView, str);
        safedk_BaseWebViewClient_onPageStarted_dbd9b983bb0a7bdcfcabf7701d757611(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.C, webView, i, str, str2);
        safedk_BaseWebViewClient_onReceivedError_c4b40af0830a4d4b18e7d115318a5d54(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.C, webView, webResourceRequest, webResourceError);
        safedk_BaseWebViewClient_onReceivedError_c750cd823b853d0907b2f463495b09b8(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
        return CreativeInfoManager.onWebViewResponseWithHeaders(h.C, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_1246a67e7c5ff87fdaf5db4c4ca2cb84 = safedk_BaseWebViewClient_shouldOverrideUrlLoading_1246a67e7c5ff87fdaf5db4c4ca2cb84(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.C, webView, webResourceRequest, zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_1246a67e7c5ff87fdaf5db4c4ca2cb84);
        return zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_1246a67e7c5ff87fdaf5db4c4ca2cb84;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/utils/browser/BaseWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_0e0e5b17f6d0330f63838b591ccd4816 = safedk_BaseWebViewClient_shouldOverrideUrlLoading_0e0e5b17f6d0330f63838b591ccd4816(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.C, webView, str, zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_0e0e5b17f6d0330f63838b591ccd4816);
        return zSafedk_BaseWebViewClient_shouldOverrideUrlLoading_0e0e5b17f6d0330f63838b591ccd4816;
    }

    public BaseWebViewClient(BrowserActivity.WebViewCloseListener webViewCloseListener) {
        this.webViewCloseListener = webViewCloseListener;
    }

    public void setWebViewClientCallback(WebViewClientCallback webViewClientCallback) {
        this.webViewClientCallback = webViewClientCallback;
    }

    public void safedk_BaseWebViewClient_onPageStarted_dbd9b983bb0a7bdcfcabf7701d757611(WebView p0, String p1, Bitmap p2) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageStartedLoading(p1);
        }
    }

    public void safedk_BaseWebViewClient_onPageFinished_1237b696d8185ea92e8aeee621038456(WebView p0, String p1) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageFinishedLoading(p1);
        }
    }

    public boolean safedk_BaseWebViewClient_shouldOverrideUrlLoading_0e0e5b17f6d0330f63838b591ccd4816(WebView p0, String p1) {
        return shouldOverrideUrlLoadingInternal(p1);
    }

    public boolean safedk_BaseWebViewClient_shouldOverrideUrlLoading_1246a67e7c5ff87fdaf5db4c4ca2cb84(WebView p0, WebResourceRequest p1) {
        BrowserActivity.WebViewCloseListener webViewCloseListener;
        BrowserActivity.WebViewCloseListener webViewCloseListener2;
        Uri uri = Uri.parse(p1.getUrl().toString());
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String lowerCase = uri.toString().toLowerCase(Locale.ROOT);
        if (SDKConstants.PARAM_INTENT.equalsIgnoreCase(scheme)) {
            return true;
        }
        if (POBCommonConstants.PLAY_STORE_DOMAIN.equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host) || ApsAdWebViewSupportClient.MARKET_SCHEME.equalsIgnoreCase(scheme) || lowerCase.startsWith(POBCommonConstants.PLAY_STORE_DOMAIN) || lowerCase.startsWith("market.android.com/")) {
            String queryParameter = uri.getQueryParameter("id");
            if (queryParameter != null) {
                boolean zForceHandleDeepLink = forceHandleDeepLink(Uri.parse("market://details?id=" + queryParameter), p0);
                if (zForceHandleDeepLink && (webViewCloseListener = this.webViewCloseListener) != null) {
                    webViewCloseListener.onWebViewCloseRequested();
                }
                return zForceHandleDeepLink;
            }
            return forceHandleDeepLink(uri, p0);
        }
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return shouldOverrideUrlLoadingInternal(p1.getUrl().toString());
        }
        if (forceHandleDeepLink(uri, p0) && (webViewCloseListener2 = this.webViewCloseListener) != null) {
            webViewCloseListener2.onWebViewCloseRequested();
        }
        return true;
    }

    private boolean shouldOverrideUrlLoadingInternal(String str) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback == null) {
            return false;
        }
        return webViewClientCallback.shouldOverrideUrlLoading(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback != null) {
            webViewClientCallback.onHttpError(webResourceRequest, webResourceResponse);
        }
    }

    public void safedk_BaseWebViewClient_onReceivedError_c4b40af0830a4d4b18e7d115318a5d54(WebView p0, int p1, String p2, String p3) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback != null) {
            webViewClientCallback.onGeneralError(p1, p2, p3);
        }
    }

    public void safedk_BaseWebViewClient_onReceivedError_c750cd823b853d0907b2f463495b09b8(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback != null) {
            webViewClientCallback.onGeneralError(p2.getErrorCode(), p2.getDescription().toString(), p1.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        WebViewClientCallback webViewClientCallback = this.webViewClientCallback;
        if (webViewClientCallback == null) {
            return false;
        }
        webViewClientCallback.onRenderProcessGone();
        return true;
    }

    public boolean forceHandleDeepLink(Uri uri, WebView webView) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(webView.getContext(), intent);
            return true;
        } catch (RuntimeException e) {
            net.pubnative.lite.sdk.utils.Logger.e(TAG, e.getMessage());
            return false;
        }
    }
}
