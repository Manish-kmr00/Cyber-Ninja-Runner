package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yo1 implements rl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zo1 f10759a;
    final /* synthetic */ ub1 b;
    final /* synthetic */ ap1 c;

    yo1(zo1 zo1Var, ub1 ub1Var, ap1 ap1Var) {
        this.f10759a = zo1Var;
        this.b = ub1Var;
        this.c = ap1Var;
    }

    @Override // com.yandex.mobile.ads.impl.rl.b
    public final void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        xo1 xo1Var = this.f10759a.d;
        ub1 ub1Var = this.b;
        ap1 ap1Var = this.c;
        xo1Var.getClass();
        xo1.a(ub1Var, ap1Var, bitmap);
    }
}
