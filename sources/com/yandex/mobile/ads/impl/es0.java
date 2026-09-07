package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class es0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj1 f8825a;
    private final ge2 b;

    public es0(pj1 positionProviderHolder, ge2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        this.f8825a = positionProviderHolder;
        this.b = videoDurationHolder;
    }

    public final int a(AdPlaybackState adPlaybackState) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        ki1 ki1VarB = this.f8825a.b();
        if (ki1VarB == null) {
            return -1;
        }
        long jMsToUs = Util.msToUs(this.b.a());
        long jMsToUs2 = Util.msToUs(ki1VarB.a());
        int adGroupIndexForPositionUs = adPlaybackState.getAdGroupIndexForPositionUs(jMsToUs2, jMsToUs);
        return adGroupIndexForPositionUs == -1 ? adPlaybackState.getAdGroupIndexAfterPositionUs(jMsToUs2, jMsToUs) : adGroupIndexForPositionUs;
    }
}
