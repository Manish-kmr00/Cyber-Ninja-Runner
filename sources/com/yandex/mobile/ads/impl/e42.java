package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e42 {
    public static final e42 h = new e42(new c(y82.a(y82.g + " TaskRunner", true)));
    private static final Logger i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f8759a;
    private int b;
    private boolean c;
    private long d;
    private final ArrayList e;
    private final ArrayList f;
    private final f42 g;

    public interface a {
        long a();

        void a(e42 e42Var);

        void a(e42 e42Var, long j);

        void execute(Runnable runnable);
    }

    public static final class b {
        public static Logger a() {
            return e42.i;
        }
    }

    static {
        Logger logger = Logger.getLogger(e42.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        i = logger;
    }

    public e42(c backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.f8759a = backend;
        this.b = 10000;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new f42(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(a42 a42Var) {
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(a42Var.b());
        try {
            long jE = a42Var.e();
            synchronized (this) {
                a(a42Var, jE);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            synchronized (this) {
                a(a42Var, -1L);
                Unit unit2 = Unit.INSTANCE;
                threadCurrentThread.setName(name);
            }
        }
    }

    public final a42 b() {
        boolean z;
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.f.isEmpty()) {
            long jA = this.f8759a.a();
            Iterator it = this.f.iterator();
            long jMin = Long.MAX_VALUE;
            a42 a42Var = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                a42 a42Var2 = (a42) ((d42) it.next()).e().get(0);
                long jMax = Math.max(0L, a42Var2.c() - jA);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (a42Var != null) {
                        z = true;
                        break;
                    }
                    a42Var = a42Var2;
                }
            }
            if (a42Var != null) {
                a(a42Var);
                if (z || (!this.c && !this.f.isEmpty())) {
                    this.f8759a.execute(this.g);
                }
                return a42Var;
            }
            if (this.c) {
                if (jMin < this.d - jA) {
                    this.f8759a.a(this);
                }
                return null;
            }
            this.c = true;
            this.d = jA + jMin;
            try {
                try {
                    this.f8759a.a(this, jMin);
                } catch (InterruptedException unused) {
                    c();
                }
                this.c = false;
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
        return null;
    }

    public final void a(d42 taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.c() == null) {
            if (!taskQueue.e().isEmpty()) {
                y82.a(this.f, taskQueue);
            } else {
                this.f.remove(taskQueue);
            }
        }
        if (this.c) {
            this.f8759a.a(this);
        } else {
            this.f8759a.execute(this.g);
        }
    }

    public final a d() {
        return this.f8759a;
    }

    public final d42 e() {
        int i2;
        synchronized (this) {
            i2 = this.b;
            this.b = i2 + 1;
        }
        return new d42(this, "Q" + i2);
    }

    public final void c() {
        int size = this.e.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                ((d42) this.e.get(size)).b();
            }
        }
        for (int size2 = this.f.size() - 1; -1 < size2; size2--) {
            d42 d42Var = (d42) this.f.get(size2);
            d42Var.b();
            if (d42Var.e().isEmpty()) {
                this.f.remove(size2);
            }
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f8760a;

        public c(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.f8760a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // com.yandex.mobile.ads.impl.e42.a
        public final void a(e42 taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // com.yandex.mobile.ads.impl.e42.a
        public final void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.f8760a.execute(runnable);
        }

        @Override // com.yandex.mobile.ads.impl.e42.a
        public final void a(e42 taskRunner, long j) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        @Override // com.yandex.mobile.ads.impl.e42.a
        public final long a() {
            return System.nanoTime();
        }
    }

    private final void a(a42 a42Var) {
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        a42Var.a(-1L);
        d42 d42VarD = a42Var.d();
        Intrinsics.checkNotNull(d42VarD);
        d42VarD.e().remove(a42Var);
        this.f.remove(d42VarD);
        d42VarD.a(a42Var);
        this.e.add(d42VarD);
    }

    private final void a(a42 a42Var, long j) {
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        d42 d42VarD = a42Var.d();
        Intrinsics.checkNotNull(d42VarD);
        if (d42VarD.c() == a42Var) {
            boolean zD = d42VarD.d();
            d42VarD.i();
            d42VarD.a(null);
            this.e.remove(d42VarD);
            if (j != -1 && !zD && !d42VarD.g()) {
                d42VarD.a(a42Var, j, true);
            }
            if (d42VarD.e().isEmpty()) {
                return;
            }
            this.f.add(d42VarD);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
