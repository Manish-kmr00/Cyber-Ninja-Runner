package com.smaato.sdk.core.lgpd;

import com.smaato.sdk.core.locationaware.LocationAware;

/* JADX INFO: loaded from: classes10.dex */
public final class SomaLgpdV2Utils implements SomaLgpdUtils {
    private final LocationAware locationAware;

    SomaLgpdV2Utils(LocationAware locationAware) {
        this.locationAware = locationAware;
    }

    @Override // com.smaato.sdk.core.lgpd.SomaLgpdUtils
    public SomaLgpdData createSomaLgpdData() {
        return new SomaLgpdData(this.locationAware);
    }
}
