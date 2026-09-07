package com.five_corp.ad.internal.movie;

/* JADX INFO: loaded from: classes8.dex */
public final class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E f1428a;

    public C(E e) {
        this.f1428a = e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        E e = this.f1428a;
        e.f1429a.b(e.a());
    }
}
