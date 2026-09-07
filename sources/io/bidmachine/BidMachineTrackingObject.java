package io.bidmachine;

import io.bidmachine.models.AdObject;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.SessionTrackingObject;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes9.dex */
public class BidMachineTrackingObject extends SessionTrackingObject {
    public BidMachineTrackingObject() {
        super(BidMachineImpl.get().getSessionTracker());
    }

    public BidMachineTrackingObject(Object obj) {
        super(obj, BidMachineImpl.get().getSessionTracker());
    }

    public void eventFinish(TrackEventType trackEventType, AdsType adsType, AdResponse adResponse, BMError bMError) {
        EventData price;
        if (adResponse != null) {
            price = new EventData().setNetworkName(adResponse.getAuctionResult().getNetworkKey()).setPrice(Double.valueOf(adResponse.getPrice()));
            AdObject adObject = adResponse.getAdObject();
            if (adObject != null) {
                price.setCustomParams(adObject.getCustomParams());
            }
        } else {
            price = null;
        }
        eventFinish(trackEventType, adsType, price, bMError);
    }
}
