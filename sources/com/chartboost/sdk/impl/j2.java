package com.chartboost.sdk.impl;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010)\u001a\u00020&\u0012\b\u0010-\u001a\u0004\u0018\u00010*¢\u0006\u0004\b6\u00107J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJA\u0010\u0011\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010#R\u0014\u0010%\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/chartboost/sdk/impl/j2;", "Landroid/webkit/WebChromeClient;", "Lcom/chartboost/sdk/impl/xb$a;", "Lcom/chartboost/sdk/impl/n5;", "Landroid/webkit/ConsoleMessage;", "cm", "", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Landroid/webkit/WebView;", "view", "", "url", "message", "defaultValue", "Landroid/webkit/JsPromptResult;", "result", "onJsPrompt", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "", "onShowCustomView", "(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "", "requestedOrientation", "(Landroid/view/View;ILandroid/webkit/WebChromeClient$CustomViewCallback;)V", "onHideCustomView", "()V", "Lorg/json/JSONObject;", "data", "a", "(Lorg/json/JSONObject;)V", "consoleMsg", "(Ljava/lang/String;)V", "Landroid/view/View;", "activityNonVideoView", "Lcom/chartboost/sdk/impl/g7;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/g7;", "cmd", "Lcom/chartboost/sdk/impl/xb;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/xb;", "corsHandler", "<set-?>", "d", "Z", "isVideoFullscreen", "()Z", "e", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "videoViewCallback", "<init>", "(Landroid/view/View;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/xb;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class j2 extends WebChromeClient implements xb.a, n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View activityNonVideoView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final g7 cmd;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final xb corsHandler;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean isVideoFullscreen;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public WebChromeClient.CustomViewCallback videoViewCallback;

    public j2(View activityNonVideoView, g7 cmd, xb xbVar) {
        Intrinsics.checkNotNullParameter(activityNonVideoView, "activityNonVideoView");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        this.activityNonVideoView = activityNonVideoView;
        this.cmd = cmd;
        this.corsHandler = xbVar;
        cmd.a(this);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage cm) {
        Logger.d("Chartboost|SafeDK: Execution> Lcom/chartboost/sdk/impl/j2;->onConsoleMessage(Landroid/webkit/ConsoleMessage;)Z");
        BrandSafetyUtils.handleOnConsoleMessage(com.safedk.android.utils.h.c, this, cm);
        return safedk_j2_onConsoleMessage_beeeb5a6032e4b6d4f507e688334a3b9(cm);
    }

    public boolean safedk_j2_onConsoleMessage_beeeb5a6032e4b6d4f507e688334a3b9(ConsoleMessage cm) {
        Intrinsics.checkNotNullParameter(cm, "cm");
        String consoleMsg = cm.message();
        b7.a("Chartboost Rich Webview: " + consoleMsg + " -- From line " + cm.lineNumber() + " of " + cm.sourceId(), (Throwable) null, 2, (Object) null);
        Intrinsics.checkNotNullExpressionValue(consoleMsg, "consoleMsg");
        a(consoleMsg);
        return true;
    }

    public final void a(String consoleMsg) {
        xb xbVar = this.corsHandler;
        if (xbVar != null) {
            xbVar.a(consoleMsg, this);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        if (message == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(message);
            String string = jSONObject.getString("eventType");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"eventType\")");
            JSONObject jSONObject2 = jSONObject.getJSONObject("eventArgs");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObj.getJSONObject(\"eventArgs\")");
            String strA = this.cmd.a(jSONObject2, string);
            if (result != null) {
                result.confirm(strA);
            }
            return true;
        } catch (JSONException unused) {
            b7.b("Exception caught parsing the function name from js to native", null, 2, null);
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
        onShowCustomView(view, callback);
    }

    @Override // android.webkit.WebChromeClient, com.chartboost.sdk.impl.n5
    public void onHideCustomView() {
        WebChromeClient.CustomViewCallback customViewCallback;
        if (this.isVideoFullscreen) {
            this.activityNonVideoView.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback2 = this.videoViewCallback;
            if (customViewCallback2 != null && !StringsKt.contains$default((CharSequence) customViewCallback2.getClass().getName(), (CharSequence) ".chromium.", false, 2, (Object) null) && (customViewCallback = this.videoViewCallback) != null) {
                customViewCallback.onCustomViewHidden();
            }
            this.isVideoFullscreen = false;
            this.videoViewCallback = null;
        }
    }

    @Override // com.chartboost.sdk.impl.xb.a
    public void a(JSONObject data) {
        this.cmd.a(data, h7.ERROR.getCmdName());
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        if (view instanceof FrameLayout) {
            this.isVideoFullscreen = true;
            this.videoViewCallback = callback;
            this.activityNonVideoView.setVisibility(4);
        }
    }
}
