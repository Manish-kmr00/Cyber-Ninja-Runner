package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xu0 extends pg<ax0, ax0> {
    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) {
        ax0 value = (ax0) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return pg.a(name, "media", value);
    }
}
