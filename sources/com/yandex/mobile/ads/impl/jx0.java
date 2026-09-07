package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class jx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9359a;
    private final o8<?> b;
    private final zf2 c;
    private final lv d;
    private final ob1 e;
    private final db1 f;
    private final xb1 g;

    public final vv1 a(CustomizableMediaView mediaView, wv0 customControls, o3 adConfiguration, mk0 impressionEventsObservable, za1 listener, p81 nativeForcePauseObserver, a51 nativeAdControllers, kx0 mediaViewRenderController, pj0 imageProvider, rx1 rx1Var, db2 db2Var) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(customControls, "customControls");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Context context = mediaView.getContext();
        qf2 qf2VarA = this.e.a(mediaView);
        db1 db1Var = this.f;
        sf2 sf2VarD = db2Var != null ? db2Var.d() : null;
        db1Var.getClass();
        pe2 pe2Var = new pe2(qf2VarA, sf2VarD != null ? sf2VarD.b() : true, sf2VarD != null ? sf2VarD.c() : false, sf2VarD != null ? sf2VarD.a() : null);
        this.d.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        int videoControlsLayoutId = mediaView.getVideoControlsLayoutId();
        xb1 xb1Var = this.g;
        Intrinsics.checkNotNull(context);
        ub1 nativeVideoView = xb1Var.a(context, pe2Var, customControls, db2Var, videoControlsLayoutId);
        this.c.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        Context context2 = mediaView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (!u80.a(context2, t80.e)) {
            mediaView.removeAllViews();
        }
        mediaView.addView(nativeVideoView, new FrameLayout.LayoutParams(-1, -1));
        jg2 jg2Var = new jg2(this.f9359a, nativeVideoView, pe2Var, adConfiguration, this.b, impressionEventsObservable, listener, nativeForcePauseObserver, nativeAdControllers, imageProvider, rx1Var, new hg2());
        return new vv1(mediaView, jg2Var, mediaViewRenderController, new og2(jg2Var));
    }

    public /* synthetic */ jx0(uu1 uu1Var, o8 o8Var) {
        this(uu1Var, o8Var, new zf2(), new lv(), new ob1());
    }

    public jx0(uu1 sdkEnvironmentModule, o8<?> adResponse, zf2 videoSubViewBinder, lv customizableMediaViewManager, ob1 nativeVideoScaleTypeProvider) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(videoSubViewBinder, "videoSubViewBinder");
        Intrinsics.checkNotNullParameter(customizableMediaViewManager, "customizableMediaViewManager");
        Intrinsics.checkNotNullParameter(nativeVideoScaleTypeProvider, "nativeVideoScaleTypeProvider");
        this.f9359a = sdkEnvironmentModule;
        this.b = adResponse;
        this.c = videoSubViewBinder;
        this.d = customizableMediaViewManager;
        this.e = nativeVideoScaleTypeProvider;
        this.f = new db1();
        this.g = new xb1();
    }
}
