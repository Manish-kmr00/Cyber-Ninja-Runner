package com.five_corp.ad.internal.bgtask;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f1332a;
    public final com.five_corp.ad.internal.logger.a b;
    public long c = 0;
    public int d = 0;

    public g(m mVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1332a = mVar;
        this.b = aVar;
    }

    public final int a() {
        this.f1332a.toString();
        try {
            if (!this.f1332a.b()) {
                if (this.d < 3) {
                    this.f1332a.toString();
                    return 2;
                }
                this.f1332a.toString();
                this.f1332a.a();
                return 3;
            }
            this.f1332a.toString();
            com.five_corp.ad.internal.j jVar = this.f1332a.b;
            if (jVar == null) {
                return 1;
            }
            synchronized (jVar.g) {
                try {
                    jVar.h = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return 1;
        } catch (Exception e) {
            this.f1332a.toString();
            this.b.a(e);
            this.f1332a.a();
            return 3;
        }
    }
}
