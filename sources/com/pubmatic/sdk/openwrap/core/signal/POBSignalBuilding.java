package com.pubmatic.sdk.openwrap.core.signal;

import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalBuilding;", "", "build", "", "setDeviceInfo", "", POBCrashAnalyticsConstants.DEVICE_INFO_KEY, "Lcom/pubmatic/sdk/common/models/POBDeviceInfo;", "setRequest", "request", "Lcom/pubmatic/sdk/openwrap/core/POBRequest;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface POBSignalBuilding {
    String build();

    void setDeviceInfo(POBDeviceInfo deviceInfo);

    void setRequest(POBRequest request);
}
