package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;

/* JADX INFO: loaded from: classes5.dex */
public final class Kg implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4601z0 f11226a;
    public final Function b;
    public final /* synthetic */ Lg c;

    public Kg(Lg lg, C4601z0 c4601z0, Function<String, C3984a6> function) {
        this.c = lg;
        this.f11226a = c4601z0;
        this.b = function;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void consume(String str) {
        Lg lg = this.c;
        C4601z0 c4601z0 = this.f11226a;
        String str2 = c4601z0.f11867a;
        String str3 = c4601z0.b;
        Integer numValueOf = Integer.valueOf(c4601z0.d);
        C4601z0 c4601z1 = this.f11226a;
        String str4 = c4601z1.e;
        C4157h4 c4157h4 = new C4157h4(str2, str3, numValueOf, str4, c4601z1.c);
        C3984a6 c3984a6 = (C3984a6) this.b.apply(str);
        G4 g4 = new G4(new Bl(), new F4(), null);
        lg.c.a(c4157h4, g4).a(c3984a6, g4);
        lg.c.a(numValueOf.intValue(), str3, str4);
    }
}
