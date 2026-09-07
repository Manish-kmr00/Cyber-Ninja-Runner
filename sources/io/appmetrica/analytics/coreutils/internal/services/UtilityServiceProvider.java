package io.appmetrica.analytics.coreutils.internal.services;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.utils.j;
import io.appmetrica.analytics.coreutils.impl.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/UtilityServiceProvider;", "", "", "initAsync", "Lio/appmetrica/analytics/coreutils/internal/services/UtilityServiceConfiguration;", j.c, "updateConfiguration", "Lio/appmetrica/analytics/coreutils/internal/services/FirstExecutionConditionServiceImpl;", "a", "Lkotlin/Lazy;", "getFirstExecutionService", "()Lio/appmetrica/analytics/coreutils/internal/services/FirstExecutionConditionServiceImpl;", "firstExecutionService", "Lio/appmetrica/analytics/coreutils/internal/services/WaitForActivationDelayBarrier;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/appmetrica/analytics/coreutils/internal/services/WaitForActivationDelayBarrier;", "getActivationBarrier", "()Lio/appmetrica/analytics/coreutils/internal/services/WaitForActivationDelayBarrier;", "activationBarrier", "<init>", "()V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
public final class UtilityServiceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy firstExecutionService = LazyKt.lazy(new l(this));

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final WaitForActivationDelayBarrier activationBarrier = new WaitForActivationDelayBarrier();

    public final WaitForActivationDelayBarrier getActivationBarrier() {
        return this.activationBarrier;
    }

    public final FirstExecutionConditionServiceImpl getFirstExecutionService() {
        return (FirstExecutionConditionServiceImpl) this.firstExecutionService.getValue();
    }

    public final void initAsync() {
        this.activationBarrier.activate();
    }

    public final void updateConfiguration(UtilityServiceConfiguration configuration) {
        getFirstExecutionService().updateConfig(configuration);
    }
}
