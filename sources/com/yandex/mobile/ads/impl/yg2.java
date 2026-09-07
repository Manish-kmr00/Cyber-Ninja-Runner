package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
final class yg2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ zg2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    yg2(zg2 zg2Var) {
        super(1);
        this.b = zg2Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        String id = str;
        Intrinsics.checkNotNullParameter(id, "id");
        this.b.f10816a.invoke(new zx.b(id));
        return Unit.INSTANCE;
    }
}
