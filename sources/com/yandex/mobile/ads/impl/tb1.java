package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
final class tb1 extends Lambda implements Function1<ax0, db2> {
    public static final tb1 b = new tb1();

    tb1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final db2 invoke(ax0 ax0Var) {
        ax0 it = ax0Var;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c();
    }
}
