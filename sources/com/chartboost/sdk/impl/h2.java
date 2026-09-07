package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/h2;", "", "Lcom/chartboost/sdk/impl/o3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/chartboost/sdk/impl/o3;", "Lcom/chartboost/sdk/impl/m7;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/m7;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "", "a", "()I", "", "d", "()Z", "Landroid/content/Context;", "Landroid/content/Context;", "context", "e", "isNetworkAvailable", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    public h2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean e() {
        return p3.d(this.context);
    }

    public final o3 c() {
        o3 o3Var;
        Context context = this.context;
        if (!p3.d(context)) {
            o3Var = o3.CONNECTION_ERROR;
        } else if (p3.e(context)) {
            o3Var = o3.CONNECTION_WIFI;
        } else if (p3.c(context)) {
            o3Var = o3.CONNECTION_MOBILE;
        } else {
            o3Var = o3.CONNECTION_UNKNOWN;
        }
        b7.a("NETWORK TYPE: " + o3Var, (Throwable) null, 2, (Object) null);
        return o3Var;
    }

    public final m7 f() {
        return p3.g(this.context);
    }

    public final String b() {
        return p3.g(this.context).getAsString();
    }

    public final int a() {
        return p3.f(this.context);
    }

    public final boolean d() {
        return c() == o3.CONNECTION_MOBILE;
    }
}
