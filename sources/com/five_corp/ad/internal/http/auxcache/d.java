package com.five_corp.ad.internal.http.auxcache;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1383a;

    public d(i iVar) {
        this.f1383a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f1383a;
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
