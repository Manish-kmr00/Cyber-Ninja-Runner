package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p81 f9621a;
    private final kb1 b;
    private final vd2 c;
    private final ra1 d;
    private jb1 e;
    private o81 f;

    public mb1(Context context, jg2 viewAdapter, pe2 videoOptions, o3 adConfiguration, o8 adResponse, me2 impressionTrackingListener, za1 nativeVideoPlaybackEventListener, p81 nativeForcePauseObserver, pj0 imageProvider, kb1 presenterCreator, vd2 aspectRatioProvider, ra1 nativeVideoAdPlayerProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        Intrinsics.checkNotNullParameter(nativeVideoPlaybackEventListener, "nativeVideoPlaybackEventListener");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(presenterCreator, "presenterCreator");
        Intrinsics.checkNotNullParameter(aspectRatioProvider, "aspectRatioProvider");
        Intrinsics.checkNotNullParameter(nativeVideoAdPlayerProvider, "nativeVideoAdPlayerProvider");
        this.f9621a = nativeForcePauseObserver;
        this.b = presenterCreator;
        this.c = aspectRatioProvider;
        this.d = nativeVideoAdPlayerProvider;
    }

    public final void a(ub1 videoView, rb2<gb1> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        gb1 gb1VarD = videoAdInfo.d();
        videoView.setAspectRatio(gb1VarD.getAdHeight() != 0 ? gb1VarD.getAdWidth() / gb1VarD.getAdHeight() : 1.7777778f);
        jb1 jb1Var = this.e;
        if (jb1Var != null) {
            jb1Var.a();
        }
    }

    public /* synthetic */ mb1(Context context, jg2 jg2Var, pe2 pe2Var, o3 o3Var, o8 o8Var, me2 me2Var, za1 za1Var, p81 p81Var, pj0 pj0Var, rx1 rx1Var) {
        kb1 kb1Var = new kb1(jg2Var, pe2Var, o3Var, o8Var, me2Var, za1Var, pj0Var, rx1Var);
        vd2 vd2Var = new vd2();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, jg2Var, pe2Var, o3Var, o8Var, me2Var, za1Var, p81Var, pj0Var, kb1Var, vd2Var, new ra1(applicationContext, o3Var, o8Var));
    }

    public final void a(ub1 videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        jb1 jb1Var = this.e;
        if (jb1Var != null) {
            jb1Var.b(videoView);
        }
        o81 o81Var = this.f;
        if (o81Var != null) {
            this.f9621a.b(o81Var);
            this.f = null;
        }
        videoView.setOnAttachStateChangeListener(null);
    }

    public final void a(ub1 videoView, db2 video, fg2 videoTracker) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        oa1 oa1VarA = this.d.a(video.b());
        Context context = videoView.getContext();
        kb1 kb1Var = this.b;
        Intrinsics.checkNotNull(context);
        jb1 jb1VarA = kb1Var.a(context, oa1VarA, video, videoTracker);
        this.e = jb1VarA;
        jb1VarA.a(videoView);
        o81 o81Var = new o81(oa1VarA);
        this.f = o81Var;
        this.f9621a.a(o81Var);
        videoView.setOnAttachStateChangeListener(new wa1(oa1VarA, videoView));
    }
}
