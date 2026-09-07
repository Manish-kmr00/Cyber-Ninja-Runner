package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\f\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/w4;", "", "", "id", "Ljava/io/File;", "a", "(Ljava/lang/String;)Ljava/io/File;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/io/File;", "precacheDirectory", "precacheQueueDirectory", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "precachingInternalDirectory", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface w4 {
    File a();

    File a(String id);

    File b();

    File c();
}
