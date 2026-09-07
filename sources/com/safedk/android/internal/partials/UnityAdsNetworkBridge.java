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
import com.safedk.android.utils.n;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: UnityAdsSourceFile */
/* JADX INFO: loaded from: classes8.dex */
public class UnityAdsNetworkBridge {
    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + url + ", WebView address : " + targetInstance.toString() + "  SDK_PACKAGE_NAME = com.unity3d.ads");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(url) || url.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + url);
            } else {
                NetworkBridge.logWebviewLoadURLRequest("com.unity3d.ads", targetInstance, url);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i("com.unity3d.ads");
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(url, (String) null, targetInstance, "com.unity3d.ads");
                }
                SafeDKWebAppInterface.a("com.unity3d.ads", targetInstance, url, true);
            }
        }
        targetInstance.loadUrl(url);
    }

    public static void webviewLoadDataWithBaseURL(WebView targetInstance, String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->webviewLoadDataWithBaseURL(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            Logger.d("SafeDKNetwork", "webviewLoadDataWithBaseURL: " + baseUrl + ", WebView address : " + targetInstance.toString() + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = com.unity3d.ads");
            CreativeInfoManager.a(baseUrl, data, targetInstance, "com.unity3d.ads");
            SafeDKWebAppInterface.a("com.unity3d.ads", targetInstance, data, true);
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i("com.unity3d.ads");
        if (adNetworkDiscoveryI != null) {
            data = adNetworkDiscoveryI.a(targetInstance, baseUrl, data);
        }
        targetInstance.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    public static void webviewLoadData(WebView targetInstance, String data, String mimeType, String encoding) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->webviewLoadData(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        boolean z = SafeDK.getInstance() != null && SafeDK.getInstance().p();
        Logger.d("SafeDKNetwork", "webviewLoadData invoked, WebView address : " + targetInstance + ", isSafeDKInitialized = " + z + ", SDK_PACKAGE_NAME = com.unity3d.ads");
        if (z) {
            CreativeInfoManager.a((String) null, data, targetInstance, "com.unity3d.ads");
            SafeDKWebAppInterface.a("com.unity3d.ads", targetInstance, data, true);
        }
        targetInstance.loadData(data, mimeType, encoding);
    }

    @SuppressLint({"AddJavascriptInterface", "JavascriptInterface"})
    public static void onAddedJavascriptInterface(WebView targetInstance, Object object, String name) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->onAddedJavascriptInterface(Landroid/webkit/WebView;Ljava/lang/Object;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "onAddedJavascriptInterface invoked, WebView address: " + targetInstance + ", SDK_PACKAGE_NAME: com.unity3d.ads object is: " + object + " and name: " + name);
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i("com.unity3d.ads");
        if (adNetworkDiscoveryI != null) {
            adNetworkDiscoveryI.a(targetInstance, object);
        }
        targetInstance.addJavascriptInterface(object, name);
    }

    public static void okhttp3CallEnqueue(Call targetInstance, Callback responseCallback) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->okhttp3CallEnqueue(Lokhttp3/Call;Lokhttp3/Callback;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                Request request = targetInstance.request();
                int iIdentityHashCode = System.identityHashCode(request);
                String string = request.url().getUrl();
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
                if (requestInfo == null) {
                    requestInfo = new NetworkBridge.RequestInfo("com.unity3d.ads", string);
                } else {
                    requestInfo.a(string);
                }
                NetworkBridge.d.put(Integer.valueOf(iIdentityHashCode), requestInfo);
                Logger.d("SafeDKNetwork", "retrofitokhttp3Call_enqueue request id:" + iIdentityHashCode + ", RequestInfo:" + requestInfo + ", isOnUiThread = " + n.c());
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "retrofit|okhttp3.Call enqueue error " + th.getMessage());
            }
        }
        targetInstance.enqueue(responseCallback);
    }

    public static ResponseBody okhttp3Response_body(Response targetInstance) {
        Logger.d("UnityAdsNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/UnityAdsNetworkBridge;->okhttp3Response_body(Lokhttp3/Response;)Lokhttp3/ResponseBody;");
        ResponseBody responseBodyBody = targetInstance.body();
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                int iIdentityHashCode = System.identityHashCode(targetInstance);
                NetworkBridge.RequestInfo requestInfoRemove = NetworkBridge.d.remove(Integer.valueOf(iIdentityHashCode));
                Logger.d("SafeDKNetwork", "retrofitokhttp3Response_body response id " + iIdentityHashCode + ", info " + requestInfoRemove + ", isOnUiThread = " + n.c());
                if (requestInfoRemove != null) {
                    int iIdentityHashCode2 = System.identityHashCode(responseBodyBody);
                    NetworkBridge.d.put(Integer.valueOf(iIdentityHashCode2), requestInfoRemove);
                    Logger.d("SafeDKNetwork", "retrofitokhttp3Response_body, removing response Id:" + iIdentityHashCode + ", adding  responseBodyId:" + iIdentityHashCode2 + ", RequestInfo:" + requestInfoRemove);
                } else {
                    Logger.d("SafeDKNetwork", "retrofitokhttp3Response_body, skipping response Id:" + iIdentityHashCode);
                }
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "retrofitokhttp3Response_body error " + th.getMessage());
            }
        }
        return responseBodyBody;
    }
}
