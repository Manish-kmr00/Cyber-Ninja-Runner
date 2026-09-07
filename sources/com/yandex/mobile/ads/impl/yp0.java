package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10761a;
    private final e1 b;
    private final wr c;
    private final mp d;

    public yp0(o8<?> adResponse, e1 adActivityEventController, wr contentCloseListener, mp closeAppearanceController) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
        this.f10761a = adResponse;
        this.b = adActivityEventController;
        this.c = contentCloseListener;
        this.d = closeAppearanceController;
    }

    public final dq a(y41 nativeAdControlViewProvider, aw debugEventsReporter, y42 timeProviderContainer) {
        Intrinsics.checkNotNullParameter(nativeAdControlViewProvider, "nativeAdControlViewProvider");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        return new dq(this.f10761a, this.b, this.d, this.c, nativeAdControlViewProvider, debugEventsReporter, timeProviderContainer);
    }
}
