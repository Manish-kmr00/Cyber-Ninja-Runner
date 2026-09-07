package com.bytedance.sdk.component.pA;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.safedk.android.internal.partials.PangleNetworkBridge;

/* JADX INFO: loaded from: classes9.dex */
public class du extends pA {
    static final /* synthetic */ boolean SGo = true;
    protected WebView Bzk;
    protected String omh;

    @Override // com.bytedance.sdk.component.pA.pA
    protected Context pA(SGo sGo) {
        if (sGo.ML != null) {
            return sGo.ML;
        }
        if (sGo.pA != null) {
            return sGo.pA.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.pA.pA
    protected String pA() {
        return this.Bzk.getUrl();
    }

    @Override // com.bytedance.sdk.component.pA.pA
    protected void Og(SGo sGo) {
        this.Bzk = sGo.pA;
        this.omh = sGo.KZx;
        if (sGo.Sn) {
            return;
        }
        KZx();
    }

    protected void KZx() {
        if (!SGo && this.Bzk == null) {
            throw new AssertionError();
        }
        PangleNetworkBridge.onAddedJavascriptInterface(this.Bzk, this, this.omh);
    }

    @Override // com.bytedance.sdk.component.pA.pA
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.pA.pA
    protected void Og() {
        super.Og();
        ZZv();
    }

    protected void ZZv() {
        this.Bzk.removeJavascriptInterface(this.omh);
    }

    @Override // com.bytedance.sdk.component.pA.pA
    protected void pA(String str, oX oXVar) {
        if (oXVar != null && !TextUtils.isEmpty(oXVar.omh)) {
            String str2 = oXVar.omh;
            pA(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.pA(str, oXVar);
    }

    @Override // com.bytedance.sdk.component.pA.pA
    protected void pA(String str) {
        pA(str, "javascript:" + this.omh + "._handleMessageFromToutiao(" + str + ")");
    }

    private void pA(String str, final String str2) {
        if (this.JG || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.pA.du.1
            @Override // java.lang.Runnable
            public void run() {
                if (du.this.JG) {
                    return;
                }
                try {
                    du.this.Bzk.evaluateJavascript(str2, null);
                } catch (Throwable unused) {
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.ZZv.post(runnable);
        } else {
            runnable.run();
        }
    }
}
