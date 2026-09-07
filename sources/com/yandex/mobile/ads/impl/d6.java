package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e4 f8666a;
    private final yn0 b;
    private final a5 c;
    private final p5 d;

    public d6(p9 adStateDataController, e4 adGroupIndexProvider, yn0 instreamSourceUrlProvider) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(adGroupIndexProvider, "adGroupIndexProvider");
        Intrinsics.checkNotNullParameter(instreamSourceUrlProvider, "instreamSourceUrlProvider");
        this.f8666a = adGroupIndexProvider;
        this.b = instreamSourceUrlProvider;
        this.c = adStateDataController.a();
        this.d = adStateDataController.c();
    }

    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        un0 mediaFile = videoAd.f();
        v4 v4Var = new v4(this.f8666a.a(mediaFile.a()), videoAd.b().a() - 1);
        this.c.a(v4Var, videoAd);
        AdPlaybackState adPlaybackStateA = this.d.a();
        if (adPlaybackStateA.isAdInErrorState(v4Var.a(), v4Var.b())) {
            return;
        }
        AdPlaybackState adPlaybackStateWithAdCount = adPlaybackStateA.withAdCount(v4Var.a(), videoAd.b().b());
        Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdCount, "withAdCount(...)");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        AdPlaybackState adPlaybackStateWithAdUri = adPlaybackStateWithAdCount.withAdUri(v4Var.a(), v4Var.b(), Uri.parse(mediaFile.getUrl()));
        Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdUri, "withAdUri(...)");
        this.d.a(adPlaybackStateWithAdUri);
    }
}
