package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0006\u0010\u000fJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0006\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0006\u0010\u0015J\u001b\u0010\u0003\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0003\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000b\u0010\u001dJ\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0012H&¢\u0006\u0004\b\u0006\u0010\u001f¨\u0006 "}, d2 = {"Lcom/chartboost/sdk/impl/s4;", "", "Lcom/google/android/exoplayer2/offline/DownloadManager;", "d", "()Lcom/google/android/exoplayer2/offline/DownloadManager;", "", "a", "()V", "Lcom/chartboost/sdk/impl/tb$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/chartboost/sdk/impl/tb$a;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "id", "", "(Ljava/lang/String;)Z", "Lcom/chartboost/sdk/impl/gb;", "asset", "Lcom/chartboost/sdk/impl/d4;", "stopReason", "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/d4;)V", "(Lcom/chartboost/sdk/impl/gb;)V", "", "Lcom/chartboost/sdk/internal/video/repository/exoplayer/Percentage;", "(Ljava/lang/String;)F", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "Lcom/chartboost/sdk/impl/e4;", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/e4;", "currentDownloadStopReason", "(Lcom/chartboost/sdk/impl/d4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface s4 {
    void a();

    void a(d4 currentDownloadStopReason);

    void a(gb asset);

    void a(gb asset, d4 stopReason);

    void a(tb.a listener);

    boolean a(String id);

    e4 b(String id);

    void b();

    DataSource.Factory c();

    float d(String id);

    DownloadManager d();
}
