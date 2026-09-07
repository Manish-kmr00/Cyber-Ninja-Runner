package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBannerListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridge;
import com.fyber.marketplace.fairbid.bridge.MarketplaceInterstitialListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceOnUserAgentAvailableListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceRewardedListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class n extends MarketplaceBridge {
    public final g c = new g(new com.fyber.inneractive.sdk.serverapi.c(r.a()));
    public boolean d = false;

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final MarketplaceAuctionParameters getAuctionParameters(String str) {
        g gVar = this.c;
        gVar.d = str;
        return gVar;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final boolean isMuted() {
        return this.d;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final void loadBannerAd(String str, JSONObject jSONObject, Map map, MarketplaceBannerListener marketplaceBannerListener) {
        IAlog.a("Request Banner with spotId = %s", str);
        j jVar = new j(str, jSONObject, map, this.d, marketplaceBannerListener, this.c);
        com.fyber.inneractive.sdk.dv.j wrapperQueryInfo = this.c.getWrapperQueryInfo(str);
        if (wrapperQueryInfo != null) {
            jVar.setQueryInfo(wrapperQueryInfo);
        }
        IAConfigManager.addListener(new m(this, jVar, marketplaceBannerListener));
        IAConfigManager.a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final void loadInterstitialAd(String str, JSONObject jSONObject, Map map, MarketplaceInterstitialListener marketplaceInterstitialListener) {
        IAlog.a("Request Interstitial with spotId = %s", str);
        IAConfigManager.addListener(new m(this, new p(str, jSONObject, map, this.d, marketplaceInterstitialListener, this.c), marketplaceInterstitialListener));
        IAConfigManager.a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final void loadRewardedAd(String str, JSONObject jSONObject, Map map, MarketplaceRewardedListener marketplaceRewardedListener) {
        IAlog.a("Request Interstitial with spotId = %s", str);
        IAConfigManager.addListener(new m(this, new q(str, jSONObject, map, this.d, marketplaceRewardedListener, this.c), marketplaceRewardedListener));
        IAConfigManager.a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final String requestUserAgent(MarketplaceOnUserAgentAvailableListener marketplaceOnUserAgentAvailableListener) {
        com.fyber.inneractive.sdk.util.r.f2374a.execute(new l(marketplaceOnUserAgentAvailableListener));
        return IAConfigManager.O.y.a();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final void setMuted(boolean z) {
        this.d = z;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridge
    public final MarketplaceAuctionParameters getAuctionParameters() {
        g gVar = this.c;
        gVar.d = "";
        return gVar;
    }
}
