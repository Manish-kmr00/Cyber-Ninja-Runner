package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ag {
    private static final Object c = new Object();
    private static ag d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tk1<td0, rs> f8405a;
    private final ud0 b;

    public static final class a {
        public static ag a() {
            if (ag.d == null) {
                synchronized (ag.c) {
                    if (ag.d == null) {
                        ag.d = new ag(new tk1(), new ud0());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            ag agVar = ag.d;
            if (agVar != null) {
                return agVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public ag(tk1<td0, rs> preloadingCache, ud0 cacheParamsMapper) {
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(cacheParamsMapper, "cacheParamsMapper");
        this.f8405a = preloadingCache;
        this.b = cacheParamsMapper;
    }

    public final synchronized void a(v7 adRequestData, rs item) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(item, "item");
        tk1<td0, rs> tk1Var = this.f8405a;
        this.b.getClass();
        tk1Var.a(ud0.a(adRequestData), item);
    }

    public final synchronized rs a(v7 adRequestData) {
        tk1<td0, rs> tk1Var;
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        tk1Var = this.f8405a;
        this.b.getClass();
        return (rs) tk1Var.a(ud0.a(adRequestData));
    }

    public final synchronized boolean c() {
        return this.f8405a.b();
    }
}
