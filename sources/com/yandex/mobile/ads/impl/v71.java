package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f92.a f10456a;
    private final String b;

    public v71(f92.a validationStatus, String str) {
        Intrinsics.checkNotNullParameter(validationStatus, "validationStatus");
        this.f10456a = validationStatus;
        this.b = str;
    }

    public final f92.a b() {
        return this.f10456a;
    }

    public final String a() {
        return this.b;
    }
}
