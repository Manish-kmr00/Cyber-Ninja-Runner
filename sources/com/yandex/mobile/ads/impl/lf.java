package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9510a;
    private final String b;
    private final String c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lf)) {
            return false;
        }
        lf lfVar = (lf) obj;
        return Intrinsics.areEqual(this.f9510a, lfVar.f9510a) && Intrinsics.areEqual(this.b, lfVar.b) && Intrinsics.areEqual(this.c, lfVar.c);
    }

    public final int hashCode() {
        String str = this.f9510a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AppMetricaStartupParams(uuid=" + this.f9510a + ", deviceId=" + this.b + ", getAdUrl=" + this.c + ")";
    }

    public lf(String str, String str2, String str3) {
        this.f9510a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String c() {
        return this.f9510a;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }
}
