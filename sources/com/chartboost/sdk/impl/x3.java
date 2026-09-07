package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/x3;", "", "Lcom/chartboost/sdk/impl/w3;", "a", "()Lcom/chartboost/sdk/impl/w3;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/b4;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "Lcom/chartboost/sdk/impl/z3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/z3;", "deviceFieldsWrapper", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/b4;Lcom/chartboost/sdk/impl/z3;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final b4 displayMeasurement;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final z3 deviceFieldsWrapper;

    public x3(Context context, b4 displayMeasurement, z3 deviceFieldsWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        Intrinsics.checkNotNullParameter(deviceFieldsWrapper, "deviceFieldsWrapper");
        this.context = context;
        this.displayMeasurement = displayMeasurement;
        this.deviceFieldsWrapper = deviceFieldsWrapper;
    }

    public final w3 a() {
        try {
            c4 c4VarA = this.displayMeasurement.a();
            c4 c4VarD = this.displayMeasurement.d();
            String packageName = this.context.getPackageName();
            int width = c4VarA.getWidth();
            int height = c4VarA.getHeight();
            int width2 = c4VarD.getWidth();
            int height2 = c4VarD.getHeight();
            float displayMetricsDensity = this.displayMeasurement.getDisplayMetricsDensity();
            String strValueOf = String.valueOf(this.displayMeasurement.getDisplayMetricsDensityDpi());
            int iA = this.deviceFieldsWrapper.a();
            String strB = this.deviceFieldsWrapper.b();
            PackageManager packageManager = this.context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            return new w3(width, height, width2, height2, displayMetricsDensity, strValueOf, iA, strB, packageName, b5.getPackageVersionName(packageManager, packageName), this.deviceFieldsWrapper.c());
        } catch (Exception e) {
            b7.b("Cannot create device body", e);
            return new w3(0, 0, 0, 0, 0.0f, null, 0, null, null, null, false, 2047, null);
        }
    }
}
