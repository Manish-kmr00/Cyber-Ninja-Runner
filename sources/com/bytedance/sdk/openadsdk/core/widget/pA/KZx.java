package com.bytedance.sdk.openadsdk.core.widget.pA;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.WV;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class KZx {
    private final WeakReference<Context> pA;
    private boolean Og = true;
    private final boolean KZx = true;
    private final boolean ZZv = true;
    private final boolean ML = false;
    private final boolean JG = true;
    private boolean SD = true;

    public static KZx pA(Context context) {
        return new KZx(context);
    }

    private KZx(Context context) {
        this.pA = new WeakReference<>(context);
    }

    public KZx pA(boolean z) {
        this.SD = z;
        return this;
    }

    public KZx Og(boolean z) {
        this.Og = z;
        return this;
    }

    public void pA(WebView webView) {
        if (webView == null || this.pA.get() == null) {
            return;
        }
        Og(webView);
        WebSettings settings = webView.getSettings();
        pA(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            WV.pA("SSWebSettings", e.getMessage());
        }
        try {
            if (this.Og) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            WV.pA("SSWebSettings", th.getMessage());
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(false);
        try {
            if (this.SD) {
                webView.setLayerType(2, null);
            } else {
                webView.setLayerType(0, null);
            }
        } catch (Throwable th2) {
            WV.pA("SSWebSettings", th2.getMessage());
        }
    }

    public static void Og(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            WV.Og(th.toString());
        }
    }

    private void pA(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            WV.Og(th.toString());
        }
    }

    public static void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("clear_web_cache_new", 0);
        if (iPA == 0) {
            zZv.pA(true);
        } else if (iPA == 1) {
            zZv.pA(false);
        }
    }
}
