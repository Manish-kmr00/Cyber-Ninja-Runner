package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4022bj implements InterfaceC4555x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC4555x4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Xi a(Context context, C4431s5 c4431s5, C4157h4 c4157h4, G4 g4) {
        C4393qg c4393qg;
        C4108f5 c4108f5 = new C4108f5(c4157h4.b, c4157h4.f11579a);
        synchronized (c4431s5) {
            c4393qg = (C4393qg) c4431s5.f11759a.get(c4108f5.toString());
        }
        return new Xi(c4393qg);
    }
}
