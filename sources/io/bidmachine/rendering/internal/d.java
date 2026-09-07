package io.bidmachine.rendering.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f12357a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicBoolean k = new AtomicBoolean(false);

    @Override // io.bidmachine.rendering.internal.c
    public void a() {
        this.d.set(true);
        this.f12357a.set(false);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean b() {
        return this.f12357a.get() && !l();
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean c() {
        return this.b.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean d() {
        return this.c.get();
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean e() {
        return this.h.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean f() {
        return this.g.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean g() {
        return this.i.get();
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean h() {
        return this.f.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean i() {
        return this.i.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean j() {
        return this.k.compareAndSet(false, true);
    }

    @Override // io.bidmachine.rendering.internal.c
    public void k() {
        this.c.set(true);
    }

    public boolean l() {
        return this.d.get();
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean a(boolean z) {
        this.b.set(false);
        this.f12357a.set(z);
        return this.e.compareAndSet(false, true) && !l();
    }

    @Override // io.bidmachine.rendering.internal.c
    public boolean b(boolean z) {
        return this.j.compareAndSet(!z, z);
    }
}
