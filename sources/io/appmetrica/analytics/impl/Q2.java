package io.appmetrica.analytics.impl;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC4392qf f11304a;
    public final La b;

    public Q2(AbstractC4392qf abstractC4392qf, La la) {
        this.f11304a = abstractC4392qf;
        this.b = la;
    }

    public final boolean a(C3984a6 c3984a6, P2 p2) {
        Iterator it = ((C4012b9) this.f11304a.a(c3984a6.d)).f11476a.iterator();
        while (it.hasNext()) {
            if (p2.a(it.next(), c3984a6)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC4392qf b() {
        return this.f11304a;
    }

    public final La a() {
        return this.b;
    }
}
