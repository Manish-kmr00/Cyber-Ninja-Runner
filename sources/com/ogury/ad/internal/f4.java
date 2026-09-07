package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.core.internal.network.NetworkClient;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f7296a;
    public final h4 b;

    public f4(Context context) {
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
        h4 h4Var = new h4(context);
        this.f7296a = x5Var;
        this.b = h4Var;
    }
}
