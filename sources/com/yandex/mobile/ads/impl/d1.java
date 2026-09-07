package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d1 {
    private static final Object b = new Object();
    private static volatile d1 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<Long, c1> f8655a;

    public static final class a {
        @JvmStatic
        public static d1 a() {
            d1 d1Var;
            d1 d1Var2 = d1.c;
            if (d1Var2 != null) {
                return d1Var2;
            }
            synchronized (d1.b) {
                d1Var = d1.c;
                if (d1Var == null) {
                    d1Var = new d1(0);
                    d1.c = d1Var;
                }
            }
            return d1Var;
        }
    }

    private d1() {
        this.f8655a = new HashMap<>();
    }

    public /* synthetic */ d1(int i) {
        this();
    }

    public final c1 a(long j) {
        c1 c1VarRemove;
        synchronized (b) {
            c1VarRemove = this.f8655a.remove(Long.valueOf(j));
        }
        return c1VarRemove;
    }

    public final void a(long j, c1 adActivityData) {
        Intrinsics.checkNotNullParameter(adActivityData, "adActivityData");
        synchronized (b) {
            this.f8655a.put(Long.valueOf(j), adActivityData);
            Unit unit = Unit.INSTANCE;
        }
    }
}
