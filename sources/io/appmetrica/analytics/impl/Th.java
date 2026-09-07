package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class Th implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Yh f11366a;

    public Th(Yh yh) {
        this.f11366a = yh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.f11366a;
        Yh.a(yh.f11439a, yh.d, yh.e).sendEventsBuffer();
    }
}
