package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Dh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Yh f11107a;

    public Dh(Yh yh) {
        this.f11107a = yh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.f11107a;
        Yh.a(yh.f11439a, yh.d, yh.e).pauseSession();
    }
}
