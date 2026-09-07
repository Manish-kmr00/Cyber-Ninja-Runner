package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f9916a;
    private final od0 b;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivity(p1);
    }

    public final Object a(Context context, c1 adActivityData) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adActivityData, "adActivityData");
        long jA = ti0.a();
        Intent intentA = this.b.a(context, jA);
        int i = d1.d;
        d1 d1VarA = d1.a.a();
        d1VarA.a(jA, adActivityData);
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
            dp0.a("Failed to show Fullscreen Ad. Exception: " + thM7907exceptionOrNullimpl, new Object[0]);
            this.f9916a.reportError("Failed to show Fullscreen Ad", thM7907exceptionOrNullimpl);
        }
        return objM7904constructorimpl;
    }

    public /* synthetic */ pd0(uu1 uu1Var) {
        this(uu1Var, uu1Var.c(), new od0(uu1Var.e()));
    }

    public pd0(uu1 sdkEnvironmentModule, lp1 reporter, od0 intentCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(intentCreator, "intentCreator");
        this.f9916a = reporter;
        this.b = intentCreator;
    }
}
