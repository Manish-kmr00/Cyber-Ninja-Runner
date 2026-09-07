package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\r\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/chartboost/sdk/impl/r0;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/qa;", "a", "Lcom/chartboost/sdk/impl/qa;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/qa;", "advertisingIDState", "Ljava/lang/String;", "advertisingID", "<init>", "(Lcom/chartboost/sdk/impl/qa;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final qa advertisingIDState;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String advertisingID;

    public r0(qa advertisingIDState, String str) {
        Intrinsics.checkNotNullParameter(advertisingIDState, "advertisingIDState");
        this.advertisingIDState = advertisingIDState;
        this.advertisingID = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) other;
        return this.advertisingIDState == r0Var.advertisingIDState && Intrinsics.areEqual(this.advertisingID, r0Var.advertisingID);
    }

    public int hashCode() {
        int iHashCode = this.advertisingIDState.hashCode() * 31;
        String str = this.advertisingID;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AdvertisingIDHolder(advertisingIDState=" + this.advertisingIDState + ", advertisingID=" + this.advertisingID + ')';
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final qa getAdvertisingIDState() {
        return this.advertisingIDState;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdvertisingID() {
        return this.advertisingID;
    }
}
