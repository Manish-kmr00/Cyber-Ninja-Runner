package com.smaato.sdk.core.datacollector;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class DataCollector {
    private final LocationProvider locationProvider;
    private final SystemInfoProvider systemInfoProvider;

    DataCollector(SystemInfoProvider systemInfoProvider, LocationProvider locationProvider) {
        this.systemInfoProvider = (SystemInfoProvider) Objects.requireNonNull(systemInfoProvider, "Parameter systemInfoProvider cannot be null for DataCollector::new");
        this.locationProvider = (LocationProvider) Objects.requireNonNull(locationProvider, "Parameter locationProvider cannot be null for DataCollector::new");
    }

    public SystemInfo getSystemInfo() {
        return this.systemInfoProvider.getSystemInfoSnapshot();
    }

    public LocationProvider.DetectedLocation getLocationData() {
        return this.locationProvider.getLocationData();
    }
}
