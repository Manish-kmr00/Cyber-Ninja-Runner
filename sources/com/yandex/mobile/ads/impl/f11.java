package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f11 {
    public static final a e = new a(0);
    private static volatile f11 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8859a = new Object();
    private volatile boolean b = true;
    private final i1 c = new i1();
    private final qg1 d = new qg1();

    public final void a(Context context) throws xo0 {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.b) {
            synchronized (this.f8859a) {
                if (this.b) {
                    if (pa.a(context)) {
                        this.c.a(context);
                        this.d.getClass();
                        qg1.a(context);
                    }
                    this.b = false;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static final class a {
        @JvmStatic
        public final f11 a() {
            f11 f11Var = f11.f;
            if (f11Var == null) {
                synchronized (this) {
                    f11Var = f11.f;
                    if (f11Var == null) {
                        f11Var = new f11();
                        f11.f = f11Var;
                    }
                }
            }
            return f11Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
