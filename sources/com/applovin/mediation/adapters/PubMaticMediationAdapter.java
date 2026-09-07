package com.applovin.mediation.adapters;

import android.app.Activity;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.utils.BundleUtils;
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
import com.applovin.mediation.adapters.pubmatic.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.OpenWrapSDKConfig;
import com.pubmatic.sdk.common.OpenWrapSDKInitializer;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.openwrap.banner.POBBannerView;
import com.pubmatic.sdk.openwrap.core.POBReward;
import com.pubmatic.sdk.openwrap.core.signal.POBBiddingHost;
import com.pubmatic.sdk.openwrap.core.signal.POBSignalConfig;
import com.pubmatic.sdk.openwrap.core.signal.POBSignalGenerator;
import com.pubmatic.sdk.openwrap.interstitial.POBInterstitial;
import com.pubmatic.sdk.rewardedad.POBRewardedAd;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public class PubMaticMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private POBBannerView adView;
    private POBInterstitial interstitialAd;
    private POBRewardedAd rewardedAd;

    public PubMaticMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            String string = BundleUtils.getString("publisher_id", maxAdapterInitializationParameters.getServerParameters());
            int i = BundleUtils.getInt("profile_id", maxAdapterInitializationParameters.getServerParameters());
            log("Initializing PubMatic SDK with publisherId: " + string + ", profileId: " + i + APSSharedUtil.TRUNCATE_SEPARATOR);
            OpenWrapSDK.initialize(getApplicationContext(), new OpenWrapSDKConfig.Builder(string, Collections.singletonList(Integer.valueOf(i))).build(), new OpenWrapSDKInitializer.Listener() { // from class: com.applovin.mediation.adapters.PubMaticMediationAdapter.1
                @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
                public void onSuccess() {
                    PubMaticMediationAdapter.this.log("PubMatic SDK initialized");
                    MaxAdapter.InitializationStatus unused = PubMaticMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(PubMaticMediationAdapter.status, null);
                }

                @Override // com.pubmatic.sdk.common.OpenWrapSDKInitializer.Listener
                public void onFailure(POBError pOBError) {
                    PubMaticMediationAdapter.this.log("PubMatic SDK failed to initialize with error: " + pOBError);
                    MaxAdapter.InitializationStatus unused = PubMaticMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(PubMaticMediationAdapter.status, pOBError.getErrorMessage());
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return OpenWrapSDK.getVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        POBAdFormat pubMaticAdFormat = toPubMaticAdFormat(maxAdapterSignalCollectionParameters.getAdFormat());
        if (pubMaticAdFormat == null) {
            maxSignalCollectionListener.onSignalCollectionFailed("Invalid ad format");
        } else {
            maxSignalCollectionListener.onSignalCollected(POBSignalGenerator.generateSignal(getApplicationContext(), POBBiddingHost.ALMAX, new POBSignalConfig.Builder(pubMaticAdFormat).setGpid(maxAdapterSignalCollectionParameters.getAdUnitId()).build()));
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAdapter
    public Boolean shouldLoadAdsOnUiThread(MaxAdFormat maxAdFormat) {
        return true;
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAdapter
    public Boolean shouldShowAdsOnUiThread(MaxAdFormat maxAdFormat) {
        return true;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        POBInterstitial pOBInterstitial = this.interstitialAd;
        if (pOBInterstitial != null) {
            pOBInterstitial.destroy();
            this.interstitialAd = null;
        }
        POBRewardedAd pOBRewardedAd = this.rewardedAd;
        if (pOBRewardedAd != null) {
            pOBRewardedAd.destroy();
            this.rewardedAd = null;
        }
        POBBannerView pOBBannerView = this.adView;
        if (pOBBannerView != null) {
            pOBBannerView.destroy();
            this.adView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading interstitial ad");
        POBInterstitial pOBInterstitial = new POBInterstitial(getApplicationContext());
        this.interstitialAd = pOBInterstitial;
        pOBInterstitial.setListener(new InterstitialListener(maxInterstitialAdapterListener));
        this.interstitialAd.loadAd(bidResponse);
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad");
        POBInterstitial pOBInterstitial = this.interstitialAd;
        if (pOBInterstitial == null) {
            log("Interstitial ad failed to load - ad not ready");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, 0, "Interstitial ad not ready"));
        } else {
            pOBInterstitial.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading rewarded ad");
        POBRewardedAd rewardedAd = POBRewardedAd.getRewardedAd(getApplicationContext());
        if (rewardedAd == null) {
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        this.rewardedAd = rewardedAd;
        rewardedAd.setListener(new RewardedListener(maxRewardedAdapterListener));
        this.rewardedAd.loadAd(bidResponse);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad");
        if (this.rewardedAd == null) {
            log("Rewarded ad failed to load - ad not ready");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, 0, "Rewarded ad not ready"));
        } else {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        log("Loading " + maxAdFormat.getLabel() + " ad");
        POBBannerView pOBBannerView = new POBBannerView(getApplicationContext());
        this.adView = pOBBannerView;
        pOBBannerView.setListener(new AdViewListener(maxAdViewAdapterListener));
        this.adView.loadAd(bidResponse);
        this.adView.pauseAutoRefresh();
    }

    private static POBAdFormat toPubMaticAdFormat(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return POBAdFormat.BANNER;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return POBAdFormat.BANNER;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return POBAdFormat.MREC;
        }
        if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
            return POBAdFormat.INTERSTITIAL;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED) {
            return POBAdFormat.REWARDEDAD;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    public static MaxAdapterError toMaxError(POBError pOBError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        int errorCode = pOBError.getErrorCode();
        if (errorCode == 2001) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        } else if (errorCode == 2002) {
            maxAdapterError = MaxAdapterError.AD_NOT_READY;
        } else if (errorCode != 3001) {
            if (errorCode != 5001 && errorCode != 5002) {
                switch (errorCode) {
                    case 1001:
                    case 1012:
                        maxAdapterError = MaxAdapterError.BAD_REQUEST;
                        break;
                    case 1002:
                        maxAdapterError = MaxAdapterError.NO_FILL;
                        break;
                    case 1003:
                        maxAdapterError = MaxAdapterError.NO_CONNECTION;
                        break;
                    case 1004:
                        maxAdapterError = MaxAdapterError.SERVER_ERROR;
                        break;
                    case 1005:
                        maxAdapterError = MaxAdapterError.TIMEOUT;
                        break;
                    case 1006:
                    case 1007:
                    case 1008:
                    case 1010:
                        maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                        break;
                    case 1009:
                        maxAdapterError = MaxAdapterError.WEBVIEW_ERROR;
                        break;
                    case 1011:
                        maxAdapterError = MaxAdapterError.AD_EXPIRED;
                        break;
                    case 1013:
                        maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                        break;
                }
            } else {
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
            }
        } else {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        }
        return new MaxAdapterError(maxAdapterError, pOBError.getErrorCode(), pOBError.getErrorMessage());
    }

    private class InterstitialListener extends POBInterstitial.POBInterstitialListener {
        private final MaxInterstitialAdapterListener listener;

        public InterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdReceived(POBInterstitial pOBInterstitial) {
            PubMaticMediationAdapter.this.log("Interstitial received");
            this.listener.onInterstitialAdLoaded();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdFailedToLoad(POBInterstitial pOBInterstitial, POBError pOBError) {
            MaxAdapterError maxError = PubMaticMediationAdapter.toMaxError(pOBError);
            PubMaticMediationAdapter.this.log("Interstitial failed to load with error: " + maxError);
            this.listener.onInterstitialAdLoadFailed(maxError);
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdImpression(POBInterstitial pOBInterstitial) {
            PubMaticMediationAdapter.this.log("Interstitial impression");
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdFailedToShow(POBInterstitial pOBInterstitial, POBError pOBError) {
            MaxAdapterError maxError = PubMaticMediationAdapter.toMaxError(pOBError);
            PubMaticMediationAdapter.this.log("Interstitial failed to show with error: " + maxError);
            this.listener.onInterstitialAdDisplayFailed(maxError);
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdClicked(POBInterstitial pOBInterstitial) {
            PubMaticMediationAdapter.this.log("Interstitial clicked");
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitial.POBInterstitialListener
        public void onAdClosed(POBInterstitial pOBInterstitial) {
            PubMaticMediationAdapter.this.log("Interstitial closed");
            this.listener.onInterstitialAdHidden();
        }
    }

    private class RewardedListener extends POBRewardedAd.POBRewardedAdListener {
        private boolean hasGrantedReward = false;
        private final MaxRewardedAdapterListener listener;

        public RewardedListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdReceived(POBRewardedAd pOBRewardedAd) {
            PubMaticMediationAdapter.this.log("Rewarded ad received");
            this.listener.onRewardedAdLoaded();
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdFailedToLoad(POBRewardedAd pOBRewardedAd, POBError pOBError) {
            MaxAdapterError maxError = PubMaticMediationAdapter.toMaxError(pOBError);
            PubMaticMediationAdapter.this.log("Rewarded ad failed to load with error: " + maxError);
            this.listener.onRewardedAdLoadFailed(maxError);
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdImpression(POBRewardedAd pOBRewardedAd) {
            PubMaticMediationAdapter.this.log("Rewarded ad impression");
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdFailedToShow(POBRewardedAd pOBRewardedAd, POBError pOBError) {
            MaxAdapterError maxError = PubMaticMediationAdapter.toMaxError(pOBError);
            PubMaticMediationAdapter.this.log("Rewarded ad failed to show with error: " + maxError);
            this.listener.onRewardedAdDisplayFailed(maxError);
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdClicked(POBRewardedAd pOBRewardedAd) {
            PubMaticMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onReceiveReward(POBRewardedAd pOBRewardedAd, POBReward pOBReward) {
            PubMaticMediationAdapter.this.log("Rewarded ad reward granted");
            this.hasGrantedReward = true;
        }

        @Override // com.pubmatic.sdk.rewardedad.POBRewardedAd.POBRewardedAdListener
        public void onAdClosed(POBRewardedAd pOBRewardedAd) {
            if (this.hasGrantedReward || PubMaticMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = PubMaticMediationAdapter.this.getReward();
                PubMaticMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            PubMaticMediationAdapter.this.log("Rewarded ad closed");
            this.listener.onRewardedAdHidden();
        }
    }

    private class AdViewListener extends POBBannerView.POBBannerViewListener {
        private final MaxAdViewAdapterListener listener;

        public AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.pubmatic.sdk.openwrap.banner.POBBannerView.POBBannerViewListener
        public void onAdReceived(POBBannerView pOBBannerView) {
            PubMaticMediationAdapter.this.log("Ad view received");
            this.listener.onAdViewAdLoaded(pOBBannerView);
        }

        @Override // com.pubmatic.sdk.openwrap.banner.POBBannerView.POBBannerViewListener
        public void onAdFailed(POBBannerView pOBBannerView, POBError pOBError) {
            MaxAdapterError maxError = PubMaticMediationAdapter.toMaxError(pOBError);
            PubMaticMediationAdapter.this.log("Ad view failed to load with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.pubmatic.sdk.openwrap.banner.POBBannerView.POBBannerViewListener
        public void onAdImpression(POBBannerView pOBBannerView) {
            PubMaticMediationAdapter.this.log("Ad view impression");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.pubmatic.sdk.openwrap.banner.POBBannerView.POBBannerViewListener
        public void onAdClicked(POBBannerView pOBBannerView) {
            PubMaticMediationAdapter.this.log("Ad view clicked");
            this.listener.onAdViewAdClicked();
        }
    }
}
