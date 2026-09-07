package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadCursor;
import com.google.android.exoplayer2.offline.DownloadManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/exoplayer2/offline/DownloadCursor;", "", "Lcom/chartboost/sdk/impl/e4;", "a", "(Lcom/google/android/exoplayer2/offline/DownloadCursor;)Ljava/util/List;", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "(Lcom/google/android/exoplayer2/offline/DownloadManager;)Ljava/util/List;", "", "id", "(Lcom/google/android/exoplayer2/offline/DownloadManager;Ljava/lang/String;)Lcom/chartboost/sdk/impl/e4;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class bb {
    public static final List<e4> a(DownloadCursor downloadCursor) {
        Intrinsics.checkNotNullParameter(downloadCursor, "<this>");
        ArrayList arrayList = new ArrayList();
        while (downloadCursor.moveToNext()) {
            Download download = downloadCursor.getDownload();
            Intrinsics.checkNotNullExpressionValue(download, "download");
            arrayList.add(f4.a(download));
        }
        return arrayList;
    }

    public static final e4 a(DownloadManager downloadManager, String id) throws IOException {
        Intrinsics.checkNotNullParameter(downloadManager, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        Download download = downloadManager.getDownloadIndex().getDownload(id);
        if (download != null) {
            return f4.a(download);
        }
        return null;
    }

    public static final List<e4> a(DownloadManager downloadManager) throws IOException {
        Intrinsics.checkNotNullParameter(downloadManager, "<this>");
        DownloadCursor downloads = downloadManager.getDownloadIndex().getDownloads(new int[0]);
        Intrinsics.checkNotNullExpressionValue(downloads, "downloadIndex.getDownloads()");
        return a(downloads);
    }
}
