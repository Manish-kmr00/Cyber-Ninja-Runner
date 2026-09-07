package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class G9 implements IHandlerExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f11158a;
    public final Handler b;
    public final HandlerThreadC4189ib c;

    public G9(String str) {
        this(a(str));
    }

    public static HandlerThreadC4189ib a(String str) {
        HandlerThreadC4189ib handlerThreadC4189ib = new HandlerThreadC4189ib(str + "-" + ThreadFactoryC4589yd.f11859a.incrementAndGet());
        handlerThreadC4189ib.start();
        return handlerThreadC4189ib;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j) {
        this.b.postDelayed(runnable, TimeUnit.MILLISECONDS.toMillis(j));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor
    public final Handler getHandler() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor
    public final Looper getLooper() {
        return this.f11158a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC4189ib handlerThreadC4189ib = this.c;
        synchronized (handlerThreadC4189ib) {
            z = handlerThreadC4189ib.f11601a;
        }
        return z;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void remove(Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void removeAll() {
        this.b.removeCallbacksAndMessages(null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final void stopRunning() {
        HandlerThreadC4189ib handlerThreadC4189ib = this.c;
        synchronized (handlerThreadC4189ib) {
            handlerThreadC4189ib.f11601a = false;
            handlerThreadC4189ib.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public G9(HandlerThreadC4189ib handlerThreadC4189ib) {
        this(handlerThreadC4189ib, handlerThreadC4189ib.getLooper(), new Handler(handlerThreadC4189ib.getLooper()));
    }

    public G9(HandlerThreadC4189ib handlerThreadC4189ib, Looper looper, Handler handler) {
        this.c = handlerThreadC4189ib;
        this.f11158a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
