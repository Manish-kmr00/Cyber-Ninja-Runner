package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zq1 f8568a;
    private List<? extends ig<?>> b;
    private final String c;
    private final String d;
    private final rr0 e;
    private final t4 f;
    private final fb0 g;
    private final fb0 h;
    private final List<String> i;
    private final List<xx1> j;

    public c41(zq1 responseNativeType, List<? extends ig<?>> assets, String str, String str2, rr0 rr0Var, t4 t4Var, fb0 fb0Var, fb0 fb0Var2, List<String> renderTrackingUrls, List<xx1> showNotices) {
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(renderTrackingUrls, "renderTrackingUrls");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        this.f8568a = responseNativeType;
        this.b = assets;
        this.c = str;
        this.d = str2;
        this.e = rr0Var;
        this.f = t4Var;
        this.g = fb0Var;
        this.h = fb0Var2;
        this.i = renderTrackingUrls;
        this.j = showNotices;
    }

    public static c41 a(c41 c41Var, List assets) {
        zq1 responseNativeType = c41Var.f8568a;
        String str = c41Var.c;
        String str2 = c41Var.d;
        rr0 rr0Var = c41Var.e;
        t4 t4Var = c41Var.f;
        fb0 fb0Var = c41Var.g;
        fb0 fb0Var2 = c41Var.h;
        List<String> renderTrackingUrls = c41Var.i;
        List<xx1> showNotices = c41Var.j;
        c41Var.getClass();
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(renderTrackingUrls, "renderTrackingUrls");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        return new c41(responseNativeType, assets, str, str2, rr0Var, t4Var, fb0Var, fb0Var2, renderTrackingUrls, showNotices);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c41)) {
            return false;
        }
        c41 c41Var = (c41) obj;
        return this.f8568a == c41Var.f8568a && Intrinsics.areEqual(this.b, c41Var.b) && Intrinsics.areEqual(this.c, c41Var.c) && Intrinsics.areEqual(this.d, c41Var.d) && Intrinsics.areEqual(this.e, c41Var.e) && Intrinsics.areEqual(this.f, c41Var.f) && Intrinsics.areEqual(this.g, c41Var.g) && Intrinsics.areEqual(this.h, c41Var.h) && Intrinsics.areEqual(this.i, c41Var.i) && Intrinsics.areEqual(this.j, c41Var.j);
    }

    public final int hashCode() {
        int iA = aa.a(this.b, this.f8568a.hashCode() * 31, 31);
        String str = this.c;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        rr0 rr0Var = this.e;
        int iHashCode3 = (iHashCode2 + (rr0Var == null ? 0 : rr0Var.hashCode())) * 31;
        t4 t4Var = this.f;
        int iHashCode4 = (iHashCode3 + (t4Var == null ? 0 : t4Var.hashCode())) * 31;
        fb0 fb0Var = this.g;
        int iHashCode5 = (iHashCode4 + (fb0Var == null ? 0 : fb0Var.hashCode())) * 31;
        fb0 fb0Var2 = this.h;
        return this.j.hashCode() + aa.a(this.i, (iHashCode5 + (fb0Var2 != null ? fb0Var2.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "Native(responseNativeType=" + this.f8568a + ", assets=" + this.b + ", adId=" + this.c + ", info=" + this.d + ", link=" + this.e + ", impressionData=" + this.f + ", hideConditions=" + this.g + ", showConditions=" + this.h + ", renderTrackingUrls=" + this.i + ", showNotices=" + this.j + ")";
    }

    public final zq1 g() {
        return this.f8568a;
    }

    public final List<ig<?>> b() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    public final String a() {
        return this.c;
    }

    public final rr0 e() {
        return this.e;
    }

    public final void a(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.b = arrayList;
    }

    public final t4 c() {
        return this.f;
    }

    public final List<String> f() {
        return this.i;
    }

    public final List<xx1> h() {
        return this.j;
    }
}
