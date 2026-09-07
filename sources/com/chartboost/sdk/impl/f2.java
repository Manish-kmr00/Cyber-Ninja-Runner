package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/f2;", "", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "statusCode", "", "[B", "()[B", "data", "<init>", "(I[B)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int statusCode;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final byte[] data;

    public f2(int i, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.statusCode = i;
        this.data = data;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) other;
        return this.statusCode == f2Var.statusCode && Intrinsics.areEqual(this.data, f2Var.data);
    }

    public int hashCode() {
        return (Integer.hashCode(this.statusCode) * 31) + Arrays.hashCode(this.data);
    }

    public String toString() {
        return "CBNetworkServerResponse(statusCode=" + this.statusCode + ", data=" + Arrays.toString(this.data) + ')';
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final boolean c() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }
}
