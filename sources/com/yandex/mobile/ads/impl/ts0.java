package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ts0 {
    private static final Object f = new Object();
    private static volatile ts0 g;
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ws0 f10328a;
    private final vs0 b;
    private final iw1 c;
    private final dx1 d;
    private final Context e;

    public static final class a {
        @JvmStatic
        public static ts0 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (ts0.g == null) {
                synchronized (ts0.f) {
                    if (ts0.g == null) {
                        ts0.g = new ts0(context);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            ts0 ts0Var = ts0.g;
            if (ts0Var != null) {
                return ts0Var;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    /* synthetic */ ts0(Context context) {
        ws0 ws0Var = new ws0();
        vs0 vs0Var = new vs0();
        int i = iw1.l;
        this(context, ws0Var, vs0Var, iw1.a.a(), new dx1());
    }

    private ts0(Context context, ws0 ws0Var, vs0 vs0Var, iw1 iw1Var, dx1 dx1Var) {
        this.f10328a = ws0Var;
        this.b = vs0Var;
        this.c = iw1Var;
        this.d = dx1Var;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.e = applicationContext;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0051  */
    public final Location c() {
        Location locationA;
        synchronized (f) {
            if (this.c.d()) {
                dx1 dx1Var = this.d;
                Context context = this.e;
                dx1Var.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                if (dx1.a(context)) {
                    locationA = null;
                } else {
                    vs0 vs0Var = this.b;
                    Context context2 = this.e;
                    vs0Var.getClass();
                    ArrayList arrayListA = vs0.a(context2);
                    List listCreateListBuilder = CollectionsKt.createListBuilder();
                    Iterator it = arrayListA.iterator();
                    while (it.hasNext()) {
                        Location locationA2 = ((us0) it.next()).a();
                        if (locationA2 != null) {
                            listCreateListBuilder.add(locationA2);
                        }
                    }
                    locationA = this.f10328a.a(CollectionsKt.build(listCreateListBuilder));
                }
            } else {
                locationA = null;
            }
        }
        return locationA;
    }
}
