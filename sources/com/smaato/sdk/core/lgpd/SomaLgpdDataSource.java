package com.smaato.sdk.core.lgpd;

import com.smaato.sdk.core.locationaware.LocationAware;

/* JADX INFO: loaded from: classes5.dex */
public class SomaLgpdDataSource {
    private final LocationAware locationAware;

    public SomaLgpdDataSource(LocationAware locationAware) {
        this.locationAware = locationAware;
    }

    public SomaLgpdData getSomaLgpdData() {
        return new SomaLgpdV2Utils(this.locationAware).createSomaLgpdData();
    }
}
