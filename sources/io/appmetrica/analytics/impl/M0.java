package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class M0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11250a;
    public final /* synthetic */ C4278m1 b;

    public M0(C4278m1 c4278m1, String str) {
        this.b = c4278m1;
        this.f11250a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.b.f11662a;
        String str = this.f11250a;
        c4377q0.getClass();
        C4352p0.c().setUserProfileID(str);
    }
}
