package com.five_corp.ad.internal.cache;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1339a;
    public final /* synthetic */ com.five_corp.ad.internal.util.f b;

    public d(e eVar, com.five_corp.ad.internal.util.f fVar) {
        this.f1339a = eVar;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1339a.a(this.b.b);
    }
}
