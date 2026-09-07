package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10844a = new Object();
    private static volatile zp1 b;
    public static final /* synthetic */ int c = 0;

    public static final class a {
        @JvmStatic
        public static zp1 a() {
            zp1 zp1Var;
            zp1 zp1Var2 = zp1.b;
            if (zp1Var2 != null) {
                return zp1Var2;
            }
            synchronized (zp1.f10844a) {
                zp1Var = zp1.b;
                if (zp1Var == null) {
                    zp1Var = new zp1();
                    zp1.b = zp1Var;
                }
            }
            return zp1Var;
        }
    }

    public static void a(Context context, final Object tag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        dd1.a(context).a(new bq1.b() { // from class: com.yandex.mobile.ads.impl.zp1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.bq1.b
            public final boolean a(np1 np1Var) {
                return zp1.a(tag, np1Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Object tag, np1 np1Var) {
        Intrinsics.checkNotNullParameter(tag, "$tag");
        return Intrinsics.areEqual(tag, np1Var.i());
    }
}
