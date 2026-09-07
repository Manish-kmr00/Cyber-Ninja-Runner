package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class L0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f11233a;
    public final /* synthetic */ C4278m1 b;

    public L0(C4278m1 c4278m1, boolean z) {
        this.b = c4278m1;
        this.f11233a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.b.f11662a;
        boolean z = this.f11233a;
        c4377q0.getClass();
        C4352p0.c().setDataSendingEnabled(z);
    }
}
