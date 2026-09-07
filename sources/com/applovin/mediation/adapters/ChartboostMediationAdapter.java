package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.Profile;
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
import com.applovin.mediation.adapters.chartboost.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.LoggingLevel;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ClickEvent;
import com.chartboost.sdk.events.DismissEvent;
import com.chartboost.sdk.events.ImpressionEvent;
import com.chartboost.sdk.events.RewardEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.events.StartError;
import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.GDPR;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class ChartboostMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static MaxAdapter.InitializationStatus status;
    private Banner adView;
    private Interstitial interstitialAd;
    private Rewarded rewardedAd;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static final Mediation MEDIATION_PROVIDER = new Mediation("MAX", AppLovinSdk.VERSION, BuildConfig.VERSION_NAME);

    public ChartboostMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            Bundle serverParameters = maxAdapterInitializationParameters.getServerParameters();
            String string = serverParameters.getString("app_id");
            log("Initializing Chartboost SDK with app id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            Context applicationContext = activity != null ? activity.getApplicationContext() : getApplicationContext();
            updateConsentStatus(maxAdapterInitializationParameters, applicationContext);
            Chartboost.startWithAppId(applicationContext, string, serverParameters.getString("app_signature"), new StartCallback() { // from class: com.applovin.mediation.adapters.ChartboostMediationAdapter.1
                @Override // com.chartboost.sdk.callbacks.StartCallback
                public void onStartCompleted(StartError startError) {
                    if (startError != null) {
                        ChartboostMediationAdapter.this.log("Chartboost SDK initialized failed because of error: " + startError);
                        MaxAdapter.InitializationStatus unused = ChartboostMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                        onCompletionListener.onCompletion(ChartboostMediationAdapter.status, startError.toString());
                    } else {
                        ChartboostMediationAdapter.this.log("Chartboost SDK initialized successfully");
                        MaxAdapter.InitializationStatus unused2 = ChartboostMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                        onCompletionListener.onCompletion(ChartboostMediationAdapter.status, null);
                    }
                }
            });
            if (maxAdapterInitializationParameters.isTesting()) {
                Chartboost.setLoggingLevel(LoggingLevel.ALL);
                return;
            }
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return Chartboost.getSDKVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        log("Destroy called for adapter " + this);
        Interstitial interstitial = this.interstitialAd;
        if (interstitial != null) {
            interstitial.clearCache();
            this.interstitialAd = null;
        }
        Rewarded rewarded = this.rewardedAd;
        if (rewarded != null) {
            rewarded.clearCache();
            this.rewardedAd = null;
        }
        Banner banner = this.adView;
        if (banner != null) {
            banner.detach();
            this.adView.clearCache();
            this.adView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(Chartboost.getBidderToken());
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String strRetrieveLocation = retrieveLocation(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        log("Loading " + (zIsValidString ? "bidding " : "") + "interstitial ad for location \"" + strRetrieveLocation + "\"...");
        updateConsentStatus(maxAdapterResponseParameters, getContext(activity));
        Interstitial interstitial = new Interstitial(strRetrieveLocation, new InterstitialAdListener(maxInterstitialAdapterListener), MEDIATION_PROVIDER);
        this.interstitialAd = interstitial;
        if (interstitial.isCached()) {
            log("Ad is available already");
            maxInterstitialAdapterListener.onInterstitialAdLoaded();
        } else if (zIsValidString) {
            this.interstitialAd.cache(bidResponse);
        } else {
            this.interstitialAd.cache();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad for location \"" + retrieveLocation(maxAdapterResponseParameters) + "\"...");
        Interstitial interstitial = this.interstitialAd;
        if (interstitial != null && interstitial.isCached()) {
            this.interstitialAd.show();
        } else {
            log("Interstitial ad not ready");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String strRetrieveLocation = retrieveLocation(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        log("Loading " + (zIsValidString ? "bidding " : "") + "rewarded ad for location \"" + strRetrieveLocation + "\"...");
        updateConsentStatus(maxAdapterResponseParameters, getContext(activity));
        Rewarded rewarded = new Rewarded(strRetrieveLocation, new RewardedAdListener(maxRewardedAdapterListener), MEDIATION_PROVIDER);
        this.rewardedAd = rewarded;
        if (rewarded.isCached()) {
            log("Ad is available already");
            maxRewardedAdapterListener.onRewardedAdLoaded();
        } else if (zIsValidString) {
            this.rewardedAd.cache(bidResponse);
        } else {
            this.rewardedAd.cache();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad for location \"" + retrieveLocation(maxAdapterResponseParameters) + "\"...");
        Rewarded rewarded = this.rewardedAd;
        if (rewarded != null && rewarded.isCached()) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        } else {
            log("Rewarded ad not ready");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String strRetrieveLocation = retrieveLocation(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        log("Loading " + (zIsValidString ? "bidding " : "") + maxAdFormat.getLabel() + " ad for location \"" + strRetrieveLocation + "\"...");
        updateConsentStatus(maxAdapterResponseParameters, getContext(activity));
        Banner banner = new Banner(getContext(activity), strRetrieveLocation, toAdSize(maxAdFormat), new AdViewAdListener(maxAdViewAdapterListener, maxAdFormat), MEDIATION_PROVIDER);
        this.adView = banner;
        if (banner.isCached()) {
            log("Ad is available already");
            maxAdViewAdapterListener.onAdViewAdLoaded(this.adView);
            showAdViewDelayed(maxAdViewAdapterListener);
        } else if (zIsValidString) {
            this.adView.cache(bidResponse);
        } else {
            this.adView.cache();
        }
    }

    private void updateConsentStatus(MaxAdapterParameters maxAdapterParameters, Context context) {
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null) {
            Chartboost.addDataUseConsent(context, new GDPR(boolHasUserConsent.booleanValue() ? GDPR.GDPR_CONSENT.BEHAVIORAL : GDPR.GDPR_CONSENT.NON_BEHAVIORAL));
        }
        Boolean boolIsDoNotSell = maxAdapterParameters.isDoNotSell();
        if (boolIsDoNotSell != null) {
            Chartboost.addDataUseConsent(context, new CCPA(boolIsDoNotSell.booleanValue() ? CCPA.CCPA_CONSENT.OPT_OUT_SALE : CCPA.CCPA_CONSENT.OPT_IN_SALE));
        }
    }

    private String retrieveLocation(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            return maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        }
        return Profile.DEFAULT_PROFILE_NAME;
    }

    private Banner.BannerSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return Banner.BannerSize.STANDARD;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return Banner.BannerSize.LEADERBOARD;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return Banner.BannerSize.MEDIUM;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(CacheError cacheError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (AnonymousClass3.$SwitchMap$com$chartboost$sdk$events$CacheError$Code[cacheError.getCode().ordinal()]) {
            case 1:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 2:
            case 3:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 4:
                maxAdapterError = MaxAdapterError.NO_FILL;
                break;
            case 5:
                maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                break;
            case 6:
                maxAdapterError = MaxAdapterError.BAD_REQUEST;
                break;
            case 7:
            case 8:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
            case 9:
                maxAdapterError = MaxAdapterError.SERVER_ERROR;
                break;
        }
        return new MaxAdapterError(maxAdapterError, cacheError.getCode().getErrorCode(), cacheError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(ShowError showError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (AnonymousClass3.$SwitchMap$com$chartboost$sdk$events$ShowError$Code[showError.getCode().ordinal()]) {
            case 1:
            case 2:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 3:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                break;
            case 4:
                maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                break;
            case 5:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 6:
                maxAdapterError = MaxAdapterError.AD_NOT_READY;
                break;
            case 7:
            case 8:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
        }
        return new MaxAdapterError(maxAdapterError, showError.getCode().getErrorCode(), showError.toString());
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.ChartboostMediationAdapter$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$events$CacheError$Code;
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$events$ClickError$Code;
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$events$ShowError$Code;

        static {
            int[] iArr = new int[ClickError.Code.values().length];
            $SwitchMap$com$chartboost$sdk$events$ClickError$Code = iArr;
            try {
                iArr[ClickError.Code.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ClickError$Code[ClickError.Code.URI_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ClickError$Code[ClickError.Code.URI_UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ShowError.Code.values().length];
            $SwitchMap$com$chartboost$sdk$events$ShowError$Code = iArr2;
            try {
                iArr2[ShowError.Code.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.PRESENTATION_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.AD_ALREADY_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.SESSION_NOT_STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.INTERNET_UNAVAILABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.NO_CACHED_AD.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.BANNER_DISABLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$ShowError$Code[ShowError.Code.BANNER_VIEW_IS_DETACHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[CacheError.Code.values().length];
            $SwitchMap$com$chartboost$sdk$events$CacheError$Code = iArr3;
            try {
                iArr3[CacheError.Code.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.INTERNET_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.NETWORK_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.NO_AD_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.SESSION_NOT_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.ASSET_DOWNLOAD_FAILURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.BANNER_DISABLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.BANNER_VIEW_IS_DETACHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$events$CacheError$Code[CacheError.Code.SERVER_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    private static MaxAdapterError toMaxError(ClickError clickError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        int i = AnonymousClass3.$SwitchMap$com$chartboost$sdk$events$ClickError$Code[clickError.getCode().ordinal()];
        if (i == 1) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        } else if (i == 2 || i == 3) {
            maxAdapterError = MaxAdapterError.BAD_REQUEST;
        }
        return new MaxAdapterError(maxAdapterError, clickError.getCode().getErrorCode(), clickError.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdViewDelayed(final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.mediation.adapters.ChartboostMediationAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChartboostMediationAdapter.this.adView != null) {
                    ChartboostMediationAdapter.this.adView.show();
                } else {
                    ChartboostMediationAdapter.this.log("Ad load failed: Chartboost Banner AdView is not ready.");
                    maxAdViewAdapterListener.onAdViewAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "AdView ad not ready"));
                }
            }
        }, 500L);
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private class InterstitialAdListener implements InterstitialCallback {
        private final MaxInterstitialAdapterListener listener;

        private InterstitialAdListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdLoaded(CacheEvent cacheEvent, CacheError cacheError) {
            String location = cacheEvent.getAd().getLocation();
            if (cacheError != null) {
                ChartboostMediationAdapter.this.log("Interstitial ad failed \"" + location + "\" to load with error: " + cacheError);
                this.listener.onInterstitialAdLoadFailed(ChartboostMediationAdapter.toMaxError(cacheError));
            } else {
                ChartboostMediationAdapter.this.log("Interstitial ad loaded: " + location);
                this.listener.onInterstitialAdLoaded();
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdRequestedToShow(ShowEvent showEvent) {
            ChartboostMediationAdapter.this.log("Interstitial ad requested to show: " + showEvent.getAd().getLocation());
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdShown(ShowEvent showEvent, ShowError showError) {
            String location = showEvent.getAd().getLocation();
            if (showError != null) {
                ChartboostMediationAdapter.this.log("Interstitial ad failed \"" + location + "\" to show with error: " + showError);
                this.listener.onInterstitialAdDisplayFailed(ChartboostMediationAdapter.toMaxError(showError));
            } else {
                ChartboostMediationAdapter.this.log("Interstitial ad shown: " + location);
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdClicked(ClickEvent clickEvent, ClickError clickError) {
            String location = clickEvent.getAd().getLocation();
            if (clickError != null) {
                ChartboostMediationAdapter.this.log("Failed to record interstitial ad click on \"" + location + "\" because of error: " + clickError);
            } else {
                ChartboostMediationAdapter.this.log("Interstitial ad clicked: " + location);
                this.listener.onInterstitialAdClicked();
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onImpressionRecorded(ImpressionEvent impressionEvent) {
            ChartboostMediationAdapter.this.log("Interstitial ad impression tracked: " + impressionEvent.getAd().getLocation());
            if (!TextUtils.isEmpty(impressionEvent.getAdID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", impressionEvent.getAdID());
                this.listener.onInterstitialAdDisplayed(bundle);
                return;
            }
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.chartboost.sdk.callbacks.DismissibleAdCallback
        public void onAdDismiss(DismissEvent dismissEvent) {
            ChartboostMediationAdapter.this.log("Interstitial ad hidden: " + dismissEvent.getAd().getLocation());
            this.listener.onInterstitialAdHidden();
        }
    }

    private class RewardedAdListener implements RewardedCallback {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        private RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdLoaded(CacheEvent cacheEvent, CacheError cacheError) {
            String location = cacheEvent.getAd().getLocation();
            if (cacheError != null) {
                ChartboostMediationAdapter.this.log("Rewarded ad failed \"" + location + "\" to load with error: " + cacheError);
                this.listener.onRewardedAdLoadFailed(ChartboostMediationAdapter.toMaxError(cacheError));
            } else {
                ChartboostMediationAdapter.this.log("Rewarded ad loaded: " + location);
                this.listener.onRewardedAdLoaded();
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdRequestedToShow(ShowEvent showEvent) {
            ChartboostMediationAdapter.this.log("Rewarded ad requested to show: " + showEvent.getAd().getLocation());
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdShown(ShowEvent showEvent, ShowError showError) {
            String location = showEvent.getAd().getLocation();
            if (showError != null) {
                ChartboostMediationAdapter.this.log("Rewarded ad failed \"" + location + "\" to show with error: " + showError);
                this.listener.onRewardedAdDisplayFailed(ChartboostMediationAdapter.toMaxError(showError));
            } else {
                ChartboostMediationAdapter.this.log("Rewarded ad shown: " + location);
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdClicked(ClickEvent clickEvent, ClickError clickError) {
            String location = clickEvent.getAd().getLocation();
            if (clickError != null) {
                ChartboostMediationAdapter.this.log("Failed to record rewarded ad click on \"" + location + "\" because of error: " + clickError);
            } else {
                ChartboostMediationAdapter.this.log("Rewarded ad clicked: " + location);
                this.listener.onRewardedAdClicked();
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onImpressionRecorded(ImpressionEvent impressionEvent) {
            ChartboostMediationAdapter.this.log("Rewarded ad impression tracked: " + impressionEvent.getAd().getLocation());
            if (!TextUtils.isEmpty(impressionEvent.getAdID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", impressionEvent.getAdID());
                this.listener.onRewardedAdDisplayed(bundle);
                return;
            }
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.chartboost.sdk.callbacks.RewardedCallback
        public void onRewardEarned(RewardEvent rewardEvent) {
            ChartboostMediationAdapter.this.log("Rewarded ad granted reward: " + rewardEvent.getAd().getLocation());
            this.hasGrantedReward = true;
        }

        @Override // com.chartboost.sdk.callbacks.DismissibleAdCallback
        public void onAdDismiss(DismissEvent dismissEvent) {
            String location = dismissEvent.getAd().getLocation();
            if (this.hasGrantedReward || ChartboostMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = ChartboostMediationAdapter.this.getReward();
                ChartboostMediationAdapter.this.log("Rewarded ad user with reward: " + reward + " at location: " + location);
                this.listener.onUserRewarded(reward);
            }
            ChartboostMediationAdapter.this.log("Rewarded ad hidden: " + location);
            this.listener.onRewardedAdHidden();
        }
    }

    private class AdViewAdListener implements BannerCallback {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;

        private AdViewAdListener(MaxAdViewAdapterListener maxAdViewAdapterListener, MaxAdFormat maxAdFormat) {
            this.listener = maxAdViewAdapterListener;
            this.adFormat = maxAdFormat;
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdLoaded(CacheEvent cacheEvent, CacheError cacheError) {
            String location = cacheEvent.getAd().getLocation();
            if (cacheError != null) {
                ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad failed \"" + location + "\" to load with error: " + cacheError);
                this.listener.onAdViewAdLoadFailed(ChartboostMediationAdapter.toMaxError(cacheError));
                return;
            }
            ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad loaded: " + location);
            if (TextUtils.isEmpty(cacheEvent.getAdID())) {
                this.listener.onAdViewAdLoaded(ChartboostMediationAdapter.this.adView);
            } else {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", cacheEvent.getAdID());
                this.listener.onAdViewAdLoaded(ChartboostMediationAdapter.this.adView, bundle);
            }
            ChartboostMediationAdapter.this.showAdViewDelayed(this.listener);
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdRequestedToShow(ShowEvent showEvent) {
            ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad requested to show: " + showEvent.getAd().getLocation());
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdShown(ShowEvent showEvent, ShowError showError) {
            String location = showEvent.getAd().getLocation();
            if (showError != null) {
                ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad failed \"" + location + "\" to show with error: " + showError);
                this.listener.onAdViewAdDisplayFailed(ChartboostMediationAdapter.toMaxError(showError));
            } else {
                ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad shown: " + location);
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onAdClicked(ClickEvent clickEvent, ClickError clickError) {
            String location = clickEvent.getAd().getLocation();
            if (clickError != null) {
                ChartboostMediationAdapter.this.log("Failed to record " + this.adFormat.getLabel() + " ad click on \"" + location + "\" because of error: " + clickError);
            } else {
                ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad clicked: " + location);
                this.listener.onAdViewAdClicked();
            }
        }

        @Override // com.chartboost.sdk.callbacks.AdCallback
        public void onImpressionRecorded(ImpressionEvent impressionEvent) {
            ChartboostMediationAdapter.this.log(this.adFormat.getLabel() + " ad impression tracked: " + impressionEvent.getAd().getLocation());
            if (!TextUtils.isEmpty(impressionEvent.getAdID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", impressionEvent.getAdID());
                this.listener.onAdViewAdDisplayed(bundle);
                return;
            }
            this.listener.onAdViewAdDisplayed();
        }
    }
}
