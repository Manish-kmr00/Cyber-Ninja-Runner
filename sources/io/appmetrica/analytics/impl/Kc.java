package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class Kc implements J8, W8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S6 f11223a;
    public final Fg b;
    public final AtomicLong c;

    public Kc(S6 s6, Fg fg) {
        this.f11223a = s6;
        this.b = fg;
        this.c = new AtomicLong(s6.a());
        s6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void a(List<Integer> list) {
        this.c.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.J8
    public final boolean b() {
        return this.c.get() >= ((long) ((C4045ch) this.b.a()).i);
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void a() {
        this.c.set(this.f11223a.a());
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void b(List<Integer> list) {
        this.c.addAndGet(-list.size());
    }
}
