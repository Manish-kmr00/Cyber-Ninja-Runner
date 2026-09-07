package com.five_corp.ad.internal.http.movcache;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.http.a f1405a;

    public j(com.five_corp.ad.internal.http.a aVar) {
        this.f1405a = aVar;
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final int a() {
        return this.f1405a.c;
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void a(int i, boolean z, l lVar, boolean z2) {
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void a(byte[] bArr, int i, int i2, int i3) {
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void b() {
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void c() {
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean d() {
        com.five_corp.ad.internal.http.a aVar = this.f1405a;
        com.five_corp.ad.internal.context.l lVar = (com.five_corp.ad.internal.context.l) aVar.b.get();
        com.five_corp.ad.internal.ad.a aVar2 = lVar != null ? lVar.b : (com.five_corp.ad.internal.ad.a) aVar.f1379a.get();
        if (aVar2 == null || !this.f1405a.a()) {
            return false;
        }
        return !aVar2.a();
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean e() {
        return this.f1405a.a();
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean a(int i) {
        com.five_corp.ad.internal.http.a aVar = this.f1405a;
        com.five_corp.ad.internal.context.l lVar = (com.five_corp.ad.internal.context.l) aVar.b.get();
        com.five_corp.ad.internal.ad.a aVar2 = lVar != null ? lVar.b : (com.five_corp.ad.internal.ad.a) aVar.f1379a.get();
        if (aVar2 == null || !this.f1405a.a()) {
            return false;
        }
        return !aVar2.a() || ((long) i) < aVar2.g.b;
    }
}
