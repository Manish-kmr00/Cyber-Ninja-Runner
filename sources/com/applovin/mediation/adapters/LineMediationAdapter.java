package com.applovin.mediation.adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapters.line.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.five_corp.ad.FiveAd;
import com.five_corp.ad.FiveAdConfig;
import com.five_corp.ad.FiveAdCustomLayout;
import com.five_corp.ad.FiveAdCustomLayoutEventListener;
import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdInterface;
import com.five_corp.ad.FiveAdInterstitial;
import com.five_corp.ad.FiveAdInterstitialEventListener;
import com.five_corp.ad.FiveAdLoadListener;
import com.five_corp.ad.FiveAdNative;
import com.five_corp.ad.FiveAdNativeEventListener;
import com.five_corp.ad.FiveAdState;
import com.five_corp.ad.FiveAdVideoReward;
import com.five_corp.ad.FiveAdVideoRewardEventListener;
import com.five_corp.ad.NeedGdprNonPersonalizedAdsTreatment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LineMediationAdapter extends MediationAdapterBase implements MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();
    private FiveAdCustomLayout adView;
    private FiveAdInterstitial interstitialAd;
    private FiveAdNative nativeAd;
    private FiveAdVideoReward rewardedAd;

    public LineMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return FiveAd.getSdkSemanticVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        if (INITIALIZED.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("app_id");
            log("Initializing Line SDK with app id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            FiveAdConfig fiveAdConfig = new FiveAdConfig(string);
            fiveAdConfig.isTest = maxAdapterInitializationParameters.isTesting();
            Bundle serverParameters = maxAdapterInitializationParameters.getServerParameters();
            if (serverParameters.containsKey("is_muted")) {
                fiveAdConfig.enableSoundByDefault(!serverParameters.getBoolean("is_muted"));
            }
            Boolean boolHasUserConsent = maxAdapterInitializationParameters.hasUserConsent();
            if (boolHasUserConsent != null) {
                fiveAdConfig.needGdprNonPersonalizedAdsTreatment = boolHasUserConsent.booleanValue() ? NeedGdprNonPersonalizedAdsTreatment.FALSE : NeedGdprNonPersonalizedAdsTreatment.TRUE;
            }
            FiveAd.initialize(getApplicationContext(), fiveAdConfig);
            onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN, null);
            return;
        }
        if (FiveAd.isInitialized()) {
            onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN, null);
        } else {
            log("Line SDK still initializing");
            onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.INITIALIZING, null);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        this.interstitialAd = null;
        this.rewardedAd = null;
        this.adView = null;
        this.nativeAd = null;
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading interstitial ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.interstitialAd = new FiveAdInterstitial(getApplicationContext(), thirdPartyAdPlacementId);
        InterstitialListener interstitialListener = new InterstitialListener(maxInterstitialAdapterListener);
        this.interstitialAd.setLoadListener(interstitialListener);
        this.interstitialAd.setEventListener(interstitialListener);
        this.interstitialAd.loadAdAsync();
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad for slot id: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.interstitialAd.showAd();
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.rewardedAd = new FiveAdVideoReward(getApplicationContext(), thirdPartyAdPlacementId);
        RewardedListener rewardedListener = new RewardedListener(maxRewardedAdapterListener);
        this.rewardedAd.setLoadListener(rewardedListener);
        this.rewardedAd.setEventListener(rewardedListener);
        this.rewardedAd.loadAdAsync();
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad for slot id: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        configureReward(maxAdapterResponseParameters);
        this.rewardedAd.showAd();
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading " + (z ? "native " : "") + maxAdFormat.getLabel() + " ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (z) {
            this.nativeAd = new FiveAdNative(getApplicationContext(), thirdPartyAdPlacementId, new DisplayMetrics().widthPixels);
            NativeAdViewListener nativeAdViewListener = new NativeAdViewListener(maxAdViewAdapterListener, maxAdFormat, maxAdapterResponseParameters.getServerParameters());
            this.nativeAd.setLoadListener(nativeAdViewListener);
            this.nativeAd.setEventListener(nativeAdViewListener);
            this.nativeAd.enableSound(false);
            this.nativeAd.loadAdAsync();
            return;
        }
        this.adView = new FiveAdCustomLayout(getApplicationContext(), thirdPartyAdPlacementId, new DisplayMetrics().widthPixels);
        AdViewListener adViewListener = new AdViewListener(maxAdViewAdapterListener, maxAdFormat);
        this.adView.setLoadListener(adViewListener);
        this.adView.setEventListener(adViewListener);
        this.adView.enableSound(false);
        this.adView.loadAdAsync();
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading native ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.nativeAd = new FiveAdNative(getApplicationContext(), thirdPartyAdPlacementId, new DisplayMetrics().widthPixels);
        NativeAdListener nativeAdListener = new NativeAdListener(maxNativeAdAdapterListener, maxAdapterResponseParameters.getServerParameters());
        this.nativeAd.setLoadListener(nativeAdListener);
        this.nativeAd.setEventListener(nativeAdListener);
        this.nativeAd.enableSound(false);
        this.nativeAd.loadAdAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(FiveAdErrorCode fiveAdErrorCode) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        String str = "Please contact us.";
        switch (AnonymousClass1.$SwitchMap$com$five_corp$ad$FiveAdErrorCode[fiveAdErrorCode.ordinal()]) {
            case 1:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                str = "Please try again in a stable network environment.";
                break;
            case 2:
                maxAdapterError = MaxAdapterError.NO_FILL;
                str = "Ad was not ready at display time. Please try again.";
                break;
            case 3:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                str = "Check if the OS type, PackageName, and issued AppID registered in FIVE Dashboard and the application settings match. Please be careful about blanks.";
                break;
            case 4:
                maxAdapterError = MaxAdapterError.UNSPECIFIED;
                str = "There is a problem with the device storage. Please try again with another device.";
                break;
            case 5:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 6:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                str = "There is a problem with the implementation. Please check the following. Whether the initialization process (FiveAd.initialize) is executed before the creation of the ad object or loadAdAsync. Are you calling loadAdAsync multiple times for one ad object?";
                break;
            case 7:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                str = "Make sure you are using the SlotID issued on the FIVE Dashboard.";
                break;
            case 8:
            case 9:
                maxAdapterError = MaxAdapterError.UNSPECIFIED;
                break;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), fiveAdErrorCode.ordinal(), str);
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.LineMediationAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$five_corp$ad$FiveAdErrorCode;

        static {
            int[] iArr = new int[FiveAdErrorCode.values().length];
            $SwitchMap$com$five_corp$ad$FiveAdErrorCode = iArr;
            try {
                iArr[FiveAdErrorCode.NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.NO_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.BAD_APP_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.STORAGE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.INTERNAL_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.INVALID_STATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.BAD_SLOT_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.SUPPRESSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$five_corp$ad$FiveAdErrorCode[FiveAdErrorCode.PLAYER_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private class InterstitialListener implements FiveAdLoadListener, FiveAdInterstitialEventListener {
        private final MaxInterstitialAdapterListener listener;

        InterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoad(FiveAdInterface fiveAdInterface) {
            LineMediationAdapter.this.log("Interstitial ad loaded for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onInterstitialAdLoaded();
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoadError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Interstitial ad failed to load for slot id: " + fiveAdInterface.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onInterstitialAdLoadFailed(LineMediationAdapter.toMaxError(fiveAdErrorCode));
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onViewError(FiveAdInterstitial fiveAdInterstitial, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Interstitial ad failed to show for slot id: " + fiveAdInterstitial.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", fiveAdErrorCode.value, "Please Contact Us"));
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onImpression(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad impression tracked for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onClick(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad clicked for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onFullScreenClose(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad hidden for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onInterstitialAdHidden();
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onFullScreenOpen(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad shown for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onPlay(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad did play for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onPause(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad did pause for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdInterstitialEventListener
        public void onViewThrough(FiveAdInterstitial fiveAdInterstitial) {
            LineMediationAdapter.this.log("Interstitial ad completed for slot id: " + fiveAdInterstitial.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
    }

    private class RewardedListener implements FiveAdLoadListener, FiveAdVideoRewardEventListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        RewardedListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoad(FiveAdInterface fiveAdInterface) {
            LineMediationAdapter.this.log("Rewarded ad loaded for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onRewardedAdLoaded();
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoadError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Rewarded ad failed to load for slot id: " + fiveAdInterface.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onRewardedAdLoadFailed(LineMediationAdapter.toMaxError(fiveAdErrorCode));
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onViewError(FiveAdVideoReward fiveAdVideoReward, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Rewarded ad failed to show for slot id: " + fiveAdVideoReward.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", fiveAdErrorCode.value, "Please Contact Us"));
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onImpression(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad impression tracked for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onClick(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad clicked for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onRewardedAdClicked();
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onFullScreenClose(FiveAdVideoReward fiveAdVideoReward) {
            if (fiveAdVideoReward.getState() != FiveAdState.ERROR && (this.hasGrantedReward || LineMediationAdapter.this.shouldAlwaysRewardUser())) {
                MaxReward reward = LineMediationAdapter.this.getReward();
                LineMediationAdapter.this.log("Rewarded ad user with reward: " + reward + " for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
                this.listener.onUserRewarded(reward);
            }
            LineMediationAdapter.this.log("Rewarded ad hidden for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onRewardedAdHidden();
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onFullScreenOpen(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad shown for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onPlay(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad did play for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onPause(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad did pause for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onViewThrough(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad completed for slot id: " + fiveAdVideoReward.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdVideoRewardEventListener
        public void onReward(FiveAdVideoReward fiveAdVideoReward) {
            LineMediationAdapter.this.log("Rewarded ad granted reward for slot id: " + fiveAdVideoReward.getSlotId());
            this.hasGrantedReward = true;
        }
    }

    private class AdViewListener implements FiveAdLoadListener, FiveAdCustomLayoutEventListener {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;

        AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener, MaxAdFormat maxAdFormat) {
            this.listener = maxAdViewAdapterListener;
            this.adFormat = maxAdFormat;
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoad(FiveAdInterface fiveAdInterface) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad loaded for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdLoaded(LineMediationAdapter.this.adView);
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoadError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad failed to load for slot id: " + fiveAdInterface.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onAdViewAdLoadFailed(LineMediationAdapter.toMaxError(fiveAdErrorCode));
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onViewError(FiveAdCustomLayout fiveAdCustomLayout, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad failed to show for slot id: " + fiveAdCustomLayout.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onAdViewAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", fiveAdErrorCode.value, "Please Contact Us"));
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onImpression(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad impression tracked for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onClick(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad clicked for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onRemove(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad hidden for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdHidden();
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onPlay(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad did play for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onPause(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad did pause for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdCustomLayoutEventListener
        public void onViewThrough(FiveAdCustomLayout fiveAdCustomLayout) {
            LineMediationAdapter.this.log(this.adFormat.getLabel() + " ad completed for slot id: " + fiveAdCustomLayout.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
    }

    private class NativeAdViewListener implements FiveAdLoadListener, FiveAdNativeEventListener {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;
        private final Bundle serverParameters;

        NativeAdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener, MaxAdFormat maxAdFormat, Bundle bundle) {
            this.listener = maxAdViewAdapterListener;
            this.adFormat = maxAdFormat;
            this.serverParameters = bundle;
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoad(FiveAdInterface fiveAdInterface) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            if (LineMediationAdapter.this.nativeAd == null) {
                LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load: no fill for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
            } else {
                renderCustomNativeBanner(fiveAdInterface.getSlotId());
            }
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoadError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load for slot id: " + fiveAdInterface.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onAdViewAdLoadFailed(LineMediationAdapter.toMaxError(fiveAdErrorCode));
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onViewError(FiveAdNative fiveAdNative, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to show for slot id: " + fiveAdNative.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onAdViewAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", fiveAdErrorCode.value, "Please Contact Us"));
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onImpression(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad impression tracked for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onClick(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad clicked for slot id: " + fiveAdNative.getSlotId());
            this.listener.onAdViewAdClicked();
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onRemove(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad hidden for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onAdViewAdHidden();
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onPlay(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad did play for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onPause(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad did pause for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onViewThrough(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad completed for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        private void renderCustomNativeBanner(final String str) {
            LineMediationAdapter.this.nativeAd.loadIconImageAsync(new FiveAdNative.LoadImageCallback() { // from class: com.applovin.mediation.adapters.LineMediationAdapter.NativeAdViewListener.1
                @Override // com.five_corp.ad.FiveAdNative.LoadImageCallback
                public void onImageLoad(final Bitmap bitmap) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.LineMediationAdapter.NativeAdViewListener.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaxNativeAdView maxNativeAdView;
                            FiveAdNative fiveAdNative = LineMediationAdapter.this.nativeAd;
                            if (fiveAdNative == null) {
                                LineMediationAdapter.this.log("Native " + NativeAdViewListener.this.adFormat.getLabel() + " ad destroyed before assets finished load for slot id: " + str);
                                return;
                            }
                            MaxNativeAd maxNativeAdBuild = new MaxNativeAd.Builder().setAdFormat(NativeAdViewListener.this.adFormat).setTitle(fiveAdNative.getAdTitle()).setBody(fiveAdNative.getDescriptionText()).setCallToAction(fiveAdNative.getButtonText()).setIcon(new MaxNativeAd.MaxNativeAdImage(new BitmapDrawable(LineMediationAdapter.this.getApplicationContext().getResources(), bitmap))).setMediaView(fiveAdNative.getAdMainView()).build();
                            String string = BundleUtils.getString("template", "", NativeAdViewListener.this.serverParameters);
                            if (string.equals("vertical")) {
                                maxNativeAdView = new MaxNativeAdView(maxNativeAdBuild, NativeAdViewListener.this.adFormat == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template", LineMediationAdapter.this.getApplicationContext());
                            } else {
                                maxNativeAdView = new MaxNativeAdView(maxNativeAdBuild, string, LineMediationAdapter.this.getApplicationContext());
                            }
                            ArrayList arrayList = new ArrayList(5);
                            if (AppLovinSdkUtils.isValidString(maxNativeAdBuild.getTitle()) && maxNativeAdView.getTitleTextView() != null) {
                                arrayList.add(maxNativeAdView.getTitleTextView());
                            }
                            if (AppLovinSdkUtils.isValidString(maxNativeAdBuild.getBody()) && maxNativeAdView.getBodyTextView() != null) {
                                arrayList.add(maxNativeAdView.getBodyTextView());
                            }
                            if (AppLovinSdkUtils.isValidString(maxNativeAdBuild.getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
                                arrayList.add(maxNativeAdView.getCallToActionButton());
                            }
                            if (maxNativeAdBuild.getIcon() != null && maxNativeAdView.getIconImageView() != null) {
                                arrayList.add(maxNativeAdView.getIconImageView());
                            }
                            ViewGroup mediaContentViewGroup = maxNativeAdView.getMediaContentViewGroup();
                            if (maxNativeAdBuild.getMediaView() != null && mediaContentViewGroup != null) {
                                arrayList.add(mediaContentViewGroup);
                            }
                            fiveAdNative.registerViews(maxNativeAdView, maxNativeAdView.getIconImageView(), arrayList);
                            NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdView);
                        }
                    });
                }
            });
        }
    }

    private class NativeAdListener implements FiveAdLoadListener, FiveAdNativeEventListener {
        private final MaxNativeAdAdapterListener listener;
        private final Bundle serverParameters;

        NativeAdListener(MaxNativeAdAdapterListener maxNativeAdAdapterListener, Bundle bundle) {
            this.listener = maxNativeAdAdapterListener;
            this.serverParameters = bundle;
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoad(final FiveAdInterface fiveAdInterface) {
            LineMediationAdapter.this.log("Native ad loaded for slot id: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            FiveAdNative fiveAdNative = LineMediationAdapter.this.nativeAd;
            if (fiveAdNative == null) {
                LineMediationAdapter.this.log("Native ad destroyed before the ad successfully loaded: " + fiveAdInterface.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
                this.listener.onNativeAdLoadFailed(MaxAdapterError.INVALID_LOAD_STATE);
            } else if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)) && TextUtils.isEmpty(fiveAdNative.getAdTitle())) {
                LineMediationAdapter.this.e("Native ad (" + fiveAdInterface + ") does not have required assets.");
                this.listener.onNativeAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            } else {
                fiveAdNative.loadIconImageAsync(new FiveAdNative.LoadImageCallback() { // from class: com.applovin.mediation.adapters.LineMediationAdapter.NativeAdListener.1
                    @Override // com.five_corp.ad.FiveAdNative.LoadImageCallback
                    public void onImageLoad(Bitmap bitmap) {
                        FiveAdNative fiveAdNative2 = LineMediationAdapter.this.nativeAd;
                        if (fiveAdNative2 == null) {
                            LineMediationAdapter.this.log("Native ad destroyed before assets finished load for slot id: " + fiveAdInterface.getSlotId());
                            return;
                        }
                        NativeAdListener.this.listener.onNativeAdLoaded(new MaxLineNativeAd(LineMediationAdapter.this, new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(fiveAdNative2.getAdTitle()).setAdvertiser(fiveAdNative2.getAdvertiserName()).setBody(fiveAdNative2.getDescriptionText()).setCallToAction(fiveAdNative2.getButtonText()).setIcon(new MaxNativeAd.MaxNativeAdImage(new BitmapDrawable(LineMediationAdapter.this.getApplicationContext().getResources(), bitmap))).setMediaView(fiveAdNative2.getAdMainView()), null), null);
                    }
                });
            }
        }

        @Override // com.five_corp.ad.FiveAdLoadListener
        public void onFiveAdLoadError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Native ad failed to load for slot id: " + fiveAdInterface.getSlotId() + " with error: " + fiveAdErrorCode);
            this.listener.onNativeAdLoadFailed(LineMediationAdapter.toMaxError(fiveAdErrorCode));
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onViewError(FiveAdNative fiveAdNative, FiveAdErrorCode fiveAdErrorCode) {
            LineMediationAdapter.this.log("Native ad failed to show for slot id: " + fiveAdNative.getSlotId() + " with error: " + fiveAdErrorCode);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onImpression(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad impression tracked for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onClick(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad clicked for slot id: " + fiveAdNative.getSlotId());
            this.listener.onNativeAdClicked();
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onRemove(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad hidden for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onPlay(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad did play for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onPause(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad did pause for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }

        @Override // com.five_corp.ad.FiveAdNativeEventListener
        public void onViewThrough(FiveAdNative fiveAdNative) {
            LineMediationAdapter.this.log("Native ad completed for slot id: " + fiveAdNative.getSlotId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
    }

    private class MaxLineNativeAd extends MaxNativeAd {
        /* synthetic */ MaxLineNativeAd(LineMediationAdapter lineMediationAdapter, MaxNativeAd.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private MaxLineNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            ImageView imageView;
            FiveAdNative fiveAdNative = LineMediationAdapter.this.nativeAd;
            if (fiveAdNative == null) {
                LineMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
                return false;
            }
            LineMediationAdapter.this.d("Preparing views for interaction: " + list + " with container: " + viewGroup);
            for (View view : list) {
                if (view instanceof ImageView) {
                    imageView = (ImageView) view;
                    fiveAdNative.registerViews(viewGroup, imageView, list);
                    return true;
                }
            }
            imageView = null;
            fiveAdNative.registerViews(viewGroup, imageView, list);
            return true;
        }
    }
}
