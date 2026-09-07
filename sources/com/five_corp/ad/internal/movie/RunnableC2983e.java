package com.five_corp.ad.internal.movie;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC2983e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1439a;

    public RunnableC2983e(x xVar) {
        this.f1439a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1439a;
        xVar.b.c(xVar.a());
    }
}
