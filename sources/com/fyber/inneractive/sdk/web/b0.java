package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f2401a;

    public b0(c0 c0Var) {
        this.f2401a = c0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2401a.f2403a.evictAll();
        } catch (Throwable unused) {
        }
    }
}
