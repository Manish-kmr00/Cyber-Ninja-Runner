package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\u001c\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/chartboost/sdk/impl/o;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/u;", "a", "Lcom/chartboost/sdk/impl/u;", "()Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "height", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "e", "width", "d", "Ljava/lang/String;", "location", "I", "impDepth", "<init>", "(Lcom/chartboost/sdk/impl/u;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;I)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u adType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Integer height;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Integer width;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int impDepth;

    public o(u adType, Integer num, Integer num2, String str, int i) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        this.adType = adType;
        this.height = num;
        this.width = num2;
        this.location = str;
        this.impDepth = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        return Intrinsics.areEqual(this.adType, oVar.adType) && Intrinsics.areEqual(this.height, oVar.height) && Intrinsics.areEqual(this.width, oVar.width) && Intrinsics.areEqual(this.location, oVar.location) && this.impDepth == oVar.impDepth;
    }

    public int hashCode() {
        int iHashCode = this.adType.hashCode() * 31;
        Integer num = this.height;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.width;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.location;
        return ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.impDepth);
    }

    public String toString() {
        return "AdParameters(adType=" + this.adType + ", height=" + this.height + ", width=" + this.width + ", location=" + this.location + ", impDepth=" + this.impDepth + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final u getAdType() {
        return this.adType;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getImpDepth() {
        return this.impDepth;
    }
}
