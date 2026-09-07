package com.smaato.sdk.core.lgpd;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.locationaware.LocationAware;

/* JADX INFO: loaded from: classes13.dex */
public class SomaLgpdData {
    private final LocationAware locationAware;

    SomaLgpdData(LocationAware locationAware) {
        this.locationAware = locationAware;
    }

    public boolean isLgpdEnabled() {
        return this.locationAware.isConsentCountry();
    }

    public Boolean isLgpdConsentEnabled() {
        return SmaatoSdk.isLGPDConsentEnabled();
    }

    public boolean isUsageAllowedFor() {
        Boolean boolIsLGPDConsentEnabled = SmaatoSdk.isLGPDConsentEnabled();
        if (boolIsLGPDConsentEnabled != null) {
            return boolIsLGPDConsentEnabled.booleanValue();
        }
        return true;
    }
}
