package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10843a;
    private final j1 b;
    private final int c;
    private final f30 d;
    private final mp e;
    private final x41 f;

    public final c30 a(Context context, o8 adResponse, m61 nativeAdPrivate, e1 adActivityEventController, wr contentCloseListener, k3 adCompleteListener, aw debugEventsReporter, i20 divKitActionHandlerDelegate, y42 timeProviderContainer, y20 y20Var, m6 m6Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        try {
            this.d.getClass();
            if (!f30.a(context) || y20Var == null) {
                return null;
            }
            return new c30(y20Var.b(), this.f10843a, new yq(new dq(adResponse, adActivityEventController, this.e, contentCloseListener, this.f, debugEventsReporter, timeProviderContainer), new xr(adResponse, adActivityEventController, adCompleteListener, nativeAdPrivate.b(), timeProviderContainer, y20Var), new oz1(m6Var, adActivityEventController, this.f, fz1.a(m6Var))), this.b, divKitActionHandlerDelegate, this.c);
        } catch (Throwable unused) {
            return null;
        }
    }

    public /* synthetic */ zp0(o3 o3Var, j1 j1Var, int i) {
        this(o3Var, j1Var, i, new f30(), new vh2(), new z41());
    }

    public zp0(o3 adConfiguration, j1 adActivityListener, int i, f30 divKitIntegrationValidator, mp closeAppearanceController, x41 nativeAdControlViewProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(divKitIntegrationValidator, "divKitIntegrationValidator");
        Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
        Intrinsics.checkNotNullParameter(nativeAdControlViewProvider, "nativeAdControlViewProvider");
        this.f10843a = adConfiguration;
        this.b = adActivityListener;
        this.c = i;
        this.d = divKitIntegrationValidator;
        this.e = closeAppearanceController;
        this.f = nativeAdControlViewProvider;
    }
}
