package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u22 extends pg<String, String> {
    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) {
        String value = (String) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return pg.a(name, "string", value);
    }
}
