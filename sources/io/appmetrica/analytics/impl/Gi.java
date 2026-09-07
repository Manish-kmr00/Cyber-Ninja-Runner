package io.appmetrica.analytics.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Gi implements InterfaceC4610z9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC4610z9
    public final Integer a(R8 r8) {
        EnumC4164hb enumC4164hb = r8.h;
        if (enumC4164hb != null) {
            return (Integer) Cf.c.get(enumC4164hb);
        }
        Map map = Cf.f11090a;
        return null;
    }
}
