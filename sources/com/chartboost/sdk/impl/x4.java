package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u0005\u0010\tR\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/x4;", "Lcom/chartboost/sdk/impl/w4;", "", "id", "Ljava/io/File;", "a", "(Ljava/lang/String;)Ljava/io/File;", "Ljava/io/File;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/io/File;", "precacheDirectory", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "precacheQueueDirectory", "precachingInternalDirectory", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x4 implements w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final File precacheDirectory;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final File precacheQueueDirectory;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final File precachingInternalDirectory;

    public x4(Context context, File precacheDirectory, File precacheQueueDirectory, File precachingInternalDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(precacheDirectory, "precacheDirectory");
        Intrinsics.checkNotNullParameter(precacheQueueDirectory, "precacheQueueDirectory");
        Intrinsics.checkNotNullParameter(precachingInternalDirectory, "precachingInternalDirectory");
        this.precacheDirectory = precacheDirectory;
        this.precacheQueueDirectory = precacheQueueDirectory;
        this.precachingInternalDirectory = precachingInternalDirectory;
    }

    @Override // com.chartboost.sdk.impl.w4
    public File a(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new File(getPrecacheDirectory(), id);
    }

    @Override // com.chartboost.sdk.impl.w4
    /* JADX INFO: renamed from: c, reason: from getter */
    public File getPrecacheDirectory() {
        return this.precacheDirectory;
    }

    @Override // com.chartboost.sdk.impl.w4
    /* JADX INFO: renamed from: b, reason: from getter */
    public File getPrecachingInternalDirectory() {
        return this.precachingInternalDirectory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ x4(Context context, File file, File file2, File file3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        file = (i & 2) != 0 ? v3.b(context) : file;
        this(context, file, (i & 4) != 0 ? v3.c(context) : file2, (i & 8) != 0 ? new File(file, "exoplayer-cache") : file3);
    }

    @Override // com.chartboost.sdk.impl.w4
    /* JADX INFO: renamed from: a, reason: from getter */
    public File getPrecacheQueueDirectory() {
        return this.precacheQueueDirectory;
    }
}
