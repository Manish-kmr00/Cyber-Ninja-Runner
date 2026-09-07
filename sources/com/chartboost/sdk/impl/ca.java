package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/ca;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "a", "J", "()J", "currentTimeMillis", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getNanoTime", "nanoTime", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getUptimeMillis", "uptimeMillis", "<init>", "(JJJ)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long currentTimeMillis;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final long nanoTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final long uptimeMillis;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ca)) {
            return false;
        }
        ca caVar = (ca) other;
        return this.currentTimeMillis == caVar.currentTimeMillis && this.nanoTime == caVar.nanoTime && this.uptimeMillis == caVar.uptimeMillis;
    }

    public int hashCode() {
        return (((Long.hashCode(this.currentTimeMillis) * 31) + Long.hashCode(this.nanoTime)) * 31) + Long.hashCode(this.uptimeMillis);
    }

    public String toString() {
        return "TimeSourceBodyFields(currentTimeMillis=" + this.currentTimeMillis + ", nanoTime=" + this.nanoTime + ", uptimeMillis=" + this.uptimeMillis + ')';
    }

    public ca(long j, long j2, long j3) {
        this.currentTimeMillis = j;
        this.nanoTime = j2;
        this.uptimeMillis = j3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getCurrentTimeMillis() {
        return this.currentTimeMillis;
    }
}
