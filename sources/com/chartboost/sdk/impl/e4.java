package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.offline.Download;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0014\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/chartboost/sdk/impl/e4;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/android/exoplayer2/offline/Download;", "a", "Lcom/google/android/exoplayer2/offline/Download;", "()Lcom/google/android/exoplayer2/offline/Download;", "download", InneractiveMediationDefs.GENDER_FEMALE, "uri", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "id", "d", "state", "", "e", "()J", "updateTime", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()F", "percentDownloaded", "<init>", "(Lcom/google/android/exoplayer2/offline/Download;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Download download;

    public e4(Download download) {
        Intrinsics.checkNotNullParameter(download, "download");
        this.download = download;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof e4) && Intrinsics.areEqual(this.download, ((e4) other).download);
    }

    public int hashCode() {
        return this.download.hashCode();
    }

    public String toString() {
        return "DownloadWrapper(download=" + this.download + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Download getDownload() {
        return this.download;
    }

    public final String f() {
        String string = this.download.request.uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "download.request.uri.toString()");
        return string;
    }

    public final String b() {
        String str = this.download.request.id;
        Intrinsics.checkNotNullExpressionValue(str, "download.request.id");
        return str;
    }

    public final int d() {
        return this.download.state;
    }

    public final long e() {
        return this.download.updateTimeMs;
    }

    public final float c() {
        return this.download.getPercentDownloaded();
    }
}
