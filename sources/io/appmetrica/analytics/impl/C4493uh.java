package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.uh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4493uh implements InterfaceC4555x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4307n5 f11803a;

    public C4493uh(InterfaceC4307n5 interfaceC4307n5) {
        this.f11803a = interfaceC4307n5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4555x4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4368pg a(Context context, C4431s5 c4431s5, C4157h4 c4157h4, G4 g4) {
        C4393qg c4393qg;
        C4108f5 c4108f5 = new C4108f5(c4157h4.b, c4157h4.f11579a);
        C4417rg c4417rg = new C4417rg(this.f11803a);
        synchronized (c4431s5) {
            c4393qg = (C4393qg) c4431s5.a(c4108f5, g4, c4417rg, c4431s5.f11759a);
        }
        return new C4368pg(context, c4393qg);
    }
}
