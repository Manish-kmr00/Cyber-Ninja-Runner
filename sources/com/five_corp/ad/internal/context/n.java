package com.five_corp.ad.internal.context;

/* JADX INFO: loaded from: classes11.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.system.e f1366a;
    public final com.five_corp.ad.internal.tracking_data.e b;

    public n(com.five_corp.ad.internal.system.e eVar, com.five_corp.ad.internal.tracking_data.e eVar2) {
        this.f1366a = eVar;
        this.b = eVar2;
    }

    public final o a() {
        boolean zA = this.f1366a.a();
        synchronized (this.b.f1554a) {
        }
        return new o(zA);
    }
}
