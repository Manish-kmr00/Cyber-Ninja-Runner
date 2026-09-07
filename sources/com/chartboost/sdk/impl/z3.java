package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/chartboost/sdk/impl/z3;", "", "", "a", "()I", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Z", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/b4;", "Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/b4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final b4 displayMeasurement;

    public z3(Context context, b4 displayMeasurement) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        this.context = context;
        this.displayMeasurement = displayMeasurement;
    }

    public final int a() {
        Integer numB = a4.b(this.context);
        Intrinsics.checkNotNullExpressionValue(numB, "getOpenRTBDeviceType(context)");
        return numB.intValue();
    }

    public final String b() {
        String strD = a4.d(this.context);
        Intrinsics.checkNotNullExpressionValue(strD, "getType(context)");
        return strD;
    }

    public final boolean c() {
        return b8.c(this.context, this.displayMeasurement);
    }
}
