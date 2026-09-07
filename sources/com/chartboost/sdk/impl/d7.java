package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/chartboost/sdk/impl/d7;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "()I", "intValue", "<init>", "(Ljava/lang/String;II)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public enum d7 {
    UNKNOWN(0),
    HTML(1),
    VIDEO(2),
    AUDIO(3),
    NATIVE(4);


    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int intValue;

    d7(int i) {
        this.intValue = i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getIntValue() {
        return this.intValue;
    }
}
