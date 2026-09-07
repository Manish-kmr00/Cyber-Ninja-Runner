package io.bidmachine.media3.exoplayer;

import io.bidmachine.media3.common.PlaybackParameters;

/* JADX INFO: loaded from: classes11.dex */
public interface MediaClock {
    PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    default boolean hasSkippedSilenceSinceLastCall() {
        return false;
    }

    void setPlaybackParameters(PlaybackParameters playbackParameters);
}
