package com.moloco.sdk.common_adapter_internal;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.moloco.sdk.publisher.bidrequest.Geo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJb\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010#R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010#R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\f¨\u00061"}, d2 = {"Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "component1", "", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Float;", "geo", "bidRequestEndpoint", RemoteConfigConstants.RequestFieldKey.APP_ID, "publisherId", "platformId", "adUnitName", "bidFloor", "copy", "(Lcom/moloco/sdk/publisher/bidrequest/Geo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "toString", "", "hashCode", "other", "", "equals", "a", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "getGeo", "()Lcom/moloco/sdk/publisher/bidrequest/Geo;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getBidRequestEndpoint", "()Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getAppId", "d", "getPublisherId", "e", "getPlatformId", InneractiveMediationDefs.GENDER_FEMALE, "getAdUnitName", "g", "Ljava/lang/Float;", "getBidFloor", "<init>", "(Lcom/moloco/sdk/publisher/bidrequest/Geo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class AdapterSessionData {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Geo geo;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String bidRequestEndpoint;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String appId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String publisherId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String platformId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String adUnitName;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Float bidFloor;

    public AdapterSessionData(Geo geo, String str, String str2, String str3, String str4, String str5, Float f) {
        Intrinsics.checkNotNullParameter(geo, "geo");
        this.geo = geo;
        this.bidRequestEndpoint = str;
        this.appId = str2;
        this.publisherId = str3;
        this.platformId = str4;
        this.adUnitName = str5;
        this.bidFloor = f;
    }

    public static /* synthetic */ AdapterSessionData copy$default(AdapterSessionData adapterSessionData, Geo geo, String str, String str2, String str3, String str4, String str5, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            geo = adapterSessionData.geo;
        }
        if ((i & 2) != 0) {
            str = adapterSessionData.bidRequestEndpoint;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = adapterSessionData.appId;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = adapterSessionData.publisherId;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = adapterSessionData.platformId;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = adapterSessionData.adUnitName;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            f = adapterSessionData.bidFloor;
        }
        return adapterSessionData.copy(geo, str6, str7, str8, str9, str10, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Geo getGeo() {
        return this.geo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBidRequestEndpoint() {
        return this.bidRequestEndpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPublisherId() {
        return this.publisherId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlatformId() {
        return this.platformId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAdUnitName() {
        return this.adUnitName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Float getBidFloor() {
        return this.bidFloor;
    }

    public final AdapterSessionData copy(Geo geo, String bidRequestEndpoint, String appId, String publisherId, String platformId, String adUnitName, Float bidFloor) {
        Intrinsics.checkNotNullParameter(geo, "geo");
        return new AdapterSessionData(geo, bidRequestEndpoint, appId, publisherId, platformId, adUnitName, bidFloor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdapterSessionData)) {
            return false;
        }
        AdapterSessionData adapterSessionData = (AdapterSessionData) other;
        return Intrinsics.areEqual(this.geo, adapterSessionData.geo) && Intrinsics.areEqual(this.bidRequestEndpoint, adapterSessionData.bidRequestEndpoint) && Intrinsics.areEqual(this.appId, adapterSessionData.appId) && Intrinsics.areEqual(this.publisherId, adapterSessionData.publisherId) && Intrinsics.areEqual(this.platformId, adapterSessionData.platformId) && Intrinsics.areEqual(this.adUnitName, adapterSessionData.adUnitName) && Intrinsics.areEqual((Object) this.bidFloor, (Object) adapterSessionData.bidFloor);
    }

    public final String getAdUnitName() {
        return this.adUnitName;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Float getBidFloor() {
        return this.bidFloor;
    }

    public final String getBidRequestEndpoint() {
        return this.bidRequestEndpoint;
    }

    public final Geo getGeo() {
        return this.geo;
    }

    public final String getPlatformId() {
        return this.platformId;
    }

    public final String getPublisherId() {
        return this.publisherId;
    }

    public int hashCode() {
        int iHashCode = this.geo.hashCode() * 31;
        String str = this.bidRequestEndpoint;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.publisherId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.platformId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.adUnitName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f = this.bidFloor;
        return iHashCode6 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        return "AdapterSessionData(geo=" + this.geo + ", bidRequestEndpoint=" + this.bidRequestEndpoint + ", appId=" + this.appId + ", publisherId=" + this.publisherId + ", platformId=" + this.platformId + ", adUnitName=" + this.adUnitName + ", bidFloor=" + this.bidFloor + ')';
    }
}
