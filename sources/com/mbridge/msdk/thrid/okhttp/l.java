package com.mbridge.msdk.thrid.okhttp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    static final /* synthetic */ boolean h = true;

    @Nullable
    private Runnable c;

    @Nullable
    private ExecutorService d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5569a = 64;
    private int b = 5;
    private final Deque<v.b> e = new ArrayDeque();
    private final Deque<v.b> f = new ArrayDeque();
    private final Deque<v> g = new ArrayDeque();

    public l(ExecutorService executorService) {
        this.d = executorService;
    }

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    public void b(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        synchronized (this) {
            this.b = i;
        }
        b();
    }

    public synchronized int c() {
        return this.f.size() + this.g.size();
    }

    public void a(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f5569a = i;
            }
            b();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    private boolean b() {
        int i;
        boolean z;
        if (!h && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<v.b> it = this.e.iterator();
            while (it.hasNext()) {
                v.b next = it.next();
                if (this.f.size() >= this.f5569a) {
                    break;
                }
                if (b(next) < this.b) {
                    it.remove();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = c() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((v.b) arrayList.get(i)).a(a());
        }
        return z;
    }

    synchronized void a(v vVar) {
        this.g.add(vVar);
    }

    void a(v.b bVar) {
        a(this.f, bVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public l() {
    }

    private int b(v.b bVar) {
        int i = 0;
        for (v.b bVar2 : this.f) {
            if (!bVar2.c().f && bVar2.d().equals(bVar.d())) {
                i++;
            }
        }
        return i;
    }

    void b(v vVar) {
        a(this.g, vVar);
    }
}
