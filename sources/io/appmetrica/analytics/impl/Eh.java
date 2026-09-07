package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class Eh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11123a;
    public final /* synthetic */ Yh b;

    public Eh(Yh yh, String str) {
        this.b = yh;
        this.f11123a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).setUserProfileID(this.f11123a);
    }
}
