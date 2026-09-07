package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v22 implements vg<String> {
    @Override // com.yandex.mobile.ads.impl.vg
    public final boolean a(String str) {
        String value = str;
        Intrinsics.checkNotNullParameter(value, "value");
        return value.length() > 0 && !Intrinsics.areEqual("null", value);
    }
}
