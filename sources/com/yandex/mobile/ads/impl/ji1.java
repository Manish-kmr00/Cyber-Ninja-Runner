package com.yandex.mobile.ads.impl;

import android.os.Looper;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class ji1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f9322a;
    private final a b;
    private final hp c;
    private int d;
    private Object e;
    private Looper f;
    private boolean g;
    private boolean h;
    private boolean i;

    public interface a {
    }

    public interface b {
        void a(int i, Object obj) throws j60;
    }

    public final synchronized void a(long j) throws InterruptedException, TimeoutException {
        boolean z;
        if (!this.g) {
            throw new IllegalStateException();
        }
        if (this.f.getThread() == Thread.currentThread()) {
            throw new IllegalStateException();
        }
        long jB = this.c.b() + j;
        while (true) {
            z = this.i;
            if (z || j <= 0) {
                break;
            }
            this.c.getClass();
            wait(j);
            j = jB - this.c.b();
        }
        if (!z) {
            throw new TimeoutException("Message delivery timed out.");
        }
    }

    public ji1(a aVar, b bVar, b52 b52Var, int i, hp hpVar, Looper looper) {
        this.b = aVar;
        this.f9322a = bVar;
        this.f = looper;
        this.c = hpVar;
    }

    public final b c() {
        return this.f9322a;
    }

    public final int d() {
        return this.d;
    }

    public final Object b() {
        return this.e;
    }

    public final Looper a() {
        return this.f;
    }

    public final ji1 e() {
        if (!this.g) {
            this.g = true;
            ((q60) this.b).c(this);
            return this;
        }
        throw new IllegalStateException();
    }

    public final synchronized void a(boolean z) {
        this.h = z | this.h;
        this.i = true;
        notifyAll();
    }

    public final ji1 a(Object obj) {
        if (!this.g) {
            this.e = obj;
            return this;
        }
        throw new IllegalStateException();
    }

    public final ji1 a(int i) {
        if (!this.g) {
            this.d = i;
            return this;
        }
        throw new IllegalStateException();
    }
}
