package com.five_corp.ad.internal.cache;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1344a;
    public final /* synthetic */ o b;

    public j(o oVar, n nVar) {
        this.b = oVar;
        this.f1344a = nVar;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.five_corp.ad.internal.cache.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.five_corp.ad.internal.cache.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.five_corp.ad.internal.cache.n, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        boolean zIsEmpty;
        synchronized (this.b.f1347a) {
            o oVar = this.b;
            if (oVar.f) {
                this.f1344a.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.T5, null, null, null));
                return;
            }
            com.five_corp.ad.internal.storage.a aVar = oVar.d;
            com.five_corp.ad.internal.util.g gVarA = aVar.f1525a.a(aVar.b, new byte[0]);
            if (!gVarA.f1560a) {
                this.f1344a.a(gVarA.b);
                return;
            }
            synchronized (this.b.f1347a) {
                zIsEmpty = this.b.g.isEmpty();
                this.b.e = true;
            }
            this.f1344a.b();
            if (zIsEmpty) {
                return;
            }
            o oVar2 = this.b;
            oVar2.b.post(new k(oVar2));
        }
    }
}
