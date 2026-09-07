package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class xn0 {
    private static final Object e = new Object();
    private static volatile xn0 f;
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10666a;
    private boolean b;
    private boolean c;
    private Set<String> d;

    public static final class a {
        @JvmStatic
        public static xn0 a() {
            if (xn0.f == null) {
                synchronized (xn0.e) {
                    if (xn0.f == null) {
                        xn0.f = new xn0(0);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            xn0 xn0Var = xn0.f;
            if (xn0Var != null) {
                return xn0Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    private xn0() {
        this.f10666a = true;
        this.b = true;
        this.c = true;
        this.d = SetsKt.emptySet();
    }

    public final void b(boolean z) {
        this.f10666a = z;
    }

    public final boolean e() {
        return this.f10666a;
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final Set<String> c() {
        return this.d;
    }

    public /* synthetic */ xn0(int i) {
        this();
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void c(boolean z) {
        this.b = z;
    }
}
