package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes10.dex */
public final class nd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f9723a = new l10();

    public final md0 a(Context context, o8<String> adResponse, o3 adConfiguration) throws lj2 {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Context context2 = context.getApplicationContext();
        try {
            Intrinsics.checkNotNull(context2);
            md0 md0Var = new md0(context2, adResponse, adConfiguration);
            md0Var.setId(2);
            l10 l10Var = this.f9723a;
            float fR = adResponse.r();
            l10Var.getClass();
            Intrinsics.checkNotNullParameter(context2, "context");
            int iRoundToInt = MathKt.roundToInt(TypedValue.applyDimension(1, fR, context2.getResources().getDisplayMetrics()));
            l10 l10Var2 = this.f9723a;
            float fC = adResponse.c();
            l10Var2.getClass();
            Intrinsics.checkNotNullParameter(context2, "context");
            int iRoundToInt2 = MathKt.roundToInt(TypedValue.applyDimension(1, fC, context2.getResources().getDisplayMetrics()));
            if (iRoundToInt > 0 && iRoundToInt2 > 0) {
                md0Var.layout(0, 0, iRoundToInt, iRoundToInt2);
            }
            return md0Var;
        } catch (Throwable unused) {
            throw new lj2();
        }
    }
}
