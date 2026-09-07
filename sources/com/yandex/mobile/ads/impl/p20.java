package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q20 f9889a;
    private final String b;

    public p20(q20 type, String assetName) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        this.f9889a = type;
        this.b = assetName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p20)) {
            return false;
        }
        p20 p20Var = (p20) obj;
        return this.f9889a == p20Var.f9889a && Intrinsics.areEqual(this.b, p20Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9889a.hashCode() * 31);
    }

    public final String toString() {
        return "DivKitAsset(type=" + this.f9889a + ", assetName=" + this.b + ")";
    }

    public final String a() {
        return this.b;
    }

    public final q20 b() {
        return this.f9889a;
    }
}
