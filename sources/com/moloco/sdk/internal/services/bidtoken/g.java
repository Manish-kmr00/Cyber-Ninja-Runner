package com.moloco.sdk.internal.services.bidtoken;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6318a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public g(String language, String osVersion, String make, String model, String hardwareVersion) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hardwareVersion, "hardwareVersion");
        this.f6318a = language;
        this.b = osVersion;
        this.c = make;
        this.d = model;
        this.e = hardwareVersion;
    }

    public final String a() {
        return this.f6318a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
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
        return Intrinsics.areEqual(this.f6318a, gVar.f6318a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e);
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f6318a;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((this.f6318a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.b;
    }

    public String toString() {
        return "BidTokenDeviceRequestInfo(language=" + this.f6318a + ", osVersion=" + this.b + ", make=" + this.c + ", model=" + this.d + ", hardwareVersion=" + this.e + ')';
    }

    public final g a(String language, String osVersion, String make, String model, String hardwareVersion) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hardwareVersion, "hardwareVersion");
        return new g(language, osVersion, make, model, hardwareVersion);
    }

    public static /* synthetic */ g a(g gVar, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gVar.f6318a;
        }
        if ((i & 2) != 0) {
            str2 = gVar.b;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = gVar.c;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = gVar.d;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = gVar.e;
        }
        return gVar.a(str, str6, str7, str8, str5);
    }
}
