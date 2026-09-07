package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qu0 f9950a;
    private final qu0 b;

    public pu0(qu0 width, qu0 height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        this.f9950a = width;
        this.b = height;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pu0)) {
            return false;
        }
        pu0 pu0Var = (pu0) obj;
        return Intrinsics.areEqual(this.f9950a, pu0Var.f9950a) && Intrinsics.areEqual(this.b, pu0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9950a.hashCode() * 31);
    }

    public final String toString() {
        return "MeasuredSize(width=" + this.f9950a + ", height=" + this.b + ")";
    }

    public final qu0 b() {
        return this.f9950a;
    }

    public final qu0 a() {
        return this.b;
    }
}
