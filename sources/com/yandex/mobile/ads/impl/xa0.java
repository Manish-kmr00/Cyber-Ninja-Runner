package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class xa0 extends pg<wa0, uj0> {
    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) {
        uj0 value = (uj0) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return pg.a(name, "feedback", new wa0(value));
    }
}
