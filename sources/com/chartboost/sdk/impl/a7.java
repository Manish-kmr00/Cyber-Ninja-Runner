package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u0010$\u001a\u00020\u001c¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0013\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 ¨\u0006'"}, d2 = {"Lcom/chartboost/sdk/impl/a7;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/y0;", "a", "Lcom/chartboost/sdk/impl/y0;", "getAppRequest", "()Lcom/chartboost/sdk/impl/y0;", "appRequest", "Lcom/chartboost/sdk/impl/v;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/v;", "()Lcom/chartboost/sdk/impl/v;", "adUnit", "Lcom/chartboost/sdk/internal/Model/CBError;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/internal/Model/CBError;", "()Lcom/chartboost/sdk/internal/Model/CBError;", "error", "", "d", "J", "getRequestResponseCodeNs", "()J", "requestResponseCodeNs", "e", "getReadDataNs", "readDataNs", "<init>", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/internal/Model/CBError;JJ)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y0 appRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final v adUnit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CBError error;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long requestResponseCodeNs;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long readDataNs;

    public a7(y0 appRequest, v vVar, CBError cBError, long j, long j2) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        this.appRequest = appRequest;
        this.adUnit = vVar;
        this.error = cBError;
        this.requestResponseCodeNs = j;
        this.readDataNs = j2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a7)) {
            return false;
        }
        a7 a7Var = (a7) other;
        return Intrinsics.areEqual(this.appRequest, a7Var.appRequest) && Intrinsics.areEqual(this.adUnit, a7Var.adUnit) && Intrinsics.areEqual(this.error, a7Var.error) && this.requestResponseCodeNs == a7Var.requestResponseCodeNs && this.readDataNs == a7Var.readDataNs;
    }

    public int hashCode() {
        int iHashCode = this.appRequest.hashCode() * 31;
        v vVar = this.adUnit;
        int iHashCode2 = (iHashCode + (vVar == null ? 0 : vVar.hashCode())) * 31;
        CBError cBError = this.error;
        return ((((iHashCode2 + (cBError != null ? cBError.hashCode() : 0)) * 31) + Long.hashCode(this.requestResponseCodeNs)) * 31) + Long.hashCode(this.readDataNs);
    }

    public String toString() {
        return "LoadResult(appRequest=" + this.appRequest + ", adUnit=" + this.adUnit + ", error=" + this.error + ", requestResponseCodeNs=" + this.requestResponseCodeNs + ", readDataNs=" + this.readDataNs + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final v getAdUnit() {
        return this.adUnit;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final CBError getError() {
        return this.error;
    }

    public /* synthetic */ a7(y0 y0Var, v vVar, CBError cBError, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(y0Var, (i & 2) != 0 ? null : vVar, (i & 4) == 0 ? cBError : null, (i & 8) != 0 ? 0L : j, (i & 16) == 0 ? j2 : 0L);
    }
}
