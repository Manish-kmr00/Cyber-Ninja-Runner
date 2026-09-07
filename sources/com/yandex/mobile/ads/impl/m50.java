package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m50 {
    private static m50 c;
    private static final Object d = new Object();
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l50 f9597a;
    private yi0 b;

    public static final class a {
        @JvmStatic
        public static m50 a(Context context) {
            m50 m50Var;
            Intrinsics.checkNotNullParameter(context, "context");
            m50 m50Var2 = m50.c;
            if (m50Var2 != null) {
                return m50Var2;
            }
            synchronized (m50.d) {
                m50Var = m50.c;
                if (m50Var == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    m50Var = new m50(applicationContext, new l50(), gf.a(applicationContext));
                    m50.c = m50Var;
                }
            }
            return m50Var;
        }
    }

    public m50(Context appContext, l50 environmentConfiguration, yi0 appMetricaProvider) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        Intrinsics.checkNotNullParameter(appMetricaProvider, "appMetricaProvider");
        this.f9597a = environmentConfiguration;
        CollectionsKt.emptyList();
        MapsKt.emptyMap();
        this.b = appMetricaProvider;
    }

    public final l50 c() {
        return this.f9597a;
    }

    public final yi0 d() {
        return this.b;
    }
}
