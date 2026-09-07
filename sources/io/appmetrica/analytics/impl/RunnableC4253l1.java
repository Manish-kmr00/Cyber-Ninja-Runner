package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC4253l1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f11641a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4253l1(C4278m1 c4278m1, Throwable th) {
        this.b = c4278m1;
        this.f11641a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportUnhandledException(this.f11641a);
    }
}
