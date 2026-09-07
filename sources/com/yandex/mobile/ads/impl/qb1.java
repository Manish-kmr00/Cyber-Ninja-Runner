package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
final class qb1 extends Lambda implements Function1<db2, rb2<gb1>> {
    public static final qb1 b = new qb1();

    qb1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final rb2<gb1> invoke(db2 db2Var) {
        db2 it = db2Var;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.b();
    }
}
