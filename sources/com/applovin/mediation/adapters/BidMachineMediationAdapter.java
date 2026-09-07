package com.applovin.mediation.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import io.bidmachine.AdsFormat;
import io.bidmachine.BidMachine;
import io.bidmachine.BidTokenCallback;
import io.bidmachine.ImageData;
import io.bidmachine.InitializationCallback;
import io.bidmachine.MediaAssetType;
import io.bidmachine.banner.BannerListener;
import io.bidmachine.banner.BannerRequest;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.banner.BannerView;
import io.bidmachine.interstitial.InterstitialAd;
import io.bidmachine.interstitial.InterstitialListener;
import io.bidmachine.interstitial.InterstitialRequest;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.nativead.NativeAd;
import io.bidmachine.nativead.NativeListener;
import io.bidmachine.nativead.NativeRequest;
import io.bidmachine.nativead.view.NativeMediaView;
import io.bidmachine.rewarded.RewardedAd;
import io.bidmachine.rewarded.RewardedListener;
import io.bidmachine.rewarded.RewardedRequest;
import io.bidmachine.utils.BMError;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public class BidMachineMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter, MaxNativeAdAdapter {
    private static final int DEFAULT_IMAGE_TASK_TIMEOUT_SECONDS = 10;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private BannerView adView;
    private InterstitialAd interstitialAd;
    private NativeAd nativeAd;
    private RewardedAd rewardedAd;

    public BidMachineMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            final String string = maxAdapterInitializationParameters.getServerParameters().getString("source_id");
            log("Initializing BidMachine SDK with source id: " + string);
            BidMachine.setLoggingEnabled(maxAdapterInitializationParameters.isTesting());
            BidMachine.setTestMode(maxAdapterInitializationParameters.isTesting());
            updateSettings(maxAdapterInitializationParameters);
            BidMachine.initialize(getApplicationContext(), string, new InitializationCallback() { // from class: com.applovin.mediation.adapters.BidMachineMediationAdapter.1
                @Override // io.bidmachine.InitializationCallback
                public void onInitialized() {
                    BidMachineMediationAdapter.this.log("BidMachine SDK successfully finished initialization with source id: " + string);
                    MaxAdapter.InitializationStatus unused = BidMachineMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(BidMachineMediationAdapter.status, null);
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return getVersionString(BidMachine.class, "VERSION");
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return "3.2.1.0";
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setListener(null);
            this.interstitialAd.destroy();
            this.interstitialAd = null;
        }
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null) {
            rewardedAd.setListener(null);
            this.rewardedAd.destroy();
            this.rewardedAd = null;
        }
        BannerView bannerView = this.adView;
        if (bannerView != null) {
            bannerView.setListener(null);
            this.adView.destroy();
            this.adView = null;
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.nativeAd.setListener(null);
            this.nativeAd.destroy();
            this.nativeAd = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal for " + maxAdapterSignalCollectionParameters.getAdFormat().getLabel() + " ad...");
        updateSettings(maxAdapterSignalCollectionParameters);
        BidMachine.getBidToken(getApplicationContext(), toAdsFormat(maxAdapterSignalCollectionParameters), new BidTokenCallback() { // from class: com.applovin.mediation.adapters.BidMachineMediationAdapter.2
            @Override // io.bidmachine.BidTokenCallback
            public void onCollected(String str) {
                BidMachineMediationAdapter.this.log("Signal collection successful");
                maxSignalCollectionListener.onSignalCollected(str);
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Loading interstitial ad...");
        updateSettings(maxAdapterResponseParameters);
        InterstitialAd interstitialAd = new InterstitialAd(getApplicationContext());
        this.interstitialAd = interstitialAd;
        interstitialAd.setListener(new InterstitialAdListener(maxInterstitialAdapterListener));
        this.interstitialAd.load((InterstitialRequest) ((InterstitialRequest.Builder) new InterstitialRequest.Builder().setBidPayload(maxAdapterResponseParameters.getBidResponse())).build());
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad...");
        if (this.interstitialAd.isExpired()) {
            log("Unable to show interstitial - ad expired");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        } else if (!this.interstitialAd.canShow()) {
            log("Unable to show interstitial - ad not ready");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, 0, "Interstitial ad not ready"));
        } else {
            this.interstitialAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Loading rewarded ad...");
        updateSettings(maxAdapterResponseParameters);
        RewardedAd rewardedAd = new RewardedAd(getApplicationContext());
        this.rewardedAd = rewardedAd;
        rewardedAd.setListener(new RewardedAdListener(maxRewardedAdapterListener));
        this.rewardedAd.load((RewardedRequest) ((RewardedRequest.Builder) new RewardedRequest.Builder().setBidPayload(maxAdapterResponseParameters.getBidResponse())).build());
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad...");
        if (this.rewardedAd.isExpired()) {
            log("Unable to show rewarded ad - ad expired");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        } else if (!this.rewardedAd.canShow()) {
            log("Unable to show rewarded ad - ad not ready");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, 0, "Rewarded ad not ready"));
        } else {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        log("Loading " + maxAdFormat.getLabel() + " ad...");
        updateSettings(maxAdapterResponseParameters);
        BannerView bannerView = new BannerView(getApplicationContext());
        this.adView = bannerView;
        bannerView.setListener(new AdViewListener(maxAdViewAdapterListener));
        this.adView.load((BannerRequest) ((BannerRequest.Builder) new BannerRequest.Builder().setSize(toAdSize(maxAdFormat)).setBidPayload(maxAdapterResponseParameters.getBidResponse())).build());
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        log("Loading native ad...");
        updateSettings(maxAdapterResponseParameters);
        NativeAd nativeAd = new NativeAd(getApplicationContext());
        this.nativeAd = nativeAd;
        nativeAd.setListener(new NativeAdListener(maxAdapterResponseParameters.getServerParameters(), maxNativeAdAdapterListener));
        this.nativeAd.load((NativeRequest) ((NativeRequest.Builder) new NativeRequest.Builder().setMediaAssetTypes(MediaAssetType.All).setBidPayload(maxAdapterResponseParameters.getBidResponse())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    public MaxAdapterError toMaxError(BMError bMError) {
        int code = bMError.getCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (code != 200) {
            switch (code) {
                case 100:
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                    break;
                case 101:
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                    break;
                case 102:
                    maxAdapterError = MaxAdapterError.TIMEOUT;
                    break;
                case 103:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                default:
                    switch (code) {
                        case 106:
                        case 108:
                            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                            break;
                        case 107:
                            maxAdapterError = MaxAdapterError.AD_EXPIRED;
                            break;
                        case 109:
                            maxAdapterError = MaxAdapterError.SERVER_ERROR;
                            break;
                        case 110:
                            maxAdapterError = MaxAdapterError.BAD_REQUEST;
                            break;
                    }
                    break;
            }
        } else {
            maxAdapterError = MaxAdapterError.SERVER_ERROR;
        }
        return new MaxAdapterError(maxAdapterError.getCode(), maxAdapterError.getMessage(), code, bMError.getMessage());
    }

    private BannerSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return BannerSize.Size_320x50;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return BannerSize.Size_728x90;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return BannerSize.Size_300x250;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    private AdsFormat toAdsFormat(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters) {
        MaxAdFormat adFormat = maxAdapterSignalCollectionParameters.getAdFormat();
        if (adFormat == MaxAdFormat.BANNER) {
            return AdsFormat.Banner_320x50;
        }
        if (adFormat == MaxAdFormat.MREC) {
            return AdsFormat.Banner_300x250;
        }
        if (adFormat == MaxAdFormat.LEADER) {
            return AdsFormat.Banner_728x90;
        }
        if (adFormat == MaxAdFormat.NATIVE) {
            return AdsFormat.Native;
        }
        if (adFormat == MaxAdFormat.INTERSTITIAL) {
            return AdsFormat.Interstitial;
        }
        if (adFormat == MaxAdFormat.REWARDED) {
            return AdsFormat.Rewarded;
        }
        return null;
    }

    private void updateSettings(MaxAdapterParameters maxAdapterParameters) {
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null) {
            BidMachine.setConsentConfig(boolHasUserConsent.booleanValue(), null);
        }
        Boolean boolIsDoNotSell = maxAdapterParameters.isDoNotSell();
        if (boolIsDoNotSell != null) {
            BidMachine.setUSPrivacyString(boolIsDoNotSell.booleanValue() ? "1YY-" : "1YN-");
        } else {
            BidMachine.setUSPrivacyString("1---");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCreativeId(AuctionResult auctionResult) {
        if (auctionResult != null) {
            return auctionResult.getCreativeId();
        }
        return null;
    }

    private class InterstitialAdListener implements InterstitialListener {
        private final MaxInterstitialAdapterListener listener;

        public InterstitialAdListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoaded(InterstitialAd interstitialAd) {
            Bundle bundle;
            BidMachineMediationAdapter.this.log("Interstitial ad loaded");
            String creativeId = BidMachineMediationAdapter.this.getCreativeId(interstitialAd.getAuctionResult());
            if (TextUtils.isEmpty(creativeId)) {
                bundle = null;
            } else {
                bundle = new Bundle(1);
                bundle.putString("creative_id", creativeId);
            }
            this.listener.onInterstitialAdLoaded(bundle);
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoadFailed(InterstitialAd interstitialAd, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("Interstitial ad failed to load with error (" + maxError + ")");
            this.listener.onInterstitialAdLoadFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdShowFailed(InterstitialAd interstitialAd, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("Interstitial ad failed to show with error (" + maxError + ")");
            this.listener.onInterstitialAdDisplayFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdImpression(InterstitialAd interstitialAd) {
            BidMachineMediationAdapter.this.log("Interstitial ad impression");
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // io.bidmachine.AdListener
        public void onAdClicked(InterstitialAd interstitialAd) {
            BidMachineMediationAdapter.this.log("Interstitial ad clicked");
            this.listener.onInterstitialAdClicked();
        }

        @Override // io.bidmachine.AdFullScreenListener
        public void onAdClosed(InterstitialAd interstitialAd, boolean z) {
            BidMachineMediationAdapter.this.log("Interstitial ad closed");
            this.listener.onInterstitialAdHidden();
        }

        @Override // io.bidmachine.AdListener
        public void onAdExpired(InterstitialAd interstitialAd) {
            BidMachineMediationAdapter.this.log("Interstitial ad expired");
        }
    }

    private class RewardedAdListener implements RewardedListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        public RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoaded(RewardedAd rewardedAd) {
            Bundle bundle;
            BidMachineMediationAdapter.this.log("Rewarded ad loaded");
            String creativeId = BidMachineMediationAdapter.this.getCreativeId(rewardedAd.getAuctionResult());
            if (TextUtils.isEmpty(creativeId)) {
                bundle = null;
            } else {
                bundle = new Bundle(1);
                bundle.putString("creative_id", creativeId);
            }
            this.listener.onRewardedAdLoaded(bundle);
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoadFailed(RewardedAd rewardedAd, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("Rewarded ad failed to load with error (" + maxError + ")");
            this.listener.onRewardedAdLoadFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdShowFailed(RewardedAd rewardedAd, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("Rewarded ad failed to show with error (" + maxError + ")");
            this.listener.onRewardedAdDisplayFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdImpression(RewardedAd rewardedAd) {
            BidMachineMediationAdapter.this.log("Rewarded ad impression");
            this.listener.onRewardedAdDisplayed();
        }

        @Override // io.bidmachine.AdListener
        public void onAdClicked(RewardedAd rewardedAd) {
            BidMachineMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // io.bidmachine.AdRewardedListener
        public void onAdRewarded(RewardedAd rewardedAd) {
            BidMachineMediationAdapter.this.log("Rewarded ad should grant reward");
            this.hasGrantedReward = true;
        }

        @Override // io.bidmachine.AdFullScreenListener
        public void onAdClosed(RewardedAd rewardedAd, boolean z) {
            BidMachineMediationAdapter.this.log("Rewarded ad closed");
            if (this.hasGrantedReward || BidMachineMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = BidMachineMediationAdapter.this.getReward();
                BidMachineMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            this.listener.onRewardedAdHidden();
        }

        @Override // io.bidmachine.AdListener
        public void onAdExpired(RewardedAd rewardedAd) {
            BidMachineMediationAdapter.this.log("Rewarded ad expired");
        }
    }

    private class AdViewListener implements BannerListener {
        private final MaxAdViewAdapterListener listener;

        public AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoaded(BannerView bannerView) {
            Bundle bundle;
            BidMachineMediationAdapter.this.log("AdView ad loaded");
            String creativeId = BidMachineMediationAdapter.this.getCreativeId(bannerView.getAuctionResult());
            if (TextUtils.isEmpty(creativeId)) {
                bundle = null;
            } else {
                bundle = new Bundle(1);
                bundle.putString("creative_id", creativeId);
            }
            this.listener.onAdViewAdLoaded(bannerView, bundle);
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoadFailed(BannerView bannerView, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("AdView ad failed to load with error (" + maxError + ")");
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdImpression(BannerView bannerView) {
            BidMachineMediationAdapter.this.log("AdView ad impression");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // io.bidmachine.AdListener
        public void onAdShowFailed(BannerView bannerView, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("AdView ad failed to show with error (" + maxError + ")");
            this.listener.onAdViewAdDisplayFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdClicked(BannerView bannerView) {
            BidMachineMediationAdapter.this.log("AdView ad clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // io.bidmachine.AdListener
        public void onAdExpired(BannerView bannerView) {
            BidMachineMediationAdapter.this.log("AdView ad expired");
        }
    }

    private class NativeAdListener implements NativeListener {
        private final MaxNativeAdAdapterListener listener;
        private final Bundle serverParameters;

        public NativeAdListener(Bundle bundle, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.serverParameters = bundle;
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoaded(final NativeAd nativeAd) {
            BidMachineMediationAdapter.this.log("Native ad loaded");
            if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)) && TextUtils.isEmpty(nativeAd.getTitle())) {
                BidMachineMediationAdapter.this.e("Native ad (" + nativeAd + ") does not have required assets.");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
                return;
            }
            ImageData icon = nativeAd.getIcon();
            MaxNativeAd.MaxNativeAdImage maxNativeAdImage = null;
            if (icon == null) {
                handleNativeAdLoaded(nativeAd, null);
                return;
            }
            Drawable image = icon.getImage();
            Uri localUri = icon.getLocalUri();
            final String remoteUrl = icon.getRemoteUrl();
            if (image != null) {
                maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(image);
            } else if (localUri != null) {
                maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(localUri);
            } else if (remoteUrl != null) {
                BidMachineMediationAdapter.this.getCachingExecutorService().execute(new Runnable() { // from class: com.applovin.mediation.adapters.BidMachineMediationAdapter.NativeAdListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        BidMachineMediationAdapter.this.log("Adding native ad icon (" + remoteUrl + ") to queue to be fetched");
                        try {
                            drawable = BidMachineMediationAdapter.this.createDrawableFuture(remoteUrl, BidMachineMediationAdapter.this.getApplicationContext().getResources()).get(BundleUtils.getInt("image_task_timeout_seconds", 10, NativeAdListener.this.serverParameters), TimeUnit.SECONDS);
                        } catch (Throwable th) {
                            BidMachineMediationAdapter.this.e("Failed to fetch icon image", th);
                            drawable = null;
                        }
                        NativeAdListener.this.handleNativeAdLoaded(nativeAd, new MaxNativeAd.MaxNativeAdImage(drawable));
                    }
                });
                return;
            }
            handleNativeAdLoaded(nativeAd, maxNativeAdImage);
        }

        @Override // io.bidmachine.AdListener
        public void onAdLoadFailed(NativeAd nativeAd, BMError bMError) {
            MaxAdapterError maxError = BidMachineMediationAdapter.this.toMaxError(bMError);
            BidMachineMediationAdapter.this.log("Native ad failed to load with error (" + maxError + ")");
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // io.bidmachine.AdListener
        public void onAdImpression(NativeAd nativeAd) {
            BidMachineMediationAdapter.this.log("Native ad impression");
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // io.bidmachine.AdListener
        public void onAdShowFailed(NativeAd nativeAd, BMError bMError) {
            BidMachineMediationAdapter.this.log("Native ad failed to show with error (" + bMError + ")");
        }

        @Override // io.bidmachine.AdListener
        public void onAdClicked(NativeAd nativeAd) {
            BidMachineMediationAdapter.this.log("Native ad clicked");
            this.listener.onNativeAdClicked();
        }

        @Override // io.bidmachine.AdListener
        public void onAdExpired(NativeAd nativeAd) {
            BidMachineMediationAdapter.this.log("Native ad expired");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleNativeAdLoaded(final NativeAd nativeAd, final MaxNativeAd.MaxNativeAdImage maxNativeAdImage) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.BidMachineMediationAdapter.NativeAdListener.2
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle;
                    MaxNativeAd.Builder mediaView = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(nativeAd.getTitle()).setBody(nativeAd.getDescription()).setCallToAction(nativeAd.getCallToAction()).setIcon(maxNativeAdImage).setOptionsView(nativeAd.getProviderView(BidMachineMediationAdapter.this.getApplicationContext())).setMediaView(new NativeMediaView(BidMachineMediationAdapter.this.getApplicationContext()));
                    if (nativeAd.getMainImage() != null) {
                        mediaView.setMainImage(new MaxNativeAd.MaxNativeAdImage(nativeAd.getMainImage().getImage()));
                    }
                    MaxBidMachineNativeAd maxBidMachineNativeAd = BidMachineMediationAdapter.this.new MaxBidMachineNativeAd(mediaView);
                    String creativeId = BidMachineMediationAdapter.this.getCreativeId(nativeAd.getAuctionResult());
                    if (TextUtils.isEmpty(creativeId)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle(1);
                        bundle.putString("creative_id", creativeId);
                    }
                    NativeAdListener.this.listener.onNativeAdLoaded(maxBidMachineNativeAd, bundle);
                }
            });
        }
    }

    private class MaxBidMachineNativeAd extends MaxNativeAd {
        public MaxBidMachineNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            ImageView imageView;
            NativeAd nativeAd = BidMachineMediationAdapter.this.nativeAd;
            if (nativeAd == null) {
                BidMachineMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
                return false;
            }
            BidMachineMediationAdapter.this.d("Preparing views for interaction: " + list + " with container: " + viewGroup);
            HashSet hashSet = new HashSet(list);
            for (View view : list) {
                if (view instanceof ImageView) {
                    imageView = (ImageView) view;
                    nativeAd.registerView(viewGroup, imageView, (NativeMediaView) getMediaView(), hashSet);
                    return true;
                }
            }
            imageView = null;
            nativeAd.registerView(viewGroup, imageView, (NativeMediaView) getMediaView(), hashSet);
            return true;
        }
    }
}
