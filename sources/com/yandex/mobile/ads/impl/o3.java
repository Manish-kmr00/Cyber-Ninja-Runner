package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f9775a;
    private final uu1 b;
    private final sq c;
    private final ca d;
    private final az1 e;
    private v7 f;
    private ba1 g;
    private y91 h;
    private i82.a i;
    private String j;
    private String k;
    private String l;
    private Integer m;
    private hz0 n;
    private String o;
    private boolean p;
    private int q;
    private int r;

    public /* synthetic */ o3(qs qsVar, uu1 uu1Var) {
        this(qsVar, uu1Var, new sq(), new ca(), new az1());
    }

    public o3(qs adType, uu1 sdkEnvironmentModule, sq commonAdRequestConfiguration, ca adUnitIdConfigurator, az1 sizeInfoConfigurator) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(commonAdRequestConfiguration, "commonAdRequestConfiguration");
        Intrinsics.checkNotNullParameter(adUnitIdConfigurator, "adUnitIdConfigurator");
        Intrinsics.checkNotNullParameter(sizeInfoConfigurator, "sizeInfoConfigurator");
        this.f9775a = adType;
        this.b = sdkEnvironmentModule;
        this.c = commonAdRequestConfiguration;
        this.d = adUnitIdConfigurator;
        this.e = sizeInfoConfigurator;
        this.p = true;
        this.r = yh0.b;
    }

    public final qs b() {
        return this.f9775a;
    }

    public final uu1 q() {
        return this.b;
    }

    public final sq g() {
        return this.c;
    }

    public final v7 a() {
        return this.f;
    }

    public final ba1 s() {
        return this.g;
    }

    public final y91 p() {
        return this.h;
    }

    public final i82.a t() {
        return this.i;
    }

    public final String f() {
        return this.j;
    }

    public final String l() {
        return this.k;
    }

    public final String n() {
        return this.l;
    }

    public final Integer d() {
        return this.m;
    }

    public final hz0 i() {
        return this.n;
    }

    public final String j() {
        return this.o;
    }

    public final boolean u() {
        return this.p;
    }

    public final int o() {
        return this.q;
    }

    public final int h() {
        return this.r;
    }

    public final zy1 r() {
        return this.e.a();
    }

    public final String c() {
        return this.d.a();
    }

    public final void b(String str) {
        this.j = str;
    }

    public final void a(v7 v7Var) {
        this.f = v7Var;
    }

    public final jc e() {
        return this.c.a();
    }

    public final l50 k() {
        return this.c.b();
    }

    public final List<String> m() {
        return this.c.c();
    }

    public final void d(String str) {
        this.k = str;
    }

    public final void c(String str) {
        this.o = str;
    }

    public final void e(String str) {
        this.l = str;
    }

    public final void a(String str) {
        this.d.a(str);
    }

    public final void a(Integer num) {
        this.m = num;
    }

    public final void a(jc configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.c.a(configuration);
    }

    public final void a(hz0 hz0Var) {
        this.n = hz0Var;
    }

    public final void a(l50 configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.c.a(configuration);
    }

    public final void a(int i) {
        this.q = i;
    }

    public final void a(y91 y91Var) {
        this.h = y91Var;
    }

    public final void a(boolean z) {
        this.p = z;
    }

    public final void a(zy1 zy1Var) {
        this.e.a(zy1Var);
    }

    public final void a(ba1 ba1Var) {
        this.g = ba1Var;
    }

    public final void a(i82.a aVar) {
        this.i = aVar;
    }
}
