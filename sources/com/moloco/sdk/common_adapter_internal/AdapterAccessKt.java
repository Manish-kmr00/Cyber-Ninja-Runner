package com.moloco.sdk.common_adapter_internal;

import com.moloco.sdk.Init;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.bidrequest.Geo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/moloco/sdk/Init$SDKInitResponse;", "", "adUnitId", "Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "a", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "DefaultGeo", "moloco-sdk_release"}, k = 2, mv = {1, 8, 0})
public final class AdapterAccessKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Geo f6056a = new Geo(null, null, null, null, null, null);

    /* JADX WARN: Code duplicated, block: B:18:0x006e  */
    /* JADX WARN: Code duplicated, block: B:31:0x009f  */
    public static final AdapterSessionData a(Init.SDKInitResponse sDKInitResponse, String str) {
        Geo geo;
        String name;
        Float fValueOf;
        Object next;
        Object next2;
        Init.SDKInitResponse.Geo geo2 = sDKInitResponse.getGeo();
        if (geo2 != null) {
            geo = new Geo(geo2.getCity(), geo2.getCountryIso3Code(), geo2.getCountryIso2Code(), geo2.getZipCode(), Float.valueOf(geo2.getLatitude()), Float.valueOf(geo2.getLongitude()));
        } else {
            geo = f6056a;
        }
        String bidRequestEndpoint = Moloco.getBidRequestEndpoint();
        String appId = sDKInitResponse.getAppId();
        String publisherId = sDKInitResponse.getPublisherId();
        String platformId = sDKInitResponse.getPlatformId();
        List<Init.SDKInitResponse.AdUnit> adUnitsList = sDKInitResponse.getAdUnitsList();
        if (adUnitsList != null) {
            Iterator<T> it = adUnitsList.iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
            } while (!Intrinsics.areEqual(((Init.SDKInitResponse.AdUnit) next2).getId(), str));
            Init.SDKInitResponse.AdUnit adUnit = (Init.SDKInitResponse.AdUnit) next2;
            if (adUnit != null) {
                name = adUnit.getName();
            } else {
                name = null;
            }
        } else {
            name = null;
        }
        List<Init.SDKInitResponse.AdUnit> adUnitsList2 = sDKInitResponse.getAdUnitsList();
        if (adUnitsList2 != null) {
            Iterator<T> it2 = adUnitsList2.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual(((Init.SDKInitResponse.AdUnit) next).getId(), str));
            Init.SDKInitResponse.AdUnit adUnit2 = (Init.SDKInitResponse.AdUnit) next;
            if (adUnit2 != null) {
                fValueOf = Float.valueOf(adUnit2.getBidFloor());
            } else {
                fValueOf = null;
            }
        } else {
            fValueOf = null;
        }
        return new AdapterSessionData(geo, bidRequestEndpoint, appId, publisherId, platformId, name, fValueOf);
    }
}
