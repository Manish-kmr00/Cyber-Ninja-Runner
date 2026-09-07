package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;

/* JADX INFO: loaded from: classes9.dex */
interface GAMNetwork {
    void cache();

    void cache(AdsFormat adsFormat);

    boolean cacheWaterfall(AdsFormat adsFormat, boolean z);

    String getVersion();

    void init(Context context);

    boolean isInitialized();

    void loadBanner(NetworkAdUnit networkAdUnit, InternalBannerAdListener internalBannerAdListener);

    void loadInterstitial(NetworkAdUnit networkAdUnit, InternalInterstitialAdListener internalInterstitialAdListener);

    void loadRewarded(NetworkAdUnit networkAdUnit, InternalRewardedAdListener internalRewardedAdListener);

    InternalAdData reserveMostExpensiveAd(NetworkAdUnit networkAdUnit, AdsFormat adsFormat);

    void unReserveAd(NetworkAdUnit networkAdUnit);
}
