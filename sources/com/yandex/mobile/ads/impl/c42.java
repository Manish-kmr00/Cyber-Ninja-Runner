package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
public final class c42 extends a42 {
    final /* synthetic */ Function0<Unit> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c42(String str, eh0.c cVar) {
        super(str, true);
        this.e = cVar;
    }

    @Override // com.yandex.mobile.ads.impl.a42
    public final long e() {
        this.e.invoke();
        return -1L;
    }
}
