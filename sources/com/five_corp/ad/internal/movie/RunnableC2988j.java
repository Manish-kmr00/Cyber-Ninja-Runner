package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2988j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2989k f1452a;

    public RunnableC2988j(C2989k c2989k) {
        this.f1452a = c2989k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1452a.b;
        com.five_corp.ad.internal.view.E e = xVar.b;
        xVar.a();
        e.a(this.f1452a.f1453a);
    }
}
