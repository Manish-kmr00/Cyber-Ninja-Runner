package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public final class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1778a;
    public final /* synthetic */ N b;

    public J(N n, long j) {
        this.b = n;
        this.f1778a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.G()) {
            N n = this.b;
            n.n = new I(this);
            long jA = n.a(this.f1778a);
            N n2 = this.b;
            n2.getClass();
            x0 x0Var = new x0(TimeUnit.MILLISECONDS, jA);
            n2.o = x0Var;
            x0Var.e = new M(n2);
            v0 v0Var = new v0(x0Var);
            x0Var.c = v0Var;
            x0Var.d = false;
            v0Var.sendEmptyMessage(1932593528);
            N n3 = this.b;
            n3.getClass();
            IAlog.a("%sad contains custom close. Will show transparent x in %d", IAlog.a(n3), Long.valueOf(jA));
            this.b.l = null;
        } else {
            N n4 = this.b;
            n4.getClass();
            IAlog.a("%sad does not contain custom close. Showing close button", IAlog.a(n4));
            this.b.d(false);
        }
        Runnable runnable = this.b.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.b.l = null;
        }
    }
}
