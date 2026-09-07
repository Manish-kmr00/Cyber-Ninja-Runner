package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class no2 {
    private no2() {
    }

    public static void a(WebView webView) {
        a(webView, "finishSession", new Object[0]);
    }

    public static void b(WebView webView) {
        a(webView, "publishImpressionEvent", new Object[0]);
    }

    public static void a(WebView webView, float f) {
        a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    public static void b(WebView webView, JSONObject jSONObject) {
        a(webView, "publishLoadedEvent", jSONObject);
    }

    public static void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(webView, "publishMediaEvent", str, jSONObject);
        } else {
            a(webView, "publishMediaEvent", str);
        }
    }

    public static void b(WebView webView, String str) {
        a(webView, "setState", str);
    }

    public static void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    static void a(WebView webView, String str, Object... objArr) {
        String string;
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (objArr.length > 0) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        string = "\"\"";
                    } else {
                        if (obj instanceof String) {
                            string = obj.toString();
                            if (!string.startsWith("{")) {
                                sb.append('\"').append(string).append('\"');
                            }
                        } else {
                            sb.append(obj);
                        }
                        sb.append(StringUtils.COMMA);
                    }
                    sb.append(string);
                    sb.append(StringUtils.COMMA);
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append(")}");
            String string2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(string2);
            } else {
                handler.post(new mo2(webView, string2));
            }
        }
    }

    public static void a(WebView webView, JSONObject jSONObject) {
        a(webView, "init", jSONObject);
    }

    public static void a(WebView webView, String str) {
        a(webView, "setNativeViewHierarchy", str);
    }
}
