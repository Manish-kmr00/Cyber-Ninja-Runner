package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class p01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final iw1 f9883a;
    private static volatile o01 b;

    static final class a extends Lambda implements Function0<j92> {
        final /* synthetic */ l92 b;
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l92 l92Var, Context context) {
            super(0);
            this.b = l92Var;
            this.c = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final j92 invoke() {
            return this.b.a(this.c);
        }
    }

    static {
        int i = iw1.l;
        f9883a = iw1.a.a();
    }

    @JvmStatic
    public static final o01 a(Context context, l92 varioqubAdapterProvider, ie appAdAnalyticsActivator) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(varioqubAdapterProvider, "varioqubAdapterProvider");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        if (b == null) {
            synchronized (o01.e) {
                if (b == null && (applicationContext = context.getApplicationContext()) != null) {
                    Intrinsics.checkNotNull(applicationContext);
                    b = a(applicationContext, varioqubAdapterProvider, f9883a.a(context), appAdAnalyticsActivator);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        o01 o01Var = b;
        if (o01Var != null) {
            return o01Var;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    private static o01 a(Context context, l92 l92Var, cu1 cu1Var, ie ieVar) {
        boolean z;
        jf jfVar = new jf();
        lp1 lp1VarA = new kf(jfVar, ieVar, ve.a()).a(context);
        Lazy lazy = LazyKt.lazy(new a(l92Var, context));
        if (cu1Var != null) {
            z = cu1Var.v();
        }
        int i = is0.f;
        o01 o01Var = new o01(lp1VarA, lazy, z, is0.a.a().c());
        eu1 eu1Var = new eu1(o01Var, jfVar);
        int i2 = iu1.d;
        new du1(jfVar, eu1Var, iu1.a.a()).a();
        return o01Var;
    }
}
