package com.smaato.sdk.video.vast.vastplayer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SkipButtonVisibilityManager {
    abstract void onProgressChange(long j, VideoPlayerView videoPlayerView);

    abstract void onVideoComplete(VideoPlayerView videoPlayerView);

    public static SkipButtonVisibilityManager create(VideoSettings videoSettings) {
        if (videoSettings == null) {
            return new NoOpSkipButtonVisibilityManager();
        }
        return videoSettings.isVideoSkippable ? new SkipButtonVisibilityManagerImpl(videoSettings.skipOffsetMillis, videoSettings.videoDurationMillis, videoSettings.hasCompanionAd) : new NoOpSkipButtonVisibilityManager();
    }

    private static class NoOpSkipButtonVisibilityManager extends SkipButtonVisibilityManager {
        @Override // com.smaato.sdk.video.vast.vastplayer.SkipButtonVisibilityManager
        public void onProgressChange(long j, VideoPlayerView videoPlayerView) {
        }

        private NoOpSkipButtonVisibilityManager() {
        }

        @Override // com.smaato.sdk.video.vast.vastplayer.SkipButtonVisibilityManager
        public void onVideoComplete(VideoPlayerView videoPlayerView) {
            videoPlayerView.hideMuteButton();
            videoPlayerView.hideProgressBar();
        }
    }
}
