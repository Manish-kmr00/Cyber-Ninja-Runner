package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class Wf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC4169hg f11405a;
    public final /* synthetic */ Throwable b;

    public Wf(InterfaceC4169hg interfaceC4169hg, Throwable th) {
        this.f11405a = interfaceC4169hg;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11405a.a(this.b);
    }
}
