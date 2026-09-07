package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.offline.Download;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u001d\u0010\u0002\u001a\u00020\u0007*\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/exoplayer2/offline/Download;", "Lcom/chartboost/sdk/impl/e4;", "a", "(Lcom/google/android/exoplayer2/offline/Download;)Lcom/chartboost/sdk/impl/e4;", "", "", "(I)Ljava/lang/String;", "Ljava/io/File;", "parentDirectory", "(Lcom/chartboost/sdk/impl/e4;Ljava/io/File;)Ljava/io/File;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class f4 {
    public static final File a(e4 e4Var, File file) {
        Intrinsics.checkNotNullParameter(e4Var, "<this>");
        return new File(file, e4Var.b());
    }

    public static final e4 a(Download download) {
        Intrinsics.checkNotNullParameter(download, "<this>");
        return new e4(download);
    }

    public static final String a(int i) {
        if (i == 0) {
            return "STATE_QUEUED";
        }
        if (i == 1) {
            return "STATE_STOPPED";
        }
        if (i == 2) {
            return "STATE_DOWNLOADING";
        }
        if (i == 3) {
            return "STATE_COMPLETED";
        }
        if (i == 4) {
            return "STATE_FAILED";
        }
        if (i == 5) {
            return "STATE_REMOVING";
        }
        if (i != 7) {
            return "UNKNOWN STATE " + i;
        }
        return "STATE_RESTARTING";
    }
}
