package com.five_corp.ad.internal.http.movcache;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1401a;

    public e(h hVar) {
        this.f1401a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f1401a;
        hVar.i = null;
        hVar.c();
    }
}
