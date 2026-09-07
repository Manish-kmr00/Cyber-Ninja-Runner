package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ro implements t72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wm0 f10127a;
    private final f6 b;

    public ro(Context context, uu1 sdkEnvironmentModule, dt coreInstreamAdBreak, zn0 instreamVastAdPlayer, rb2 videoAdInfo, eg2 videoTracker, fb2 playbackListener, su creativeAssetsProvider, ko0 instreamVideoClicksProvider, zd2 videoClicks, wm0 clickListener, f6 adPlayerVolumeConfigurator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(creativeAssetsProvider, "creativeAssetsProvider");
        Intrinsics.checkNotNullParameter(instreamVideoClicksProvider, "instreamVideoClicksProvider");
        Intrinsics.checkNotNullParameter(videoClicks, "videoClicks");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(adPlayerVolumeConfigurator, "adPlayerVolumeConfigurator");
        this.f10127a = clickListener;
        this.b = adPlayerVolumeConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.t72
    public final void a(q70 instreamAdView, in0 controlsState) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        instreamAdView.setOnClickListener(this.f10127a);
        this.b.a(controlsState.a(), controlsState.d());
    }

    @Override // com.yandex.mobile.ads.impl.t72
    public final void a(q70 instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        instreamAdView.setOnClickListener(null);
        instreamAdView.setClickable(false);
    }
}
