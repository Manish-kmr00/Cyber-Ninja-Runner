package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
final class b91 extends Lambda implements Function1<pj0, oj0> {
    public static final b91 b = new b91();

    b91() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final oj0 invoke(pj0 pj0Var) {
        pj0 it = pj0Var;
        Intrinsics.checkNotNullParameter(it, "it");
        return new oj0(it, new nj0());
    }
}
