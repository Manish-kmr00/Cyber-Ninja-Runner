package com.smaato.sdk.video.vast.vastplayer;

/* JADX INFO: loaded from: classes13.dex */
public class SkipButtonVisibilityManagerImpl extends SkipButtonVisibilityManager {
    private final long durationMillis;
    private final boolean hasCompanionAd;
    private long lastUpdatedCountdownValue;
    private final long skipOffsetMillis;

    SkipButtonVisibilityManagerImpl(long j, long j2, boolean z) {
        this.skipOffsetMillis = Math.min(j, j2);
        this.durationMillis = j2;
        this.lastUpdatedCountdownValue = j2;
        this.hasCompanionAd = z;
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.SkipButtonVisibilityManager
    void onProgressChange(long j, VideoPlayerView videoPlayerView) {
        long j2 = this.skipOffsetMillis;
        if (j2 < 0) {
            return;
        }
        if (j >= j2 && j < this.durationMillis) {
            videoPlayerView.hideCountdownText();
            videoPlayerView.showSkipButton(this.hasCompanionAd);
        }
        if (j >= 0) {
            long j3 = this.skipOffsetMillis;
            if (j > j3 || j >= this.durationMillis) {
                return;
            }
            int iCeil = (int) Math.ceil((j3 - j) / 1000.0d);
            long j4 = iCeil;
            if (this.lastUpdatedCountdownValue > j4) {
                videoPlayerView.updateCountdownText(iCeil);
                this.lastUpdatedCountdownValue = j4;
            }
        }
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.SkipButtonVisibilityManager
    void onVideoComplete(VideoPlayerView videoPlayerView) {
        videoPlayerView.hideSkipButton();
        videoPlayerView.hideProgressBar();
        videoPlayerView.hideMuteButton();
        videoPlayerView.hideCountdownText();
    }
}
