package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/u8;", "", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()J", "", "a", "()V", "Ljava/io/RandomAccessFile;", "Ljava/io/RandomAccessFile;", "randomAccessFile", "Ljava/io/FileDescriptor;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/io/FileDescriptor;", "()Ljava/io/FileDescriptor;", "fd", "<init>", "(Ljava/io/RandomAccessFile;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RandomAccessFile randomAccessFile;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final FileDescriptor fd;

    public u8(RandomAccessFile randomAccessFile) throws IOException {
        Intrinsics.checkNotNullParameter(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
        FileDescriptor fd = randomAccessFile.getFD();
        Intrinsics.checkNotNullExpressionValue(fd, "randomAccessFile.fd");
        this.fd = fd;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final FileDescriptor getFd() {
        return this.fd;
    }

    public final long c() {
        return this.randomAccessFile.length();
    }

    public final void a() throws IOException {
        this.randomAccessFile.close();
    }
}
