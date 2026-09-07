package com.moloco.sdk.internal.services;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/internal/services/SingleObserverBackgroundThenForegroundAnalyticsListener;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "a", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onStart", "onStop", "Lcom/moloco/sdk/internal/services/analytics/a;", "Lcom/moloco/sdk/internal/services/analytics/a;", "analyticsService", "Lcom/moloco/sdk/internal/services/i0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/moloco/sdk/internal/services/i0;", "timeProviderService", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/Long;", "lastBgTimestamp", "", "d", "Z", "trackNext", "<init>", "(Lcom/moloco/sdk/internal/services/analytics/a;Lcom/moloco/sdk/internal/services/i0;)V", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0})
public final class SingleObserverBackgroundThenForegroundAnalyticsListener implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.moloco.sdk.internal.services.analytics.a analyticsService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final i0 timeProviderService;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Long lastBgTimestamp;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean trackNext;

    public SingleObserverBackgroundThenForegroundAnalyticsListener(com.moloco.sdk.internal.services.analytics.a analyticsService, i0 timeProviderService) {
        Intrinsics.checkNotNullParameter(analyticsService, "analyticsService");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.analyticsService = analyticsService;
        this.timeProviderService = timeProviderService;
    }

    public final void a() {
        this.trackNext = true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, h.f6388a, "Application onStart", false, 4, null);
        Long l = this.lastBgTimestamp;
        if (l != null) {
            MolocoLogger.debug$default(molocoLogger, h.f6388a, "Background event has been recorded, recording foreground", false, 4, null);
            this.analyticsService.a(this.timeProviderService.invoke(), l.longValue());
            this.lastBgTimestamp = null;
            this.trackNext = false;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, h.f6388a, "Application onStop", false, 4, null);
        if (this.trackNext) {
            MolocoLogger.debug$default(molocoLogger, h.f6388a, "Tracking of event is true. Recording background", false, 4, null);
            long jInvoke = this.timeProviderService.invoke();
            this.lastBgTimestamp = Long.valueOf(jInvoke);
            this.analyticsService.a(jInvoke);
        }
    }
}
