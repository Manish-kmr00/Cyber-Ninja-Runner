package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebViewBridgeInterface.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007J.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;", "", "webViewBridge", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "webViewAppInvocationCallbackInvoker", "Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V", "handleCallback", "", "callbackId", "", "callbackStatus", "rawParameters", "handleInvocation", "data", "onHandleCallback", "view", "Landroid/webkit/WebView;", "message", "Landroidx/webkit/WebMessageCompat;", "sourceOrigin", "Landroid/net/Uri;", "isMainFrame", "", "replyProxy", "Landroidx/webkit/JavaScriptReplyProxy;", "onHandleInvocation", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebViewBridgeInterface() {
        this(null);
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>()V");
        CreativeInfoManager.onWebviewInterfaceConstruction(h.m, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private WebViewBridgeInterface(StatsEvent statsEvent) {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>()V");
        if ("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>()V" == 0) {
        } else {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        this(iWebViewBridge, iInvocationCallbackInvoker, null);
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V");
        CreativeInfoManager.onWebviewInterfaceConstruction(h.m, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iWebViewBridge, iInvocationCallbackInvoker, i, defaultConstructorMarker, null);
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;ILkotlin/jvm/internal/DefaultConstructorMarker;)V");
        CreativeInfoManager.onWebviewInterfaceConstruction(h.m, this);
    }

    @JavascriptInterface
    public final void handleInvocation(String data) throws JSONException {
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;->handleInvocation(Ljava/lang/String;)V");
        CreativeInfoManager.onHandleInvocation(h.m, this, data);
        safedk_WebViewBridgeInterface_handleInvocation_b28daaa65b43c0e84aea26fd798d0398(data);
    }

    private WebViewBridgeInterface(IWebViewBridge webViewBridge, IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker, StatsEvent p3) {
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V");
        if ("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V" == 0) {
            Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
            Intrinsics.checkNotNullParameter(webViewAppInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        } else {
            Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
            Intrinsics.checkNotNullParameter(webViewAppInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
            this.webViewBridge = webViewBridge;
            this.webViewAppInvocationCallbackInvoker = webViewAppInvocationCallbackInvoker;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private WebViewBridgeInterface(IWebViewBridge p1, IInvocationCallbackInvoker p2, int p3, DefaultConstructorMarker p4, StatsEvent p5) {
        Logger.d("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;ILkotlin/jvm/internal/DefaultConstructorMarker;)V");
        if ("UnityCore|SafeDK: Execution> Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;-><init>(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;ILkotlin/jvm/internal/DefaultConstructorMarker;)V" != 0) {
            this((p3 & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : p1, (p3 & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : p2);
            return;
        }
        int i = p3 & 1;
        IWebViewBridge p6 = SharedInstances.INSTANCE.getWebViewBridge();
        int i2 = p3 & 2;
        IInvocationCallbackInvoker p7 = SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
        this(p6, p7);
    }

    @JavascriptInterface
    public void safedk_WebViewBridgeInterface_handleInvocation_b28daaa65b43c0e84aea26fd798d0398(String data) throws JSONException {
        Intrinsics.checkNotNullParameter(data, "data");
        DeviceLog.debug("handleInvocation " + data);
        JSONArray jSONArray = new JSONArray(data);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, JSONArrayExtensionsKt.toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    @JavascriptInterface
    public final void handleCallback(String callbackId, String callbackStatus, String rawParameters) throws Exception {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callbackStatus, "callbackStatus");
        Intrinsics.checkNotNullParameter(rawParameters, "rawParameters");
        DeviceLog.debug("handleCallback " + callbackId + ' ' + callbackStatus + ' ' + rawParameters);
        this.webViewBridge.handleCallback(callbackId, callbackStatus, JSONArrayExtensionsKt.toTypedArray(new JSONArray(rawParameters)));
    }

    public final void onHandleInvocation(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy replyProxy) throws JSONException {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceOrigin, "sourceOrigin");
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        String data = message.getData();
        if (!isMainFrame || (str = data) == null || StringsKt.isBlank(str)) {
            return;
        }
        handleInvocation(data);
    }

    public final void onHandleCallback(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy replyProxy) throws Exception {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceOrigin, "sourceOrigin");
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        String data = message.getData();
        if (!isMainFrame || (str = data) == null || StringsKt.isBlank(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(data);
        String callbackId = jSONObject.getString("id");
        String callbackStatus = jSONObject.getString("status");
        String rawParameters = jSONObject.getString("parameters");
        Intrinsics.checkNotNullExpressionValue(callbackId, "callbackId");
        Intrinsics.checkNotNullExpressionValue(callbackStatus, "callbackStatus");
        Intrinsics.checkNotNullExpressionValue(rawParameters, "rawParameters");
        handleCallback(callbackId, callbackStatus, rawParameters);
    }
}
