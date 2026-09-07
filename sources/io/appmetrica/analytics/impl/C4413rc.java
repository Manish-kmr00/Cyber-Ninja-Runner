package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.rc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4413rc implements InterfaceC4555x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC4555x4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4438sc a(Context context, C4431s5 c4431s5, C4157h4 c4157h4, G4 g4) {
        C4393qg c4393qg;
        C4463tc c4463tc = new C4463tc(c4157h4.b, c4157h4.f11579a);
        C4417rg c4417rg = new C4417rg(new C4538wc());
        synchronized (c4431s5) {
            c4393qg = (C4393qg) c4431s5.a(c4463tc, g4, c4417rg, c4431s5.f11759a);
        }
        return new C4438sc(context, c4393qg);
    }
}
