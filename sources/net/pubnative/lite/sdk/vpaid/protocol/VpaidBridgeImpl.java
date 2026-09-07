package net.pubnative.lite.sdk.vpaid.protocol;

import android.webkit.JavascriptInterface;
import java.util.Locale;
import java.util.Objects;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import net.pubnative.lite.sdk.vpaid.models.vpaid.CreativeParams;

/* JADX INFO: loaded from: classes12.dex */
public class VpaidBridgeImpl implements VpaidBridge {
    private static final String LOG_TAG = "VpaidBridgeImpl";
    private final BridgeEventHandler mBridge;
    private final CreativeParams mCreativeParams;

    public VpaidBridgeImpl(BridgeEventHandler bridgeEventHandler, CreativeParams creativeParams) {
        this.mBridge = bridgeEventHandler;
        this.mCreativeParams = creativeParams;
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void prepare() {
        Logger.d(LOG_TAG, "call initVpaidWrapper()");
        callJsMethod("initVpaidWrapper()");
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void startAd() {
        Logger.d(LOG_TAG, "call startAd()");
        callWrapper("startAd()");
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void stopAd() {
        Logger.d(LOG_TAG, "call stopAd()");
        callWrapper("stopAd()");
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void pauseAd() {
        Logger.d(LOG_TAG, "call pauseAd()");
        callWrapper("pauseAd()");
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void resumeAd() {
        Logger.d(LOG_TAG, "call resumeAd()");
        callWrapper("resumeAd()");
    }

    @Override // net.pubnative.lite.sdk.vpaid.protocol.VpaidBridge
    public void getAdSkippableState() {
        Logger.d(LOG_TAG, "call getAdSkippableState()");
        callWrapper("getAdSkippableState()");
    }

    private void runOnUiThread(Runnable runnable) {
        this.mBridge.runOnUiThread(runnable);
    }

    private void callJsMethod(String str) {
        this.mBridge.callJsMethod(str);
    }

    private void callWrapper(String str) {
        callJsMethod("vapidWrapperInstance." + str);
    }

    @JavascriptInterface
    public void wrapperReady() {
        initAd();
    }

    private void initAd() {
        Logger.d(LOG_TAG, "JS: call initAd()");
        callWrapper(String.format(Locale.ENGLISH, "initAd(%1$d,%2$d,%3$s,%4$s,%5$s,%6$s)", Integer.valueOf(this.mCreativeParams.getWidth()), Integer.valueOf(this.mCreativeParams.getHeight()), this.mCreativeParams.getViewMode(), Integer.valueOf(this.mCreativeParams.getDesiredBitrate()), this.mCreativeParams.getCreativeData(), this.mCreativeParams.getEnvironmentVars()));
    }

    @JavascriptInterface
    public String handshakeVersionResult(String str) {
        Logger.d(LOG_TAG, "JS: handshakeVersion()");
        return str;
    }

    @JavascriptInterface
    public void vpaidAdLoaded() {
        Logger.d(LOG_TAG, "JS: vpaidAdLoaded");
        this.mBridge.onPrepared();
    }

    @JavascriptInterface
    public void vpaidAdStarted() {
        Logger.d(LOG_TAG, "JS: vpaidAdStarted");
    }

    @JavascriptInterface
    public void initAdResult() {
        Logger.d(LOG_TAG, "JS: Init ad done");
    }

    @JavascriptInterface
    public void vpaidAdError(String str) {
        Logger.d(LOG_TAG, "JS: vpaidAdError" + str);
        this.mBridge.trackError(str);
    }

    @JavascriptInterface
    public void vpaidAdLog(String str) {
        Logger.d(LOG_TAG, "JS: vpaidAdLog " + str);
    }

    @JavascriptInterface
    public void vpaidAdUserAcceptInvitation() {
        Logger.d(LOG_TAG, "JS: vpaidAdUserAcceptInvitation");
    }

    @JavascriptInterface
    public void vpaidAdUserMinimize() {
        Logger.d(LOG_TAG, "JS: vpaidAdUserMinimize");
    }

    @JavascriptInterface
    public void vpaidAdUserClose() {
        Logger.d(LOG_TAG, "JS: vpaidAdUserClose");
    }

    @JavascriptInterface
    public void vpaidAdSkippableStateChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdSkippableStateChange");
    }

    @JavascriptInterface
    public void vpaidAdExpandedChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdExpandedChange");
    }

    @JavascriptInterface
    public void getAdExpandedResult(String str) {
        Logger.d(LOG_TAG, "JS: getAdExpandedResult");
    }

    @JavascriptInterface
    public void vpaidAdSizeChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdSizeChange");
    }

    @JavascriptInterface
    public void vpaidAdDurationChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdDurationChange");
        callWrapper("getAdDurationResult");
        this.mBridge.onDurationChanged();
    }

    @JavascriptInterface
    public void vpaidAdRemainingTimeChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdRemainingTimeChange");
        callWrapper("getAdRemainingTime()");
    }

    @JavascriptInterface
    public void vpaidAdLinearChange() {
        Logger.d(LOG_TAG, "JS: vpaidAdLinearChange");
        this.mBridge.onAdLinearChange();
    }

    @JavascriptInterface
    public void vpaidAdPaused() {
        Logger.d(LOG_TAG, "JS: vpaidAdPaused");
        this.mBridge.postEvent("pause", false);
    }

    @JavascriptInterface
    public void vpaidAdVideoStart() {
        Logger.d(LOG_TAG, "JS: vpaidAdVideoStart");
        this.mBridge.postEvent("start", true);
    }

    @JavascriptInterface
    public void vpaidAdPlaying() {
        Logger.d(LOG_TAG, "JS: vpaidAdPlaying");
        this.mBridge.postEvent("resume", false);
    }

    @JavascriptInterface
    public void vpaidAdClickThruIdPlayerHandles(String str, String str2, boolean z) {
        if (z) {
            this.mBridge.openUrl(str);
        }
    }

    @JavascriptInterface
    public void vpaidAdVideoFirstQuartile() {
        this.mBridge.postEvent(EventConstants.FIRST_QUARTILE, true);
    }

    @JavascriptInterface
    public void vpaidAdVideoMidpoint() {
        Logger.d(LOG_TAG, "JS: vpaidAdVideoMidpoint");
        this.mBridge.postEvent("midpoint", true);
    }

    @JavascriptInterface
    public void vpaidAdVideoThirdQuartile() {
        Logger.d(LOG_TAG, "JS: vpaidAdVideoThirdQuartile");
        this.mBridge.postEvent(EventConstants.THIRD_QUARTILE, true);
    }

    @JavascriptInterface
    public void vpaidAdVideoComplete() {
        Logger.d(LOG_TAG, "JS: vpaidAdVideoComplete");
    }

    @JavascriptInterface
    public void getAdSkippableStateResult(boolean z) {
        Logger.d(LOG_TAG, "JS: SkippableState: " + z);
        this.mBridge.setSkippableState(z);
    }

    @JavascriptInterface
    public void getAdRemainingTimeResult(int i) {
        Logger.d(LOG_TAG, "JS: getAdRemainingTimeResult: " + i);
        if (i == 0) {
            this.mBridge.postEvent("complete", true);
        } else {
            this.mBridge.postEvent("progress", i, false);
        }
    }

    @JavascriptInterface
    public void getAdDurationResult(int i) {
        Logger.d(LOG_TAG, "JS: getAdDurationResult: " + i);
    }

    @JavascriptInterface
    public void getAdLinearResult(boolean z) {
        Logger.d(LOG_TAG, "getAdLinearResult: " + z);
    }

    @JavascriptInterface
    public void vpaidAdSkipped() {
        Logger.d(LOG_TAG, "JS: vpaidAdSkipped");
        final BridgeEventHandler bridgeEventHandler = this.mBridge;
        Objects.requireNonNull(bridgeEventHandler);
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.protocol.VpaidBridgeImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                bridgeEventHandler.onAdSkipped();
            }
        });
    }

    @JavascriptInterface
    public void vpaidAdStopped() {
        Logger.d(LOG_TAG, "JS: vpaidAdStopped");
        final BridgeEventHandler bridgeEventHandler = this.mBridge;
        Objects.requireNonNull(bridgeEventHandler);
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.protocol.VpaidBridgeImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                bridgeEventHandler.onAdStopped();
            }
        });
    }

    @JavascriptInterface
    public void vpaidAdImpression() {
        Logger.d(LOG_TAG, "JS: vpaidAdImpression");
        this.mBridge.onAdImpression();
    }

    @JavascriptInterface
    public void vpaidAdInteraction() {
        Logger.d(LOG_TAG, "JS: vpaidAdInteraction");
    }

    @JavascriptInterface
    public void vpaidAdVolumeChanged() {
        Logger.d(LOG_TAG, "JS: vpaidAdVolumeChanged");
        this.mBridge.onAdVolumeChange();
    }

    @JavascriptInterface
    public void getAdVolumeResult() {
        Logger.d(LOG_TAG, "JS: getAdVolumeResult");
    }
}
