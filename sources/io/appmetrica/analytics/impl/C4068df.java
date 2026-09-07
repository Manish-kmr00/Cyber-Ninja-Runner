package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4068df implements Ii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oe f11514a;

    public C4068df(Oe oe) {
        this.f11514a = oe;
    }

    @Override // io.appmetrica.analytics.impl.Ii
    public final boolean a() {
        return this.f11514a.i();
    }

    @Override // io.appmetrica.analytics.impl.Ii
    public final void b() {
        this.f11514a.h().b();
    }

    public C4068df() {
        this(C4486ua.j().x());
    }
}
