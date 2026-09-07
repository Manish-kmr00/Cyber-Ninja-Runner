package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class td0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10289a;
    private final String b;
    private final String c;
    private final String d;
    private final List<String> e;
    private final Map<String, String> f;
    private final gq1 g;

    public td0(String adUnitId, String str, String str2, String str3, List<String> list, Map<String, String> map, gq1 gq1Var) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f10289a = adUnitId;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = list;
        this.f = map;
        this.g = gq1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof td0)) {
            return false;
        }
        td0 td0Var = (td0) obj;
        return Intrinsics.areEqual(this.f10289a, td0Var.f10289a) && Intrinsics.areEqual(this.b, td0Var.b) && Intrinsics.areEqual(this.c, td0Var.c) && Intrinsics.areEqual(this.d, td0Var.d) && Intrinsics.areEqual(this.e, td0Var.e) && Intrinsics.areEqual(this.f, td0Var.f) && this.g == td0Var.g;
    }

    public final int hashCode() {
        int iHashCode = this.f10289a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.e;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, String> map = this.f;
        int iHashCode6 = (iHashCode5 + (map == null ? 0 : map.hashCode())) * 31;
        gq1 gq1Var = this.g;
        return iHashCode6 + (gq1Var != null ? gq1Var.hashCode() : 0);
    }

    public final String toString() {
        return "FullscreenCacheParams(adUnitId=" + this.f10289a + ", age=" + this.b + ", gender=" + this.c + ", contextQuery=" + this.d + ", contextTags=" + this.e + ", parameters=" + this.f + ", preferredTheme=" + this.g + ")";
    }
}
