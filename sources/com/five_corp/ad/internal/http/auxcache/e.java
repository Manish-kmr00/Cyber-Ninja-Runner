package com.five_corp.ad.internal.http.auxcache;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1384a;
    public final /* synthetic */ i b;

    public e(i iVar, j jVar) {
        this.b = iVar;
        this.f1384a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (k kVar : this.f1384a.c) {
            kVar.g.remove(this.f1384a.f1389a);
        }
        this.b.a(this.f1384a);
    }
}
