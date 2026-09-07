package com.yandex.mobile.ads.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
final class yy extends Lambda implements Function0<Long> {
    final /* synthetic */ zy b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    yy(zy zyVar) {
        super(0);
        this.b = zyVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(this.b.f10865a.toMillis(zy.a(this.b)));
    }
}
