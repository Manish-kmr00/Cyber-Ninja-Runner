package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class H0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11169a;
    public final /* synthetic */ C4278m1 b;

    public H0(C4278m1 c4278m1, String str) {
        this.b = c4278m1;
        this.f11169a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).b(this.f11169a);
    }
}
