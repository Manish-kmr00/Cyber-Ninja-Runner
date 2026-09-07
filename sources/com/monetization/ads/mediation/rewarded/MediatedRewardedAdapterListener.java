package com.monetization.ads.mediation.rewarded;

import com.monetization.ads.mediation.base.MediatedAdRequestError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/monetization/ads/mediation/rewarded/MediatedRewardedAdapterListener;", "", "onAdImpression", "", "onRewarded", "rewardItem", "Lcom/monetization/ads/mediation/rewarded/MediatedReward;", "onRewardedAdClicked", "onRewardedAdDismissed", "onRewardedAdFailedToLoad", "error", "Lcom/monetization/ads/mediation/base/MediatedAdRequestError;", "onRewardedAdLeftApplication", "onRewardedAdLoaded", "onRewardedAdShown", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedRewardedAdapterListener {
    void onAdImpression();

    void onRewarded(MediatedReward rewardItem);

    void onRewardedAdClicked();

    void onRewardedAdDismissed();

    void onRewardedAdFailedToLoad(MediatedAdRequestError error);

    void onRewardedAdLeftApplication();

    void onRewardedAdLoaded();

    void onRewardedAdShown();
}
