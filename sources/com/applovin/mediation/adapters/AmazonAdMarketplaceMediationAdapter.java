package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.amazon.aps.ads.ApsConstants;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdBannerListener;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdInterstitial;
import com.amazon.device.ads.DTBAdInterstitialListener;
import com.amazon.device.ads.DTBAdLoader;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdView;
import com.amazon.device.ads.SDKUtilities;
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
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes9.dex */
public class AmazonAdMarketplaceMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter {
    private DTBAdView adView;
    private DTBAdInterstitial interstitialAd;
    private DTBAdInterstitial rewardedAd;
    private static final Map<MaxAdFormat, DTBAdLoader> adLoaders = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> usedAdLoaders = new HashSet();
    private static final Map<String, MediationHints> mediationHintsCache = new HashMap();
    private static final Object mediationHintsCacheLock = new Object();

    public AmazonAdMarketplaceMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        if (maxAdapterInitializationParameters.isTesting()) {
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
        }
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return AdRegistration.getVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return "9.5.4.1";
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        this.adView = null;
        this.interstitialAd = null;
        this.rewardedAd = null;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        DTBAdRequest adLoader;
        MaxAdFormat adFormat = maxAdapterSignalCollectionParameters.getAdFormat();
        Object obj = maxAdapterSignalCollectionParameters.getLocalExtraParameters().get(ApsConstants.AMAZON_SUCCESS_RESPONSE);
        Object obj2 = maxAdapterSignalCollectionParameters.getLocalExtraParameters().get(ApsConstants.AMAZON_ERROR_RESPONSE);
        boolean z = obj instanceof DTBAdResponse;
        if (z) {
            adLoader = ((DTBAdResponse) obj).getAdLoader();
            if (!usedAdLoaders.contains(Integer.valueOf(adLoader.hashCode()))) {
                d("Using ad loader from ad response object: " + adLoader);
            } else {
                maxAdapterSignalCollectionParameters.getLocalExtraParameters().remove(ApsConstants.AMAZON_SUCCESS_RESPONSE);
                adLoader = null;
            }
        } else {
            adLoader = null;
        }
        if (obj2 instanceof AdError) {
            DTBAdRequest adLoader2 = ((AdError) obj2).getAdLoader();
            if (!usedAdLoaders.contains(Integer.valueOf(adLoader2.hashCode()))) {
                d("Using ad loader from ad error object: " + adLoader2);
                adLoader = adLoader2;
            } else {
                maxAdapterSignalCollectionParameters.getLocalExtraParameters().remove(ApsConstants.AMAZON_ERROR_RESPONSE);
            }
        }
        Map<MaxAdFormat, DTBAdLoader> map = adLoaders;
        DTBAdLoader dTBAdLoader = map.get(adFormat);
        if (adLoader == null) {
            if (dTBAdLoader != null) {
                d("Using cached ad loader: " + dTBAdLoader);
                loadSubsequentSignal(dTBAdLoader, maxAdapterSignalCollectionParameters, adFormat, maxSignalCollectionListener);
                return;
            } else {
                failSignalCollection("DTBAdResponse or AdError not passed in ad load API", maxSignalCollectionListener);
                return;
            }
        }
        if (adLoader == dTBAdLoader) {
            d("Passed in ad loader same as current ad loader: " + dTBAdLoader);
            loadSubsequentSignal(adLoader, maxAdapterSignalCollectionParameters, adFormat, maxSignalCollectionListener);
            return;
        }
        d("New loader passed in for " + adFormat + ": " + adLoader + ", replacing current ad loader: " + dTBAdLoader);
        map.put(adFormat, adLoader);
        usedAdLoaders.add(Integer.valueOf(adLoader.hashCode()));
        if (z) {
            processAdResponse(maxAdapterSignalCollectionParameters, (DTBAdResponse) obj, maxSignalCollectionListener);
        } else {
            failSignalCollection((AdError) obj2, maxSignalCollectionListener);
        }
    }

    private void loadSubsequentSignal(DTBAdLoader dTBAdLoader, final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final MaxAdFormat maxAdFormat, final MaxSignalCollectionListener maxSignalCollectionListener) {
        d("Found existing ad loader (" + dTBAdLoader + ") for format: " + maxAdFormat + " - loading...");
        dTBAdLoader.loadAd(new DTBAdCallback() { // from class: com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter.1
            @Override // com.amazon.device.ads.DTBAdCallback
            public void onSuccess(DTBAdResponse dTBAdResponse) {
                AmazonAdMarketplaceMediationAdapter.adLoaders.put(maxAdFormat, dTBAdResponse.getAdLoader());
                AmazonAdMarketplaceMediationAdapter.usedAdLoaders.add(Integer.valueOf(dTBAdResponse.getAdLoader().hashCode()));
                AmazonAdMarketplaceMediationAdapter.this.d("Signal collected for ad loader: " + dTBAdResponse.getAdLoader());
                AmazonAdMarketplaceMediationAdapter.this.processAdResponse(maxAdapterSignalCollectionParameters, dTBAdResponse, maxSignalCollectionListener);
            }

            @Override // com.amazon.device.ads.DTBAdCallback
            public void onFailure(AdError adError) {
                AmazonAdMarketplaceMediationAdapter.adLoaders.put(maxAdFormat, adError.getAdLoader());
                AmazonAdMarketplaceMediationAdapter.usedAdLoaders.add(Integer.valueOf(adError.getAdLoader().hashCode()));
                AmazonAdMarketplaceMediationAdapter.this.d("Signal failed to collect for ad loader: " + adError.getAdLoader());
                AmazonAdMarketplaceMediationAdapter.this.failSignalCollection(adError, maxSignalCollectionListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAdResponse(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, DTBAdResponse dTBAdResponse, MaxSignalCollectionListener maxSignalCollectionListener) {
        d("Processing ad response...");
        String pricePoint = SDKUtilities.getPricePoint(dTBAdResponse);
        if (AppLovinSdkUtils.isValidString(pricePoint)) {
            MediationHints mediationHints = new MediationHints(SDKUtilities.getBidInfo(dTBAdResponse));
            synchronized (mediationHintsCacheLock) {
                mediationHintsCache.put(pricePoint, mediationHints);
            }
            long millis = TimeUnit.SECONDS.toMillis(maxAdapterSignalCollectionParameters.getServerParameters().getLong("mediation_hints_cleanup_delay_sec", TimeUnit.MINUTES.toSeconds(5L)));
            if (millis > 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new CleanupMediationHintsTask(pricePoint, mediationHints), millis);
            }
            d("Successfully loaded encoded bid id: " + pricePoint);
            maxSignalCollectionListener.onSignalCollected(pricePoint);
            return;
        }
        failSignalCollection("Received empty bid id", maxSignalCollectionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failSignalCollection(AdError adError, MaxSignalCollectionListener maxSignalCollectionListener) {
        failSignalCollection("Signal collection failed: " + adError.getCode() + " - " + adError.getMessage(), maxSignalCollectionListener);
    }

    private void failSignalCollection(String str, MaxSignalCollectionListener maxSignalCollectionListener) {
        e(str);
        maxSignalCollectionListener.onSignalCollectionFailed(str);
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        MediationHints mediationHints;
        String string = maxAdapterResponseParameters.getServerParameters().getString("encoded_bid_id");
        d("Loading " + maxAdFormat.getLabel() + " ad view ad for encoded bid id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (TextUtils.isEmpty(string)) {
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        synchronized (mediationHintsCacheLock) {
            Map<String, MediationHints> map = mediationHintsCache;
            mediationHints = map.get(string);
            map.remove(string);
        }
        if (mediationHints != null) {
            DTBAdView dTBAdView = new DTBAdView(getContext(activity), new AdViewListener(maxAdViewAdapterListener));
            this.adView = dTBAdView;
            dTBAdView.fetchAd(mediationHints.value);
        } else {
            e("Unable to find mediation hints");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_LOAD_STATE);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String string = maxAdapterResponseParameters.getServerParameters().getString("encoded_bid_id");
        d("Loading interstitial ad for encoded bid id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (TextUtils.isEmpty(string)) {
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        DTBAdInterstitial dTBAdInterstitial = new DTBAdInterstitial(activity, new InterstitialListener(maxInterstitialAdapterListener));
        this.interstitialAd = dTBAdInterstitial;
        if (loadFullscreenAd(string, dTBAdInterstitial)) {
            return;
        }
        maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.INVALID_LOAD_STATE);
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad...");
        DTBAdInterstitial dTBAdInterstitial = this.interstitialAd;
        if (dTBAdInterstitial != null) {
            dTBAdInterstitial.show();
        } else {
            e("Interstitial ad is null");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed"));
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String string = maxAdapterResponseParameters.getServerParameters().getString("encoded_bid_id");
        d("Loading rewarded ad for encoded bid id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (TextUtils.isEmpty(string)) {
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        DTBAdInterstitial dTBAdInterstitial = new DTBAdInterstitial(activity, new RewardedAdListener(maxRewardedAdapterListener));
        this.rewardedAd = dTBAdInterstitial;
        if (loadFullscreenAd(string, dTBAdInterstitial)) {
            return;
        }
        maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INVALID_LOAD_STATE);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad...");
        if (this.rewardedAd != null) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show();
        } else {
            e("Rewarded ad is null");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed"));
        }
    }

    private boolean loadFullscreenAd(String str, DTBAdInterstitial dTBAdInterstitial) {
        MediationHints mediationHints;
        synchronized (mediationHintsCacheLock) {
            Map<String, MediationHints> map = mediationHintsCache;
            mediationHints = map.get(str);
            map.remove(str);
        }
        if (mediationHints == null) {
            e("Unable to find mediation hints");
            return false;
        }
        dTBAdInterstitial.fetchAd(mediationHints.value);
        return true;
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private class AdViewListener implements DTBAdBannerListener {
        private final MaxAdViewAdapterListener listener;

        private AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLoaded(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView ad loaded");
            this.listener.onAdViewAdLoaded(view);
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdFailed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.e("AdView failed to load");
            this.listener.onAdViewAdLoadFailed(MaxAdapterError.UNSPECIFIED);
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClicked(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onImpressionFired(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView impression fired");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdOpen(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView expanded");
            this.listener.onAdViewAdExpanded();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClosed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView collapsed");
            this.listener.onAdViewAdCollapsed();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLeftApplication(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("AdView left application");
        }
    }

    private class InterstitialListener implements DTBAdInterstitialListener {
        private final MaxInterstitialAdapterListener listener;

        InterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLoaded(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial loaded");
            this.listener.onInterstitialAdLoaded();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdFailed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.e("Interstitial failed to load");
            this.listener.onInterstitialAdLoadFailed(MaxAdapterError.NO_FILL);
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onImpressionFired(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial did fire impression");
            this.listener.onInterstitialAdDisplayed();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdOpen(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial did open");
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClicked(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial clicked");
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.amazon.device.ads.DTBAdVideoListener
        public void onVideoCompleted(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial video completed");
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClosed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial closed");
            this.listener.onInterstitialAdHidden();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLeftApplication(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Interstitial will leave application");
        }
    }

    private class RewardedAdListener implements DTBAdInterstitialListener {
        private boolean hasGrantedReward;
        private final MaxRewardedAdapterListener listener;

        RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLoaded(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad loaded");
            this.listener.onRewardedAdLoaded();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdFailed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.e("Rewarded ad failed to load");
            this.listener.onRewardedAdLoadFailed(MaxAdapterError.NO_FILL);
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onImpressionFired(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad did fire impression");
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdOpen(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad did open");
            this.listener.onRewardedAdVideoStarted();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClicked(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // com.amazon.device.ads.DTBAdVideoListener
        public void onVideoCompleted(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad video completed");
            this.hasGrantedReward = true;
            this.listener.onRewardedAdVideoCompleted();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdClosed(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad closed");
            if (this.hasGrantedReward || AmazonAdMarketplaceMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = AmazonAdMarketplaceMediationAdapter.this.getReward();
                AmazonAdMarketplaceMediationAdapter.this.d("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            this.listener.onRewardedAdHidden();
        }

        @Override // com.amazon.device.ads.DTBAdListener
        public void onAdLeftApplication(View view) {
            AmazonAdMarketplaceMediationAdapter.this.d("Rewarded ad will leave application");
        }
    }

    private static class MediationHints {
        private final String id;
        private final String value;

        private MediationHints(String str) {
            this.id = UUID.randomUUID().toString().toLowerCase(Locale.US);
            this.value = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediationHints)) {
                return false;
            }
            MediationHints mediationHints = (MediationHints) obj;
            String str = this.id;
            if (str == null ? mediationHints.id != null : !str.equals(mediationHints.id)) {
                return false;
            }
            String str2 = this.value;
            String str3 = mediationHints.value;
            if (str2 != null) {
                return str2.equals(str3);
            }
            return str3 == null;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "MediationHints{id=" + this.id + ", value=" + this.value + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static class CleanupMediationHintsTask implements Runnable {
        private final String encodedBidId;
        private final MediationHints mediationHints;

        private CleanupMediationHintsTask(String str, MediationHints mediationHints) {
            this.encodedBidId = str;
            this.mediationHints = mediationHints;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AmazonAdMarketplaceMediationAdapter.mediationHintsCacheLock) {
                MediationHints mediationHints = (MediationHints) AmazonAdMarketplaceMediationAdapter.mediationHintsCache.get(this.encodedBidId);
                if (mediationHints != null && mediationHints.id.equals(this.mediationHints.id)) {
                    AmazonAdMarketplaceMediationAdapter.mediationHintsCache.remove(this.encodedBidId);
                }
            }
        }
    }
}
