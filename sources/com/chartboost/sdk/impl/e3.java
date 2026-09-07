package com.chartboost.sdk.impl;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "a", "()Landroid/content/Context;", "Lcom/chartboost/sdk/impl/w6;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/chartboost/sdk/impl/w6;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class e3 {
    public static final Context a() {
        Context applicationContext = y2.b.a().getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "ChartboostDependencyCont…ontext.applicationContext");
        return applicationContext;
    }

    public static final w6 b() {
        return y2.b.d().p();
    }
}
