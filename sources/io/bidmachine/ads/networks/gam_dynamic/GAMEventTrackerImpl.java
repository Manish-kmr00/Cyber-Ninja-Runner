package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.AdsFormat;
import io.bidmachine.TrackEventType;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.EventTrackerImpl;
import io.bidmachine.tracking.SimpleTrackingObject;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
class GAMEventTrackerImpl extends EventTrackerImpl implements GAMEventTracker {
    GAMEventTrackerImpl(AdExtension.EventConfiguration eventConfiguration) {
        super(eventConfiguration);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMEventTracker
    public void trackEvent(TrackEventType trackEventType, AdsFormat adsFormat, EventData eventData, BMError bMError) {
        trackEvent(new SimpleTrackingObject(), trackEventType, null, adsFormat.getAdsType(), bMError, eventData);
    }
}
