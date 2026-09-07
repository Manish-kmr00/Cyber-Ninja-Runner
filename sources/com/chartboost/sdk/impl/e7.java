package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DtbConstants;
import com.json.bu;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/impl/e7;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, DtbConstants.MEDIATION_NAME, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "libraryVersion", bu.b, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String mediationName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String libraryVersion;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String adapterVersion;

    public e7(String mediationName, String libraryVersion, String adapterVersion) {
        Intrinsics.checkNotNullParameter(mediationName, "mediationName");
        Intrinsics.checkNotNullParameter(libraryVersion, "libraryVersion");
        Intrinsics.checkNotNullParameter(adapterVersion, "adapterVersion");
        this.mediationName = mediationName;
        this.libraryVersion = libraryVersion;
        this.adapterVersion = adapterVersion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e7)) {
            return false;
        }
        e7 e7Var = (e7) other;
        return Intrinsics.areEqual(this.mediationName, e7Var.mediationName) && Intrinsics.areEqual(this.libraryVersion, e7Var.libraryVersion) && Intrinsics.areEqual(this.adapterVersion, e7Var.adapterVersion);
    }

    public int hashCode() {
        return (((this.mediationName.hashCode() * 31) + this.libraryVersion.hashCode()) * 31) + this.adapterVersion.hashCode();
    }

    public String toString() {
        return "MediationBodyFields(mediationName=" + this.mediationName + ", libraryVersion=" + this.libraryVersion + ", adapterVersion=" + this.adapterVersion + ')';
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getMediationName() {
        return this.mediationName;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLibraryVersion() {
        return this.libraryVersion;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdapterVersion() {
        return this.adapterVersion;
    }
}
