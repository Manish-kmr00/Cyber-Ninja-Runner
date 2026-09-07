package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class Sh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f11349a;
    public final /* synthetic */ Yh b;

    public Sh(Yh yh, S s) {
        this.b = yh;
        this.f11349a = s;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).a(this.f11349a);
    }
}
