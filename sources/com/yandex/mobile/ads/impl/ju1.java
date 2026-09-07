package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
final class ju1 extends Lambda implements Function1<an1, CharSequence> {
    public static final ju1 b = new ju1();

    ju1() {
        super(1);
    }

    public static String a(an1 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ CharSequence invoke(an1 an1Var) {
        return a(an1Var);
    }
}
