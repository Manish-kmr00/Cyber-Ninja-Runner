package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ci2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<p2> f8614a;

    public ci2(String version, ArrayList adBreaks, ArrayList extensions) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.f8614a = adBreaks;
    }

    public final List<p2> a() {
        return this.f8614a;
    }
}
