package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4393qg implements InterfaceC4447sl, Na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11737a;
    public final C4108f5 b;
    public final C4133g5 c;
    public final C4075dm d;
    public final Wa e;

    public C4393qg(Context context, C4108f5 c4108f5, G4 g4, InterfaceC4307n5 interfaceC4307n5, C4133g5 c4133g5, C4223jl c4223jl) {
        this.f11737a = context;
        this.b = c4108f5;
        this.c = c4133g5;
        C4075dm c4075dmA = c4223jl.a(context, c4108f5, g4.f11154a);
        this.d = c4075dmA;
        this.e = interfaceC4307n5.a(context, c4108f5, g4.b, c4075dmA);
        c4223jl.a(c4108f5, this);
    }

    public final C4108f5 a() {
        return this.b;
    }

    public final Context b() {
        return this.f11737a;
    }

    public final void a(InterfaceC4530w4 interfaceC4530w4) {
        this.c.f11562a.add(interfaceC4530w4);
    }

    public final void b(InterfaceC4530w4 interfaceC4530w4) {
        this.c.f11562a.remove(interfaceC4530w4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(Hl hl) {
        this.e.a(hl);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4447sl
    public final void a(EnumC4273ll enumC4273ll, Hl hl) {
        ((C4282m5) this.e).getClass();
    }

    @Override // io.appmetrica.analytics.impl.Na
    public final void a(G4 g4) {
        this.d.a(g4.f11154a);
        this.e.a(g4.b);
    }

    public final void a(C3984a6 c3984a6, G4 g4) {
        if (!C9.c.contains(EnumC4164hb.a(c3984a6.d))) {
            this.e.a(g4.b);
        }
        ((C4282m5) this.e).a(c3984a6);
    }

    public C4393qg(Context context, C4108f5 c4108f5, G4 g4, InterfaceC4307n5 interfaceC4307n5) {
        this(context, c4108f5, g4, interfaceC4307n5, new C4133g5(), C4223jl.a());
    }
}
