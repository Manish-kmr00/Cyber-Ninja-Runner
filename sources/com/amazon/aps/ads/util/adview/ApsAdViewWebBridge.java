package com.amazon.aps.ads.util.adview;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DtbCommonUtils;
import com.amazon.device.ads.MraidCommand;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsAdViewWebBridge.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0007R\"\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewWebBridge;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/amazon/aps/ads/util/adview/ApsWebBridgeListener;", "(Lcom/amazon/aps/ads/util/adview/ApsWebBridgeListener;)V", "executionException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getExecutionException", "()Ljava/lang/Exception;", "setExecutionException", "(Ljava/lang/Exception;)V", "getListener", "()Lcom/amazon/aps/ads/util/adview/ApsWebBridgeListener;", "echo", "", "json", "Lorg/json/JSONObject;", "handleApsCommand", "apsEvent", "handleMraidCommand", "request", "handleServiceCall", "handleVideoEvent", "videoEvent", "logFromJavasScript", "message", "", "postMessage", "args", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsAdViewWebBridge {
    private Exception executionException;
    private final ApsWebBridgeListener listener;

    public ApsAdViewWebBridge(ApsWebBridgeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final ApsWebBridgeListener getListener() {
        return this.listener;
    }

    public final Exception getExecutionException() {
        return this.executionException;
    }

    public final void setExecutionException(Exception exc) {
        this.executionException = exc;
    }

    @JavascriptInterface
    public final void postMessage(String args) {
        try {
            JSONObject jSONObject = new JSONObject(args);
            if (jSONObject.has("type")) {
                String string = jSONObject.getString("type");
                if (Intrinsics.areEqual(NotificationCompat.CATEGORY_SERVICE, string)) {
                    handleServiceCall(jSONObject);
                    return;
                }
                if (Intrinsics.areEqual("mraid", string)) {
                    handleMraidCommand(jSONObject);
                    return;
                } else if (Intrinsics.areEqual(ApsMetricsDataMap.APSMETRICS_FIELD_APS, string)) {
                    handleApsCommand(jSONObject);
                    return;
                } else {
                    if (Intrinsics.areEqual("apsvid", string)) {
                        handleVideoEvent(jSONObject);
                        return;
                    }
                    return;
                }
            }
            ApsAdExtensionsKt.e(this, "Unrecognized bridge call");
        } catch (JSONException e) {
            ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("JSON conversion failed:", e));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void handleVideoEvent(JSONObject videoEvent) throws JSONException {
        Intrinsics.checkNotNullParameter(videoEvent, "videoEvent");
        String string = videoEvent.getString("subtype");
        if (DtbCommonUtils.isNullOrWhiteSpace(string) || this.listener.getApsMraidHandler() == null) {
            return;
        }
        if (string != null) {
            switch (string.hashCode()) {
                case -1928679091:
                    if (string.equals("AD_VIDEO_PLAYER_COMPLETED")) {
                        DTBAdMRAIDController apsMraidHandler = this.listener.getApsMraidHandler();
                        if (apsMraidHandler == null) {
                            return;
                        }
                        apsMraidHandler.onVideoCompleted();
                        return;
                    }
                    break;
                case -100915287:
                    if (string.equals("AD_VIDEO_PLAYER_CLICKED")) {
                        DTBAdMRAIDController apsMraidHandler2 = this.listener.getApsMraidHandler();
                        if (apsMraidHandler2 == null) {
                            return;
                        }
                        apsMraidHandler2.onAdClicked();
                        return;
                    }
                    break;
                case 252691236:
                    if (string.equals("END_CARD_COMPANION_AD_START")) {
                        DTBAdMRAIDController apsMraidHandler3 = this.listener.getApsMraidHandler();
                        if (apsMraidHandler3 == null) {
                            return;
                        }
                        apsMraidHandler3.startEndCardDisplayOMSDKSession();
                        return;
                    }
                    break;
                case 604315076:
                    if (string.equals("AD_FAILED_TO_LOAD")) {
                        DTBAdMRAIDController apsMraidHandler4 = this.listener.getApsMraidHandler();
                        if (apsMraidHandler4 == null) {
                            return;
                        }
                        apsMraidHandler4.onAdFailedToLoad();
                        return;
                    }
                    break;
                case 1135343643:
                    if (string.equals("END_CARD_VIDEO_CLOSED")) {
                        DTBAdMRAIDController apsMraidHandler5 = this.listener.getApsMraidHandler();
                        if (apsMraidHandler5 == null) {
                            return;
                        }
                        apsMraidHandler5.stopOMSDKSession();
                        return;
                    }
                    break;
                case 1690844065:
                    if (string.equals("AD_LOADED")) {
                        DTBAdMRAIDController apsMraidHandler6 = this.listener.getApsMraidHandler();
                        if (apsMraidHandler6 == null) {
                            return;
                        }
                        apsMraidHandler6.onAdLoaded();
                        return;
                    }
                    break;
            }
        }
        ApsAdExtensionsKt.i(this, Intrinsics.stringPlus(string, " video event not supported"));
    }

    public final void handleServiceCall(JSONObject request) throws JSONException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (Intrinsics.areEqual(CreativeInfo.f, request.getString("subtype"))) {
            String string = request.getJSONObject("arguments").getString("message");
            Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(\"message\")");
            logFromJavasScript(string);
        }
    }

    public final void handleApsCommand(JSONObject apsEvent) throws JSONException {
        Intrinsics.checkNotNullParameter(apsEvent, "apsEvent");
        String string = apsEvent.getString("subtype");
        if (DtbCommonUtils.isNullOrWhiteSpace(string) || this.listener.getApsMraidHandler() == null) {
            return;
        }
        if (Intrinsics.areEqual(string, "onAdLoaded")) {
            DTBAdMRAIDController apsMraidHandler = this.listener.getApsMraidHandler();
            if (apsMraidHandler == null) {
                return;
            }
            apsMraidHandler.onAdLoaded();
            return;
        }
        if (!Intrinsics.areEqual(string, "onAdFailedToLoad")) {
            ApsAdExtensionsKt.i(this, Intrinsics.stringPlus(string, " aps event not supported"));
            return;
        }
        DTBAdMRAIDController apsMraidHandler2 = this.listener.getApsMraidHandler();
        if (apsMraidHandler2 == null) {
            return;
        }
        apsMraidHandler2.onAdFailedToLoad();
    }

    public final void handleMraidCommand(JSONObject request) throws JSONException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.executionException = null;
        String string = request.getString("subtype");
        Class<MraidCommand> clsFindMraidCommandByName = MraidCommand.findMraidCommandByName(string);
        if (clsFindMraidCommandByName == null) {
            ApsAdExtensionsKt.e(this, "MRAID Command:" + ((Object) string) + " is not found");
            DTBAdMRAIDController apsMraidHandler = this.listener.getApsMraidHandler();
            Intrinsics.checkNotNull(apsMraidHandler);
            apsMraidHandler.fireErrorEvent(string, Intrinsics.stringPlus(string, " is not supported"));
            DTBAdMRAIDController apsMraidHandler2 = this.listener.getApsMraidHandler();
            Intrinsics.checkNotNull(apsMraidHandler2);
            apsMraidHandler2.commandCompleted(string);
            return;
        }
        try {
            MraidCommand mraidCommandNewInstance = clsFindMraidCommandByName.newInstance();
            if (mraidCommandNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.amazon.device.ads.MraidCommand");
            }
            MraidCommand mraidCommand = mraidCommandNewInstance;
            ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("execute command ", mraidCommand.getName()));
            mraidCommand.execute(request.getJSONObject("arguments"), this.listener.getApsMraidHandler());
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            this.executionException = e2;
            ApsAdExtensionsKt.e(this, "Error execution command " + ((Object) string) + ' ' + ((Object) e2.getLocalizedMessage()));
        }
    }

    private final void logFromJavasScript(String message) {
        ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("mraid:JSNative: ", message));
    }

    public final void echo(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            int i = json.getInt("promiseId");
            String strStringPlus = Intrinsics.stringPlus(json.getJSONObject("arguments").getString("greeting"), " Returned");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String str = String.format("window.promiseResolve(%d, '%s');", Arrays.copyOf(new Object[]{Integer.valueOf(i), strStringPlus}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewWebBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ApsAdViewWebBridge.m4376echo$lambda8(this.f$0, str);
                }
            });
        } catch (JSONException e) {
            ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("JSON conversion failed:", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: echo$lambda-8, reason: not valid java name */
    public static final void m4376echo$lambda8(ApsAdViewWebBridge this$0, String scriplet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scriplet, "$scriplet");
        this$0.listener.evaluateApsJavascript(scriplet, null);
    }
}
