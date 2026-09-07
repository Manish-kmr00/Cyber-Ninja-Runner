package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.GeoInfo;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.datacollector.SystemInfo;
import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Maps;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
final class ClientInfoMacros {
    private final DataCollector dataCollector;
    private final RequestInfoProvider requestInfoProvider;
    private final SdkConfiguration sdkConfiguration;

    ClientInfoMacros(DataCollector dataCollector, RequestInfoProvider requestInfoProvider, SdkConfiguration sdkConfiguration) {
        this.dataCollector = (DataCollector) Objects.requireNonNull(dataCollector);
        this.requestInfoProvider = (RequestInfoProvider) Objects.requireNonNull(requestInfoProvider);
        this.sdkConfiguration = (SdkConfiguration) Objects.requireNonNull(sdkConfiguration);
    }

    Map<String, String> toMap() {
        SystemInfo systemInfo = this.dataCollector.getSystemInfo();
        return Maps.mapOf(Maps.entryOf("[IFA]", getGoogleAdvertisingId()), Maps.entryOf("[IFATYPE]", "aaid"), Maps.entryOf("[CLIENTUA]", "unknown"), Maps.entryOf("[SERVERUA]", "-1"), Maps.entryOf("[DEVICEUA]", TextUtils.isEmpty(systemInfo.getUserAgent()) ? "-2" : systemInfo.getUserAgent()), Maps.entryOf("[SERVERSIDE]", "0"), Maps.entryOf("[DEVICEIP]", "-1"), Maps.entryOf("[LATLONG]", getLatLng()));
    }

    private String getGoogleAdvertisingId() {
        String googleAdId = this.requestInfoProvider.getGoogleAdId();
        return TextUtils.isEmpty(googleAdId) ? "-2" : googleAdId;
    }

    private String getLatLng() {
        GeoInfo geoInfo = this.requestInfoProvider.getGeoInfo(this.sdkConfiguration.getUserInfo());
        if (geoInfo == null) {
            return "-2";
        }
        return Joiner.join(StringUtils.COMMA, geoInfo.getFormattedLatitude(), geoInfo.getFormattedLongitude());
    }
}
