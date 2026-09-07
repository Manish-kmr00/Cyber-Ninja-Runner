package com.applovin.impl.sdk.array;

import com.applovin.array.apphub.aidl.IAppHubService;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* JADX INFO: loaded from: classes5.dex */
public class ArrayDataCollector {
    private static final String TAG = "ArrayService";
    private final o logger;
    private final k sdk;

    public ArrayDataCollector(k kVar) {
        this.sdk = kVar;
        this.logger = kVar.O();
    }

    public long collectAppHubVersionCode(IAppHubService iAppHubService) {
        try {
            return iAppHubService.getAppHubVersionCode();
        } catch (Throwable th) {
            if (!o.a()) {
                return -1L;
            }
            this.logger.a(TAG, "Failed to collect version code", th);
            return -1L;
        }
    }

    public Boolean collectDirectDownloadEnabled(IAppHubService iAppHubService) {
        try {
            return Boolean.valueOf(iAppHubService.getEnabledFeatures().getBoolean("DIRECT_DOWNLOAD"));
        } catch (Throwable th) {
            if (!o.a()) {
                return null;
            }
            this.logger.a(TAG, "Failed to collect enabled features", th);
            return null;
        }
    }

    public String collectRandomUserToken(IAppHubService iAppHubService) {
        try {
            return iAppHubService.getRandomUserToken();
        } catch (Throwable th) {
            if (!o.a()) {
                return null;
            }
            this.logger.a(TAG, "Failed to collect random user token", th);
            return null;
        }
    }
}
