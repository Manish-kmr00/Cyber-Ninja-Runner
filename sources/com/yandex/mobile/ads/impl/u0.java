package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0 f10343a;

    public static void safedk_Activity_startActivityForResult_206f42f0b65887e835d87ee52d14d221(Activity p0, Intent p1, int p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivityForResult(p1, p2);
    }

    public final void a(Activity activity, c1 adActivityData) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adActivityData, "adActivityData");
        if (adActivityData.a() == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            safedk_Activity_startActivityForResult_206f42f0b65887e835d87ee52d14d221(activity, adActivityData.a(), 0);
            Unit unit = Unit.INSTANCE;
            this.f10343a.a(adActivityData);
            activity.finish();
            objM7904constructorimpl = Result.m7904constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            this.f10343a.a(thM7907exceptionOrNullimpl);
        }
    }

    public /* synthetic */ u0(lp1 lp1Var) {
        this(lp1Var, new v0(lp1Var));
    }

    public u0(lp1 reporter, v0 activityResultReporter) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(activityResultReporter, "activityResultReporter");
        this.f10343a = activityResultReporter;
    }
}
