package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class jg2 extends ng2<ub1, db2> {
    private final o8<?> c;
    private final hg2 d;
    private final mb1 e;
    private final gg2 f;
    private final ab1 g;
    private fg2 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg2(uu1 sdkEnvironmentModule, ub1 view, pe2 videoOptions, o3 adConfiguration, o8 adResponse, mk0 impressionEventsObservable, za1 nativeVideoPlaybackEventListener, p81 nativeForcePauseObserver, a51 nativeAdControllers, pj0 imageProvider, rx1 rx1Var, hg2 videoTrackerForceImpressionController) {
        super(view);
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeVideoPlaybackEventListener, "nativeVideoPlaybackEventListener");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(videoTrackerForceImpressionController, "videoTrackerForceImpressionController");
        this.c = adResponse;
        this.d = videoTrackerForceImpressionController;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.e = new mb1(context, this, videoOptions, adConfiguration, adResponse, impressionEventsObservable, nativeVideoPlaybackEventListener, nativeForcePauseObserver, imageProvider, rx1Var);
        this.f = new gg2(sdkEnvironmentModule.d());
        this.g = nativeAdControllers.a();
        impressionEventsObservable.a(videoTrackerForceImpressionController);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(View view) {
        ub1 view2 = (ub1) view;
        Intrinsics.checkNotNullParameter(view2, "view");
        this.e.a(view2);
        super.a(view2);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void b(View view, db2 db2Var) {
        ub1 view2 = (ub1) view;
        db2 video = db2Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(video, "video");
        rb2<gb1> rb2VarB = video.b();
        gg2 gg2Var = this.f;
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        fg2 fg2VarA = gg2Var.a(context, rb2VarB, sc2.e);
        this.h = fg2VarA;
        this.d.a(fg2VarA);
        ab1 ab1Var = this.g;
        Context context2 = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ab1Var.a(context2, rb2VarB, this.c);
        this.e.a(view2, video, fg2VarA);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a(ig asset, qg2 viewConfigurator, db2 db2Var) {
        db2 db2Var2 = db2Var;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(viewConfigurator, "viewConfigurator");
        ub1 ub1VarB = b();
        if (ub1VarB != null) {
            viewConfigurator.a(ub1VarB, asset);
            if (db2Var2 == null || this.h == null) {
                return;
            }
            rb2<gb1> rb2VarB = db2Var2.b();
            viewConfigurator.a((ig<?>) asset, new yd2(ub1VarB, rb2VarB.b()));
            this.e.a(ub1VarB, rb2VarB);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final void a() {
        fg2 fg2Var = this.h;
        if (fg2Var != null) {
            fg2Var.k();
        }
        this.d.a(null);
    }

    @Override // com.yandex.mobile.ads.impl.ng2
    public final boolean a(View view, db2 db2Var) {
        ub1 view2 = (ub1) view;
        db2 value = db2Var;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        return true;
    }
}
