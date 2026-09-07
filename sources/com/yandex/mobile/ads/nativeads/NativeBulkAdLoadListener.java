package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.common.AdRequestError;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/NativeBulkAdLoadListener;", "", "onAdsFailedToLoad", "", "error", "Lcom/yandex/mobile/ads/common/AdRequestError;", "onAdsLoaded", "nativeAds", "", "Lcom/yandex/mobile/ads/nativeads/NativeAd;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeBulkAdLoadListener {
    void onAdsFailedToLoad(AdRequestError error);

    void onAdsLoaded(List<NativeAd> nativeAds);
}
