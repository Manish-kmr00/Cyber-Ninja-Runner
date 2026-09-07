package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes9.dex */
public final class bq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8532a;
    private final HashSet b;
    private final PriorityBlockingQueue<np1<?>> c;
    private final PriorityBlockingQueue<np1<?>> d;
    private final sm e;
    private final oc1 f;
    private final yq1 g;
    private final pc1[] h;
    private xm i;
    private final ArrayList j;
    private final ArrayList k;

    public interface a {
        void a(np1<?> np1Var, int i);
    }

    public interface b {
        boolean a(np1<?> np1Var);
    }

    @Deprecated
    public interface c<T> {
        void a();
    }

    public bq1(sm smVar, wk wkVar, int i) {
        this(smVar, wkVar, i, new e60(new Handler(Looper.getMainLooper())));
    }

    public final void a(np1 np1Var) {
        np1Var.a(this);
        synchronized (this.b) {
            this.b.add(np1Var);
        }
        np1Var.b(this.f8532a.incrementAndGet());
        np1Var.a("add-to-queue");
        a(np1Var, 0);
        if (np1Var.t()) {
            this.c.add(np1Var);
        } else {
            this.d.add(np1Var);
        }
    }

    public bq1(sm smVar, wk wkVar, int i, e60 e60Var) {
        this.f8532a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = smVar;
        this.f = wkVar;
        this.h = new pc1[i];
        this.g = e60Var;
    }

    public final void a(tp1 tp1Var) {
        synchronized (this.k) {
            this.k.add(tp1Var);
        }
    }

    public final void a(b bVar) {
        synchronized (this.b) {
            for (np1<?> np1Var : this.b) {
                if (bVar.a(np1Var)) {
                    np1Var.a();
                }
            }
        }
    }

    final <T> void b(np1<T> np1Var) {
        synchronized (this.b) {
            this.b.remove(np1Var);
        }
        synchronized (this.j) {
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a();
            }
        }
        a(np1Var, 5);
    }

    final void a(np1<?> np1Var, int i) {
        synchronized (this.k) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(np1Var, i);
            }
        }
    }

    public final void a() {
        xm xmVar = this.i;
        if (xmVar != null) {
            xmVar.b();
        }
        for (pc1 pc1Var : this.h) {
            if (pc1Var != null) {
                pc1Var.b();
            }
        }
        xm xmVar2 = new xm(this.c, this.d, this.e, this.g);
        this.i = xmVar2;
        xmVar2.start();
        for (int i = 0; i < this.h.length; i++) {
            pc1 pc1Var2 = new pc1(this.d, this.f, this.e, this.g);
            this.h[i] = pc1Var2;
            pc1Var2.start();
        }
    }
}
