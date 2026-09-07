package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdsLoader.EventListener f9894a;
    private AdPlaybackState b;

    public p5(AdsLoader.EventListener eventListener) {
        this.f9894a = eventListener;
        AdPlaybackState NONE = AdPlaybackState.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.b = NONE;
    }

    public final AdPlaybackState a() {
        return this.b;
    }

    public final void b() {
        this.f9894a = null;
        AdPlaybackState NONE = AdPlaybackState.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.b = NONE;
    }

    public final void a(AdsLoader.EventListener eventListener) {
        this.f9894a = eventListener;
    }

    public final void a(AdPlaybackState adPlaybackState) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        this.b = adPlaybackState;
        AdsLoader.EventListener eventListener = this.f9894a;
        if (eventListener != null) {
            eventListener.onAdPlaybackState(adPlaybackState);
        }
    }
}
