package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\fJ)\u0010\r\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\r\u0010\u0014J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\u0015J!\u0010\r\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\r\u0010\u0019R\u001c\u0010\u001e\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/chartboost/sdk/impl/y5;", "", "", "location", "", "videoPosition", "videoDuration", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "Lcom/chartboost/sdk/impl/m2;", "cbUrl", "(Lcom/chartboost/sdk/impl/m2;)V", "a", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "urlFromCreative", "", "shouldDismiss", "Lcom/chartboost/sdk/impl/l6;", "impressionState", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/chartboost/sdk/impl/l6;)Z", "()V", "url", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "error", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "getClick", "()Z", "e", "(Z)V", "click", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface y5 {
    void a(m2 cbUrl);

    void a(String url, CBError.a error);

    boolean a(String urlFromCreative, Boolean shouldDismiss, l6 impressionState);

    void b();

    void b(m2 cbUrl);

    void b(String location, Float videoPosition, Float videoDuration);

    void c(m2 cbUrl);

    void e(boolean z);
}
