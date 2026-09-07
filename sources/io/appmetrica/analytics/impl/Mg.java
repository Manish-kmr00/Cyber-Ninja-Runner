package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Mg extends Gg {
    public final IReporter b;

    public Mg(C4282m5 c4282m5, IReporter iReporter) {
        super(c4282m5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        Mc mc = (Mc) Mc.c.get(c3984a6.d);
        HashMap map = new HashMap();
        map.put("type", mc.f11257a);
        map.put("delivery_method", mc.b);
        this.b.reportEvent("crash_saved", map);
        return false;
    }
}
