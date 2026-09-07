package io.appmetrica.analytics.coreapi.internal.executors;

/* JADX INFO: loaded from: classes.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f10962a;

    public InterruptionSafeThread() {
        this.f10962a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f10962a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f10962a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f10962a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f10962a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f10962a = true;
    }
}
