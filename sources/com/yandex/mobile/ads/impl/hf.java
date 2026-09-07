package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class hf {
    public static boolean a(df appMetricaIdentifiers) {
        Intrinsics.checkNotNullParameter(appMetricaIdentifiers, "appMetricaIdentifiers");
        String strA = appMetricaIdentifiers.a();
        String strB = appMetricaIdentifiers.b();
        String strC = appMetricaIdentifiers.c();
        if (strC == null || strC.length() == 0) {
            return false;
        }
        if (strA == null || strA.length() == 0) {
            return false;
        }
        return !(strB == null || strB.length() == 0);
    }
}
