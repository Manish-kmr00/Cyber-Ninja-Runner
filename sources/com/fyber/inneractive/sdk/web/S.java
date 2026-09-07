package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes13.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f2394a;

    public S(W w) {
        this.f2394a = w;
    }

    public final void a(boolean z) {
        if (this.f2394a.u.compareAndSet(false, true)) {
            this.f2394a.d("onCancelResult(" + z + ");");
            this.f2394a.v.set(false);
        }
    }
}
