package com.pubmatic.sdk.nativead;

import android.view.View;
import com.pubmatic.sdk.common.POBAdServerSignalingEventListener;
import com.pubmatic.sdk.openwrap.core.POBBid;

/* JADX INFO: loaded from: classes10.dex */
public class POBDefaultNativeEventHandler extends POBNativeAdEvent {

    protected static class POBDefaultNativeAdEventBridge extends POBNativeAdEventBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private POBAdServerSignalingEventListener f7679a;

        protected POBDefaultNativeAdEventBridge() {
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
        public void destroy() {
        }

        @Override // com.pubmatic.sdk.nativead.POBNativeAdEventBridge
        public View getAdServerView() {
            return null;
        }

        @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
        public void requestAd(POBBid pOBBid) {
            if (this.f7679a != null) {
                if (pOBBid != null && pOBBid.getStatus() == 1) {
                    this.f7679a.onOpenWrapPartnerWin(pOBBid.getId());
                } else {
                    this.f7679a.onFailed(prepareErrorFromResponse(this.f7679a.getBidsProvider()));
                }
            }
        }

        @Override // com.pubmatic.sdk.nativead.POBNativeAdEventBridge
        public void setNativeAdEventListener(POBNativeAdEventListener pOBNativeAdEventListener) {
        }

        @Override // com.pubmatic.sdk.nativead.POBNativeAdEventBridge
        public void setSignalingEventListener(POBAdServerSignalingEventListener pOBAdServerSignalingEventListener) {
            this.f7679a = pOBAdServerSignalingEventListener;
        }

        @Override // com.pubmatic.sdk.nativead.POBNativeAdEventBridge
        public void trackClick() {
        }

        @Override // com.pubmatic.sdk.nativead.POBNativeAdEventBridge
        public void trackImpression() {
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdEvent
    public POBNativeAdEventBridge createNativeAdEventBridge() {
        return new POBDefaultNativeAdEventBridge();
    }
}
