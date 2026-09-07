package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdsLoader.EventListener f9781a;
    private AdPlaybackState b;

    public o5(AdsLoader.EventListener eventListener) {
        this.f9781a = eventListener;
        AdPlaybackState NONE = AdPlaybackState.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.b = NONE;
    }

    public final AdPlaybackState a() {
        return this.b;
    }

    public final void b() {
        this.f9781a = null;
        AdPlaybackState NONE = AdPlaybackState.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.b = NONE;
    }

    public final void a(AdsLoader.EventListener eventListener) {
        this.f9781a = eventListener;
    }

    public final void a(AdPlaybackState adPlaybackState) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        this.b = adPlaybackState;
        AdsLoader.EventListener eventListener = this.f9781a;
        if (eventListener != null) {
            eventListener.onAdPlaybackState(adPlaybackState);
        }
    }
}
