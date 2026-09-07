package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes11.dex */
public final class e60 implements yq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f8764a;

    final class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f8765a;

        a(Handler handler) {
            this.f8765a = handler;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f8765a.post(runnable);
        }
    }

    public e60(Handler handler) {
        this.f8764a = new a(handler);
    }

    public final void a(np1<?> np1Var, ki2 ki2Var) {
        np1Var.a("post-error");
        qq1 qq1VarA = qq1.a(ki2Var);
        Executor executor = this.f8764a;
        ((a) executor).f8765a.post(new b(np1Var, qq1VarA, null));
    }

    private static class b implements Runnable {
        private final np1 b;
        private final qq1 c;
        private final Runnable d;

        public b(np1 np1Var, qq1 qq1Var, Runnable runnable) {
            this.b = np1Var;
            this.c = qq1Var;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.n()) {
                this.b.c("canceled-at-delivery");
                return;
            }
            qq1 qq1Var = this.c;
            ki2 ki2Var = qq1Var.c;
            if (ki2Var == null) {
                this.b.a(qq1Var.f10044a);
            } else {
                this.b.a(ki2Var);
            }
            if (this.c.d) {
                this.b.a("intermediate-response");
            } else {
                this.b.c("done");
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void a(np1<?> np1Var, qq1<?> qq1Var, Runnable runnable) {
        np1Var.o();
        np1Var.a("post-response");
        Executor executor = this.f8764a;
        ((a) executor).f8765a.post(new b(np1Var, qq1Var, runnable));
    }
}
