package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.runtime.ComposeVersion;
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
import com.applovin.mediation.adapters.ironsource.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.ads.AdError;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.metadata.a;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.smaato.sdk.core.dns.DnsName;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import com.unity3d.ironsourceads.IronSourceAds;
import com.unity3d.ironsourceads.banner.BannerAdLoader;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import com.unity3d.ironsourceads.banner.BannerAdViewListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoader;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoader;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class IronSourceMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static MaxAdapter.InitializationStatus status;
    private ISDemandOnlyBannerLayout adView;
    private String adViewPlacementIdentifier;
    private BannerAdView biddingAdView;
    private InterstitialAd biddingInterstitialAd;
    private BiddingInterstitialListener biddingInterstitialListener;
    private RewardedAd biddingRewardedAd;
    private BiddingRewardedListener biddingRewardedListener;
    private String mRouterPlacementIdentifier;
    private static final IronSourceRouter ROUTER = new IronSourceRouter();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();
    private static final List<String> loadedAdViewPlacementIdentifiers = Collections.synchronizedList(new ArrayList());

    public IronSourceMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (INITIALIZED.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            String string = maxAdapterInitializationParameters.getServerParameters().getString(MBridgeConstans.APP_KEY);
            log("Initializing IronSource SDK with app key: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            IronSource.setMediationType("MAX" + getAdapterVersionCode() + "SDK" + AppLovinSdk.VERSION_CODE);
            setPrivacySettings(maxAdapterInitializationParameters);
            Boolean boolIsDoNotSell = maxAdapterInitializationParameters.isDoNotSell();
            if (boolIsDoNotSell != null) {
                IronSource.setMetaData(a.f3993a, Boolean.toString(boolIsDoNotSell.booleanValue()));
            }
            IronSource.setAdaptersDebug(maxAdapterInitializationParameters.isTesting());
            IronSourceRouter ironSourceRouter = ROUTER;
            IronSource.setISDemandOnlyInterstitialListener(ironSourceRouter);
            IronSource.setISDemandOnlyRewardedVideoListener(ironSourceRouter);
            IronSourceAds.init(getApplicationContext(), new InitRequest.Builder(string).withLegacyAdFormats(getAdFormatsToInitialize(maxAdapterInitializationParameters)).build(), new InitListener() { // from class: com.applovin.mediation.adapters.IronSourceMediationAdapter.1
                @Override // com.unity3d.ironsourceads.InitListener
                public void onInitSuccess() {
                    IronSourceMediationAdapter.this.log("IronSource SDK initialized.");
                    MaxAdapter.InitializationStatus unused = IronSourceMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(IronSourceMediationAdapter.status, null);
                }

                @Override // com.unity3d.ironsourceads.InitListener
                public void onInitFailed(IronSourceError ironSourceError) {
                    IronSourceMediationAdapter.this.log("Failed to initialize IronSource SDK with error: " + ironSourceError);
                    MaxAdapter.InitializationStatus unused = IronSourceMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(IronSourceMediationAdapter.status, ironSourceError.getErrorMessage());
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return IronSourceUtils.getSDKVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        if (this.adViewPlacementIdentifier != null) {
            log("Destroying adview with instance ID: " + this.adViewPlacementIdentifier);
            IronSource.destroyISDemandOnlyBanner(this.adViewPlacementIdentifier);
            loadedAdViewPlacementIdentifiers.remove(this.adViewPlacementIdentifier);
        }
        ROUTER.removeAdapter(this, this.mRouterPlacementIdentifier);
        BannerAdView bannerAdView = this.biddingAdView;
        if (bannerAdView != null) {
            bannerAdView.setListener(null);
            this.biddingAdView = null;
        }
        InterstitialAd interstitialAd = this.biddingInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setListener(null);
            this.biddingInterstitialAd = null;
        }
        RewardedAd rewardedAd = this.biddingRewardedAd;
        if (rewardedAd != null) {
            rewardedAd.setListener(null);
            this.biddingRewardedAd = null;
        }
        this.biddingInterstitialListener = null;
        this.biddingRewardedListener = null;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        setPrivacySettings(maxAdapterSignalCollectionParameters);
        maxSignalCollectionListener.onSignalCollected(IronSource.getISDemandOnlyBiddingData(getApplicationContext()));
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        setPrivacySettings(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading ironSource " + (zIsValidString ? "bidding " : "") + "interstitial for instance ID: " + thirdPartyAdPlacementId);
        if (zIsValidString) {
            InterstitialAdRequest interstitialAdRequestBuild = new InterstitialAdRequest.Builder(thirdPartyAdPlacementId, bidResponse).build();
            BiddingInterstitialListener biddingInterstitialListener = new BiddingInterstitialListener(maxInterstitialAdapterListener);
            this.biddingInterstitialListener = biddingInterstitialListener;
            InterstitialAdLoader.loadAd(interstitialAdRequestBuild, biddingInterstitialListener);
            return;
        }
        String interstitialRouterIdentifier = IronSourceRouter.getInterstitialRouterIdentifier(thirdPartyAdPlacementId);
        this.mRouterPlacementIdentifier = interstitialRouterIdentifier;
        IronSourceRouter ironSourceRouter = ROUTER;
        ironSourceRouter.addInterstitialAdapter(this, maxInterstitialAdapterListener, interstitialRouterIdentifier);
        if (IronSource.isISDemandOnlyInterstitialReady(thirdPartyAdPlacementId)) {
            log("Ad is available already for instance ID: " + thirdPartyAdPlacementId);
            ironSourceRouter.onAdLoaded(this.mRouterPlacementIdentifier);
        } else {
            IronSource.loadISDemandOnlyInterstitial(activity, thirdPartyAdPlacementId);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        boolean zIsValidString = AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse());
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing ironSource interstitial for instance ID: " + thirdPartyAdPlacementId);
        if (zIsValidString) {
            InterstitialAd interstitialAd = this.biddingInterstitialAd;
            if (interstitialAd == null || !interstitialAd.isReadyToShow()) {
                log("Unable to show ironSource interstitial - ad is not ready for instance ID: " + thirdPartyAdPlacementId);
                maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
                return;
            } else if (activity == null) {
                log("Interstitial ad display failed: Activity is null");
                maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.MISSING_ACTIVITY);
                return;
            } else {
                this.biddingInterstitialAd.setListener(this.biddingInterstitialListener);
                this.biddingInterstitialAd.show(activity);
                return;
            }
        }
        IronSourceRouter ironSourceRouter = ROUTER;
        ironSourceRouter.addShowingAdapter(this);
        if (!IronSource.isISDemandOnlyInterstitialReady(thirdPartyAdPlacementId)) {
            log("Unable to show ironSource interstitial - no ad loaded for instance ID: " + thirdPartyAdPlacementId);
            ironSourceRouter.onAdDisplayFailed(IronSourceRouter.getInterstitialRouterIdentifier(thirdPartyAdPlacementId), new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
        } else {
            IronSource.showISDemandOnlyInterstitial(thirdPartyAdPlacementId);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        setPrivacySettings(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading ironSource " + (zIsValidString ? "bidding " : "") + "rewarded for instance ID: " + thirdPartyAdPlacementId);
        if (zIsValidString) {
            RewardedAdRequest rewardedAdRequestBuild = new RewardedAdRequest.Builder(thirdPartyAdPlacementId, bidResponse).build();
            BiddingRewardedListener biddingRewardedListener = new BiddingRewardedListener(maxRewardedAdapterListener);
            this.biddingRewardedListener = biddingRewardedListener;
            RewardedAdLoader.loadAd(rewardedAdRequestBuild, biddingRewardedListener);
            return;
        }
        String rewardedVideoRouterIdentifier = IronSourceRouter.getRewardedVideoRouterIdentifier(thirdPartyAdPlacementId);
        this.mRouterPlacementIdentifier = rewardedVideoRouterIdentifier;
        IronSourceRouter ironSourceRouter = ROUTER;
        ironSourceRouter.addRewardedAdapter(this, maxRewardedAdapterListener, rewardedVideoRouterIdentifier);
        if (IronSource.isISDemandOnlyRewardedVideoAvailable(thirdPartyAdPlacementId)) {
            log("Ad is available already for instance ID: " + thirdPartyAdPlacementId);
            ironSourceRouter.onAdLoaded(this.mRouterPlacementIdentifier);
        } else {
            IronSource.loadISDemandOnlyRewardedVideo(activity, thirdPartyAdPlacementId);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        boolean zIsValidString = AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse());
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing ironSource rewarded for instance ID: " + thirdPartyAdPlacementId);
        if (zIsValidString) {
            RewardedAd rewardedAd = this.biddingRewardedAd;
            if (rewardedAd == null || !rewardedAd.isReadyToShow()) {
                log("Unable to show ironSource rewarded - ad is not ready for instance ID: " + thirdPartyAdPlacementId);
                maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
                return;
            } else if (activity == null) {
                log("Rewarded ad display failed: Activity is null");
                maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.MISSING_ACTIVITY);
                return;
            } else {
                configureReward(maxAdapterResponseParameters);
                this.biddingRewardedAd.setListener(this.biddingRewardedListener);
                this.biddingRewardedAd.show(activity);
                return;
            }
        }
        IronSourceRouter ironSourceRouter = ROUTER;
        ironSourceRouter.addShowingAdapter(this);
        if (!IronSource.isISDemandOnlyRewardedVideoAvailable(thirdPartyAdPlacementId)) {
            log("Unable to show ironSource rewarded - no ad loaded...");
            ironSourceRouter.onAdDisplayFailed(IronSourceRouter.getRewardedVideoRouterIdentifier(thirdPartyAdPlacementId), new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
        } else {
            configureReward(maxAdapterResponseParameters);
            IronSource.showISDemandOnlyRewardedVideo(thirdPartyAdPlacementId);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        setPrivacySettings(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        log("Loading " + (zIsValidString ? "bidding " : "") + maxAdFormat.getLabel() + " ad for instance ID: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        if (zIsValidString) {
            BannerAdLoader.loadAd(new BannerAdRequest.Builder(getApplicationContext(), maxAdapterResponseParameters.getThirdPartyAdPlacementId(), bidResponse, toISAdSize(maxAdFormat)).build(), new BiddingAdViewListener(maxAdViewAdapterListener));
            return;
        }
        if (activity == null) {
            log(maxAdFormat.getLabel() + " ad load failed: Activity is null");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.MISSING_ACTIVITY);
        } else {
            if (loadedAdViewPlacementIdentifiers.contains(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
                log("AdView ad failed to load for instance ID: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + ". An ad with the same instance ID is already loaded");
                maxAdViewAdapterListener.onAdViewAdLoadFailed(new MaxAdapterError(MaxAdapterError.INTERNAL_ERROR.getCode(), MaxAdapterError.INTERNAL_ERROR.getMessage(), 0, "An ad with the same instance ID is already loaded"));
                return;
            }
            this.adViewPlacementIdentifier = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutCreateBannerForDemandOnly = IronSource.createBannerForDemandOnly(activity, toISBannerSize(maxAdFormat));
            this.adView = iSDemandOnlyBannerLayoutCreateBannerForDemandOnly;
            iSDemandOnlyBannerLayoutCreateBannerForDemandOnly.setBannerDemandOnlyListener(new AdViewListener(maxAdViewAdapterListener));
            IronSource.loadISDemandOnlyBanner(activity, this.adView, this.adViewPlacementIdentifier);
        }
    }

    private void setPrivacySettings(MaxAdapterParameters maxAdapterParameters) {
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null) {
            IronSource.setConsent(boolHasUserConsent.booleanValue());
        }
    }

    private List<IronSourceAds.AdFormat> getAdFormatsToInitialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters) {
        ArrayList<String> stringArrayList = maxAdapterInitializationParameters.getServerParameters().getStringArrayList("init_ad_formats");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return Arrays.asList(IronSourceAds.AdFormat.INTERSTITIAL, IronSourceAds.AdFormat.REWARDED, IronSourceAds.AdFormat.BANNER);
        }
        ArrayList arrayList = new ArrayList();
        if (stringArrayList.contains("inter")) {
            arrayList.add(IronSourceAds.AdFormat.INTERSTITIAL);
        }
        if (stringArrayList.contains("rewarded")) {
            arrayList.add(IronSourceAds.AdFormat.REWARDED);
        }
        if (stringArrayList.contains("banner")) {
            arrayList.add(IronSourceAds.AdFormat.BANNER);
        }
        return arrayList;
    }

    private ISBannerSize toISBannerSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return ISBannerSize.BANNER;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return ISBannerSize.LARGE;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return ISBannerSize.RECTANGLE;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    private AdSize toISAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return AdSize.banner();
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return AdSize.leaderboard();
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.mediumRectangle();
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x003c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0045  */
    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    /* JADX WARN: Code duplicated, block: B:31:0x004b  */
    /* JADX WARN: Code duplicated, block: B:32:0x004e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0054  */
    /* JADX WARN: Code duplicated, block: B:35:0x0057  */
    /* JADX WARN: Code duplicated, block: B:36:0x005a  */
    public static MaxAdapterError toMaxError(IronSourceError ironSourceError) {
        int errorCode = ironSourceError.getErrorCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (errorCode != 501 && errorCode != 502 && errorCode != 505 && errorCode != 506) {
            if (errorCode != 526) {
                if (errorCode == 527 || errorCode == 1060 || errorCode == 1061) {
                    maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                } else {
                    switch (errorCode) {
                        case 1:
                        case 605:
                        case 610:
                        case 611:
                        case 613:
                        case 614:
                        case 7101:
                        case 7102:
                        case 7103:
                        case ComposeVersion.version /* 7104 */:
                        case 7201:
                            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                            break;
                        case IronSourceError.ERROR_NO_INTERNET_CONNECTION /* 520 */:
                            maxAdapterError = MaxAdapterError.NO_CONNECTION;
                            break;
                        case 600:
                        case 601:
                        case 602:
                        case 603:
                        case 607:
                        case 612:
                        case 1010:
                        case 7001:
                        case AdError.LOAD_CALLED_WHILE_SHOWING_AD /* 7002 */:
                        case AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED /* 7003 */:
                        case AdError.INCORRECT_STATE_ERROR /* 7004 */:
                        case 7115:
                            maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                            break;
                        case 604:
                            maxAdapterError = MaxAdapterError.AD_FREQUENCY_CAPPED;
                            break;
                        case 606:
                        case 621:
                        case 1158:
                        case 3306:
                            maxAdapterError = MaxAdapterError.NO_FILL;
                            break;
                        case 608:
                        case 609:
                        case 7113:
                            maxAdapterError = MaxAdapterError.TIMEOUT;
                            break;
                        case 615:
                        case 616:
                        case 7105:
                        case 7106:
                        case 7107:
                        case 7108:
                        case 7109:
                        case 7110:
                        case 7111:
                        case 7112:
                        case 7116:
                        case 7117:
                        case 7118:
                            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                            break;
                        case 7202:
                            maxAdapterError = MaxAdapterError.AD_NOT_READY;
                            break;
                        default:
                            switch (errorCode) {
                                case 508:
                                    maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                                    break;
                                case 509:
                                    maxAdapterError = MaxAdapterError.NO_FILL;
                                    break;
                                case 510:
                                    maxAdapterError = MaxAdapterError.UNSPECIFIED;
                                    break;
                                default:
                                    switch (errorCode) {
                                        case 1000:
                                        case 1001:
                                        case 1002:
                                        case 1003:
                                        case 1004:
                                        case 1005:
                                        case 1007:
                                        case 1008:
                                            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                                            break;
                                        case 1006:
                                            maxAdapterError = MaxAdapterError.SIGNAL_COLLECTION_TIMEOUT;
                                            break;
                                        default:
                                            switch (errorCode) {
                                                case 1020:
                                                case 1021:
                                                    maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                                                    break;
                                                case 1022:
                                                case 1023:
                                                    maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                                                    break;
                                                case 1024:
                                                    maxAdapterError = MaxAdapterError.NO_FILL;
                                                    break;
                                                default:
                                                    switch (errorCode) {
                                                        case 1026:
                                                        case 1027:
                                                        case IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW /* 1036 */:
                                                        case IronSourceError.ERROR_IS_LOAD_DURING_SHOW /* 1037 */:
                                                            maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                                                            break;
                                                        case 1028:
                                                        case 1030:
                                                        case IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK /* 1034 */:
                                                        case IronSourceError.ERROR_RV_SHOW_EXCEPTION /* 1038 */:
                                                        case IronSourceError.ERROR_IS_SHOW_EXCEPTION /* 1039 */:
                                                        case IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION /* 1040 */:
                                                        case IronSourceError.ERROR_IS_INSTANCE_INIT_EXCEPTION /* 1041 */:
                                                            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                                                            break;
                                                        case 1029:
                                                        case 1031:
                                                            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                                                            break;
                                                        case 1032:
                                                        case IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT /* 1033 */:
                                                            maxAdapterError = MaxAdapterError.TIMEOUT;
                                                            break;
                                                        case IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES /* 1035 */:
                                                            maxAdapterError = MaxAdapterError.NO_FILL;
                                                            break;
                                                        default:
                                                            switch (errorCode) {
                                                                case 1050:
                                                                case 1053:
                                                                case IronSourceError.ERROR_DO_RV_LOAD_DURING_SHOW /* 1056 */:
                                                                    maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                                                                    break;
                                                                case IronSourceError.ERROR_DO_IS_CALL_LOAD_BEFORE_SHOW /* 1051 */:
                                                                case IronSourceError.ERROR_DO_RV_CALL_LOAD_BEFORE_SHOW /* 1054 */:
                                                                    maxAdapterError = MaxAdapterError.AD_NOT_READY;
                                                                    break;
                                                                case 1052:
                                                                case 1055:
                                                                    maxAdapterError = MaxAdapterError.TIMEOUT;
                                                                    break;
                                                                case IronSourceError.ERROR_RV_EXPIRED_ADS /* 1057 */:
                                                                    maxAdapterError = MaxAdapterError.AD_EXPIRED;
                                                                    break;
                                                                case 1058:
                                                                    maxAdapterError = MaxAdapterError.NO_FILL;
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                }
            } else {
                maxAdapterError = MaxAdapterError.AD_FREQUENCY_CAPPED;
            }
        } else {
            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, ironSourceError.getErrorMessage());
    }

    private long getAdapterVersionCode() {
        int i;
        long j;
        long j2 = 0;
        for (String str : getAdapterVersion().replaceAll("[^0-9.]", "").split(DnsName.ESCAPED_DOT)) {
            long j3 = j2 * 100;
            if (j3 != 0 && str.length() > 2) {
                i = Integer.parseInt(str.substring(0, 2));
            } else {
                if (str.isEmpty()) {
                    j = 0;
                } else {
                    i = Integer.parseInt(str);
                }
                j2 = j3 + j;
            }
            j = i;
            j2 = j3 + j;
        }
        return j2;
    }

    private static class IronSourceRouter extends MediationAdapterRouter implements ISDemandOnlyInterstitialListener, ISDemandOnlyRewardedVideoListener {
        private boolean hasGrantedReward;

        @Override // com.applovin.mediation.adapters.MediationAdapterRouter
        void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        }

        private IronSourceRouter() {
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdReady(String str) {
            log("Interstitial loaded for instance ID: " + str);
            onAdLoaded(getInterstitialRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError) {
            log("Interstitial ad failed to load for instance ID: " + str + " with error: " + ironSourceError);
            onAdLoadFailed(getInterstitialRouterIdentifier(str), IronSourceMediationAdapter.toMaxError(ironSourceError));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdOpened(String str) {
            log("Interstitial ad displayed for instance ID: " + str);
            onAdDisplayed(getInterstitialRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdShowFailed(String str, IronSourceError ironSourceError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
            log("Interstitial ad failed to show for instance ID: " + str + " with error: " + maxAdapterError);
            onAdDisplayFailed(getInterstitialRouterIdentifier(str), maxAdapterError);
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdClicked(String str) {
            log("Interstitial ad clicked for instance ID: " + str);
            onAdClicked(getInterstitialRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
        public void onInterstitialAdClosed(String str) {
            log("Interstitial ad closed for instance ID: " + str);
            onAdHidden(getInterstitialRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdLoadSuccess(String str) {
            log("Rewarded ad loaded for instance ID: " + str);
            onAdLoaded(getRewardedVideoRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdLoadFailed(String str, IronSourceError ironSourceError) {
            log("Rewarded ad failed to load for instance ID: " + str);
            onAdLoadFailed(getRewardedVideoRouterIdentifier(str), IronSourceMediationAdapter.toMaxError(ironSourceError));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdOpened(String str) {
            log("Rewarded ad shown for instance ID: " + str);
            onAdDisplayed(getRewardedVideoRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdShowFailed(String str, IronSourceError ironSourceError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
            log("Rewarded ad failed to show for instance ID: " + str + " with error: " + maxAdapterError);
            onAdDisplayFailed(getRewardedVideoRouterIdentifier(str), maxAdapterError);
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdClicked(String str) {
            log("Rewarded ad clicked for instance ID: " + str);
            onAdClicked(getRewardedVideoRouterIdentifier(str));
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdClosed(String str) {
            String rewardedVideoRouterIdentifier = getRewardedVideoRouterIdentifier(str);
            if (this.hasGrantedReward || shouldAlwaysRewardUser(rewardedVideoRouterIdentifier)) {
                MaxReward reward = getReward(rewardedVideoRouterIdentifier);
                log("Rewarded  ad rewarded user with reward: " + reward + " for instance ID: " + str);
                onUserRewarded(rewardedVideoRouterIdentifier, reward);
            }
            log("Rewarded ad hidden for instance ID: " + str);
            onAdHidden(rewardedVideoRouterIdentifier);
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
        public void onRewardedVideoAdRewarded(String str) {
            log("Rewarded ad granted reward for instance ID: " + str);
            this.hasGrantedReward = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getInterstitialRouterIdentifier(String str) {
            return str + "-" + IronSource.AD_UNIT.INTERSTITIAL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getRewardedVideoRouterIdentifier(String str) {
            return str + "-" + IronSource.AD_UNIT.REWARDED_VIDEO;
        }
    }

    private class AdViewListener implements ISDemandOnlyBannerListener {
        private final MaxAdViewAdapterListener listener;

        AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener
        public void onBannerAdLoaded(String str) {
            IronSourceMediationAdapter.this.log("AdView loaded for instance ID: " + str);
            this.listener.onAdViewAdLoaded(IronSourceMediationAdapter.this.adView);
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener
        public void onBannerAdLoadFailed(String str, IronSourceError ironSourceError) {
            MaxAdapterError maxError = IronSourceMediationAdapter.toMaxError(ironSourceError);
            IronSourceMediationAdapter.this.log("AdView ad failed to load for instance ID: " + str + " with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener
        public void onBannerAdClicked(String str) {
            IronSourceMediationAdapter.this.log("AdView ad clicked for instance ID: " + str);
            this.listener.onAdViewAdClicked();
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener
        public void onBannerAdShown(String str) {
            IronSourceMediationAdapter.loadedAdViewPlacementIdentifiers.add(str);
            IronSourceMediationAdapter.this.log("AdView ad displayed for instance ID: " + str);
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.json.mediationsdk.demandOnly.ISDemandOnlyBannerListener
        public void onBannerAdLeftApplication(String str) {
            IronSourceMediationAdapter.this.log("AdView ad left application for instance ID: " + str);
        }
    }

    private class BiddingInterstitialListener implements InterstitialAdLoaderListener, InterstitialAdListener {
        private final MaxInterstitialAdapterListener listener;

        BiddingInterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
        public void onInterstitialAdLoaded(InterstitialAd interstitialAd) {
            IronSourceMediationAdapter.this.log("Interstitial loaded for bidding instance ID: " + interstitialAd.getAdInfo().getInstanceId());
            IronSourceMediationAdapter.this.biddingInterstitialAd = interstitialAd;
            this.listener.onInterstitialAdLoaded(createExtraInfo(interstitialAd));
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
        public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
            IronSourceMediationAdapter.this.log("Interstitial ad failed to load for bidding instance with error: " + ironSourceError);
            this.listener.onInterstitialAdLoadFailed(IronSourceMediationAdapter.toMaxError(ironSourceError));
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
        public void onInterstitialAdShown(InterstitialAd interstitialAd) {
            IronSourceMediationAdapter.this.log("Interstitial ad displayed for bidding instance ID: " + interstitialAd.getAdInfo().getInstanceId());
            this.listener.onInterstitialAdDisplayed(createExtraInfo(interstitialAd));
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
        public void onInterstitialAdFailedToShow(InterstitialAd interstitialAd, IronSourceError ironSourceError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
            IronSourceMediationAdapter.this.log("Interstitial ad failed to show for bidding instance ID: " + interstitialAd.getAdInfo().getInstanceId() + " with error: " + maxAdapterError);
            this.listener.onInterstitialAdDisplayFailed(maxAdapterError, createExtraInfo(interstitialAd));
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
        public void onInterstitialAdClicked(InterstitialAd interstitialAd) {
            IronSourceMediationAdapter.this.log("Interstitial ad clicked for bidding instance ID: " + interstitialAd.getAdInfo().getInstanceId());
            this.listener.onInterstitialAdClicked(createExtraInfo(interstitialAd));
        }

        @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
        public void onInterstitialAdDismissed(InterstitialAd interstitialAd) {
            IronSourceMediationAdapter.this.log("Interstitial ad closed for bidding instance ID: " + interstitialAd.getAdInfo().getInstanceId());
            this.listener.onInterstitialAdHidden(createExtraInfo(interstitialAd));
        }

        private Bundle createExtraInfo(InterstitialAd interstitialAd) {
            String adId = interstitialAd.getAdInfo().getAdId();
            if (TextUtils.isEmpty(adId)) {
                return null;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", adId);
            return bundle;
        }
    }

    private class BiddingRewardedListener implements RewardedAdLoaderListener, RewardedAdListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        BiddingRewardedListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
        public void onRewardedAdLoaded(RewardedAd rewardedAd) {
            IronSourceMediationAdapter.this.log("Rewarded ad loaded for bidding instance ID: " + rewardedAd.getAdInfo().getInstanceId());
            IronSourceMediationAdapter.this.biddingRewardedAd = rewardedAd;
            this.listener.onRewardedAdLoaded(createExtraInfo(rewardedAd));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
        public void onRewardedAdLoadFailed(IronSourceError ironSourceError) {
            IronSourceMediationAdapter.this.log("Rewarded ad failed to load for bidding instance with error: " + ironSourceError);
            this.listener.onRewardedAdLoadFailed(IronSourceMediationAdapter.toMaxError(ironSourceError));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdShown(RewardedAd rewardedAd) {
            IronSourceMediationAdapter.this.log("Rewarded ad shown for bidding instance ID: " + rewardedAd.getAdInfo().getInstanceId());
            this.listener.onRewardedAdDisplayed(createExtraInfo(rewardedAd));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdFailedToShow(RewardedAd rewardedAd, IronSourceError ironSourceError) {
            MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
            IronSourceMediationAdapter.this.log("Rewarded ad failed to show for bidding instance ID: " + rewardedAd.getAdInfo().getInstanceId() + " with error: " + maxAdapterError);
            this.listener.onRewardedAdDisplayFailed(maxAdapterError, createExtraInfo(rewardedAd));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdClicked(RewardedAd rewardedAd) {
            IronSourceMediationAdapter.this.log("Rewarded ad clicked for instance ID: " + rewardedAd.getAdInfo().getInstanceId());
            this.listener.onRewardedAdClicked(createExtraInfo(rewardedAd));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onRewardedAdDismissed(RewardedAd rewardedAd) {
            if (this.hasGrantedReward || IronSourceMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = IronSourceMediationAdapter.this.getReward();
                IronSourceMediationAdapter.this.log("Rewarded ad rewarded user with reward: " + reward + " for instance ID: " + rewardedAd.getAdInfo().getInstanceId());
                this.listener.onUserRewarded(reward);
            }
            IronSourceMediationAdapter.this.log("Rewarded ad hidden for instance ID: " + rewardedAd.getAdInfo().getInstanceId());
            this.listener.onRewardedAdHidden(createExtraInfo(rewardedAd));
        }

        @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
        public void onUserEarnedReward(RewardedAd rewardedAd) {
            IronSourceMediationAdapter.this.log("Rewarded ad granted reward for instance ID: " + rewardedAd.getAdInfo().getInstanceId());
            this.hasGrantedReward = true;
        }

        private Bundle createExtraInfo(RewardedAd rewardedAd) {
            String adId = rewardedAd.getAdInfo().getAdId();
            if (TextUtils.isEmpty(adId)) {
                return null;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", adId);
            return bundle;
        }
    }

    private class BiddingAdViewListener implements BannerAdLoaderListener, BannerAdViewListener {
        private final MaxAdViewAdapterListener listener;

        BiddingAdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.unity3d.ironsourceads.banner.BannerAdLoaderListener
        public void onBannerAdLoaded(BannerAdView bannerAdView) {
            IronSourceMediationAdapter.this.log("AdView loaded for instance ID: " + bannerAdView.getAdInfo().getInstanceId());
            IronSourceMediationAdapter.this.biddingAdView = bannerAdView;
            IronSourceMediationAdapter.this.biddingAdView.setListener(this);
            this.listener.onAdViewAdLoaded(IronSourceMediationAdapter.this.biddingAdView, createExtraInfo(bannerAdView));
        }

        @Override // com.unity3d.ironsourceads.banner.BannerAdLoaderListener
        public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
            MaxAdapterError maxError = IronSourceMediationAdapter.toMaxError(ironSourceError);
            IronSourceMediationAdapter.this.log("AdView ad failed to load for bidding instance with error: " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.unity3d.ironsourceads.banner.BannerAdViewListener
        public void onBannerAdClicked(BannerAdView bannerAdView) {
            IronSourceMediationAdapter.this.log("AdView ad clicked");
            this.listener.onAdViewAdClicked(createExtraInfo(bannerAdView));
        }

        @Override // com.unity3d.ironsourceads.banner.BannerAdViewListener
        public void onBannerAdShown(BannerAdView bannerAdView) {
            IronSourceMediationAdapter.this.log("AdView ad displayed");
            this.listener.onAdViewAdDisplayed(createExtraInfo(bannerAdView));
        }

        private Bundle createExtraInfo(BannerAdView bannerAdView) {
            String adId = bannerAdView.getAdInfo().getAdId();
            if (TextUtils.isEmpty(adId)) {
                return null;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", adId);
            return bundle;
        }
    }
}
