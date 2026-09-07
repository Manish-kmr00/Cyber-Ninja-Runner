package com.pubmatic.sdk.openwrap.interstitial;

import com.pubmatic.sdk.openwrap.core.POBBid;

/* JADX INFO: loaded from: classes10.dex */
public class POBDefaultInterstitialEventHandler extends POBInterstitialEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBInterstitialEventListener f7766a;

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void destroy() {
        this.f7766a = null;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void requestAd(POBBid pOBBid) {
        if (this.f7766a != null) {
            if (pOBBid != null && pOBBid.getStatus() == 1) {
                this.f7766a.onOpenWrapPartnerWin(pOBBid.getId());
            } else {
                this.f7766a.onFailedToLoad(prepareErrorFromResponse(this.f7766a.getBidsProvider()));
            }
        }
    }

    @Override // com.pubmatic.sdk.openwrap.interstitial.POBInterstitialEvent
    public void setEventListener(POBInterstitialEventListener pOBInterstitialEventListener) {
        this.f7766a = pOBInterstitialEventListener;
    }
}
