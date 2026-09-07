package com.fyber.inneractive.sdk.network;

import android.os.Process;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes7.dex */
public final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L f1908a;

    public I(L l) {
        this.f1908a = l;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        U u;
        boolean z;
        C3125a c3125aG;
        O oA;
        Throwable th;
        P p;
        L l = this.f1908a;
        l.getClass();
        Process.setThreadPriority(10);
        while (l.b) {
            O o = null;
            try {
                u = (U) l.f1910a.take();
            } catch (InterruptedException unused) {
                if (!l.b) {
                    Thread.currentThread().interrupt();
                }
                u = null;
            }
            if (u != null && !u.f1914a) {
                i0 i0Var = i0.RUNNING;
                u.f = i0Var;
                if (i0Var == i0.QUEUED_FOR_RETRY && (p = u.d) != null) {
                    p.a("sdkRequestEndedButWillBeRetried");
                }
                if (u.o) {
                    Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.l) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.l.class)).c("should_manage_request_watchdog");
                    if (boolC != null ? boolC.booleanValue() : true) {
                        z = true;
                    } else if (u.t()) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (u.t()) {
                    z = true;
                } else {
                    z = false;
                }
                IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a(l), Boolean.valueOf(z));
                if (z) {
                    j0 j0Var = l.f;
                    Thread threadCurrentThread = Thread.currentThread();
                    j0Var.getClass();
                    IAlog.a("%s : NetworkRequestWatchdog : register request: %s", IAlog.a(j0Var), u.g);
                    int iQ = u.q();
                    l0 l0VarN = u.n();
                    n0 n0Var = new n0(u, threadCurrentThread, l0VarN.f1925a + l0VarN.b + iQ);
                    j0Var.f1922a.putIfAbsent(u.g, n0Var);
                    com.fyber.inneractive.sdk.util.r.b.postDelayed(n0Var.d, n0Var.c);
                }
                try {
                    c3125aG = (u.f1914a || u.f() == null) ? null : u.g();
                } catch (Exception e) {
                    IAlog.a("failed fetching cache data", e, new Object[0]);
                    if (!u.f1914a) {
                        u.a((Object) null, e, true);
                    }
                }
                if (c3125aG != null && c3125aG.b != null && !u.f1914a) {
                    u.a(c3125aG.b, (Exception) null, true);
                }
                try {
                    C3136l c3136lA = l.a(u, c3125aG);
                    oA = l.a(u, c3136lA);
                    try {
                        try {
                            L.a(u, c3136lA, oA);
                            L.a(u, oA);
                            L.a(u);
                            l.c(u);
                        } catch (t0 unused2) {
                            o = oA;
                            oA = o;
                            L.a(u, oA);
                            L.a(u);
                            l.c(u);
                        } catch (Exception e2) {
                            e = e2;
                            if (!u.f1914a) {
                                u.a((Object) null, e, false);
                            }
                            L.a(u, oA);
                            L.a(u);
                            l.c(u);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        L.a(u, oA);
                        L.a(u);
                        l.c(u);
                        throw th;
                    }
                } catch (t0 unused3) {
                } catch (Exception e3) {
                    e = e3;
                    oA = null;
                } catch (Throwable th3) {
                    oA = null;
                    th = th3;
                }
            }
        }
    }
}
