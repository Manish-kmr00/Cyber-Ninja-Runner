package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class Q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Kb f11306a;

    public Q4() {
        this(C4486ua.j().k());
    }

    public static V4 a(O4 o4) {
        return new V4(new T4(o4), o4);
    }

    public Q4(Kb kb) {
        this.f11306a = kb;
    }

    public final Jm a(O4 o4, C4075dm c4075dm) {
        Jm jm = new Jm(o4, new C4567xg(c4075dm));
        Kb kb = this.f11306a;
        synchronized (kb) {
            kb.c.add(jm);
        }
        return jm;
    }
}
