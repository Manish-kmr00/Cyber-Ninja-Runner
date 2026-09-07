package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10304a;
    private final String b;
    private final String c;
    private final String d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ti)) {
            return false;
        }
        ti tiVar = (ti) obj;
        return Intrinsics.areEqual(this.f10304a, tiVar.f10304a) && Intrinsics.areEqual(this.b, tiVar.b) && Intrinsics.areEqual(this.c, tiVar.c) && Intrinsics.areEqual(this.d, tiVar.d);
    }

    public final int hashCode() {
        String str = this.f10304a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return "BackgroundColors(top=" + this.f10304a + ", right=" + this.b + ", left=" + this.c + ", bottom=" + this.d + ")";
    }

    public ti(String str, String str2, String str3, String str4) {
        this.f10304a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final String d() {
        return this.f10304a;
    }

    public final String c() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String a() {
        return this.d;
    }
}
