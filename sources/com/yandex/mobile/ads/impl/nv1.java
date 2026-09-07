package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
final class nv1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ pv1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    nv1(pv1 pv1Var) {
        super(1);
        this.b = pv1Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        this.b.f9952a.a();
        return Unit.INSTANCE;
    }
}
