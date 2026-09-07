package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes12.dex */
public final class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f2411a;

    public h0(j0 j0Var) {
        this.f2411a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.measurement.tracker.f fVar;
        j0 j0Var = this.f2411a;
        if (j0Var.H == null || (fVar = j0Var.I) == null) {
            return;
        }
        fVar.c();
    }
}
