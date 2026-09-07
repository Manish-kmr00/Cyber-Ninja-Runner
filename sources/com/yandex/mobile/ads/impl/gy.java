package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class gy {
    private static final String b = "https://mobile.yandexadexchange.net";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l50 f9044a;

    public gy(l50 environmentConfiguration) {
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        this.f9044a = environmentConfiguration;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        String strA = this.f9044a.a();
        if (strA == null) {
            strA = b;
        }
        sb.append(strA);
        Character chLastOrNull = StringsKt.lastOrNull(sb);
        if (chLastOrNull == null || chLastOrNull.charValue() != '/') {
            sb.append('/');
        }
        sb.append("v1/debugpanel");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
