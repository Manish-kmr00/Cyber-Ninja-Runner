package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2982d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1438a;

    public RunnableC2982d(x xVar) {
        this.f1438a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1438a;
        com.five_corp.ad.internal.view.E e = xVar.b;
        int iA = xVar.a();
        com.five_corp.ad.f fVar = e.d;
        fVar.o.p(iA, fVar.t);
    }
}
