package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10485a;
    private final String b;
    private final Map<String, Object> c;
    private final Integer d;
    private final uy e;

    public vj1(String packageName, String url, LinkedHashMap linkedHashMap, Integer num, uy uyVar) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f10485a = packageName;
        this.b = url;
        this.c = linkedHashMap;
        this.d = num;
        this.e = uyVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vj1)) {
            return false;
        }
        vj1 vj1Var = (vj1) obj;
        return Intrinsics.areEqual(this.f10485a, vj1Var.f10485a) && Intrinsics.areEqual(this.b, vj1Var.b) && Intrinsics.areEqual(this.c, vj1Var.c) && Intrinsics.areEqual(this.d, vj1Var.d) && this.e == vj1Var.e;
    }

    public final int hashCode() {
        int iA = v3.a(this.b, this.f10485a.hashCode() * 31, 31);
        Map<String, Object> map = this.c;
        int iHashCode = (iA + (map == null ? 0 : map.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        uy uyVar = this.e;
        return iHashCode2 + (uyVar != null ? uyVar.hashCode() : 0);
    }

    public final String toString() {
        return "PreferredPackage(packageName=" + this.f10485a + ", url=" + this.b + ", extras=" + this.c + ", flags=" + this.d + ", launchMode=" + this.e + ")";
    }

    public final String d() {
        return this.f10485a;
    }

    public final String e() {
        return this.b;
    }

    public final Map<String, Object> a() {
        return this.c;
    }

    public final Integer b() {
        return this.d;
    }

    public final uy c() {
        return this.e;
    }
}
