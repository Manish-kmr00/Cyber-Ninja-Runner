package com.smaato.sdk.core.ad;

import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.util.Objects;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class GeoInfo {
    private final GeoType geoType;
    private final LatLng latLng;

    public GeoInfo(LatLng latLng, GeoType geoType) {
        this.latLng = (LatLng) Objects.requireNonNull(latLng);
        this.geoType = (GeoType) Objects.requireNonNull(geoType);
    }

    public String getFormattedLatitude() {
        return format(this.latLng.getLatitude());
    }

    public String getFormattedLongitude() {
        return format(this.latLng.getLongitude());
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public GeoType getGeoType() {
        return this.geoType;
    }

    private String format(double d) {
        return String.format(Locale.US, "%.2f", Double.valueOf(d));
    }
}
