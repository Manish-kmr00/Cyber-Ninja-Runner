package io.bidmachine.ads.networks.gam;

import android.view.View;
import io.bidmachine.AdsFormat;

/* JADX INFO: loaded from: classes12.dex */
public abstract class InternalGAMBannerAd extends InternalGAMAd {
    protected abstract View getAdView();

    public InternalGAMBannerAd(GAMLoader gAMLoader, AdsFormat adsFormat, GAMUnitData gAMUnitData) {
        super(gAMLoader, adsFormat, gAMUnitData);
    }
}
