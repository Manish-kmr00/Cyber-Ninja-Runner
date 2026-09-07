package com.mbridge.msdk.thrid.okhttp;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5506a;
    private final long b;
    private final Runnable c;
    private final Deque<com.mbridge.msdk.thrid.okhttp.internal.connection.c> d;
    final com.mbridge.msdk.thrid.okhttp.internal.connection.d e;
    boolean f;

    /* JADX INFO: compiled from: ConnectionPool.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long jA = h.this.a(System.nanoTime());
                if (jA == -1) {
                    return;
                }
                if (jA > 0) {
                    long j = jA / 1000000;
                    long j2 = jA - (1000000 * j);
                    synchronized (h.this) {
                        try {
                            h.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public h() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    @Nullable
    com.mbridge.msdk.thrid.okhttp.internal.connection.c a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, a0 a0Var) {
        if (!h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar : this.d) {
            if (cVar.a(aVar, a0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    void b(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
        if (!h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f) {
            this.f = true;
            g.execute(this.c);
        }
        this.d.add(cVar);
    }

    public h(int i, long j, TimeUnit timeUnit) {
        this.c = new a();
        this.d = new ArrayDeque();
        this.e = new com.mbridge.msdk.thrid.okhttp.internal.connection.d();
        this.f5506a = i;
        this.b = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    @Nullable
    Socket a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar) {
        if (!h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar : this.d) {
            if (cVar.a(aVar, null) && cVar.f() && cVar != gVar.c()) {
                return gVar.b(cVar);
            }
        }
        return null;
    }

    boolean a(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
        if (!h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!cVar.k && this.f5506a != 0) {
            notifyAll();
            return false;
        }
        this.d.remove(cVar);
        return true;
    }

    long a(long j) {
        synchronized (this) {
            com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2 : this.d) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.b;
            if (j2 < j4 && i <= this.f5506a) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.f = false;
                return -1L;
            }
            this.d.remove(cVar);
            com.mbridge.msdk.thrid.okhttp.internal.c.a(cVar.g());
            return 0L;
        }
    }

    private int a(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar, long j) {
        List<Reference<com.mbridge.msdk.thrid.okhttp.internal.connection.g>> list = cVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<com.mbridge.msdk.thrid.okhttp.internal.connection.g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a("A connection to " + cVar.c().a().k() + " was leaked. Did you forget to close a response body?", ((com.mbridge.msdk.thrid.okhttp.internal.connection.g.a) reference).f5523a);
                list.remove(i);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
