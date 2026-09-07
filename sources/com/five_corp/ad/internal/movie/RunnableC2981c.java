package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2981c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1437a;

    public RunnableC2981c(x xVar) {
        this.f1437a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1437a;
        com.five_corp.ad.internal.view.E e = xVar.b;
        int iA = xVar.a();
        com.five_corp.ad.f fVar = e.d;
        fVar.s.a();
        fVar.o.u(iA, fVar.t);
    }
}
