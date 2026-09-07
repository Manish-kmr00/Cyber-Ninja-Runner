package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0004\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/chartboost/sdk/impl/d2;", "", "", "", "a", "Ljava/util/Map;", "headers", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "[B", "body", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "()Ljava/lang/String;", "contentType", "<init>", "(Ljava/util/Map;[BLjava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> headers;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final byte[] body;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String contentType;

    public d2(Map<String, String> map, byte[] bArr, String str) {
        this.headers = map;
        this.body = bArr;
        this.contentType = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }
}
