package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/chartboost/sdk/impl/x2;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDspCode", "(Ljava/lang/String;)V", "dspCode", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "[I", "()[I", "setDspCreatives", "([I)V", "dspCreatives", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x2 f1185a = new x2();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static String dspCode = "";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static int[] dspCreatives;

    public final String a() {
        return dspCode;
    }

    public final int[] b() {
        return dspCreatives;
    }
}
