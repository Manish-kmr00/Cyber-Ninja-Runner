package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class U0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11372a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C4278m1 c;

    public U0(C4278m1 c4278m1, String str, String str2) {
        this.c = c4278m1;
        this.f11372a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.c.f11662a;
        String str = this.f11372a;
        String str2 = this.b;
        c4377q0.getClass();
        C4352p0.c().a(str, str2);
    }
}
