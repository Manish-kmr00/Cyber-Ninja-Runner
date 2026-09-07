package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/q5;", "", "Lcom/chartboost/sdk/impl/r0;", "a", "()Lcom/chartboost/sdk/impl/r0;", "Landroid/content/Context;", "context", "", "isTrackingLimited", "", "(Landroid/content/Context;Z)Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "Lcom/chartboost/sdk/impl/m5;", "Lcom/chartboost/sdk/impl/m5;", "googleAdvertisingId", "Lcom/chartboost/sdk/impl/t0;", "Lcom/chartboost/sdk/impl/t0;", "amazonAdvertisingId", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", CommonUrlParts.MANUFACTURER, "<init>", "(Lcom/chartboost/sdk/impl/m5;Lcom/chartboost/sdk/impl/t0;Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final m5 googleAdvertisingId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final t0 amazonAdvertisingId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String manufacturer;

    public q5(m5 googleAdvertisingId, t0 amazonAdvertisingId, String manufacturer) {
        Intrinsics.checkNotNullParameter(googleAdvertisingId, "googleAdvertisingId");
        Intrinsics.checkNotNullParameter(amazonAdvertisingId, "amazonAdvertisingId");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        this.googleAdvertisingId = googleAdvertisingId;
        this.amazonAdvertisingId = amazonAdvertisingId;
        this.manufacturer = manufacturer;
    }

    public final r0 a() {
        try {
            if (b()) {
                return this.amazonAdvertisingId.b();
            }
            return this.googleAdvertisingId.b();
        } catch (Exception e) {
            b7.b("getAdvertisingId error", e);
            return new r0(qa.TRACKING_UNKNOWN, "");
        }
    }

    public final String a(Context context, boolean isTrackingLimited) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strA = a4.a(context, isTrackingLimited);
        Intrinsics.checkNotNullExpressionValue(strA, "getUniqueId(context, isTrackingLimited)");
        return strA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ q5(m5 m5Var, t0 t0Var, String MANUFACTURER, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        }
        this(m5Var, t0Var, MANUFACTURER);
    }

    public final boolean b() {
        return StringsKt.equals("Amazon", this.manufacturer, true);
    }
}
