package com.yandex.mobile.ads.banner;

import com.json.nu;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.common.ImpressionData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/yandex/mobile/ads/banner/BannerAdEventListener;", "", nu.f, "", "onAdFailedToLoad", "error", "Lcom/yandex/mobile/ads/common/AdRequestError;", "onAdLoaded", "onImpression", "impressionData", "Lcom/yandex/mobile/ads/common/ImpressionData;", "onLeftApplication", "onReturnedToApplication", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface BannerAdEventListener {
    void onAdClicked();

    void onAdFailedToLoad(AdRequestError error);

    void onAdLoaded();

    void onImpression(ImpressionData impressionData);

    void onLeftApplication();

    void onReturnedToApplication();
}
