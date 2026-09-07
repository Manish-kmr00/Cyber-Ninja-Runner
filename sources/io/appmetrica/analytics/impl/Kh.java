package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class Kh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f11227a;
    public final /* synthetic */ Yh b;

    public Kh(Yh yh, boolean z) {
        this.b = yh;
        this.f11227a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).setDataSendingEnabled(this.f11227a);
    }
}
