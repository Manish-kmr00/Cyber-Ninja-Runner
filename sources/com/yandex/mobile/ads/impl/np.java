package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class np extends pg<rp, String> {
    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) {
        String value = (String) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return pg.a(name, "string", new rp(rp.a.b, value));
    }
}
