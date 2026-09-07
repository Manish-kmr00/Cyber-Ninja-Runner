package io.bidmachine.ads.networks.gam_dynamic;

import android.view.View;
import io.bidmachine.AdsFormat;
import io.bidmachine.protobuf.Waterfall;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InternalBannerAd extends InternalAd {
    protected abstract View getAdView();

    public InternalBannerAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }
}
