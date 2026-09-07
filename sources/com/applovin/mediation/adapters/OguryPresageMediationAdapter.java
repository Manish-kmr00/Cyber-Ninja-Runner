package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
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
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.ogurypresage.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ogury.ad.OguryAdError;
import com.ogury.ad.OguryBannerAdSize;
import com.ogury.ad.OguryBannerAdView;
import com.ogury.ad.OguryBannerAdViewListener;
import com.ogury.ad.OguryBidTokenListener;
import com.ogury.ad.OguryBidTokenProvider;
import com.ogury.ad.OguryInterstitialAd;
import com.ogury.ad.OguryInterstitialAdListener;
import com.ogury.ad.OguryReward;
import com.ogury.ad.OguryRewardedAd;
import com.ogury.ad.OguryRewardedAdListener;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.OguryError;
import com.ogury.sdk.Ogury;
import com.ogury.sdk.OguryOnStartListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
public class OguryPresageMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private OguryBannerAdView adView;
    private OguryInterstitialAd interstitialAd;
    private OguryRewardedAd rewardedAd;

    public OguryPresageMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("asset_key");
            log("Initializing Ogury Presage SDK with asset key: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            Ogury.start(getContext(activity), string, new OguryOnStartListener() { // from class: com.applovin.mediation.adapters.OguryPresageMediationAdapter.1
                @Override // com.ogury.sdk.OguryOnStartListener
                public void onStarted() {
                    OguryPresageMediationAdapter.this.log("Ogury Presage SDK initialized");
                    MaxAdapter.InitializationStatus unused = OguryPresageMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(OguryPresageMediationAdapter.status, null);
                }

                @Override // com.ogury.sdk.OguryOnStartListener
                public void onFailed(OguryError oguryError) {
                    OguryPresageMediationAdapter.this.log("Ogury Presage SDK failed to initialize with error: " + oguryError);
                    MaxAdapter.InitializationStatus unused = OguryPresageMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(OguryPresageMediationAdapter.status, oguryError.getMessage());
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return Ogury.getSdkVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        this.interstitialAd = null;
        this.rewardedAd = null;
        OguryBannerAdView oguryBannerAdView = this.adView;
        if (oguryBannerAdView != null) {
            oguryBannerAdView.destroy();
            this.adView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        OguryBidTokenProvider.getBidToken(getContext(activity), new OguryBidTokenListener() { // from class: com.applovin.mediation.adapters.OguryPresageMediationAdapter.2
            @Override // com.ogury.ad.OguryBidTokenListener
            public void onBidTokenGenerated(String str) {
                OguryPresageMediationAdapter.this.log("Signal collection successful");
                maxSignalCollectionListener.onSignalCollected(str);
            }

            @Override // com.ogury.ad.OguryBidTokenListener
            public void onBidTokenGenerationFailed(OguryError oguryError) {
                OguryPresageMediationAdapter.this.log("Signal collection failed with error: " + oguryError);
                maxSignalCollectionListener.onSignalCollectionFailed(oguryError.getMessage());
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading " + (AppLovinSdkUtils.isValidString(bidResponse) ? "bidding " : "") + "interstitial ad: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.interstitialAd = new OguryInterstitialAd(getContext(activity), thirdPartyAdPlacementId, new OguryMediation("AppLovin MAX", AppLovinSdk.VERSION));
        this.interstitialAd.setListener(new InterstitialAdListener(thirdPartyAdPlacementId, maxInterstitialAdapterListener));
        if (this.interstitialAd.isLoaded()) {
            log("Ad is available already");
            maxInterstitialAdapterListener.onInterstitialAdLoaded();
        } else if (AppLovinSdkUtils.isValidString(bidResponse)) {
            this.interstitialAd.load(bidResponse);
        } else {
            this.interstitialAd.load();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!this.interstitialAd.isLoaded()) {
            log("Interstitial ad not ready");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        } else {
            this.interstitialAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading " + (AppLovinSdkUtils.isValidString(bidResponse) ? "bidding " : "") + "rewarded ad: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.rewardedAd = new OguryRewardedAd(getContext(activity), thirdPartyAdPlacementId, new OguryMediation("AppLovin MAX", AppLovinSdk.VERSION));
        this.rewardedAd.setListener(new RewardedAdListener(thirdPartyAdPlacementId, maxRewardedAdapterListener));
        if (this.rewardedAd.isLoaded()) {
            log("Ad is available already");
            maxRewardedAdapterListener.onRewardedAdLoaded();
        } else if (AppLovinSdkUtils.isValidString(bidResponse)) {
            this.rewardedAd.load(bidResponse);
        } else {
            this.rewardedAd.load();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!this.rewardedAd.isLoaded()) {
            log("Rewarded ad not ready");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        } else {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) throws JSONException {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading " + (AppLovinSdkUtils.isValidString(bidResponse) ? "bidding " : "") + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        this.adView = new OguryBannerAdView(getContext(activity), thirdPartyAdPlacementId, toAdSize(maxAdFormat), new OguryMediation("AppLovin MAX", AppLovinSdk.VERSION));
        this.adView.setListener(new AdViewListener(thirdPartyAdPlacementId, maxAdViewAdapterListener));
        if (AppLovinSdkUtils.isValidString(bidResponse)) {
            this.adView.load(bidResponse);
        } else {
            this.adView.load();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x002a  */
    public static MaxAdapterError toMaxError(OguryAdError oguryAdError) {
        int code = oguryAdError.getCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (code != 2300 && code != 2301) {
            switch (code) {
                case 2000:
                case 2001:
                    maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                    break;
                case 2002:
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                    break;
                default:
                    switch (code) {
                        case 2100:
                        case 2101:
                        case 2102:
                        case 2103:
                            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                            break;
                        case 2104:
                            maxAdapterError = MaxAdapterError.UNSPECIFIED;
                            break;
                        default:
                            switch (code) {
                                case 2200:
                                    maxAdapterError = MaxAdapterError.SERVER_ERROR;
                                    break;
                                case 2201:
                                    maxAdapterError = MaxAdapterError.NO_FILL;
                                    break;
                                case 2202:
                                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), code, oguryAdError.getMessage());
    }

    private OguryBannerAdSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER || maxAdFormat == MaxAdFormat.LEADER) {
            return OguryBannerAdSize.SMALL_BANNER_320x50;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return OguryBannerAdSize.MREC_300x250;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private class InterstitialAdListener implements OguryInterstitialAdListener {
        private final MaxInterstitialAdapterListener listener;
        private final String placementId;

        InterstitialAdListener(String str, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.placementId = str;
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.ogury.ad.OguryInterstitialAdListener, com.ogury.ad.internal.v5
        public void onAdLoaded(OguryInterstitialAd oguryInterstitialAd) {
            OguryPresageMediationAdapter.this.log("Interstitial loaded: " + this.placementId);
            this.listener.onInterstitialAdLoaded();
        }

        @Override // com.ogury.ad.OguryInterstitialAdListener, com.ogury.ad.internal.v5
        public void onAdImpression(OguryInterstitialAd oguryInterstitialAd) {
            OguryPresageMediationAdapter.this.log("Interstitial triggered impression: " + this.placementId);
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.ogury.ad.OguryInterstitialAdListener, com.ogury.ad.internal.v5
        public void onAdClicked(OguryInterstitialAd oguryInterstitialAd) {
            OguryPresageMediationAdapter.this.log("Interstitial clicked: " + this.placementId);
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.ogury.ad.OguryInterstitialAdListener, com.ogury.ad.internal.v5
        public void onAdClosed(OguryInterstitialAd oguryInterstitialAd) {
            OguryPresageMediationAdapter.this.log("Interstitial hidden: " + this.placementId);
            this.listener.onInterstitialAdHidden();
        }

        @Override // com.ogury.ad.OguryInterstitialAdListener, com.ogury.ad.internal.v5
        public void onAdError(OguryInterstitialAd oguryInterstitialAd, OguryAdError oguryAdError) {
            if (oguryAdError.getType() == OguryAdError.Type.SHOW_ERROR) {
                OguryPresageMediationAdapter.this.log("Interstitial (" + this.placementId + ") failed to show with error: " + oguryAdError);
                this.listener.onInterstitialAdDisplayFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            } else {
                OguryPresageMediationAdapter.this.log("Interstitial (" + this.placementId + ") failed to load with error: " + oguryAdError);
                this.listener.onInterstitialAdLoadFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            }
        }
    }

    private class RewardedAdListener implements OguryRewardedAdListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;
        private final String placementId;

        RewardedAdListener(String str, MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.placementId = str;
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.ogury.ad.OguryRewardedAdListener, com.ogury.ad.internal.v5
        public void onAdLoaded(OguryRewardedAd oguryRewardedAd) {
            OguryPresageMediationAdapter.this.log("Rewarded ad loaded: " + this.placementId);
            this.listener.onRewardedAdLoaded();
        }

        @Override // com.ogury.ad.OguryRewardedAdListener, com.ogury.ad.internal.v5
        public void onAdImpression(OguryRewardedAd oguryRewardedAd) {
            OguryPresageMediationAdapter.this.log("Rewarded ad triggered impression: " + this.placementId);
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.ogury.ad.OguryRewardedAdListener, com.ogury.ad.internal.v5
        public void onAdClicked(OguryRewardedAd oguryRewardedAd) {
            OguryPresageMediationAdapter.this.log("Rewarded ad clicked: " + this.placementId);
            this.listener.onRewardedAdClicked();
        }

        @Override // com.ogury.ad.OguryRewardedAdListener, com.ogury.ad.internal.v5
        public void onAdClosed(OguryRewardedAd oguryRewardedAd) {
            if (this.hasGrantedReward || OguryPresageMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = OguryPresageMediationAdapter.this.getReward();
                OguryPresageMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            OguryPresageMediationAdapter.this.log("Rewarded ad hidden: " + this.placementId);
            this.listener.onRewardedAdHidden();
        }

        @Override // com.ogury.ad.OguryRewardedAdListener
        public void onAdRewarded(OguryRewardedAd oguryRewardedAd, OguryReward oguryReward) {
            OguryPresageMediationAdapter.this.log("Rewarded ad (" + this.placementId + ") granted reward with rewardName: " + oguryReward.getName() + ", rewardValue: " + oguryReward.getValue());
            this.hasGrantedReward = true;
        }

        @Override // com.ogury.ad.OguryRewardedAdListener, com.ogury.ad.internal.v5
        public void onAdError(OguryRewardedAd oguryRewardedAd, OguryAdError oguryAdError) {
            if (oguryAdError.getType() == OguryAdError.Type.SHOW_ERROR) {
                OguryPresageMediationAdapter.this.log("Rewarded ad (" + this.placementId + ") failed to show with error: " + oguryAdError);
                this.listener.onRewardedAdDisplayFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            } else {
                OguryPresageMediationAdapter.this.log("Rewarded ad (" + this.placementId + ") failed to load with error: " + oguryAdError);
                this.listener.onRewardedAdLoadFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            }
        }
    }

    private class AdViewListener implements OguryBannerAdViewListener {
        private final MaxAdViewAdapterListener listener;
        private final String placementId;

        AdViewListener(String str, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = str;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.ogury.ad.OguryBannerAdViewListener, com.ogury.ad.internal.v5
        public void onAdLoaded(OguryBannerAdView oguryBannerAdView) {
            OguryPresageMediationAdapter.this.log("AdView loaded: " + this.placementId);
            this.listener.onAdViewAdLoaded(OguryPresageMediationAdapter.this.adView);
        }

        @Override // com.ogury.ad.OguryBannerAdViewListener, com.ogury.ad.internal.v5
        public void onAdImpression(OguryBannerAdView oguryBannerAdView) {
            OguryPresageMediationAdapter.this.log("AdView triggered impression: " + this.placementId);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.ogury.ad.OguryBannerAdViewListener, com.ogury.ad.internal.v5
        public void onAdClicked(OguryBannerAdView oguryBannerAdView) {
            OguryPresageMediationAdapter.this.log("AdView clicked: " + this.placementId);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.ogury.ad.OguryBannerAdViewListener, com.ogury.ad.internal.v5
        public void onAdClosed(OguryBannerAdView oguryBannerAdView) {
            OguryPresageMediationAdapter.this.log("AdView ad hidden: " + this.placementId);
        }

        @Override // com.ogury.ad.OguryBannerAdViewListener, com.ogury.ad.internal.v5
        public void onAdError(OguryBannerAdView oguryBannerAdView, OguryAdError oguryAdError) {
            if (oguryAdError.getType() == OguryAdError.Type.SHOW_ERROR) {
                OguryPresageMediationAdapter.this.log("AdView ad (" + this.placementId + ") failed to show with error: " + oguryAdError);
                this.listener.onAdViewAdDisplayFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            } else {
                OguryPresageMediationAdapter.this.log("AdView ad (" + this.placementId + ") failed to load with error: " + oguryAdError);
                this.listener.onAdViewAdLoadFailed(OguryPresageMediationAdapter.toMaxError(oguryAdError));
            }
        }
    }
}
