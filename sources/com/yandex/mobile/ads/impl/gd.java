package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapter;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gd {
    private static final AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jf f8994a;
    private final it0 b;
    private final iw1 c;

    public final void a(Context context) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.c.a(context);
        boolean z = cu1VarA != null && cu1VarA.l();
        this.b.getClass();
        if (it0.d(context) && !z && d.compareAndSet(false, true)) {
            kd configuration = this.f8994a.a(context);
            fd.f8884a.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            try {
                Result.Companion companion = Result.INSTANCE;
                AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfigBuild = AppMetricaLibraryAdapterConfig.newConfigBuilder().withAdvIdentifiersTracking(configuration.a()).build();
                Intrinsics.checkNotNullExpressionValue(appMetricaLibraryAdapterConfigBuild, "build(...)");
                AppMetricaLibraryAdapter.activate(context, appMetricaLibraryAdapterConfigBuild);
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
                op0.b(new Object[0]);
            }
        }
    }

    public /* synthetic */ gd() {
        jf jfVar = new jf();
        it0 it0Var = new it0();
        int i = iw1.l;
        this(jfVar, it0Var, iw1.a.a());
    }

    public gd(jf appMetricaPolicyConfigurator, it0 manifestAnalyzer, iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(appMetricaPolicyConfigurator, "appMetricaPolicyConfigurator");
        Intrinsics.checkNotNullParameter(manifestAnalyzer, "manifestAnalyzer");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f8994a = appMetricaPolicyConfigurator;
        this.b = manifestAnalyzer;
        this.c = sdkSettings;
    }
}
