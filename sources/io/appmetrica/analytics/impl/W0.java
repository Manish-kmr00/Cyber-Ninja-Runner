package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class W0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11399a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C4278m1 c;

    public W0(C4278m1 c4278m1, String str, String str2) {
        this.c = c4278m1;
        this.f11399a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.c).b(this.f11399a, this.b);
    }
}
