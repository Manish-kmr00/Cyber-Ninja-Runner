package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4115fc implements InterfaceC4555x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC4555x4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final L4 a(Context context, C4431s5 c4431s5, C4157h4 c4157h4, G4 g4) {
        O4 o4;
        M4 m4 = new M4(c4157h4.b);
        P4 p4 = new P4();
        synchronized (c4431s5) {
            o4 = (O4) c4431s5.a(m4, g4, p4, c4431s5.b);
        }
        return new L4(context, o4, g4);
    }
}
