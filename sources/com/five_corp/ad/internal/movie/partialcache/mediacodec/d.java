package com.five_corp.ad.internal.movie.partialcache.mediacodec;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f1485a;
    public final /* synthetic */ h b;

    public d(h hVar, a aVar) {
        this.b = hVar;
        this.f1485a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.b;
        if (hVar.d != 2) {
            return;
        }
        a aVar = this.f1485a;
        if (hVar.f1489a.a(hVar, aVar)) {
            return;
        }
        hVar.b.postDelayed(new d(hVar, aVar), 100L);
    }
}
