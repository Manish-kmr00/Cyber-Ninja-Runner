package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC4203j1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11610a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C4278m1 c;

    public RunnableC4203j1(C4278m1 c4278m1, String str, Throwable th) {
        this.c = c4278m1;
        this.f11610a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.c).reportError(this.f11610a, this.b);
    }
}
