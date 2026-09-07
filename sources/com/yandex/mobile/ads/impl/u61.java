package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c41> f10360a;
    private final List<ig<?>> b;
    private final List<String> c;
    private final t4 d;
    private final Map<String, Object> e;
    private final List<y20> f;
    private final List<xx1> g;
    private final String h;
    private final rx1 i;
    private final g6 j;

    /* JADX WARN: Multi-variable type inference failed */
    public u61(List<c41> nativeAds, List<? extends ig<?>> assets, List<String> renderTrackingUrls, t4 t4Var, Map<String, ? extends Object> properties, List<y20> divKitDesigns, List<xx1> showNotices, String str, rx1 rx1Var, g6 g6Var) {
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(renderTrackingUrls, "renderTrackingUrls");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(divKitDesigns, "divKitDesigns");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        this.f10360a = nativeAds;
        this.b = assets;
        this.c = renderTrackingUrls;
        this.d = t4Var;
        this.e = properties;
        this.f = divKitDesigns;
        this.g = showNotices;
        this.h = str;
        this.i = rx1Var;
        this.j = g6Var;
    }

    public static u61 a(u61 u61Var, List nativeAds) {
        List<ig<?>> assets = u61Var.b;
        List<String> renderTrackingUrls = u61Var.c;
        t4 t4Var = u61Var.d;
        Map<String, Object> properties = u61Var.e;
        List<y20> divKitDesigns = u61Var.f;
        List<xx1> showNotices = u61Var.g;
        String str = u61Var.h;
        rx1 rx1Var = u61Var.i;
        g6 g6Var = u61Var.j;
        u61Var.getClass();
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(renderTrackingUrls, "renderTrackingUrls");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(divKitDesigns, "divKitDesigns");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        return new u61(nativeAds, assets, renderTrackingUrls, t4Var, properties, divKitDesigns, showNotices, str, rx1Var, g6Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u61)) {
            return false;
        }
        u61 u61Var = (u61) obj;
        return Intrinsics.areEqual(this.f10360a, u61Var.f10360a) && Intrinsics.areEqual(this.b, u61Var.b) && Intrinsics.areEqual(this.c, u61Var.c) && Intrinsics.areEqual(this.d, u61Var.d) && Intrinsics.areEqual(this.e, u61Var.e) && Intrinsics.areEqual(this.f, u61Var.f) && Intrinsics.areEqual(this.g, u61Var.g) && Intrinsics.areEqual(this.h, u61Var.h) && Intrinsics.areEqual(this.i, u61Var.i) && Intrinsics.areEqual(this.j, u61Var.j);
    }

    public final int hashCode() {
        int iA = aa.a(this.c, aa.a(this.b, this.f10360a.hashCode() * 31, 31), 31);
        t4 t4Var = this.d;
        int iA2 = aa.a(this.g, aa.a(this.f, (this.e.hashCode() + ((iA + (t4Var == null ? 0 : t4Var.hashCode())) * 31)) * 31, 31), 31);
        String str = this.h;
        int iHashCode = (iA2 + (str == null ? 0 : str.hashCode())) * 31;
        rx1 rx1Var = this.i;
        int iHashCode2 = (iHashCode + (rx1Var == null ? 0 : rx1Var.hashCode())) * 31;
        g6 g6Var = this.j;
        return iHashCode2 + (g6Var != null ? g6Var.hashCode() : 0);
    }

    public final String toString() {
        return "NativeAdResponse(nativeAds=" + this.f10360a + ", assets=" + this.b + ", renderTrackingUrls=" + this.c + ", impressionData=" + this.d + ", properties=" + this.e + ", divKitDesigns=" + this.f + ", showNotices=" + this.g + ", version=" + this.h + ", settings=" + this.i + ", adPod=" + this.j + ")";
    }

    public final List<c41> e() {
        return this.f10360a;
    }

    public final List<ig<?>> b() {
        return this.b;
    }

    public final List<String> g() {
        return this.c;
    }

    public final t4 d() {
        return this.d;
    }

    public final Map<String, Object> f() {
        return this.e;
    }

    public final List<y20> c() {
        return this.f;
    }

    public final List<xx1> i() {
        return this.g;
    }

    public final rx1 h() {
        return this.i;
    }

    public final g6 a() {
        return this.j;
    }
}
