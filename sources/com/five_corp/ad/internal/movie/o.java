package com.five_corp.ad.internal.movie;

/* JADX INFO: loaded from: classes5.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2989k f1457a;
    public final /* synthetic */ x b;

    public o(x xVar, C2989k c2989k) {
        this.b = xVar;
        this.f1457a = c2989k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1457a.a(this.b.m);
        } catch (Throwable th) {
            this.b.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.t0, null, th, null));
        }
    }
}
