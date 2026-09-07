package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ex0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ug f8839a;
    private final o3 b;
    private final mk0 c;
    private final fx0 d;
    private final a51 e;
    private final kx0 f;
    private final wv0 g;
    private final rx1 h;

    public ex0(ug assetValueProvider, o3 adConfiguration, mk0 impressionEventsObservable, fx0 fx0Var, a51 nativeAdControllers, kx0 mediaViewRenderController, hj2 controlsProvider, rx1 rx1Var) {
        Intrinsics.checkNotNullParameter(assetValueProvider, "assetValueProvider");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(controlsProvider, "controlsProvider");
        this.f8839a = assetValueProvider;
        this.b = adConfiguration;
        this.c = impressionEventsObservable;
        this.d = fx0Var;
        this.e = nativeAdControllers;
        this.f = mediaViewRenderController;
        this.g = controlsProvider;
        this.h = rx1Var;
    }

    public final dx0 a(CustomizableMediaView mediaView, pj0 imageProvider, j91 nativeMediaContent, p81 nativeForcePauseObserver) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        ax0 ax0VarA = this.f8839a.a();
        fx0 fx0Var = this.d;
        if (fx0Var != null) {
            return fx0Var.a(mediaView, this.b, imageProvider, this.g, this.c, nativeMediaContent, nativeForcePauseObserver, this.e, this.f, this.h, ax0VarA);
        }
        return null;
    }
}
