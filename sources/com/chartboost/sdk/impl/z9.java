package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/chartboost/sdk/impl/z9;", "", "Ljava/io/File;", "directory", "", ContentDisposition.Parameters.FileName, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/io/File;Ljava/lang/String;)Z", "a", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "videoFile", "Ljava/io/RandomAccessFile;", "(Ljava/io/File;)Ljava/io/RandomAccessFile;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class z9 {
    public final boolean b(File directory, String filename) {
        if (directory != null && filename != null) {
            try {
                File fileA = a(directory, filename);
                if (fileA != null) {
                    return fileA.exists();
                }
                return false;
            } catch (Exception e) {
                b7.a(e.toString(), (Throwable) null, 2, (Object) null);
            }
        }
        return false;
    }

    public final RandomAccessFile a(File videoFile) {
        if (videoFile != null) {
            return new RandomAccessFile(videoFile, "rwd");
        }
        return null;
    }

    public final File a(File directory, String filename) {
        if (directory == null || filename == null) {
            return null;
        }
        return new File(directory, filename + ".tmp");
    }
}
