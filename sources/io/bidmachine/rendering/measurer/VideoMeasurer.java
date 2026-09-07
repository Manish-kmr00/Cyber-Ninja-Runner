package io.bidmachine.rendering.measurer;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public interface VideoMeasurer extends Measurer<View> {
    void onMediaCompleted();

    void onMediaFirstQuartile();

    void onMediaMidpoint();

    void onMediaPaused();

    void onMediaResumed();

    void onMediaSkipped();

    void onMediaStarted(float durationMs, float volume);

    void onMediaThirdQuartile();

    void onMediaVolumeChanged(float volume);
}
