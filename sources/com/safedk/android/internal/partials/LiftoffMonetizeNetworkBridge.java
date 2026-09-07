package com.safedk.android.internal.partials;

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
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: LiftoffMonetizeSourceFile */
/* JADX INFO: loaded from: classes9.dex */
public class LiftoffMonetizeNetworkBridge {
    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.d("LiftoffMonetizeNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/LiftoffMonetizeNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + url + ", WebView address : " + targetInstance.toString() + "  SDK_PACKAGE_NAME = " + h.d);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(url) || url.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + url);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.d, targetInstance, url);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.d);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(url, (String) null, targetInstance, h.d);
                }
                SafeDKWebAppInterface.a(h.d, targetInstance, url, true);
            }
        }
        targetInstance.loadUrl(url);
    }

    public static Response okhttp3CallExecute(Call targetInstance) throws IOException {
        Logger.d("LiftoffMonetizeNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/LiftoffMonetizeNetworkBridge;->okhttp3CallExecute(Lokhttp3/Call;)Lokhttp3/Response;");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                Request request = targetInstance.request();
                int iIdentityHashCode = System.identityHashCode(request);
                String url = request.url().getUrl();
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
                if (requestInfo == null) {
                    requestInfo = new NetworkBridge.RequestInfo(h.d, url);
                } else {
                    requestInfo.a(url);
                }
                NetworkBridge.d.put(Integer.valueOf(iIdentityHashCode), requestInfo);
                Logger.d("SafeDKNetwork", "retrofitCall_execute request id:" + iIdentityHashCode + ", RequestInfo:" + requestInfo + ", isOnUiThread = " + n.c());
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "retrofit|okhttp3 okhttp3.Call execute error " + th.getMessage());
            }
        }
        return targetInstance.execute();
    }

    public static void okhttp3CallEnqueue(Call targetInstance, Callback responseCallback) {
        Logger.d("LiftoffMonetizeNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/LiftoffMonetizeNetworkBridge;->okhttp3CallEnqueue(Lokhttp3/Call;Lokhttp3/Callback;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                Request request = targetInstance.request();
                int iIdentityHashCode = System.identityHashCode(request);
                String url = request.url().getUrl();
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
                if (requestInfo == null) {
                    requestInfo = new NetworkBridge.RequestInfo(h.d, url);
                } else {
                    requestInfo.a(url);
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
        Logger.d("LiftoffMonetizeNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/LiftoffMonetizeNetworkBridge;->okhttp3Response_body(Lokhttp3/Response;)Lokhttp3/ResponseBody;");
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

    public static BufferedSource retrofitExceptionCatchingRequestBody_source(ResponseBody targetInstance) {
        Logger.d("LiftoffMonetizeNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/LiftoffMonetizeNetworkBridge;->retrofitExceptionCatchingRequestBody_source(Lokhttp3/ResponseBody;)Lokio/BufferedSource;");
        BufferedSource bufferedSourceSource = targetInstance.getBodySource();
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                int iIdentityHashCode = System.identityHashCode(targetInstance);
                Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source bodyId " + iIdentityHashCode + " retroReq " + NetworkBridge.d + ", isOnUiThread = " + n.c());
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(iIdentityHashCode));
                if (requestInfo != null) {
                    bufferedSourceSource = CreativeInfoManager.a(requestInfo.a(), requestInfo.b(), bufferedSourceSource, iIdentityHashCode);
                    Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source found responseBodyId:" + iIdentityHashCode + ", RequestInfo:" + requestInfo + ", returning Source: " + bufferedSourceSource);
                }
                return bufferedSourceSource;
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "retrofit|retrofitExceptionCatchingRequestBody_source error " + th.getMessage());
                return bufferedSourceSource;
            }
        }
        return bufferedSourceSource;
    }
}
