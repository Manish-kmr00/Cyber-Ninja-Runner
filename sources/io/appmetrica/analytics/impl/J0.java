package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f11203a;
    public final /* synthetic */ C4278m1 b;

    public J0(C4278m1 c4278m1, boolean z) {
        this.b = c4278m1;
        this.f11203a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.b.f11662a;
        boolean z = this.f11203a;
        c4377q0.getClass();
        C4352p0.c().a(z);
    }
}
