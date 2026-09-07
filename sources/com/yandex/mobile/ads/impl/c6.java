package com.yandex.mobile.ads.impl;

import android.net.Uri;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d4 f8571a;
    private final yn0 b;
    private final z4 c;
    private final o5 d;

    public c6(o9 adStateDataController, d4 adGroupIndexProvider, yn0 instreamSourceUrlProvider) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(adGroupIndexProvider, "adGroupIndexProvider");
        Intrinsics.checkNotNullParameter(instreamSourceUrlProvider, "instreamSourceUrlProvider");
        this.f8571a = adGroupIndexProvider;
        this.b = instreamSourceUrlProvider;
        this.c = adStateDataController.a();
        this.d = adStateDataController.c();
    }

    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        un0 mediaFile = videoAd.f();
        u4 u4Var = new u4(this.f8571a.a(mediaFile.a()), videoAd.b().a() - 1);
        this.c.a(u4Var, videoAd);
        AdPlaybackState adPlaybackStateA = this.d.a();
        if (adPlaybackStateA.isAdInErrorState(u4Var.a(), u4Var.b())) {
            return;
        }
        AdPlaybackState adPlaybackStateWithAdCount = adPlaybackStateA.withAdCount(u4Var.a(), videoAd.b().b());
        Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdCount, "withAdCount(...)");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(mediaFile, "mediaFile");
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        AdPlaybackState adPlaybackStateWithAvailableAdMediaItem = adPlaybackStateWithAdCount.withAvailableAdMediaItem(u4Var.a(), u4Var.b(), MediaItem.fromUri(Uri.parse(mediaFile.getUrl())));
        Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAvailableAdMediaItem, "withAvailableAdMediaItem(...)");
        this.d.a(adPlaybackStateWithAvailableAdMediaItem);
    }
}
