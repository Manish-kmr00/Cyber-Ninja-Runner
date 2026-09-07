package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class Xh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11420a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Yh c;

    public Xh(Yh yh, String str, String str2) {
        this.c = yh;
        this.f11420a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).reportEvent(this.f11420a, this.b);
    }
}
