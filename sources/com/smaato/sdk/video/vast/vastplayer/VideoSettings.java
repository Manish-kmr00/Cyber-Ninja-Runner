package com.smaato.sdk.video.vast.vastplayer;

import com.smaato.sdk.video.vast.model.VideoAdViewProperties;

/* JADX INFO: loaded from: classes13.dex */
public final class VideoSettings {
    public final int closeButtonSize;
    public final boolean hasCompanionAd;
    public final boolean isVideoClickable;
    public final boolean isVideoSkippable;
    public final boolean isVideoSoundOn;
    public final long skipOffsetMillis;
    public long videoDurationMillis;

    private VideoSettings(long j, long j2, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        this.videoDurationMillis = j;
        this.skipOffsetMillis = j2;
        this.isVideoSkippable = z;
        this.isVideoClickable = z2;
        this.isVideoSoundOn = z3;
        this.closeButtonSize = i;
        this.hasCompanionAd = z4;
    }

    public static VideoSettings create(long j, VideoAdViewProperties videoAdViewProperties) {
        return new VideoSettings(j, videoAdViewProperties.skipInterval(), videoAdViewProperties.isSkippable(), videoAdViewProperties.isClickable(), videoAdViewProperties.isSoundOn(), videoAdViewProperties.closeButtonSize(), videoAdViewProperties.hasCompanionAd());
    }

    void updateVideoDurationMillis(long j) {
        this.videoDurationMillis = j;
    }
}
