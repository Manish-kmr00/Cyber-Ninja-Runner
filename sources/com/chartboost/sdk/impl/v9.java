package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/chartboost/sdk/impl/v9;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "adId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "location", "", "I", "e", "()I", "videoCached", "d", "adTypeName", "Lcom/chartboost/sdk/Mediation;", "Lcom/chartboost/sdk/Mediation;", "()Lcom/chartboost/sdk/Mediation;", "mediation", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/chartboost/sdk/Mediation;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String adId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int videoCached;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String adTypeName;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Mediation mediation;

    public v9(String str, String location, int i, String adTypeName, Mediation mediation) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adTypeName, "adTypeName");
        this.adId = str;
        this.location = location;
        this.videoCached = i;
        this.adTypeName = adTypeName;
        this.mediation = mediation;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getVideoCached() {
        return this.videoCached;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAdTypeName() {
        return this.adTypeName;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Mediation getMediation() {
        return this.mediation;
    }
}
