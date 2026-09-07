package com.fyber.marketplace.fairbid.impl;

import android.app.Activity;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdShowError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenDisplayEventsListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class o extends e implements MarketplaceFullscreenAd, InneractiveFullscreenAdEventsListener {
    protected final InneractiveFullscreenUnitController mController;
    protected MarketplaceFullscreenDisplayEventsListener mEventsListener;
    private final MarketplaceAdLoadListener<MarketplaceFullscreenAd<MarketplaceFullscreenDisplayEventsListener>> mLoadListener;

    public o(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAdLoadListener<MarketplaceFullscreenAd<MarketplaceFullscreenDisplayEventsListener>> marketplaceAdLoadListener, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        super(str, jSONObject, map, z, marketplaceAuctionParameters);
        this.mLoadListener = marketplaceAdLoadListener;
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = new InneractiveFullscreenUnitController();
        this.mController = inneractiveFullscreenUnitController;
        inneractiveFullscreenUnitController.setEventsListener(this);
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd
    public void destroy() {
        InneractiveAdSpot adSpot;
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = this.mController;
        if (inneractiveFullscreenUnitController == null || (adSpot = inneractiveFullscreenUnitController.getAdSpot()) == null) {
            return;
        }
        adSpot.destroy();
    }

    @Override // com.fyber.marketplace.fairbid.impl.e
    public void internalOnAdLoaded(e eVar, k kVar) {
        if (this.mController != null && kVar != null) {
            InneractiveAdSpotManager.get().bindSpot(kVar);
            this.mController.setAdSpot(kVar);
        }
        MarketplaceAdLoadListener<MarketplaceFullscreenAd<MarketplaceFullscreenDisplayEventsListener>> marketplaceAdLoadListener = this.mLoadListener;
        if (marketplaceAdLoadListener != null) {
            marketplaceAdLoadListener.onAdLoaded(this);
        }
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenAd
    public boolean isAvailable() {
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = this.mController;
        return inneractiveFullscreenUnitController != null && inneractiveFullscreenUnitController.isAvailable();
    }

    @Override // com.fyber.marketplace.fairbid.impl.e
    public boolean isFullscreen() {
        return true;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd
    public void load() {
        loadAd(this.mController, this.mLoadListener);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceFullscreenDisplayEventsListener marketplaceFullscreenDisplayEventsListener = this.mEventsListener;
        if (marketplaceFullscreenDisplayEventsListener != null) {
            marketplaceFullscreenDisplayEventsListener.onClick();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
    public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceFullscreenDisplayEventsListener marketplaceFullscreenDisplayEventsListener = this.mEventsListener;
        if (marketplaceFullscreenDisplayEventsListener != null) {
            marketplaceFullscreenDisplayEventsListener.onClose();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceFullscreenDisplayEventsListener marketplaceFullscreenDisplayEventsListener = this.mEventsListener;
        if (marketplaceFullscreenDisplayEventsListener != null) {
            marketplaceFullscreenDisplayEventsListener.onShow();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenAd
    public void show(Activity activity, MarketplaceFullscreenDisplayEventsListener marketplaceFullscreenDisplayEventsListener) {
        if (this.mController == null) {
            if (marketplaceFullscreenDisplayEventsListener != null) {
                marketplaceFullscreenDisplayEventsListener.onShowError(MarketplaceAdShowError.GENERIC_SHOW_ERROR);
            }
        } else {
            this.mEventsListener = marketplaceFullscreenDisplayEventsListener;
            if (this.adSpot.isReady()) {
                this.mController.show(activity);
            } else {
                marketplaceFullscreenDisplayEventsListener.onShowError(MarketplaceAdShowError.EXPIRED_AD_ERROR);
            }
        }
    }
}
