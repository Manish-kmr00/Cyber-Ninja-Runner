package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class Uh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11378a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Yh c;

    public Uh(Yh yh, String str, String str2) {
        this.c = yh;
        this.f11378a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).putAppEnvironmentValue(this.f11378a, this.b);
    }
}
