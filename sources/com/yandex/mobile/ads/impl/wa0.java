package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class wa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uj0 f10547a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof wa0) && Intrinsics.areEqual(this.f10547a, ((wa0) obj).f10547a);
    }

    public final int hashCode() {
        uj0 uj0Var = this.f10547a;
        if (uj0Var == null) {
            return 0;
        }
        return uj0Var.hashCode();
    }

    public final String toString() {
        return "FeedbackValue(imageValue=" + this.f10547a + ")";
    }

    public wa0(uj0 uj0Var) {
        this.f10547a = uj0Var;
    }

    public final uj0 a() {
        return this.f10547a;
    }
}
