package io.bidmachine;

import io.bidmachine.AdRequestParameters;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.TargetingInfo;
import io.bidmachine.unified.UnifiedAdRequestParams;

/* JADX INFO: loaded from: classes13.dex */
public class UnifiedAdRequestParamsImpl<AdRequestParametersType extends AdRequestParameters> implements UnifiedAdRequestParams {
    private final AdRequestParametersType adRequestParameters;
    private final DataRestrictions dataRestrictions;
    private final io.bidmachine.models.DeviceInfo deviceInfo;
    private final TargetingInfo targetingInfo;

    protected UnifiedAdRequestParamsImpl(AdRequestParametersType adrequestparameterstype, TargetingParams targetingParams, DataRestrictions dataRestrictions) {
        this.adRequestParameters = adrequestparameterstype;
        this.targetingInfo = new TargetingInfoImpl(dataRestrictions, targetingParams);
        this.deviceInfo = new DeviceInfoImpl(dataRestrictions);
        this.dataRestrictions = dataRestrictions;
    }

    @Override // io.bidmachine.unified.UnifiedAdRequestParams, io.bidmachine.unified.UnifiedFullscreenAdRequestParams
    public AdRequestParametersType getAdRequestParameters() {
        return this.adRequestParameters;
    }

    @Override // io.bidmachine.GeneralParams
    public DataRestrictions getDataRestrictions() {
        return this.dataRestrictions;
    }

    @Override // io.bidmachine.GeneralParams
    public TargetingInfo getTargetingInfo() {
        return this.targetingInfo;
    }

    @Override // io.bidmachine.unified.UnifiedAdRequestParams
    public io.bidmachine.models.DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Override // io.bidmachine.GeneralParams
    public boolean isTestMode() {
        return BidMachineImpl.get().isTestMode();
    }
}
