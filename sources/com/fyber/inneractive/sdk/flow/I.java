package com.fyber.inneractive.sdk.flow;

/* JADX INFO: loaded from: classes10.dex */
public final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f1777a;

    public I(J j) {
        this.f1777a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        N n = this.f1777a.b;
        n.d(!n.t);
        this.f1777a.b.n = null;
    }
}
