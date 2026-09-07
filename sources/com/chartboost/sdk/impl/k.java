package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb f1054a;

    public k(zb zbVar) {
        this.f1054a = zbVar;
    }

    public static k a(p pVar) {
        zb zbVar = (zb) pVar;
        ld.a(pVar, "AdSession is null");
        ld.g(zbVar);
        ld.b(zbVar);
        k kVar = new k(zbVar);
        zbVar.f().a(kVar);
        return kVar;
    }

    public void b() {
        ld.a(this.f1054a);
        ld.e(this.f1054a);
        this.f1054a.p();
    }

    public void a() {
        ld.b(this.f1054a);
        ld.e(this.f1054a);
        if (!this.f1054a.j()) {
            try {
                this.f1054a.b();
            } catch (Exception unused) {
            }
        }
        if (this.f1054a.j()) {
            this.f1054a.o();
        }
    }

    public void a(cb cbVar) {
        ld.a(cbVar, "VastProperties is null");
        ld.a(this.f1054a);
        ld.e(this.f1054a);
        this.f1054a.a(cbVar.a());
    }
}
