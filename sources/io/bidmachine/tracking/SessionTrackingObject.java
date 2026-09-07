package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;
import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
public class SessionTrackingObject extends TrackingObjectImpl {
    private final SessionTracker sessionTracker;

    public SessionTrackingObject(SessionTracker sessionTracker) {
        this(UUID.randomUUID(), sessionTracker);
    }

    public SessionTrackingObject(Object obj, SessionTracker sessionTracker) {
        super(obj);
        this.sessionTracker = sessionTracker;
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventStart(TrackEventType trackEventType, TrackEventInfo trackEventInfo) {
        this.sessionTracker.trackEventStart(this, trackEventType, trackEventInfo);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventFinish(TrackEventType trackEventType, AdsType adsType, EventData eventData, BMError bMError) {
        this.sessionTracker.trackEventFinish(this, trackEventType, adsType, bMError, eventData);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void clearEvent(TrackEventType trackEventType) {
        this.sessionTracker.clearTrackingEvent(this, trackEventType);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void clear() {
        this.sessionTracker.clearTrackingEvents(this);
    }
}
