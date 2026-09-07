package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2984f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1448a;

    public RunnableC2984f(x xVar) {
        this.f1448a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1448a;
        xVar.b.b(xVar.a());
    }
}
