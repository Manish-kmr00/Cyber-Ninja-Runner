package net.pubnative.lite.sdk.utils.browser;

import android.content.Intent;

/* JADX INFO: loaded from: classes13.dex */
public interface BrowserView {
    void closeBrowser();

    void hideProgressIndicator();

    void launchExternalBrowser(Intent intent);

    void redirectToExternalApp(Intent intent);

    void setPageNavigationBackEnabled(boolean z);

    void setPageNavigationForwardEnabled(boolean z);

    void showConnectionSecure(boolean z);

    void showHostname(String str);

    void showProgressIndicator();

    void updateProgressIndicator(int i);
}
