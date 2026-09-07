package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.AdsFormat;
import io.bidmachine.protobuf.Waterfall;

/* JADX INFO: loaded from: classes11.dex */
public abstract class InternalRewardedAd extends InternalFullscreenAd {
    public InternalRewardedAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }
}
