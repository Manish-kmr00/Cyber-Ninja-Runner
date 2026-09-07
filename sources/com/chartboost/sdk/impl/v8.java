package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/chartboost/sdk/impl/v8;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "cellularConnectionType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "connectionTypeFromActiveNetwork", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "detailedConnectionType", "Lcom/chartboost/sdk/impl/m7;", "d", "Lcom/chartboost/sdk/impl/m7;", "()Lcom/chartboost/sdk/impl/m7;", "openRTBConnectionType", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/chartboost/sdk/impl/m7;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class v8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Integer cellularConnectionType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Integer connectionTypeFromActiveNetwork;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String detailedConnectionType;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final m7 openRTBConnectionType;

    public v8() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof v8)) {
            return false;
        }
        v8 v8Var = (v8) other;
        return Intrinsics.areEqual(this.cellularConnectionType, v8Var.cellularConnectionType) && Intrinsics.areEqual(this.connectionTypeFromActiveNetwork, v8Var.connectionTypeFromActiveNetwork) && Intrinsics.areEqual(this.detailedConnectionType, v8Var.detailedConnectionType) && this.openRTBConnectionType == v8Var.openRTBConnectionType;
    }

    public int hashCode() {
        Integer num = this.cellularConnectionType;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.connectionTypeFromActiveNetwork;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.detailedConnectionType;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.openRTBConnectionType.hashCode();
    }

    public String toString() {
        return "ReachabilityBodyFields(cellularConnectionType=" + this.cellularConnectionType + ", connectionTypeFromActiveNetwork=" + this.connectionTypeFromActiveNetwork + ", detailedConnectionType=" + this.detailedConnectionType + ", openRTBConnectionType=" + this.openRTBConnectionType + ')';
    }

    public v8(Integer num, Integer num2, String str, m7 openRTBConnectionType) {
        Intrinsics.checkNotNullParameter(openRTBConnectionType, "openRTBConnectionType");
        this.cellularConnectionType = num;
        this.connectionTypeFromActiveNetwork = num2;
        this.detailedConnectionType = str;
        this.openRTBConnectionType = openRTBConnectionType;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getCellularConnectionType() {
        return this.cellularConnectionType;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getConnectionTypeFromActiveNetwork() {
        return this.connectionTypeFromActiveNetwork;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDetailedConnectionType() {
        return this.detailedConnectionType;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final m7 getOpenRTBConnectionType() {
        return this.openRTBConnectionType;
    }

    public /* synthetic */ v8(Integer num, Integer num2, String str, m7 m7Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? m7.UNKNOWN : m7Var);
    }
}
