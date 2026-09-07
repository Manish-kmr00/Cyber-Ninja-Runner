package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.player.content.VideoPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kn2 implements ju {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoPlayer f9438a;

    public kn2(VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        this.f9438a = videoPlayer;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kn2) && Intrinsics.areEqual(this.f9438a, ((kn2) obj).f9438a);
    }

    public final int hashCode() {
        return this.f9438a.hashCode();
    }

    public final String toString() {
        return "YandexVideoPlayerAdapter(videoPlayer=" + this.f9438a + ")";
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void a(df2 df2Var) {
        this.f9438a.setVideoPlayerListener(df2Var != null ? new ln2(df2Var) : null);
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final float getVolume() {
        return this.f9438a.getVolume();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final long getVideoPosition() {
        return this.f9438a.getVideoPosition();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final long getVideoDuration() {
        return this.f9438a.getVideoDuration();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void prepareVideo() {
        this.f9438a.prepareVideo();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void pauseVideo() {
        this.f9438a.pauseVideo();
    }

    @Override // com.yandex.mobile.ads.impl.ju
    public final void resumeVideo() {
        this.f9438a.resumeVideo();
    }
}
