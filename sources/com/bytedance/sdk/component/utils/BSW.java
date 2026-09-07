package com.bytedance.sdk.component.utils;

import android.webkit.WebView;
import com.safedk.android.internal.partials.PangleNetworkBridge;

/* JADX INFO: loaded from: classes5.dex */
public class BSW {
    private static final pA pA = new Og();

    private static class pA {
        private pA() {
        }

        public void pA(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                PangleNetworkBridge.webviewLoadUrl(webView, str);
            } catch (Throwable unused) {
            }
        }
    }

    private static class Og extends pA {
        private Og() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.BSW.pA
        public void pA(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th) {
                    boolean z = th instanceof IllegalStateException;
                }
            }
            try {
                PangleNetworkBridge.webviewLoadUrl(webView, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void pA(WebView webView, String str) {
        pA.pA(webView, str);
    }
}
