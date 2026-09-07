package com.smaato.sdk.video.vast.tracking;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.VastBeaconEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
class VastTrackingBeaconsManager {
    private final Set trackedBeaconEvents = Collections.synchronizedSet(new HashSet());
    private final Map trackingBeaconEvents;

    VastTrackingBeaconsManager(Map<VastBeaconEvent, Collection<String>> map) {
        this.trackingBeaconEvents = new HashMap((Map) Objects.requireNonNull(map));
    }

    Set<String> getNotSentBeaconUrls(VastBeaconEvent vastBeaconEvent) {
        Collection collection;
        if (this.trackedBeaconEvents.contains(vastBeaconEvent)) {
            return Collections.emptySet();
        }
        if (this.trackingBeaconEvents.containsKey(vastBeaconEvent) && (collection = (Collection) this.trackingBeaconEvents.get(vastBeaconEvent)) != null) {
            return Collections.unmodifiableSet(new HashSet(collection));
        }
        return Collections.emptySet();
    }

    void markAsTracked(VastBeaconEvent vastBeaconEvent) {
        this.trackedBeaconEvents.add(vastBeaconEvent);
    }

    boolean isTracked(VastBeaconEvent vastBeaconEvent) {
        return this.trackedBeaconEvents.contains(vastBeaconEvent);
    }
}
