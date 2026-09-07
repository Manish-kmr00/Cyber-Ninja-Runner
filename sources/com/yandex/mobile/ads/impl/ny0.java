package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ny0 implements fx0 {
    @Override // com.yandex.mobile.ads.impl.fx0
    public final dx0 a(CustomizableMediaView mediaView, o3 adConfiguration, pj0 imageProvider, wv0 controlsProvider, mk0 impressionEventsObservable, j91 nativeMediaContent, p81 nativeForcePauseObserver, a51 nativeAdControllers, kx0 mediaViewRenderController, rx1 rx1Var, ax0 ax0Var) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(controlsProvider, "controlsProvider");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        mediaView.removeAllViews();
        return new my0(mediaView, mediaViewRenderController);
    }
}
