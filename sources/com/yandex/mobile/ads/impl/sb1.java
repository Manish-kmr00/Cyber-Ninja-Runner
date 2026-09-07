package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
final class sb1 extends Lambda implements Function1<c41, Set<? extends ax0>> {
    final /* synthetic */ pb1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    sb1(pb1 pb1Var) {
        super(1);
        this.b = pb1Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Set<? extends ax0> invoke(c41 c41Var) {
        c41 it = c41Var;
        Intrinsics.checkNotNullParameter(it, "it");
        this.b.f9910a.getClass();
        return cx0.a(it);
    }
}
