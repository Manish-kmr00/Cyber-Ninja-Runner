package com.smaato.sdk.core.datacollector;

import android.location.Location;
import android.location.LocationManager;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
final class LocationDetector {
    private final AppMetaData appMetaData;
    private final LocationManager locationManager;

    LocationDetector(LocationManager locationManager, AppMetaData appMetaData) {
        this.locationManager = (LocationManager) Objects.requireNonNull(locationManager);
        this.appMetaData = (AppMetaData) Objects.requireNonNull(appMetaData);
    }

    Location getNetworkProvidedLocation() {
        if (hasPermission("android.permission.ACCESS_COARSE_LOCATION") && this.locationManager.isProviderEnabled("network")) {
            return this.locationManager.getLastKnownLocation("network");
        }
        return null;
    }

    private boolean hasPermission(String str) {
        return this.appMetaData.isPermissionGranted(str);
    }
}
