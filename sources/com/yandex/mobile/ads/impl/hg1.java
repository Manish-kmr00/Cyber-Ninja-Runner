package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class hg1 implements vw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gc0 f9091a;
    private i52 b;
    private t52 c;

    @Override // com.yandex.mobile.ads.impl.vw1
    public final void a(wf1 wf1Var) {
        i52 i52Var = this.b;
        if (i52Var == null) {
            throw new IllegalStateException();
        }
        int i = x82.f10629a;
        long jB = i52Var.b();
        long jC = this.b.c();
        if (jB == -9223372036854775807L || jC == -9223372036854775807L) {
            return;
        }
        gc0 gc0Var = this.f9091a;
        if (jC != gc0Var.q) {
            gc0 gc0VarA = gc0Var.a().a(jC).a();
            this.f9091a = gc0VarA;
            this.c.a(gc0VarA);
        }
        int iA = wf1Var.a();
        this.c.a(iA, wf1Var);
        this.c.a(jB, 1, iA, 0, null);
    }

    public hg1(String str) {
        this.f9091a = new gc0.a().e(str).a();
    }

    @Override // com.yandex.mobile.ads.impl.vw1
    public final void a(i52 i52Var, y70 y70Var, i72.d dVar) {
        this.b = i52Var;
        dVar.a();
        t52 t52VarA = y70Var.a(dVar.c(), 5);
        this.c = t52VarA;
        t52VarA.a(this.f9091a);
    }
}
