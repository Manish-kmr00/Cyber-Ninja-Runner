package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class Vh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Yh f11393a;

    public Vh(Yh yh) {
        this.f11393a = yh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.f11393a;
        Yh.a(yh.f11439a, yh.d, yh.e).clearAppEnvironment();
    }
}
