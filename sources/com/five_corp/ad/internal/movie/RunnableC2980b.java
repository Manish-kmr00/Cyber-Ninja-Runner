package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2980b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1436a;

    public RunnableC2980b(x xVar) {
        this.f1436a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1436a;
        xVar.b.a(xVar.a());
    }
}
