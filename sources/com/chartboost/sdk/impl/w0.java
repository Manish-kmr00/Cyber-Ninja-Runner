package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/chartboost/sdk/impl/w0;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/app/Application;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Landroid/app/Application;", "app", "Landroid/content/SharedPreferences;", InneractiveMediationDefs.GENDER_FEMALE, "()Landroid/content/SharedPreferences;", "sharedPreferences", "d", "trackingSharedPreferences", "Lcom/chartboost/sdk/impl/v0;", "j", "()Lcom/chartboost/sdk/impl/v0;", "android", "Lcom/chartboost/sdk/impl/sa;", "e", "()Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/n1;", "a", "()Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Lcom/chartboost/sdk/impl/g9;", "i", "()Lcom/chartboost/sdk/impl/g9;", "resourceLoader", "Lcom/chartboost/sdk/impl/u9;", "g", "()Lcom/chartboost/sdk/impl/u9;", "sharedPrefsHelper", "Lcom/chartboost/sdk/impl/b4;", "h", "()Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "Lcom/chartboost/sdk/impl/z3;", CampaignEx.JSON_KEY_AD_K, "()Lcom/chartboost/sdk/impl/z3;", "deviceFieldsWrapper", "Landroid/content/ContentResolver;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Landroid/content/ContentResolver;", "contentResolver", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface w0 {
    n1 a();

    Application b();

    ContentResolver c();

    SharedPreferences d();

    sa e();

    SharedPreferences f();

    u9 g();

    Context getContext();

    b4 h();

    g9 i();

    v0 j();

    z3 k();
}
