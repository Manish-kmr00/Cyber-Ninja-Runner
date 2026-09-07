package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ks1 {
    private static final Object c = new Object();
    private static ks1 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tk1<td0, du> f9447a;
    private final ud0 b;

    public static final class a {
        public static ks1 a() {
            if (ks1.d == null) {
                synchronized (ks1.c) {
                    if (ks1.d == null) {
                        ks1.d = new ks1(new tk1(), new ud0());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            ks1 ks1Var = ks1.d;
            if (ks1Var != null) {
                return ks1Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public ks1(tk1<td0, du> preloadingCache, ud0 cacheParamsMapper) {
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(cacheParamsMapper, "cacheParamsMapper");
        this.f9447a = preloadingCache;
        this.b = cacheParamsMapper;
    }

    public final synchronized void a(v7 adRequestData, du item) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(item, "item");
        tk1<td0, du> tk1Var = this.f9447a;
        this.b.getClass();
        tk1Var.a(ud0.a(adRequestData), item);
    }

    public final synchronized du a(v7 adRequestData) {
        tk1<td0, du> tk1Var;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        tk1Var = this.f9447a;
        this.b.getClass();
        return (du) tk1Var.a(ud0.a(adRequestData));
    }

    public final synchronized boolean c() {
        return this.f9447a.b();
    }
}
