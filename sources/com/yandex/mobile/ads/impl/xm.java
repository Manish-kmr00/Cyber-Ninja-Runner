package com.yandex.mobile.ads.impl;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes6.dex */
public final class xm extends Thread {
    private static final boolean h = li2.f9524a;
    private final BlockingQueue<np1<?>> b;
    private final BlockingQueue<np1<?>> c;
    private final sm d;
    private final yq1 e;
    private volatile boolean f = false;
    private final zi2 g;

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (h) {
            op0.e(new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                op0.b(new Object[0]);
            } catch (Throwable unused2) {
                op0.b(new Object[0]);
                return;
            }
        }
    }

    public xm(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, sm smVar, yq1 yq1Var) {
        this.b = priorityBlockingQueue;
        this.c = priorityBlockingQueue2;
        this.d = smVar;
        this.e = yq1Var;
        this.g = new zi2(this, priorityBlockingQueue2, yq1Var);
    }

    public final void b() {
        this.f = true;
        interrupt();
    }

    private void a() throws InterruptedException {
        np1<?> np1VarTake = this.b.take();
        np1VarTake.a("cache-queue-take");
        np1VarTake.a(1);
        try {
            if (np1VarTake.n()) {
                np1VarTake.c("cache-discard-canceled");
            } else {
                sm.a aVar = this.d.get(np1VarTake.d());
                if (aVar == null) {
                    np1VarTake.a("cache-miss");
                    if (!this.g.a(np1VarTake)) {
                        this.c.put(np1VarTake);
                    }
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (aVar.e < jCurrentTimeMillis) {
                        np1VarTake.a("cache-hit-expired");
                        np1VarTake.a(aVar);
                        if (!this.g.a(np1VarTake)) {
                            this.c.put(np1VarTake);
                        }
                    } else {
                        np1VarTake.a("cache-hit");
                        qq1<?> qq1VarA = np1VarTake.a(new tc1(200, aVar.f10218a, aVar.g, false));
                        np1VarTake.a("cache-hit-parsed");
                        if (qq1VarA.c != null) {
                            np1VarTake.a("cache-parsing-failed");
                            this.d.a(np1VarTake.d());
                            np1VarTake.a((sm.a) null);
                            if (!this.g.a(np1VarTake)) {
                                this.c.put(np1VarTake);
                            }
                        } else if (aVar.f < jCurrentTimeMillis) {
                            np1VarTake.a("cache-hit-refresh-needed");
                            np1VarTake.a(aVar);
                            qq1VarA.d = true;
                            if (!this.g.a(np1VarTake)) {
                                ((e60) this.e).a(np1VarTake, qq1VarA, new wm(this, np1VarTake));
                            } else {
                                ((e60) this.e).a(np1VarTake, qq1VarA, null);
                            }
                        } else {
                            ((e60) this.e).a(np1VarTake, qq1VarA, null);
                        }
                    }
                }
            }
        } finally {
            np1VarTake.a(2);
        }
    }
}
