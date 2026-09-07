package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class su0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10238a;
    private final float b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof su0)) {
            return false;
        }
        su0 su0Var = (su0) obj;
        return Intrinsics.areEqual(this.f10238a, su0Var.f10238a) && Float.compare(this.b, su0Var.b) == 0;
    }

    public final int hashCode() {
        String str = this.f10238a;
        return Float.hashCode(this.b) + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "Media(htmlContent=" + this.f10238a + ", aspectRatio=" + this.b + ")";
    }

    public su0(String str, float f) {
        this.f10238a = str;
        this.b = f;
    }

    public final String b() {
        return this.f10238a;
    }

    public final float a() {
        return this.b;
    }
}
