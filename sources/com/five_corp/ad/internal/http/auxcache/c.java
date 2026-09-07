package com.five_corp.ad.internal.http.auxcache;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.context.l f1382a;
    public final /* synthetic */ i b;

    public c(i iVar, com.five_corp.ad.internal.context.l lVar) {
        this.b = iVar;
        this.f1382a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVarA = i.a(this.b, new com.five_corp.ad.internal.http.a(null, this.f1382a, 3));
        if (kVarA == null) {
            return;
        }
        this.b.k.b.addLast(kVarA);
        i.a(this.b);
    }
}
