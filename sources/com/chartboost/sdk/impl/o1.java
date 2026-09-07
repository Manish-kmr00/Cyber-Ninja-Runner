package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/chartboost/sdk/impl/o1;", "", "", "a", "()Ljava/lang/String;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/n1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lcom/chartboost/sdk/impl/w1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/w1;", "identity", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "d", "Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfiguration", "Lcom/chartboost/sdk/impl/t7;", "e", "Lcom/chartboost/sdk/impl/t7;", "openMeasurementManager", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/n1;Lcom/chartboost/sdk/impl/w1;Ljava/util/concurrent/atomic/AtomicReference;Lcom/chartboost/sdk/impl/t7;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final n1 base64Wrapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final w1 identity;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final AtomicReference<o9> sdkConfiguration;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final t7 openMeasurementManager;

    public o1(Context context, n1 base64Wrapper, w1 identity, AtomicReference<o9> sdkConfiguration, t7 openMeasurementManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        Intrinsics.checkNotNullParameter(openMeasurementManager, "openMeasurementManager");
        this.context = context;
        this.base64Wrapper = base64Wrapper;
        this.identity = identity;
        this.sdkConfiguration = sdkConfiguration;
        this.openMeasurementManager = openMeasurementManager;
    }

    public final String a() throws JSONException {
        n7 n7VarB;
        f8 f8VarC;
        r5 r5VarH = this.identity.h();
        o9 o9Var = this.sdkConfiguration.get();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_version", "1.0");
        String setId = r5VarH.getSetId();
        if (setId == null) {
            setId = "";
        }
        jSONObject.put("appSetId", setId);
        Integer setIdScope = r5VarH.getSetIdScope();
        jSONObject.put("appSetIdScope", setIdScope != null ? setIdScope.intValue() : 0);
        jSONObject.put("package", this.context.getPackageName());
        if (o9Var != null && (n7VarB = o9Var.b()) != null && n7VarB.getIsEnabled() && (f8VarC = this.openMeasurementManager.c()) != null) {
            jSONObject.put("omidpn", f8VarC.a());
            jSONObject.put("omidpv", f8VarC.b());
        }
        n1 n1Var = this.base64Wrapper;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return n1Var.c(string);
    }
}
