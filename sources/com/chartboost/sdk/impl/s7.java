package com.chartboost.sdk.impl;

import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J7\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010\u0012J\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&¢\u0006\u0004\b\u000e\u0010\u0016J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u000e\u0010\u0019J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u000e\u0010\u001cJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H&¢\u0006\u0004\b\u000e\u0010 J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\u000e\u0010#J\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010\u0004¨\u0006%"}, d2 = {"Lcom/chartboost/sdk/impl/s7;", "", "", "e", "()V", "Lcom/chartboost/sdk/impl/d7;", "mtype", "Lcom/chartboost/sdk/impl/p2;", com.ironsource.b9.h.K, "", UnifiedMediationParams.KEY_SKIP_OFFSET, "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourcesList", "a", "(Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/p2;Ljava/lang/Integer;Ljava/util/List;)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "", "videoDuration", "volume", "(FF)V", "", "isBufferStart", "(Z)V", "Lcom/chartboost/sdk/impl/t8;", "quartile", "(Lcom/chartboost/sdk/impl/t8;)V", InneractiveMediationDefs.GENDER_FEMALE, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(F)V", "Lcom/chartboost/sdk/impl/g8;", "state", "(Lcom/chartboost/sdk/impl/g8;)V", "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface s7 {
    void a();

    void a(float volume);

    void a(float videoDuration, float volume);

    void a(View view);

    void a(d7 mtype, p2 webview, Integer skipOffset, List<fb> verificationScriptResourcesList);

    void a(g8 state);

    void a(t8 quartile);

    void a(boolean isBufferStart);

    void b();

    void c();

    void d();

    void e();

    void f();
}
