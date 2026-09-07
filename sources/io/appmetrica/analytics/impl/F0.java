package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class F0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11131a;
    public final /* synthetic */ C4278m1 b;

    public F0(C4278m1 c4278m1, String str) {
        this.b = c4278m1;
        this.f11131a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f11131a, false);
    }
}
