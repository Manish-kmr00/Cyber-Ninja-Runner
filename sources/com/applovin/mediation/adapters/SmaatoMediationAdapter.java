package com.applovin.mediation.adapters;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.applovin.mediation.adapters.smaato.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.Config;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.lifecycle.Lifecycling;
import com.smaato.sdk.core.log.LogLevel;
import com.smaato.sdk.iahb.InAppBid;
import com.smaato.sdk.iahb.InAppBiddingException;
import com.smaato.sdk.iahb.SmaatoSdkInAppBidding;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.Interstitial;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;
import com.smaato.sdk.nativead.NativeAd;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.NativeAdError;
import com.smaato.sdk.nativead.NativeAdRenderer;
import com.smaato.sdk.nativead.NativeAdRequest;
import com.smaato.sdk.rewarded.RewardedError;
import com.smaato.sdk.rewarded.RewardedInterstitial;
import com.smaato.sdk.rewarded.RewardedInterstitialAd;
import com.smaato.sdk.rewarded.RewardedRequestError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class SmaatoMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter {
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();
    private static final SmaatoMediationAdapterRouter ROUTER = (SmaatoMediationAdapterRouter) MediationAdapterRouter.getSharedInstance(SmaatoMediationAdapterRouter.class);
    private BannerView adView;
    private InterstitialAd interstitialAd;
    private NativeAdRenderer nativeAdRenderer;
    private String placementId;
    private RewardedInterstitialAd rewardedAd;

    public SmaatoMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        if (INITIALIZED.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("pub_id", "");
            log("Initializing Smaato SDK with publisher id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            SmaatoSdk.init((Application) getContext(activity), Config.builder().setLogLevel(maxAdapterInitializationParameters.isTesting() ? LogLevel.DEBUG : LogLevel.ERROR).build(), string);
            updateLocationCollectionEnabled(maxAdapterInitializationParameters);
        }
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return SmaatoSdk.getVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        updateLocationCollectionEnabled(maxAdapterSignalCollectionParameters);
        maxSignalCollectionListener.onSignalCollected(SmaatoSdk.collectSignals(getContext(activity)));
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        BannerView bannerView = this.adView;
        if (bannerView != null) {
            bannerView.setEventListener(null);
            this.adView.destroy();
            this.adView = null;
        }
        this.interstitialAd = null;
        this.rewardedAd = null;
        this.nativeAdRenderer = null;
        ROUTER.removeAdapter(this, this.placementId);
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        log("Loading " + (zIsValidString ? "bidding " : "") + (z ? "native " : "") + maxAdFormat.getLabel() + " ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        if (z) {
            if (activity == null) {
                log("Native " + maxAdFormat.getLabel() + " ad load failed: Activity is null");
                maxAdViewAdapterListener.onAdViewAdLoadFailed(new MaxAdapterError(-5601, "Missing Activity"));
                return;
            }
            NativeAdRequest nativeAdRequestCreateNativeAdRequest = createNativeAdRequest(thirdPartyAdPlacementId, bidResponse);
            if (nativeAdRequestCreateNativeAdRequest == null) {
                log(maxAdFormat.getLabel() + " ad load failed: ad request null with invalid bid response");
                maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
                return;
            } else {
                NativeAd.loadAd(Lifecycling.of(activity), nativeAdRequestCreateNativeAdRequest, new NativeAdViewListener(maxAdapterResponseParameters, maxAdFormat, getContext(activity), maxAdViewAdapterListener));
                return;
            }
        }
        BannerView bannerView = new BannerView(getContext(activity));
        this.adView = bannerView;
        bannerView.setAutoReloadInterval(AutoReloadInterval.DISABLED);
        this.adView.setEventListener(new AdViewListener(maxAdViewAdapterListener));
        if (zIsValidString) {
            AdRequestParams adRequestParamsCreateBiddingAdRequestParams = createBiddingAdRequestParams(bidResponse);
            if (adRequestParamsCreateBiddingAdRequestParams == null || adRequestParamsCreateBiddingAdRequestParams.getUBUniqueId() == null) {
                log(maxAdFormat.getLabel() + " ad load failed: ad request null with invalid bid response");
                maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
                return;
            } else {
                this.adView.loadAd(thirdPartyAdPlacementId, toAdSize(maxAdFormat), adRequestParamsCreateBiddingAdRequestParams);
                return;
            }
        }
        this.adView.loadAd(thirdPartyAdPlacementId, toAdSize(maxAdFormat));
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading " + (AppLovinSdkUtils.isValidString(bidResponse) ? "bidding " : "") + "interstitial ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        SmaatoMediationAdapterRouter smaatoMediationAdapterRouter = ROUTER;
        smaatoMediationAdapterRouter.addInterstitialAdapter(this, maxInterstitialAdapterListener, thirdPartyAdPlacementId);
        InterstitialAd interstitialAd = smaatoMediationAdapterRouter.getInterstitialAd(thirdPartyAdPlacementId);
        if (interstitialAd != null && interstitialAd.isAvailableForPresentation()) {
            log("Interstitial ad already loaded for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
            maxInterstitialAdapterListener.onInterstitialAdLoaded();
        } else {
            if (AppLovinSdkUtils.isValidString(bidResponse)) {
                AdRequestParams adRequestParamsCreateBiddingAdRequestParams = createBiddingAdRequestParams(bidResponse);
                if (adRequestParamsCreateBiddingAdRequestParams != null && adRequestParamsCreateBiddingAdRequestParams.getUBUniqueId() != null) {
                    Interstitial.loadAd(thirdPartyAdPlacementId, smaatoMediationAdapterRouter, adRequestParamsCreateBiddingAdRequestParams);
                    return;
                } else {
                    log("Interstitial load failed: ad request null with invalid bid response");
                    maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
                    return;
                }
            }
            Interstitial.loadAd(thirdPartyAdPlacementId, smaatoMediationAdapterRouter);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing interstitial ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        SmaatoMediationAdapterRouter smaatoMediationAdapterRouter = ROUTER;
        smaatoMediationAdapterRouter.addShowingAdapter(this);
        InterstitialAd interstitialAd = smaatoMediationAdapterRouter.getInterstitialAd(thirdPartyAdPlacementId);
        this.interstitialAd = interstitialAd;
        if (interstitialAd == null || !interstitialAd.isAvailableForPresentation()) {
            log("Interstitial ad failed to load - ad not ready");
            smaatoMediationAdapterRouter.onAdDisplayFailed(thirdPartyAdPlacementId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        } else if (activity == null) {
            log("Interstitial ad display failed: Activity is null");
            smaatoMediationAdapterRouter.onAdDisplayFailed(thirdPartyAdPlacementId, MaxAdapterError.MISSING_ACTIVITY);
        } else {
            this.interstitialAd.showAd(activity);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading " + (AppLovinSdkUtils.isValidString(bidResponse) ? "bidding " : "") + "rewarded ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        SmaatoMediationAdapterRouter smaatoMediationAdapterRouter = ROUTER;
        smaatoMediationAdapterRouter.addRewardedAdapter(this, maxRewardedAdapterListener, thirdPartyAdPlacementId);
        RewardedInterstitialAd rewardedAd = smaatoMediationAdapterRouter.getRewardedAd(thirdPartyAdPlacementId);
        if (rewardedAd != null && rewardedAd.isAvailableForPresentation()) {
            log("Rewarded ad already loaded for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
            maxRewardedAdapterListener.onRewardedAdLoaded();
        } else {
            if (AppLovinSdkUtils.isValidString(bidResponse)) {
                AdRequestParams adRequestParamsCreateBiddingAdRequestParams = createBiddingAdRequestParams(bidResponse);
                if (adRequestParamsCreateBiddingAdRequestParams != null && adRequestParamsCreateBiddingAdRequestParams.getUBUniqueId() != null) {
                    RewardedInterstitial.loadAd(thirdPartyAdPlacementId, smaatoMediationAdapterRouter, adRequestParamsCreateBiddingAdRequestParams);
                    return;
                } else {
                    log("Rewarded ad load failed: ad request null with invalid bid response");
                    maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
                    return;
                }
            }
            RewardedInterstitial.loadAd(thirdPartyAdPlacementId, smaatoMediationAdapterRouter);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        SmaatoMediationAdapterRouter smaatoMediationAdapterRouter = ROUTER;
        smaatoMediationAdapterRouter.addShowingAdapter(this);
        RewardedInterstitialAd rewardedAd = smaatoMediationAdapterRouter.getRewardedAd(thirdPartyAdPlacementId);
        this.rewardedAd = rewardedAd;
        if (rewardedAd != null && rewardedAd.isAvailableForPresentation()) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.showAd();
        } else {
            log("Rewarded ad not ready.");
            smaatoMediationAdapterRouter.onAdDisplayFailed(thirdPartyAdPlacementId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading " + (AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "") + "native ad for placement: " + thirdPartyAdPlacementId + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (activity == null) {
            log("Native ad load failed: Activity is null");
            maxNativeAdAdapterListener.onNativeAdLoadFailed(new MaxAdapterError(-5601, "Missing Activity"));
            return;
        }
        updateLocationCollectionEnabled(maxAdapterResponseParameters);
        NativeAdRequest nativeAdRequestCreateNativeAdRequest = createNativeAdRequest(thirdPartyAdPlacementId, bidResponse);
        if (nativeAdRequestCreateNativeAdRequest == null) {
            log("Native ad load failed: ad request null with invalid bid response");
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
        } else {
            NativeAd.loadAd(Lifecycling.of(activity), nativeAdRequestCreateNativeAdRequest, new NativeAdListener(maxAdapterResponseParameters, getContext(activity), maxNativeAdAdapterListener));
        }
    }

    private void updateLocationCollectionEnabled(MaxAdapterParameters maxAdapterParameters) {
        Object obj = maxAdapterParameters.getLocalExtraParameters().get("is_location_collection_enabled");
        if (obj instanceof Boolean) {
            log("Setting location collection enabled: " + obj);
            SmaatoSdk.setGPSEnabled(((Boolean) obj).booleanValue());
        }
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplication() : getApplicationContext();
    }

    private BannerAdSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return BannerAdSize.XX_LARGE_320x50;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return BannerAdSize.MEDIUM_RECTANGLE_300x250;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return BannerAdSize.LEADERBOARD_728x90;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(BannerError bannerError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$banner$widget$BannerError[bannerError.ordinal()]) {
            case 1:
                maxAdapterError = MaxAdapterError.NO_FILL;
                break;
            case 2:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
            case 3:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 4:
            case 5:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 6:
                maxAdapterError = MaxAdapterError.AD_EXPIRED;
                break;
            case 7:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                break;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), bannerError.ordinal(), bannerError.name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(NativeAdError nativeAdError) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$nativead$NativeAdError[nativeAdError.ordinal()];
        if (i == 1) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else if (i == 2) {
            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
        } else if (i == 3) {
            maxAdapterError = MaxAdapterError.NO_CONNECTION;
        } else if (i == 4 || i == 5) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), nativeAdError.ordinal(), nativeAdError.name());
    }

    private AdRequestParams createBiddingAdRequestParams(String str) {
        try {
            return AdRequestParams.builder().setUBUniqueId(SmaatoSdkInAppBidding.saveBid(InAppBid.create(str))).build();
        } catch (InAppBiddingException e) {
            log("Error occurred in saving pre-bid: " + str, e);
            return null;
        }
    }

    private NativeAdRequest createNativeAdRequest(String str, String str2) {
        NativeAdRequest.Builder builderShouldReturnUrlsForImageAssets = NativeAdRequest.builder().adSpaceId(str).shouldReturnUrlsForImageAssets(false);
        if (AppLovinSdkUtils.isValidString(str2)) {
            AdRequestParams adRequestParamsCreateBiddingAdRequestParams = createBiddingAdRequestParams(str2);
            if (adRequestParamsCreateBiddingAdRequestParams == null || adRequestParamsCreateBiddingAdRequestParams.getUBUniqueId() == null) {
                return null;
            }
            builderShouldReturnUrlsForImageAssets.uniqueUBId(adRequestParamsCreateBiddingAdRequestParams.getUBUniqueId());
        }
        return builderShouldReturnUrlsForImageAssets.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<View> getClickableViews(MaxNativeAd maxNativeAd, MaxNativeAdView maxNativeAdView) {
        ArrayList arrayList = new ArrayList(6);
        if (AppLovinSdkUtils.isValidString(maxNativeAd.getTitle()) && maxNativeAdView.getTitleTextView() != null) {
            arrayList.add(maxNativeAdView.getTitleTextView());
        }
        if (AppLovinSdkUtils.isValidString(maxNativeAd.getAdvertiser()) && maxNativeAdView.getAdvertiserTextView() != null) {
            arrayList.add(maxNativeAdView.getAdvertiserTextView());
        }
        if (AppLovinSdkUtils.isValidString(maxNativeAd.getBody()) && maxNativeAdView.getBodyTextView() != null) {
            arrayList.add(maxNativeAdView.getBodyTextView());
        }
        if (AppLovinSdkUtils.isValidString(maxNativeAd.getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
            arrayList.add(maxNativeAdView.getCallToActionButton());
        }
        if (maxNativeAd.getIcon() != null && maxNativeAdView.getIconImageView() != null) {
            arrayList.add(maxNativeAdView.getIconImageView());
        }
        if (maxNativeAd.getMediaView() != null && maxNativeAdView.getMediaContentViewGroup() != null) {
            arrayList.add(maxNativeAdView.getMediaContentViewGroup());
        }
        return arrayList;
    }

    private class AdViewListener implements BannerView.EventListener {
        private final MaxAdViewAdapterListener listener;

        AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.smaato.sdk.banner.widget.BannerView.EventListener
        public void onAdLoaded(BannerView bannerView) {
            SmaatoMediationAdapter.this.log("AdView loaded");
            if (TextUtils.isEmpty(bannerView.getCreativeId())) {
                this.listener.onAdViewAdLoaded(SmaatoMediationAdapter.this.adView);
                return;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", bannerView.getCreativeId());
            this.listener.onAdViewAdLoaded(SmaatoMediationAdapter.this.adView, bundle);
        }

        @Override // com.smaato.sdk.banner.widget.BannerView.EventListener
        public void onAdFailedToLoad(BannerView bannerView, BannerError bannerError) {
            SmaatoMediationAdapter.this.log("AdView load failed to load with error: " + bannerError);
            this.listener.onAdViewAdLoadFailed(SmaatoMediationAdapter.toMaxError(bannerError));
        }

        @Override // com.smaato.sdk.banner.widget.BannerView.EventListener
        public void onAdImpression(BannerView bannerView) {
            SmaatoMediationAdapter.this.log("AdView displayed");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.smaato.sdk.banner.widget.BannerView.EventListener
        public void onAdClicked(BannerView bannerView) {
            SmaatoMediationAdapter.this.log("AdView clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.smaato.sdk.banner.widget.BannerView.EventListener
        public void onAdTTLExpired(BannerView bannerView) {
            SmaatoMediationAdapter.this.log("AdView ad expired");
        }
    }

    private class NativeAdViewListener implements NativeAd.Listener {
        final MaxAdFormat adFormat;
        final Context context;
        final MaxAdViewAdapterListener listener;
        final String placementId;
        final Bundle serverParameters;

        public NativeAdViewListener(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Context context, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.adFormat = maxAdFormat;
            this.context = context;
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdLoaded(final NativeAd nativeAd, final NativeAdRenderer nativeAdRenderer) {
            SmaatoMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded: " + this.placementId);
            SmaatoMediationAdapter.this.nativeAdRenderer = nativeAdRenderer;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.SmaatoMediationAdapter.NativeAdViewListener.1
                /* JADX WARN: Code duplicated, block: B:17:0x009d  */
                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    NativeAdAssets assets = nativeAdRenderer.getAssets();
                    if (TextUtils.isEmpty(assets.title())) {
                        SmaatoMediationAdapter.this.e("Native " + NativeAdViewListener.this.adFormat.getLabel() + " ad (" + nativeAd + ") does not have required assets.");
                        NativeAdViewListener.this.listener.onAdViewAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
                        return;
                    }
                    AnonymousClass1 anonymousClass1 = null;
                    MaxNativeAd.MaxNativeAdImage maxNativeAdImage = (assets.icon() == null || assets.icon().drawable() == null) ? null : new MaxNativeAd.MaxNativeAdImage(assets.icon().drawable());
                    if (assets.images().size() > 0) {
                        NativeAdAssets.Image image = assets.images().get(0);
                        if (image.drawable() != null) {
                            imageView = new ImageView(NativeAdViewListener.this.context);
                            imageView.setImageDrawable(image.drawable());
                        } else {
                            imageView = null;
                        }
                    } else {
                        imageView = null;
                    }
                    NativeAdViewListener nativeAdViewListener = NativeAdViewListener.this;
                    String validTemplateName = nativeAdViewListener.getValidTemplateName(BundleUtils.getString("template", "", nativeAdViewListener.serverParameters));
                    MaxSmaatoNativeAd maxSmaatoNativeAd = new MaxSmaatoNativeAd(SmaatoMediationAdapter.this, new MaxNativeAd.Builder().setAdFormat(NativeAdViewListener.this.adFormat).setTitle(assets.title()).setAdvertiser(assets.sponsored()).setBody(assets.text()).setCallToAction(assets.cta()).setIcon(maxNativeAdImage).setMediaView(imageView), anonymousClass1);
                    MaxNativeAdView maxNativeAdView = new MaxNativeAdView(maxSmaatoNativeAd, validTemplateName, NativeAdViewListener.this.context);
                    maxSmaatoNativeAd.prepareForInteraction(SmaatoMediationAdapter.getClickableViews(maxSmaatoNativeAd, maxNativeAdView), maxNativeAdView);
                    SmaatoMediationAdapter.this.log("Native " + NativeAdViewListener.this.adFormat.getLabel() + " ad fully loaded: " + NativeAdViewListener.this.placementId);
                    NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdView);
                }
            });
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdFailedToLoad(NativeAd nativeAd, NativeAdError nativeAdError) {
            MaxAdapterError maxError = SmaatoMediationAdapter.toMaxError(nativeAdError);
            SmaatoMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad (" + this.placementId + ") failed to load with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdImpressed(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad shown: " + this.placementId);
            this.listener.onAdViewAdDisplayed(null);
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdClicked(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad clicked: " + this.placementId);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onTtlExpired(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad expired");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getValidTemplateName(String str) {
            if (AppLovinSdkUtils.isValidString(str)) {
                if (str.contains("media") || str.contains("leader")) {
                    return str;
                }
                if (str.contains("vertical")) {
                    return this.adFormat == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template";
                }
                return "media_banner_template";
            }
            return "media_banner_template";
        }
    }

    private class NativeAdListener implements NativeAd.Listener {
        final Context context;
        final MaxNativeAdAdapterListener listener;
        final String placementId;
        final Bundle serverParameters;

        public NativeAdListener(MaxAdapterResponseParameters maxAdapterResponseParameters, Context context, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.context = context;
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdLoaded(final NativeAd nativeAd, final NativeAdRenderer nativeAdRenderer) {
            SmaatoMediationAdapter.this.log("Native ad loaded: " + this.placementId);
            SmaatoMediationAdapter.this.nativeAdRenderer = nativeAdRenderer;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.SmaatoMediationAdapter.NativeAdListener.1
                /* JADX WARN: Code duplicated, block: B:19:0x00a7  */
                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    MaxNativeAd.MaxNativeAdImage maxNativeAdImage;
                    NativeAdAssets assets = nativeAdRenderer.getAssets();
                    if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", NativeAdListener.this.serverParameters)) && TextUtils.isEmpty(assets.title())) {
                        SmaatoMediationAdapter.this.e("Native ad (" + nativeAd + ") does not have required assets.");
                        NativeAdListener.this.listener.onNativeAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
                        return;
                    }
                    AnonymousClass1 anonymousClass1 = null;
                    MaxNativeAd.MaxNativeAdImage maxNativeAdImage2 = (assets.icon() == null || assets.icon().drawable() == null) ? null : new MaxNativeAd.MaxNativeAdImage(assets.icon().drawable());
                    if (assets.images().size() > 0) {
                        NativeAdAssets.Image image = assets.images().get(0);
                        if (image.drawable() != null) {
                            imageView = new ImageView(NativeAdListener.this.context);
                            imageView.setImageDrawable(image.drawable());
                            maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(image.drawable());
                        } else {
                            imageView = null;
                            maxNativeAdImage = null;
                        }
                    } else {
                        imageView = null;
                        maxNativeAdImage = null;
                    }
                    MaxNativeAd.Builder mediaView = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(assets.title()).setAdvertiser(assets.sponsored()).setBody(assets.text()).setCallToAction(assets.cta()).setIcon(maxNativeAdImage2).setMediaView(imageView);
                    if (AppLovinSdk.VERSION_CODE >= 11040399) {
                        mediaView.setMainImage(maxNativeAdImage);
                    }
                    MaxSmaatoNativeAd maxSmaatoNativeAd = new MaxSmaatoNativeAd(SmaatoMediationAdapter.this, mediaView, anonymousClass1);
                    SmaatoMediationAdapter.this.log("Native ad fully loaded: " + NativeAdListener.this.placementId);
                    NativeAdListener.this.listener.onNativeAdLoaded(maxSmaatoNativeAd, null);
                }
            });
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdFailedToLoad(NativeAd nativeAd, NativeAdError nativeAdError) {
            MaxAdapterError maxError = SmaatoMediationAdapter.toMaxError(nativeAdError);
            SmaatoMediationAdapter.this.log("Native ad (" + this.placementId + ") failed to load with error: " + maxError);
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdImpressed(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native ad shown");
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onAdClicked(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native ad clicked");
            this.listener.onNativeAdClicked();
        }

        @Override // com.smaato.sdk.nativead.NativeAd.Listener
        public void onTtlExpired(NativeAd nativeAd) {
            SmaatoMediationAdapter.this.log("Native ad expired");
        }
    }

    private class MaxSmaatoNativeAd extends MaxNativeAd {
        /* synthetic */ MaxSmaatoNativeAd(SmaatoMediationAdapter smaatoMediationAdapter, MaxNativeAd.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private MaxSmaatoNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            NativeAdRenderer nativeAdRenderer = SmaatoMediationAdapter.this.nativeAdRenderer;
            if (nativeAdRenderer == null) {
                SmaatoMediationAdapter.this.e("Failed to register native ad view for interaction. Native ad renderer is null");
                return false;
            }
            SmaatoMediationAdapter.this.d("Preparing views for interaction with container: " + viewGroup);
            nativeAdRenderer.registerForImpression(viewGroup);
            nativeAdRenderer.registerForClicks(viewGroup);
            nativeAdRenderer.registerForClicks(list);
            return true;
        }
    }

    private static class SmaatoMediationAdapterRouter extends MediationAdapterRouter implements EventListener, com.smaato.sdk.rewarded.EventListener {
        private boolean hasGrantedReward;
        private final Map<String, InterstitialAd> interstitialAds = new HashMap();
        private final Object interstitialAdsLock = new Object();
        private final Map<String, RewardedInterstitialAd> rewardedAds = new HashMap();
        private final Object rewardedAdsLock = new Object();

        @Override // com.applovin.mediation.adapters.MediationAdapterRouter
        void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        }

        private SmaatoMediationAdapterRouter() {
        }

        public InterstitialAd getInterstitialAd(String str) {
            InterstitialAd interstitialAd;
            synchronized (this.interstitialAdsLock) {
                interstitialAd = this.interstitialAds.get(str);
            }
            return interstitialAd;
        }

        public RewardedInterstitialAd getRewardedAd(String str) {
            RewardedInterstitialAd rewardedInterstitialAd;
            synchronized (this.rewardedAdsLock) {
                rewardedInterstitialAd = this.rewardedAds.get(str);
            }
            return rewardedInterstitialAd;
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdLoaded(InterstitialAd interstitialAd) {
            String adSpaceId = interstitialAd.getAdSpaceId();
            synchronized (this.interstitialAdsLock) {
                this.interstitialAds.put(adSpaceId, interstitialAd);
            }
            log("Interstitial loaded for placement: " + adSpaceId + APSSharedUtil.TRUNCATE_SEPARATOR);
            onAdLoaded(adSpaceId, interstitialAd.getCreativeId());
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdFailedToLoad(InterstitialRequestError interstitialRequestError) {
            String adSpaceId = interstitialRequestError.getAdSpaceId();
            log("Interstitial failed to load for placement: " + adSpaceId + "...with error: " + interstitialRequestError.getInterstitialError());
            onAdLoadFailed(adSpaceId, toMaxError(interstitialRequestError.getInterstitialError()));
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdError(InterstitialAd interstitialAd, InterstitialError interstitialError) {
            log("Interstitial failed to display with error: " + interstitialError);
            if (interstitialAd != null) {
                String adSpaceId = interstitialAd.getAdSpaceId();
                synchronized (this.interstitialAdsLock) {
                    this.interstitialAds.remove(adSpaceId);
                }
                onAdDisplayFailed(adSpaceId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", interstitialError.ordinal(), interstitialError.name()));
            }
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdImpression(InterstitialAd interstitialAd) {
            String adSpaceId = interstitialAd.getAdSpaceId();
            synchronized (this.interstitialAdsLock) {
                this.interstitialAds.remove(adSpaceId);
            }
            log("Interstitial displayed");
            onAdDisplayed(adSpaceId);
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdOpened(InterstitialAd interstitialAd) {
            log("Interstitial opened");
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdClicked(InterstitialAd interstitialAd) {
            log("Interstitial clicked");
            onAdClicked(interstitialAd.getAdSpaceId());
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdClosed(InterstitialAd interstitialAd) {
            log("Interstitial hidden");
            onAdHidden(interstitialAd.getAdSpaceId());
        }

        @Override // com.smaato.sdk.interstitial.EventListener
        public void onAdTTLExpired(InterstitialAd interstitialAd) {
            log("Interstitial expired");
            synchronized (this.interstitialAdsLock) {
                this.interstitialAds.remove(interstitialAd.getAdSpaceId());
            }
        }

        private static MaxAdapterError toMaxError(InterstitialError interstitialError) {
            MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
            switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$interstitial$InterstitialError[interstitialError.ordinal()]) {
                case 1:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                case 2:
                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                    break;
                case 3:
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                    break;
                case 4:
                case 5:
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                    break;
                case 6:
                    maxAdapterError = MaxAdapterError.AD_EXPIRED;
                    break;
                case 7:
                    maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                    break;
            }
            return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), interstitialError.ordinal(), interstitialError.name());
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdLoaded(RewardedInterstitialAd rewardedInterstitialAd) {
            String adSpaceId = rewardedInterstitialAd.getAdSpaceId();
            synchronized (this.rewardedAdsLock) {
                this.rewardedAds.put(adSpaceId, rewardedInterstitialAd);
            }
            log("Rewarded ad loaded for placement: " + adSpaceId + APSSharedUtil.TRUNCATE_SEPARATOR);
            onAdLoaded(adSpaceId, rewardedInterstitialAd.getCreativeId());
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdFailedToLoad(RewardedRequestError rewardedRequestError) {
            String adSpaceId = rewardedRequestError.getAdSpaceId();
            log("Rewarded ad failed to load for placement: " + adSpaceId + "...with error: " + rewardedRequestError.getRewardedError());
            onAdLoadFailed(adSpaceId, toMaxError(rewardedRequestError.getRewardedError()));
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdError(RewardedInterstitialAd rewardedInterstitialAd, RewardedError rewardedError) {
            log("Rewarded ad failed to display with error: " + rewardedError);
            if (rewardedInterstitialAd != null) {
                String adSpaceId = rewardedInterstitialAd.getAdSpaceId();
                synchronized (this.rewardedAdsLock) {
                    this.rewardedAds.remove(adSpaceId);
                }
                onAdDisplayFailed(adSpaceId, new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", rewardedError.ordinal(), rewardedError.name()));
            }
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdStarted(RewardedInterstitialAd rewardedInterstitialAd) {
            String adSpaceId = rewardedInterstitialAd.getAdSpaceId();
            synchronized (this.rewardedAdsLock) {
                this.rewardedAds.remove(adSpaceId);
            }
            log("Rewarded ad displayed");
            onAdDisplayed(adSpaceId);
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdClicked(RewardedInterstitialAd rewardedInterstitialAd) {
            log("Rewarded ad clicked");
            onAdClicked(rewardedInterstitialAd.getAdSpaceId());
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdReward(RewardedInterstitialAd rewardedInterstitialAd) {
            log("Rewarded ad video completed");
            this.hasGrantedReward = true;
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdClosed(RewardedInterstitialAd rewardedInterstitialAd) {
            String adSpaceId = rewardedInterstitialAd.getAdSpaceId();
            if (this.hasGrantedReward || shouldAlwaysRewardUser(adSpaceId)) {
                MaxReward reward = getReward(adSpaceId);
                log("Rewarded user with reward: " + reward);
                onUserRewarded(adSpaceId, reward);
            }
            log("Rewarded ad hidden");
            onAdHidden(adSpaceId);
        }

        @Override // com.smaato.sdk.rewarded.EventListener
        public void onAdTTLExpired(RewardedInterstitialAd rewardedInterstitialAd) {
            log("Rewarded ad expired");
            synchronized (this.rewardedAdsLock) {
                this.rewardedAds.remove(rewardedInterstitialAd.getAdSpaceId());
            }
        }

        private void onAdLoaded(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", str2);
                onAdLoaded(str, bundle);
                return;
            }
            onAdLoaded(str);
        }

        private static MaxAdapterError toMaxError(RewardedError rewardedError) {
            MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
            switch (AnonymousClass1.$SwitchMap$com$smaato$sdk$rewarded$RewardedError[rewardedError.ordinal()]) {
                case 1:
                    maxAdapterError = MaxAdapterError.NO_FILL;
                    break;
                case 2:
                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                    break;
                case 3:
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                    break;
                case 4:
                case 5:
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                    break;
                case 6:
                    maxAdapterError = MaxAdapterError.AD_EXPIRED;
                    break;
            }
            return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), rewardedError.ordinal(), rewardedError.name());
        }
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.SmaatoMediationAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$banner$widget$BannerError;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$interstitial$InterstitialError;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$nativead$NativeAdError;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$rewarded$RewardedError;

        static {
            int[] iArr = new int[RewardedError.values().length];
            $SwitchMap$com$smaato$sdk$rewarded$RewardedError = iArr;
            try {
                iArr[RewardedError.NO_AD_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$rewarded$RewardedError[RewardedError.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$rewarded$RewardedError[RewardedError.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$rewarded$RewardedError[RewardedError.INTERNAL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$rewarded$RewardedError[RewardedError.CACHE_LIMIT_REACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$smaato$sdk$rewarded$RewardedError[RewardedError.CREATIVE_RESOURCE_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[InterstitialError.values().length];
            $SwitchMap$com$smaato$sdk$interstitial$InterstitialError = iArr2;
            try {
                iArr2[InterstitialError.NO_AD_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.CACHE_LIMIT_REACHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.INTERNAL_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.CREATIVE_RESOURCE_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$smaato$sdk$interstitial$InterstitialError[InterstitialError.AD_UNLOADED.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[NativeAdError.values().length];
            $SwitchMap$com$smaato$sdk$nativead$NativeAdError = iArr3;
            try {
                iArr3[NativeAdError.NO_AD_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$smaato$sdk$nativead$NativeAdError[NativeAdError.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$smaato$sdk$nativead$NativeAdError[NativeAdError.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$smaato$sdk$nativead$NativeAdError[NativeAdError.INTERNAL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$smaato$sdk$nativead$NativeAdError[NativeAdError.CACHE_LIMIT_REACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr4 = new int[BannerError.values().length];
            $SwitchMap$com$smaato$sdk$banner$widget$BannerError = iArr4;
            try {
                iArr4[BannerError.NO_AD_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.INTERNAL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.CACHE_LIMIT_REACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.CREATIVE_RESOURCE_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$smaato$sdk$banner$widget$BannerError[BannerError.AD_UNLOADED.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }
}
