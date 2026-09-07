package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.ReporterConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
final class of extends Lambda implements Function0<IReporter> {
    final /* synthetic */ ie b;
    final /* synthetic */ Context c;
    final /* synthetic */ pf d;
    final /* synthetic */ String e;
    final /* synthetic */ jf f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    of(ie ieVar, Context context, pf pfVar, String str, jf jfVar) {
        super(0);
        this.b = ieVar;
        this.c = context;
        this.d = pfVar;
        this.e = str;
        this.f = jfVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final IReporter invoke() {
        this.b.a(this.c);
        pf pfVar = this.d;
        Context context = this.c;
        String str = this.e;
        jf jfVar = this.f;
        pfVar.getClass();
        try {
            ReporterConfig reporterConfigBuild = ReporterConfig.newConfigBuilder(str).withDataSendingEnabled(jfVar.b(context)).build();
            Intrinsics.checkNotNullExpressionValue(reporterConfigBuild, "build(...)");
            AppMetrica.activateReporter(context, reporterConfigBuild);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
        return AppMetrica.getReporter(this.c, this.e);
    }
}
