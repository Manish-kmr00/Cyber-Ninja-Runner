package io.bidmachine;

import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.EventTracker;
import io.bidmachine.tracking.SessionTrackerImpl;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
class BidMachineSessionTracker extends SessionTrackerImpl {
    private final BidMachineEventTracker bidMachineEventTracker;

    BidMachineSessionTracker(EventTracker eventTracker) {
        super(eventTracker);
        this.bidMachineEventTracker = new BidMachineEventTracker();
    }

    @Override // io.bidmachine.tracking.SessionTrackerImpl, io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bMError, EventData eventData) {
        super.trackEvent(trackingObject, trackEventType, trackEventInfo, adsType, bMError, eventData);
        this.bidMachineEventTracker.trackEvent(trackingObject, trackEventType, trackEventInfo, adsType, bMError, eventData);
    }
}
