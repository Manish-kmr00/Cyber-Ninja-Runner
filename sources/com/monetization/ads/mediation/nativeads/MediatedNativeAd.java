package com.monetization.ads.mediation.nativeads;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAd;", "", "mediatedNativeAdAssets", "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdAssets;", "getMediatedNativeAdAssets", "()Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdAssets;", "bindNativeAd", "", "viewProvider", "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdViewProvider;", "destroy", "unbindNativeAd", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedNativeAd {
    void bindNativeAd(MediatedNativeAdViewProvider viewProvider);

    void destroy();

    MediatedNativeAdAssets getMediatedNativeAdAssets();

    void unbindNativeAd(MediatedNativeAdViewProvider viewProvider);
}
