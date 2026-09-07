package com.yandex.mobile.ads.feed;

import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/yandex/mobile/ads/feed/FeedAdLoadListener;", "", "onAdFailedToLoad", "", "error", "Lcom/yandex/mobile/ads/common/AdRequestError;", "onAdLoaded", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FeedAdLoadListener {
    void onAdFailedToLoad(AdRequestError error);

    void onAdLoaded();
}
