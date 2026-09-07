package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.AdsFormat;
import io.bidmachine.TrackEventType;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.EventTracker;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes7.dex */
interface GAMEventTracker extends EventTracker {
    void trackEvent(TrackEventType trackEventType, AdsFormat adsFormat, EventData eventData, BMError bMError);
}
