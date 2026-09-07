package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ok implements rw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<rw0.c> f9825a = new ArrayList<>(1);
    private final HashSet<rw0.c> b = new HashSet<>(1);
    private final sw0.a c = new sw0.a();
    private final e40.a d = new e40.a();
    private Looper e;
    private b52 f;
    private ii1 g;

    protected void a() {
    }

    protected abstract void a(w62 w62Var);

    protected void b() {
    }

    protected abstract void e();

    protected final sw0.a b(int i, rw0.b bVar) {
        return this.c.a(i, bVar);
    }

    protected final sw0.a b(rw0.b bVar) {
        return this.c.a(0, bVar);
    }

    protected final boolean d() {
        return !this.b.isEmpty();
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(Handler handler, e40 e40Var) {
        this.d.a(handler, e40Var);
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void c(rw0.c cVar) {
        this.e.getClass();
        boolean zIsEmpty = this.b.isEmpty();
        this.b.add(cVar);
        if (zIsEmpty) {
            b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void b(rw0.c cVar) {
        boolean zIsEmpty = this.b.isEmpty();
        this.b.remove(cVar);
        if (zIsEmpty || !this.b.isEmpty()) {
            return;
        }
        a();
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(Handler handler, sw0 sw0Var) {
        this.c.a(handler, sw0Var);
    }

    protected final ii1 c() {
        ii1 ii1Var = this.g;
        if (ii1Var != null) {
            return ii1Var;
        }
        throw new IllegalStateException();
    }

    protected final e40.a a(int i, rw0.b bVar) {
        return this.d.a(i, bVar);
    }

    protected final e40.a a(rw0.b bVar) {
        return this.d.a(0, bVar);
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(rw0.c cVar, w62 w62Var, ii1 ii1Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        if (looper != null && looper != looperMyLooper) {
            throw new IllegalArgumentException();
        }
        this.g = ii1Var;
        b52 b52Var = this.f;
        this.f9825a.add(cVar);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.b.add(cVar);
            a(w62Var);
        } else if (b52Var != null) {
            c(cVar);
            cVar.a(this, b52Var);
        }
    }

    protected final void a(b52 b52Var) {
        this.f = b52Var;
        Iterator<rw0.c> it = this.f9825a.iterator();
        while (it.hasNext()) {
            it.next().a(this, b52Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(rw0.c cVar) {
        this.f9825a.remove(cVar);
        if (this.f9825a.isEmpty()) {
            this.e = null;
            this.f = null;
            this.g = null;
            this.b.clear();
            e();
            return;
        }
        b(cVar);
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(e40 e40Var) {
        this.d.e(e40Var);
    }

    @Override // com.yandex.mobile.ads.impl.rw0
    public final void a(sw0 sw0Var) {
        this.c.a(sw0Var);
    }
}
