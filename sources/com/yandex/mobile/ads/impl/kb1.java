package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f9403a;
    private final pe2 b;
    private final o3 c;
    private final o8<?> d;
    private final me2 e;
    private final fb1 f;
    private final pj0 g;
    private final rx1 h;

    public kb1(jg2 videoViewAdapter, pe2 videoOptions, o3 adConfiguration, o8 adResponse, me2 videoImpressionListener, za1 nativeVideoPlaybackEventListener, pj0 imageProvider, rx1 rx1Var) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(videoImpressionListener, "videoImpressionListener");
        Intrinsics.checkNotNullParameter(nativeVideoPlaybackEventListener, "nativeVideoPlaybackEventListener");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        this.f9403a = videoViewAdapter;
        this.b = videoOptions;
        this.c = adConfiguration;
        this.d = adResponse;
        this.e = videoImpressionListener;
        this.f = nativeVideoPlaybackEventListener;
        this.g = imageProvider;
        this.h = rx1Var;
    }

    public final jb1 a(Context context, oa1 videoAdPlayer, db2 video, fg2 videoTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        return new jb1(context, this.d, this.c, videoAdPlayer, video, this.b, this.f9403a, new mc2(this.c, this.d), videoTracker, this.e, this.f, this.g, this.h);
    }
}
