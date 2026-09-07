package com.five_corp.ad.internal.movie;

/* JADX INFO: loaded from: classes8.dex */
public final class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E f1427a;

    public B(E e) {
        this.f1427a = e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        E e = this.f1427a;
        e.f1429a.c(e.a());
    }
}
