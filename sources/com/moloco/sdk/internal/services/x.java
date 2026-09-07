package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6435a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final String i;
    public final float j;
    public final long k;

    public x(String manufacturer, String model, String hwVersion, boolean z, String os, String osVersion, int i, String language, String mobileCarrier, float f, long j) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(mobileCarrier, "mobileCarrier");
        this.f6435a = manufacturer;
        this.b = model;
        this.c = hwVersion;
        this.d = z;
        this.e = os;
        this.f = osVersion;
        this.g = i;
        this.h = language;
        this.i = mobileCarrier;
        this.j = f;
        this.k = j;
    }

    public final String a() {
        return this.f6435a;
    }

    public final float b() {
        return this.j;
    }

    public final long c() {
        return this.k;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.areEqual(this.f6435a, xVar.f6435a) && Intrinsics.areEqual(this.b, xVar.b) && Intrinsics.areEqual(this.c, xVar.c) && this.d == xVar.d && Intrinsics.areEqual(this.e, xVar.e) && Intrinsics.areEqual(this.f, xVar.f) && this.g == xVar.g && Intrinsics.areEqual(this.h, xVar.h) && Intrinsics.areEqual(this.i, xVar.i) && Float.compare(this.j, xVar.j) == 0 && this.k == xVar.k;
    }

    public final boolean f() {
        return this.d;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.f6435a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        boolean z = this.d;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((((iHashCode + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Float.hashCode(this.j)) * 31) + Long.hashCode(this.k);
    }

    public final int i() {
        return this.g;
    }

    public final String j() {
        return this.h;
    }

    public final String k() {
        return this.i;
    }

    public final int l() {
        return this.g;
    }

    public final long m() {
        return this.k;
    }

    public final String n() {
        return this.c;
    }

    public final String o() {
        return this.h;
    }

    public final String p() {
        return this.f6435a;
    }

    public final String q() {
        return this.i;
    }

    public final String r() {
        return this.b;
    }

    public final String s() {
        return this.e;
    }

    public final String t() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceInfo(manufacturer=");
        sb.append(this.f6435a).append(", model=").append(this.b).append(", hwVersion=").append(this.c).append(", isTablet=").append(this.d).append(", os=").append(this.e).append(", osVersion=").append(this.f).append(", apiLevel=").append(this.g).append(", language=").append(this.h).append(", mobileCarrier=").append(this.i).append(", screenDensity=").append(this.j).append(", dbtMs=").append(this.k).append(')');
        return sb.toString();
    }

    public final float u() {
        return this.j;
    }

    public final boolean v() {
        return this.d;
    }

    public final x a(String manufacturer, String model, String hwVersion, boolean z, String os, String osVersion, int i, String language, String mobileCarrier, float f, long j) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(mobileCarrier, "mobileCarrier");
        return new x(manufacturer, model, hwVersion, z, os, osVersion, i, language, mobileCarrier, f, j);
    }
}
