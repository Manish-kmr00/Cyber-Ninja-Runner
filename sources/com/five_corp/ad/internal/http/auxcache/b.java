package com.five_corp.ad.internal.http.auxcache;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.context.l f1381a;
    public final /* synthetic */ i b;

    public b(i iVar, com.five_corp.ad.internal.context.l lVar) {
        this.b = iVar;
        this.f1381a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVarA = i.a(this.b, new com.five_corp.ad.internal.http.a(null, this.f1381a, 2));
        if (kVarA == null) {
            return;
        }
        this.b.j.b.addLast(kVarA);
        i.a(this.b);
    }
}
