package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes6.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<t<?>> f5636a;
    private final m b;
    private final b c;
    private final w d;
    private volatile boolean e = false;

    public n(BlockingQueue<t<?>> blockingQueue, m mVar, b bVar, w wVar) {
        this.f5636a = blockingQueue;
        this.b = mVar;
        this.c = bVar;
        this.d = wVar;
    }

    private void a(t<?> tVar) {
        TrafficStats.setThreadStatsTag(tVar.s());
    }

    void b(t<?> tVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        tVar.a(3);
        try {
            try {
                tVar.a("network-queue-take");
                if (tVar.v()) {
                    tVar.c("network-discard-cancelled");
                    tVar.x();
                    return;
                }
                if (tVar.y()) {
                    a(tVar);
                }
                q qVarA = this.b.a(tVar);
                tVar.a("network-http-complete");
                if (qVarA.e && tVar.u()) {
                    tVar.c("not-modified");
                    tVar.x();
                    return;
                }
                v<?> vVarA = tVar.a(qVarA);
                tVar.a("network-parse-complete");
                if (tVar.z() && vVarA.b != null) {
                    this.c.a(tVar.e(), vVarA.b);
                    tVar.a("network-cache-written");
                }
                tVar.w();
                this.d.a(tVar, vVarA);
                tVar.a(vVarA);
            } catch (b0 e) {
                e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                a(tVar, e);
                tVar.x();
            } catch (Exception e2) {
                c0.a(e2, "Unhandled exception %s", e2.toString());
                a0 a0Var = new a0(e2);
                a0Var.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.d.a(tVar, a0Var);
                tVar.x();
            }
        } finally {
            tVar.a(4);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                c0.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void a() throws InterruptedException {
        b(this.f5636a.take());
    }

    private void a(t<?> tVar, b0 b0Var) {
        this.d.a(tVar, tVar.c(b0Var));
    }
}
