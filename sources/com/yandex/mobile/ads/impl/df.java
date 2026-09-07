package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8688a;
    private final String b;
    private final String c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof df)) {
            return false;
        }
        df dfVar = (df) obj;
        return Intrinsics.areEqual(this.f8688a, dfVar.f8688a) && Intrinsics.areEqual(this.b, dfVar.b) && Intrinsics.areEqual(this.c, dfVar.c);
    }

    public final int hashCode() {
        String str = this.f8688a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AppMetricaIdentifiers(adGetUrl=" + this.f8688a + ", deviceId=" + this.b + ", uuid=" + this.c + ")";
    }

    public df(String str, String str2, String str3) {
        this.f8688a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.f8688a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
