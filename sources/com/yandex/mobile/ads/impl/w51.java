package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
final class w51 extends Lambda implements Function0<Bitmap> {
    final /* synthetic */ pj0 b;
    final /* synthetic */ uj0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    w51(pj0 pj0Var, uj0 uj0Var) {
        super(0);
        this.b = pj0Var;
        this.c = uj0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Bitmap invoke() {
        return this.b.b(this.c);
    }
}
