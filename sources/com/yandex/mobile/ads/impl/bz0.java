package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class bz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab2 f8550a;

    public bz0(ab2 versionParser) {
        Intrinsics.checkNotNullParameter(versionParser, "versionParser");
        this.f8550a = versionParser;
    }

    public final boolean a(String current, String str) {
        Intrinsics.checkNotNullParameter(current, "current");
        if (str == null || StringsKt.isBlank(str)) {
            return true;
        }
        this.f8550a.getClass();
        za2 za2VarA = ab2.a(current);
        if (za2VarA == null) {
            return true;
        }
        this.f8550a.getClass();
        za2 za2VarA2 = ab2.a(str);
        return za2VarA2 == null || za2VarA.compareTo(za2VarA2) >= 0;
    }
}
