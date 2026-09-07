package com.smaato.sdk.core.gdpr;

import com.smaato.sdk.core.locationaware.LocationAware;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public class SomaGdprDataSource {
    private final IabCmpV2DataStorage iabCmpV2DataStorage;
    private final LocationAware locationAware;

    public SomaGdprDataSource(IabCmpV2DataStorage iabCmpV2DataStorage, LocationAware locationAware) {
        this.iabCmpV2DataStorage = (IabCmpV2DataStorage) Objects.requireNonNull(iabCmpV2DataStorage, "iabCmpV2DataStorage can not be null for SomaGdprDataSource::new");
        this.locationAware = locationAware;
    }

    public SomaGdprData getSomaGdprData() {
        return new SomaGdprV2Utils(this.locationAware).createSomaGdprData(this.iabCmpV2DataStorage.getCmpData());
    }
}
