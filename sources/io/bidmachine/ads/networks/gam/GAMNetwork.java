package io.bidmachine.ads.networks.gam;

import android.content.Context;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.ads.networks.gam.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.version.Version;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
class GAMNetwork {
    private final GAMLoader gamLoader;
    private final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final boolean overrideCallbacks;
    private final Tag tag;
    private final VersionWrapper versionWrapper;

    GAMNetwork(Context context, VersionWrapper versionWrapper, String str, Map<AdsFormat, GAMTypeConfig> map, String str2, long j, boolean z) {
        this.tag = new Tag(str + AndroidInitializeBoldSDK.MSG_NETWORK);
        this.versionWrapper = versionWrapper;
        this.gamLoader = new GAMLoader(context, versionWrapper, str, map, str2, j);
        this.overrideCallbacks = z;
    }

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

    public GAMLoader getGAMLoader() {
        return this.gamLoader;
    }

    public boolean isOverrideCallbacks() {
        return this.overrideCallbacks;
    }

    void init(Context context) {
        if (this.isInitialized.getAndSet(true)) {
            return;
        }
        try {
            this.versionWrapper.initialize(context);
        } catch (Throwable unused) {
        }
    }

    void cache() {
        this.gamLoader.load();
    }

    void cache(AdsFormat adsFormat) {
        AdsFormat parent;
        if (this.gamLoader.load(adsFormat) || (parent = adsFormat.getParent()) == null) {
            return;
        }
        this.gamLoader.load(parent);
    }

    boolean isInitialized() {
        return this.isInitialized.get();
    }

    GAMUnitData reserveMostExpensiveGAMAd(NetworkAdUnit networkAdUnit, String str) {
        return this.gamLoader.reserveMostExpensiveGAMAd(networkAdUnit, str);
    }

    void unReserveGAMAd(NetworkAdUnit networkAdUnit) {
        this.gamLoader.unReserveGAMAd(networkAdUnit);
    }

    void loadBanner(final NetworkAdUnit networkAdUnit, InternalGAMBannerAdListener internalGAMBannerAdListener) {
        InternalGAMAd reservedGAMAd = this.gamLoader.getReservedGAMAd(networkAdUnit);
        if (reservedGAMAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMNetwork$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load banner (Can't find reserved GAMAd by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalGAMBannerAdListener, null, BMError.internal("Can't find reserved GAMAd by NetworkAdUnit"));
        } else if (reservedGAMAd instanceof InternalGAMBannerAd) {
            reservedGAMAd.setAdPresentListener(internalGAMBannerAdListener);
            internalGAMBannerAdListener.onAdLoaded((InternalGAMBannerAd) reservedGAMAd);
        } else {
            onAdLoadFailed(internalGAMBannerAdListener, reservedGAMAd, BMError.internal("InternalGAM object has an incompatible ad type"));
        }
    }

    void loadInterstitial(final NetworkAdUnit networkAdUnit, InternalGAMInterstitialAdListener internalGAMInterstitialAdListener) {
        InternalGAMAd reservedGAMAd = this.gamLoader.getReservedGAMAd(networkAdUnit);
        if (reservedGAMAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMNetwork$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load interstitial (Can't find reserved GAMAd by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalGAMInterstitialAdListener, null, BMError.internal("Can't find reserved GAMAd by NetworkAdUnit"));
        } else if (reservedGAMAd instanceof InternalGAMInterstitialAd) {
            reservedGAMAd.setAdPresentListener(internalGAMInterstitialAdListener);
            internalGAMInterstitialAdListener.onAdLoaded((InternalGAMInterstitialAd) reservedGAMAd);
        } else {
            onAdLoadFailed(internalGAMInterstitialAdListener, reservedGAMAd, BMError.internal("InternalGAM object has an incompatible ad type"));
        }
    }

    void loadRewarded(final NetworkAdUnit networkAdUnit, InternalGAMRewardedAdListener internalGAMRewardedAdListener) {
        InternalGAMAd reservedGAMAd = this.gamLoader.getReservedGAMAd(networkAdUnit);
        if (reservedGAMAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.GAMNetwork$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Fail to load rewarded (Can't find reserved GAMAd by network ad unit id - %s)", networkAdUnit.getId());
                }
            });
            onAdLoadFailed(internalGAMRewardedAdListener, null, BMError.internal("Can't find reserved GAMAd by NetworkAdUnit"));
        } else if (reservedGAMAd instanceof InternalGAMRewardedAd) {
            reservedGAMAd.setAdPresentListener(internalGAMRewardedAdListener);
            internalGAMRewardedAdListener.onAdLoaded((InternalGAMRewardedAd) reservedGAMAd);
        } else {
            onAdLoadFailed(internalGAMRewardedAdListener, reservedGAMAd, BMError.internal("InternalGAM object has an incompatible ad type"));
        }
    }

    private void onAdLoadFailed(InternalGAMAdLoadListener<?> internalGAMAdLoadListener, InternalGAMAd internalGAMAd, BMError bMError) {
        if (internalGAMAd != null) {
            try {
                internalGAMAd.destroy();
            } catch (Throwable unused) {
            }
        }
        if (bMError == null) {
            bMError = BMError.NoFill;
        }
        internalGAMAdLoadListener.onAdLoadFailed(bMError);
    }
}
