package io.bidmachine.iab.vast;

import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public interface VastPlaybackListener extends Serializable {
    void onVideoCompleted();

    void onVideoFirstQuartile();

    void onVideoMidpoint();

    void onVideoPaused();

    void onVideoResumed();

    void onVideoSkipped();

    void onVideoStarted(float durationMs, float volume);

    void onVideoThirdQuartile();

    void onVideoVolumeChanged(float volume);
}
