package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public interface SessionTracker extends EventTracker {
    void clearTrackingEvent(TrackingObject trackingObject, TrackEventType trackEventType);

    void clearTrackingEvents(TrackingObject trackingObject);

    void trackEventFinish(TrackingObject trackingObject, TrackEventType trackEventType, AdsType adsType, BMError bMError, EventData eventData);

    void trackEventStart(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo);
}
