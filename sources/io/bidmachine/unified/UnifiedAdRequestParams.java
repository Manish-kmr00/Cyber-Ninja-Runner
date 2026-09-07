package io.bidmachine.unified;

import io.bidmachine.AdRequestParameters;
import io.bidmachine.GeneralParams;
import io.bidmachine.models.DeviceInfo;

/* JADX INFO: loaded from: classes13.dex */
public interface UnifiedAdRequestParams extends GeneralParams {
    AdRequestParameters getAdRequestParameters();

    DeviceInfo getDeviceInfo();
}
