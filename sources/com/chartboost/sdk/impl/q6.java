package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH&¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000eH&¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\u000eH&¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u0007\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H&¢\u0006\u0004\b \u0010\u001bJ\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u001bJ\u000f\u0010!\u001a\u00020\u0006H&¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b\"\u0010\u001bR\u001c\u0010$\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0013\"\u0004\b\u0007\u0010\u0011¨\u0006%"}, d2 = {"Lcom/chartboost/sdk/impl/q6;", "", "Landroid/view/ViewGroup;", "o", "()Landroid/view/ViewGroup;", "hostView", "", "a", "(Landroid/view/ViewGroup;)V", "Lcom/chartboost/sdk/impl/l6;", "state", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "(Lcom/chartboost/sdk/impl/l6;Lcom/chartboost/sdk/view/CBImpressionActivity;)V", "", VastAttributes.VISIBLE, "d", "(Z)V", "h", "()Z", "showProcessed", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "m", "showSent", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, CampaignEx.JSON_KEY_AD_K, "j", "()V", "n", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "g", InneractiveMediationDefs.GENDER_FEMALE, "l", "i", "wasImpressionSignaled", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface q6 {
    void a(ViewGroup hostView);

    void a(l6 state, CBImpressionActivity activity);

    void a(CBError.b error);

    void a(boolean z);

    void b(boolean showProcessed);

    void c();

    void c(boolean showSent);

    void d(boolean visible);

    void f();

    void g();

    boolean h();

    boolean i();

    void j();

    boolean k();

    void l();

    boolean m();

    void n();

    ViewGroup o();
}
