package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
final class rb1 extends Lambda implements Function1<rb2<gb1>, String> {
    public static final rb1 b = new rb1();

    rb1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(rb2<gb1> rb2Var) {
        rb2<gb1> it = rb2Var;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.d().getUrl();
    }
}
