package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/google/android/exoplayer2/ExoPlayer;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/google/android/exoplayer2/ExoPlayer;)I", "a", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class a5 {
    public static final int a(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "<this>");
        Format videoFormat = exoPlayer.getVideoFormat();
        if (videoFormat != null) {
            return videoFormat.height;
        }
        return 1;
    }

    public static final int b(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "<this>");
        Format videoFormat = exoPlayer.getVideoFormat();
        if (videoFormat != null) {
            return videoFormat.width;
        }
        return 1;
    }
}
