package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.w0;
import com.fyber.inneractive.sdk.util.x0;

/* JADX INFO: loaded from: classes10.dex */
public final class L implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f1780a;

    public L(N n) {
        this.f1780a = n;
    }

    @Override // com.fyber.inneractive.sdk.util.w0
    public final void a() {
        com.fyber.inneractive.sdk.util.r.b.post(this.f1780a.l);
        N n = this.f1780a;
        x0 x0Var = n.m;
        if (x0Var != null) {
            x0Var.e = null;
            n.m = null;
        }
        n.q = false;
    }
}
