package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class iq implements gq, ls0.a {
    private static final Object j = new Object();
    private final y62 b;
    private final y62 c;
    private String d;
    private String e;
    private boolean f;
    private String g;
    private String h;
    private String i;

    public iq(jq cmpV1, kq cmpV2, ls0 preferences) {
        Intrinsics.checkNotNullParameter(cmpV1, "cmpV1");
        Intrinsics.checkNotNullParameter(cmpV2, "cmpV2");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.b = cmpV1;
        this.c = cmpV2;
        for (eq eqVar : eq.values()) {
            a(preferences, eqVar);
        }
        preferences.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.gq
    public final String b() {
        String str;
        synchronized (j) {
            str = this.d;
        }
        return str;
    }

    @Override // com.yandex.mobile.ads.impl.gq
    public final String a() {
        String str;
        synchronized (j) {
            str = this.e;
        }
        return str;
    }

    @Override // com.yandex.mobile.ads.impl.ls0.a
    public final void a(ls0 localStorage, String key) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (j) {
            lq lqVarA = this.c.a(localStorage, key);
            if (lqVarA == null) {
                lqVarA = this.b.a(localStorage, key);
            }
            if (lqVarA != null) {
                a(lqVarA);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean e() {
        boolean z;
        synchronized (j) {
            z = this.f;
        }
        return z;
    }

    @Override // com.yandex.mobile.ads.impl.gq
    public final String c() {
        String str;
        synchronized (j) {
            str = this.g;
        }
        return str;
    }

    public final String f() {
        String str;
        synchronized (j) {
            str = this.h;
        }
        return str;
    }

    public final String d() {
        String str;
        synchronized (j) {
            str = this.i;
        }
        return str;
    }

    private final void a(ls0 ls0Var, eq eqVar) {
        lq lqVarA = this.c.a(ls0Var, eqVar);
        if (lqVarA == null) {
            lqVarA = this.b.a(ls0Var, eqVar);
        }
        a(lqVarA);
    }

    private final void a(lq lqVar) {
        if (lqVar instanceof lq.b) {
            this.f = ((lq.b) lqVar).a();
            return;
        }
        if (lqVar instanceof lq.c) {
            this.d = ((lq.c) lqVar).a();
            return;
        }
        if (lqVar instanceof lq.d) {
            this.e = ((lq.d) lqVar).a();
            return;
        }
        if (lqVar instanceof lq.e) {
            this.g = ((lq.e) lqVar).a();
        } else if (lqVar instanceof lq.f) {
            this.h = ((lq.f) lqVar).a();
        } else if (lqVar instanceof lq.a) {
            this.i = ((lq.a) lqVar).a();
        }
    }
}
