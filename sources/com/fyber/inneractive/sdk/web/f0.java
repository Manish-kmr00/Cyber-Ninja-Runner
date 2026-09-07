package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes12.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f2408a;

    public f0(j0 j0Var) {
        this.f2408a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3274m c3274m = this.f2408a.b;
        if (c3274m != null) {
            c3274m.getViewTreeObserver().addOnPreDrawListener(this.f2408a.K);
        }
    }
}
