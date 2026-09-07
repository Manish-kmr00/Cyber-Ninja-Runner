package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.video.playback.model.VideoAd;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class dm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<do0, VideoAd> f8713a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<VideoAd, do0> b = new ConcurrentHashMap<>();

    public final do0 a(VideoAd yandexVideoAd) {
        Intrinsics.checkNotNullParameter(yandexVideoAd, "yandexVideoAd");
        do0 do0Var = this.b.get(yandexVideoAd);
        if (do0Var == null) {
            dp0.a("Incorrect state exception. The VideoAd provided to this specific InstreamAdPlayerListener is incorrect.\nPossible reasons: \n 1) Using the wrong instance of InstreamAdPlayerListener for callback notification\n 2) Notifying a callback for a VideoAd that has been released", new Object[0]);
        }
        return do0Var;
    }

    public final void b(do0 coreVideoAd) {
        Intrinsics.checkNotNullParameter(coreVideoAd, "coreVideoAd");
        this.f8713a.remove(coreVideoAd);
    }

    public final VideoAd a(do0 coreVideoAd) {
        Intrinsics.checkNotNullParameter(coreVideoAd, "coreVideoAd");
        VideoAd videoAd = this.f8713a.get(coreVideoAd);
        if (videoAd != null) {
            return videoAd;
        }
        hn2 hn2Var = new hn2(coreVideoAd, new sb2());
        this.f8713a.put(coreVideoAd, hn2Var);
        this.b.put(hn2Var, coreVideoAd);
        return hn2Var;
    }

    public final void b(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.b.remove(videoAd);
    }
}
