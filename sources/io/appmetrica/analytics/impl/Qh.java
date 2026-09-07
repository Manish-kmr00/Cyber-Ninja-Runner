package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes.dex */
public final class Qh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4325nn f11315a;
    public final /* synthetic */ Yh b;

    public Qh(Yh yh, C4325nn c4325nn) {
        this.b = yh;
        this.f11315a = c4325nn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).a(this.f11315a);
    }
}
