package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.version.Version;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class GAMNetworkImpl implements GAMNetwork {
    private static final Map<String, GAMAdManager> GAM_AD_MANAGER_MAP = new HashMap();
    private static final Object GAM_AD_MANAGER_MAP_LOCK = new Object();
    final GAMAdManager gamAdManager;
    private final AtomicBoolean isInitialized;
    private final Tag tag;
    private final VersionWrapper versionWrapper;
    final Map<AdsFormat, WaterfallController> waterfallControllerMap;

    GAMNetworkImpl(Context context, NetworkParams networkParams, Waterfall.Context context2, VersionWrapper versionWrapper) {
        this(context, networkParams, context2, versionWrapper, obtainGamAdManager(networkParams.getNetworkKey()));
    }

    GAMNetworkImpl(Context context, NetworkParams networkParams, Waterfall.Context context2, VersionWrapper versionWrapper, GAMAdManager gAMAdManager) {
        GAMNetworkImpl gAMNetworkImpl = this;
        gAMNetworkImpl.tag = new Tag(networkParams.getNetworkName() + AndroidInitializeBoldSDK.MSG_NETWORK);
        gAMNetworkImpl.isInitialized = new AtomicBoolean(false);
        gAMNetworkImpl.versionWrapper = versionWrapper;
        gAMNetworkImpl.gamAdManager = gAMAdManager;
        gAMNetworkImpl.waterfallControllerMap = new EnumMap(AdsFormat.class);
        GAMEventTrackerImpl gAMEventTrackerImpl = new GAMEventTrackerImpl(context2.getEventConfig());
        TaskExecutorImpl taskExecutorImpl = new TaskExecutorImpl();
        for (Waterfall.Configuration configuration : context2.getConfigurationsList()) {
            AdsFormat adsFormatByRemoteName = AdsFormat.byRemoteName(configuration.getFormat());
            if (adsFormatByRemoteName != null) {
                gAMNetworkImpl.waterfallControllerMap.put(adsFormatByRemoteName, new WaterfallController(context, networkParams, adsFormatByRemoteName, configuration, versionWrapper, this, gAMAdManager, gAMEventTrackerImpl, taskExecutorImpl));
                gAMNetworkImpl = this;
            }
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public String getVersion() {
        try {
            Version version = this.versionWrapper.getVersion();
            if (version != null) {
                return version.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public boolean isInitialized() {
        return this.isInitialized.get();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void init(Context context) {
        if (this.isInitialized.getAndSet(true)) {
            return;
        }
        try {
            this.versionWrapper.initialize(context);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void cache() {
        for (AdsFormat adsFormat : AdsFormat.values()) {
            cacheWaterfall(adsFormat, false);
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void cache(AdsFormat adsFormat) {
        AdsFormat parent;
        if (cacheWaterfall(adsFormat, false) || (parent = adsFormat.getParent()) == null) {
            return;
        }
        cacheWaterfall(parent, false);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public boolean cacheWaterfall(AdsFormat adsFormat, boolean z) {
        WaterfallController waterfallController = this.waterfallControllerMap.get(adsFormat);
        if (waterfallController == null) {
            return false;
        }
        waterfallController.load(z);
        return true;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public InternalAdData reserveMostExpensiveAd(NetworkAdUnit networkAdUnit, AdsFormat adsFormat) {
        AdsFormat parent;
        InternalAdData internalAdDataReserveMostExpensiveAd = this.gamAdManager.reserveMostExpensiveAd(networkAdUnit, adsFormat);
        return (internalAdDataReserveMostExpensiveAd != null || (parent = adsFormat.getParent()) == null) ? internalAdDataReserveMostExpensiveAd : this.gamAdManager.reserveMostExpensiveAd(networkAdUnit, parent);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void unReserveAd(NetworkAdUnit networkAdUnit) {
        this.gamAdManager.unReserveAd(networkAdUnit);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadBanner(final NetworkAdUnit networkAdUnit, InternalBannerAdListener internalBannerAdListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load banner (Can't find reserved ad by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalBannerAdListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalBannerAd) {
            reservedAd.setAdPresentListener(internalBannerAdListener);
            internalBannerAdListener.onAdLoaded((InternalBannerAd) reservedAd);
        } else {
            onAdLoadFailed(internalBannerAdListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadInterstitial(final NetworkAdUnit networkAdUnit, InternalInterstitialAdListener internalInterstitialAdListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load interstitial (Can't find reserved ad by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalInterstitialAdListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalInterstitialAd) {
            reservedAd.setAdPresentListener(internalInterstitialAdListener);
            internalInterstitialAdListener.onAdLoaded((InternalInterstitialAd) reservedAd);
        } else {
            onAdLoadFailed(internalInterstitialAdListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadRewarded(final NetworkAdUnit networkAdUnit, InternalRewardedAdListener internalRewardedAdListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load rewarded (Can't find reserved ad by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalRewardedAdListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalRewardedAd) {
            reservedAd.setAdPresentListener(internalRewardedAdListener);
            internalRewardedAdListener.onAdLoaded((InternalRewardedAd) reservedAd);
        } else {
            onAdLoadFailed(internalRewardedAdListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    void onAdLoadFailed(InternalAdLoadListener<?> internalAdLoadListener, InternalAd internalAd, BMError bMError) {
        if (internalAd != null) {
            internalAd.destroy();
        }
        if (bMError == null) {
            bMError = BMError.NoFill;
        }
        internalAdLoadListener.onAdLoadFailed(bMError);
    }

    private static GAMAdManager obtainGamAdManager(String str) {
        Map<String, GAMAdManager> map = GAM_AD_MANAGER_MAP;
        GAMAdManager gAMAdManager = map.get(str);
        if (gAMAdManager != null) {
            return gAMAdManager;
        }
        synchronized (GAM_AD_MANAGER_MAP_LOCK) {
            GAMAdManager gAMAdManager2 = map.get(str);
            if (gAMAdManager2 != null) {
                return gAMAdManager2;
            }
            GAMAdManager gAMAdManager3 = new GAMAdManager(str);
            map.put(str, gAMAdManager3);
            return gAMAdManager3;
        }
    }

    static void clear() {
        GAM_AD_MANAGER_MAP.clear();
    }
}
