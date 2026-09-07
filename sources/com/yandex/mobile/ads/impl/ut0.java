package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ut0 {
    private static final Object b = new Object();
    private static volatile ut0 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f10417a;

    public static final class a {
        public static ut0 a() {
            if (ut0.c == null) {
                synchronized (ut0.b) {
                    if (ut0.c == null) {
                        ut0.c = new ut0(0);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            ut0 ut0Var = ut0.c;
            if (ut0Var != null) {
                return ut0Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    private ut0() {
        this.f10417a = new WeakHashMap();
    }

    public /* synthetic */ ut0(int i) {
        this();
    }

    public final ot0 a(q70 view) {
        ot0 ot0Var;
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (b) {
            ot0Var = (ot0) this.f10417a.get(view);
        }
        return ot0Var;
    }

    public final void a(q70 view, ot0 presenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        synchronized (b) {
        }
    }

    public final boolean a(ot0 presenter) {
        boolean z;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        synchronized (b) {
            Iterator it = this.f10417a.entrySet().iterator();
            z = false;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(presenter, (ot0) ((Map.Entry) it.next()).getValue())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }
}
