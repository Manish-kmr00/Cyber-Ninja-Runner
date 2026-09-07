package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
final class vg2 extends Lambda implements Function1<fy.g, Unit> {
    final /* synthetic */ zg2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    vg2(zg2 zg2Var) {
        super(1);
        this.b = zg2Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(fy.g gVar) {
        fy.g uiUnit = gVar;
        Intrinsics.checkNotNullParameter(uiUnit, "uiUnit");
        this.b.f10816a.invoke(new zx.f(uiUnit));
        return Unit.INSTANCE;
    }
}
