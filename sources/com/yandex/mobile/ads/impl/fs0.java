package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class fs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qj1 f8922a;
    private final he2 b;

    public fs0(qj1 positionProviderHolder, he2 videoDurationHolder) {
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        this.f8922a = positionProviderHolder;
        this.b = videoDurationHolder;
    }

    public final int a(AdPlaybackState adPlaybackState) {
        Intrinsics.checkNotNullParameter(adPlaybackState, "adPlaybackState");
        li1 li1VarB = this.f8922a.b();
        if (li1VarB == null) {
            return -1;
        }
        long jMsToUs = Util.msToUs(this.b.a());
        long jMsToUs2 = Util.msToUs(li1VarB.a());
        int adGroupIndexForPositionUs = adPlaybackState.getAdGroupIndexForPositionUs(jMsToUs2, jMsToUs);
        return adGroupIndexForPositionUs == -1 ? adPlaybackState.getAdGroupIndexAfterPositionUs(jMsToUs2, jMsToUs) : adGroupIndexForPositionUs;
    }
}
