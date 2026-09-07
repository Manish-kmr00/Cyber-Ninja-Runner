package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10610a;
    private final String b;
    private final String c;
    private final List<uj0> d;

    public x00(String type, String target, String layout, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.f10610a = type;
        this.b = target;
        this.c = layout;
        this.d = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x00)) {
            return false;
        }
        x00 x00Var = (x00) obj;
        return Intrinsics.areEqual(this.f10610a, x00Var.f10610a) && Intrinsics.areEqual(this.b, x00Var.b) && Intrinsics.areEqual(this.c, x00Var.c) && Intrinsics.areEqual(this.d, x00Var.d);
    }

    public final int hashCode() {
        int iA = v3.a(this.c, v3.a(this.b, this.f10610a.hashCode() * 31, 31), 31);
        List<uj0> list = this.d;
        return iA + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        return "Design(type=" + this.f10610a + ", target=" + this.b + ", layout=" + this.c + ", images=" + this.d + ")";
    }

    public final String d() {
        return this.f10610a;
    }

    public final String c() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final List<uj0> a() {
        return this.d;
    }
}
