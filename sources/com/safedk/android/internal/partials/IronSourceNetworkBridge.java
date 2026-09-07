package com.safedk.android.internal.partials;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.internal.f;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceSourceFile */
/* JADX INFO: loaded from: classes9.dex */
public class IronSourceNetworkBridge {
    public static InputStream urlConnectionGetInputStream(URLConnection targetInstance) throws IOException {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->urlConnectionGetInputStream(Ljava/net/URLConnection;)Ljava/io/InputStream;");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            String string = targetInstance.getURL().toString();
            Logger.d("SafeDKNetwork", "urlConnectionGetInputStream : " + string + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME =  " + h.f);
            Map<String, List<String>> headerFields = targetInstance.getHeaderFields();
            InputStream inputStream = null;
            try {
                inputStream = targetInstance.getInputStream();
            } catch (Throwable th) {
                Logger.d("SafeDKNetwork", "Exception in urlConnectionGetInputStream : " + th.getMessage());
            }
            InputStream inputStreamA = CreativeInfoManager.a(h.f, string, inputStream, headerFields);
            if ((targetInstance instanceof HttpURLConnection) && (inputStreamA instanceof f)) {
                Logger.d("SafeDKNetwork", "following HttpURLConnection:" + targetInstance + " and stream: " + inputStreamA);
                f fVar = (f) inputStreamA;
                HttpURLConnection httpURLConnection = (HttpURLConnection) targetInstance;
                NetworkBridge.b.put(httpURLConnection, fVar);
                fVar.a(httpURLConnection);
                return inputStreamA;
            }
            return inputStreamA;
        }
        return targetInstance.getInputStream();
    }

    public static OutputStream urlConnectionGetOutputStream(URLConnection targetInstance) throws IOException {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->urlConnectionGetOutputStream(Ljava/net/URLConnection;)Ljava/io/OutputStream;");
        if (SafeDK.getInstance() == null || !SafeDK.getInstance().p()) {
            return targetInstance.getOutputStream();
        }
        OutputStream outputStream = targetInstance.getOutputStream();
        String string = targetInstance.getURL().toString();
        Logger.d("SafeDKNetwork", "urlConnectionGetOutputStream url=" + string + ", isOnUiThread = " + n.c() + ", SDK_PACKAGE_NAME = " + h.f);
        return CreativeInfoManager.a(h.f, string, outputStream);
    }

    public static int httpUrlConnectionGetResponseCode(HttpURLConnection targetInstance) throws IOException {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->httpUrlConnectionGetResponseCode(Ljava/net/HttpURLConnection;)I");
        int responseCode = targetInstance.getResponseCode();
        String string = (targetInstance == null || targetInstance.getURL() == null) ? null : targetInstance.getURL().toString();
        Logger.d("SafeDKNetwork", "httpUrlConnectionGetResponseCode - sdk=, response code= " + responseCode + ", url= " + string);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p() && responseCode >= 200 && responseCode < 300 && CreativeInfoManager.a(h.f, AdNetworkConfiguration.USE_INPUT_STREAM_EVENT_AS_RESOURCE_LOADED_INDICATION, false)) {
            CreativeInfoManager.onResourceLoaded(h.f, null, string);
        }
        return responseCode;
    }

    public static void httpUrlConnectionDisconnect(HttpURLConnection targetInstance) {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->httpUrlConnectionDisconnect(Ljava/net/HttpURLConnection;)V");
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            try {
                Logger.d("SafeDKNetwork", "httpUrlConnectionDisconnect, isOnUiThread = " + n.c());
                f fVarRemove = NetworkBridge.b.remove(targetInstance);
                if (fVarRemove != null) {
                    fVarRemove.a();
                }
            } catch (Throwable th) {
            }
        }
        targetInstance.disconnect();
    }

    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + url + ", WebView address : " + targetInstance.toString() + "  SDK_PACKAGE_NAME = " + h.f);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(url) || url.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + url);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.f, targetInstance, url);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.f);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(url, (String) null, targetInstance, h.f);
                }
                SafeDKWebAppInterface.a(h.f, targetInstance, url, true);
            }
        }
        targetInstance.loadUrl(url);
    }

    @SuppressLint({"AddJavascriptInterface", "JavascriptInterface"})
    public static void onAddedJavascriptInterface(WebView targetInstance, Object object, String name) {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->onAddedJavascriptInterface(Landroid/webkit/WebView;Ljava/lang/Object;Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "onAddedJavascriptInterface invoked, WebView address: " + targetInstance + ", SDK_PACKAGE_NAME: " + h.f + " object is: " + object + " and name: " + name);
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.f);
        if (adNetworkDiscoveryI != null) {
            adNetworkDiscoveryI.a(targetInstance, object);
        }
        targetInstance.addJavascriptInterface(object, name);
    }

    public static void webViewEvaluateJavaScript(WebView webView, String script, ValueCallback<String> resultCallback) {
        String strV;
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->webViewEvaluateJavaScript(Landroid/webkit/WebView;Ljava/lang/String;Landroid/webkit/ValueCallback;)V");
        webView.evaluateJavascript(script, resultCallback);
        try {
            String mainSdkPackage = SdksMapping.getMainSdkPackage(h.f);
            n.b("SafeDKNetwork", "on evaluate javascript with package name: " + mainSdkPackage + " view: " + webView + " and script: \n" + script);
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(mainSdkPackage);
            if (adNetworkDiscoveryI != null && (strV = adNetworkDiscoveryI.v(script)) != null) {
                Logger.d("SafeDKNetwork", "evaluate JS - the ad id found is: " + strV);
                adNetworkDiscoveryI.a(webView, strV);
            }
        } catch (Throwable th) {
            Logger.d("SafeDKNetwork", "exception in evaluate JS: " + th.getMessage(), th);
        }
    }

    public static JSONObject jsonObjectInit() {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->jsonObjectInit()Lorg/json/JSONObject;");
        return new JSONObject();
    }

    public static JSONObject jsonObjectInit(String message) throws JSONException {
        Logger.d("IronSourceNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/IronSourceNetworkBridge;->jsonObjectInit(Ljava/lang/String;)Lorg/json/JSONObject;");
        String message2 = CreativeInfoManager.d(h.f, message);
        if (message2 != null) {
            message = message2;
        }
        if (SafeDK.ae()) {
            CreativeInfoManager.c(h.f, message);
        }
        return new JSONObject(message);
    }
}
