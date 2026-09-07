package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8923a;
    private final j1 b;
    private final int c;
    private final f30 d;

    public /* synthetic */ fs1(o3 o3Var, j1 j1Var, int i) {
        this(o3Var, j1Var, i, new f30());
    }

    private static yq a(o8 o8Var, m61 m61Var, e1 e1Var, k3 k3Var, ds1 ds1Var, y42 y42Var, y20 y20Var, m6 m6Var) {
        h52 h52Var = new h52();
        z41 z41Var = new z41();
        j91 j91VarB = m61Var.b();
        return new yq(new es1(o8Var, e1Var, ds1Var, z41Var, j91VarB, y42Var, y20Var, new up()), new xr(o8Var, e1Var, k3Var, j91VarB, y42Var, y20Var), new ls1(e1Var, h52Var, j91VarB, y42Var), new oz1(m6Var, e1Var, z41Var, fz1.a(m6Var)));
    }

    public fs1(o3 adConfiguration, j1 adActivityListener, int i, f30 divKitIntegrationValidator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(divKitIntegrationValidator, "divKitIntegrationValidator");
        this.f8923a = adConfiguration;
        this.b = adActivityListener;
        this.c = i;
        this.d = divKitIntegrationValidator;
    }

    public final c30 a(Context context, o8 adResponse, m61 nativeAdPrivate, e1 adActivityEventController, k3 adCompleteListener, ds1 closeVerificationController, y42 timeProviderContainer, i20 divKitActionHandlerDelegate, y20 y20Var, m6 m6Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        try {
            this.d.getClass();
            if (!f30.a(context) || y20Var == null) {
                return null;
            }
            return new c30(y20Var.b(), this.f8923a, a(adResponse, nativeAdPrivate, adActivityEventController, adCompleteListener, closeVerificationController, timeProviderContainer, y20Var, m6Var), this.b, divKitActionHandlerDelegate, this.c);
        } catch (Throwable unused) {
            return null;
        }
    }
}
