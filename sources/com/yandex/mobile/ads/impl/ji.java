package com.yandex.mobile.ads.impl;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hl1 f9319a = new hl1();

    public final boolean a() {
        String strA = this.f9319a.a();
        if (strA == null || !(StringsKt.endsWith$default(strA, ":Metrica", false, 2, (Object) null) || StringsKt.endsWith$default(strA, ":AppMetrica", false, 2, (Object) null))) {
            return false;
        }
        String str = "Auxiliary process '" + strA + "' detected";
        op0.d(new Object[0]);
        return true;
    }
}
