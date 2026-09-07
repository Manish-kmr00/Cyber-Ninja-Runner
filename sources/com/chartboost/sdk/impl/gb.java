package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.http.ContentDisposition;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\f\b\u0002\u0010\u001e\u001a\u00060\u001aj\u0002`\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u001a¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0010\u0010\u0017R\u001b\u0010\u001e\u001a\u00060\u001aj\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\f\u0010\u001dR\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001f\u0010\u0004R\"\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\"\u0004\b\f\u0010!¨\u0006%"}, d2 = {"Lcom/chartboost/sdk/impl/gb;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "g", "url", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", ContentDisposition.Parameters.FileName, "Ljava/io/File;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/io/File;", "e", "()Ljava/io/File;", "localFile", "directory", "", "Lcom/chartboost/sdk/internal/utils/TimeStamp;", "J", "()J", "creationDate", InneractiveMediationDefs.GENDER_FEMALE, "queueFilePath", "(J)V", "expectedFileSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;JLjava/lang/String;J)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String filename;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final File localFile;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final File directory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long creationDate;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String queueFilePath;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public long expectedFileSize;

    public gb(String url, String filename, File file, File file2, long j, String queueFilePath, long j2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(queueFilePath, "queueFilePath");
        this.url = url;
        this.filename = filename;
        this.localFile = file;
        this.directory = file2;
        this.creationDate = j;
        this.queueFilePath = queueFilePath;
        this.expectedFileSize = j2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof gb)) {
            return false;
        }
        gb gbVar = (gb) other;
        return Intrinsics.areEqual(this.url, gbVar.url) && Intrinsics.areEqual(this.filename, gbVar.filename) && Intrinsics.areEqual(this.localFile, gbVar.localFile) && Intrinsics.areEqual(this.directory, gbVar.directory) && this.creationDate == gbVar.creationDate && Intrinsics.areEqual(this.queueFilePath, gbVar.queueFilePath) && this.expectedFileSize == gbVar.expectedFileSize;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.filename.hashCode()) * 31;
        File file = this.localFile;
        int iHashCode2 = (iHashCode + (file == null ? 0 : file.hashCode())) * 31;
        File file2 = this.directory;
        return ((((((iHashCode2 + (file2 != null ? file2.hashCode() : 0)) * 31) + Long.hashCode(this.creationDate)) * 31) + this.queueFilePath.hashCode()) * 31) + Long.hashCode(this.expectedFileSize);
    }

    public String toString() {
        return "VideoAsset(url=" + this.url + ", filename=" + this.filename + ", localFile=" + this.localFile + ", directory=" + this.directory + ", creationDate=" + this.creationDate + ", queueFilePath=" + this.queueFilePath + ", expectedFileSize=" + this.expectedFileSize + ')';
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final File getLocalFile() {
        return this.localFile;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final File getDirectory() {
        return this.directory;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getCreationDate() {
        return this.creationDate;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getQueueFilePath() {
        return this.queueFilePath;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getExpectedFileSize() {
        return this.expectedFileSize;
    }

    public /* synthetic */ gb(String str, String str2, File file, File file2, long j, String str3, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, file, file2, (i & 16) != 0 ? x9.a() : j, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? 0L : j2);
    }

    public final void a(long j) {
        this.expectedFileSize = j;
    }
}
