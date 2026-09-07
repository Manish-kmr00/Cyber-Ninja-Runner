package com.five_corp.ad.internal.cache;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1341a;
    public final /* synthetic */ com.five_corp.ad.internal.o b;

    public g(e eVar, com.five_corp.ad.internal.o oVar) {
        this.f1341a = eVar;
        this.b = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1341a.a(this.b);
    }
}
