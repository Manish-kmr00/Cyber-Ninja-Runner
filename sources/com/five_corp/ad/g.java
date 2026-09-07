package com.five_corp.ad;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements com.five_corp.ad.internal.adselector.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1260a;
    public final /* synthetic */ com.five_corp.ad.internal.context.i b;
    public final /* synthetic */ com.five_corp.ad.internal.context.h c;
    public final /* synthetic */ i d;
    public final /* synthetic */ AdLoader e;

    public g(AdLoader adLoader, h hVar, com.five_corp.ad.internal.context.i iVar, com.five_corp.ad.internal.context.h hVar2, i iVar2) {
        this.e = adLoader;
        this.f1260a = hVar;
        this.b = iVar;
        this.c = hVar2;
        this.d = iVar2;
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public final void onAdSuccessfullySelected(com.five_corp.ad.internal.context.l lVar) {
        this.e.a(this.f1260a, lVar);
    }

    @Override // com.five_corp.ad.internal.adselector.b
    public final void onFailureToSelectAd(com.five_corp.ad.internal.o oVar) {
        this.e.b(this.d, oVar, null, this.b, this.c);
    }
}
