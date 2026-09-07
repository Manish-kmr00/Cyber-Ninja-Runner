package com.bykv.vk.openvk.preload.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: Interceptor.java */
/* JADX INFO: loaded from: classes13.dex */
public abstract class d<IN, OUT> {
    private static AtomicLong d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f899a;
    IN b;
    OUT c;
    private com.bykv.vk.openvk.preload.b.b.a e;
    private b f;
    private long g;

    public abstract Object a(b<OUT> bVar, IN in) throws Throwable;

    protected void a(Object... objArr) {
    }

    final void a(b bVar, d dVar, IN in, com.bykv.vk.openvk.preload.b.b.a aVar, Object[] objArr) {
        this.f = new c(bVar);
        this.f899a = dVar;
        this.b = in;
        this.e = aVar;
        if (dVar != null) {
            this.g = dVar.g;
        } else {
            long andIncrement = d.getAndIncrement();
            this.g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    public final long b() {
        return this.g;
    }

    final void c() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f, this);
    }

    final void d() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f, this);
    }

    final void e() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f, this);
    }

    final void b(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f, this, th);
    }

    final void c(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f, this, th);
    }

    protected final void d(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f, this, th);
    }

    public final OUT f() {
        return this.c;
    }
}
