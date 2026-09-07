package com.five_corp.ad.internal;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements com.five_corp.ad.internal.hub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.context.g f1411a;
    public final z b;
    public final com.five_corp.ad.internal.cache.w c;
    public final com.five_corp.ad.internal.bgtask.b d;
    public final com.five_corp.ad.internal.http.d e;
    public final l f;
    public final Object g = new Object();
    public boolean h = false;
    public com.five_corp.ad.internal.cache.x i;

    public j(com.five_corp.ad.internal.context.g gVar, z zVar, com.five_corp.ad.internal.cache.w wVar, com.five_corp.ad.internal.bgtask.b bVar, com.five_corp.ad.internal.http.d dVar, l lVar, com.five_corp.ad.internal.cache.x xVar, com.five_corp.ad.internal.hub.a aVar) {
        this.f1411a = gVar;
        this.b = zVar;
        this.c = wVar;
        this.d = bVar;
        this.e = dVar;
        this.f = lVar;
        this.i = xVar;
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(com.five_corp.ad.internal.cache.x xVar) {
        synchronized (this.g) {
            this.i = xVar;
        }
    }

    public final void a(int i) {
        synchronized (this.g) {
            if (this.h) {
                return;
            }
            this.h = true;
            this.d.a(new h(this.f1411a, this.b, this.c, this.e, this.f, i, this));
        }
    }
}
