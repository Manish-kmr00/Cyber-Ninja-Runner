package com.smaato.sdk.core.datacollector;

import android.location.Location;
import com.smaato.sdk.core.util.Clock;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class LocationProvider {
    private final Clock clock;
    private DetectedLocation lastKnownLocation;
    private final LocationDetector locationDetector;
    private long locationRefreshTimeMillis;

    LocationProvider(LocationDetector locationDetector, Clock clock, long j) {
        this.locationDetector = (LocationDetector) Objects.requireNonNull(locationDetector);
        this.clock = (Clock) Objects.requireNonNull(clock);
        this.locationRefreshTimeMillis = j;
    }

    DetectedLocation getLocationData() {
        if (isLocationFresh()) {
            return this.lastKnownLocation;
        }
        DetectedLocation detectedLocationDetectLocation = detectLocation();
        this.lastKnownLocation = detectedLocationDetectLocation;
        return detectedLocationDetectLocation;
    }

    private DetectedLocation detectLocation() {
        return getNetworkProvidedLocation();
    }

    private DetectedLocation getNetworkProvidedLocation() {
        Location networkProvidedLocation = this.locationDetector.getNetworkProvidedLocation();
        if (networkProvidedLocation == null) {
            return null;
        }
        return new DetectedLocation(networkProvidedLocation, DetectedLocation.TYPE.NETWORK, this.clock.elapsedRealtime());
    }

    private boolean isLocationFresh() {
        return this.lastKnownLocation != null && this.clock.elapsedRealtime() - this.lastKnownLocation.lastUpdatedMillis <= this.locationRefreshTimeMillis;
    }

    public static final class DetectedLocation {
        private final long lastUpdatedMillis;
        final Location location;
        private final TYPE type;

        public enum TYPE {
            GPS,
            NETWORK
        }

        private DetectedLocation(Location location, TYPE type, long j) {
            this.location = location;
            this.type = type;
            this.lastUpdatedMillis = j;
        }

        public double getLatitude() {
            return this.location.getLatitude();
        }

        public double getLongitude() {
            return this.location.getLongitude();
        }

        public float getAccuracy() {
            return this.location.getAccuracy();
        }

        public TYPE getType() {
            return this.type;
        }

        public long getLastUpdatedMillis() {
            return this.lastUpdatedMillis;
        }
    }
}
