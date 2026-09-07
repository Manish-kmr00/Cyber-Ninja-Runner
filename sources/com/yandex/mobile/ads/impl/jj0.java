package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
final class jj0 implements qq1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9324a;
    final /* synthetic */ lj0 b;

    jj0(lj0 lj0Var, String str) {
        this.b = lj0Var;
        this.f9324a = str;
    }

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 ki2Var) {
        lj0 lj0Var = this.b;
        String str = this.f9324a;
        lj0.a aVar = (lj0.a) lj0Var.c.remove(str);
        if (aVar != null) {
            aVar.c = ki2Var;
            lj0Var.d.put(str, aVar);
            if (lj0Var.f == null) {
                kj0 kj0Var = new kj0(lj0Var);
                lj0Var.f = kj0Var;
                lj0Var.e.postDelayed(kj0Var, 100);
            }
        }
    }
}
