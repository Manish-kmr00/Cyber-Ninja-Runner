package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class xi0 implements yi0 {
    private static final Object h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ue f10656a;
    private final hf b;
    private final ff c;
    private final Context d;
    private df e;
    private final zi0 f;
    private final String g;

    public xi0(Context context, ue appMetricaAdapter, hf appMetricaIdentifiersValidator, ff appMetricaIdentifiersLoader, ju0 mauidManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appMetricaAdapter, "appMetricaAdapter");
        Intrinsics.checkNotNullParameter(appMetricaIdentifiersValidator, "appMetricaIdentifiersValidator");
        Intrinsics.checkNotNullParameter(appMetricaIdentifiersLoader, "appMetricaIdentifiersLoader");
        Intrinsics.checkNotNullParameter(mauidManager, "mauidManager");
        this.f10656a = appMetricaAdapter;
        this.b = appMetricaIdentifiersValidator;
        this.c = appMetricaIdentifiersLoader;
        this.f = zi0.b;
        this.g = mauidManager.a();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.d = applicationContext;
    }

    @Override // com.yandex.mobile.ads.impl.yi0
    public final zi0 c() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.yi0
    public final String a() {
        return this.g;
    }

    public final void a(df appMetricaIdentifiers) {
        Intrinsics.checkNotNullParameter(appMetricaIdentifiers, "appMetricaIdentifiers");
        synchronized (h) {
            this.b.getClass();
            if (hf.a(appMetricaIdentifiers)) {
                this.e = appMetricaIdentifiers;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.yandex.mobile.ads.impl.df] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    @Override // com.yandex.mobile.ads.impl.yi0
    public final df b() {
        ?? r2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (h) {
            df dfVar = this.e;
            r2 = dfVar;
            if (dfVar == null) {
                df dfVar2 = new df(null, this.f10656a.b(this.d), this.f10656a.a(this.d));
                this.c.a(this.d, this);
                r2 = dfVar2;
            }
            objectRef.element = r2;
            Unit unit = Unit.INSTANCE;
        }
        return r2;
    }
}
