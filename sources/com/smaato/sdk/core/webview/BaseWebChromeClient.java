package com.smaato.sdk.core.webview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public class BaseWebChromeClient extends WebChromeClient {
    private WebChromeClientCallback webChromeClientCallback;

    public interface WebChromeClientCallback {
        void onProgressChanged(int i);
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.webChromeClientCallback = webChromeClientCallback;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, final int i) {
        Objects.onNotNull(this.webChromeClientCallback, new Consumer() { // from class: com.smaato.sdk.core.webview.BaseWebChromeClient$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BaseWebChromeClient.WebChromeClientCallback) obj).onProgressChanged(i);
            }
        });
    }
}
