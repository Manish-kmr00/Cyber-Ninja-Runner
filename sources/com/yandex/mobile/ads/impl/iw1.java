package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class iw1 {
    private static final Object j = new Object();
    private static volatile iw1 k;
    public static final /* synthetic */ int l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cu1 f9262a;
    private Boolean b;
    private Boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Integer h;
    private boolean i;

    public static final class a {
        @JvmStatic
        public static iw1 a() {
            iw1 iw1Var;
            iw1 iw1Var2 = iw1.k;
            if (iw1Var2 != null) {
                return iw1Var2;
            }
            synchronized (iw1.j) {
                iw1Var = iw1.k;
                if (iw1Var == null) {
                    iw1Var = new iw1(0);
                    iw1.k = iw1Var;
                }
            }
            return iw1Var;
        }
    }

    public static void c() {
        synchronized (j) {
        }
    }

    public final void b(boolean z) {
        synchronized (j) {
            this.d = z;
            this.e = z;
            this.f = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(boolean z) {
        synchronized (j) {
            this.c = Boolean.valueOf(z);
            Unit unit = Unit.INSTANCE;
        }
    }

    private iw1() {
        this.f = true;
        this.g = true;
    }

    public /* synthetic */ iw1(int i) {
        this();
    }

    public final Integer e() {
        Integer num;
        synchronized (j) {
            num = this.h;
        }
        return num;
    }

    public final void e(boolean z) {
        synchronized (j) {
            this.i = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (j) {
            z = this.i;
        }
        return z;
    }

    public final void d(boolean z) {
        synchronized (j) {
            this.g = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean h() {
        boolean z;
        synchronized (j) {
            z = this.d;
        }
        return z;
    }

    public final boolean i() {
        boolean z;
        synchronized (j) {
            z = this.e;
        }
        return z;
    }

    public final boolean k() {
        boolean z;
        synchronized (j) {
            z = this.f;
        }
        return z;
    }

    public final Boolean j() {
        Boolean bool;
        synchronized (j) {
            bool = this.b;
        }
        return bool;
    }

    public final Boolean f() {
        Boolean bool;
        synchronized (j) {
            bool = this.c;
        }
        return bool;
    }

    public final void f(boolean z) {
        synchronized (j) {
            this.b = Boolean.valueOf(z);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean g() {
        boolean z;
        synchronized (j) {
            z = this.g;
        }
        return z;
    }

    public final cu1 a(Context context) {
        cu1 cu1Var;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (j) {
            if (this.f9262a == null) {
                jr.f9346a.getClass();
                this.f9262a = jr.a.a(context).a();
            }
            cu1Var = this.f9262a;
        }
        return cu1Var;
    }

    public final void a(Context context, cu1 sdkConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        synchronized (j) {
            this.f9262a = sdkConfiguration;
            jr.f9346a.getClass();
            jr.a.a(context).a(sdkConfiguration);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(Integer num) {
        synchronized (j) {
            this.h = num;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(boolean z) {
        synchronized (j) {
            this.d = z;
            this.f = z;
            Unit unit = Unit.INSTANCE;
        }
    }
}
