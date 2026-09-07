package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 {
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f9470a;
    private volatile i2 b;

    public l2(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f9470a = localStorage;
    }

    public final void c() {
        synchronized (c) {
            a(this, null, null, null, Integer.valueOf(b().a() + 1), 7);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static void a(l2 l2Var, Boolean bool, g2 g2Var, Long l, Integer num, int i) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            g2Var = null;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        l2Var.getClass();
        synchronized (c) {
            boolean zBooleanValue = bool != null ? bool.booleanValue() : l2Var.b().d();
            if (g2Var == null) {
                g2Var = l2Var.b().c();
            }
            i2 i2Var = new i2(zBooleanValue, g2Var, l != null ? l.longValue() : l2Var.b().b(), num != null ? num.intValue() : l2Var.b().a());
            l2Var.f9470a.b("AdBlockerDetected", i2Var.d());
            l2Var.f9470a.a("AdBlockerRequestPolicy", i2Var.c().name());
            l2Var.f9470a.a("AdBlockerLastUpdate", i2Var.b());
            l2Var.f9470a.a(i2Var.a(), "AdBlockerFailedRequestsCount");
            l2Var.b = i2Var;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final i2 b() {
        i2 i2Var;
        i2 i2Var2 = this.b;
        if (i2Var2 != null) {
            return i2Var2;
        }
        synchronized (c) {
            i2Var = this.b;
            if (i2Var == null) {
                boolean zA = this.f9470a.a("AdBlockerDetected", false);
                String strD = this.f9470a.d("AdBlockerRequestPolicy");
                if (strD == null) {
                    strD = "TCP";
                }
                i2Var = new i2(zA, g2.valueOf(strD), this.f9470a.b("AdBlockerLastUpdate"), this.f9470a.b(0, "AdBlockerFailedRequestsCount"));
                this.b = i2Var;
            }
        }
        return i2Var;
    }

    public final void a() {
        synchronized (c) {
            a(this, null, null, null, 0, 7);
            Unit unit = Unit.INSTANCE;
        }
    }
}
