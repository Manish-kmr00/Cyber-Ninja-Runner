package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0019R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/ironsource/g3;", "", "Lcom/ironsource/ct;", "a", "Lcom/ironsource/ct;", "e", "()Lcom/ironsource/ct;", "recordType", "Lcom/ironsource/ig;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/ig;", "()Lcom/ironsource/ig;", "adProvider", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "()Ljava/lang/String;", "adInstanceId", "", "d", "J", InneractiveMediationDefs.GENDER_FEMALE, "()J", "timestamp", "", "()Ljava/util/Map;", "asFullHistoryMap", "asCurrentlyLoadedAdsMap", "<init>", "(Lcom/ironsource/ct;Lcom/ironsource/ig;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ct recordType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ig adProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String adInstanceId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final long timestamp;

    public g3(ct recordType, ig adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.recordType = recordType;
        this.adProvider = adProvider;
        this.adInstanceId = adInstanceId;
        this.timestamp = Calendar.getInstance().getTimeInMillis() / ((long) 1000);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdInstanceId() {
        return this.adInstanceId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ig getAdProvider() {
        return this.adProvider;
    }

    public final Map<String, Object> c() {
        return MapsKt.mapOf(TuplesKt.to(yk.SESSION_HISTORY_KEY_AD_PROVIDER, Integer.valueOf(this.adProvider.getId())), TuplesKt.to("ts", String.valueOf(this.timestamp)));
    }

    public final Map<String, Object> d() {
        return MapsKt.mapOf(TuplesKt.to(yk.SESSION_HISTORY_KEY_AD_ID, this.adInstanceId), TuplesKt.to(yk.SESSION_HISTORY_KEY_AD_PROVIDER, Integer.valueOf(this.adProvider.getId())), TuplesKt.to("ts", String.valueOf(this.timestamp)), TuplesKt.to("rt", Integer.valueOf(this.recordType.ordinal())));
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ct getRecordType() {
        return this.recordType;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }
}
