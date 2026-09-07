package com.five_corp.ad.internal.context;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements com.five_corp.ad.internal.cache.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.time.c f1357a;
    public final /* synthetic */ e b;
    public final /* synthetic */ l c;
    public final /* synthetic */ f d;

    public c(com.five_corp.ad.internal.time.c cVar, e eVar, l lVar, f fVar) {
        this.f1357a = cVar;
        this.b = eVar;
        this.c = lVar;
        this.d = fVar;
    }

    @Override // com.five_corp.ad.internal.cache.m
    public final void a(com.five_corp.ad.internal.o oVar) {
        if (this.f1357a.b()) {
            this.d.a(oVar);
        }
    }

    @Override // com.five_corp.ad.internal.cache.m
    public final void a(String str) {
        if (this.f1357a.b()) {
            this.b.a(this.c);
        }
    }
}
