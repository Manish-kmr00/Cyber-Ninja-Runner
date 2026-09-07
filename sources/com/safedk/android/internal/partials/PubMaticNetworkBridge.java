package com.safedk.android.internal.partials;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;

/* JADX INFO: compiled from: PubMaticSourceFile */
/* JADX INFO: loaded from: classes11.dex */
public class PubMaticNetworkBridge {
    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.d("PubMaticNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/PubMaticNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + url + ", WebView address : " + targetInstance.toString() + "  SDK_PACKAGE_NAME = " + h.F);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(url) || url.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + url);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.F, targetInstance, url);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.F);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(url, (String) null, targetInstance, h.F);
                }
                SafeDKWebAppInterface.a(h.F, targetInstance, url, true);
            }
        }
        targetInstance.loadUrl(url);
    }

    public static void webviewLoadDataWithBaseURL(WebView targetInstance, String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        Logger.d("PubMaticNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/PubMaticNetworkBridge;->webviewLoadDataWithBaseURL(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            Logger.d("SafeDKNetwork", "webviewLoadDataWithBaseURL: " + baseUrl + ", WebView address : " + targetInstance.toString() + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = " + h.F);
            CreativeInfoManager.a(baseUrl, data, targetInstance, h.F);
            SafeDKWebAppInterface.a(h.F, targetInstance, data, true);
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.F);
        if (adNetworkDiscoveryI != null) {
            data = adNetworkDiscoveryI.a(targetInstance, baseUrl, data);
        }
        targetInstance.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    @SuppressLint({"AddJavascriptInterface", "JavascriptInterface"})
    public static void onAddedJavascriptInterface(WebView targetInstance, Object object, String name) {
        Logger.d("PubMaticNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/PubMaticNetworkBridge;->onAddedJavascriptInterface(Landroid/webkit/WebView;Ljava/lang/Object;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "onAddedJavascriptInterface invoked, WebView address: " + targetInstance + ", SDK_PACKAGE_NAME: " + h.F + " object is: " + object + " and name: " + name);
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.F);
        if (adNetworkDiscoveryI != null) {
            adNetworkDiscoveryI.a(targetInstance, object);
        }
        targetInstance.addJavascriptInterface(object, name);
    }
}
