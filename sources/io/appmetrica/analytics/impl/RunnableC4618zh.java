package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC4618zh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11879a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ Yh c;

    public RunnableC4618zh(Yh yh, String str, Throwable th) {
        this.c = yh;
        this.f11879a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).reportError(this.f11879a, this.b);
    }
}
