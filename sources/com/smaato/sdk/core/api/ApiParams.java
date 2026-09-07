package com.smaato.sdk.core.api;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.network.NetworkConnectionType;

/* JADX INFO: loaded from: classes11.dex */
public class ApiParams {
    private final DataCollector dataCollector;
    private final RequestInfoProvider requestInfoProvider;

    public ApiParams(DataCollector dataCollector, RequestInfoProvider requestInfoProvider) {
        this.dataCollector = dataCollector;
        this.requestInfoProvider = requestInfoProvider;
    }

    public String getClient() {
        if (!SmaatoSdk.getUnityVersion().isEmpty()) {
            return "sdkandroid_" + SmaatoSdk.getVersion() + "_unity_" + SmaatoSdk.getUnityVersion();
        }
        return "sdkandroid_" + SmaatoSdk.getVersion();
    }

    public String getBundle() {
        return this.dataCollector.getSystemInfo().getPackageName();
    }

    public String getGoogleAdId() {
        return this.requestInfoProvider.getGoogleAdId();
    }

    public Boolean getGoogleDnt() {
        return this.dataCollector.getSystemInfo().isGoogleLimitAdTrackingEnabled();
    }

    public int getCoppa() {
        return SmaatoSdk.getCoppa() ? 1 : 0;
    }

    public String getConnectionType() {
        NetworkConnectionType networkConnectionType = this.dataCollector.getSystemInfo().getNetworkConnectionType();
        if (networkConnectionType != null) {
            return networkConnectionType.toString();
        }
        return null;
    }
}
