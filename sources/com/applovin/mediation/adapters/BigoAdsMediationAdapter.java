package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.amazon.device.ads.DtbConstants;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.bigoads.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.json.bu;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ConsentOptions;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.AdSize;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.BannerAdLoader;
import sg.bigo.ads.api.BannerAdRequest;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.InterstitialAdLoader;
import sg.bigo.ads.api.InterstitialAdRequest;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.NativeAdLoader;
import sg.bigo.ads.api.NativeAdRequest;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;
import sg.bigo.ads.api.RewardVideoAdLoader;
import sg.bigo.ads.api.RewardVideoAdRequest;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;
import sg.bigo.ads.api.SplashAdLoader;
import sg.bigo.ads.api.SplashAdRequest;

/* JADX INFO: loaded from: classes5.dex */
public class BigoAdsMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxAppOpenAdapter, MaxRewardedAdapter, MaxAdViewAdapter, MaxNativeAdAdapter {
    private static final int ADVERTISER_VIEW_TAG = 8;
    private static final int BODY_VIEW_TAG = 4;
    private static final int CALL_TO_ACTION_VIEW_TAG = 5;
    private static final int ICON_VIEW_TAG = 3;
    private static final String MEDIATION_INFO;
    private static final int MEDIA_VIEW_CONTAINER_TAG = 2;
    private static final int TITLE_LABEL_TAG = 1;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private BannerAd adViewAd;
    private AdViewListener adViewListener;
    private SplashAd appOpenAd;
    private AppOpenAdListener appOpenAdListener;
    private InterstitialAd interstitialAd;
    private InterstitialAdListener interstitialAdListener;
    private NativeAd nativeAd;
    private NativeAdListener nativeAdListener;
    private NativeAdViewListener nativeAdViewListener;
    private RewardVideoAd rewardedAd;
    private RewardedAdListener rewardedAdListener;

    static {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DtbConstants.MEDIATION_NAME, "Max");
            jSONObject.putOpt("mediationVersion", AppLovinSdk.VERSION);
            jSONObject.putOpt(bu.b, BuildConfig.VERSION_NAME);
        } catch (Throwable th) {
            Log.e("BigoAdsMediationAdapter", "Error creating mediation info JSON", th);
        }
        MEDIATION_INFO = jSONObject.toString();
    }

    public BigoAdsMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            String string = maxAdapterInitializationParameters.getServerParameters().getString("app_id");
            log("Initializing Bigo Ads SDK with app id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            BigoAdSdk.initialize(getApplicationContext(), new AdConfig.Builder().setAppId(string).setDebug(maxAdapterInitializationParameters.isTesting()).build(), new BigoAdSdk.InitListener() { // from class: com.applovin.mediation.adapters.BigoAdsMediationAdapter.1
                @Override // sg.bigo.ads.BigoAdSdk.InitListener
                public void onInitialized() {
                    if (BigoAdSdk.isInitialized()) {
                        BigoAdsMediationAdapter.this.log("Bigo Ads SDK initialized");
                        MaxAdapter.InitializationStatus unused = BigoAdsMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    } else {
                        BigoAdsMediationAdapter.this.log("Bigo Ads SDK failed to initialize");
                        MaxAdapter.InitializationStatus unused2 = BigoAdsMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    }
                    onCompletionListener.onCompletion(BigoAdsMediationAdapter.status, null);
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return BigoAdSdk.getSDKVersionName();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        log("Destroy called for adapter " + this);
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.interstitialAd = null;
            this.interstitialAdListener = null;
        }
        SplashAd splashAd = this.appOpenAd;
        if (splashAd != null) {
            splashAd.destroy();
            this.appOpenAd = null;
            this.appOpenAdListener = null;
        }
        RewardVideoAd rewardVideoAd = this.rewardedAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.rewardedAd = null;
            this.rewardedAdListener = null;
        }
        BannerAd bannerAd = this.adViewAd;
        if (bannerAd != null) {
            bannerAd.destroy();
            this.adViewAd = null;
            this.adViewListener = null;
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.nativeAd = null;
            this.nativeAdViewListener = null;
            this.nativeAdListener = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        updateUserConsent(maxAdapterSignalCollectionParameters);
        maxSignalCollectionListener.onSignalCollected(BigoAdSdk.getBidderToken());
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading interstitial ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!BigoAdSdk.isInitialized()) {
            log("Bigo Ads SDK not successfully initialized: failing interstitial ad load for slot id: " + thirdPartyAdPlacementId);
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else {
            updateUserConsent(maxAdapterResponseParameters);
            this.interstitialAdListener = new InterstitialAdListener(thirdPartyAdPlacementId, maxInterstitialAdapterListener);
            new InterstitialAdLoader.Builder().withAdLoadListener((AdLoadListener<InterstitialAd>) this.interstitialAdListener).withExt(MEDIATION_INFO).build().loadAd(new InterstitialAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).build());
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing interstitial ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (this.interstitialAd.isExpired()) {
            log("Unable to show interstitial ad for slot id: " + thirdPartyAdPlacementId + " - ad expired");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        } else {
            this.interstitialAd.setAdInteractionListener(this.interstitialAdListener);
            this.interstitialAd.show();
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void loadAppOpenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading app open ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!BigoAdSdk.isInitialized()) {
            log("Bigo Ads SDK not successfully initialized: failing app open ad load for slot id: " + thirdPartyAdPlacementId);
            maxAppOpenAdapterListener.onAppOpenAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updateUserConsent(maxAdapterResponseParameters);
        this.appOpenAdListener = new AppOpenAdListener(thirdPartyAdPlacementId, maxAppOpenAdapterListener);
        SplashAdLoader splashAdLoaderBuild = new SplashAdLoader.Builder().withAdLoadListener((AdLoadListener<SplashAd>) this.appOpenAdListener).withExt(MEDIATION_INFO).build();
        ApplicationInfo applicationInfo = getApplicationContext().getApplicationInfo();
        splashAdLoaderBuild.loadAd(new SplashAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).withAppLogo(applicationInfo.logo).withAppName(applicationInfo.name).build());
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAppOpenAdapter
    public void showAppOpenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing app open ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (this.appOpenAd.isExpired()) {
            log("Unable to show app open ad for slot id: " + thirdPartyAdPlacementId + " - ad expired");
            maxAppOpenAdapterListener.onAppOpenAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        } else {
            this.appOpenAd.setAdInteractionListener((SplashAdInteractionListener) this.appOpenAdListener);
            this.appOpenAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!BigoAdSdk.isInitialized()) {
            log("Bigo Ads SDK not successfully initialized: failing rewarded ad load for slot id: " + thirdPartyAdPlacementId);
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else {
            updateUserConsent(maxAdapterResponseParameters);
            this.rewardedAdListener = new RewardedAdListener(thirdPartyAdPlacementId, maxRewardedAdapterListener);
            new RewardVideoAdLoader.Builder().withAdLoadListener((AdLoadListener<RewardVideoAd>) this.rewardedAdListener).withExt(MEDIATION_INFO).build().loadAd(new RewardVideoAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).build());
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (this.rewardedAd.isExpired()) {
            log("Unable to show rewarded ad for slot id: " + thirdPartyAdPlacementId + " - ad expired");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        } else {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.setAdInteractionListener((RewardAdInteractionListener) this.rewardedAdListener);
            this.rewardedAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        log("Loading " + (z ? "native " : "") + maxAdFormat.getLabel() + " ad for slot id: " + thirdPartyAdPlacementId);
        if (!BigoAdSdk.isInitialized()) {
            log("Bigo Ads SDK not successfully initialized: failing " + maxAdFormat.getLabel() + " ad load for slot id: " + thirdPartyAdPlacementId);
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updateUserConsent(maxAdapterResponseParameters);
        if (z) {
            this.nativeAdViewListener = new NativeAdViewListener(thirdPartyAdPlacementId, maxAdFormat, maxAdapterResponseParameters.getServerParameters(), maxAdViewAdapterListener);
            new NativeAdLoader.Builder().withAdLoadListener((AdLoadListener<NativeAd>) this.nativeAdViewListener).withExt(MEDIATION_INFO).build().loadAd(new NativeAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        AdSize adSize = toAdSize(maxAdFormat);
        if (adSize == null) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_INVALID_CONFIGURATION, "Unsupported ad format: " + maxAdFormat);
            log(maxAdFormat.getLabel() + " ad failed to load with error: " + maxAdapterError);
            maxAdViewAdapterListener.onAdViewAdLoadFailed(maxAdapterError);
        } else {
            this.adViewListener = new AdViewListener(thirdPartyAdPlacementId, maxAdFormat, maxAdViewAdapterListener);
            new BannerAdLoader.Builder().withAdLoadListener((AdLoadListener<BannerAd>) this.adViewListener).withExt(MEDIATION_INFO).build().loadAd(new BannerAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).withAdSizes(adSize).build());
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading native ad for slot id: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!BigoAdSdk.isInitialized()) {
            log("Bigo Ads SDK not successfully initialized: failing native ad load for slot id: " + thirdPartyAdPlacementId);
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else {
            updateUserConsent(maxAdapterResponseParameters);
            this.nativeAdListener = new NativeAdListener(thirdPartyAdPlacementId, maxAdapterResponseParameters.getServerParameters(), maxNativeAdAdapterListener);
            new NativeAdLoader.Builder().withAdLoadListener((AdLoadListener<NativeAd>) this.nativeAdListener).withExt(MEDIATION_INFO).build().loadAd(new NativeAdRequest.Builder().withSlotId(thirdPartyAdPlacementId).withBid(maxAdapterResponseParameters.getBidResponse()).build());
        }
    }

    private AdSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return AdSize.BANNER;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    public static MaxAdapterError toMaxError(AdError adError) {
        int code = adError.getCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (code == 1000) {
            maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
        } else if (code == 1001) {
            maxAdapterError = MaxAdapterError.BAD_REQUEST;
        } else if (code != 1011) {
            switch (code) {
                case 1003:
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                    break;
                case 1004:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                case 1005:
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                    break;
                case 1006:
                    maxAdapterError = MaxAdapterError.AD_DISPLAY_FAILED;
                    break;
                case 1007:
                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                    break;
                default:
                    switch (code) {
                        case 2000:
                            maxAdapterError = MaxAdapterError.AD_EXPIRED;
                            break;
                        case 2001:
                            maxAdapterError = MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS;
                            break;
                        case 2002:
                        case 2003:
                        case 2004:
                            maxAdapterError = MaxAdapterError.AD_DISPLAY_FAILED;
                            break;
                        case 2005:
                            maxAdapterError = MaxAdapterError.MISSING_ACTIVITY;
                            break;
                    }
                    break;
            }
        } else {
            maxAdapterError = MaxAdapterError.TIMEOUT;
        }
        return new MaxAdapterError(maxAdapterError, code, adError.getMessage());
    }

    private void updateUserConsent(MaxAdapterParameters maxAdapterParameters) {
        Context applicationContext = getApplicationContext();
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null) {
            BigoAdSdk.setUserConsent(applicationContext, ConsentOptions.GDPR, boolHasUserConsent.booleanValue());
        }
        Boolean boolIsDoNotSell = maxAdapterParameters.isDoNotSell();
        if (boolIsDoNotSell != null) {
            BigoAdSdk.setUserConsent(applicationContext, ConsentOptions.CCPA, !boolIsDoNotSell.booleanValue());
        }
    }

    private class InterstitialAdListener implements AdLoadListener<InterstitialAd>, AdInteractionListener {
        private final MaxInterstitialAdapterListener listener;
        private final String slotId;

        private InterstitialAdListener(String str, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.slotId = str;
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(InterstitialAd interstitialAd) {
            BigoAdsMediationAdapter.this.log("Interstitial ad loaded for slot id: " + this.slotId);
            BigoAdsMediationAdapter.this.interstitialAd = interstitialAd;
            this.listener.onInterstitialAdLoaded();
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Interstitial ad (" + this.slotId + ") failed to load with error: " + maxError);
            this.listener.onInterstitialAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
            BigoAdsMediationAdapter.this.log("Interstitial ad opened for slot id: " + this.slotId);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log("Interstitial ad impression recorded for slot id: " + this.slotId);
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Interstitial ad (" + this.slotId + ") failed to show with error: " + maxError);
            this.listener.onInterstitialAdDisplayFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log("Interstitial ad click recorded for slot id: " + this.slotId);
            this.listener.onInterstitialAdClicked();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
            BigoAdsMediationAdapter.this.log("Interstitial ad hidden for slot id: " + this.slotId);
            this.listener.onInterstitialAdHidden();
        }
    }

    private class AppOpenAdListener implements AdLoadListener<SplashAd>, SplashAdInteractionListener {
        private final MaxAppOpenAdapterListener listener;
        private final String slotId;

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
        }

        private AppOpenAdListener(String str, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
            this.slotId = str;
            this.listener = maxAppOpenAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(SplashAd splashAd) {
            BigoAdsMediationAdapter.this.log("App open ad loaded for slot id: " + this.slotId);
            BigoAdsMediationAdapter.this.appOpenAd = splashAd;
            this.listener.onAppOpenAdLoaded();
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("App open ad (" + this.slotId + ") failed to load with error: " + maxError);
            this.listener.onAppOpenAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log("App open ad impression recorded for slot id: " + this.slotId);
            this.listener.onAppOpenAdDisplayed();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("App open ad (" + this.slotId + ") failed to show with error: " + maxError);
            this.listener.onAppOpenAdDisplayFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log("App open ad click recorded for slot id: " + this.slotId);
            this.listener.onAppOpenAdClicked();
        }

        @Override // sg.bigo.ads.api.SplashAdInteractionListener
        public void onAdFinished() {
            BigoAdsMediationAdapter.this.log("App open ad finished for slot id: " + this.slotId);
        }

        @Override // sg.bigo.ads.api.SplashAdInteractionListener
        public void onAdSkipped() {
            BigoAdsMediationAdapter.this.log("App open ad skipped for slot id: " + this.slotId);
            this.listener.onAppOpenAdHidden();
        }
    }

    private class RewardedAdListener implements AdLoadListener<RewardVideoAd>, RewardAdInteractionListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;
        private final String slotId;

        private RewardedAdListener(String str, MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.slotId = str;
            this.listener = maxRewardedAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(RewardVideoAd rewardVideoAd) {
            BigoAdsMediationAdapter.this.log("Rewarded ad loaded for slot id: " + this.slotId);
            BigoAdsMediationAdapter.this.rewardedAd = rewardVideoAd;
            this.listener.onRewardedAdLoaded();
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Rewarded ad (" + this.slotId + ") failed to load with error: " + maxError);
            this.listener.onRewardedAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
            BigoAdsMediationAdapter.this.log("Rewarded ad opened for slot id: " + this.slotId);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log("Rewarded ad impression recorded for slot id: " + this.slotId);
            this.listener.onRewardedAdDisplayed();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Rewarded ad (" + this.slotId + ") failed to show with error: " + maxError);
            this.listener.onRewardedAdDisplayFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log("Rewarded ad click recorded for slot id: " + this.slotId);
            this.listener.onRewardedAdClicked();
        }

        @Override // sg.bigo.ads.api.RewardAdInteractionListener
        public void onAdRewarded() {
            BigoAdsMediationAdapter.this.log("User earned reward for slot id: " + this.slotId);
            this.hasGrantedReward = true;
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
            if (this.hasGrantedReward || BigoAdsMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = BigoAdsMediationAdapter.this.getReward();
                BigoAdsMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            BigoAdsMediationAdapter.this.log("Rewarded ad hidden for slot id: " + this.slotId);
            this.listener.onRewardedAdHidden();
        }
    }

    private class AdViewListener implements AdLoadListener<BannerAd>, AdInteractionListener {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;
        private final String slotId;

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
        }

        private AdViewListener(String str, MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.slotId = str;
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(BannerAd bannerAd) {
            BigoAdsMediationAdapter.this.log(this.adFormat.getLabel() + " ad loaded for slot id: " + this.slotId);
            BigoAdsMediationAdapter.this.adViewAd = bannerAd;
            bannerAd.setAdInteractionListener(BigoAdsMediationAdapter.this.adViewListener);
            this.listener.onAdViewAdLoaded(bannerAd.adView());
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log(this.adFormat.getLabel() + " ad (" + this.slotId + ") failed to load with error :" + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log(this.adFormat.getLabel() + " ad impression recorded for slot id: " + this.slotId);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log(this.adFormat.getLabel() + " ad (" + this.slotId + ") failed to show with error: " + maxError);
            this.listener.onAdViewAdDisplayFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log(this.adFormat.getLabel() + " ad clicked recorded for slot id: " + this.slotId);
            this.listener.onAdViewAdClicked();
        }
    }

    private class NativeAdViewListener implements AdLoadListener<NativeAd>, AdInteractionListener {
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;
        private final Bundle serverParameters;
        private final String slotId;

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
        }

        private NativeAdViewListener(String str, MaxAdFormat maxAdFormat, Bundle bundle, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.slotId = str;
            this.adFormat = maxAdFormat;
            this.serverParameters = bundle;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(NativeAd nativeAd) {
            MaxNativeAdView maxNativeAdView;
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded for slot id: " + this.slotId);
            if (nativeAd == null) {
                BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad + (" + nativeAd + ") can 't be null.");
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
                return;
            }
            if (!TextUtils.isEmpty(nativeAd.getTitle())) {
                nativeAd.setAdInteractionListener(BigoAdsMediationAdapter.this.nativeAdViewListener);
                BigoAdsMediationAdapter.this.nativeAd = nativeAd;
                Context applicationContext = BigoAdsMediationAdapter.this.getApplicationContext();
                MaxBigoAdsNativeAd maxBigoAdsNativeAd = BigoAdsMediationAdapter.this.new MaxBigoAdsNativeAd(new MaxNativeAd.Builder().setAdFormat(this.adFormat).setTitle(nativeAd.getTitle()).setAdvertiser(nativeAd.getAdvertiser()).setBody(nativeAd.getDescription()).setCallToAction(nativeAd.getCallToAction()).setIconView(new ImageView(applicationContext)).setOptionsView(new AdOptionsView(applicationContext)).setMediaView(new MediaView(applicationContext)));
                String string = BundleUtils.getString("template", "", this.serverParameters);
                if (string.equals("vertical")) {
                    maxNativeAdView = new MaxNativeAdView(maxBigoAdsNativeAd, this.adFormat == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template", BigoAdsMediationAdapter.this.getApplicationContext());
                } else {
                    maxNativeAdView = new MaxNativeAdView(maxBigoAdsNativeAd, string, BigoAdsMediationAdapter.this.getApplicationContext());
                }
                maxBigoAdsNativeAd.prepareForInteraction(maxNativeAdView.getClickableViews(), maxNativeAdView);
                this.listener.onAdViewAdLoaded(maxNativeAdView);
                return;
            }
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad (" + nativeAd + ") does not have required assets.");
            this.listener.onAdViewAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad (" + this.slotId + ") failed to load with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad impression recorded for slot id: " + this.slotId);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad (" + this.slotId + ") failed to show with error: " + maxError);
            this.listener.onAdViewAdDisplayFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad click recorded for slot id: " + this.slotId);
            this.listener.onAdViewAdClicked();
        }
    }

    private class NativeAdListener implements AdLoadListener<NativeAd>, AdInteractionListener {
        private final MaxNativeAdAdapterListener listener;
        private final Bundle serverParameters;
        private final String slotId;

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdOpened() {
        }

        private NativeAdListener(String str, Bundle bundle, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.slotId = str;
            this.serverParameters = bundle;
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onAdLoaded(NativeAd nativeAd) {
            BigoAdsMediationAdapter.this.log("Native ad loaded for slot id: " + this.slotId);
            if (nativeAd != null) {
                nativeAd.setAdInteractionListener(BigoAdsMediationAdapter.this.nativeAdListener);
                BigoAdsMediationAdapter.this.nativeAd = nativeAd;
                if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)) && TextUtils.isEmpty(nativeAd.getTitle())) {
                    BigoAdsMediationAdapter.this.log("Native ad (" + nativeAd + ") does not have required assets.");
                    this.listener.onNativeAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
                    return;
                }
                Context applicationContext = BigoAdsMediationAdapter.this.getApplicationContext();
                ImageView imageView = new ImageView(applicationContext);
                this.listener.onNativeAdLoaded(BigoAdsMediationAdapter.this.new MaxBigoAdsNativeAd(new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(nativeAd.getTitle()).setAdvertiser(nativeAd.getAdvertiser()).setBody(nativeAd.getDescription()).setCallToAction(nativeAd.getCallToAction()).setIconView(imageView).setOptionsView(new AdOptionsView(applicationContext)).setMediaView(new MediaView(applicationContext)).setMediaContentAspectRatio(nativeAd.getMediaContentAspectRatio())), null);
                return;
            }
            BigoAdsMediationAdapter.this.log("Native ad (" + nativeAd + ")  can't be null.");
            this.listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
        }

        @Override // sg.bigo.ads.api.AdLoadListener
        public void onError(AdError adError) {
            MaxAdapterError maxError = BigoAdsMediationAdapter.toMaxError(adError);
            BigoAdsMediationAdapter.this.log("Native ad (" + this.slotId + ") failed to load with error: " + maxError);
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdImpression() {
            BigoAdsMediationAdapter.this.log("Native ad impression recorded for slot id: " + this.slotId);
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdError(AdError adError) {
            BigoAdsMediationAdapter.this.log("Native ad (" + this.slotId + ") failed to show with error: " + BigoAdsMediationAdapter.toMaxError(adError));
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public void onAdClicked() {
            BigoAdsMediationAdapter.this.log("Native ad click recorded for slot id: " + this.slotId);
            this.listener.onNativeAdClicked();
        }
    }

    private class MaxBigoAdsNativeAd extends MaxNativeAd {
        public MaxBigoAdsNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            NativeAd nativeAd = BigoAdsMediationAdapter.this.nativeAd;
            if (nativeAd == null) {
                BigoAdsMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
                return false;
            }
            if (viewGroup instanceof MaxNativeAdView) {
                MaxNativeAdView maxNativeAdView = (MaxNativeAdView) viewGroup;
                nativeAd.registerViewForInteraction(viewGroup, maxNativeAdView.getMediaContentViewGroup() != null ? (MediaView) getMediaView() : null, maxNativeAdView.getIconImageView() != null ? maxNativeAdView.getIconImageView() : null, maxNativeAdView.getOptionsContentViewGroup() != null ? (AdOptionsView) getOptionsView() : null, list);
            } else {
                MediaView mediaView = null;
                ImageView imageView = null;
                for (View view : list) {
                    Object tag = view.getTag();
                    if (tag != null) {
                        int iIntValue = ((Integer) tag).intValue();
                        if (iIntValue == 1) {
                            view.setTag(2);
                        } else if (iIntValue == 3) {
                            if (view instanceof ImageView) {
                                imageView = (ImageView) view;
                            }
                        } else if (iIntValue == 2) {
                            mediaView = (MediaView) getMediaView();
                        } else if (iIntValue == 4) {
                            view.setTag(6);
                        } else if (iIntValue == 5) {
                            view.setTag(7);
                        } else if (iIntValue == 8) {
                            view.setTag(3);
                        }
                    }
                }
                nativeAd.registerViewForInteraction(viewGroup, mediaView, imageView, (AdOptionsView) null, list);
            }
            return true;
        }
    }
}
