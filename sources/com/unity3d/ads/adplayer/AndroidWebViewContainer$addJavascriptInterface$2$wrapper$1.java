package com.unity3d.ads.adplayer;

import android.webkit.JavascriptInterface;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.unity3d.ads.adplayer.model.WebViewBridgeInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidWebViewContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0017J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0017¨\u0006\n"}, d2 = {"com/unity3d/ads/adplayer/AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1", "Lcom/unity3d/ads/adplayer/model/WebViewBridgeInterface;", "handleCallback", "", "callbackId", "", "callbackStatus", "rawParameters", "handleInvocation", "message", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1 implements WebViewBridgeInterface {
    final /* synthetic */ WebViewBridge $webViewBridgeInterface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1(WebViewBridge webViewBridge) {
        this(webViewBridge, null);
        Logger.d("UnityAds|SafeDK: Execution> Lcom/unity3d/ads/adplayer/AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1;-><init>(Lcom/unity3d/ads/adplayer/WebViewBridge;)V");
        CreativeInfoManager.onWebviewInterfaceConstruction("com.unity3d.ads", this);
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewBridgeInterface
    @JavascriptInterface
    public void handleInvocation(String message) {
        Logger.d("UnityAds|SafeDK: Execution> Lcom/unity3d/ads/adplayer/AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1;->handleInvocation(Ljava/lang/String;)V");
        CreativeInfoManager.onHandleInvocation("com.unity3d.ads", this, message);
        safedk_AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1_handleInvocation_13f0ae608c73e26f83257d778e6067a1(message);
    }

    private AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1(WebViewBridge p1, StatsEvent p2) {
        Logger.d("UnityAds|SafeDK: Execution> Lcom/unity3d/ads/adplayer/AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1;-><init>(Lcom/unity3d/ads/adplayer/WebViewBridge;)V");
        if ("UnityAds|SafeDK: Execution> Lcom/unity3d/ads/adplayer/AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1;-><init>(Lcom/unity3d/ads/adplayer/WebViewBridge;)V" == 0) {
            this.$webViewBridgeInterface = p1;
        } else {
            this.$webViewBridgeInterface = p1;
        }
    }

    @JavascriptInterface
    public void safedk_AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1_handleInvocation_13f0ae608c73e26f83257d778e6067a1(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.$webViewBridgeInterface.handleInvocation(message);
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewBridgeInterface
    @JavascriptInterface
    public void handleCallback(String callbackId, String callbackStatus, String rawParameters) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callbackStatus, "callbackStatus");
        Intrinsics.checkNotNullParameter(rawParameters, "rawParameters");
        this.$webViewBridgeInterface.handleCallback(callbackId, callbackStatus, rawParameters);
    }
}
