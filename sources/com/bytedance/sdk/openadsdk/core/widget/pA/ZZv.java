package com.bytedance.sdk.openadsdk.core.widget.pA;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.utils.aBv;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv extends WebChromeClient {
    private static final String pA = WebChromeClient.class.getSimpleName();
    private BSW KZx;
    private final IG Og;
    private com.bytedance.sdk.openadsdk.common.ZZv ZZv;

    public ZZv(IG ig) {
        this.Og = ig;
    }

    public ZZv(IG ig, BSW bsw, com.bytedance.sdk.openadsdk.common.ZZv zZv) {
        this(ig, bsw);
        this.ZZv = zZv;
    }

    public ZZv(IG ig, BSW bsw) {
        this.Og = ig;
        this.KZx = bsw;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            pA(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !pA(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean pA(final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.regionMatches(true, 0, "bytedance:", 0, "bytedance:".length())) {
                Sn.KZx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.pA.ZZv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aBv.pA(Uri.parse(str), ZZv.this.Og);
                    }
                });
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        BSW bsw = this.KZx;
        if (bsw != null) {
            bsw.pA(webView, i);
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZv = this.ZZv;
        if (zZv != null) {
            zZv.pA(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
