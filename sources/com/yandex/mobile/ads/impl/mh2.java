package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class mh2 {
    public static String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        String string2 = StringsKt.trim((CharSequence) string).toString();
        return string2.length() > 0 ? "yma_" + string2 : "";
    }
}
