package com.monetization.ads.mediation.nativeads;

import com.json.nu;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdapterListener;", "", "", nu.f, "()V", nu.g, "onAdImpression", nu.k, nu.c, "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAd;", "mediatedNativeAd", "onAppInstallAdLoaded", "(Lcom/monetization/ads/mediation/nativeads/MediatedNativeAd;)V", "onContentAdLoaded", "Lcom/monetization/ads/mediation/base/MediatedAdRequestError;", "error", "onAdFailedToLoad", "(Lcom/monetization/ads/mediation/base/MediatedAdRequestError;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public interface MediatedNativeAdapterListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(MediatedAdRequestError error);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdOpened();

    void onAppInstallAdLoaded(MediatedNativeAd mediatedNativeAd);

    void onContentAdLoaded(MediatedNativeAd mediatedNativeAd);
}
