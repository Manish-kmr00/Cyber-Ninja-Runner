package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public final class F9 implements ExecutorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uj f11137a;
    public final IHandlerExecutor b;

    public F9() {
        Uj ujW = C4486ua.j().w();
        this.f11137a = ujW;
        this.b = ujW.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f11137a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + "-" + ThreadFactoryC4589yd.f11859a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        Uj uj = this.f11137a;
        if (uj.f == null) {
            synchronized (uj) {
                if (uj.f == null) {
                    uj.f11380a.getClass();
                    HandlerThreadC4189ib handlerThreadC4189ibA = G9.a("IAA-SIO");
                    uj.f = new G9(handlerThreadC4189ibA, handlerThreadC4189ibA.getLooper(), new Handler(handlerThreadC4189ibA.getLooper()));
                }
            }
        }
        return uj.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f11137a.f();
    }
}
