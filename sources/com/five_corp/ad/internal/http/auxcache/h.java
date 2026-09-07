package com.five_corp.ad.internal.http.auxcache;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1387a;
    public final /* synthetic */ i b;

    public h(i iVar, Object obj) {
        this.b = iVar;
        this.f1387a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1387a.equals(this.b.f)) {
            i iVar = this.b;
            iVar.f = null;
            if (iVar.g) {
                return;
            }
            iVar.g = true;
            iVar.i.b();
            iVar.j.b();
            iVar.k.b();
            iVar.a((j) null);
        }
    }
}
