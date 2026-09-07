package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Ah implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11060a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ Yh d;

    public Ah(Yh yh, String str, String str2, Throwable th) {
        this.d = yh;
        this.f11060a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.d;
        Yh.a(yh.f11439a, yh.d, yh.e).reportError(this.f11060a, this.b, this.c);
    }
}
