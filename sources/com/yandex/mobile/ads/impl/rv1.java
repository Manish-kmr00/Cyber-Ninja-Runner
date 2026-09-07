package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rv1 implements fx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10145a;
    private final jx0 b;
    private final gx0 c;
    private final ix0 d;
    private final hx0 e;

    public rv1(uu1 sdkEnvironmentModule, o8<?> adResponse, jx0 mediaViewAdapterWithVideoCreator, gx0 mediaViewAdapterWithImageCreator, ix0 mediaViewAdapterWithMultiBannerCreator, hx0 mediaViewAdapterWithMediaCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediaViewAdapterWithVideoCreator, "mediaViewAdapterWithVideoCreator");
        Intrinsics.checkNotNullParameter(mediaViewAdapterWithImageCreator, "mediaViewAdapterWithImageCreator");
        Intrinsics.checkNotNullParameter(mediaViewAdapterWithMultiBannerCreator, "mediaViewAdapterWithMultiBannerCreator");
        Intrinsics.checkNotNullParameter(mediaViewAdapterWithMediaCreator, "mediaViewAdapterWithMediaCreator");
        this.f10145a = adResponse;
        this.b = mediaViewAdapterWithVideoCreator;
        this.c = mediaViewAdapterWithImageCreator;
        this.d = mediaViewAdapterWithMultiBannerCreator;
        this.e = mediaViewAdapterWithMediaCreator;
    }

    private final dx0 a(CustomizableMediaView customizableMediaView, o3 o3Var, pj0 pj0Var, kx0 kx0Var, rx1 rx1Var, ax0 ax0Var) {
        List<uj0> listA = ax0Var.a();
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        if (listA.size() == 1) {
            return this.c.a(customizableMediaView, pj0Var, kx0Var);
        }
        try {
            return this.d.a(this.f10145a, o3Var, customizableMediaView, pj0Var, listA, kx0Var, rx1Var);
        } catch (Throwable unused) {
            return this.c.a(customizableMediaView, pj0Var, kx0Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fx0
    public final dx0 a(CustomizableMediaView mediaView, o3 adConfiguration, pj0 imageProvider, wv0 controlsProvider, mk0 impressionEventsObservable, j91 nativeMediaContent, p81 nativeForcePauseObserver, a51 nativeAdControllers, kx0 mediaViewRenderController, rx1 rx1Var, ax0 ax0Var) {
        dx0 dx0VarA;
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(controlsProvider, "controlsProvider");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        dx0 dx0VarA2 = null;
        dx0VarA2 = null;
        dx0VarA2 = null;
        dx0VarA2 = null;
        if (ax0Var == null) {
            return null;
        }
        za1 za1VarA = nativeMediaContent.a();
        ec1 ec1VarB = nativeMediaContent.b();
        su0 su0VarB = ax0Var.b();
        Context context = mediaView.getContext();
        Context context2 = mediaView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        boolean zA = u80.a(context2, t80.e);
        if (zA) {
            mediaView.removeAllViews();
        }
        if (za1VarA != null) {
            vv1 vv1VarA = this.b.a(mediaView, controlsProvider, adConfiguration, impressionEventsObservable, za1VarA, nativeForcePauseObserver, nativeAdControllers, mediaViewRenderController, imageProvider, rx1Var, ax0Var.c());
            yy1 yy1VarA = rx1Var != null ? rx1Var.a() : null;
            dx0VarA2 = (yy1VarA == null || !zA || (dx0VarA = a(mediaView, adConfiguration, imageProvider, mediaViewRenderController, rx1Var, ax0Var)) == null) ? vv1VarA : new wv1(mediaView, vv1VarA, dx0VarA, mediaViewRenderController, yy1VarA);
        } else if (ec1VarB != null && su0VarB != null) {
            Intrinsics.checkNotNull(context);
            if (oa.a(context)) {
                try {
                    dx0VarA2 = this.e.a(mediaView, su0VarB, impressionEventsObservable, ec1VarB, mediaViewRenderController);
                } catch (lj2 unused) {
                }
            }
        }
        return dx0VarA2 == null ? a(mediaView, adConfiguration, imageProvider, mediaViewRenderController, rx1Var, ax0Var) : dx0VarA2;
    }
}
