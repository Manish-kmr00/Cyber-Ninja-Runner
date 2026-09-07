package io.bidmachine.ads.networks.gam_dynamic;

import android.app.Activity;
import io.bidmachine.AdsFormat;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public abstract class InternalFullscreenAd extends InternalAd {
    protected abstract void showAd(Activity activity, InternalFullscreenAdPresentListener internalFullscreenAdPresentListener) throws Throwable;

    public InternalFullscreenAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }

    public final void show(final Activity activity, final InternalFullscreenAdPresentListener internalFullscreenAdPresentListener) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7393x61fb8266(activity, internalFullscreenAdPresentListener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$show$0$io-bidmachine-ads-networks-gam_dynamic-InternalFullscreenAd, reason: not valid java name */
    /* synthetic */ void m7393x61fb8266(Activity activity, InternalFullscreenAdPresentListener internalFullscreenAdPresentListener) {
        try {
            setStatus(InternalAd.Status.Showing);
            showAd(activity, internalFullscreenAdPresentListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalFullscreenAdPresentListener.onAdShowFailed(BMError.throwable("Exception showing InternalAd object", th));
        }
    }
}
