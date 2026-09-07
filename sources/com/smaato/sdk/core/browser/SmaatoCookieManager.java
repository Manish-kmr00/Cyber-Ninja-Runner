package com.smaato.sdk.core.browser;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public class SmaatoCookieManager {
    private final CookieManager cookieManager;
    private final CookieSyncManagerHolder cookieSyncManagerHolder;

    public void startSync() {
    }

    public void stopSync() {
    }

    public SmaatoCookieManager(CookieManager cookieManager, CookieSyncManagerHolder cookieSyncManagerHolder) {
        this.cookieManager = (CookieManager) Objects.requireNonNull(cookieManager, "Parameter cookieManager cannot be null for SmaatoCookieManager::new");
        this.cookieSyncManagerHolder = (CookieSyncManagerHolder) Objects.requireNonNull(cookieSyncManagerHolder, "Parameter cookieSyncManagerHolder cannot be null for SmaatoCookieManager::new");
    }

    public void setupCookiePolicy(WebView webView) {
        Objects.requireNonNull(webView, "Parameter webView cannot be null for SmaatoCookieManager::setupCookiePolicy");
        this.cookieManager.setAcceptThirdPartyCookies(webView, true);
    }

    public void forceCookieSync() {
        this.cookieManager.flush();
    }

    private void callOnCookieSyncManager(Consumer consumer) {
        CookieSyncManager cookieSyncManager = this.cookieSyncManagerHolder.getCookieSyncManager();
        if (cookieSyncManager == null) {
            throw new IllegalStateException("CookieSyncManager is expected to be present on API < 21");
        }
        consumer.accept(cookieSyncManager);
    }
}
