package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenDisplayEventsListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceRewardedAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceRewardedDisplayEventsListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class q extends o implements MarketplaceRewardedAd, InneractiveFullScreenAdRewardedListener {
    public q(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAdLoadListener<MarketplaceFullscreenAd<MarketplaceRewardedDisplayEventsListener>> marketplaceAdLoadListener, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        super(str, jSONObject, map, z, marketplaceAdLoadListener, marketplaceAuctionParameters);
        this.mController.setRewardedListener(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener
    public void onAdRewarded(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceFullscreenDisplayEventsListener marketplaceFullscreenDisplayEventsListener = this.mEventsListener;
        if (marketplaceFullscreenDisplayEventsListener != null) {
            ((MarketplaceRewardedDisplayEventsListener) marketplaceFullscreenDisplayEventsListener).onReward();
        }
    }
}
