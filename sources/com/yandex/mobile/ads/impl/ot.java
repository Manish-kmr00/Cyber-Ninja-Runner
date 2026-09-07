package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ut f9855a;
    private final qt b;
    private final qt c;
    private final qt d;
    private final zt e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final Float k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final boolean p;

    public ot() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ot)) {
            return false;
        }
        ot otVar = (ot) obj;
        return Intrinsics.areEqual(this.f9855a, otVar.f9855a) && Intrinsics.areEqual(this.b, otVar.b) && Intrinsics.areEqual(this.c, otVar.c) && Intrinsics.areEqual(this.d, otVar.d) && Intrinsics.areEqual(this.e, otVar.e) && Intrinsics.areEqual(this.f, otVar.f) && Intrinsics.areEqual(this.g, otVar.g) && Intrinsics.areEqual(this.h, otVar.h) && Intrinsics.areEqual(this.i, otVar.i) && Intrinsics.areEqual(this.j, otVar.j) && Intrinsics.areEqual((Object) this.k, (Object) otVar.k) && Intrinsics.areEqual(this.l, otVar.l) && Intrinsics.areEqual(this.m, otVar.m) && Intrinsics.areEqual(this.n, otVar.n) && Intrinsics.areEqual(this.o, otVar.o) && this.p == otVar.p;
    }

    public final int hashCode() {
        ut utVar = this.f9855a;
        int iHashCode = (utVar == null ? 0 : utVar.hashCode()) * 31;
        qt qtVar = this.b;
        int iHashCode2 = (iHashCode + (qtVar == null ? 0 : qtVar.hashCode())) * 31;
        qt qtVar2 = this.c;
        int iHashCode3 = (iHashCode2 + (qtVar2 == null ? 0 : qtVar2.hashCode())) * 31;
        qt qtVar3 = this.d;
        int iHashCode4 = (iHashCode3 + (qtVar3 == null ? 0 : qtVar3.hashCode())) * 31;
        zt ztVar = this.e;
        int iHashCode5 = (iHashCode4 + (ztVar == null ? 0 : ztVar.hashCode())) * 31;
        String str = this.f;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.h;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.i;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.j;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f = this.k;
        int iHashCode11 = (iHashCode10 + (f == null ? 0 : f.hashCode())) * 31;
        String str6 = this.l;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.m;
        int iHashCode13 = (iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.n;
        int iHashCode14 = (iHashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.o;
        return Boolean.hashCode(this.p) + ((iHashCode14 + (str9 != null ? str9.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "CoreNativeAdAssets(media=" + this.f9855a + ", favicon=" + this.b + ", icon=" + this.c + ", image=" + this.d + ", closeButton=" + this.e + ", age=" + this.f + ", body=" + this.g + ", callToAction=" + this.h + ", domain=" + this.i + ", price=" + this.j + ", rating=" + this.k + ", reviewCount=" + this.l + ", sponsored=" + this.m + ", title=" + this.n + ", warning=" + this.o + ", feedbackAvailable=" + this.p + ")";
    }

    public /* synthetic */ ot(int i) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false);
    }

    public final ut i() {
        return this.f9855a;
    }

    public final qt e() {
        return this.b;
    }

    public ot(ut utVar, qt qtVar, qt qtVar2, qt qtVar3, zt ztVar, String str, String str2, String str3, String str4, String str5, Float f, String str6, String str7, String str8, String str9, boolean z) {
        this.f9855a = utVar;
        this.b = qtVar;
        this.c = qtVar2;
        this.d = qtVar3;
        this.e = ztVar;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = f;
        this.l = str6;
        this.m = str7;
        this.n = str8;
        this.o = str9;
        this.p = z;
    }

    public final qt g() {
        return this.c;
    }

    public final qt h() {
        return this.d;
    }

    public final String a() {
        return this.f;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        return this.h;
    }

    public final String d() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final Float k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public final String o() {
        return this.o;
    }

    public final boolean f() {
        return this.p;
    }
}
