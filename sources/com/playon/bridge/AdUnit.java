package com.playon.bridge;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import com.facebook.internal.AnalyticsEvents;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.Assert;
import com.playon.bridge.common.util.DeviceUtils;
import com.playon.bridge.common.util.PluginUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AdUnit {
    public static final int ERROR_INVALID_MEDIA_URL = 8005;
    public static final int ERROR_LOADING_IN_PROGRESS = 8007;
    public static final int ERROR_LOAD_AFTER_RELEASE = 8006;
    public static final int ERROR_MEDIA_PLAYER_ERROR = 8008;
    public static final int ERROR_NETWORK_NOT_AVAILABLE = 8054;
    public static final int ERROR_NO_INVENTORY = 8004;
    public static final int ERROR_PAUSE_EXPIRED = 8011;
    public static final int ERROR_STOPPED_CLOSEBTN = 8012;
    public static final int ERROR_STOPPED_MANUALLY = 8010;
    public static final int ERROR_UNKNOWN = 8003;
    public static final int ERROR_UNKNOWN_HOST = 8001;
    public static final int ERROR_UNSUPPORTED_MIME_TYPE = 8009;
    public static final int EVENT_APPLICATION_BACKGROUND = 200;
    public static final int EVENT_APPLICATION_FOREGROUND = 201;
    public static final int EVENT_AUDIOSESSION_INTERUPTION_BEGAN = 204;
    public static final int EVENT_AUDIOSESSION_INTERUPTION_ENDED = 205;
    public static final int EVENT_AUDIOSESSION_PAUSED_BY_CLICK = 206;
    public static final int EVENT_AUDIOSESSION_RESUMED_AFTER_CLICK = 209;
    public static final int EVENT_DEVELOPER_CLOSED_AD_BY_BUTTON = 212;
    public static final int EVENT_DEVELOPER_CLOSED_AD_BY_METHOD = 211;
    public static final int EVENT_HEADPHONES_CONNECTED = 208;
    public static final int EVENT_HEADPHONES_DISCONNECTED = 207;
    public static final int EVENT_REWARDED_POPUP_APPEAR = 202;
    public static final int EVENT_REWARDED_POPUP_DISAPPEAR = 203;
    public static final int EVENT_USER_CHANGE_VOLUME_BY_BUTTON = 210;
    private static final String TAG = Log.makeTag("AdUnit");
    private Date adExpireDate;
    private final AdUnitType adRequestType;
    private Date blockStart;
    private boolean isPlaying;
    private final Activity mActivity;
    private final PlayOnManager.AdActivity mActivityListener;
    private PlayOnManager.AdListener mAdListener;
    private AdLoader mAdLoader;
    private final AdLoader.AdLoaderListener mAdLoaderListener;
    private AdUnitActivity mAdUnitActivity;
    private boolean mReleased;
    private CountDownTimer progressTick;
    private float rewardAmount = 0.0f;
    private RewardType rewardType = RewardType.EndLevel;
    private Position popupPosition = Position.BottomRight;
    private int popupXOffset = 20;
    private int popupYOffset = 20;
    private Position position = Position.BottomCenter;
    private Bundle mAd = new Bundle();
    private int timesError = 0;
    private AdState currentState = AdState.NO_ADS;
    private Position progressBarPos = Position.TopRight;
    private int xOffsetProgressBar = 0;
    private int yOffsetProgressBar = 200;
    private int sizeProgress = 64;
    private int progressBarColor = -1;
    private int visualizationMain = -1;
    private int visualizationSecondaryFrom = Color.rgb(249, 0, 243);
    private int visualizationSecondaryTo = Color.rgb(130, 1, 241);
    private ActionButtonType actionButtonType = ActionButtonType.Mute;
    private float actionButtonDelay = 0.0f;

    public enum ActionButtonType {
        Mute,
        Close,
        None
    }

    private enum AdState {
        NO_ADS,
        LOADING,
        READY
    }

    public enum AdUnitType {
        AudioBannerAd,
        AudioRewardedBannerAd,
        AudioLogoAd,
        AudioRewardedLogoAd
    }

    public enum Position {
        TopLeft,
        TopCenter,
        TopRight,
        CenterLeft,
        Centered,
        CenterRight,
        BottomLeft,
        BottomCenter,
        BottomRight
    }

    public enum RewardType {
        InLevel("in_level"),
        EndLevel("end_level");

        private final String value;

        public String getValue() {
            return this.value;
        }

        RewardType(String str) {
            this.value = str;
        }
    }

    public AdUnit(Activity activity, AdUnitType adUnitType, PlayOnManager.AdListener adListener) {
        AdLoader.AdLoaderListener adLoaderListener = new AdLoader.AdLoaderListener() { // from class: com.playon.bridge.AdUnit.1
            @Override // com.playon.bridge.AdLoader.AdLoaderListener
            public void onAdLoadingError(AdLoader adLoader, int i) {
                if (i == 8001 && !PluginUtils.isNetworkConnected(AdUnit.this.mActivity.getApplicationContext())) {
                    i = 8054;
                }
                AdUnit.this.onLoadError(i);
            }

            @Override // com.playon.bridge.AdLoader.AdLoaderListener
            public void onAdLoaded(AdLoader adLoader, Bundle bundle) {
                AdUnit.this.loadAd(bundle);
            }
        };
        this.mAdLoaderListener = adLoaderListener;
        this.mActivityListener = new PlayOnManager.AdActivity() { // from class: com.playon.bridge.AdUnit.2
            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onSuccess() {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onClose();
                    AdUnit.this.isPlaying = false;
                }
                AdUnit.this.dispose();
            }

            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onError(int i) {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onClose();
                    AdUnit.this.isPlaying = false;
                }
                AdUnit.this.dispose();
            }

            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onShow() {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onShow();
                }
            }

            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onReward(float f) {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onReward(f);
                }
            }

            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onClick() {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onClick();
                }
            }

            @Override // com.playon.bridge.PlayOnManager.AdActivity
            public void onImpression(ImpressionData impressionData) {
                if (AdUnit.this.mAdListener != null) {
                    AdUnit.this.mAdListener.onImpression(impressionData);
                }
            }
        };
        this.mActivity = activity;
        this.mAdListener = adListener;
        this.adRequestType = adUnitType;
        if (DeviceUtils.INSTANCE.isChromeBook(activity)) {
            Log.i(TAG, "ChromeOS is not supported, dummy initialization. Ads are not available");
            return;
        }
        PlayOnManager.getInstance().AddAdUnit(this);
        AdLoader adLoader = new AdLoader();
        this.mAdLoader = adLoader;
        adLoader.setListener(adLoaderListener);
        loadAd();
    }

    public void setAdListener(PlayOnManager.AdListener adListener) {
        this.mAdListener = adListener;
    }

    public PlayOnManager.AdListener getAdListener() {
        return this.mAdListener;
    }

    public boolean isAdAvailable() {
        CheckDateExpire();
        return !this.isPlaying && this.currentState == AdState.READY;
    }

    public void setReward(RewardType rewardType, float f) {
        this.rewardType = rewardType;
        this.rewardAmount = f;
    }

    public void showAd() {
        if (isAdAvailable()) {
            AdUnitActivity adUnitActivity = this.mAdUnitActivity;
            if (adUnitActivity != null && adUnitActivity.mActive) {
                Log.i(TAG, "Already showing one");
            } else {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.AdUnit$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m5468lambda$showAd$0$complayonbridgeAdUnit();
                    }
                });
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0052 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:2:0x0000, B:7:0x003d, B:17:0x0073, B:19:0x007e, B:15:0x0052, B:16:0x0066, B:6:0x0029), top: B:24:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0066 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:2:0x0000, B:7:0x003d, B:17:0x0073, B:19:0x007e, B:15:0x0052, B:16:0x0066, B:6:0x0029), top: B:24:0x0000 }] */
    /* JADX INFO: renamed from: lambda$showAd$0$com-playon-bridge-AdUnit, reason: not valid java name */
    /* synthetic */ void m5468lambda$showAd$0$complayonbridgeAdUnit() {
        try {
            AdUnitActivity adUnitActivity = new AdUnitActivity(this.mActivity, this.adRequestType, this.mAd, this.mActivityListener);
            this.mAdUnitActivity = adUnitActivity;
            adUnitActivity.setVisualizationColor(this.visualizationMain, this.visualizationSecondaryFrom, this.visualizationSecondaryTo);
            int i = AnonymousClass4.$SwitchMap$com$playon$bridge$AdUnit$AdUnitType[this.adRequestType.ordinal()];
            if (i == 1 || i == 2) {
                this.mAdUnitActivity.turnOnRewardCallback(this.rewardType, this.rewardAmount);
                this.mAdUnitActivity.turnOnPopup(this.popupPosition, this.popupXOffset, this.popupYOffset);
            }
            int i2 = AnonymousClass4.$SwitchMap$com$playon$bridge$AdUnit$AdUnitType[this.adRequestType.ordinal()];
            if (i2 == 1) {
                this.mAdUnitActivity.turnOnBanner(this.position, this.progressBarColor, this.actionButtonType, this.actionButtonDelay);
            } else if (i2 == 2) {
                this.mAdUnitActivity.turnOnLogo(this.progressBarPos, this.xOffsetProgressBar, this.yOffsetProgressBar, this.sizeProgress, this.progressBarColor, this.actionButtonType, this.actionButtonDelay);
            } else if (i2 == 3) {
                this.mAdUnitActivity.turnOnBanner(this.position, this.progressBarColor, this.actionButtonType, this.actionButtonDelay);
            } else if (i2 == 4) {
                this.mAdUnitActivity.turnOnLogo(this.progressBarPos, this.xOffsetProgressBar, this.yOffsetProgressBar, this.sizeProgress, this.progressBarColor, this.actionButtonType, this.actionButtonDelay);
            }
            this.mAdUnitActivity.play();
            this.isPlaying = true;
            PlayOnManager.AdListener adListener = this.mAdListener;
            if (adListener != null) {
                adListener.onAvailabilityChanged(false);
            }
        } catch (Exception e) {
            Log.d(TAG, "AdUnit creating exception. " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.playon.bridge.AdUnit$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$AdUnitType;
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$Position;

        static {
            int[] iArr = new int[AdUnitType.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$AdUnitType = iArr;
            try {
                iArr[AdUnitType.AudioRewardedBannerAd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnitType.AudioRewardedLogoAd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnitType.AudioBannerAd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnitType.AudioLogoAd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Position.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$Position = iArr2;
            try {
                iArr2[Position.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.CenterLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.CenterRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.Centered.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.TopRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.TopCenter.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.BottomLeft.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.BottomRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[Position.BottomCenter.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void closeAd() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.AdUnit$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5465lambda$closeAd$1$complayonbridgeAdUnit();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$closeAd$1$com-playon-bridge-AdUnit, reason: not valid java name */
    /* synthetic */ void m5465lambda$closeAd$1$complayonbridgeAdUnit() {
        try {
            AdUnitActivity adUnitActivity = this.mAdUnitActivity;
            if (adUnitActivity != null) {
                adUnitActivity.finishWithError(8010);
            }
        } catch (Exception e) {
            Log.d(TAG, "closeAd exception:" + e.getMessage());
        }
    }

    public void trackRewardedOffer() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_id", "rewardedOffer");
            jSONObject.put("payload", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD));
            Ad.postCustomEvent(this.mAd.getString(Ad.TRACKINGEVENTURL), jSONObject);
        } catch (Exception e) {
            Log.w(TAG, "Post exception: " + e.getMessage());
        }
    }

    protected void loadAd() {
        if (!PlayOnManager.getInstance().isInitialized()) {
            Log.w(TAG, "PlayOnSDK is not Initialized. Waiting for initialization before making request");
            return;
        }
        if (IsBlocked()) {
            return;
        }
        this.currentState = AdState.LOADING;
        BaseUrlGenerator baseUrlGenerator = new BaseUrlGenerator();
        baseUrlGenerator.initUrlString("bidrequest");
        baseUrlGenerator.appendApiKey();
        baseUrlGenerator.appendAppInfo();
        baseUrlGenerator.appendDeviceInfo();
        baseUrlGenerator.appendLocationInfo(this.mActivity);
        baseUrlGenerator.appendPrivacyInfo();
        baseUrlGenerator.appendFreshRequestID();
        baseUrlGenerator.appendSDKInfo();
        baseUrlGenerator.appendEngineInfo();
        baseUrlGenerator.appendAdType(this.adRequestType);
        baseUrlGenerator.appendCustomAttributes();
        this.mAdLoader.load(baseUrlGenerator.getFinalUrlString());
    }

    private boolean IsBlocked() {
        if (PlayOnManager.getInstance().getSettings().getProtectionTimes() != 0 && this.timesError >= PlayOnManager.getInstance().getSettings().getProtectionTimes()) {
            if (this.blockStart == null) {
                this.blockStart = Calendar.getInstance().getTime();
            }
            long time = Calendar.getInstance().getTime().getTime() - this.blockStart.getTime();
            if (time < PlayOnManager.getInstance().getSettings().getProtectionDelayMs()) {
                Log.d(TAG, "Too much Request with same result, wait " + (((long) PlayOnManager.getInstance().getSettings().getProtectionDelayMs()) - time) + "ms, to make new request");
                onLoadError(8003);
                return true;
            }
            this.timesError = 0;
        }
        return false;
    }

    private void CreateAutoRefreshTimer(final float f) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.AdUnit$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5464lambda$CreateAutoRefreshTimer$2$complayonbridgeAdUnit(f);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [com.playon.bridge.AdUnit$3] */
    /* JADX INFO: renamed from: lambda$CreateAutoRefreshTimer$2$com-playon-bridge-AdUnit, reason: not valid java name */
    /* synthetic */ void m5464lambda$CreateAutoRefreshTimer$2$complayonbridgeAdUnit(float f) {
        long j = (long) (f * 1000.0f);
        try {
            CountDownTimer countDownTimer = this.progressTick;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.progressTick = new CountDownTimer(j, j) { // from class: com.playon.bridge.AdUnit.3
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AdUnit.this.isAdAvailable()) {
                        return;
                    }
                    AdUnit.this.loadAd();
                }
            }.start();
        } catch (Exception e) {
            Log.d(TAG, "CreateAutoRefreshTimer exception:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Bundle bundle) {
        int i;
        PlayOnManager.AdListener adListener;
        if (bundle.isEmpty() || bundle.getString("url") == null) {
            onLoadError(8004);
            return;
        }
        if (this.mReleased) {
            i = 8006;
        } else {
            i = !PluginUtils.isNetworkConnected(this.mActivity.getApplicationContext()) ? 8054 : 0;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Ad.COMPANION);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i = ERROR_INVALID_MEDIA_URL;
        }
        if (i != 0) {
            onLoadError(i);
            return;
        }
        this.mAd = bundle;
        this.currentState = AdState.READY;
        this.adExpireDate = Calendar.getInstance().getTime();
        if (this.isPlaying || (adListener = this.mAdListener) == null) {
            return;
        }
        adListener.onAvailabilityChanged(true);
    }

    private void CheckDateExpire() {
        if (this.currentState != AdState.READY) {
            return;
        }
        if (Calendar.getInstance().getTime().getTime() - this.adExpireDate.getTime() >= PlayOnManager.getInstance().getSettings().getAdExpire()) {
            AdUnitActivity adUnitActivity = this.mAdUnitActivity;
            if (adUnitActivity != null) {
                adUnitActivity.finishWithError(8011);
            } else {
                dispose();
            }
            Log.d(TAG, "Ad Expired. Trying to request one more");
            loadAd();
        }
    }

    public void setVisualization(String str, String str2) {
        this.visualizationMain = Color.parseColor(str);
        this.visualizationSecondaryFrom = Color.parseColor(str2);
        this.visualizationSecondaryTo = Color.parseColor(str2);
    }

    public void setProgressBar(String str) {
        this.progressBarColor = Color.parseColor(str);
    }

    public void setActionButton(ActionButtonType actionButtonType, float f) {
        this.actionButtonType = actionButtonType;
        this.actionButtonDelay = f;
    }

    public void setLogo(Position position, int i, int i2, int i3) {
        this.progressBarPos = position;
        this.xOffsetProgressBar = i;
        this.yOffsetProgressBar = i2;
        this.sizeProgress = i3;
    }

    public void setPopup(Position position, int i, int i2) {
        this.popupPosition = position;
        this.popupXOffset = i;
        this.popupYOffset = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispose() {
        this.mAdUnitActivity = null;
        this.mAd.clear();
        this.currentState = AdState.NO_ADS;
        loadAd();
    }

    public void setBanner(Position position) {
        this.position = position;
    }

    public void release() {
        this.mReleased = true;
        AdLoader adLoader = this.mAdLoader;
        if (adLoader != null) {
            adLoader.cancel();
            this.mAdLoader = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadError(int i) {
        if (i == 8004) {
            this.timesError++;
        } else {
            this.timesError = 0;
        }
        CreateAutoRefreshTimer(PlayOnManager.getInstance().getSettings().getRequestWaitTime());
    }

    public static String debugErrorToStr(int i) {
        if (i == 0) {
            return "No error";
        }
        if (i == 8001) {
            return "Unknown host";
        }
        if (i != 8054) {
            switch (i) {
                case 8003:
                    return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                case 8004:
                    return "No ad inventory";
                case ERROR_INVALID_MEDIA_URL /* 8005 */:
                    return "Invalid media URL";
                case 8006:
                    return "Trying to load an ad after release()";
                case ERROR_LOADING_IN_PROGRESS /* 8007 */:
                    return "Loading already in progress";
                case ERROR_MEDIA_PLAYER_ERROR /* 8008 */:
                    return "Media player error";
                case ERROR_UNSUPPORTED_MIME_TYPE /* 8009 */:
                    return "Unsupported MIME type";
                default:
                    Assert.failUnhandledValue(TAG, i, "debugErrorToStr");
                    return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
        }
        return "Network not available";
    }

    protected static int PositionToGravity(Position position) {
        switch (AnonymousClass4.$SwitchMap$com$playon$bridge$AdUnit$Position[position.ordinal()]) {
            case 1:
                return 8388659;
            case 2:
                return 8388627;
            case 3:
                return 8388629;
            case 4:
                return 17;
            case 5:
                return 8388661;
            case 6:
                return 49;
            case 7:
                return 8388691;
            case 8:
                return 8388693;
            case 9:
                return 81;
            default:
                return 0;
        }
    }

    protected void onPause() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.AdUnit$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5466lambda$onPause$3$complayonbridgeAdUnit();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onPause$3$com-playon-bridge-AdUnit, reason: not valid java name */
    /* synthetic */ void m5466lambda$onPause$3$complayonbridgeAdUnit() {
        try {
            AdUnitActivity adUnitActivity = this.mAdUnitActivity;
            if (adUnitActivity != null) {
                adUnitActivity.onApplicationPause();
            }
            CountDownTimer countDownTimer = this.progressTick;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e) {
            Log.d(TAG, "onPause exception:" + e.getMessage());
        }
    }

    protected void onResume() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.playon.bridge.AdUnit$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5467lambda$onResume$4$complayonbridgeAdUnit();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onResume$4$com-playon-bridge-AdUnit, reason: not valid java name */
    /* synthetic */ void m5467lambda$onResume$4$complayonbridgeAdUnit() {
        try {
            AdUnitActivity adUnitActivity = this.mAdUnitActivity;
            if (adUnitActivity != null) {
                adUnitActivity.onApplicationResume();
            }
            if (this.isPlaying) {
                return;
            }
            CreateAutoRefreshTimer(5.0f);
        } catch (Exception e) {
            Log.d(TAG, "onResume exception:" + e.getMessage());
        }
    }

    protected void finalize() {
        release();
        PlayOnManager.getInstance().RemoveAdUnit(this);
    }
}
