package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
final class bc2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ dc2 b;
    final /* synthetic */ wp1<ci2> c;
    final /* synthetic */ gi2 d;
    final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bc2(dc2 dc2Var, pm0 pm0Var, gi2 gi2Var, Object obj) {
        super(0);
        this.b = dc2Var;
        this.c = pm0Var;
        this.d = gi2Var;
        this.e = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        ii2 ii2Var = new ii2(this.b.b, this.c);
        g5 g5Var = this.b.b;
        f5 f5Var = f5.y;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        this.b.c.a(this.b.g, this.b.f8681a, this.d, this.e, ii2Var);
        return Unit.INSTANCE;
    }
}
