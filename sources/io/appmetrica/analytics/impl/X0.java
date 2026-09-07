package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class X0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11410a;
    public final /* synthetic */ C4278m1 b;

    public X0(C4278m1 c4278m1, String str) {
        this.b = c4278m1;
        this.f11410a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).a(this.f11410a);
    }
}
