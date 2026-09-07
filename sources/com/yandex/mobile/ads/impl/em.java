package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class em {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8812a;
    private final dm b;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivity(p1);
    }

    public final boolean a(Context context, o8 adResponse, t8 adResultReceiver, o3 adConfiguration, String browserUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adResultReceiver, "adResultReceiver");
        Intrinsics.checkNotNullParameter(browserUrl, "browserUrl");
        int i = d1.d;
        d1 d1VarA = d1.a.a();
        long jA = ti0.a();
        Intent intentA = this.b.a(context, browserUrl, jA);
        d1VarA.a(jA, new c1(new c1.a(adResponse, adConfiguration, adResultReceiver)));
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
            return true;
        } catch (Exception e) {
            d1VarA.a(jA);
            String str = "Failed to show Browser. Exception: " + e;
            op0.b(new Object[0]);
            this.f8812a.reportError("Failed to show Browser", e);
            return false;
        }
    }

    public /* synthetic */ em(uu1 uu1Var) {
        this(uu1Var, uu1Var.c(), new dm(uu1Var.e()));
    }

    public em(uu1 sdkEnvironmentModule, lp1 reporter, dm intentCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(intentCreator, "intentCreator");
        this.f8812a = reporter;
        this.b = intentCreator;
    }
}
