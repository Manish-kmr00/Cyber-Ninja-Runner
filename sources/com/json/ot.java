package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/ironsource/ot;", "Lcom/ironsource/ew;", "Lcom/ironsource/a0;", "instanceToShow", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, m5.p, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "Lcom/ironsource/xo;", "d", "Lcom/ironsource/xo;", "outcomeReporter", "Lcom/ironsource/zv;", "e", "Lcom/ironsource/zv;", "waterfallInstances", "Lcom/ironsource/g0;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/g0;", "adInstanceLoadStrategy", "Lcom/ironsource/w2;", "adTools", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/xo;Lcom/ironsource/zv;Lcom/ironsource/g0;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class ot extends ew {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final xo outcomeReporter;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final zv waterfallInstances;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final g0 adInstanceLoadStrategy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot(w2 adTools, xo outcomeReporter, zv waterfallInstances, g0 adInstanceLoadStrategy) {
        super(adTools, outcomeReporter);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(outcomeReporter, "outcomeReporter");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        Intrinsics.checkNotNullParameter(adInstanceLoadStrategy, "adInstanceLoadStrategy");
        this.outcomeReporter = outcomeReporter;
        this.waterfallInstances = waterfallInstances;
        this.adInstanceLoadStrategy = adInstanceLoadStrategy;
    }

    @Override // com.json.ew
    public void a() {
        a0 instanceToShow = this.adInstanceLoadStrategy.c().getInstanceToShow();
        if (instanceToShow != null) {
            this.outcomeReporter.a(this.waterfallInstances.b(), instanceToShow);
        }
    }

    @Override // com.json.ew
    public void a(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!this.adInstanceLoadStrategy.a(instance) && (!this.adInstanceLoadStrategy.a() || (instance = this.adInstanceLoadStrategy.c().getInstanceToShow()) == null)) {
            return;
        }
        this.outcomeReporter.a(this.waterfallInstances.b(), instance);
    }

    @Override // com.json.ew
    public void b(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // com.json.ew
    public void c(a0 instanceToShow) {
        Intrinsics.checkNotNullParameter(instanceToShow, "instanceToShow");
        this.outcomeReporter.a(this.waterfallInstances.b(), instanceToShow);
    }
}
