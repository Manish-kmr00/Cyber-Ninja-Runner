package io.bidmachine.rewarded;

import android.content.Context;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.FullScreenAd;
import io.bidmachine.FullScreenAdObject;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedFullscreenAd;

/* JADX INFO: loaded from: classes13.dex */
public final class RewardedAd extends FullScreenAd<RewardedAd, RewardedRequest, FullScreenAdObject<RewardedRequest>, RewardedListener> {
    public RewardedAd(Context context) {
        super(context, AdsType.Rewarded);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public FullScreenAdObject<RewardedRequest> createAdObject(ContextProvider contextProvider, RewardedRequest rewardedRequest, NetworkAdapter networkAdapter, AdObjectParams adObjectParams, AdProcessCallback adProcessCallback) {
        UnifiedFullscreenAd unifiedFullscreenAdCreateRewarded = networkAdapter.createRewarded();
        if (unifiedFullscreenAdCreateRewarded == null) {
            return null;
        }
        return new FullScreenAdObject<>(contextProvider, adProcessCallback, rewardedRequest, adObjectParams, unifiedFullscreenAdCreateRewarded);
    }
}
