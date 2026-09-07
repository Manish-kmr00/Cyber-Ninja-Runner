package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.IReporter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qf implements lp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f10013a;

    public qf(Lazy<? extends IReporter> lazyReporter) {
        Intrinsics.checkNotNullParameter(lazyReporter, "lazyReporter");
        this.f10013a = lazyReporter;
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void a(hp1 report) {
        Intrinsics.checkNotNullParameter(report, "report");
        try {
            ((IReporter) this.f10013a.getValue()).reportEvent(report.c(), report.b());
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportAnr(Map<Thread, StackTraceElement[]> traces) {
        Intrinsics.checkNotNullParameter(traces, "traces");
        try {
            ((IReporter) this.f10013a.getValue()).reportAnr(traces);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportError(String message, Throwable error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        try {
            ((IReporter) this.f10013a.getValue()).reportError(message, error);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void reportUnhandledException(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            ((IReporter) this.f10013a.getValue()).reportUnhandledException(throwable);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lp1
    public final void a(boolean z) {
        try {
            ((IReporter) this.f10013a.getValue()).setDataSendingEnabled(z);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
    }
}
