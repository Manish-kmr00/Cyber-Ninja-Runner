package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class Lf implements Jf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11244a;

    public Lf(Rf rf) {
        this.f11244a = rf;
    }

    @Override // io.appmetrica.analytics.impl.Jf
    public final void a() {
        Rf rf = this.f11244a;
        Ga ga = rf.b;
        Kf kf = new Kf(rf);
        ga.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Fa(ga));
            C4486ua.E.d.f11380a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + ThreadFactoryC4589yd.f11859a.incrementAndGet()).start();
            C4044cg c4044cg = (C4044cg) futureTask.get(5L, TimeUnit.SECONDS);
            In.a(ga.b);
            Rf.a(rf, c4044cg, Rf.a(rf));
        } catch (Throwable th) {
            try {
                kf.a(th);
            } finally {
                In.a(ga.b);
            }
        }
    }
}
