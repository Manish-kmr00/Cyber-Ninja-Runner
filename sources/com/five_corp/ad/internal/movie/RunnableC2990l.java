package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2990l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f1454a;
    public final /* synthetic */ x b;

    public RunnableC2990l(x xVar, u1 u1Var) {
        this.b = xVar;
        this.f1454a = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1454a.a(this.b.m);
        } catch (Throwable th) {
            this.b.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.t0, null, th, null));
        }
    }
}
