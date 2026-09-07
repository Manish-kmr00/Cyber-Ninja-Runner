package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9971a;
    private final t0 b;
    private final p1 c;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivity(p1);
    }

    public final void a(Context context, Intent intent) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        long jA = ti0.a();
        Intent intentA = this.c.a(context, jA);
        c1 c1VarA = this.b.a(intent);
        int i = d1.d;
        d1 d1VarA = d1.a.a();
        d1VarA.a(jA, c1VarA);
        try {
            Result.Companion companion = Result.INSTANCE;
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            d1VarA.a(jA);
            this.f9971a.reportError("Failed to launch AdActivity for result", thM7907exceptionOrNullimpl);
        }
    }

    public /* synthetic */ q1(o3 o3Var, o8 o8Var) {
        this(o3Var, o8Var, o3Var.q().c(), new t0(o8Var, o3Var), new p1(o3Var.q().e()));
    }

    public q1(o3 adConfiguration, o8<?> adResponse, lp1 reporter, t0 activityResultAdDataCreator, p1 intentCreator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(activityResultAdDataCreator, "activityResultAdDataCreator");
        Intrinsics.checkNotNullParameter(intentCreator, "intentCreator");
        this.f9971a = reporter;
        this.b = activityResultAdDataCreator;
        this.c = intentCreator;
    }
}
