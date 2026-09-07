package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
final class kj0 implements Runnable {
    final /* synthetic */ lj0 b;

    kj0(lj0 lj0Var) {
        this.b = lj0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (lj0.a aVar : this.b.d.values()) {
            for (lj0.c cVar : aVar.d) {
                lj0.d dVar = cVar.b;
                if (dVar != null) {
                    ki2 ki2Var = aVar.c;
                    if (ki2Var == null) {
                        cVar.f9530a = aVar.b;
                        dVar.a(cVar, false);
                    } else {
                        dVar.a(ki2Var);
                    }
                }
            }
        }
        this.b.d.clear();
        this.b.f = null;
    }
}
