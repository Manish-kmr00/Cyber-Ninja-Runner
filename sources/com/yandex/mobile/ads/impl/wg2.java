package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
final class wg2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ zg2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    wg2(zg2 zg2Var) {
        super(1);
        this.b = zg2Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String str) {
        String message = str;
        Intrinsics.checkNotNullParameter(message, "message");
        this.b.f10816a.invoke(new zx.h(message));
        return Unit.INSTANCE;
    }
}
