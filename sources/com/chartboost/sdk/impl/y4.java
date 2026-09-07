package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\f"}, d2 = {"Lcom/chartboost/sdk/impl/y4;", "", "Lcom/chartboost/sdk/impl/gb;", "asset", "Lcom/google/android/exoplayer2/MediaItem;", "a", "(Lcom/chartboost/sdk/impl/gb;)Lcom/google/android/exoplayer2/MediaItem;", "Lcom/chartboost/sdk/impl/s4;", "Lcom/chartboost/sdk/impl/s4;", "downloadManager", "<init>", "(Lcom/chartboost/sdk/impl/s4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s4 downloadManager;

    public y4(s4 downloadManager) {
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        this.downloadManager = downloadManager;
    }

    public final MediaItem a(gb asset) {
        Download download;
        DownloadRequest downloadRequest;
        Intrinsics.checkNotNullParameter(asset, "asset");
        e4 e4VarB = this.downloadManager.b(asset.getFilename());
        if (e4VarB == null || (download = e4VarB.getDownload()) == null || (downloadRequest = download.request) == null) {
            return null;
        }
        return downloadRequest.toMediaItem();
    }
}
