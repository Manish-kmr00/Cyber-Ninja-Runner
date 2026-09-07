package com.moloco.sdk.internal.error.crash;

import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.moloco.sdk.internal.error.crash.filters.a> f6094a;
    public final com.moloco.sdk.internal.error.api.a b;
    public final String c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends com.moloco.sdk.internal.error.crash.filters.a> exceptionFilters, com.moloco.sdk.internal.error.api.a errorReporter) {
        Intrinsics.checkNotNullParameter(exceptionFilters, "exceptionFilters");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.f6094a = exceptionFilters;
        this.b = errorReporter;
        this.c = "CrashHandlerService";
    }

    @Override // com.moloco.sdk.internal.error.crash.c
    public void a(Throwable crash) {
        Intrinsics.checkNotNullParameter(crash, "crash");
        if (!b(crash)) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "App Crashed", null, false, 12, null);
        } else {
            AndroidClientMetrics.INSTANCE.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.CrashDetected.b()));
            this.b.a(crash);
        }
    }

    public final boolean b(Throwable th) {
        Iterator<com.moloco.sdk.internal.error.crash.filters.a> it = this.f6094a.iterator();
        while (it.hasNext()) {
            if (it.next().a(th)) {
                return true;
            }
        }
        return false;
    }
}
