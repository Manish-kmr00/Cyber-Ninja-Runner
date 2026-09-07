package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4277m0 implements Ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11661a;
    public final IHandlerExecutor b;
    public final C4505v4 c;

    public C4277m0() {
        IHandlerExecutor iHandlerExecutorA = C4455t4.i().e().a();
        this.b = iHandlerExecutorA;
        this.f11661a = iHandlerExecutorA.getHandler();
        this.c = new C4505v4();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final void a(AppMetricaConfig appMetricaConfig, InterfaceC3989ab interfaceC3989ab) {
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final Handler b() {
        return this.f11661a;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final W1 c() {
        return new W1();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final C4388qb d() {
        return new C4388qb();
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Ia
    public final C4505v4 a() {
        return this.c;
    }
}
