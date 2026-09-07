package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class Kf implements InterfaceC4169hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11225a;

    public Kf(Rf rf) {
        this.f11225a = rf;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4169hg
    public final void a(C4044cg c4044cg) {
        Rf rf = this.f11225a;
        Rf.a(rf, c4044cg, (Jf) rf.d.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4169hg
    public final void a(Throwable th) {
        Rf rf = this.f11225a;
        Rf.a(rf, null, (Jf) rf.d.getValue());
    }
}
