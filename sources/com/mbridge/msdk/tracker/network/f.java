package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes6.dex */
public class f implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f5631a;

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f5632a;

        a(Handler handler) {
            this.f5632a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f5632a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t f5633a;
        private final v b;
        private final Runnable c;

        public b(t tVar, v vVar, Runnable runnable) {
            this.f5633a = tVar;
            this.b = vVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5633a.v()) {
                this.f5633a.c("canceled-at-delivery");
                return;
            }
            if (this.b.a()) {
                this.f5633a.a(this.b.f5654a);
            } else {
                this.f5633a.b(this.b.c);
            }
            if (this.b.d) {
                this.f5633a.a("intermediate-response");
            } else {
                this.f5633a.c("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f5631a = new a(handler);
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, v<?> vVar) {
        a(tVar, vVar, null);
    }

    public void a(t<?> tVar, v<?> vVar, Runnable runnable) {
        tVar.w();
        tVar.a("post-response");
        this.f5631a.execute(new b(tVar, vVar, runnable));
    }

    public f(Executor executor) {
        this.f5631a = executor;
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, b0 b0Var) {
        tVar.a("post-error");
        this.f5631a.execute(new b(tVar, v.a(b0Var), null));
    }
}
