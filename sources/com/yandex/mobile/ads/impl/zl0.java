package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10825a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zl0)) {
            return false;
        }
        zl0 zl0Var = (zl0) obj;
        return Intrinsics.areEqual(this.f10825a, zl0Var.f10825a) && Intrinsics.areEqual(this.b, zl0Var.b) && Intrinsics.areEqual(this.c, zl0Var.c) && Intrinsics.areEqual(this.d, zl0Var.d) && Intrinsics.areEqual(this.e, zl0Var.e);
    }

    public final int hashCode() {
        String str = this.f10825a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        return "InstreamAdInfo(adId=" + this.f10825a + ", creativeId=" + this.b + ", bannerId=" + this.c + ", data=" + this.d + ", advertiserInfo=" + this.e + ")";
    }

    public zl0(String str, String str2, String str3, String str4, String str5) {
        this.f10825a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final String a() {
        return this.f10825a;
    }

    public final String d() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final String b() {
        return this.e;
    }
}
