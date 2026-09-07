package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class Og extends Gg {
    public final Un b;

    public Og(C4282m5 c4282m5) {
        this(c4282m5, c4282m5.t());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        C4282m5 c4282m5 = this.f11164a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C4386q9 c4386q9 = c4282m5.n;
            c4386q9.c.b(C3984a6.a(c3984a6, EnumC4164hb.EVENT_TYPE_FIRST_ACTIVATION));
        }
        Un un = this.b;
        synchronized (un) {
            Vn vn = un.f11384a;
            vn.a(vn.a().put("first_event_done", true));
        }
        return false;
    }

    public Og(C4282m5 c4282m5, Un un) {
        super(c4282m5);
        this.b = un;
    }
}
