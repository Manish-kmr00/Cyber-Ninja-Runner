package net.pubnative.lite.sdk.utils.browser;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes10.dex */
public class BaseWebChromeClient extends WebChromeClient {
    private WebChromeClientCallback webChromeClientCallback;

    public interface WebChromeClientCallback {
        void onProgressChanged(int i);
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.webChromeClientCallback = webChromeClientCallback;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        WebChromeClientCallback webChromeClientCallback = this.webChromeClientCallback;
        if (webChromeClientCallback != null) {
            webChromeClientCallback.onProgressChanged(i);
        }
    }
}
