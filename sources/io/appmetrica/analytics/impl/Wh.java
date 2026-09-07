package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class Wh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11406a;
    public final /* synthetic */ Yh b;

    public Wh(Yh yh, String str) {
        this.b = yh;
        this.f11406a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportEvent(this.f11406a);
    }
}
