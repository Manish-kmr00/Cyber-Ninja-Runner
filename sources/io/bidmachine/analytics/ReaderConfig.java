package io.bidmachine.analytics;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lio/bidmachine/analytics/ReaderConfig;", "", "", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getUrl", "url", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "J", "getInterval", "()J", "interval", "", "d", "Z", "getUniqueOnly", "()Z", "uniqueOnly", "", "Lio/bidmachine/analytics/ReaderConfig$Rule;", "e", "Ljava/util/List;", "getRules", "()Ljava/util/List;", "rules", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZLjava/util/List;)V", "Rule", "bidmachine-android-sdk-analytics_b_2_2_4"}, k = 1, mv = {1, 7, 1})
public final class ReaderConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long interval;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean uniqueOnly;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final List rules;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lio/bidmachine/analytics/ReaderConfig$Rule;", "", "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getPath", "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "bidmachine-android-sdk-analytics_b_2_2_4"}, k = 1, mv = {1, 7, 1})
    public static final class Rule {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String tag;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final String path;

        public Rule(String str, String str2) {
            this.tag = str;
            this.path = str2;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    public ReaderConfig(String str, String str2, long j, boolean z, List<Rule> list) {
        this.name = str;
        this.url = str2;
        this.interval = j;
        this.uniqueOnly = z;
        this.rules = list;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Rule> getRules() {
        return this.rules;
    }

    public final boolean getUniqueOnly() {
        return this.uniqueOnly;
    }

    public final String getUrl() {
        return this.url;
    }
}
