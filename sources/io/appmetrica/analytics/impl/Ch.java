package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Ch implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Yh f11091a;

    public Ch(Yh yh) {
        this.f11091a = yh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.f11091a;
        Yh.a(yh.f11439a, yh.d, yh.e).resumeSession();
    }
}
