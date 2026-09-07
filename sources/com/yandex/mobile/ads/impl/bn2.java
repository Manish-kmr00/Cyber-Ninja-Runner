package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bn2 implements l92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bn2 f8524a = new bn2();
    private static final Object b = new Object();
    private static volatile an2 c;

    @Override // com.yandex.mobile.ads.impl.l92
    public final j92 a(Context context) {
        an2 an2Var;
        Intrinsics.checkNotNullParameter(context, "context");
        an2 an2Var2 = c;
        if (an2Var2 != null) {
            return an2Var2;
        }
        synchronized (b) {
            an2Var = c;
            if (an2Var == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String str = pa.a(applicationContext) ? "322a737a-a0ca-44e0-bc85-649b1c7c1db6" : "478cb909-6ad1-4e12-84cc-b3629a789f93";
                we weVar = new we(applicationContext);
                weVar.a(str);
                int i = iw1.l;
                an2Var = new an2(weVar, applicationContext, iw1.a.a().a(applicationContext));
                c = an2Var;
            }
        }
        return an2Var;
    }

    private bn2() {
    }
}
