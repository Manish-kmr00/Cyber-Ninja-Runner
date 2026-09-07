package net.pubnative.lite.sdk.utils.browser;

import android.webkit.CookieManager;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes8.dex */
public class BrowserCookieManager {
    private final CookieManager cookieManager;

    public BrowserCookieManager(CookieManager cookieManager) {
        if (cookieManager == null) {
            throw new NullPointerException("CookieManager can not be null");
        }
        this.cookieManager = cookieManager;
    }

    public void setupCookiePolicy(WebView webView) {
        if (webView == null) {
            throw new NullPointerException("WebView can not be null");
        }
        this.cookieManager.setAcceptThirdPartyCookies(webView, true);
    }
}
