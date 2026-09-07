package io.bidmachine.ads.networks.gam_dynamic;

/* JADX INFO: loaded from: classes13.dex */
public interface InternalAdListener {
    void onAdDestroyed(InternalAd internalAd, boolean z);

    void onAdExpired(InternalAd internalAd);

    void onAdShown(InternalAd internalAd);

    void onPaidEvent(InternalAd internalAd);
}
