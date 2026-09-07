package com.fyber.marketplace.fairbid.impl;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBannerDisplayEventsListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends e implements MarketplaceBannerAd, InneractiveAdViewEventsListener {
    private FrameLayout mContainer;
    private final InneractiveAdViewUnitController mController;
    private MarketplaceBannerDisplayEventsListener mEventsListener;
    private boolean mInternalBrowserPossiblyOpen;
    private final MarketplaceAdLoadListener<MarketplaceBannerAd> mLoadListener;

    public j(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAdLoadListener<MarketplaceBannerAd> marketplaceAdLoadListener, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        super(str, jSONObject, map, z, marketplaceAuctionParameters);
        this.mInternalBrowserPossiblyOpen = false;
        this.mLoadListener = marketplaceAdLoadListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = new InneractiveAdViewUnitController(true);
        this.mController = inneractiveAdViewUnitController;
        inneractiveAdViewUnitController.setEventsListener(this);
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd
    public boolean canRefresh() {
        return !this.mInternalBrowserPossiblyOpen && this.mController.canRefreshAd();
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd
    public void destroy() {
        if (this.mController != null) {
            FrameLayout frameLayout = this.mContainer;
            if (frameLayout != null) {
                ViewParent parent = frameLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeAllViews();
                }
                this.mController.unbindView(this.mContainer);
                this.mContainer = null;
            }
            InneractiveAdSpot adSpot = this.mController.getAdSpot();
            if (adSpot != null) {
                adSpot.destroy();
            }
        }
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd
    public int getAdHeight() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController != null) {
            return inneractiveAdViewUnitController.getAdContentHeight();
        }
        return 0;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd
    public int getAdWidth() {
        return this.mController != null ? -1 : 0;
    }

    @Override // com.fyber.marketplace.fairbid.impl.e
    public void internalOnAdLoaded(e eVar, k kVar) {
        if (this.mController != null && kVar != null) {
            InneractiveAdSpotManager.get().bindSpot(kVar);
            this.mController.setAdSpot(kVar);
        }
        MarketplaceAdLoadListener<MarketplaceBannerAd> marketplaceAdLoadListener = this.mLoadListener;
        if (marketplaceAdLoadListener != null) {
            marketplaceAdLoadListener.onAdLoaded(this);
        }
    }

    @Override // com.fyber.marketplace.fairbid.impl.e
    public boolean isFullscreen() {
        return false;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd
    public boolean isUsingFullWidth() {
        return true;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd
    public void load() {
        loadAd(this.mController, this.mLoadListener);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = true;
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener = this.mEventsListener;
        if (marketplaceBannerDisplayEventsListener != null) {
            marketplaceBannerDisplayEventsListener.onClick();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController == null || (marketplaceBannerDisplayEventsListener = this.mEventsListener) == null) {
            return;
        }
        marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController == null || (marketplaceBannerDisplayEventsListener = this.mEventsListener) == null) {
            return;
        }
        marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener = this.mEventsListener;
        if (marketplaceBannerDisplayEventsListener != null) {
            marketplaceBannerDisplayEventsListener.onShow();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
        MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener;
        InneractiveAdViewUnitController inneractiveAdViewUnitController = this.mController;
        if (inneractiveAdViewUnitController == null || (marketplaceBannerDisplayEventsListener = this.mEventsListener) == null) {
            return;
        }
        marketplaceBannerDisplayEventsListener.onSizeChange(inneractiveAdViewUnitController.getAdContentWidth(), this.mController.getAdContentHeight());
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = false;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        this.mInternalBrowserPossiblyOpen = false;
    }

    @Override // com.fyber.marketplace.fairbid.bridge.MarketplaceBannerAd
    public void showInView(ViewGroup viewGroup, MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener) {
        if (this.mController == null || this.adSpot == null) {
            IAlog.b("Banner is not ready to be shown", new Object[0]);
            return;
        }
        this.mContainer = new i(viewGroup.getContext());
        viewGroup.removeAllViews();
        viewGroup.addView(this.mContainer);
        this.mController.bindView(this.mContainer);
        this.mEventsListener = marketplaceBannerDisplayEventsListener;
    }
}
