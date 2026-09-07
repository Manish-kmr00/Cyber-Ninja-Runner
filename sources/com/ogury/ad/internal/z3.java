package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.core.internal.network.NetworkClient;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z3 {
    public static a4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z3 f7460a = new z3();
    public static final t7 c = t7.f7405a;

    public static void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (b == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            if (x5.c == null) {
                int millis = (int) TimeUnit.SECONDS.toMillis(t7.b.b.f7468a);
                Context context2 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
                Intrinsics.checkNotNullParameter(context2, "context");
                Context applicationContext = context2.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                x5.c = new x5(new m2(applicationContext), new NetworkClient(millis, millis * 5));
            }
            x5 x5Var = x5.c;
            Intrinsics.checkNotNull(x5Var);
            b = new a4(x5Var, new g1(context), context);
        }
    }

    public static void a(y3 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = event instanceof h9;
        if (z) {
            c.getClass();
            if (!t7.b.e.b.f7473a) {
                return;
            }
        }
        boolean z2 = event instanceof k7;
        if (z2) {
            c.getClass();
            if (!t7.b.e.c.f7471a) {
                return;
            }
        }
        a4 a4Var = b;
        if (a4Var != null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (z2) {
                a4Var.a((k7) event);
            } else if (z) {
                a4Var.a((h9) event);
            } else {
                if (!(event instanceof f)) {
                    throw new NoWhenBranchMatchedException();
                }
                a4Var.a((f) event);
            }
        }
    }
}
