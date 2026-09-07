package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {
    public static final int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6571a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f6571a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String a() {
        return this.f6571a;
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
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.f6571a, iVar.f6571a) && Intrinsics.areEqual(this.b, iVar.b) && Intrinsics.areEqual(this.c, iVar.c) && Intrinsics.areEqual(this.d, iVar.d) && Intrinsics.areEqual(this.e, iVar.e) && Intrinsics.areEqual(this.f, iVar.f) && Intrinsics.areEqual(this.g, iVar.g);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.f6571a;
    }

    public int hashCode() {
        String str = this.f6571a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String i() {
        return this.b;
    }

    public final String j() {
        return this.c;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.d;
    }

    public final String m() {
        return this.f;
    }

    public final String n() {
        return this.g;
    }

    public String toString() {
        return "DEC(appIconUri=" + this.f6571a + ", appName=" + this.b + ", ctaText=" + this.c + ", ctaUrl=" + this.d + ", ctaTrackingUrl=" + this.e + ", impressionTrackingUrl=" + this.f + ", skipToDECTrackingUrl=" + this.g + ')';
    }

    public final i a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new i(str, str2, str3, str4, str5, str6, str7);
    }

    public static /* synthetic */ i a(i iVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iVar.f6571a;
        }
        if ((i & 2) != 0) {
            str2 = iVar.b;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = iVar.c;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = iVar.d;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = iVar.e;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = iVar.f;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = iVar.g;
        }
        return iVar.a(str, str8, str9, str10, str11, str12, str7);
    }
}
