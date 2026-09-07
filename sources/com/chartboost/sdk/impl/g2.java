package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J!\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0006\u0010$¨\u0006("}, d2 = {"Lcom/chartboost/sdk/impl/g2;", "", "T", "Lcom/chartboost/sdk/impl/c2;", "request", "", "a", "(Lcom/chartboost/sdk/impl/c2;)V", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "backgroundExecutor", "Lcom/chartboost/sdk/impl/j7;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/j7;", "factory", "Lcom/chartboost/sdk/impl/h2;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/ba;", "d", "Lcom/chartboost/sdk/impl/ba;", "timeSource", "Lcom/chartboost/sdk/impl/sa;", "e", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", InneractiveMediationDefs.GENDER_FEMALE, "networkExecutor", "Lcom/chartboost/sdk/impl/l4;", "g", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "", "h", "Ljava/lang/String;", "()Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.APP_ID, "<init>", "(Ljava/util/concurrent/Executor;Lcom/chartboost/sdk/impl/j7;Lcom/chartboost/sdk/impl/h2;Lcom/chartboost/sdk/impl/ba;Lcom/chartboost/sdk/impl/sa;Ljava/util/concurrent/Executor;Lcom/chartboost/sdk/impl/l4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Executor backgroundExecutor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final j7 factory;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final ba timeSource;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Executor networkExecutor;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final l4 eventTracker;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final String appId;

    public g2(Executor backgroundExecutor, j7 factory, h2 reachability, ba timeSource, sa uiPoster, Executor networkExecutor, l4 eventTracker) {
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(reachability, "reachability");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(networkExecutor, "networkExecutor");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.backgroundExecutor = backgroundExecutor;
        this.factory = factory;
        this.reachability = reachability;
        this.timeSource = timeSource;
        this.uiPoster = uiPoster;
        this.networkExecutor = networkExecutor;
        this.eventTracker = eventTracker;
        this.appId = y2.b.b();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final <T> void a(c2<T> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        b7.d("Execute request: " + request.getUri(), null);
        this.networkExecutor.execute(new i7(this.backgroundExecutor, this.factory, this.reachability, this.timeSource, this.uiPoster, request, this.eventTracker));
    }
}
