package com.yandex.mobile.ads.impl;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
final class w82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<gc0> f10543a;
    private final t52[] b;

    public w82(List<gc0> list) {
        this.f10543a = list;
        this.b = new t52[list.size()];
    }

    public final void a(long j, wf1 wf1Var) {
        if (wf1Var.a() < 9) {
            return;
        }
        int iH = wf1Var.h();
        int iH2 = wf1Var.h();
        int iT = wf1Var.t();
        if (iH == 434 && iH2 == 1195456820 && iT == 3) {
            co.b(j, wf1Var, this.b);
        }
    }

    public final void a(y70 y70Var, i72.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            t52 t52VarA = y70Var.a(dVar.c(), 3);
            gc0 gc0Var = this.f10543a.get(i);
            String str = gc0Var.m;
            hg.a("Invalid closed caption mime type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
            t52VarA.a(new gc0.a().b(dVar.b()).e(str).m(gc0Var.e).d(gc0Var.d).a(gc0Var.E).a(gc0Var.o).a());
            this.b[i] = t52VarA;
        }
    }
}
