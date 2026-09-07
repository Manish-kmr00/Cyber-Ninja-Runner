package io.bidmachine.analytics;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.explorestack.protobuf.Struct;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/bidmachine/analytics/AnalyticsConfig;", "", "", "a", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", JsonStorageKeyNames.SESSION_ID_KEY, "", "Lio/bidmachine/analytics/MonitorConfig;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "getMonitorConfigList", "()Ljava/util/List;", "monitorConfigList", "Lio/bidmachine/analytics/ReaderConfig;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getReaderConfigList", "readerConfigList", "d", "getBpk", "bpk", "Lcom/explorestack/protobuf/Struct;", "e", "Lcom/explorestack/protobuf/Struct;", "getExtras", "()Lcom/explorestack/protobuf/Struct;", "extras", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/explorestack/protobuf/Struct;)V", "bidmachine-android-sdk-analytics_b_2_2_4"}, k = 1, mv = {1, 7, 1})
public final class AnalyticsConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sessionId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List monitorConfigList;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List readerConfigList;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String bpk;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Struct extras;

    public AnalyticsConfig(String str, List<MonitorConfig> list, List<ReaderConfig> list2, String str2, Struct struct) {
        this.sessionId = str;
        this.monitorConfigList = list;
        this.readerConfigList = list2;
        this.bpk = str2;
        this.extras = struct;
    }

    public final String getBpk() {
        return this.bpk;
    }

    public final Struct getExtras() {
        return this.extras;
    }

    public final List<MonitorConfig> getMonitorConfigList() {
        return this.monitorConfigList;
    }

    public final List<ReaderConfig> getReaderConfigList() {
        return this.readerConfigList;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
