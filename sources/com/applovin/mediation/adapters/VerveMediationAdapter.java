package com.applovin.mediation.adapters;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.verve.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.UserDataManager;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.ImpressionTrackingMethod;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedAd;
import net.pubnative.lite.sdk.views.HyBidAdView;

/* JADX INFO: loaded from: classes6.dex */
public class VerveMediationAdapter extends MediationAdapterBase implements MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter, MaxSignalProvider {
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private HyBidAdView adViewAd;
    private HyBidInterstitialAd interstitialAd;
    private HyBidRewardedAd rewardedAd;

    public VerveMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return HyBid.getSDKVersionInfo();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            String string = maxAdapterInitializationParameters.getServerParameters().getString(Reporting.Key.APP_TOKEN, "");
            log("Initializing Verve SDK with app token: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            if (maxAdapterInitializationParameters.isTesting()) {
                HyBid.setTestMode(true);
            }
            HyBid.initialize(string, (Application) getApplicationContext());
            if (HyBid.isInitialized()) {
                log("Verve SDK initialized");
                status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
            } else {
                log("Verve SDK failed to initialize");
                status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
            }
            onCompletionListener.onCompletion(status, null);
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        HyBidInterstitialAd hyBidInterstitialAd = this.interstitialAd;
        if (hyBidInterstitialAd != null) {
            hyBidInterstitialAd.destroy();
            this.interstitialAd = null;
        }
        HyBidRewardedAd hyBidRewardedAd = this.rewardedAd;
        if (hyBidRewardedAd != null) {
            hyBidRewardedAd.destroy();
            this.rewardedAd = null;
        }
        HyBidAdView hyBidAdView = this.adViewAd;
        if (hyBidAdView != null) {
            hyBidAdView.destroy();
            this.adViewAd = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting Signal...");
        updateLocationCollectionEnabled(maxAdapterSignalCollectionParameters);
        updateUserConsent(maxAdapterSignalCollectionParameters);
        maxSignalCollectionListener.onSignalCollected(HyBid.getCustomRequestSignalData());
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Loading interstitial ad");
        if (!HyBid.isInitialized()) {
            log("Verve SDK is not initialized: failing interstitial ad load...");
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        updateUserConsent(maxAdapterResponseParameters);
        HyBidInterstitialAd hyBidInterstitialAd = new HyBidInterstitialAd(getApplicationContext(), null, "", new InterstitialListener(this, maxInterstitialAdapterListener, null));
        this.interstitialAd = hyBidInterstitialAd;
        hyBidInterstitialAd.prepareAd(maxAdapterResponseParameters.getBidResponse());
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad...");
        if (this.interstitialAd.isReady()) {
            this.interstitialAd.show();
        } else {
            log("Interstitial ad not ready");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Loading rewarded ad");
        if (!HyBid.isInitialized()) {
            log("Verve SDK is not initialized: failing rewarded ad load...");
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        updateUserConsent(maxAdapterResponseParameters);
        HyBidRewardedAd hyBidRewardedAd = new HyBidRewardedAd(getApplicationContext(), null, "", new RewardedListener(this, maxRewardedAdapterListener, null));
        this.rewardedAd = hyBidRewardedAd;
        hyBidRewardedAd.prepareAd(maxAdapterResponseParameters.getBidResponse());
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad...");
        if (this.rewardedAd.isReady()) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        } else {
            log("Rewarded ad not ready");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        log("Loading " + maxAdFormat.getLabel() + " ad view ad...");
        if (!HyBid.isInitialized()) {
            log("Verve SDK is not initialized: failing " + maxAdFormat.getLabel() + " ad load...");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        updateUserConsent(maxAdapterResponseParameters);
        HyBidAdView hyBidAdView = new HyBidAdView(getApplicationContext(), getSize(maxAdFormat));
        this.adViewAd = hyBidAdView;
        hyBidAdView.setTrackingMethod(ImpressionTrackingMethod.AD_VIEWABLE);
        this.adViewAd.renderAd(maxAdapterResponseParameters.getBidResponse(), new AdViewListener(this, maxAdViewAdapterListener, null));
    }

    private void updateUserConsent(MaxAdapterParameters maxAdapterParameters) {
        Boolean boolIsDoNotSell;
        UserDataManager userDataManager = HyBid.getUserDataManager();
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null && userDataManager != null) {
            String iABGDPRConsentString = userDataManager.getIABGDPRConsentString();
            if (!boolHasUserConsent.booleanValue()) {
                userDataManager.setIABGDPRConsentString("0");
            } else if (TextUtils.isEmpty(iABGDPRConsentString) || iABGDPRConsentString.equals("0")) {
                userDataManager.setIABGDPRConsentString("1");
            }
        }
        if (userDataManager == null || !TextUtils.isEmpty(userDataManager.getIABUSPrivacyString()) || (boolIsDoNotSell = maxAdapterParameters.isDoNotSell()) == null || !boolIsDoNotSell.booleanValue()) {
            return;
        }
        userDataManager.setIABUSPrivacyString("1NYN");
    }

    private void updateLocationCollectionEnabled(MaxAdapterParameters maxAdapterParameters) {
        Object obj = maxAdapterParameters.getLocalExtraParameters().get("is_location_collection_enabled");
        if (obj instanceof Boolean) {
            log("Setting location collection enabled: " + obj);
            HyBid.setLocationUpdatesEnabled(((Boolean) obj).booleanValue());
        }
    }

    private static AdSize getSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return AdSize.SIZE_320x50;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return AdSize.SIZE_728x90;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.SIZE_300x250;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(Throwable th) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (th instanceof HyBidError) {
            switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[((HyBidError) th).getErrorCode().ordinal()]) {
                case 1:
                case 2:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                    break;
                case 9:
                case 10:
                    maxAdapterError = MaxAdapterError.SERVER_ERROR;
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                    maxAdapterError = MaxAdapterError.BAD_REQUEST;
                    break;
                case 15:
                    maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                    maxAdapterError = MaxAdapterError.AD_NOT_READY;
                    break;
                case 20:
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                    break;
                case 21:
                case 22:
                case 23:
                    maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                    break;
                case 24:
                    maxAdapterError = MaxAdapterError.AD_EXPIRED;
                    break;
            }
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), 0, th.getMessage());
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.VerveMediationAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode;

        static {
            int[] iArr = new int[HyBidErrorCode.values().length];
            $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode = iArr;
            try {
                iArr[HyBidErrorCode.NO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.NULL_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INVALID_ASSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.UNSUPPORTED_ASSET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.MRAID_PLAYER_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.VAST_PLAYER_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_TRACKING_URL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_TRACKING_JS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.PARSER_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.SERVER_ERROR_PREFIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INVALID_AD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INVALID_ZONE_ID.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INVALID_SIGNAL_DATA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INVALID_URL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.NOT_INITIALISED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.AUCTION_NO_AD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_RENDERING_BANNER.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_RENDERING_INTERSTITIAL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_RENDERING_REWARDED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.INTERNAL_ERROR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.DISABLED_FORMAT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.DISABLED_RENDERING_ENGINE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.ERROR_LOADING_FEEDBACK.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$HyBidErrorCode[HyBidErrorCode.EXPIRED_AD.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private class InterstitialListener implements HyBidInterstitialAd.Listener {
        private final MaxInterstitialAdapterListener listener;

        /* synthetic */ InterstitialListener(VerveMediationAdapter verveMediationAdapter, MaxInterstitialAdapterListener maxInterstitialAdapterListener, AnonymousClass1 anonymousClass1) {
            this(maxInterstitialAdapterListener);
        }

        private InterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.Listener
        public void onInterstitialLoaded() {
            VerveMediationAdapter.this.log("Interstitial ad loaded");
            this.listener.onInterstitialAdLoaded();
        }

        @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.Listener
        public void onInterstitialLoadFailed(Throwable th) {
            VerveMediationAdapter.this.log("Interstitial ad failed to load with error: " + th);
            this.listener.onInterstitialAdLoadFailed(VerveMediationAdapter.toMaxError(th));
        }

        @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.Listener
        public void onInterstitialImpression() {
            VerveMediationAdapter.this.log("Interstitial did track impression");
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.Listener
        public void onInterstitialClick() {
            VerveMediationAdapter.this.log("Interstitial clicked");
            this.listener.onInterstitialAdClicked();
        }

        @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.Listener
        public void onInterstitialDismissed() {
            VerveMediationAdapter.this.log("Interstitial hidden");
            this.listener.onInterstitialAdHidden();
        }
    }

    private class RewardedListener implements HyBidRewardedAd.Listener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        /* synthetic */ RewardedListener(VerveMediationAdapter verveMediationAdapter, MaxRewardedAdapterListener maxRewardedAdapterListener, AnonymousClass1 anonymousClass1) {
            this(maxRewardedAdapterListener);
        }

        private RewardedListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onRewardedLoaded() {
            VerveMediationAdapter.this.log("Rewarded ad loaded");
            this.listener.onRewardedAdLoaded();
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onRewardedLoadFailed(Throwable th) {
            VerveMediationAdapter.this.log("Rewarded ad failed to load with error: " + th);
            this.listener.onRewardedAdLoadFailed(VerveMediationAdapter.toMaxError(th));
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onRewardedOpened() {
            VerveMediationAdapter.this.log("Rewarded ad did track impression");
            this.listener.onRewardedAdDisplayed();
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onRewardedClick() {
            VerveMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onReward() {
            VerveMediationAdapter.this.log("Rewarded ad reward granted");
            this.hasGrantedReward = true;
        }

        @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedAd.Listener
        public void onRewardedClosed() {
            VerveMediationAdapter.this.log("Rewarded ad did disappear");
            if (this.hasGrantedReward || VerveMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = VerveMediationAdapter.this.getReward();
                VerveMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            VerveMediationAdapter.this.log("Rewarded ad hidden");
            this.listener.onRewardedAdHidden();
        }
    }

    private class AdViewListener implements HyBidAdView.Listener {
        private final MaxAdViewAdapterListener listener;

        /* synthetic */ AdViewListener(VerveMediationAdapter verveMediationAdapter, MaxAdViewAdapterListener maxAdViewAdapterListener, AnonymousClass1 anonymousClass1) {
            this(maxAdViewAdapterListener);
        }

        private AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // net.pubnative.lite.sdk.views.HyBidAdView.Listener
        public void onAdLoaded() {
            VerveMediationAdapter.this.log("AdView ad loaded");
            this.listener.onAdViewAdLoaded(VerveMediationAdapter.this.adViewAd);
        }

        @Override // net.pubnative.lite.sdk.views.HyBidAdView.Listener
        public void onAdLoadFailed(Throwable th) {
            VerveMediationAdapter.this.log("AdView failed to load with error: " + th);
            this.listener.onAdViewAdLoadFailed(VerveMediationAdapter.toMaxError(th));
        }

        @Override // net.pubnative.lite.sdk.views.HyBidAdView.Listener
        public void onAdImpression() {
            VerveMediationAdapter.this.log("AdView did track impression");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // net.pubnative.lite.sdk.views.HyBidAdView.Listener
        public void onAdClick() {
            VerveMediationAdapter.this.log("AdView clicked");
            this.listener.onAdViewAdClicked();
        }
    }
}
