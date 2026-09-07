package com.smaato.sdk.core.remoteconfig.global;

import com.smaato.sdk.core.BuildConfig;

/* JADX INFO: loaded from: classes13.dex */
public class BuildConfigProvider {
    public static String getPublisherLogUrl() {
        return BuildConfig.PUBLISHER_CONFIGURATION_LOG_URL;
    }

    public static String getPublisherConfigUrl() {
        return BuildConfig.PUBLISHER_CONFIGURATION_URL;
    }

    public static String getSOMA_UB_URL() {
        return BuildConfig.SOMA_UB_URL;
    }

    public static String getEVENT_LOG_URL() {
        return BuildConfig.EVENT_LOG_URL;
    }
}
