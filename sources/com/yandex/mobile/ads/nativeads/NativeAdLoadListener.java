package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeAdLoadListener;", "", "onAdFailedToLoad", "", "error", "Lcom/yandex/mobile/ads/common/AdRequestError;", "onAdLoaded", "nativeAd", "Lcom/yandex/mobile/ads/nativeads/NativeAd;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeAdLoadListener {
    void onAdFailedToLoad(AdRequestError error);

    void onAdLoaded(NativeAd nativeAd);
}
