package io.bidmachine.ads.networks.gam;

import android.app.Activity;
import io.bidmachine.AdsFormat;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InternalGAMFullscreenAd extends InternalGAMAd {
    protected abstract void showAd(Activity activity, InternalGAMFullscreenAdPresentListener internalGAMFullscreenAdPresentListener) throws Throwable;

    public InternalGAMFullscreenAd(GAMLoader gAMLoader, AdsFormat adsFormat, GAMUnitData gAMUnitData) {
        super(gAMLoader, adsFormat, gAMUnitData);
    }

    public final void show(final Activity activity, final InternalGAMFullscreenAdPresentListener internalGAMFullscreenAdPresentListener) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam.InternalGAMFullscreenAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7380x5f55a489(activity, internalGAMFullscreenAdPresentListener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$show$0$io-bidmachine-ads-networks-gam-InternalGAMFullscreenAd, reason: not valid java name */
    /* synthetic */ void m7380x5f55a489(Activity activity, InternalGAMFullscreenAdPresentListener internalGAMFullscreenAdPresentListener) {
        try {
            setStatus(InternalGAMAd.Status.Showing);
            showAd(activity, internalGAMFullscreenAdPresentListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalGAMFullscreenAdPresentListener.onAdShowFailed(BMError.throwable("Exception showing InternalGAM object", th));
        }
    }
}
