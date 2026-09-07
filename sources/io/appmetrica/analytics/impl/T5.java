package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class T5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11360a;
    public final IHandlerExecutor b = C4486ua.j().w().a();
    public final WaitForActivationDelayBarrier c = C4486ua.j().a();

    public T5(List list) {
        this.f11360a = list;
    }

    public static final void a(T5 t5) {
        Iterator it = t5.f11360a.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(TimeUnit.SECONDS.toMillis(10L), this.b, new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.T5$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                T5.a(this.f$0);
            }
        });
    }
}
