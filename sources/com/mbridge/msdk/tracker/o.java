package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.tracker.network.b0;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Network.java */
/* JADX INFO: loaded from: classes7.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private r f5655a;
    private final int b;
    private final p c;
    private final w d;
    private final int e;
    private com.mbridge.msdk.tracker.network.u f;
    private final Executor g;

    /* JADX INFO: compiled from: Network.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeReportResponseThread");
        }
    }

    /* JADX INFO: compiled from: Network.java */
    private static final class b implements com.mbridge.msdk.tracker.network.v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f5657a;
        private final t b;

        public b(r rVar, t tVar) {
            this.f5657a = rVar;
            this.b = tVar;
        }

        @Override // com.mbridge.msdk.tracker.network.v.a
        public void a(b0 b0Var) {
            int iA;
            int iB;
            String message;
            if (y.a(this.f5657a)) {
                if (b0Var != null) {
                    try {
                        iA = b0Var.a();
                        iB = b0Var.b();
                        message = b0Var.getMessage();
                    } catch (Exception e) {
                        if (com.mbridge.msdk.tracker.a.f5612a) {
                            Log.e("TrackManager", "onErrorResponse error", e);
                            return;
                        }
                        return;
                    }
                } else {
                    message = "";
                    iA = 0;
                    iB = 0;
                }
                this.f5657a.a(this.b, 0, String.format("volleyError:%s,responseCode:%s,errorMessage:%s", Integer.valueOf(iA), Integer.valueOf(iB), message));
            }
        }
    }

    /* JADX INFO: compiled from: Network.java */
    private static final class c implements com.mbridge.msdk.tracker.network.v.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f5658a;
        private final t b;

        public c(r rVar, t tVar) {
            this.f5658a = rVar;
            this.b = tVar;
        }

        @Override // com.mbridge.msdk.tracker.network.v.b
        public void a(Object obj) {
            if (y.a(this.f5658a)) {
                try {
                    this.f5658a.a(this.b);
                } catch (Exception e) {
                    if (com.mbridge.msdk.tracker.a.f5612a) {
                        Log.e("TrackManager", "onResponse error", e);
                    }
                }
            }
        }
    }

    public o(int i, p pVar, w wVar, int i2) {
        this.b = i;
        this.c = pVar;
        this.d = wVar;
        this.e = i2;
        this.g = new ThreadPoolExecutor(i, i, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }

    public void a(r rVar) {
        this.f5655a = rVar;
    }

    public void b(t tVar, Map<String, String> map, boolean z) {
        if (y.b(map)) {
            r rVar = this.f5655a;
            if (rVar != null) {
                try {
                    rVar.a(tVar, 0, "params is null");
                    return;
                } catch (Exception e) {
                    if (com.mbridge.msdk.tracker.a.f5612a) {
                        Log.e("TrackManager", "send error", e);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        try {
            a();
            this.f.a(a(tVar, map, z));
        } catch (Exception e2) {
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", "send error", e2);
            }
            if (y.a(this.f5655a)) {
                this.f5655a.a(tVar, 0, e2.getMessage());
            }
        }
    }

    private v<Object> a(t tVar, Map<String, String> map, boolean z) {
        v<Object> vVar = this.e == 1 ? new v<>(this.c.c(), 1, this.c.a()) : new v<>(this.c.c(), 1);
        vVar.a(map);
        vVar.a(false);
        vVar.c(true);
        vVar.b(true);
        vVar.a(this.d);
        vVar.a(z ? com.mbridge.msdk.tracker.network.t.a.HIGH : com.mbridge.msdk.tracker.network.t.a.NORMAL);
        vVar.a((com.mbridge.msdk.tracker.network.v.b<Object>) new c(this.f5655a, tVar));
        vVar.a((com.mbridge.msdk.tracker.network.v.a) new b(this.f5655a, tVar));
        return vVar;
    }

    private void a() {
        if (y.a(this.f)) {
            return;
        }
        com.mbridge.msdk.tracker.network.u uVarA = com.mbridge.msdk.tracker.network.toolbox.o.a(new com.mbridge.msdk.tracker.network.toolbox.b(this.c.b()), new com.mbridge.msdk.tracker.network.f(this.g), this.b, null);
        this.f = uVarA;
        uVarA.b();
    }
}
