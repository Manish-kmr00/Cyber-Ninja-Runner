package io.appmetrica.analytics.impl;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class H4 extends I4 {
    public H4(C4195ii c4195ii) {
        super(c4195ii);
    }

    public final void a(EnumC4164hb enumC4164hb, List<Gg> list) {
        if (!C9.h.contains(enumC4164hb)) {
            list.add(this.f11187a.s);
        }
        if (C9.b.contains(enumC4164hb)) {
            return;
        }
        list.add(this.f11187a.c);
    }
}
