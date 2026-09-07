package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class rr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10133a;
    private final gq b;

    public rr(iw1 sdkSettings, gq cmpSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(cmpSettings, "cmpSettings");
        this.f10133a = sdkSettings;
        this.b = cmpSettings;
    }

    public final xw a() {
        String strC;
        String strA;
        boolean zD = this.f10133a.d();
        Boolean boolF = this.f10133a.f();
        Boolean boolJ = this.f10133a.j();
        String strB = this.b.b();
        return new xw(zD, boolF, boolJ, ((strB == null || StringsKt.isBlank(strB)) && ((strC = this.b.c()) == null || StringsKt.isBlank(strC)) && ((strA = this.b.a()) == null || StringsKt.isBlank(strA))) ? false : true);
    }
}
