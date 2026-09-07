package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mn2 f9891a;

    private p3(mn2 mn2Var) {
        this.f9891a = mn2Var;
    }

    public static p3 a(mn2 mn2Var) {
        if (mn2Var.j().c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
        if (mn2Var.k()) {
            throw new IllegalStateException("AdSession is finished");
        }
        p3 p3Var = new p3(mn2Var);
        mn2Var.j().a(p3Var);
        return p3Var;
    }

    public final void a() {
        if (!this.f9891a.k()) {
            if (this.f9891a.l()) {
                if (!this.f9891a.g()) {
                    try {
                        this.f9891a.b();
                    } catch (Exception unused) {
                    }
                }
                if (this.f9891a.g()) {
                    this.f9891a.e();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public final void a(y92 y92Var) {
        oo2.a(this.f9891a);
        if (this.f9891a.l()) {
            this.f9891a.a(y92Var.a());
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
