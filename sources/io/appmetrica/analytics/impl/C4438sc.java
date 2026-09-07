package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.sc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4438sc extends AbstractC4102f {
    public C4438sc(Context context, C4393qg c4393qg) {
        super(context, c4393qg);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4102f
    public final void b(C3984a6 c3984a6, G4 g4) {
        boolean zBooleanValue = ((Boolean) WrapUtils.getOrDefault(g4.b.b, Boolean.FALSE)).booleanValue();
        Pb pbL = C4486ua.E.l();
        pbL.a(zBooleanValue);
        pbL.a(g4.b.c);
        Boolean bool = g4.b.n;
        if (bool != null) {
            C4486ua.E.b().b(bool.booleanValue());
        }
        this.b.a(c3984a6, g4);
    }
}
