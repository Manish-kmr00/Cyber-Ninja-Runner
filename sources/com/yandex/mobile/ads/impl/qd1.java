package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j62 f10006a;
    private final f92 b;

    public qd1(j62 notice, f92 validationResult) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        this.f10006a = notice;
        this.b = validationResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qd1)) {
            return false;
        }
        qd1 qd1Var = (qd1) obj;
        return Intrinsics.areEqual(this.f10006a, qd1Var.f10006a) && Intrinsics.areEqual(this.b, qd1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f10006a.hashCode() * 31);
    }

    public final String toString() {
        return "NoticeValidationHolder(notice=" + this.f10006a + ", validationResult=" + this.b + ")";
    }

    public final j62 a() {
        return this.f10006a;
    }

    public final f92 b() {
        return this.b;
    }
}
