package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC4102f implements InterfaceC4530w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11539a;
    public final C4393qg b;

    public AbstractC4102f(Context context, C4393qg c4393qg) {
        this.f11539a = context.getApplicationContext();
        this.b = c4393qg;
        c4393qg.a(this);
        C4486ua.j().m().b(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4530w4
    public final void a(C3984a6 c3984a6, G4 g4) {
        b(c3984a6, g4);
    }

    public final C4393qg b() {
        return this.b;
    }

    public abstract void b(C3984a6 c3984a6, G4 g4);

    public final Context c() {
        return this.f11539a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4530w4
    public final void a() {
        this.b.b(this);
        C4486ua.E.l().a(this);
    }
}
