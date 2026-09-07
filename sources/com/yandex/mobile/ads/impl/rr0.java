package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class rr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<x> f10134a;
    private final j80 b;
    private final List<String> c;
    private final String d;
    private final long e;

    /* JADX WARN: Multi-variable type inference failed */
    public rr0(List<? extends x> list, j80 j80Var, List<String> trackingUrls, String str, long j) {
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        this.f10134a = list;
        this.b = j80Var;
        this.c = trackingUrls;
        this.d = str;
        this.e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rr0)) {
            return false;
        }
        rr0 rr0Var = (rr0) obj;
        return Intrinsics.areEqual(this.f10134a, rr0Var.f10134a) && Intrinsics.areEqual(this.b, rr0Var.b) && Intrinsics.areEqual(this.c, rr0Var.c) && Intrinsics.areEqual(this.d, rr0Var.d) && this.e == rr0Var.e;
    }

    public final int hashCode() {
        List<x> list = this.f10134a;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        j80 j80Var = this.b;
        int iA = aa.a(this.c, (iHashCode + (j80Var == null ? 0 : j80Var.hashCode())) * 31, 31);
        String str = this.d;
        return Long.hashCode(this.e) + ((iA + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Link(actions=" + this.f10134a + ", falseClick=" + this.b + ", trackingUrls=" + this.c + ", url=" + this.d + ", clickableDelay=" + this.e + ")";
    }

    public final List<x> a() {
        return this.f10134a;
    }

    public final j80 c() {
        return this.b;
    }

    public final List<String> d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }
}
