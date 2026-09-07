package com.monetization.ads.mediation.base;

import com.json.k6;
import com.monetization.ads.mediation.banner.MediatedBannerSize;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/monetization/ads/mediation/base/MediatedBidderTokenLoadListener;", "", "onBidderTokenFailedToLoad", "", "failureReason", "", "onBidderTokenLoaded", "bidderToken", k6.u, "Lcom/monetization/ads/mediation/banner/MediatedBannerSize;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedBidderTokenLoadListener {
    void onBidderTokenFailedToLoad(String failureReason);

    void onBidderTokenLoaded(String bidderToken, MediatedBannerSize bannerSize);
}
