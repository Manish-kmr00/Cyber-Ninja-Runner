package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class bq0 {
    private static final Object c = new Object();
    private static bq0 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tk1<td0, kt> f8531a;
    private final ud0 b;

    public static final class a {
        public static bq0 a() {
            if (bq0.d == null) {
                synchronized (bq0.c) {
                    if (bq0.d == null) {
                        bq0.d = new bq0(new tk1(), new ud0());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            bq0 bq0Var = bq0.d;
            if (bq0Var != null) {
                return bq0Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public bq0(tk1<td0, kt> preloadingCache, ud0 cacheParamsMapper) {
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(cacheParamsMapper, "cacheParamsMapper");
        this.f8531a = preloadingCache;
        this.b = cacheParamsMapper;
    }

    public final synchronized void a(v7 adRequestData, kt item) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(item, "item");
        tk1<td0, kt> tk1Var = this.f8531a;
        this.b.getClass();
        tk1Var.a(ud0.a(adRequestData), item);
    }

    public final synchronized kt a(v7 adRequestData) {
        tk1<td0, kt> tk1Var;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        tk1Var = this.f8531a;
        this.b.getClass();
        return (kt) tk1Var.a(ud0.a(adRequestData));
    }

    public final synchronized boolean c() {
        return this.f8531a.b();
    }
}
