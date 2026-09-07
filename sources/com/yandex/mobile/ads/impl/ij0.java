package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes9.dex */
final class ij0 implements qq1.b<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9227a;
    final /* synthetic */ lj0 b;

    ij0(lj0 lj0Var, String str) {
        this.b = lj0Var;
        this.f9227a = str;
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public final void a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        lj0 lj0Var = this.b;
        String str = this.f9227a;
        lj0Var.b.a(str, bitmap2);
        lj0.a aVar = (lj0.a) lj0Var.c.remove(str);
        if (aVar != null) {
            aVar.b = bitmap2;
            lj0Var.d.put(str, aVar);
            if (lj0Var.f == null) {
                kj0 kj0Var = new kj0(lj0Var);
                lj0Var.f = kj0Var;
                lj0Var.e.postDelayed(kj0Var, 100);
            }
        }
    }
}
