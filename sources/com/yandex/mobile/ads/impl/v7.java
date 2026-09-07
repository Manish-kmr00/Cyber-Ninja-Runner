package com.yandex.mobile.ads.impl;

import android.location.Location;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10453a;
    private final String b;
    private final String c;
    private final String d;
    private final List<String> e;
    private final Location f;
    private final Map<String, String> g;
    private final String h;
    private final String i;
    private final gq1 j;
    private final boolean k;
    private final String l;

    public v7(String adUnitId, String str, String str2, String str3, List<String> list, Location location, Map<String, String> map, String str4, String str5, gq1 gq1Var, boolean z, String str6) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f10453a = adUnitId;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = list;
        this.f = location;
        this.g = map;
        this.h = str4;
        this.i = str5;
        this.j = gq1Var;
        this.k = z;
        this.l = str6;
    }

    public static v7 a(v7 v7Var, Map map, String str, int i) {
        String adUnitId = v7Var.f10453a;
        String str2 = v7Var.b;
        String str3 = v7Var.c;
        String str4 = v7Var.d;
        List<String> list = v7Var.e;
        Location location = v7Var.f;
        Map map2 = (i & 64) != 0 ? v7Var.g : map;
        String str5 = v7Var.h;
        String str6 = v7Var.i;
        gq1 gq1Var = v7Var.j;
        boolean z = v7Var.k;
        String str7 = (i & 2048) != 0 ? v7Var.l : str;
        v7Var.getClass();
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new v7(adUnitId, str2, str3, str4, list, location, map2, str5, str6, gq1Var, z, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v7)) {
            return false;
        }
        v7 v7Var = (v7) obj;
        return Intrinsics.areEqual(this.f10453a, v7Var.f10453a) && Intrinsics.areEqual(this.b, v7Var.b) && Intrinsics.areEqual(this.c, v7Var.c) && Intrinsics.areEqual(this.d, v7Var.d) && Intrinsics.areEqual(this.e, v7Var.e) && Intrinsics.areEqual(this.f, v7Var.f) && Intrinsics.areEqual(this.g, v7Var.g) && Intrinsics.areEqual(this.h, v7Var.h) && Intrinsics.areEqual(this.i, v7Var.i) && this.j == v7Var.j && this.k == v7Var.k && Intrinsics.areEqual(this.l, v7Var.l);
    }

    public final int hashCode() {
        int iHashCode = this.f10453a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.e;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Location location = this.f;
        int iHashCode6 = (iHashCode5 + (location == null ? 0 : location.hashCode())) * 31;
        Map<String, String> map = this.g;
        int iHashCode7 = (iHashCode6 + (map == null ? 0 : map.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        gq1 gq1Var = this.j;
        int iA = a7.a(this.k, (iHashCode9 + (gq1Var == null ? 0 : gq1Var.hashCode())) * 31, 31);
        String str6 = this.l;
        return iA + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        return "AdRequestData(adUnitId=" + this.f10453a + ", age=" + this.b + ", gender=" + this.c + ", contextQuery=" + this.d + ", contextTags=" + this.e + ", location=" + this.f + ", parameters=" + this.g + ", openBiddingData=" + this.h + ", readyResponse=" + this.i + ", preferredTheme=" + this.j + ", shouldLoadImagesAutomatically=" + this.k + ", preloadType=" + this.l + ")";
    }

    public final String b() {
        return this.b;
    }

    public final String a() {
        return this.f10453a;
    }

    public final String e() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final List<String> d() {
        return this.e;
    }

    public final Location f() {
        return this.f;
    }

    public final Map<String, String> h() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final gq1 i() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final String j() {
        return this.l;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10454a;
        private String b;
        private String c;
        private Location d;
        private String e;
        private List<String> f;
        private Map<String, String> g;
        private String h;
        private String i;
        private gq1 j;
        private boolean k;

        public a(String adUnitId) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            this.f10454a = adUnitId;
        }

        public final a b(String str) {
            this.e = str;
            return this;
        }

        public final a b() {
            this.i = null;
            return this;
        }

        public final a c(String str) {
            this.c = str;
            return this;
        }

        public final a d(String str) {
            this.h = str;
            return this;
        }

        public final v7 a() {
            return new v7(this.f10454a, this.b, this.c, this.e, this.f, this.d, this.g, this.h, this.i, this.j, this.k, null);
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a a(List<String> list) {
            this.f = list;
            return this;
        }

        public final a a(Location location) {
            this.d = location;
            return this;
        }

        public final a a(Map<String, String> map) {
            this.g = map;
            return this;
        }

        public final a a(gq1 gq1Var) {
            this.j = gq1Var;
            return this;
        }

        public final a a(boolean z) {
            this.k = z;
            return this;
        }
    }
}
