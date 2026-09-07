package com.mbridge.msdk.tracker.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f5651a;
    private final int e;
    private final com.mbridge.msdk.tracker.network.b f;
    private final m g;
    private final w h;
    private final AtomicInteger b = new AtomicInteger();
    private final Set<t<?>> c = new HashSet();
    private final PriorityBlockingQueue<t<?>> d = new PriorityBlockingQueue<>();
    private final List<c> i = new ArrayList();
    private boolean j = false;

    /* JADX INFO: compiled from: RequestQueue.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "NetworkDispatcher");
        }
    }

    /* JADX INFO: compiled from: RequestQueue.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new n(u.this.d, u.this.g, u.this.f, u.this.h).run();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface c {
        void a(t<?> tVar, int i);
    }

    public u(m mVar, w wVar, int i, com.mbridge.msdk.tracker.network.b bVar) {
        this.e = i;
        this.f = bVar;
        this.g = mVar;
        this.h = wVar;
    }

    private void a(int i) {
        if (this.f5651a != null) {
            return;
        }
        try {
            b(i);
        } catch (Throwable unused) {
            try {
                b(5);
            } catch (Exception unused2) {
                this.f5651a = null;
            }
        }
    }

    public void b() {
        if (!this.j || this.f5651a == null) {
            a(this.e);
            this.j = true;
        }
    }

    <T> void c(t<T> tVar) {
        synchronized (this.c) {
            this.c.remove(tVar);
        }
        a(tVar, 5);
    }

    <T> void d(t<T> tVar) {
        this.d.add(tVar);
    }

    private void b(int i) {
        this.f5651a = new ThreadPoolExecutor(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }

    <T> void b(t<T> tVar) {
        d(tVar);
    }

    public int a() {
        return this.b.incrementAndGet();
    }

    public <T> t<T> a(t<T> tVar) {
        tVar.a(this);
        synchronized (this.c) {
            this.c.add(tVar);
        }
        tVar.b(a());
        tVar.a("add-to-queue");
        a(tVar, 0);
        b(tVar);
        if (this.f5651a == null) {
            a(this.e);
        }
        if (!this.f5651a.isShutdown()) {
            this.f5651a.execute(new b());
        }
        return tVar;
    }

    void a(t<?> tVar, int i) {
        synchronized (this.i) {
            Iterator<c> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a(tVar, i);
            }
        }
    }
}
