package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.w0;
import com.fyber.inneractive.sdk.util.x0;

/* JADX INFO: loaded from: classes10.dex */
public final class M implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f1781a;

    public M(N n) {
        this.f1781a = n;
    }

    @Override // com.fyber.inneractive.sdk.util.w0
    public final void a() {
        Runnable runnable = this.f1781a.n;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.post(runnable);
        }
        N n = this.f1781a;
        x0 x0Var = n.o;
        if (x0Var != null) {
            x0Var.e = null;
            n.o = null;
        }
    }
}
