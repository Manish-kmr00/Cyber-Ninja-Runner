package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uj0 f10345a;
    private final String b;

    public u02(uj0 imageValue, String title) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Intrinsics.checkNotNullParameter(title, "title");
        this.f10345a = imageValue;
        this.b = title;
    }

    public final uj0 a() {
        return this.f10345a;
    }

    public final String b() {
        return this.b;
    }
}
