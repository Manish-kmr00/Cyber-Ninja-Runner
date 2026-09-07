package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zy1 f8806a;

    protected ek(zy1 sizeInfo) {
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        this.f8806a = sizeInfo;
    }

    public final zy1 a() {
        return this.f8806a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ek) && Intrinsics.areEqual(((ek) obj).f8806a, this.f8806a);
    }

    public final int hashCode() {
        return this.f8806a.hashCode();
    }

    public final String toString() {
        return this.f8806a.toString();
    }
}
