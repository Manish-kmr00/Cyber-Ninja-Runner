package com.yandex.mobile.ads.impl;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pc1 extends Thread {
    private final BlockingQueue<np1<?>> b;
    private final oc1 c;
    private final sm d;
    private final yq1 e;
    private volatile boolean f = false;

    public pc1(PriorityBlockingQueue priorityBlockingQueue, oc1 oc1Var, sm smVar, yq1 yq1Var) {
        this.b = priorityBlockingQueue;
        this.c = oc1Var;
        this.d = smVar;
        this.e = yq1Var;
    }

    public final void b() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    boolean z = li2.f9524a;
                    op0.b(new Object[0]);
                }
            } catch (Throwable unused2) {
                boolean z2 = li2.f9524a;
                op0.b(new Object[0]);
                return;
            }
        }
    }

    private void a() throws InterruptedException {
        np1<?> np1VarTake = this.b.take();
        SystemClock.elapsedRealtime();
        np1VarTake.a(3);
        try {
            try {
                np1VarTake.a("network-queue-take");
                if (np1VarTake.n()) {
                    np1VarTake.c("network-discard-cancelled");
                    np1VarTake.p();
                } else {
                    TrafficStats.setThreadStatsTag(np1VarTake.k());
                    tc1 tc1VarA = this.c.a(np1VarTake);
                    np1VarTake.a("network-http-complete");
                    if (tc1VarA.e && np1VarTake.m()) {
                        np1VarTake.c("not-modified");
                        np1VarTake.p();
                    } else {
                        qq1<?> qq1VarA = np1VarTake.a(tc1VarA);
                        np1VarTake.a("network-parse-complete");
                        if (np1VarTake.t() && qq1VarA.b != null) {
                            this.d.a(np1VarTake.d(), qq1VarA.b);
                            np1VarTake.a("network-cache-written");
                        }
                        np1VarTake.o();
                        ((e60) this.e).a(np1VarTake, qq1VarA, null);
                        np1VarTake.a(qq1VarA);
                    }
                }
            } catch (ki2 e) {
                SystemClock.elapsedRealtime();
                ((e60) this.e).a(np1VarTake, np1VarTake.b(e));
                np1VarTake.p();
            } catch (Exception e2) {
                Object[] args = {e2.toString()};
                boolean z = li2.f9524a;
                int i = op0.b;
                Intrinsics.checkNotNullParameter(args, "args");
                ki2 ki2Var = new ki2((Throwable) e2);
                SystemClock.elapsedRealtime();
                ((e60) this.e).a(np1VarTake, ki2Var);
                np1VarTake.p();
            }
        } finally {
            np1VarTake.a(4);
        }
    }
}
