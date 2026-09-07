package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\f\b\u0002\u0010*\u001a\u00060\u0014j\u0002`(\u0012\b\u0010/\u001a\u0004\u0018\u00010+¢\u0006\u0004\b5\u00106J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\bJ\u0015\u0010\u0003\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\r\u0010\u0011\"\u0004\b\u0015\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\r\u0010\u001cR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u0015\u0010\u001cR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0011\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0011\"\u0004\b#\u0010\u0018R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b&\u0010\u0011\"\u0004\b\u0013\u0010\u0018R&\u0010*\u001a\u00060\u0014j\u0002`(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b)\u0010\u0016\"\u0004\b\u0003\u0010\u001cR\u0019\u0010/\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u00102\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\u001aR\u0014\u00103\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0014\u00104\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0011¨\u00067"}, d2 = {"Lcom/chartboost/sdk/impl/kb;", "", "", "a", "()V", "Ljava/io/File;", "file", "", "(Ljava/io/File;)Z", "", "lastModified", "(J)Z", "videosCachedSize", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "g", "()Z", "i", "()J", "h", InneractiveMediationDefs.GENDER_FEMALE, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()I", "J", "(J)V", "maxBytes", "I", "getMaxUnitsPerTimeWindow", "(I)V", "maxUnitsPerTimeWindow", "getMaxUnitsPerTimeWindowCellular", "maxUnitsPerTimeWindowCellular", "d", "getTimeWindow", "timeWindow", "e", "getTimeWindowCellular", "timeWindowCellular", "getTtl", "ttl", "Lcom/chartboost/sdk/internal/Model/Percentage;", "getBufferSize", "bufferSize", "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/h2;", "getReachability", "()Lcom/chartboost/sdk/impl/h2;", "reachability", "timeWindowStartTimeStamp", "j", "timeWindowCachedVideosCount", "timeFromLastFileCache", "remainingWindowTime", "<init>", "(JIIJJJILcom/chartboost/sdk/impl/h2;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long maxBytes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int maxUnitsPerTimeWindow;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int maxUnitsPerTimeWindowCellular;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public long timeWindow;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public long timeWindowCellular;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public long ttl;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int bufferSize;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public volatile long timeWindowStartTimeStamp;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public volatile int timeWindowCachedVideosCount;

    public kb(long j, int i, int i2, long j2, long j3, long j4, int i3, h2 h2Var) {
        this.maxBytes = j;
        this.maxUnitsPerTimeWindow = i;
        this.maxUnitsPerTimeWindowCellular = i2;
        this.timeWindow = j2;
        this.timeWindowCellular = j3;
        this.ttl = j4;
        this.bufferSize = i3;
        this.reachability = h2Var;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getMaxBytes() {
        return this.maxBytes;
    }

    public final void e(long j) {
        this.timeWindowCellular = j;
    }

    public final long e() {
        return x9.a() - this.timeWindowStartTimeStamp;
    }

    public final long d() {
        return f() - e();
    }

    public final void a() {
        b7.a("addDownloadToTimeWindow() - timeWindowStartTimeStamp " + this.timeWindowStartTimeStamp + ", timeWindowCachedVideosCount " + this.timeWindowCachedVideosCount, (Throwable) null, 2, (Object) null);
        if (this.timeWindowStartTimeStamp == 0) {
            this.timeWindowStartTimeStamp = x9.a();
        }
        this.timeWindowCachedVideosCount++;
    }

    public final void d(long j) {
        this.timeWindow = j;
    }

    public final boolean a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return a(file.lastModified());
    }

    public final boolean g() {
        h();
        boolean z = this.timeWindowCachedVideosCount >= c();
        if (z) {
            k9.a("Video loading limit reached, will resume in timeToResetWindow: " + d());
        }
        b7.a("isMaxCountForTimeWindowReached() - " + z, (Throwable) null, 2, (Object) null);
        return z;
    }

    public final long i() {
        return f() - (x9.a() - this.timeWindowStartTimeStamp);
    }

    public final boolean b(long videosCachedSize) {
        return videosCachedSize >= this.maxBytes;
    }

    public final void h() {
        b7.a("resetWindowWhenTimeReached()", (Throwable) null, 2, (Object) null);
        if (e() > f()) {
            b7.a("resetWindowWhenTimeReached() - timer and count reset", (Throwable) null, 2, (Object) null);
            k9.a("Video loading limit reset");
            this.timeWindowCachedVideosCount = 0;
            this.timeWindowStartTimeStamp = 0L;
        }
    }

    public final void b(int i) {
        this.maxUnitsPerTimeWindow = i;
    }

    public final long f() {
        h2 h2Var = this.reachability;
        return ((h2Var == null || !h2Var.d()) ? this.timeWindow : this.timeWindowCellular) * ((long) 1000);
    }

    public final int c() {
        h2 h2Var = this.reachability;
        if (h2Var != null && h2Var.d()) {
            return this.maxUnitsPerTimeWindowCellular;
        }
        return this.maxUnitsPerTimeWindow;
    }

    public final void f(long j) {
        this.ttl = j;
    }

    public final void c(long j) {
        this.maxBytes = j;
    }

    public final void a(int i) {
        this.bufferSize = i;
    }

    public final void c(int i) {
        this.maxUnitsPerTimeWindowCellular = i;
    }

    public final boolean a(long lastModified) {
        return x9.a() - lastModified > this.ttl * ((long) 1000);
    }
}
