package io.bidmachine;

import android.content.Context;
import io.bidmachine.models.DataRestrictions;

/* JADX INFO: loaded from: classes9.dex */
class DeviceInfoImpl implements io.bidmachine.models.DeviceInfo {
    private final DataRestrictions dataRestrictions;

    DeviceInfoImpl(DataRestrictions dataRestrictions) {
        this.dataRestrictions = dataRestrictions;
    }

    @Override // io.bidmachine.models.DeviceInfo
    public String getHttpAgent(Context context) {
        if (this.dataRestrictions.canSendDeviceInfo()) {
            return UserAgentManager.getUserAgent(context);
        }
        return null;
    }

    @Override // io.bidmachine.models.DeviceInfo
    public String getIfa(Context context) {
        return AdvertisingDataManager.getAdvertisingId(context, !this.dataRestrictions.canSendIfa());
    }

    @Override // io.bidmachine.models.DeviceInfo
    public boolean isLimitAdTrackingEnabled() {
        return AdvertisingDataManager.isLimitAdTrackingEnabled();
    }
}
