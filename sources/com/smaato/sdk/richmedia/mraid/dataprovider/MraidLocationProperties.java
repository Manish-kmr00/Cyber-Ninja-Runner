package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.ad.GeoInfo;
import com.smaato.sdk.core.ad.RequestInfoMapper;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public final class MraidLocationProperties {
    public final LatLng latLng;
    public final Integer locationServiceType;

    private MraidLocationProperties(LatLng latLng, Integer num) {
        this.latLng = latLng;
        this.locationServiceType = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MraidLocationProperties.class != obj.getClass()) {
            return false;
        }
        MraidLocationProperties mraidLocationProperties = (MraidLocationProperties) obj;
        return Objects.equals(this.latLng, mraidLocationProperties.latLng) && Objects.equals(this.locationServiceType, mraidLocationProperties.locationServiceType);
    }

    public int hashCode() {
        return Objects.hash(this.latLng, this.locationServiceType);
    }

    public static MraidLocationProperties create(RequestInfoProvider requestInfoProvider, SdkConfiguration sdkConfiguration, RequestInfoMapper requestInfoMapper) {
        GeoInfo geoInfo = requestInfoProvider.getGeoInfo(sdkConfiguration.getUserInfo());
        if (geoInfo == null) {
            return new MraidLocationProperties(null, null);
        }
        return new MraidLocationProperties(geoInfo.getLatLng(), requestInfoMapper.mapToApiValue(geoInfo.getGeoType()));
    }
}
