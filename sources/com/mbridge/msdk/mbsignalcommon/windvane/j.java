package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;

/* JADX INFO: compiled from: WindVaneWebViewChromeClient.java */
/* JADX INFO: loaded from: classes12.dex */
public class j extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WindVaneWebView f5266a;
    private c b;

    public j(WindVaneWebView windVaneWebView) {
        this.f5266a = windVaneWebView;
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/windvane/j;->onConsoleMessage(Landroid/webkit/ConsoleMessage;)Z");
        BrandSafetyUtils.handleOnConsoleMessage(com.safedk.android.utils.h.o, this, consoleMessage);
        return safedk_j_onConsoleMessage_2a78eb38f9691cfcd036c779820663d4(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/windvane/j;->onJsPrompt(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z");
        BrandSafetyUtils.handleOnJsPrompt(webView, str, str2, str3, jsPromptResult);
        return safedk_j_onJsPrompt_1f91133c40dbc764658d43cc9c9d09cd(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        c cVar = this.b;
        if (cVar != null) {
            cVar.c(webView, i);
        }
    }

    public boolean safedk_j_onConsoleMessage_2a78eb38f9691cfcd036c779820663d4(ConsoleMessage p0) {
        if (p0.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(p0);
        }
        b signalCommunication = this.f5266a.getSignalCommunication();
        if (signalCommunication != null) {
            String strMessage = p0.message();
            if (TextUtils.isEmpty(strMessage) || !strMessage.startsWith("mv://")) {
                return false;
            }
            o0.a("H5_ENTRY", "onConsoleMessage: message.length() = " + strMessage.length() + " " + strMessage);
            if (strMessage.contains("wv_hybrid:") && signalCommunication.b("wv_hybrid:")) {
                String strSubstring = strMessage.substring(0, strMessage.lastIndexOf(" ") + 1);
                o0.a("H5_ENTRY", "message = " + strSubstring);
                signalCommunication.a(strSubstring);
                return true;
            }
        }
        return super.onConsoleMessage(p0);
    }

    public boolean safedk_j_onJsPrompt_1f91133c40dbc764658d43cc9c9d09cd(WebView p0, String p1, String p2, String p3, JsPromptResult p4) {
        o0.b("H5_ENTRY", p2 + "");
        b signalCommunication = this.f5266a.getSignalCommunication();
        if (signalCommunication == null || p3 == null || !signalCommunication.b(p3)) {
            return false;
        }
        signalCommunication.a(p2);
        p4.confirm("");
        return true;
    }
}
