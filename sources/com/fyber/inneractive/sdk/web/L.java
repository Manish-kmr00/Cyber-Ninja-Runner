package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes13.dex */
public final class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f2388a;

    public L(M m) {
        this.f2388a = m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        W w = this.f2388a.f2389a;
        if (w.y) {
            return;
        }
        w.e(w.k);
    }
}
