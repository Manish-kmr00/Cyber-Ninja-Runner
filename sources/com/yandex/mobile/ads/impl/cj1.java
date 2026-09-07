package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ye2 f8616a;
    private final z2 b;

    public cj1(ye2 videoPlayerController, z2 adBreakStatusController) {
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        this.f8616a = videoPlayerController;
        this.b = adBreakStatusController;
    }

    public final bj1 a(lm0 instreamAdPlaylist, dj1 listener) {
        Intrinsics.checkNotNullParameter(instreamAdPlaylist, "instreamAdPlaylist");
        Intrinsics.checkNotNullParameter(listener, "listener");
        jf2 jf2Var = new jf2(this.f8616a, new Handler(Looper.getMainLooper()));
        ht1 ht1Var = new ht1(instreamAdPlaylist);
        return new bj1(jf2Var, new rn1(ht1Var, this.b), new qn1(ht1Var, this.b), listener);
    }
}
