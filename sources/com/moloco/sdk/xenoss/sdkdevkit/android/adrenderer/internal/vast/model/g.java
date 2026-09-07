package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static final int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6893a;
    public final Integer b;
    public final String c;
    public final String d;
    public final h e;

    public g(String str, Integer num, String str2, String str3, h child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.f6893a = str;
        this.b = num;
        this.c = str2;
        this.d = str3;
        this.e = child;
    }

    public final String a() {
        return this.f6893a;
    }

    public final Integer b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final h e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.f6893a, gVar.f6893a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e);
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final h h() {
        return this.e;
    }

    public int hashCode() {
        String str = this.f6893a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.e.hashCode();
    }

    public final String i() {
        return this.f6893a;
    }

    public final Integer j() {
        return this.b;
    }

    public String toString() {
        return "Creative(id=" + this.f6893a + ", sequence=" + this.b + ", adId=" + this.c + ", apiFramework=" + this.d + ", child=" + this.e + ')';
    }

    public final g a(String str, Integer num, String str2, String str3, h child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return new g(str, num, str2, str3, child);
    }

    public static /* synthetic */ g a(g gVar, String str, Integer num, String str2, String str3, h hVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gVar.f6893a;
        }
        if ((i & 2) != 0) {
            num = gVar.b;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str2 = gVar.c;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = gVar.d;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            hVar = gVar.e;
        }
        return gVar.a(str, num2, str4, str5, hVar);
    }
}
