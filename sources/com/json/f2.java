package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\f\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0005\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ironsource/f2;", "", "Lcom/ironsource/lm;", "Lcom/ironsource/sn;", "mapper", "a", "Lcom/ironsource/ct;", "Lcom/ironsource/ct;", "e", "()Lcom/ironsource/ct;", "recordType", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "advertiserBundleId", "d", "networkInstanceId", "Lcom/ironsource/ig;", "Lcom/ironsource/ig;", "()Lcom/ironsource/ig;", "adProvider", "adInstanceId", "<init>", "(Lcom/ironsource/ct;Ljava/lang/String;Ljava/lang/String;Lcom/ironsource/ig;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ct recordType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String advertiserBundleId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String networkInstanceId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ig adProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String adInstanceId;

    public f2(ct recordType, String advertiserBundleId, String networkInstanceId, ig adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(advertiserBundleId, "advertiserBundleId");
        Intrinsics.checkNotNullParameter(networkInstanceId, "networkInstanceId");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.recordType = recordType;
        this.advertiserBundleId = advertiserBundleId;
        this.networkInstanceId = networkInstanceId;
        this.adProvider = adProvider;
        this.adInstanceId = adInstanceId;
    }

    public final sn a(lm<f2, sn> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdInstanceId() {
        return this.adInstanceId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ig getAdProvider() {
        return this.adProvider;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getAdvertiserBundleId() {
        return this.advertiserBundleId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getNetworkInstanceId() {
        return this.networkInstanceId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ct getRecordType() {
        return this.recordType;
    }
}
