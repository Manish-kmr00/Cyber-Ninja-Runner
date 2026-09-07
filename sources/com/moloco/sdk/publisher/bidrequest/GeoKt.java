package com.moloco.sdk.publisher.bidrequest;

import com.moloco.sdk.Init;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toGeo", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "Lcom/moloco/sdk/Init$SDKInitResponse$Geo;", "moloco-sdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GeoKt {
    public static final Geo toGeo(Init.SDKInitResponse.Geo geo) {
        Intrinsics.checkNotNullParameter(geo, "<this>");
        return new Geo(geo.getCity(), geo.getCountryIso3Code(), geo.getCountryIso2Code(), geo.getZipCode(), Float.valueOf(geo.getLatitude()), Float.valueOf(geo.getLongitude()));
    }
}
