package com.pubmatic.sdk.openwrap.banner;

import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.openwrap.core.POBBid;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public class POBDefaultBannerEventHandler extends POBBannerEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBAdSize[] f7722a;
    private POBBannerEventListener b;

    public POBDefaultBannerEventHandler(POBAdSize... pOBAdSizeArr) {
        this.f7722a = pOBAdSizeArr;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void destroy() {
        this.b = null;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void requestAd(POBBid pOBBid) {
        if (this.b != null) {
            if (pOBBid != null && pOBBid.getStatus() == 1) {
                this.b.onOpenWrapPartnerWin(pOBBid.getId());
            } else {
                this.b.onFailed(prepareErrorFromResponse(this.b.getBidsProvider()));
            }
        }
    }

    @Override // com.pubmatic.sdk.openwrap.banner.POBBannerEvent
    public POBAdSize[] requestedAdSizes() {
        POBAdSize[] pOBAdSizeArr = this.f7722a;
        if (pOBAdSizeArr != null) {
            return (POBAdSize[]) Arrays.copyOf(pOBAdSizeArr, pOBAdSizeArr.length);
        }
        return null;
    }

    @Override // com.pubmatic.sdk.openwrap.banner.POBBannerEvent
    public void setEventListener(POBBannerEventListener pOBBannerEventListener) {
        this.b = pOBBannerEventListener;
    }

    public POBDefaultBannerEventHandler() {
    }
}
