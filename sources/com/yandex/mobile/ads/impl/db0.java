package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
final class db0 extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final db0 b = new db0();

    db0() {
        super(1);
    }

    public static String a(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return a(entry);
    }
}
