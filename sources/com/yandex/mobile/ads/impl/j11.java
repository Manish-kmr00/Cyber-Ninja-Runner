package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j11 {
    private static j11 b;
    private static final Object c = new Object();
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<i11> f9277a;

    public static final class a {
        @JvmStatic
        public static j11 a() {
            j11 j11Var;
            j11 j11Var2 = j11.b;
            if (j11Var2 != null) {
                return j11Var2;
            }
            synchronized (j11.c) {
                j11Var = j11.b;
                if (j11Var == null) {
                    j11Var = new j11(0);
                    j11.b = j11Var;
                }
            }
            return j11Var;
        }
    }

    public final void c() {
        synchronized (c) {
            this.f9277a.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private j11() {
        this.f9277a = new ArrayDeque<>();
    }

    public final void a(long j, String requestMethod, String requestUrl, Map<String, String> map, String str, Integer num, Map<String, String> map2, String str2) {
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        if (h11.f9051a.a()) {
            i11 i11Var = new i11(new k11(j, requestMethod, requestUrl, map, str), (num == null || map2 == null || str2 == null) ? null : new l11(System.currentTimeMillis(), num, map2, str2));
            synchronized (c) {
                if (this.f9277a.size() > 100) {
                    this.f9277a.removeFirst();
                }
                this.f9277a.add(i11Var);
            }
        }
    }

    public /* synthetic */ j11(int i) {
        this();
    }

    public final List<i11> d() {
        List<i11> list;
        synchronized (c) {
            list = CollectionsKt.toList(this.f9277a);
        }
        return list;
    }
}
