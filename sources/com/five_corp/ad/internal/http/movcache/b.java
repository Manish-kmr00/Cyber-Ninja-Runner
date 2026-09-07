package com.five_corp.ad.internal.http.movcache;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.context.l f1398a;
    public final /* synthetic */ h b;

    public b(h hVar, com.five_corp.ad.internal.context.l lVar) {
        this.b = hVar;
        this.f1398a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.five_corp.ad.internal.util.f fVarA = h.a(this.b, new com.five_corp.ad.internal.http.a(null, this.f1398a, 2));
        if (fVarA.f1560a && ((Boolean) fVarA.c).booleanValue()) {
            h.a(this.b);
        }
    }
}
