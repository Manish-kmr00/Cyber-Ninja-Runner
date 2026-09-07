package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rr0 f10161a;
    private final String b;
    private final u02 c;

    public s02(rr0 link, String name, u02 value) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f10161a = link;
        this.b = name;
        this.c = value;
    }

    public final rr0 a() {
        return this.f10161a;
    }

    public final String b() {
        return this.b;
    }

    public final u02 c() {
        return this.c;
    }
}
