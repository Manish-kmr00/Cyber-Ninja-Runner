package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class hw1 implements or1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9143a;
    private final String b;

    public hw1(int i, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f9143a = i;
        this.b = type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hw1)) {
            return false;
        }
        hw1 hw1Var = (hw1) obj;
        return this.f9143a == hw1Var.f9143a && Intrinsics.areEqual(this.b, hw1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f9143a) * 31);
    }

    public final String toString() {
        return "SdkReward(amount=" + this.f9143a + ", type=" + this.b + ")";
    }

    @Override // com.yandex.mobile.ads.impl.or1
    public final int getAmount() {
        return this.f9143a;
    }

    @Override // com.yandex.mobile.ads.impl.or1
    public final String getType() {
        return this.b;
    }
}
