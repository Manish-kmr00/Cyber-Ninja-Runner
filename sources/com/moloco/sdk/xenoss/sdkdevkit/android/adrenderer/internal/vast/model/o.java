package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static final int i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6901a;
    public final String b;
    public final String c;
    public final String d;
    public final s e;
    public final List<n> f;
    public final List<String> g;
    public final List<g> h;

    public o(d dVar, String str, String str2, String str3, s sVar, List<n> impressions, List<String> errorUrls, List<g> creatives) {
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        this.f6901a = dVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = sVar;
        this.f = impressions;
        this.g = errorUrls;
        this.h = creatives;
    }

    public final d a() {
        return this.f6901a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final List<g> d() {
        return this.h;
    }

    public final String e() {
        return this.c;
    }

    public final List<String> f() {
        return this.g;
    }

    public final List<n> g() {
        return this.f;
    }

    public final s h() {
        return this.e;
    }
}
