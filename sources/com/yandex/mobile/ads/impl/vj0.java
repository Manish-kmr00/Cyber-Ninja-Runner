package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vj0 extends pg<uj0, uj0> {
    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) {
        uj0 value = (uj0) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return pg.a(name, "image", value);
    }
}
