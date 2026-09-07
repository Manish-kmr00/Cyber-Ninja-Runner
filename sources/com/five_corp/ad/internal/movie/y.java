package com.five_corp.ad.internal.movie;

/* JADX INFO: loaded from: classes5.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.o f1514a;
    public final /* synthetic */ E b;

    public y(E e, com.five_corp.ad.internal.o oVar) {
        this.b = e;
        this.f1514a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        E e = this.b;
        com.five_corp.ad.internal.view.E e2 = e.f1429a;
        e.a();
        e2.a(this.f1514a);
    }
}
