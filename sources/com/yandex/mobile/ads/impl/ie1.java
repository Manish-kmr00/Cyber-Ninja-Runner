package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ie1 {
    private static final Object c = new Object();
    private static volatile ie1 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final re1 f9207a;
    private boolean b;

    public static final class a {
        @JvmStatic
        public static ie1 a() {
            ie1 ie1Var;
            ie1 ie1Var2 = ie1.d;
            if (ie1Var2 != null) {
                return ie1Var2;
            }
            synchronized (ie1.c) {
                ie1Var = ie1.d;
                if (ie1Var == null) {
                    ie1Var = new ie1();
                    ie1.d = ie1Var;
                }
            }
            return ie1Var;
        }
    }

    /* synthetic */ ie1() {
        this(new re1());
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (c) {
            if (this.f9207a.a(context) && !this.b) {
                ue1.a(context);
                this.b = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private ie1(re1 re1Var) {
        this.f9207a = re1Var;
    }
}
