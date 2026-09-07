package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10050a;
    private final ru0 b;

    public qu0(int i, ru0 mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f10050a = i;
        this.b = mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qu0)) {
            return false;
        }
        qu0 qu0Var = (qu0) obj;
        return this.f10050a == qu0Var.f10050a && this.b == qu0Var.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f10050a) * 31);
    }

    public final String toString() {
        return "MeasuredSizeSpec(value=" + this.f10050a + ", mode=" + this.b + ")";
    }

    public final int b() {
        return this.f10050a;
    }

    public final ru0 a() {
        return this.b;
    }
}
