package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes13.dex */
public final class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f2395a;

    public T(W w) {
        this.f2395a = w;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2395a.u.compareAndSet(false, true)) {
            this.f2395a.d("onCancelResult(true);");
            this.f2395a.v.set(false);
        }
    }
}
