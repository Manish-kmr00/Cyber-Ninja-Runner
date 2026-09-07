package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes.dex */
public final class Pf implements InterfaceC4169hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11296a;

    public Pf(Rf rf) {
        this.f11296a = rf;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4169hg
    public final void a(C4044cg c4044cg) {
        Rf rf = this.f11296a;
        Rf.a(rf, c4044cg, (Jf) rf.e.getValue());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4169hg
    public final void a(Throwable th) {
        Rf rf = this.f11296a;
        Rf.a(rf, null, (Jf) rf.e.getValue());
    }
}
