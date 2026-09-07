package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Bh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f11075a;
    public final /* synthetic */ Yh b;

    public Bh(Yh yh, Throwable th) {
        this.b = yh;
        this.f11075a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportUnhandledException(this.f11075a);
    }
}
