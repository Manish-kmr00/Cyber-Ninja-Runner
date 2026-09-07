package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0013\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\t*\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/e5;", "", "Lcom/chartboost/sdk/impl/e4;", "download", "", "d", "(Lcom/chartboost/sdk/impl/e4;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "e", "Ljava/io/File;", "a", "(Lcom/chartboost/sdk/impl/e4;)Ljava/io/File;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/w4;", "Lcom/chartboost/sdk/impl/w4;", "fileCaching", "<init>", "(Lcom/chartboost/sdk/impl/w4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final w4 fileCaching;

    public e5(w4 fileCaching) {
        Intrinsics.checkNotNullParameter(fileCaching, "fileCaching");
        this.fileCaching = fileCaching;
    }

    public final void c(e4 download) throws IOException {
        Intrinsics.checkNotNullParameter(download, "download");
        if (k9.f1061a.d()) {
            b(download).createNewFile();
        }
    }

    public final void d(e4 download) {
        Intrinsics.checkNotNullParameter(download, "download");
        if (k9.f1061a.d()) {
            a(download).delete();
            b(download).delete();
        }
    }

    public final void e(e4 download) throws IOException {
        Intrinsics.checkNotNullParameter(download, "download");
        if (k9.f1061a.d()) {
            b(download).delete();
            a(download).createNewFile();
        }
    }

    public final File a(e4 e4Var) {
        return f4.a(e4Var, this.fileCaching.c());
    }

    public final File b(e4 e4Var) {
        return f4.a(e4Var, this.fileCaching.a());
    }
}
